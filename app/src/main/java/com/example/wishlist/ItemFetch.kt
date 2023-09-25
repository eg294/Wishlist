package com.example.wishlist

import android.util.Log

class ItemFetch {
        companion object {
            var N = ""
            var P = ""
            var W = ""
            fun getItems(): MutableList<ItemInfo> {
                var items: MutableList<ItemInfo> = ArrayList()

                val item = ItemInfo(N, P, W)
                items.add(item)

                return items

            }

            fun insItems(Name: String,Price: String,Web: String) {
                N = Name
                P = Price
                W = Web

                //Log.v("Hello $N,$P,$W", "Not working")

            }
        }
}