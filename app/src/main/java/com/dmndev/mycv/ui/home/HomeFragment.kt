package com.dmndev.mycv.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dmndev.mycv.R
import com.dmndev.mycv.utils.SectionListAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val adapter = SectionListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as AppCompatActivity).setSupportActionBar(root.toolbar)
        homeViewModel.list.observe(this, Observer {
            adapter.setList(it)
        })
        return root
    }
}