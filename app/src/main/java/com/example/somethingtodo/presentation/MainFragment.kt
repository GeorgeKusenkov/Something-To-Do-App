package com.example.somethingtodo.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.somethingtodo.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels{
        mainViewModelFactory
    }

    private lateinit var binding: FragmentMainBinding
    private var _binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        launchLifecycleScope()
    }

    private fun launchLifecycleScope() {
        viewLifecycleOwner.lifecycleScope
            .launchWhenStarted {
                viewModel.activityText
                    .collect { textFromApi ->
                        binding.activityText.text = textFromApi
                    }
            }
    }

    private fun setOnClickListeners() {
        binding.button.setOnClickListener {
            viewModel.reloadUsefulActivity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}