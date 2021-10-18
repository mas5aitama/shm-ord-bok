package com.sahambook.app.repository


import com.sahambook.app.entity.OrderBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Suppress("unused")
@Repository
interface OrderBookRepository : JpaRepository<OrderBook, Long>
