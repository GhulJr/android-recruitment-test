package dog.snow.androidrecruittest.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import dog.snow.androidrecruittest.data.model.raw.RawAddress

object Serializers {
    class RawAddressSerializer : JsonSerializer<RawAddress>() {
        override fun serialize(
            value: RawAddress?,
            gen: JsonGenerator?,
            serializers: SerializerProvider?
        ) {
            gen?.writeStartObject()
            gen?.writeStringField()
            gen?.writeEndObject()
        }

    }
}