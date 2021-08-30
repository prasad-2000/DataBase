package com.example.database

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.loginpage.DataHelper
import kotlinx.android.synthetic.main.employee_add.*

class addEmployee : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_add)
       var helper= DataHelper(this)
        var dataTable=helper.readableDatabase
        add2.setOnClickListener {
            var Ename = name.text.toString()
            var Eid = id.text.toString()
            var Eage = age.text.toString()
            if(Ename.isNotEmpty()&& Eid.isNotEmpty() && Eage.isNotEmpty()){
                var cv =ContentValues()
                cv.put("ID",Eid)
                cv.put("NAME",Ename)
                cv.put("AGE",Eage)
                dataTable.insert("EMPLOYEE",null,cv)
                Toast.makeText(this,"Added Successfully",Toast.LENGTH_SHORT).show()
                val i =Intent(this,MainActivity::class.java)
                startActivity(i)
            }else{
                Toast.makeText(this,"Enter Employee Details Carefully",Toast.LENGTH_SHORT).show()
            }
        }
    }
}