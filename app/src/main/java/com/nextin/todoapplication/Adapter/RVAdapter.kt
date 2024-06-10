package com.nextin.todoapplication.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.nextin.todoapplication.R
import com.nextin.todoapplication.model.TodoTasks

class RVAdapter (var arrayList: ArrayList<TodoTasks> , var context :Activity)
    :RecyclerView.Adapter<RVAdapter.MyViewHolder>()
{

    class MyViewHolder(viewItem : View) :RecyclerView.ViewHolder(viewItem){

        val task = viewItem.findViewById<CheckBox>(R.id.taskCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RVAdapter.MyViewHolder {
        val itemsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.new_task_layout ,parent,false)
        return MyViewHolder(itemsView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = arrayList[position]
        holder.task.text = item.task

        holder.task.isChecked = fromIntToBoolean(item.status)
    }

    fun fromIntToBoolean(  value :Int):Boolean{
        return value != 0
    }
}
