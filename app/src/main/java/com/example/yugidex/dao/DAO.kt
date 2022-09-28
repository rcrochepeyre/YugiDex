package com.example.yugidex.dao

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DAO(baseHelper: SQLiteOpenHelper) {
    protected lateinit var db: SQLiteDatabase
    protected lateinit var baseHelper: SQLiteOpenHelper

    init {
        this.baseHelper = baseHelper
    }

    fun open(): SQLiteDatabase {
        db = baseHelper.writableDatabase
        return db
    }

    fun close() {
        db.close()
    }
}