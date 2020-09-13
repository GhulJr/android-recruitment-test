package dog.snow.androidrecruittest.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dog.snow.androidrecruittest.di.key.ViewModelKey
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import dog.snow.androidrecruittest.ui.page.splash.SplashViewModel

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}