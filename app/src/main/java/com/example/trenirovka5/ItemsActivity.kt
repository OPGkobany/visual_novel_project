package com.example.trenirovka5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()
        val buttonProject: Button = findViewById(R.id.buttonItemsProject)

        items.add(Item(1, "grib", "СТАРИЧОК-БОРОВИЧОК", "Невероятные приключения старичка-боровичка в магическом лесу",
            "В новой главе Старичок-боровичок уходит в лес от цивиллизации\n" +
                    "Ради какой цели он решил анонимно посещать университеты и аэропорта?"))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items,this)

        buttonProject.setOnClickListener {
            val intentItem = Intent(this, ProjectActivity::class.java)
            startActivity(intentItem)
        }
    }
}