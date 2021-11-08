package com.example.smoothiefeedapp.presentation

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentRegistrationBinding
import com.example.smoothiefeedapp.view_models.RegistrationFragmentViewModel
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    private val binding: FragmentRegistrationBinding by viewBinding(FragmentRegistrationBinding::bind)
    private val viewModel: RegistrationFragmentViewModel by viewModels()
    private var fieldsJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setSavedFields()
        setFieldsSave()
        setButtonActions()
    }

    private fun setSavedFields() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                with(binding) {
                    apply {
                        registrationFragmentEtUsername.setText(viewModel.usernameObserver.first())
                    }
                    apply {
                        registrationFragmentEtEmail.setText(viewModel.emailObserver.first())
                    }
                    apply {
                        registrationFragmentEtFirstPassword.setText(viewModel.firstPasswordObserver.first())
                    }
                    apply {
                        registrationFragmentEtSecondPassword.setText(viewModel.secondPasswordObserver.first())
                    }
                }
            }
        }
    }

    private fun setFieldsSave() {
        with(binding) {
            registrationFragmentEtUsername.addTextChangedListener { username ->
                viewModel.saveUsername(username?.toString())
            }
            registrationFragmentEtEmail.addTextChangedListener { email ->
                viewModel.saveEmail(email?.toString())
            }
            registrationFragmentEtFirstPassword.addTextChangedListener { firstPassword ->
                viewModel.saveFirstPassword(firstPassword?.toString())
            }
            registrationFragmentEtSecondPassword.addTextChangedListener { secondPassword ->
                viewModel.saveSecondPassword(secondPassword?.toString())
            }
        }
    }

    private fun setButtonActions() {
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        viewModel.allFieldsIsCorrectObserver.collect { allFieldsAreCorrect ->
                            if (allFieldsAreCorrect == true) {
                                with(registrationFragmentBvJoin as MaterialButton) {
                                    setTextColor(
                                        ContextCompat.getColor(
                                            requireContext(),
                                            R.color.text_input_layout_color_green
                                        )
                                    )
                                    setStrokeColorResource(R.color.text_input_layout_color_green)
                                    setRippleColorResource(R.color.text_input_layout_color_green)
                                    fieldsJob?.cancel()
                                    setOnClickListener(null)
                                }
                            } else {
                                with(registrationFragmentBvJoin as MaterialButton) {
                                    setTextColor(
                                        ContextCompat.getColor(
                                            requireContext(),
                                            R.color.non_active_view_color_grey
                                        )
                                    )
                                    setStrokeColorResource(R.color.non_active_view_color_grey)
                                    setRippleColorResource(R.color.color_transparent)
                                    fieldsJob?.cancel()
                                    setOnClickListener {
                                        fieldsJob = launch {
                                            launch {
                                                viewModel.usernameIsCorrectObserver
                                                    .drop(0)
                                                    .collect { usernameIsCorrect ->
                                                        if (usernameIsCorrect == true) {
                                                            registrationFragmentTilUsername.isErrorEnabled =
                                                                false
                                                        } else {
                                                            registrationFragmentTilUsername.error =
                                                                getString(R.string.username_error)
                                                            registrationFragmentTilUsername.isErrorEnabled =
                                                                true
                                                        }
                                                    }
                                            }
                                            launch {
                                                viewModel.emailIsCorrectObserver
                                                    .drop(0)
                                                    .collect { emailIsCorrect ->
                                                        if (emailIsCorrect == true) {
                                                            registrationFragmentTilEmail.isErrorEnabled =
                                                                false
                                                        } else {
                                                            registrationFragmentTilEmail.error =
                                                                getString(R.string.email_error)
                                                            registrationFragmentTilEmail.isErrorEnabled =
                                                                true
                                                        }
                                                    }
                                            }
                                            launch {
                                                viewModel.firstPasswordIsCorrectObserver
                                                    .drop(0)
                                                    .collect { firstPasswordIsCorrect ->
                                                        if (firstPasswordIsCorrect == true) {
                                                            registrationFragmentTilFirstPassword.isErrorEnabled =
                                                                false
                                                        } else {
                                                            registrationFragmentTilFirstPassword.error =
                                                                getString(R.string.first_password_error)
                                                            registrationFragmentTilFirstPassword.isErrorEnabled =
                                                                true
                                                        }
                                                    }
                                            }
                                            launch {
                                                viewModel.secondPasswordIsCorrectObserver
                                                    .drop(0)
                                                    .collect { secondPasswordIsCorrect ->
                                                        if (secondPasswordIsCorrect == true && !viewModel.firstAndSecondPasswordAreSame()) {
                                                            registrationFragmentTilSecondPassword.error =
                                                                getString(R.string.passwords_error)
                                                            registrationFragmentTilSecondPassword.isErrorEnabled =
                                                                true
                                                        } else if (secondPasswordIsCorrect == true) {
                                                            registrationFragmentTilSecondPassword.isErrorEnabled =
                                                                false
                                                        } else {
                                                            registrationFragmentTilSecondPassword.error =
                                                                getString(R.string.second_password_error)
                                                            registrationFragmentTilSecondPassword.isErrorEnabled =
                                                                true
                                                        }
                                                    }
                                            }
                                        }

                                    }
                                }

                            }
                        }
                    }

                }
            }
        }


    }
}