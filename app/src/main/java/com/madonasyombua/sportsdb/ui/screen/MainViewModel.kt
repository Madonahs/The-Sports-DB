package com.madonasyombua.sportsdb.ui.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.sportsdb.data.Repository
import com.madonasyombua.sportsdb.data.remote.model.League
import com.madonasyombua.sportsdb.data.remote.response.LeagueResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _leaguesLiveData = MutableLiveData<List<League>>()
   private val disposable = CompositeDisposable()
    val leaguesLiveData: LiveData<List<League>> = _leaguesLiveData

    init {
        fetchLeagues()
    }

    private fun fetchLeagues() {
            repository.getAllLeagues().doOnSubscribe {

            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<LeagueResponse> {
                    override fun onSubscribe(d: Disposable) {
                        disposable.add(d)
                    }

                    override fun onSuccess(response: LeagueResponse) {
                        _leaguesLiveData.postValue(response.leagues)
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

}