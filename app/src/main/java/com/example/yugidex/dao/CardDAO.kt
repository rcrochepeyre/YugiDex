package com.example.yugidex.dao

import android.content.ContentValues
import android.content.Context
import com.example.yugidex.db.DBHelper
import com.example.yugidex.pojos.Card

class CardDAO : DAO {

    private var context: Context

    constructor(context: Context) : super(DBHelper(context)) {
        this.context = context
    }

    fun add(card: Card): Long {
        open()

        val linkmarkerDAO = LinkmarkerDAO(context)

        val values = ContentValues()
        values.put(DBHelper.CARD_NAME, card.name)
        values.put(DBHelper.CARD_TYPE, card.type)
        values.put(DBHelper.CARD_DESCRIPTION, card.desc)
        values.put(DBHelper.CARD_ATK, card.atk)
        values.put(DBHelper.CARD_DEF, card.def)
        values.put(DBHelper.CARD_LEVEL, card.level)
        values.put(DBHelper.CARD_RACE, card.race)
        values.put(DBHelper.CARD_ATTRIBUTE, card.attribute)
        values.put(DBHelper.CARD_ARCHETYPE, card.archetype)
        values.put(DBHelper.CARD_SCALE, card.scale)
        values.put(DBHelper.CARD_LINKVAL, card.linkval)
        values.put(DBHelper.CARD_PRICE_ID,card.prices!!.id)
        values.put(DBHelper.CARD_BANLIST_INFO_ID, card.banlists!!.id)

        val id = db.insert(DBHelper.CARD_TABLE, null, values)
        card.id = id

        val valuesCardLinkmarkers = ContentValues()
        for (linkmarker in card.linkmarkers!!) {
            val dbLinkmarker = linkmarkerDAO.findByName(linkmarker!!.name)
            valuesCardLinkmarkers.put(DBHelper.CARD_LINKMARKERS_CARD_ID,card.id)
            valuesCardLinkmarkers.put(DBHelper.CARD_LINKMARKERS_LINKMARKERS_ID,dbLinkmarker!!.id)
            db.insert(DBHelper.CARD_LINKMARKERS_TABLE,null,valuesCardLinkmarkers)
        }

        close()
        return id
    }

    fun find(id: Long): Card? {
        var card: Card? = null
        val banlistDAO = BanlistDAO(context)
        val priceDAO = PriceDAO(context)
        val cardLinkmarkersDAO = CardLinkmarkersDAO(context)
        open()
        val cursor = db.rawQuery(
            "select * from ${DBHelper.CARD_TABLE} where ${DBHelper.CARD_ID} = ?",
            arrayOf(id.toString())
        )

        if (cursor != null && cursor.moveToFirst()) {
            card = Card(
                cursor.getString(DBHelper.CARD_NAME_COLUMN_INDEX),
                cursor.getString(DBHelper.CARD_TYPE_COLUMN_INDEX),
                cursor.getString(DBHelper.CARD_DESC_COLUMN_INDEX),
                cursor.getInt(DBHelper.CARD_ATK_COLUMN_INDEX),
                cursor.getInt(DBHelper.CARD_DEF_COLUMN_INDEX),
                cursor.getInt(DBHelper.CARD_LEVEL_COLUMN_INDEX),
                cursor.getString(DBHelper.CARD_RACE_COLUMN_INDEX),
                cursor.getString(DBHelper.CARD_ATTRIBUTE_COLUMN_INDEX),
                cursor.getString(DBHelper.CARD_ARCHETYPE_COLUMN_INDEX),
                cursor.getInt(DBHelper.CARD_SCALE_COLUMN_INDEX),
                cursor.getInt(DBHelper.CARD_LINKVAL_COLUMN_INDEX),
                cardLinkmarkersDAO.find(cursor.getLong(DBHelper.CARD_ID_COLUMN_INDEX)),
                null,
                banlistDAO.find(cursor.getLong(DBHelper.CARD_BANLIST_INFO_ID_COLUMN_INDEX)),
                null,
                priceDAO.find(cursor.getLong(DBHelper.CARD_PRICE_ID_COLUMN_INDEX))
                )
            card.id = cursor.getLong(DBHelper.CARD_ID_COLUMN_INDEX)
        }

        close()
        return card
    }
}