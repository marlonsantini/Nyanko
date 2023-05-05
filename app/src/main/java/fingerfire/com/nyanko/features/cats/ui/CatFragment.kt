package fingerfire.com.nyanko.features.cats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import fingerfire.com.nyanko.databinding.FragmentCatBinding
import fingerfire.com.nyanko.features.cats.data.response.CatResponse
import fingerfire.com.nyanko.features.cats.ui.adapter.CatsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatFragment : Fragment() {

    private lateinit var binding: FragmentCatBinding
    private lateinit var catsAdapter: CatsAdapter
    private val viewModel: CatViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerCats()
        viewModel.getCatPics()
    }

    private fun observerCats() {
        viewModel.catLiveData.observe(viewLifecycleOwner) {viewState ->
            if(viewState.sucess != null) {
                val cat = viewState.sucess
                initRecyclerView()
                initAdapter(cat)
            } else if (viewState.failure) {

            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager =
            GridLayoutManager(activity, 2)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun initAdapter(catResponse: List<CatResponse>) {
        catsAdapter = CatsAdapter(catResponse)
        binding.recyclerView.adapter = catsAdapter
    }
}