package com.ravn.challenge.ui.people.list

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ravn.challenge.R
import com.ravn.challenge.base.BaseFragment
import com.ravn.challenge.databinding.FragmentPeopleListBinding
import com.ravn.challenge.ui.people.PeopleShareViewModel
import com.ravn.challenge.ui.people.list.adapter.PeopleAdapter
import com.ravn.challenge.ui.people.list.adapter.PeopleLoadingStateAdapter
import com.ravn.challenge.ui.people.list.adapter.PeopleViewHolder
import com.ravn.core.model.People
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleListFragment : BaseFragment<FragmentPeopleListBinding>(R.layout.fragment_people_list),
    PeopleViewHolder.OnItemPeopleClick {

    private val shareVieWModel: PeopleShareViewModel by sharedViewModel()
    override val viewModel: PeopleListViewModel by viewModel()

    override fun onFragmentReady() {
        setUpAdapter()
    }

    private fun setUpAdapter() {
        val adapter = PeopleAdapter(this)
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

    override fun onPeopleSelected(people: People?) {
        shareVieWModel.people = people
        findNavController().navigate(R.id.action_peopleListFragment_to_peopleDetailFragment)
    }
}