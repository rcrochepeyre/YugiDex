package com.example.yugidex.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context,factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME,factory,DATABASE_VERSION) {

    companion object {
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "YugiDex"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val CARD_TABLE = "card_table"

        // below is the variable for id column
        val ID_COL = "id"

        // below is the variable for name column
        val NAME_COl = "name"

        // below is the variable for age column
        val AGE_COL = "age"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createCardTable = ("CREATE TABLE IF NOT EXISTS $CARD_TABLE ($ID_COL INTEGER PRIMARY KEY, $NAME_COl TEXT, $AGE_COL TEXT)")
        db.execSQL(createCardTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $CARD_TABLE")
        onCreate(db)
    }

    fun addCard() {
        val values = ContentValues()


    }
}