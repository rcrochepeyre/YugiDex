package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Cardset

class CardsetDAO(context: Context) : DAO(DBHelper(context)) {

    fun add(cardset: Cardset) {
        open()

        val values = ContentValues()
        values.put(DBHelper.SET_NAME,cardset.name)
        values.put(DBHelper.SET_CODE,cardset.code)
        values.put(DBHelper.SET_RARITY,cardset.rarity)
        values.put(DBHelper.SET_RARITY_CODE,cardset.rarity_code)
        values.put(DBHelper.SET_PRICE,cardset.price)

        val id = db.insert(DBHelper.SET_TABLE,null,values)
        cardset.id = id

        close()
    }
}