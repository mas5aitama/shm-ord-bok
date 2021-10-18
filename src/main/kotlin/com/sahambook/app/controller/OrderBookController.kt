package com.sahambook.app.controller

import com.sahambook.app.entity.OrderBook
import com.sahambook.app.repository.OrderBookRepository
import com.sahambook.app.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = arrayOf("http://localhost:8080"))
class OrderBookController
    (
    private val orderBookRepository: OrderBookRepository
) {

    @GetMapping(value = ["/order-book"])
    fun Get(): ResponseEntity<Any> {
        return try {
            val result: List<OrderBook> = orderBookRepository.findAll()
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result, countTbl)

        } catch (e: Exception) {
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Dont Have Data", countTbl)
        }
    }

    @GetMapping(value = ["/order-book/{id}"])
    fun Get(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val result: Optional<OrderBook> = orderBookRepository.findById(id)
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "cant found, your ID", countTbl)
        }
    }

    @PostMapping("/order-book")
    fun createOrderBook(@Valid @RequestBody orderBook: OrderBook): ResponseEntity<Any> {
        return try {
            val result = orderBookRepository.save(orderBook)
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Not Found Your ID", countTbl)
        }
    }

    @DeleteMapping("/order-book/{id}")
    fun Delete(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val result = orderBookRepository.deleteById(id)
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse("Deleted! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Not Found Your ID", countTbl)
        }
    }

    @PutMapping("/order-book/{id}")
    fun updateOrderBook(
        @PathVariable(value = "id", required = false) id: Int, @Valid @RequestBody orderBook: OrderBook
    ):ResponseEntity<Any> {
        return try {
            val result = orderBookRepository.save(orderBook)
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse("Updated", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = orderBookRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Updated Failed", countTbl)
        }
    }
}