package com.example.diffutil_with_listadapter
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter: ListAdapter<ProgrammingItem, ProgrammingAdapter.ViewHolder>(Diffutil) {

   companion object{

       object Diffutil: DiffUtil.ItemCallback<ProgrammingItem>(){
           override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
               return oldItem.id == newItem.id
           }

           override fun areContentsTheSame(
               oldItem: ProgrammingItem,
               newItem: ProgrammingItem
           ): Boolean {
               return oldItem == newItem
           }

       }
   }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view = LayoutInflater.from(parent.context).inflate(R.layout.programing_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(item:View):RecyclerView.ViewHolder(item){
        val name :TextView = item.findViewById(R.id.txtName)
        val initialText = item.findViewById<TextView>(R.id.txtoval)

        fun bind(programingitem:ProgrammingItem){
            name.text = programingitem.programingLanguage
            initialText.text = programingitem.initial
        }
    }





}