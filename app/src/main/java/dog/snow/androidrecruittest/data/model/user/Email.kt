package dog.snow.androidrecruittest.data.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Email(val value: String) : Parcelable