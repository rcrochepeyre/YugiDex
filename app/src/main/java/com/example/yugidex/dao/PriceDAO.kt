package com.example.yugidex.dao

import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Price

class PriceDAO(context: Context) : DAO(DBHelper(context)) {

    fun find(id: Long): Price? {
        var price: Price? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.PRICE_TABLE} where ${DBHelper.PRICE_ID} = ?",
            arrayOf(id.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            price = Price(
                cursor.getString(DBHelper.PRICE_CARDMARKET_COLUMN_INDEX),
                cursor.getString(DBHelper.PRICE_TCGPLAYER_COLUMN_INDEX),
                cursor.getString(DBHelper.PRICE_EBAY_COLUMN_INDEX),
                cursor.getString(DBHelper.PRICE_AMAZON_COLUMN_INDEX),
                cursor.getString(DBHelper.PRICE_COOLSTUFFINC_COLUMN_INDEX)
            )
            price.id = cursor.getLong(DBHelper.PRICE_ID_COLUMN_INDEX)
        }

        close()
        return price
    }
}