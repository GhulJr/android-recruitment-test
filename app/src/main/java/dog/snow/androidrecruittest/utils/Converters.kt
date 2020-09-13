package dog.snow.androidrecruittest.utils

import com.fasterxml.jackson.databind.ObjectMapper
import dog.snow.androidrecruittest.data.model.address.*
import dog.snow.androidrecruittest.data.model.common.Name
import dog.snow.androidrecruittest.data.model.common.Title
import dog.snow.androidrecruittest.data.model.common.UId
import dog.snow.androidrecruittest.data.model.company.Bs
import dog.snow.androidrecruittest.data.model.company.CatchPhrase
import dog.snow.androidrecruittest.data.model.company.RawCompany
import dog.snow.androidrecruittest.data.model.geolocation.Coordinate
import dog.snow.androidrecruittest.data.model.photo.Url
import dog.snow.androidrecruittest.data.model.user.Email
import dog.snow.androidrecruittest.data.model.user.Phone
import dog.snow.androidrecruittest.data.model.user.Username
import dog.snow.androidrecruittest.data.model.user.Website
import io.objectbox.converter.PropertyConverter

object Converters {
    private const val NO_STRING = ""
    private const val NO_INT = 0L
    class WEBSITE : PropertyConverter<Website, String> {
        override fun convertToDatabaseValue(entityProperty: Website?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Website = Website(databaseValue ?: NO_STRING)
    }

    class USERNAME : PropertyConverter<Username, String> {
        override fun convertToDatabaseValue(entityProperty: Username?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Username = Username(databaseValue ?: NO_STRING)
    }

    class PHONE : PropertyConverter<Phone, String> {
        override fun convertToDatabaseValue(entityProperty: Phone?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Phone = Phone(databaseValue ?: NO_STRING)
    }

    class EMAIL : PropertyConverter<Email, String> {
        override fun convertToDatabaseValue(entityProperty: Email?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Email = Email(databaseValue ?: NO_STRING)
    }

    class URL : PropertyConverter<Url, String> {
        override fun convertToDatabaseValue(entityProperty: Url?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Url = Url(databaseValue ?: NO_STRING)
    }


    class NAME : PropertyConverter<Name, String> {
        override fun convertToDatabaseValue(entityProperty: Name?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Name = Name(databaseValue ?: NO_STRING)
    }

    class TITLE : PropertyConverter<Title, String> {
        override fun convertToDatabaseValue(entityProperty: Title?): String = entityProperty?.value ?: NO_STRING
        override fun convertToEntityProperty(databaseValue: String?): Title = Title(databaseValue ?: NO_STRING)
    }

    class UID : PropertyConverter<UId, Long> {
        override fun convertToDatabaseValue(entityProperty: UId?): Long = entityProperty?.value ?: NO_INT
        override fun convertToEntityProperty(databaseValue: Long?): UId = UId(databaseValue ?: NO_INT)
    }

    class ADDRESS : PropertyConverter<RawAddress, String> {
        override fun convertToDatabaseValue(entityProperty: RawAddress?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawAddress = ObjectMapper().readValue(databaseValue, RawAddress::class.java)
    }

    class COMPANY : PropertyConverter<RawCompany, String> {
        override fun convertToDatabaseValue(entityProperty: RawCompany?): String = ObjectMapper().writeValueAsString(entityProperty)
        override fun convertToEntityProperty(databaseValue: String?): RawCompany = ObjectMapper().readValue(databaseValue, RawCompany::class.java)
    }
}