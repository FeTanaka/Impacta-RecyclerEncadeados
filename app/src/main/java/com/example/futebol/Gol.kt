package com.example.futebol

import kotlin.random.Random

data class Gol(
    val jogador: String,
    val tempo: Int = Random.nextInt(1, 90)
)
