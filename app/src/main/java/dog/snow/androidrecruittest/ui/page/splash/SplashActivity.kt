package dog.snow.androidrecruittest.ui.page.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.data.source.remote.Resource
import dog.snow.androidrecruittest.databinding.ActivitySplashBinding
import dog.snow.androidrecruittest.ui.base.BaseActivity
import dog.snow.androidrecruittest.ui.page.main.MainActivity
import dog.snow.androidrecruittest.utils.setLoadingView
import dog.snow.androidrecruittest.utils.showError
import dog.snow.androidrecruittest.utils.subscribe


class SplashActivity : BaseActivity() {
    lateinit var splashViewModel: SplashViewModel
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        setupViewModel()
    }

    /** Utils. */

    override fun setupViewModel() {
        splashViewModel = ViewModelProvider(this, viewModelFactory)[SplashViewModel::class.java]
        splashViewModel.fetchDataState.subscribe(this) {
            setLoadingView(false)
            when (it) {
                is Resource.Success -> redirectToActivity(MainActivity::class.java)
                is Resource.Loading -> setLoadingView(true)
                is Resource.Error -> showError(it.message)
            }
        }
    }
}