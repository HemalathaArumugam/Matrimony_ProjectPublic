package com.example.matrimony_project.activity

import ProfilePhotoAdapter
import Utils
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matrimony_project.R
import com.example.matrimony_project.databinding.ActivityProfiledetailsBinding
import com.example.matrimony_project.livedata.ProfileData
import com.example.matrimony_project.livedata.ProfileLiveData

class ProfileDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfiledetailsBinding
    private lateinit var viewModel: ProfileLiveData
    private lateinit var adapter: ProfilePhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profiledetails)
        viewModel = ViewModelProvider(this).get(ProfileLiveData::class.java)
        binding.lifecycleOwner = this


        adapter = ProfilePhotoAdapter(emptyList())

        // Setup RecyclerView
        binding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerview.adapter = adapter
        val profileData: ProfileData? = viewModel.Profiles.value?.getOrNull(0) // Get the first profile data from LiveData
        binding.profilephoto = profileData


        viewModel.Profiles.observe(this) { profiles ->
            profiles?.let {
                if (profiles.isNotEmpty()) {
                    // Get the first profile data from the list
                    val firstProfile = profiles[0]
                    // Set the profilephoto binding variable
                    binding.profilephoto = firstProfile

                    // Update RecyclerView Adapter with the related images of the first profile
                    adapter.updateList(firstProfile.relatedImages)
                }
            }
        }




        val profile = intent.getParcelableExtra<ProfileData>("photo")
        profile?.let {
            Log.i("Profile Name", it.name ?: "No name provided")
            Log.i("Third Image", it.relatedImages.getOrNull(2)?.toString() ?: "No third image")
        }

        val relatedImages = intent.getIntegerArrayListExtra("relatedImages")
        Log.i("Related Images", relatedImages?.toString() ?: "No related images")

        setupRecyclerView(relatedImages, profile)
        observeProfiles()
    }

    private fun setupRecyclerView(relatedImages: ArrayList<Int>?, profile: ProfileData?) {
        profile?.let {
            relatedImages?.let { images ->
                adapter.updateList(images)
            }
        }
    }

    private fun observeProfiles() {
        viewModel.Profiles
            .observe(this, Observer { profiles ->
            profiles?.let {
                adapter.updateList(profiles.flatMap { it.relatedImages })
            }
        })
    }
}
