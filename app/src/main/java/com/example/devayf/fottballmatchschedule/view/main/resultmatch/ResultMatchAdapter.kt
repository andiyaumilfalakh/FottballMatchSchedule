package com.example.devayf.fottballmatchschedule.view.main.resultmatch

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.devayf.fottballmatchschedule.R
import com.example.devayf.fottballmatchschedule.model.match.Match

class ResultMatchAdapter (private val context: FragmentActivity?, private val matchs: List<Match>, private val listener: (Match) -> Unit)
    : RecyclerView.Adapter<ResultMatchAdapter.MatchViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun getItemCount(): Int {
        return matchs.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindMatchItem(matchs[position], listener)
    }

    class MatchViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val matchDate = view.findViewById<TextView>(R.id.tv_date)
        private val teamHome = view.findViewById<TextView>(R.id.tv_team)
        private val teamAway = view.findViewById<TextView>(R.id.tv_team2)
        private val scoreHome = view.findViewById<TextView>(R.id.tv_score)
        private val scoreAway = view.findViewById<TextView>(R.id.tv_score2)

        fun bindMatchItem (matchs: Match, listener: (Match) -> Unit){
            matchDate.text = matchs.matchDate
            teamHome.text = matchs.homeTeam
            teamAway.text = matchs.awayTeam
            scoreHome.text = matchs.homeScore
            scoreAway.text = matchs.awayScore
            itemView.setOnClickListener { listener(matchs) }
        }
    }
}
