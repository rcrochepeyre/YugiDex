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

    constructor(context: Context?) : this(context, "YugiDex.db", null, 2)

    companion object {

        //      CARD TABLE PROPERTIES
        const val CARD_ID = "id"
        const val CARD_NAME = "name"
        const val CARD_TYPE = "type"
        const val CARD_DESCRIPTION = "description"
        const val CARD_ATK = "atk"
        const val CARD_DEF = "def"
        const val CARD_LEVEL = "level"
        const val CARD_RACE = "race"
        const val CARD_ATTRIBUTE = "attribute"
        const val CARD_ARCHETYPE = "archetype"
        const val CARD_SCALE = "scale"
        const val CARD_LINKVAL = "linkval"
        const val CARD_PRICE_ID = "price_id"
        const val CARD_BANLIST_INFO_ID = "banlist_info_id"

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

        //       LINKMARKERS TABLE PROPERTIES
        const val LINKMARKERS_ID = "id"
        const val LINKMARKERS_NAME = "name"

        //        CARD_SET TABLE PROPERTIES
        const val CARD_SET_ID = "id"
        const val CARD_SET_CARD_ID = "card_id"
        const val CARD_SET_SET_ID = "set_id"

        //        CARD_IMAGE TABLE PROPERTIES
        const val CARD_IMAGE_ID = "id"
        const val CARD_IMAGE_CARD_ID = "card_id"
        const val CARD_IMAGE_IMAGE_ID = "image_id"

        //        CARD_LINKMARKERS TABLE PROPERTIES
        const val CARD_LINKMARKERS_ID = "id"
        const val CARD_LINKMARKERS_CARD_ID = "card_id"
        const val CARD_LINKMARKERS_LINKMARKERS_ID = "linkmarkers_id"

        //      TABLES NAMES
        const val CARD_TABLE = "cards"
        const val SET_TABLE = "sets"
        const val IMAGE_TABLE = "images"
        const val PRICE_TABLE = "prices"
        const val BANLIST_INFO_TABLE = "banlist_infos"
        const val LINKMARKERS_TABLE = "linkmarkers"
        const val CARD_SET_TABLE = "card_sets"
        const val CARD_IMAGE_TABLE = "card_images"
        const val CARD_LINKMARKERS_TABLE = "card_linkmarkers"

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
        const val CARD_PRICE_ID_COLUMN_INDEX = 12
        const val CARD_BANLIST_INFO_ID_COLUMN_INDEX = 13

        //      SET TABLE COLUMN INDEX ATTRIBUTION
        const val SET_ID_COLUMN_INDEX = 0
        const val SET_NAME_COLUMN_INDEX = 1
        const val SET_CODE_COLUMN_INDEX = 2
        const val SET_RARITY_COLUMN_INDEX = 3
        const val SET_RARITY_CODE_COLUMN_INDEX = 4
        const val SET_PRICE_COLUMN_INDEX = 5

        //      IMAGE TABLE COLUMN INDEX ATTRIBUTION
        const val IMAGE_ID_COLUMN_INDEX = 0
        const val IMAGE_CARD_ID_COLUMN_INDEX = 1
        const val IMAGE_URL_COLUMN_INDEX = 2
        const val IMAGE_URL_SMALL_COLUMN_INDEX = 3

        //        PRICE TABLE COLUMN INDEX ATTRIBUTION
        const val PRICE_ID_COLUMN_INDEX = 0
        const val PRICE_CARDMARKET_COLUMN_INDEX = 1
        const val PRICE_TCGPLAYER_COLUMN_INDEX = 2
        const val PRICE_EBAY_COLUMN_INDEX = 3
        const val PRICE_AMAZON_COLUMN_INDEX = 4
        const val PRICE_COOLSTUFFINC_COLUMN_INDEX = 5

        //        BANLIST_INFO TABLE COLUMN INDEX ATTRIBUTION
        const val BANLIST_INFO_ID_COLUMN_INDEX = 0
        const val BANLIST_INFO_TCG_COLUMN_INDEX = 1
        const val BANLIST_INFO_OCG_COLUMN_INDEX = 2
        const val BANLIST_INFO_GOAT_COLUMN_INDEX = 3

        //        LINKMARKERS TABLE COLUMN INDEX ATTRIBUTION
        const val LINKMARKERS_ID_COLUMN_INDEX = 0
        const val LINKMARKERS_NAME_COLUMN_INDEX = 1

        //        CARD_SET TABLE COLUMN INDEX ATTRIBUTION
        const val CARD_SET_ID_COLUMN_INDEX = 0
        const val CARD_SET_CARD_ID_COLUMN_INDEX = 1
        const val CARD_SET_SET_ID_COLUMN_INDEX = 2

        //        CARD_IMAGE TABLE COLUMN INDEX ATTRIBUTION
        const val CARD_IMAGE_ID_COLUMN_INDEX = 0
        const val CARD_IMAGE_CARD_ID_COLUMN_INDEX = 1
        const val CARD_IMAGE_IMAGE_ID_COLUMN_INDEX = 2

        //        CARD_LINKMARKERS TABLE COLUMN INDEX ATTRIBUTION
        const val CARD_LINKMARKERS_ID_COLUMN_INDEX = 0
        const val CARD_LINKMARKERS_CARD_ID_COLUMN_INDEX = 1
        const val CARD_LINKMARKERS_LINKMARKERS_ID_COLUMN_INDEX = 2

    }

    private val CARD_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $CARD_TABLE (" +
            "$CARD_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$CARD_NAME TEXT," +
            "$CARD_TYPE TEXT," +
            "$CARD_DESCRIPTION TEXT," +
            "$CARD_ATK INTEGER," +
            "$CARD_DEF INTEGER," +
            "$CARD_LEVEL INTEGER," +
            "$CARD_RACE TEXT," +
            "$CARD_ATTRIBUTE TEXT," +
            "$CARD_ARCHETYPE TEXT," +
            "$CARD_SCALE INTEGER," +
            "$CARD_LINKVAL INTEGER," +
            "$CARD_PRICE_ID INTEGER," +
            "$CARD_BANLIST_INFO_ID INTEGER);"

    private val SET_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $SET_TABLE (" +
            "$SET_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$SET_NAME TEXT," +
            "$SET_CODE TEXT," +
            "$SET_RARITY TEXT," +
            "$SET_RARITY_CODE TEXT," +
            "$SET_PRICE TEXT);"

    private val IMAGE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $IMAGE_TABLE (" +
            "$IMAGE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$IMAGE_CARD_ID INTEGER," +
            "$IMAGE_URL TEXT," +
            "$IMAGE_URL_SMALL TEXT);"

    private val PRICE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $PRICE_TABLE (" +
            "$PRICE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$PRICE_CARDMARKET TEXT," +
            "$PRICE_TCGPLAYER TEXT," +
            "$PRICE_EBAY TEXT," +
            "$PRICE_AMAZON TEXT," +
            "$PRICE_COOLSTUFFINC TEXT);"

    private val BANLIST_INFO_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $BANLIST_INFO_TABLE (" +
            "$BANLIST_INFO_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$BANLIST_INFO_TCG TEXT," +
            "$BANLIST_INFO_OCG TEXT," +
            "$BANLIST_INFO_GOAT TEXT);"

    private val LINKMARKERS_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $LINKMARKERS_TABLE (" +
            "$LINKMARKERS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$LINKMARKERS_NAME TEXT);"

    private val CARD_SET_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $CARD_SET_TABLE (" +
            "$CARD_SET_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$CARD_SET_CARD_ID INTEGER," +
            "$CARD_SET_SET_ID INTEGER);"

    private val CARD_IMAGE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $CARD_IMAGE_TABLE (" +
            "$CARD_IMAGE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$CARD_IMAGE_CARD_ID INTEGER," +
            "$CARD_IMAGE_IMAGE_ID INTEGER);"

    private val CARD_LINKMARKERS_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS $CARD_LINKMARKERS_TABLE (" +
            "$CARD_LINKMARKERS_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "$CARD_LINKMARKERS_CARD_ID INTEGER," +
            "$CARD_LINKMARKERS_LINKMARKERS_ID INTEGER);"


    private val CARD_TABLE_DROP = "DROP TABLE IF EXISTS $CARD_TABLE"
    private val SET_TABLE_DROP = "DROP TABLE IF EXISTS $SET_TABLE"
    private val IMAGE_TABLE_DROP = "DROP TABLE IF EXISTS $IMAGE_TABLE"
    private val PRICE_TABLE_DROP = "DROP TABLE IF EXISTS $PRICE_TABLE"
    private val BANLIST_INFO_TABLE_DROP = "DROP TABLE IF EXISTS $BANLIST_INFO_TABLE"
    private val LINKMARKERS_TABLE_DROP = "DROP TABLE IF EXISTS $LINKMARKERS_TABLE"
    private val CARD_SET_TABLE_DROP = "DROP TABLE IF EXISTS $CARD_SET_TABLE"
    private val CARD_IMAGE_TABLE_DROP = "DROP TABLE IF EXISTS $CARD_IMAGE_TABLE"
    private val CARD_LINKMARKERS_TABLE_DROP = "DROP TABLE IF EXISTS $CARD_LINKMARKERS_TABLE"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CARD_TABLE_CREATE)
        db.execSQL(SET_TABLE_CREATE)
        db.execSQL(IMAGE_TABLE_CREATE)
        db.execSQL(PRICE_TABLE_CREATE)
        db.execSQL(BANLIST_INFO_TABLE_CREATE)
        db.execSQL(LINKMARKERS_TABLE_CREATE)
        db.execSQL(CARD_SET_TABLE_CREATE)
        db.execSQL(CARD_IMAGE_TABLE_CREATE)
        db.execSQL(CARD_LINKMARKERS_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(CARD_TABLE_DROP)
        db.execSQL(SET_TABLE_DROP)
        db.execSQL(IMAGE_TABLE_DROP)
        db.execSQL(PRICE_TABLE_DROP)
        db.execSQL(BANLIST_INFO_TABLE_DROP)
        db.execSQL(LINKMARKERS_TABLE_DROP)
        db.execSQL(CARD_SET_TABLE_DROP)
        db.execSQL(CARD_IMAGE_TABLE_DROP)
        db.execSQL(CARD_LINKMARKERS_TABLE_DROP)
        onCreate(db)
    }
}
