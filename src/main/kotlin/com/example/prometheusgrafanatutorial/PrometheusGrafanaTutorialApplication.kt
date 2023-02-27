package com.example.prometheusgrafanatutorial

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class PrometheusGrafanaTutorialApplication

fun main(args: Array<String>) {
    runApplication<PrometheusGrafanaTutorialApplication>(*args)
    LoadGenerator().go()
}
