package dog.snow.androidrecruittest.di.module.details

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.di.module.list.ListFragmentInjectionModule
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.details.DetailsFragment
import dog.snow.androidrecruittest.ui.page.details.DetailsViewModel
import dog.snow.androidrecruittest.ui.page.list.ListFragment
import dog.snow.androidrecruittest.ui.page.list.ListViewModel

@Module
class DetailsFragmentInjectionModule {
    @Provides
    fun provideListViewModel(fragment: DetailsFragment, factory: ViewModelFactory): DetailsViewModel {
        Log.i(TAG, "Provide ListViewModel.")
        return ViewModelProvider(fragment.viewModelStore, factory)[DetailsViewModel::class.java]
    }

    companion object {
        private val TAG = DetailsFragmentInjectionModule::class.simpleName
    }
}