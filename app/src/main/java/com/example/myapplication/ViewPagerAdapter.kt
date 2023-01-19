package com.example.myapplication

import android.content.res.Resources.NotFoundException
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.inner.OrderFragment
import com.example.myapplication.inner.ProfileFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {OrderFragment()}
            1 -> {ProfileFragment()}
            else -> { throw NotFoundException("ხარვეზი!") }
        }
    }
}