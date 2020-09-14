package dog.snow.androidrecruittest.ui.page.details

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dog.snow.androidrecruittest.R

class DetailsFragment : Fragment(R.layout.fragment_details) {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}