package dog.snow.androidrecruittest.data.model.type.common

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.type.BaseSimpleType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UId(override val value: Long) : Parcelable , BaseSimpleType<Long>(value)