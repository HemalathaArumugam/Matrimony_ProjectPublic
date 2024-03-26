package com.example.matrimony_project.activity

import HomeAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matrimony_project.R
import com.example.matrimony_project.databinding.ActivityHomescreenBinding
import com.example.matrimony_project.livedata.ProfileLiveData

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var databinding: ActivityHomescreenBinding
    private lateinit var adapter: HomeAdapter
    private lateinit var profileViewModel: ProfileLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_homescreen)
        profileViewModel = ViewModelProvider(this).get(ProfileLiveData::class.java)
        databinding.lifecycleOwner = this
        databinding.binding1 = profileViewModel

        /*databinding.gesturebtn.setOnClickListener { v ->
            val intent = Intent(v.context, GestureActivity::class.java)
            startActivity(intent) // Simplified startActivity call
        }*/

        setupRecyclerView()
        observeProfiles()
    }

    private fun setupRecyclerView() {
        adapter = HomeAdapter(emptyList())
        databinding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        databinding.recyclerview.adapter = adapter
    }

    private fun observeProfiles() {
        profileViewModel.Profiles.observe(this, Observer { profiles ->
            adapter.updateProfiles(profiles)
        })
    }
}
