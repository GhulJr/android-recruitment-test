package dog.snow.androidrecruittest.data.source.local

import dog.snow.androidrecruittest.data.model.raw.*
import dog.snow.androidrecruittest.data.model.type.common.UId
import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class DatabaseManager @Inject constructor( //TODO: create interface
    private val photoBox: Box<RawPhoto>,
    private val albumBox: Box<RawAlbum>,
    private val userBox: Box<RawUser>
){
    fun putPhotos(photos: List<RawPhoto>): Unit = with(photoBox) {
        removeAll()
        put(photos)
    }

    fun putAlbum(album: RawAlbum): Unit = with(albumBox) {
        query().equal(RawAlbum_.uId, album.uId.value).build().remove() //TODO: separate query method.
        put(album)
    }

    fun putUser(user: RawUser): Unit = with(userBox) {
        query().equal(RawUser_.uId, user.uId.value).build().remove()
        put(user)
    }

    fun getPhotos(): Single<List<RawPhoto>> = RxQuery.single(photoBox.query().build())

    fun getAlbums(): Single<List<RawAlbum>> = RxQuery.single(albumBox.query().build())

    fun getUsers(): Single<List<RawUser>> = RxQuery.single(userBox.query().build())

}