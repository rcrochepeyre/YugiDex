package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Cardset

class CardsetDAO(context: Context) : DAO(DBHelper(context)) {

    fun add(cardset: Cardset) : Long {
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
        return id
    }

    fun find(id: Long): Cardset? {
        var cardset: Cardset? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.SET_TABLE} where ${DBHelper.SET_ID} = ?",
            arrayOf(id.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            cardset = Cardset(
                cursor.getString(DBHelper.SET_NAME_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_CODE_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_RARITY_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_RARITY_CODE_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_PRICE_COLUMN_INDEX)
            )
            cardset.id = cursor.getLong(DBHelper.SET_ID_COLUMN_INDEX)
        }

        close()
        return cardset
    }

    fun findByName(name: String): Cardset? {
        var cardset: Cardset? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.SET_TABLE} where ${DBHelper.SET_NAME} = ?",
            arrayOf(name)
        )

        if (cursor != null && cursor.moveToFirst()) {
            cardset = Cardset(
                cursor.getString(DBHelper.SET_NAME_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_CODE_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_RARITY_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_RARITY_CODE_COLUMN_INDEX),
                cursor.getString(DBHelper.SET_PRICE_COLUMN_INDEX)
            )
            cardset.id = cursor.getLong(DBHelper.SET_ID_COLUMN_INDEX)
        }

        close()
        return cardset
    }

}