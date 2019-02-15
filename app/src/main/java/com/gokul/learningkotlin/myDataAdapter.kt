package com.gokul.learningkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.single_card.view.*

class myDataAdapter(val myList: List<myList>) :RecyclerView.Adapter<myDataAdapter.myListviewholder>(){

    class myListviewholder(val singlecard: View) : RecyclerView.ViewHolder(singlecard)
    //create view holder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): myListviewholder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.single_card,p0, false)
        return myListviewholder(view)
    }

    //here specify the content for each item
    override fun onBindViewHolder(itemHolder: myListviewholder, index: Int) {
        val vlaue = myList[index]
            itemHolder?.singlecard.iv_title.text = vlaue.title
            itemHolder?.singlecard.iv_description.text = vlaue.des
            itemHolder?.singlecard.iv_icon.setImageResource(vlaue.resid)
    }
    override fun getItemCount(): Int = myList.size
}