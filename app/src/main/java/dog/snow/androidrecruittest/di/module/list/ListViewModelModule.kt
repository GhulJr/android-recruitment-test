package dog.snow.androidrecruittest.di.module.list

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.list.ListFragment
import dog.snow.androidrecruittest.ui.page.list.ListViewModel

@Module
class ListViewModelModule {
    @Provides
    fun provideListViewModel(fragment: ListFragment, factory: ViewModelFactory): ListViewModel {
        Log.i(TAG, "Provide ListViewModel.")
        return ViewModelProvider(fragment.viewModelStore, factory)[ListViewModel::class.java]
    }

    companion object {
        private val TAG = ListViewModelModule::class.simpleName
    }
}