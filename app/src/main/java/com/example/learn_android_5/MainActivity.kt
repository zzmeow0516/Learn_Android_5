package com.example.learn_android_5

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val data = listOf(
        "Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //集合中的数据无法直接传递给listview，需要借助adapter
        //第二个参数simple_list_item_1是 listview子布局的id，这个布局包含一行textview
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        val listView: ListView = findViewById(R.id.listView1)
        //kotlin专属操作，取代java getter/setter
        listView.adapter = adapter
    }
}