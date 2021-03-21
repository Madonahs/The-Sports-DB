package com.madonasyombua.sportsdb.ui.screen.home.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madonasyombua.sportsdb.data.Repository
import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import com.madonasyombua.sportsdb.data.remote.response.TeamsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Loveth Nwokike
 * on 3/20/2021
 * */
@HiltViewModel
class TeamsViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    private val _teamsLiveData = MutableLiveData<List<TeamByLeague>>()
    val teamsLiveData:LiveData<List<TeamByLeague>>
        get() = _teamsLiveData

    private val disposable = CompositeDisposable()

    fun getTeamsByLeague(league:String){
        repository.getAllTeamsByLeague(league = league)
            .doOnSubscribe {  }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<TeamsResponse>{
                override fun onSubscribe(d: Disposable) {
                    disposable.add(d)
                }

                override fun onSuccess(response: TeamsResponse) {
                    _teamsLiveData.postValue(response.teams)
                }

                override fun onError(error: Throwable) {
                    Timber.e(error)
                }

            })
    }
}