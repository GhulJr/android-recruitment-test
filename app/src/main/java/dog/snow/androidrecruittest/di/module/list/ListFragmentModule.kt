package dog.snow.androidrecruittest.di.module.list

import dagger.Module
import dog.snow.androidrecruittest.di.module.base.BaseFragmentModule
import dog.snow.androidrecruittest.ui.page.list.ListFragment

@Module(includes = [ListViewModelModule::class])
abstract class ListFragmentModule : BaseFragmentModule<ListFragment>()