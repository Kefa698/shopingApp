package com.kefa.myshopingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_list.view.*


class ProductsAdapter(var context: Context, var contacts: List<MyDataClass>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(
                    R.layout.product_list,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = contacts.get(position).Name
        holder.price.text = contacts.get(position).price.toString()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.name
        val price = view.price
    }
}