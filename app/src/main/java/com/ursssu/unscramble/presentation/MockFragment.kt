package com.ursssu.unscramble.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ursssu.unscramble.databinding.FragmentMockBinding
import com.yourssu.design.system.atom.Toggle
import com.yourssu.design.undercarriage.base.TextField

class MockFragment : Fragment() {
    lateinit var binding: FragmentMockBinding
    private val viewModel: ViewModel by viewModels()
}