package com.example.basedaggerapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.basedaggerapp.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment: DaggerFragment() {

  companion object {
    fun newInstance() = MainFragment()
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel by viewModels<MainViewModel> { viewModelFactory }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return inflater.inflate(R.layout.main_fragment, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    var status: String
    btnLogin.setOnClickListener {
      val user = editTextUser.text.toString()
      val password = editTextPassword.text.toString()
      status = if (viewModel.test(user, password)) {
        "Login Success"
      } else {
        "Login Error"
      }
      Toast.makeText(context, status, Toast.LENGTH_SHORT).show()
    }
  }

}