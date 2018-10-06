package com.example.devayf.fottballmatchschedule.api

import java.net.URL

class ApiRepository {
    fun request(url: String): String{
        return URL(url).readText()
    }
}
