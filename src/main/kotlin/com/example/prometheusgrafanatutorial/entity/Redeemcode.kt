package com.example.prometheusgrafanatutorial.entity

import javax.persistence.Entity

@Entity
class Redeemcode(
    val code: String,
    val amount: Long,
) : BaseEntity()
