package com.ravn.challenge.ui.people.list

import androidx.lifecycle.lifecycleScope
import com.ravn.challenge.R
import com.ravn.challenge.base.BaseFragment
import com.ravn.challenge.databinding.FragmentPeopleListBinding
import com.ravn.challenge.ui.people.list.adapter.PeopleAdapter
import com.ravn.challenge.ui.people.list.adapter.PeopleLoadingStateAdapter
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleListFragment : BaseFragment<FragmentPeopleListBinding>(R.layout.fragment_people_list) {

    override val viewModel: PeopleListViewModel by viewModel()

    override fun onFragmentReady() {
        setUpAdapter()
    }

    private fun setUpAdapter() {
        val adapter = PeopleAdapter()
        binding.rvPeople.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PeopleLoadingStateAdapter(),
            footer = PeopleLoadingStateAdapter()
        )

        lifecycleScope.launchWhenCreated {
            viewModel.getPeople().collect {
                adapter.submitData(it)
            }
        }
    }
}