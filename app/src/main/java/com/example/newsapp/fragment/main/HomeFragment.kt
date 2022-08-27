package com.example.newsapp.fragment.main

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.R
import com.example.newsapp.adapter.TabLayoutAdapter
import com.example.newsapp.databinding.BackLayoutBinding
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.util.ObjectList
import com.example.newsapp.util.ObjectList.arr
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val tabLayoutAdapter = TabLayoutAdapter()
        tabLayoutAdapter.submitList(ObjectList.newsImagesList())
        binding.viewPager.adapter = tabLayoutAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            val bind = BackLayoutBinding.inflate(layoutInflater)
            tab.customView = bind.root
            bind.texts.text = arr[pos]
            if (pos == 0) {
                bind.backs.visibility = View.VISIBLE
                bind.texts.setTextColor(Color.WHITE)
            } else {
                bind.backs.visibility = View.INVISIBLE
                bind.texts.setTextColor(Color.parseColor("#475AD7"))
            }
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val bind = BackLayoutBinding.bind(tab?.customView!!)
                bind.backs.visibility = View.VISIBLE
                bind.texts.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val bind = BackLayoutBinding.bind(tab?.customView!!)
                bind.backs.visibility = View.INVISIBLE
                bind.texts.setTextColor(Color.parseColor("#475AD7"))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) { }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}