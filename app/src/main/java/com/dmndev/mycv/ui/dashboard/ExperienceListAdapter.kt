package com.dmndev.mycv.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmndev.mycv.R
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.utils.formatToString
import kotlinx.android.synthetic.main.item_experience.view.*

class ExperienceListAdapter : RecyclerView.Adapter<ExperienceListAdapter.ExperienceViewHolder>() {

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.bind(data[position])
    }

    private var data: List<Experience> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setList(data : List<Experience>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Experience) = with(itemView) {

            dateFrom.text = item.startDate?.formatToString()
            dateTo.text = item.endDate?.formatToString()
            name.text = item.name
            description.text = item.description
        }
    }
}