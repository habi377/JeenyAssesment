package com.habib.jeenyassesment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.habib.jeenyassesment.R
import com.habib.jeenyassesment.adapters.MostViewedArticlesAdapter
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.databinding.FragmentMostViewedArticlesBinding
import com.habib.jeenyassesment.ui.viewmodels.MostViewedArticlesFragmentViewModel
import com.habib.jeenyassesment.utils.ArticleClick

/**
 * A simple [Fragment] subclass.
 * Use the [MostViewedArticlesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MostViewedArticlesFragment : Fragment() {

    private lateinit var binding: FragmentMostViewedArticlesBinding
    private lateinit var viewModelAdapter: MostViewedArticlesAdapter

    private val viewModel: MostViewedArticlesFragmentViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(activity).get(MostViewedArticlesFragmentViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // Set the lifecycleOwner so DataBinding can observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = viewModel

        viewModelAdapter = MostViewedArticlesAdapter(ArticleClick { addItemClicked(it) })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        binding = FragmentMostViewedArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun addItemClicked(article: MostViewedArticleDomainModel) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mostViewed.observe(viewLifecycleOwner, {
            /*when (it?.message) {
                Constants.LOADING -> binding.loadingSpinner.visibility = View.VISIBLE
                Constants.SUCCESS -> {
                    it.data?.results?.let { result ->
                        binding.loadingSpinner.visibility = View.GONE
                        viewModelAdapter?.results = result
                        viewModelAdapter?.notifyDataSetChanged()
                    }
                }
                else -> {
                    binding.loadingSpinner.visibility = View.GONE
                    Toast.makeText(context,it.message.toString(),Toast.LENGTH_SHORT).show()
                }
            }*/
            viewModelAdapter.articles = it
            viewModelAdapter.notifyDataSetChanged()
        })

        // Observer for the network error.
        viewModel.eventNetworkError.observe(viewLifecycleOwner, { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })
        viewModel.eventNetworkErrorMsg.observe(viewLifecycleOwner, { networkErrorMsg ->
            Toast.makeText(requireContext(), ""+networkErrorMsg , Toast.LENGTH_LONG).show()
        })
    }

    private fun onNetworkError() {
        viewModel.isNetworkErrorShown.value?.let {
            if(it) {
                viewModel.onNetworkErrorShown()
            }
        }
    }

}