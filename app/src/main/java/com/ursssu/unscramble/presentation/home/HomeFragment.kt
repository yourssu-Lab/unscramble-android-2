package com.ursssu.unscramble.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentHomeBinding
import com.ursssu.unscramble.presentation.home.HomeViewModel.EventType
import com.ursssu.unscramble.util.binding.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initObservers()
    }

    private fun bindViewModel() {
        binding.viewModel = viewModel
    }

    private fun initObservers() {
        initEventObserver()
    }

    private fun initEventObserver() {
        viewModel.event.observe(viewLifecycleOwner) { eventType ->
            when (eventType) {
                EventType.NAVIGATION -> {
                    findNavController().navigate(R.id.action_homeFragment_to_timerFragment)
                }
            }
        }
    }
}
