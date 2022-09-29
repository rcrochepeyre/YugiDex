package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Card
import com.example.yugidex.pojos.Linkmarker

class CardLinkmarkersDAO : DAO {

    private var context: Context

    constructor(context: Context) : super(DBHelper(context)) {
        this.context = context
    }


    fun add(card: Card, linkmarker: Linkmarker) {
        open()

        val values = ContentValues()
        values.put(DBHelper.CARD_ID, card.id)
        values.put(DBHelper.LINKMARKERS_ID, linkmarker.id)

        val id = db.insert(DBHelper.CARD_LINKMARKERS_TABLE, null, values)

        close()
    }

    fun find(cardId: Long): ArrayList<Linkmarker?> {
        var linkmarkers: ArrayList<Linkmarker?> = ArrayList<Linkmarker?>()
        val linkmarkerDAO = LinkmarkerDAO(context)

        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.CARD_LINKMARKERS_TABLE} where ${DBHelper.CARD_LINKMARKERS_CARD_ID} = ?",
            arrayOf(cardId.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                linkmarkers.add(linkmarkerDAO.find(cursor.getLong(DBHelper.CARD_LINKMARKERS_CARD_ID_COLUMN_INDEX)))
                cursor.moveToNext()
            }
        }
        close()
        return linkmarkers
    }
}