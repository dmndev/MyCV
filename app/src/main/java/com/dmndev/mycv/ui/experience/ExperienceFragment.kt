package com.dmndev.mycv.ui.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmndev.mycv.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import javax.inject.Inject

class ExperienceFragment : Fragment() {

    private lateinit var dashboardViewModel: ExperienceViewModel
    @Inject
    lateinit var adapter: ExperienceListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

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

        dashboardViewModel.experienceList.observe(this, Observer {
            adapter.setList(it)
        })

        return root
    }
}