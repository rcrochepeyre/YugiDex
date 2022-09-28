package com.example.yugidex.dao

import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.BanlistInfo
import com.example.yugidex.pojos.Linkmarker

class BanlistDAO(context: Context) : DAO(DBHelper(context)) {

    fun find(id: Long) : BanlistInfo? {
        var banlistInfo: BanlistInfo? = null
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.BANLIST_INFO_TABLE} where ${DBHelper.BANLIST_INFO_ID} = ?",
            arrayOf(id.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            banlistInfo = BanlistInfo(
                cursor.getString(DBHelper.BANLIST_INFO_TCG_COLUMN_INDEX),
                cursor.getString(DBHelper.BANLIST_INFO_OCG_COLUMN_INDEX),
                cursor.getString(DBHelper.BANLIST_INFO_GOAT_COLUMN_INDEX)
            )
            banlistInfo.id = cursor.getLong(DBHelper.BANLIST_INFO_ID_COLUMN_INDEX)
        }

        close()
        return banlistInfo
    }
}