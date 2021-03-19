package com.madonasyombua.sportsdb.ui.screen.home

import androidx.lifecycle.*
import com.madonasyombua.sportsdb.data.Repository
import com.madonasyombua.sportsdb.data.remote.model.League
import com.madonasyombua.sportsdb.data.remote.response.LeagueResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _leaguesLiveData = MutableLiveData<List<League>>()
    private val disposable = CompositeDisposable()

    private val _selectedLeagueLiveData = MutableLiveData<League?>(null)
    private val _state = MutableLiveData<LeagueViewState>()
    val state: LiveData<LeagueViewState>
        get() = _state

    init {
        fetchLeagues()
    }

    private fun fetchLeagues() {
        repository.getAllLeagues().doOnSubscribe {
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<LeagueResponse> {
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d) }
                override fun onSuccess(response: LeagueResponse) {
                    _leaguesLiveData.value = response.leagues
                    viewModelScope.launch {
                        combine(
                            _leaguesLiveData.asFlow().onEach {
                                    leagues -> if (leagues.isNotEmpty() && _selectedLeagueLiveData.value == null) {
                                    _selectedLeagueLiveData.value = leagues[0]
                            }
                            },
                            _selectedLeagueLiveData.asFlow()
                        ) { leagues, selectedLeague ->
                            LeagueViewState(leagues, selectedLeague)
                        }.collect { _state.value = it }
                    }
                }

                override fun onError(error: Throwable) {
                    Timber.e(error)
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun onLeagueSelected(league: League) {
        _selectedLeagueLiveData.value = league
    }

    data class LeagueViewState(
        val leagues: List<League> = emptyList(),
        val selectedLeague: League? = null
    )
}