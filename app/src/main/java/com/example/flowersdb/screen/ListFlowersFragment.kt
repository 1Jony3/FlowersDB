package com.example.flowersdb.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import com.example.flowersdb.R
import com.example.flowersdb.databinding.FragmentListFlowersBinding
import com.example.flowersdb.model.adapter.FlowersAdapter
import com.example.flowersdb.screen.viewModels.ListFlowersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFlowersFragment : Fragment(R.layout.fragment_list_flowers) {

    private lateinit var binding: FragmentListFlowersBinding
    private lateinit var adapter: FlowersAdapter

    private val viewModel: ListFlowersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListFlowersBinding.inflate(inflater, container, false)
        adapter = FlowersAdapter()

        viewModel.allFlower.observe(viewLifecycleOwner) { allFlowers ->
            if (viewLifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED) {
                adapter.flowers = allFlowers
                binding.list.adapter = adapter
            }
        }
        binding.add.setOnClickListener { openAddFlower() }
        return binding.root
    }

    private fun openAddFlower(){
        findNavController().navigate(
            R.id.action_flowersList2_to_addFlowerFragment
        )
    }

}

