package com.sahambook.app.repository

import com.sahambook.app.entity.Saham
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface SahamRepository : JpaRepository<Saham, String>
