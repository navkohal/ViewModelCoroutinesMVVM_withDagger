package com.example.mydaggerdemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.coroutineswithmvvm.R
import com.example.coroutineswithmvvm.models.Products
import kotlinx.android.synthetic.main.list_item_layout.view.*

//import kotlinx.android.synthetic.main.list_item_layout.view.*


class RepositoryAdapter(): RecyclerView.Adapter<RepositoryAdapter.MyViewHolder>() {

    private var listData : List<Products>? = null

    fun setUpdateData(listData : List<Products>){
        this.listData = listData
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val imageView = view.imageView
        val name =  view.name
        val description = view.decription

        fun bind(data: Products){
            name.setText(data.title)
            description.setText(data.description)

            Glide.with(imageView)
                .load(data.image!!)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate((R.layout.list_item_layout), parent , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if(listData==null)return 0
        else return listData?.size!!
    }

}