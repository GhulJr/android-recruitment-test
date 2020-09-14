package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.address.City
import dog.snow.androidrecruittest.data.model.type.address.Street
import dog.snow.androidrecruittest.data.model.type.address.Suite
import dog.snow.androidrecruittest.data.model.type.address.ZipCode
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawAddress(
    @JsonProperty("street")
    val street: Street,
    @JsonProperty("suite")
    val suite: Suite,
    @JsonProperty("city")
    val city: City,
    @JsonProperty("zipcode")
    val zipCode: ZipCode,
    @JsonProperty("geo")
    val geo: RawGeo
) : Parcelable