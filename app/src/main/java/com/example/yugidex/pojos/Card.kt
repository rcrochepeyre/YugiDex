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
    val linkmarkers: Array<String>,
    val sets: Array<Set>,
    val banlists: BanlistInfo,
    val images: Array<Image>,
    val prices: Array<Price>
) {
    val id: Long = 0
}