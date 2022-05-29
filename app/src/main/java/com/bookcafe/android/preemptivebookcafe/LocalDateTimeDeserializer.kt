package com.bookcafe.android.preemptivebookcafe

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

internal class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDateTime {
        return LocalDateTime.parse(
            json.asString,
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withLocale(Locale.ENGLISH)
        )
    }
}