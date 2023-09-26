package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var items = ArrayList<ItemInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val itemsRV = findViewById<RecyclerView>(R.id.listRV)

        var ItemName = findViewById<EditText>(R.id.nameTextbox) //gets the name entered by user
        var ItemPrice = findViewById<EditText>(R.id.priceTextbox) //gets the price entered by user
        var ItemLink = findViewById<EditText>(R.id.linkTextbox) //gets the link entered by user



        itemsRV.layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapter(items)
        itemsRV.adapter = adapter

        //========================Start of Button===================
        findViewById<Button>(R.id.SubmitBTN).setOnClickListener {


            items.add(
                ItemInfo(
                    ItemName.text.toString(),
                    ItemPrice.text.toString(),
                    ItemLink.text.toString()
                )
            )

            adapter.notifyDataSetChanged()


            ItemName.text.clear() //clears user input box
            ItemPrice.text.clear() //clears user input box
            ItemLink.text.clear() //clears user input box

        } //========================END of Button===================


    }
}
