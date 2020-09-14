package dog.snow.androidrecruittest.ui.page.details

import dog.snow.androidrecruittest.data.repository.StorageRepository
import dog.snow.androidrecruittest.ui.base.BaseViewModel
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val storageRepository: StorageRepository
): BaseViewModel() {

}