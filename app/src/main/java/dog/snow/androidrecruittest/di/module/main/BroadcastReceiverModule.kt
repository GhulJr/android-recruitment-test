package dog.snow.androidrecruittest.di.module.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dog.snow.androidrecruittest.ui.common.broadcast.NetworkChangeReceiver
import dog.snow.androidrecruittest.ui.page.main.MainActivity

@Module
interface BroadcastReceiverModule {

    @ContributesAndroidInjector
    fun provideNetworkReceiver(): NetworkChangeReceiver
}