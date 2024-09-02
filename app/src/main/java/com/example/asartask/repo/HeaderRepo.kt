package com.example.asartask.repo

import com.example.asartask.model.Header


class HeaderRepo {

    // Simulate a data source (e.g., API or local database)
    fun getHeaders(): List<Header> {
        return listOf(
            Header("Bitcoin", "$5438", "+0.23", "https://w7.pngwing.com/pngs/72/663/png-transparent-bitcoin-gold-cryptocurrency-bitcoin-medal-material-metal-thumbnail.png"),
            Header("IPL", "2024", "", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png"),
            Header("Ethereum", "$1438", "+0.50", "https://icon2.cleanpng.com/20190430/awq/kisspng-ethereum-classic-scalable-vector-graphics-logo-cry-why-it-would-be-in-everybodys-interests-to-regu-5cc7e00b7ec3f4.7413382115566028915192.jpg"),
        )
    }
}
