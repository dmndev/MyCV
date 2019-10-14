package com.dmndev.mycv.ui.notifications

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
import kotlinx.android.synthetic.main.fragment_dashboard.view.cvList
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class KnowledgeFragment : Fragment() {

    private lateinit var notificationsViewModel: KnowledgeViewModel
    val adapter = KnowledgeListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(KnowledgeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        root.cvList.adapter = adapter
        root.cvList.layoutManager = LinearLayoutManager(context)

        notificationsViewModel.text.observe(this, Observer {
            adapter.setList(it)
        })
        return root
    }
}