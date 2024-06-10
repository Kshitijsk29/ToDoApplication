package com.nextin.todoapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nextin.todoapplication.Adapter.RVAdapter
import com.nextin.todoapplication.model.TodoTasks

class MainActivity : AppCompatActivity() {
   private lateinit var  recyclerView: RecyclerView
   private lateinit var taskList :ArrayList<TodoTasks>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.reView)

        taskList = arrayListOf()

        recyclerView.adapter = RVAdapter(taskList,this)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val tasksHeading = arrayOf(
            "Japan’s Nikkei breaks 35,000 for first time in nearly 34 years",
            "How do I turn on the Developer Options menu on my Samsung Galaxy device?",
            "Makar Sankranti 2024: From Dates to Timings, ",
            "‘Ready for an upgrade but finding it hard to say bye? ",
            "IGNOU to hold placement drive for Insurance Dekho on January 16",
            "Mark Zuckerberg’s project to produce macadamia ",
            "Japan’s Nikkei breaks 35,000 for first time in nearly 34 years",
            "How do I turn on the Developer Options menu on my Samsung Galaxy device?",
            "Makar Sankranti 2024: From Dates to Timings, ",
            "‘Ready for an upgrade but finding it hard to say bye? ",
            "IGNOU to hold placement drive for Insurance Dekho on January 16",
            "Mark Zuckerberg’s project to produce macadamia ",
            "Japan’s Nikkei breaks 35,000 for first time in nearly 34 years",
            "How do I turn on the Developer Options menu on my Samsung Galaxy device?"
        )

        for (index in tasksHeading.indices){
            val task = TodoTasks(1,0, tasksHeading[index])
            taskList.add(task)
        }

    }
}