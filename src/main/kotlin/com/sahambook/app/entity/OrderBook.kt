package com.sahambook.app.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.*


@Entity
@Table(name = "order_book")
data class OrderBook(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @NotNull
    var id: Long? = null,

    @NotNull
    @Column(name = "bid_offer", nullable = false)
    var bidOffer: Double? = null,

    @NotNull
    @Column(name = "lot_offer", nullable = false)
    var lotOffer: Double? = null,

    @NotNull 
    @Column(name = "offer_order", nullable = false)
    var offerOrder: Double? = null,

    @NotNull
    @Column(name = "bid_order", nullable = false)
    var bidOrder: Double? = null,

    @NotNull
    @Column(name = "bid_price", nullable = false)
    var bidPrice: Double? = null,

    @NotNull
    @Column(name = "lot_price", nullable = false)
    var lotPrice: Double? = null,
)

