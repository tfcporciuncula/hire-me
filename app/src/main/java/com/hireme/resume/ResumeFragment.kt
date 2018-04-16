package com.hireme.resume

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hireme.R

class ResumeFragment : Fragment() {

    companion object {
        val TAG: String = ResumeFragment::class.java.name

        fun newInstance() = ResumeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_resume, container, false)
    }
}
