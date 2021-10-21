package com.sahambook.app.controller


import com.sahambook.app.entity.User
import com.sahambook.app.repository.UserRepository
import com.sahambook.app.response.ResponseHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("api")
class UserController(
    private val userRepository: UserRepository
) {
    @PostMapping("/register")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<Any> {
        return try {
            val result = userRepository.save(user)
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse("Save! Succcess", HttpStatus.OK, result, countTbl)
        } catch (e: Exception) {
            val countTbl: Long = userRepository.count()
            ResponseHandler.generateResponse(e.message!!, HttpStatus.MULTI_STATUS, "Email Already Exist", countTbl)
        }
    }
}
