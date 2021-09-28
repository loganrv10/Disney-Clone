package com.example.anushmp.coldstarmovieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment


class SportsFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SportsFragment().apply {

            }
    }
}