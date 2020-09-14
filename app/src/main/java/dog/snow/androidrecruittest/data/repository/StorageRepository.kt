package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import io.reactivex.Flowable
import io.reactivex.Single

interface StorageRepository {
    fun getPhotos(): Single<List<RawPhoto>>
    fun getAlbums(): Single<List<RawAlbum>>
    fun getUsers(): Single<List<RawUser>>
}