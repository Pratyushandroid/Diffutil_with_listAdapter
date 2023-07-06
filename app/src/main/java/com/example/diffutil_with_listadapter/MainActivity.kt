package com.example.diffutil_with_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutil_with_listadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val adapter = ProgrammingAdapter()

        val p1 = ProgrammingItem(1,"K","Kotlin")
        val p2 = ProgrammingItem(2,"J","java")
        val p3 = ProgrammingItem(3,"A","Android")
        val p6 = ProgrammingItem(4,"P","Python")

        adapter.submitList(listOf(p1,p2,p3))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p3 = ProgrammingItem(3,"A","Android")
            val p4 = ProgrammingItem(4,"P","Python")
            val p5 = ProgrammingItem(5,"R","Ruby")
            val p6 = ProgrammingItem(6,"JS","javaScript")
            val p7 = ProgrammingItem(7,"N","Nodejs")
            adapter.submitList(listOf(p3,p4,p5,p6,p7))

        },4000)

    }
}