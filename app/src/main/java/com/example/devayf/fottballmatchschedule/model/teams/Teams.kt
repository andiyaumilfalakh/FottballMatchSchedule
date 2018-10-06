package com.example.devayf.fottballmatchschedule.model.teams

import com.google.gson.annotations.SerializedName

data class Team (
        @SerializedName("strTeamBadge")
        var teamLogo: String? = null
)
