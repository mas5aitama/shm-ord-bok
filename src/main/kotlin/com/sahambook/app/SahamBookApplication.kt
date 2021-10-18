package com.sahambook.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SahamBookApplication

fun main(args: Array<String>) {
	runApplication<SahamBookApplication>(*args)
}
