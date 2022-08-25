package com.example.newsapp.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.R
import com.example.newsapp.activity.MainActivity
import com.example.newsapp.adapter.ImageAdapter
import com.example.newsapp.databinding.FragmentFirstBinding
import com.example.newsapp.util.ObjectList
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle
import kotlin.math.abs

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        val viewPager: ViewPager2 = (activity as MainActivity).findViewById(R.id.viewPager)
        val imageAdapter = ImageAdapter()
        imageAdapter.submitList(ObjectList.imageList())
        val transformer = CompositePageTransformer()
        transformer.addTransformer { page, pos ->
            val r = 1 - abs(pos)
            page.scaleY = 0.85f + r * 0.27f
        }
        binding.viewPager2.apply {
            adapter = imageAdapter
            offscreenPageLimit = 3
            clipChildren = false
            clipToPadding = false
            setPageTransformer(transformer)
        }
        binding.indicator.apply {
            setSliderColor(R.color.gray, R.color.blue)
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.CIRCLE)
            setupWithViewPager(binding.viewPager2)
            setSliderWidth(resources.getDimension(R.dimen.width))
            setSliderHeight(resources.getDimension(R.dimen.height))
        }
        binding.btnNext.setOnClickListener {
            viewPager.currentItem = 1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}