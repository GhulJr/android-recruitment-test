package dog.snow.androidrecruittest.data.model.type.address

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import dog.snow.androidrecruittest.data.model.type.BaseSimpleType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Street(override val value: String) : Parcelable, BaseSimpleType<String>(value)