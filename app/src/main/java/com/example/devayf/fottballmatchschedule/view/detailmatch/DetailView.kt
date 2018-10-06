package com.example.devayf.fottballmatchschedule.view.detailmatch

import com.example.devayf.fottballmatchschedule.model.match.Match
import com.example.devayf.fottballmatchschedule.model.teams.Team

interface  DetailView {
    fun showLoading()
    fun hideLoading()
    fun showDetail(events: List<Match>, homeTeam: List<Team>, awayTeam: List<Team>)
}
