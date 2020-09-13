package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.model.album.RawAlbum
import dog.snow.androidrecruittest.data.model.album.RawAlbum_
import dog.snow.androidrecruittest.data.model.photo.RawPhoto
import dog.snow.androidrecruittest.data.model.user.RawUser
import dog.snow.androidrecruittest.data.model.user.RawUser_
import dog.snow.androidrecruittest.data.source.local.DatabaseManager
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.data.source.remote.service.AlbumService
import dog.snow.androidrecruittest.data.source.remote.service.PhotoService
import dog.snow.androidrecruittest.data.source.remote.service.UserService
import io.objectbox.Box
import io.reactivex.Flowable
import io.reactivex.Single

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SourceRepositoryImpl @Inject constructor(
    private val photoService: PhotoService,
    private val albumService: AlbumService,
    private val userService: UserService,
    private val dbManager: DatabaseManager

) : SourceRepository {

    override fun pullData(): Single<out Resource<Void>> = pullPhotos()
        .switchMap { pullAlbums(it) }
        .flatMap { pullUsers(it) }
        .toList()  // By the time all values are fetched.
        .map { Resource.Success<Void>(null) }
        .observeOn(AndroidSchedulers.mainThread())


    private fun pullPhotos() = photoService.fetchPhotos(PHOTO_LIMIT)
        .subscribeOn(Schedulers.io())
        .map {
            dbManager.putPhotos(it)
            it
        }

    private fun pullAlbums(photos: List<RawPhoto>) = Flowable.fromIterable(photos.distinctBy { it.albumUId })
        .flatMap { albumService.fetchAlbum(it.albumUId) }
        .map {
            dbManager.putAlbum(it)
            it
        }

    private fun pullUsers(album: RawAlbum) = userService.fetchUser(album.userUId)
        .map {
            dbManager.putUser(it)
            it
        }


    companion object {
        private const val PHOTO_LIMIT = 100
        private val TAG = SourceRepositoryImpl::class.simpleName
    }
}