package com.example.prometheusgrafanatutorial

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.random.Random

class LoadGenerator {
    fun go() {
        while (true) {
            (1..1_000_000).map { UUID.randomUUID() }
            Thread.sleep(Random.nextLong(100, 1000))
        }
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
