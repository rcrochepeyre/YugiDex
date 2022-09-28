package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Image

class ImageDAO(context: Context) : DAO(DBHelper(context)) {

    fun add(image: Image) {
        open()

        val values = ContentValues()
        values.put(DBHelper.IMAGE_CARD_ID,image.cardId)
        values.put(DBHelper.IMAGE_URL,image.url)
        values.put(DBHelper.IMAGE_URL_SMALL,image.url_small)


        val id = db.insert(DBHelper.IMAGE_TABLE,null,values)
        image.id = id

        close()
    }
}