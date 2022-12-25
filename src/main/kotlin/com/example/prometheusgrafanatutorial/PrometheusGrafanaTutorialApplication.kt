package com.example.prometheusgrafanatutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PrometheusGrafanaTutorialApplication

fun main(args: Array<String>) {
    runApplication<PrometheusGrafanaTutorialApplication>(*args)
    LoadGenerator().go()
}
