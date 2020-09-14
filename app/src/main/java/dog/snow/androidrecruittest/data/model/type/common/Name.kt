package dog.snow.androidrecruittest.data.model.type.common

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.type.BaseSimpleType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(override val value: String) : Parcelable, BaseSimpleType<String>(value)