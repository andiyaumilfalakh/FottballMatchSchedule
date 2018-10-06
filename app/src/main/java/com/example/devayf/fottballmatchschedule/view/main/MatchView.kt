package com.example.devayf.fottballmatchschedule.view.main

import com.example.devayf.fottballmatchschedule.model.match.Match

interface MatchView {
    fun showLoading()
    fun hideLoading()
    fun showMatch(matchList: List<Match>)
}
