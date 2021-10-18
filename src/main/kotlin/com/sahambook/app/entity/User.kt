package com.sahambook.app.entity

import org.hibernate.annotations.GenericGenerator
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
//import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "\"user\"")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    var id: Int = 0

    @Column(unique = true)
    var email = ""

    @Column
    var password = ""
        //@JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder =  Argon2PasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return Argon2PasswordEncoder().matches(password, this.password)
    }
}