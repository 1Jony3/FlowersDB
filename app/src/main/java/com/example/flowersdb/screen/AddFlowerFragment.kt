package com.example.flowersdb.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.flowersdb.R
import com.example.flowersdb.databinding.FragmentAddFlowerBinding
import com.example.flowersdb.screen.viewModels.AddFlowerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFlowerFragment : Fragment(R.layout.fragment_add_flower) {

    private lateinit var binding: FragmentAddFlowerBinding
    private val viewModel: AddFlowerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddFlowerBinding.inflate(inflater, container, false)

        viewModel.allFamily.observe(viewLifecycleOwner) { allFamily ->
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                binding.addFlowerButton.text = allFamily.toString()
            }
        }

        binding.addChip.setOnClickListener { openAddFamily() }

        return binding.root
    }
    private fun openAddFamily(){
        findNavController().navigate(
            R.id.action_addFlowerFragment_to_navigation_dialog
        )
    }
}