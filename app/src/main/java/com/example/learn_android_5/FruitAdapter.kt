package com.example.learn_android_5

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

    //创建一个自定义的adapter，继承自ArrayAdapter,
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruits>) :
    ArrayAdapter<Fruits>(activity, resourceId, data) {

        //内部类ViewHolder用来对ImageView和TextView实例进行缓存
        inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

        //getView()方法，这个方法在每个子项被滚动到屏幕内的时候会被调用
        //convertView用于将加载好的布局进行缓存
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewholder: ViewHolder

        if (convertView == null) {
            //LayoutInflater为子项加载布局
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            //获取实例
            //这边必须写成view.findViewById 而不能像之前一样直接写成 findViewById,理由写在Note中
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            //创建一个ViewHolder对象，并将控件的实例存放在ViewHolder里
            viewholder = ViewHolder(fruitImage, fruitName)
            //调用的其实是View.setTag, 将ViewHolder类对象viewholder存放在view中
            view.tag = viewholder
        } else {
            view = convertView
            //从view中取出缓存的viewholder
            viewholder = view.tag as ViewHolder
        }

        //实际上是调用的父类ArrayAdapter方法getItem
        //得到当前项的fruit的实例
        val fruit = getItem(position)
        if (fruit != null) {

            //在Kotlin中，当构造器参数前使用val或var，这些参数会变成类的属性，可以像访问其他属性一样访问它们

            //kotlin语法，实际调用ImageView.setImageResource
            viewholder.fruitImage.setImageResource(fruit.fruitImageId)
            //kotlin语法，实际上调用TextView.setText
            viewholder.fruitName.text = fruit.name

        }
        return view
    }
}