package com.example.smoothiefeedapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.smoothiefeedapp.R
import com.example.smoothiefeedapp.databinding.FragmentLoginBinding
import com.example.smoothiefeedapp.presentation.view_models.LoginFragmentViewModel
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel: LoginFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.getSFUserChangesUseCase().collect { sFUser ->
                        if (sFUser != null) {
                            Toast.makeText(
                                requireContext(),
                                "Hello ${sFUser.userName}!",
                                Toast.LENGTH_SHORT
                            ).show()
                            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
                        }
                    }
                }
            }
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    binding.loginFragmentEtEmail.setText(viewModel.emailObserver.first())
                }
                launch {
                    binding.loginFragmentEtPassword.setText(viewModel.passwordObserver.first())
                }
            }
        }

        binding.loginFragmentEtEmail.addTextChangedListener { email ->
            viewModel.saveEmail(email?.toString())
        }

        binding.loginFragmentEtPassword.addTextChangedListener { password ->
            viewModel.savePassword(password?.toString())
        }

        setButtonActions()

        binding.loginFragmentTvDontHaveAccount.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegistrationFragment())
        }
    }

    private fun setButtonActions() {
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        viewModel.allFieldIsCorrectObserver.collect { allFieldsIsCorrect ->
                            if (allFieldsIsCorrect == true) {
                                with(loginFragmentBvLogIn as MaterialButton) {
                                    setTextColor(
                                        ContextCompat.getColor(
                                            requireContext(),
                                            R.color.text_input_layout_color_green
                                        )
                                    )
                                    setStrokeColorResource(R.color.text_input_layout_color_green)
                                    setRippleColorResource(R.color.text_input_layout_color_green)
                                    setOnClickListener {
                                        viewModel.logIn()
                                    }
                                }
                            } else {
                                with(loginFragmentBvLogIn as MaterialButton) {
                                    setTextColor(
                                        ContextCompat.getColor(
                                            requireContext(),
                                            R.color.non_active_view_color_grey
                                        )
                                    )
                                    setStrokeColorResource(R.color.non_active_view_color_grey)
                                    setRippleColorResource(R.color.color_transparent)
                                    setOnClickListener {
                                        launch {
                                            viewModel.emailIsCorrectObserver
                                                .drop(0)
                                                .collect { emailIsCorrect ->
                                                    if (emailIsCorrect == true) {
                                                        loginFragmentTextFieldEmail.isErrorEnabled =
                                                            false
                                                    } else {
                                                        loginFragmentTextFieldEmail.error =
                                                            getString(R.string.first_name_error)
                                                        loginFragmentTextFieldEmail.isErrorEnabled =
                                                            true
                                                    }
                                                }
                                        }
                                        launch {
                                            viewModel.passwordIsCorrectObserver
                                                .drop(0)
                                                .collect { passwordIsCorrect ->
                                                    if (passwordIsCorrect == true) {
                                                        loginFragmentTextFieldPassword.isErrorEnabled =
                                                            false
                                                    } else {
                                                        loginFragmentTextFieldPassword.error =
                                                            getString(R.string.log_in_fragment_password_error)
                                                        loginFragmentTextFieldPassword.isErrorEnabled =
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