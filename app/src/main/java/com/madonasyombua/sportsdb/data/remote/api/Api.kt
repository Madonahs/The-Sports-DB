package com.madonasyombua.sportsdb.data.remote.api

import com.madonasyombua.sportsdb.data.remote.response.LeagueResponse
import com.madonasyombua.sportsdb.data.remote.response.MatchBaseResponse
import com.madonasyombua.sportsdb.data.remote.response.SportsBaseResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author madona
 * NOTE: The developer key does not include livescores, player lists or YouTube highlight links
 * Free users, can use the test API key "1" during development of your app or for educational use(see test links below).
 * https://www.thesportsdb.com/api.php
 * https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=Arsenal
 */
interface Api {
    @GET("searchteams.php")
    fun getAllTeams(@Query("t") team : String) : Single<SportsBaseResponse>

    @GET("eventslast.php")
    fun getAllLastEvents(@Query("id") teamId : String) : Single<MatchBaseResponse>

    @GET("all_leagues.php")
    fun getAllLeagues():Single<LeagueResponse>

}