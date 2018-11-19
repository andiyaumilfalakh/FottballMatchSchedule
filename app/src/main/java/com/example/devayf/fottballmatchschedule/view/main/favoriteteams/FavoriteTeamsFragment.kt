package com.example.devayf.fottballmatchschedule.view.main.favoriteteams


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devayf.fottballmatchschedule.R

class FavoriteTeamsFragment: Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_teams, container, false)
    }
}
