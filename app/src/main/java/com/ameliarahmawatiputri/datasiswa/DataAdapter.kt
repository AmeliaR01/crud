package com.ameliarahmawatiputri.datasiswa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_update_add.*

class DataAdapter (val data: List<DataItem>?, private val click: onClickItem) :
    RecyclerView.Adapter<DataAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyHolder(view)
    }



    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.onBind(data?.get(position))
        holder.itemView.setOnClickListener() {
            click.clicked(data?.get(position))
        }
        holder.itemView.btnHapus.setOnClickListener() {
            click.delete(data?.get(position))
        }

    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(get: DataItem?) {
            itemView.tvNama.text = get?.siswaNama
            itemView.tvKelas.text = get?.siswaKelas
        }
    }

    interface onClickItem {
        fun clicked(item: DataItem?)
        fun delete(item: DataItem?)
    }
}


