package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentEndBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class EndFragment : BaseFragment<FragmentEndBinding>(R.layout.fragment_end) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRetryClickListener()
        initHomeClickListener()

    }

    private fun initRetryClickListener() {
        binding.btnEndRetry.setOnClickListener {
            findNavController().navigate(R.id.timerFragment)
        }
    }

    private fun initHomeClickListener() {
        binding.btnEndHome.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

}