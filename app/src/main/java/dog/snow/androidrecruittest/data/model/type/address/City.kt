package dog.snow.androidrecruittest.data.model.type.address

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.type.BaseSimpleType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City(override val value: String) : Parcelable, BaseSimpleType<String>(value)