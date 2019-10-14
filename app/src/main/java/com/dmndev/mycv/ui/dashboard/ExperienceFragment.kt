package com.dmndev.mycv.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmndev.mycv.R
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class ExperienceFragment : Fragment() {

    private lateinit var dashboardViewModel: ExperienceViewModel
    private val adapter: ExperienceListAdapter = ExperienceListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(ExperienceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        (activity as AppCompatActivity).setSupportActionBar(root.toolbar)

        root.cvList.adapter = adapter
        root.cvList.layoutManager = LinearLayoutManager(context)
        dashboardViewModel.text.observe(this, Observer {
            adapter.setList(it)
        })

        return root
    }
}