package com.example.mechat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class sliderAdapter(frag:FragmentActivity): FragmentStateAdapter(frag) {
    override fun getItemCount(): Int {
         return 2
    }

    override fun createFragment(position: Int): Fragment=when(position) {

            0 ->  ChatsFragment()

           else -> ContactsFragment()
        }
    }




