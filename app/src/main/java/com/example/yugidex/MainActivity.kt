package com.example.yugidex

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.yugidex.dao.CardDAO
import com.example.yugidex.dao.LinkmarkerDAO
import com.example.yugidex.pojos.*

class MainActivity : AppCompatActivity() {

    private lateinit var cardDAO: CardDAO
    private lateinit var linkmarkerDAO: LinkmarkerDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardDAO = CardDAO(applicationContext)
        linkmarkerDAO = LinkmarkerDAO(applicationContext)
        val linkmarkers2 = linkmarkerDAO.list()
        fillLinkmarkersTable(applicationContext)
        val linkmarkers = ArrayList<Linkmarker?>()
        linkmarkers.add(Linkmarker("Bottom"))
        linkmarkers.add(Linkmarker("Top"))

        val cardsets = ArrayList<Cardset>()
        cardsets.add(Cardset("test", "test", "test", "test", "test"))

        val images = ArrayList<Image>()
        images.add(Image(1,"test","test"))
        val cardId = cardDAO.add(
            Card(
                "test",
                "test",
                "desc test",
                1000,
                1000,
                4,
                "test",
                "test",
                "test",
                3,
                3,
                linkmarkers,
                cardsets,
                BanlistInfo("null","null","null"),
                images,
                Price("null","null","null","null","null")
            )
        )
        val card: Card? = cardDAO.find(cardId)
        Log.d("card",card.toString())
    }

    fun fillLinkmarkersTable(context: Context) {
        val linkmarkersStrings: Array<String> = arrayOf("Top","Left","Right","Bottom","Top-Left","Top-Right","Bottom-Left","Bottom-Right")
        val linkmarkerDAO = LinkmarkerDAO(context)

        for (linkmarkerString in linkmarkersStrings) {
            linkmarkerDAO.add(Linkmarker(linkmarkerString))
        }
    }
}