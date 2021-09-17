package com.habib.jeenyassesment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.habib.jeenyassesment.R

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsMostViewedArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsMostViewedArticleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_most_viewed_article, container, false)
    }
}