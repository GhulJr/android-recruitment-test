package dog.snow.androidrecruittest.data.model.raw

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.geolocation.Coordinate
import io.objectbox.annotation.Id
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RawGeo(
    @JsonProperty("lat")
    val lat: Coordinate,
    @JsonProperty("lng")
    val lng: Coordinate
) : Parcelable