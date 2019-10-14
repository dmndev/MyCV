package com.dmndev.mycv.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmndev.mycv.R
import com.dmndev.mycv.model.AdapterModel
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import com.dmndev.mycv.model.ModelType
import kotlinx.android.synthetic.main.item_experience.view.*
import kotlinx.android.synthetic.main.item_experience.view.name
import kotlinx.android.synthetic.main.item_knowledge.view.*

class SectionListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType){
            0 -> (holder as ExperienceViewHolder).bind(data[position])
            1 -> (holder as KnowledgeViewHolder).bind(data[position])
            else -> (holder as ExperienceViewHolder).bind(data[position])
        }
    }

    var data: List<AdapterModel> = arrayListOf()

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        val item = data[position]

        return when(item.modelType) {
            ModelType.EXPERIENCE -> 0
            ModelType.KNOWLEDGE -> 1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> getExperienceViewHolder(parent)
            1 -> getKnowledgeViewHolder(parent)
            else -> getExperienceViewHolder(parent)
        }
    }


    override fun getItemCount(): Int {
        return data.size
    }

    private fun getExperienceViewHolder(parent: ViewGroup): ExperienceViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(v)
    }

    private fun getKnowledgeViewHolder(parent: ViewGroup): KnowledgeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_knowledge, parent, false)
        return KnowledgeViewHolder(v)
    }

    fun setList(data : List<AdapterModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ExperienceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {

            dateFrom.text = (item as Experience).startDate?.formatToString()
            dateTo.text = item.endDate?.formatToString()
            name.text = item.name
            description.text = item.description
        }
    }

    class KnowledgeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: AdapterModel) = with(itemView) {
            knowledgeName.text = (item as Knowledge).name
        }
    }
}