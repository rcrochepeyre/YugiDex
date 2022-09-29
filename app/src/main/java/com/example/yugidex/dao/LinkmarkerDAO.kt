package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Linkmarker

class LinkmarkerDAO(context: Context) : DAO(DBHelper(context)) {

    fun add(linkmarker: Linkmarker) {
        open()

        val values = ContentValues()
        values.put(DBHelper.LINKMARKERS_NAME, linkmarker.name)

        val id = db.insert(DBHelper.LINKMARKERS_TABLE, null, values)
        linkmarker.id = id

        close()
    }

    fun addIfNotExist(linkmarker: Linkmarker) {
        open()

        val values = ContentValues()
        values.put(DBHelper.LINKMARKERS_NAME, linkmarker.name)

        val id = db.insertWithOnConflict(DBHelper.LINKMARKERS_TABLE, null, values,4)
        linkmarker.id = id

        close()
    }


    fun find(id: Long): Linkmarker? {
        var linkmarker: Linkmarker? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.LINKMARKERS_TABLE} where ${DBHelper.LINKMARKERS_ID} = ?",
            arrayOf(id.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            linkmarker = Linkmarker(
                cursor.getString(DBHelper.LINKMARKERS_NAME_COLUMN_INDEX)
            )
            linkmarker.id = cursor.getLong(DBHelper.LINKMARKERS_ID_COLUMN_INDEX)
        }

        close()
        return linkmarker
    }

    fun findByName(name: String): Linkmarker? {
        var linkmarker: Linkmarker? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.LINKMARKERS_TABLE} where ${DBHelper.LINKMARKERS_NAME} = ?",
            arrayOf(name)
        )

        if (cursor != null && cursor.moveToFirst()) {
            linkmarker = Linkmarker(
                cursor.getString(DBHelper.LINKMARKERS_NAME_COLUMN_INDEX)
            )
            linkmarker.id = cursor.getLong(DBHelper.LINKMARKERS_ID_COLUMN_INDEX)
        }

        close()
        return linkmarker
    }

    fun list(): ArrayList<Linkmarker> {
        val linkmarkers: ArrayList<Linkmarker> = ArrayList()
        open()
        val cursor = db.rawQuery("select * from ${DBHelper.LINKMARKERS_TABLE}", null)

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                val linkmarker = Linkmarker(
                    cursor.getString(DBHelper.LINKMARKERS_NAME_COLUMN_INDEX),
                )
                linkmarker.id = cursor.getLong(DBHelper.LINKMARKERS_ID_COLUMN_INDEX)
                linkmarkers.add(linkmarker)
                cursor.moveToNext()
            }
        }
        close()
        return linkmarkers
    }
}