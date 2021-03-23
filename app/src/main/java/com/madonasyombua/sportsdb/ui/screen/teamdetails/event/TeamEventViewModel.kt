package com.madonasyombua.sportsdb.ui.screen.teamdetails.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madonasyombua.sportsdb.data.Repository
import com.madonasyombua.sportsdb.data.remote.model.Event
import com.madonasyombua.sportsdb.data.remote.model.TeamByLeague
import com.madonasyombua.sportsdb.data.remote.response.EventResponse
import com.madonasyombua.sportsdb.data.remote.response.TeamsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TeamEventViewModel  @Inject constructor(private val repository: Repository):ViewModel(){

    private val _eventsViewModel = MutableLiveData<List<Event>>()
    private val _teamDetailLiveData = MutableLiveData<List<TeamByLeague>>()
    val eventsViewModel: LiveData<List<Event>>
    get() = _eventsViewModel

    val teamDetailsLiveData:LiveData<List<TeamByLeague>>
    get() = _teamDetailLiveData
    private val disposable = CompositeDisposable()


    fun getLastTeamEvents(teamId:String){
        repository.getTeamLastFiveEvents(teamId).doOnSubscribe {

        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe (object : Observer<EventResponse>{
                override fun onSubscribe(d: Disposable) {
                   disposable.add(d)
                }

                override fun onNext(t: EventResponse) {
                    _eventsViewModel.postValue(t.results)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }

                override fun onComplete() {
                }
            })
}

          fun getTeamDetails(teamId: String){
              repository.getTeamDetails(teamId).doOnSubscribe {

              }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                  .subscribe(object :SingleObserver<TeamsResponse>{
                      override fun onSubscribe(d: Disposable) {
                          disposable.add(d)
                      }

                      override fun onSuccess(t: TeamsResponse) {
                          _teamDetailLiveData.postValue(t.teams)
                      }

                      override fun onError(e: Throwable) {
                          Timber.e(e)
                      }
                  })
          }


}