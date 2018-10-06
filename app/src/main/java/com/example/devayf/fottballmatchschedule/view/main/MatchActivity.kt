package com.example.devayf.fottballmatchschedule.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.devayf.fottballmatchschedule.R
import com.example.devayf.fottballmatchschedule.R.id.*
import com.example.devayf.fottballmatchschedule.view.main.nextmatch.NextMatchFragment
import com.example.devayf.fottballmatchschedule.view.main.resultmatch.ResultMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MatchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMain.setOnNavigationItemSelectedListener { item ->
            when (item.itemId){
                item__result_match -> {
                    loadResultMatchFragment(savedInstanceState)
                }

                item__next_match -> {
                    loadNextMatchFragment(savedInstanceState)
                }
            }

            true
        }

        bottomNavigationMain.selectedItemId = item__result_match
    }

    private fun loadResultMatchFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_mainFrame, ResultMatchFragment(), ResultMatchFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadNextMatchFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_mainFrame, NextMatchFragment(), NextMatchFragment::class.java.simpleName)
                    .commit()
        }
    }

}