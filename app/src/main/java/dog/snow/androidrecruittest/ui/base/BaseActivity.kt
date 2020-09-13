package dog.snow.androidrecruittest.ui.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import dog.snow.androidrecruittest.ui.common.view_model.ViewModelFactory
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun redirectToActivity(direction: Class<out AppCompatActivity>) {
        startActivity(Intent(this, direction))
        finish()
    }

    fun startActivity(direction: Class<out AppCompatActivity>) {
        startActivity(Intent(this, direction))
        finish()
    }

    protected abstract fun setupViewModel()
}