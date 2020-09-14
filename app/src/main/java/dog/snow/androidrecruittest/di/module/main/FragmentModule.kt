package dog.snow.androidrecruittest.di.module.main

import androidx.fragment.app.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dog.snow.androidrecruittest.di.module.list.ListFragmentModule
import dog.snow.androidrecruittest.ui.page.details.DetailsFragment

@Module
interface FragmentModule {

    @ContributesAndroidInjector(modules = [ListFragmentModule::class])
    fun provideListFragment(): ListFragment

    @ContributesAndroidInjector
    fun provideDetailsFragment(): DetailsFragment
}