package com.tsfrsapp.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.tsfrsapp.R
import com.tsfrsapp.data.LocationModel
import com.tsfrsapp.databinding.ActivityEditProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditProfileActivity : AppCompatActivity() {
    private val viewModel: EditProfileViewModel by viewModels()
    private lateinit var _binding: ActivityEditProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this,R.layout.activity_edit_profile)
        lifecycleScope.launch {
            viewModel.getAllLocations().collect{
                _binding.textView.text = "Size : ${it.size}"
            }
        }
        _binding.button.setOnClickListener {
            var location = LocationModel(
                id = 1,
                zoneID = 1,
                zoneName = "Z1",
                districtID = 1,
                districtName = "D1",
                mandalID = 1,
                mandalName = "M1"
            )
            lifecycleScope.launch {
                viewModel.insertLocation(location).collect {
                    Toast.makeText(this@EditProfileActivity,"$it",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}