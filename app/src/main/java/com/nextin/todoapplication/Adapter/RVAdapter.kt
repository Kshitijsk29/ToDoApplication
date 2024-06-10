package com.nextin.todoapplication.Adapter
import android.app.Activity
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.each_item_task_layout ,parent,false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = arrayList[position]
        holder.task.text = item.task

        holder.task.isChecked = fromIntToBoolean(item.status)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyViewHolder(viewItem : View) :RecyclerView.ViewHolder(viewItem){

        val task: CheckBox = viewItem.findViewById(R.id.taskCheckBox)
    }

    private fun fromIntToBoolean(value :Int):Boolean{
        return value != 0
    }
}
