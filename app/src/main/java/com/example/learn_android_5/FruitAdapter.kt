package com.example.learn_android_5

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

    //创建一个自定义的adapter，继承自ArrayAdapter,
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruits>) :
    ArrayAdapter<Fruits>(activity, resourceId, data) {

        //getView()方法，这个方法在每个子项被滚动到屏幕内的时候会被调用
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //LayoutInflater为子项加载布局
        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)

        //获取实例
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)

        //实际上是调用的父类ArrayAdapter方法getItem
        //得到当前项的fruit的实例
        val fruit = getItem(position)
        if (fruit != null) {
            //kotlin语法，实际调用ImageView.setImageResource
            fruitImage.setImageResource(fruit.fruitImageId)
            //kotlin语法，实际上调用TextView.setText
            fruitName.text = fruit.name
        }
        return view
    }
}