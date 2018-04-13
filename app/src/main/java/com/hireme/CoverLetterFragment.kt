package com.hireme

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CoverLetterFragment : Fragment() {

    companion object {
        val TAG: String = CoverLetterFragment::class.java.name

        fun newInstance() = CoverLetterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cover_letter, container, false)
    }
}
