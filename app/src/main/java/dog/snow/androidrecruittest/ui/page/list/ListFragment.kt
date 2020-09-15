package dog.snow.androidrecruittest.ui.page.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import dog.snow.androidrecruittest.databinding.FragmentListBinding
import dog.snow.androidrecruittest.ui.common.rx.RxTextWatcher

import dog.snow.androidrecruittest.utils.subscribe
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ListFragment : Fragment() {
    @Inject
    lateinit var listViewModel: ListViewModel
    @Inject
    lateinit var listAdapter: ListAdapter
    private lateinit var binding: FragmentListBinding
    private lateinit var searchListenerDisposable: Disposable


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearViews()
    }

    /** Utils. */

    private fun setupViews() {
        binding.rvItems.apply { adapter = listAdapter }
        searchListenerDisposable = RxTextWatcher.fromView(binding.layoutSearch.etSearch)
            .subscribe {
                listAdapter.filter(it)
                displayNoResults(shouldDisplay = listAdapter.filteredList.isNullOrEmpty())
            }
    }

    private fun clearViews() {
        searchListenerDisposable.dispose()
    }

    private fun setupObservers() {
        listViewModel.listItems.subscribe(viewLifecycleOwner) {
            listAdapter.modifyList(it)
            displayNoResults(shouldDisplay = it.isEmpty())
        }
    }

    private fun displayNoResults(shouldDisplay: Boolean) {
        binding.layoutEmptyView.tvEmpty.visibility = if(shouldDisplay) View.VISIBLE else View.GONE
    }
}