package com.example.devayf.fottballmatchschedule.api

import android.net.Uri
import com.example.devayf.fottballmatchschedule.BuildConfig

object TheSportDBApi {
    fun getEvent(event: String?, leagueId: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath(event)
                .appendQueryParameter("id", leagueId)
                .toString()
    }

    fun getEventDetails(eventId: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("lookupevent.php")
                .appendQueryParameter("id", eventId)
                .toString()
    }

    fun getTeam(teamId: String?): String{
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.API_KEY)
                .appendPath("lookupteam.php")
                .appendQueryParameter("id", teamId)
                .toString()
    }
}
