package com.example.yugidex.pojos

class Card(
    val name: String,
    val type: String,
    val desc: String,
    val atk: Int,
    val def: Int,
    val level: Int,
    val race: String,
    val attribute: String,
    val archetype: String,
    val scale: Int,
    val linkval: Int,
    val linkmarkers: ArrayList<Linkmarker>?,
    val cardsets: ArrayList<Cardset>?,
    val banlists: BanlistInfo?,
    val images: ArrayList<Image>?,
    val prices: Price?
) {
    var id: Long = 0
}