package com.sahambook.app.entity


import javax.persistence.*
import javax.validation.constraints.*

/**
 * A Saham.
 */
@Entity
@Table(name = "saham")
data class Saham(
    @Id
    @NotNull
    @Column(name = "kode_saham", nullable = false)
    var kodeSaham: String? = null,

    @NotNull
    @Column(name = "nama_saham", nullable = false)
    var namaSaham: String? = null,

    @NotNull
    @Column(name = "harga_terakhir", nullable = false)
    var hargaTerakhir: Double? = null,

    @NotNull
    @Column(name = "change", nullable = false)
    var changes: Double? = null,

    @NotNull
    @Column(name = "change_persen", nullable = false)
    var changePersen: Double? = null,

    @NotNull
    @Column(name = "price_close", nullable = false)
    var priceClose: Double? = null,

    @NotNull
    @Column(name = "price_open", nullable = false)
    var priceOpen: Double? = null,

    @NotNull
    @Column(name = "price_high", nullable = false)
    var priceHigh: Double? = null,

    @NotNull
    @Column(name = "price_low", nullable = false)
    var priceLow: Double? = null,

    @NotNull
    @Column(name = "foreign_sale", nullable = false)
    var foreignSale: Double? = null,

    @NotNull
    @Column(name = "domestic_buy", nullable = false)
    var domesticBuy: Double? = null,

    @OneToMany(cascade = arrayOf(CascadeType.ALL),orphanRemoval = true)
    @JoinColumn(name = "kode_saham")
    val orderbook: List<OrderBook>?  = ArrayList<OrderBook>()

)
