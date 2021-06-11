package com.ravn.challenge.ui.people.detail

import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.ravn.challenge.R
import com.ravn.challenge.base.BaseFragment
import com.ravn.challenge.databinding.FragmentPeopleDetailBinding
import com.ravn.challenge.ui.people.PeopleShareViewModel
import com.ravn.challenge.ui.people.detail.adapter.VehicleAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleDetailFragment : BaseFragment<FragmentPeopleDetailBinding>(R.layout.fragment_people_detail) {

    private val shareVieWModel: PeopleShareViewModel by sharedViewModel()
    override val viewModel: PeopleDetailViewModel by viewModel()

    override fun onFragmentReady() {
        navigationBackHandler()
        viewModel.setupInfo(shareVieWModel.people)
        setUpAdapter()
    }

    private fun navigationBackHandler() {
        binding.tbPeopleDetail.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }

    private fun setUpAdapter() {
        val vehicleAdapter = VehicleAdapter()
        binding.rvVehicle.adapter = vehicleAdapter
        if (shareVieWModel.people?.vehiclesConnection.isNullOrEmpty().not()) {
            vehicleAdapter.updateData(shareVieWModel.people?.vehiclesConnection)
        } else {
            viewModel.hasVehicleObservable.set(false)
        }
    }
}