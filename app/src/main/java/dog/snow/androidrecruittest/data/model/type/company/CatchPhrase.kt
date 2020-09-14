package dog.snow.androidrecruittest.data.model.type.company

import android.os.Parcelable
import dog.snow.androidrecruittest.data.model.type.BaseSimpleType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CatchPhrase(override val value: String) : Parcelable, BaseSimpleType<String>(value)