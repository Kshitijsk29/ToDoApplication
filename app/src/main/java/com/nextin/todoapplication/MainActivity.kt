package com.nextin.todoapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.nextin.todoapplication.Adapter.RVAdapter
import com.nextin.todoapplication.model.TodoTasks

class MainActivity : AppCompatActivity() {
    lateinit var  recyclerView: RecyclerView
    lateinit var taskList :ArrayList<TodoTasks>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView.layoutManager = LinearLayoutManager(this)

        taskList = arrayListOf()

        val newsArticleArray = arrayOf(
            "Japan’s Nikkei breaks 35,000 for first time in nearly 34 years",
            "How do I turn on the Developer Options ",
            "Makar Sankranti 2024: From Dates to Timings, ",
            "‘Ready for an upgrade but finding it hard to say bye? ",
            "IGNOU to hold placement drive for Insurance Dekho on January 16",
            "Mark Zuckerberg’s project to produce macadamia "
        )


        for(index in taskList.indices)
        {
            val task = TodoTasks(1,0, newsArticleArray[index])
            taskList.add(task)

        }

        recyclerView.adapter = RVAdapter(taskList,this)

    }
}