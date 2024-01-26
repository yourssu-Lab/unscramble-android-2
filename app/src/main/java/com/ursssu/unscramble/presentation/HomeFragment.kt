package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentHomeBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListener()

    }

    private fun initClickListener(){
        initHomeClickListener()
    }


    private fun initHomeClickListener() {
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.timerFragment)
        }
    }

}
