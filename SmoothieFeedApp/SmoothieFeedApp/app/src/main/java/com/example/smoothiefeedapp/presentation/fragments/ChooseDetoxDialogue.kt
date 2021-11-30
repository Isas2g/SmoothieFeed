package com.example.smoothiefeedapp.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentDialogueBinding
import com.example.smoothiefeedapp.presentation.view_models.ChooseDetoxDialogueViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChooseDetoxDialogue: DialogFragment(R.layout.fragment_dialogue) {
    private val binding: FragmentDialogueBinding by viewBinding(FragmentDialogueBinding::bind)
    private val viewModel: ChooseDetoxDialogueViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRBActions()
        setChosenDetoxButton()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
                    viewModel.getPostsDetoxUseCase().collect {
                        if (it!=null){
                            requireActivity().onBackPressed()
                        }
                    }
                }
                launch {
                    viewModel.getTimeDetoxUseCase().collect {
                        if (it!=null){
                            requireActivity().onBackPressed()
                        }
                    }
                }
            }
        }
    }

    private fun setRBActions(){
        with(binding){
            fragDialogueRbPostsLight.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    offAnotherRB(fragDialogueRbPostsLight)
                }
            }
            fragDialogueRbTimeLight.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    offAnotherRB(fragDialogueRbTimeLight)
                }
            }
            fragDialogueRbPostsMedium.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    offAnotherRB(fragDialogueRbPostsMedium)
                }
            }
            fragDialogueRbTimeMedium.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    offAnotherRB(fragDialogueRbTimeMedium)
                }
            }
            fragDialogueRbPostsHard.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    offAnotherRB(fragDialogueRbPostsHard)
                }
            }
            fragDialogueRbTimeHard.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked){
                    offAnotherRB(fragDialogueRbTimeHard)
                }
            }
        }
    }

    private fun offAnotherRB(neededRB: RadioButton){
        with(binding){
            fragDialogueRbPostsLight.isChecked = false
            fragDialogueRbTimeLight.isChecked = false
            fragDialogueRbPostsMedium.isChecked = false
            fragDialogueRbTimeMedium.isChecked = false
            fragDialogueRbPostsHard.isChecked = false
            fragDialogueRbTimeHard.isChecked = false
        }
        neededRB.isChecked = true
    }

    private fun setChosenDetoxButton(){
        with(binding){
            bvStartDetox.setOnClickListener {
                if (fragDialogueRbPostsLight.isChecked) viewModel.setDetox(1)
                if (fragDialogueRbTimeLight.isChecked) viewModel.setDetox(2)
                if (fragDialogueRbPostsMedium.isChecked) viewModel.setDetox(3)
                if (fragDialogueRbTimeMedium.isChecked) viewModel.setDetox(4)
                if (fragDialogueRbPostsHard.isChecked) viewModel.setDetox(5)
                if (fragDialogueRbTimeHard.isChecked) viewModel.setDetox(6)
            }
        }

    }
}