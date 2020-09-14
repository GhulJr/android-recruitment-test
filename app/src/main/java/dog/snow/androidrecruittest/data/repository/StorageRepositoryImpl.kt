package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.raw.RawAlbum
import dog.snow.androidrecruittest.data.model.raw.RawPhoto
import dog.snow.androidrecruittest.data.model.raw.RawUser
import dog.snow.androidrecruittest.data.source.local.DatabaseManager
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val databaseManager: DatabaseManager
) : StorageRepository {
    override fun getPhotos(): Single<List<RawPhoto>> = databaseManager.getPhotos()
        .subscribeOn(Schedulers.newThread())

    override fun getAlbums(): Single<List<RawAlbum>> = databaseManager.getAlbums()
        .subscribeOn(Schedulers.newThread())

    override fun getUsers(): Single<List<RawUser>> = databaseManager.getUsers()
        .subscribeOn(Schedulers.newThread())
}