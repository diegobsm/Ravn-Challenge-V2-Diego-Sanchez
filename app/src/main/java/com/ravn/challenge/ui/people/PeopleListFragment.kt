package com.ravn.challenge.ui.people

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ravn.challenge.R

class PeopleListFragment : Fragment() {

    companion object {
        fun newInstance() = PeopleListFragment()
    }

    private lateinit var viewModel: PeopleListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PeopleListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}