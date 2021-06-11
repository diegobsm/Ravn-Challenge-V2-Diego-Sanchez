package com.ravn.challenge.ui.people.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ravn.challenge.R

class PeopleDetailFragment : Fragment() {

    companion object {
        fun newInstance() = PeopleDetailFragment()
    }

    private lateinit var viewModel: PeopleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PeopleDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}