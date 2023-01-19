package com.example.myapplication


import android.app.AlertDialog
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class Order : Fragment(R.layout.fragment_order) {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout=view.findViewById(R.id.tabLayout2)
        viewPager=view.findViewById(R.id.viewPager)
        viewPager.adapter=ViewPagerAdapter(this.requireActivity())
        TabLayoutMediator(tabLayout,viewPager){tab,index->
            tab.text=when(index){
                0->{"შეკვეთა"}
                1->{"პროფილი"}
                else -> {throw Resources.NotFoundException("ხარვეზი")
                }
            }
        }.attach()
    }
}
