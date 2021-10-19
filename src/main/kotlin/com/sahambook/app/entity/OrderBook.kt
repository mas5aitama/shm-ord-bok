package com.sahambook.app.entity

import javax.persistence.*
import javax.validation.constraints.*


@Entity
@Table(name = "order_book")
data class OrderBook(
    @Id
    var id: Long? = null,

    @NotNull
    @Column(name = "bid_order", nullable = false)
    var bidOrder: Double? = null,

    @NotNull
    @Column(name = "bid_lot", nullable = false)
    var bidLot: Double? = null,

    @NotNull
    @Column(name = "bid_price", nullable = false)
    var bidPrice: Double? = null,

    @NotNull
    @Column(name = "offer_price", nullable = false)
    var offerPrice: Double? = null,

    @NotNull
    @Column(name = "offer_lot", nullable = false)
    var offerLot: Double? = null,

    @NotNull
    @Column(name = "offer_order", nullable = false)
    var offerOrder: Double? = null,
)

