package com.example.yugidex.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    constructor(context: Context?) : this(context, "YugiDex.db", null, 1)

    companion object {

        //      CARD TABLE PROPERTIES
        const val CARD_ID = "id"
        const val CARD_CARD_ID = "card_id"
        const val CARD_NAME = "name"
        const val CARD_TYPE = "type"
        const val CARD_DESC = "desc"
        const val CARD_ATK = "atk"
        const val CARD_DEF = "def"
        const val CARD_LEVEL = "level"
        const val CARD_RACE = "race"
        const val CARD_ATTRIBUTE = "attribute"
        const val CARD_ARCHETYPE = "archetype"
        const val CARD_SCALE = "scale"
        const val CARD_LINKVAL = "linkval"
        const val CARD_LINKMARKERS = "linkmarkers"

        //      SET TABLE PROPERTIES
        const val SET_ID = "id"
        const val SET_NAME = "name"
        const val SET_CODE = "code"
        const val SET_RARITY = "rarity"
        const val SET_RARITY_CODE = "rarity_code"
        const val SET_PRICE = "price"

        //      IMAGE TABLE PROPERTIES
        const val IMAGE_ID = "id"
        const val IMAGE_CARD_ID = "card_id"
        const val IMAGE_URL = "url"
        const val IMAGE_URL_SMALL = "url_small"

        //      PRICE TABLE PROPERTIES
        const val PRICE_ID = "id"
        const val PRICE_CARDMARKET = "cardmarket"
        const val PRICE_TCGPLAYER = "tcgplayer"
        const val PRICE_EBAY = "ebay"
        const val PRICE_AMAZON = "amazon"
        const val PRICE_COOLSTUFFINC = "coolstuffinc"

        //      BANLIST_INFO TABLE PROPERTIES
        const val BANLIST_INFO_ID = "id"
        const val BANLIST_INFO_TCG = "tcg"
        const val BANLIST_INFO_OCG = "ocg"
        const val BANLIST_INFO_GOAT = "goat"

        //      TABLES NAMES
        const val CARD_TABLE = "cards"
        const val SET_TABLE = "sets"
        const val IMAGE_TABLE = "images"
        const val PRICE_TABLE = "tables"
        const val BANLIST_INFO_TABLE = "banlist_infos"

        //      CARD TABLE COLUMN INDEX ATTRIBUTION
        const val CARD_ID_COLUMN_INDEX = 0
        const val CARD_NAME_COLUMN_INDEX = 1
        const val CARD_TYPE_COLUMN_INDEX = 2
        const val CARD_DESC_COLUMN_INDEX = 3
        const val CARD_ATK_COLUMN_INDEX = 4
        const val CARD_DEF_COLUMN_INDEX = 5
        const val CARD_LEVEL_COLUMN_INDEX = 6
        const val CARD_RACE_COLUMN_INDEX = 7
        const val CARD_ATTRIBUTE_COLUMN_INDEX = 8
        const val CARD_ARCHETYPE_COLUMN_INDEX = 9
        const val CARD_SCALE_COLUMN_INDEX = 10
        const val CARD_LINKVAL_COLUMN_INDEX = 11
        const val CARD_LINKMARKERS_COLUMN_INDEX = 12

        //      SET TABLE COLUMN INDEX ATTRIBUTION
        const val SET_ID_COLUMN_INDEX = 1
        const val SET_NAME_COLUMN_INDEX = 2
        const val SET_CODE_COLUMN_INDEX = 3
        const val SET_RARITY_COLUMN_INDEX = 4
        const val SET_RARITY_CODE_COLUMN_INDEX = 5
        const val SET_PRICE_COLUMN_INDEX = 6
    }

    private val CARD_TABLE_CREATE = "CREATE TABLE $CARD_TABLE (" +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " TEXT, " +
            " TEXT, " +
            " TEXT, " +
            " TEXT," +
            " TEXT," +
            " TEXT," +
            " TEXT," +
            " INTEGER);"

    private val CARD_TABLE_DROP = "DROP TABLE IF EXISTS $CARD_TABLE"

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(CARD_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(CARD_TABLE_DROP)
        onCreate(db)
    }
}
