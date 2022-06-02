package com.bookcafe.android.preemptivebookcafe

import java.time.LocalDateTime

data class UserResponse (
    val id : Long,
    val classNo : Long,
    val email : String,
    val createdAt : LocalDateTime,
    val updatedAt : LocalDateTime,
    val isDeleted : Boolean
)