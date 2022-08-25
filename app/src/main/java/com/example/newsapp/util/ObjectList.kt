package com.example.newsapp.util

import com.example.newsapp.R

object ObjectList {
    fun imageList(): List<Int> {
        return listOf(
            R.drawable.img2,
            R.drawable.img1,
            R.drawable.img3,
        )
    }

    fun topicList(): List<String> {
        return listOf(
            "\uD83C\uDFC8   Sports",
            "⚖️   Politics",
            "\uD83C\uDF1E   Life",
            "\uD83C\uDFAE   Gaming",
            "\uD83D\uDC3B   Animals",
            "\uD83C\uDF34   Nature",
            "\uD83C\uDF54   Food",
            "\uD83C\uDFA8   Art",
            "\uD83D\uDCDC   History",
            "\uD83D\uDC57   Fashion",
        )
    }
}