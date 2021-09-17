package com.habib.jeenyassesment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.habib.jeenyassesment.R
import com.habib.jeenyassesment.data.local.models.MostViewedArticleDomainModel
import com.habib.jeenyassesment.databinding.FragmentDetailsMostViewedArticleBinding
/**
 * A simple [Fragment] subclass.
 * Use the [DetailsMostViewedArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsMostViewedArticleFragment : Fragment() {

    private lateinit var binding: FragmentDetailsMostViewedArticleBinding
    private val args: DetailsMostViewedArticleFragmentArgs by navArgs()
    private val data: MostViewedArticleDomainModel by lazy { args.data!! }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsMostViewedArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data.let {
            binding.article = it
        }
    }
}