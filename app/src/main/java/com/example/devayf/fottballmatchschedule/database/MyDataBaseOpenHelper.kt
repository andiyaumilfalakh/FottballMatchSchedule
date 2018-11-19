package com.example.devayf.fottballmatchschedule.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.devayf.fottballmatchschedule.view.main.favoriteteams.FavoriteTeams
import org.jetbrains.anko.db.*

class MyDataBaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1){
    companion object {
        private var instace: MyDataBaseOpenHelper? = null

        @Synchronized
        fun getInstace(ctx: Context): MyDataBaseOpenHelper {
            if (instace == null) {
                instace = MyDataBaseOpenHelper(ctx.applicationContext)
            }
            return instace as MyDataBaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(FavoriteTeams.TABLE_FAVORITE, true,
                FavoriteTeams.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteTeams.TEAM_ID to TEXT + UNIQUE,
                FavoriteTeams.TEAM_NAME to TEXT,
                FavoriteTeams.TEAM_BADGE to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(FavoriteTeams.TABLE_FAVORITE, true)
    }
}

val Context.database: MyDataBaseOpenHelper
    get() = MyDataBaseOpenHelper.getInstace(applicationContext)