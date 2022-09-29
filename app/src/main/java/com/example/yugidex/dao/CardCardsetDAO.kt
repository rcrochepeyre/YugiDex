package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Card
import com.example.yugidex.pojos.Cardset

class CardCardsetDAO : DAO {

    private var context: Context

    constructor(context: Context) : super(DBHelper(context)) {
        this.context = context
    }


    fun add(card: Card, cardset: Cardset) {
        open()

        val values = ContentValues()
        values.put(DBHelper.CARD_ID, card.id)
        values.put(DBHelper.SET_ID, cardset.id)

        val id = db.insert(DBHelper.CARD_LINKMARKERS_TABLE, null, values)

        close()
    }

    fun find(cardId: Long): ArrayList<Cardset?> {
        val cardsets: ArrayList<Cardset?> = ArrayList()
        val cardsetDAO = CardsetDAO(context)

        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.CARD_SET_TABLE} where ${DBHelper.CARD_SET_CARD_ID} = ?",
            arrayOf(cardId.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            while (!cursor.isAfterLast) {
                cardsets.add(cardsetDAO.find(cursor.getLong(DBHelper.CARD_SET_CARD_ID_COLUMN_INDEX)))
                cursor.moveToNext()
            }
        }
        close()
        return cardsets
    }
}