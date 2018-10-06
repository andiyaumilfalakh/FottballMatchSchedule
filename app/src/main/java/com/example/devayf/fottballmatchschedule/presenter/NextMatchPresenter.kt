package com.example.devayf.fottballmatchschedule.presenter

import com.example.devayf.fottballmatchschedule.api.ApiRepository
import com.example.devayf.fottballmatchschedule.api.TheSportDBApi
import com.example.devayf.fottballmatchschedule.model.match.MatchResponse
import com.example.devayf.fottballmatchschedule.view.main.MatchView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter (private val view: MatchView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson)  {

    fun getMatchList(event: String, leagueId: String){
        view.showLoading()
        doAsync {
            val eventData = gson.fromJson(
                    apiRepository.request(TheSportDBApi.getEvent(event, leagueId)),
                    MatchResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showMatch(eventData.events)
            }
        }
    }
}
