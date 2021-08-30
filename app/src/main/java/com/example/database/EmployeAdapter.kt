package com.example.database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.employee_card.view.*

class EmployeAdapter(val context: Context,var EmployeeList:ArrayList<DataClassEmplo>):RecyclerView.Adapter<EmployeAdapter.view>() {
    inner class view(var inner_view: View):RecyclerView.ViewHolder(inner_view){

        fun data(c:DataClassEmplo?,pos:Int){
            itemView.display_id.text = "ID : "+ c?.id
            itemView.display_name.text = "Name : "+ c?.name
            itemView.display_age.text = "Age : "+ c?.age
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): view {
        var v = LayoutInflater.from(context).inflate(R.layout.employee_card,parent,false)
        return view(v)
    }

    override fun onBindViewHolder(holder: view, position: Int) {
        var item =EmployeeList[position]
        holder.data(item,position)

    }

    override fun getItemCount(): Int {
        return  EmployeeList.size
    }
}