package com.bookcafe.android.preemptivebookcafe

import java.time.LocalDateTime

data class Seats constructor(
    val id : Long,
    val user : UserResponse,
    val status : String,
    val leftOn : LocalDateTime,
    val registerAt : LocalDateTime,
    val updatedAt : LocalDateTime
)