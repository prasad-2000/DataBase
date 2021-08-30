package com.example.database

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginpage.DataHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_employee.*

class updateEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)
        val helper =DataHelper(this)
        val dataTable = helper.readableDatabase
        update2.setOnClickListener {
            var age = age2.text.toString()
            val uName = updateName.text.toString()
            var arg = listOf<String>(uName).toTypedArray()
            var rs = dataTable.rawQuery("SELECT NAME FROM EMPLOYEE WHERE NAME=?", arg)
            if (uName.isEmpty())
                updateName.error="Enter Name"
            else if(rs.moveToNext()){
                val cv = ContentValues()
                cv.put("AGE", age)
                dataTable.update("EMPLOYEE",cv,"NAME=?",arg)
                Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            else{
                Toast.makeText(this,"Name Doesn't Exist",Toast.LENGTH_SHORT).show()
            }
            dataTable.close()
        }
    }
}