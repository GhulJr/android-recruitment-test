package dog.snow.androidrecruittest.ui.model

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.model.type.common.UId
import dog.snow.androidrecruittest.data.model.type.common.Title
import dog.snow.androidrecruittest.data.model.type.photo.Url
import dog.snow.androidrecruittest.data.model.type.user.Email
import dog.snow.androidrecruittest.data.model.type.user.Phone
import dog.snow.androidrecruittest.data.model.type.user.Username
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Detail(
    val photoUId: UId,
    val photoTitle: Title,
    val albumTitle: Title,
    val username: Username,
    val email: Email,
    val phone: Phone,
    val url: Url
) : Parcelable {

    companion object { // TODO: create binding module
        @BindingAdapter("avatar")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: Url) {
            Picasso.get()
                .load(url.value)
                .placeholder(R.drawable.ic_placeholder)
                //.centerCrop()
                //.resize(850, 850)
                //.transform(RoundedCornersTransformation(40, 0))
                .into(imageView)
        }
    }
}