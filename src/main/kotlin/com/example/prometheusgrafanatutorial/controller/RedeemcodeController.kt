package com.example.prometheusgrafanatutorial.controller

import com.example.prometheusgrafanatutorial.entity.Redeemcode
import com.example.prometheusgrafanatutorial.repository.RedeemcodeRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.random.Random

@RestController
class RedeemcodeController(
    private val redeemcodeRepository: RedeemcodeRepository,
) {
    @PostMapping("/api/v1/redeemcode")
    fun generate() {
        redeemcodeRepository.save(Redeemcode(UUID.randomUUID().toString(), Random.nextLong(10000, 1000000)))
    }
}
