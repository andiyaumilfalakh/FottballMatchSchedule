package com.example.devayf.fottballmatchschedule.view.detailmatch

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ProgressBar
import com.example.devayf.fottballmatchschedule.api.ApiRepository
import com.example.devayf.fottballmatchschedule.model.match.Match
import com.example.devayf.fottballmatchschedule.model.teams.Team
import com.example.devayf.fottballmatchschedule.presenter.DetailPresenter
import com.example.devayf.fottballmatchschedule.view.main.favoriteteams.FavoriteTeams
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import com.example.devayf.fottballmatchschedule.R
import com.example.devayf.fottballmatchschedule.R.id.add_to_favorite
import com.example.devayf.fottballmatchschedule.R.menu.detail_menu
import com.example.devayf.fottballmatchschedule.database.database

class DetailActivity : AppCompatActivity(), DetailView {

    private lateinit var detailPresenter: DetailPresenter
    private lateinit var match: Match
    private lateinit var matchId: String
    private lateinit var homeId: String
    private lateinit var awayId: String
    val api = ApiRepository()
    val gson = Gson()
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Match Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        match = Match()

        matchId = intent.getStringExtra("matchId")
        homeId = intent.getStringExtra("homeId")
        awayId = intent.getStringExtra("awayId")

        detailPresenter = DetailPresenter(this, api, gson)
        detailPresenter.getMatchDetail(matchId, homeId, awayId)
    }

    override fun showLoading() {
        pb_detail.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pb_detail.visibility = ProgressBar.INVISIBLE
    }

    override fun showDetail(events: List<Match>, homeTeam: List<Team>, awayTeam: List<Team>) {
        match.matchId = events[0].matchId
        match.matchDate = events[0].matchDate
        match.homeId = events[0].homeId
        match.homeTeam = events[0].homeTeam
        match.homeScore = events[0].homeScore
        match.awayId = events[0].awayId
        match.awayTeam = events[0].awayTeam
        match.awayScore = events[0].awayScore

        tv_dateDetail.text = events[0].matchDate

        //home
        Picasso.get().load(homeTeam[0].teamLogo).into(iv_homeLogo)
        tv_homeName.text = events[0].homeTeam
        tv_homeScore.text = events[0].homeScore
        tv_homeFormation.text = events[0].homeFormation
        tv_homeGoals.text = events[0].homeGoalDetails
        tv_homeShots.text = events[0].homeShots
        tv_homeGoalKeeper.text = events[0].homeGoalKeeper
        tv_homeDefense.text = events[0].homeDefense
        tv_homeMidfield.text = events[0].homeMidfield
        tv_homeForward.text = events[0].homeForward

        //away
        Picasso.get().load(awayTeam[0].teamLogo).into(iv_awayLogo)
        tv_awayName.text = events[0].awayTeam
        tv_awayScore.text = events[0].awayScore
        tv_awayFormation.text = events[0].awayFormation
        tv_awayGoals.text = events[0].awayGoalDetails
        tv_awayShots.text = events[0].awayShots
        tv_awayGoalKeeper.text = events[0].awayGoalKeeper
        tv_awayDefense.text = events[0].awayDefense
        tv_awayMidfield.text = events[0].awayMidfield
        tv_awayForward.text = events[0].awayForward

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(detail_menu, menu)
        menuItem = menu
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            add_to_favorite -> {
//                addToFavorite()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

//    private fun addToFavorite(){
//        try{
//            database.use {
//                insert(FavoriteTeams.TABLE_FAVORITE,
//                        FavoriteTeams.TEAM_ID to teams.teamId,
//                        FavoriteTeams.TEAM_NAME to teams.teamName,
//                        FavoriteTeams.TEAM_BADGE to teams.teamBadge)
//            }
//            swipeRefresh.snackbar("Added to favorite").show()
//        } catch (e: SQLiteConstraintException){
//            swipeRefresh.snackbar(e.localizedMessage).show()
//    }
}