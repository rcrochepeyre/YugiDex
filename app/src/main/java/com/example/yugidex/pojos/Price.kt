package com.example.yugidex.pojos

class Price(
    val cardmarket_price: String,
    val tcgplayer_price: String,
    val ebay_price: String,
    val amazon_price: String,
    val coolstuffinc_price: String
) {
    var id: Long = 0
}