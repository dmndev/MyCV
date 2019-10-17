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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_experience.view.toolbar
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        (activity as AppCompatActivity).setSupportActionBar(root.toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false)

        homeViewModel.person.observe(this, Observer { person ->
            if(person != null) {
                if (person.avatarUrl.isNotEmpty() && person.avatarUrl.isNotBlank())
                    Picasso.get().load(person.avatarUrl).into(root.avatar)

                root.fullName.text =
                    context?.getString(R.string.label_full_name, person.firstName, person.lastName)
                root.phone.text = person.phone
                root.email.text = person.email
                root.aboutMe.text = person.aboutMe
            }
        })

        return root
    }
}