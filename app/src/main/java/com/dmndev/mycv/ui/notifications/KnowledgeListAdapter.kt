package com.dmndev.mycv.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmndev.mycv.R
import com.dmndev.mycv.model.AdapterModel
import com.dmndev.mycv.model.realm.Experience
import com.dmndev.mycv.model.realm.Knowledge
import kotlinx.android.synthetic.main.item_knowledge.view.*

class KnowledgeListAdapter : RecyclerView.Adapter<KnowledgeListAdapter.KnowledgeViewHolder>() {

    override fun onBindViewHolder(holder: KnowledgeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    private var data: List<Knowledge> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_knowledge, parent, false)
        return KnowledgeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setList(data : List<Knowledge>) {
        this.data = data
        notifyDataSetChanged()
    }

    class KnowledgeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Knowledge) = with(itemView) {
            knowledgeName.text = item.name
        }
    }
}