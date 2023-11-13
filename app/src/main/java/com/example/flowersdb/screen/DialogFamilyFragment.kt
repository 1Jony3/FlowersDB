package com.example.flowersdb.screen

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.flowersdb.R
import com.example.flowersdb.databinding.FragmentDialogFamilyBinding
import com.example.flowersdb.databinding.FragmentListFlowersBinding
import com.example.flowersdb.model.adapter.FlowersAdapter
import com.example.flowersdb.screen.viewModels.DialogFamilyViewModel
import com.example.flowersdb.screen.viewModels.ListFlowersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DialogFamilyFragment() : DialogFragment() {

    private lateinit var binding: FragmentDialogFamilyBinding

    private val viewModel: DialogFamilyViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = FragmentDialogFamilyBinding.inflate(layoutInflater)

        binding.addFamilyButton.setOnClickListener{
            viewModel.insertFamily(binding.familyNameTextInputEditText.toString())
        }

        val builder = AlertDialog.Builder(requireContext())
            .setTitle(R.string.add_family)
            .setView(binding.root)

        val alertDialog = builder.create()
        val drawable: Drawable? = AppCompatResources.getDrawable(requireContext(), R.drawable.shape_radius)
        alertDialog.window?.setBackgroundDrawable(drawable)

        return alertDialog
    }

}