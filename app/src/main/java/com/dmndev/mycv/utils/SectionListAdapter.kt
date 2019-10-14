package com.dmndev.mycv.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmndev.mycv.R
import com.dmndev.mycv.model.realm.AdapterModel
import kotlinx.android.synthetic.main.item_experience.view.*
import kotlinx.android.synthetic.main.item_experience.view.name
import kotlinx.android.synthetic.main.item_hobby.view.*
import kotlinx.android.synthetic.main.item_knowledge.view.*
import kotlinx.android.synthetic.main.item_label.view.*

class SectionListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> (holder as LabelViewHolder).bind(data[position])
            1 -> (holder as ExperienceViewHolder).bind(data[position])
            2 -> (holder as KnowledgeViewHolder).bind(data[position])
            3 -> (holder as HobbyViewHolder).bind(data[position])
            else -> (holder as LabelViewHolder).bind(data[position])
        }
    }

    var data: List<AdapterModel> = arrayListOf()

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = data[position]
        return when {
            item.label != null -> 0
            item.experience != null -> 1
            item.knowledge != null -> 2
            item.hobbies != null -> 3
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> getLabelViewHolder(parent)
            1 -> getExperienceViewHolder(parent)
            2 -> getKnowledgeViewHolder(parent)
            3 -> getHobbyViewHolder(parent)
            else -> getLabelViewHolder(parent)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    private fun getLabelViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_label, parent, false)
        return LabelViewHolder(v)
    }

    private fun getExperienceViewHolder(parent: ViewGroup): ExperienceViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(v)
    }

    private fun getKnowledgeViewHolder(parent: ViewGroup): KnowledgeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_knowledge, parent, false)
        return KnowledgeViewHolder(v)
    }

    private fun getHobbyViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_hobby, parent, false)
        return HobbyViewHolder(v)
    }
    fun setList(data : List<AdapterModel>) {
        this.data = data
        notifyDataSetChanged()
    }


    class LabelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {
            label.text = item.label
        }
    }

    class ExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {
            dateFrom.text = item.experience?.startDate?.formatToString()
            dateTo.text = item.experience?.endDate?.formatToString()
            name.text = item.experience?.name
            description.text = item.experience?.description
        }
    }

    class KnowledgeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {
            knowledgeName.text = item.knowledge?.name
        }
    }

    class HobbyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {
            hobbyName.text = item.hobbies?.name
        }
    }

}