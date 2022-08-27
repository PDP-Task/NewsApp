package com.example.newsapp.fragment.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapp.R
import com.example.newsapp.activity.HomeActivity
import com.example.newsapp.activity.MainActivity
import com.example.newsapp.adapter.TopicAdapter
import com.example.newsapp.databinding.FragmentThirdFragmetnBinding
import com.example.newsapp.manager.SharedPref
import com.example.newsapp.util.ObjectList


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdFragmetnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdFragmetnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    private fun initViews() {
        val sharedPref = SharedPref(requireContext())
        val topicAdapter = TopicAdapter()
        topicAdapter.submitList(ObjectList.topicList())
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = topicAdapter
        binding.btnNext.setOnClickListener {
            val activity = (activity as MainActivity)
            activity.startActivity(Intent(activity, HomeActivity::class.java))
            activity.finish()
            sharedPref.saveFinish(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}