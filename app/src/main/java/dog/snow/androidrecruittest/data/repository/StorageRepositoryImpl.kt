package dog.snow.androidrecruittest.data.repository

import dog.snow.androidrecruittest.data.source.local.DatabaseManager
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(
    private val databaseManager: DatabaseManager
) : StorageRepository {

    fun getListItems() {
    }
}