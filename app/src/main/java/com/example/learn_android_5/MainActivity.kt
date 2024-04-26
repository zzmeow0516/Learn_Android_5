package com.example.learn_android_5

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

//    private val data = listOf(
//        "Apple", "Banana", "Orange", "Watermelon",
//        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",

//        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
//        "Pineapple", "Strawberry", "Cherry", "Mango"
//    )

    private val fruitList = ArrayList<Fruits>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        //集合中的数据无法直接传递给listview，需要借助adapter
//        //第二个参数simple_list_item_1是 listview子布局的id，这个布局包含一行textview
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
//        val listView: ListView = findViewById(R.id.listView1)
//        //kotlin专属操作，取代java getter/setter
//        listView.adapter = adapter

        initFruits()

        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        val listview: ListView = findViewById(R.id.listView1)
        listview.adapter = adapter

        //setOnItemClickListener接收一个OnItemClickListener参数，这个参数其实是一个java单抽象方法接口
        //因为我们在这里直接用到了Java函数式API,
        //OnItemClickListener接口的唯一方法OnItemClick的参数就是下面四个
        //没有用到的参数可以直接用 _ 代替，这里为了突出参数就没有代替
        listview.setOnItemClickListener { parent, view, position, id ->
            view.setBackgroundColor(Color.RED)
            val fruitItem = fruitList[position]
            Toast.makeText(this, fruitItem.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
        repeat(1000) {
            fruitList.add(Fruits("Apple", R.drawable.apple_pic))
            fruitList.add(Fruits("Banana", R.drawable.banana_pic))
            fruitList.add(Fruits("Orange", R.drawable.orange_pic))
            fruitList.add(Fruits("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruits("Pear", R.drawable.pear_pic))
            fruitList.add(Fruits("Grape", R.drawable.grape_pic))
            fruitList.add(Fruits("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruits("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruits("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruits("Mango", R.drawable.mango_pic))
        }
    }
}