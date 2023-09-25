package com.example.wishlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: List<ItemInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        //========================Start of Button===================
        findViewById<Button>(R.id.SubmitBTN).setOnClickListener {
            val itemsRV = findViewById<RecyclerView>(R.id.listRV)

            var ItemName = findViewById<EditText>(R.id.nameTextbox) //gets the name entered by user
            var ItemPrice = findViewById<EditText>(R.id.priceTextbox) //gets the price entered by user
            var ItemLink = findViewById<EditText>(R.id.linkTextbox) //gets the link entered by user

            //Log.v("Hello $new", "Not working")
            ItemFetch.insItems("${ItemName.text.toString()}", "${ItemPrice.text.toString()}","${ItemLink.text.toString()}")
            items = ItemFetch.getItems() //returns Items in the Fetch class

            val adapter = ItemAdapter(items)
            itemsRV.adapter = adapter
            itemsRV.layoutManager = LinearLayoutManager(this)

            ItemName.getText().clear() //clears user input box
            ItemPrice.getText().clear() //clears user input box
            ItemLink.getText().clear() //clears user input box

        } //========================END of Button===================




    }
}