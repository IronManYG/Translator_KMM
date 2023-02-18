package com.ironmanyg.translator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform