package com.ursssu.unscramble.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ursssu.unscramble.databinding.FragmentMockBinding

class MockFragment : Fragment() {
    lateinit var binding: FragmentMockBinding
    private val mockViewModel: MockViewModel by viewModels()
}