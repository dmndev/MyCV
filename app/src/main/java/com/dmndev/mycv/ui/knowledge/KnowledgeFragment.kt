package com.dmndev.mycv.ui.knowledge

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
import kotlinx.android.synthetic.main.fragment_dashboard.view.cvList
import kotlinx.android.synthetic.main.fragment_knowledge.view.*
import javax.inject.Inject

class KnowledgeFragment : Fragment() {

    private lateinit var notificationsViewModel: KnowledgeViewModel
    @Inject
    lateinit var adapter : KnowledgeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(KnowledgeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_knowledge, container, false)

        (activity as AppCompatActivity).setSupportActionBar(root.toolbar)

        root.cvList.adapter = adapter
        root.cvList.layoutManager = LinearLayoutManager(context)

        notificationsViewModel.knowledgeList.observe(this, Observer {
            adapter.setList(it)
        })
        return root
    }
}