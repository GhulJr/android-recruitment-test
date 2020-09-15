package dog.snow.androidrecruittest.ui.common.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import dagger.android.AndroidInjection


class NetworkChangeReceiver(private val onChanged: () -> Unit) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        AndroidInjection.inject(this, context)
        val connMgr = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(connMgr.activeNetwork == null)
            onChanged.invoke()
    }
}