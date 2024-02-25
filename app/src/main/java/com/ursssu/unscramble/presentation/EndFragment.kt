package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentEndBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class EndFragment : BaseFragment<FragmentEndBinding>(R.layout.fragment_end) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()
    }

    private fun initClickListeners() {
        initRetryClickListener()
        initHomeClickListener()
    }

    private fun initRetryClickListener() {
        binding.btnEndRetry.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(findNavController().graph.startDestinationId, true)
                .build()
            findNavController().navigate(R.id.timerFragment, null, navOptions)
        }
    }

    private fun initHomeClickListener() {
        binding.btnEndHome.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.timerFragment, true)
                .build()
            findNavController().navigate(R.id.homeFragment, null, navOptions)
        }
    }


}