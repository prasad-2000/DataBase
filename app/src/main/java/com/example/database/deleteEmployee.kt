package com.example.database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginpage.DataHelper
import kotlinx.android.synthetic.main.activity_delete_employee.*
import kotlinx.android.synthetic.main.employee_add.*

class deleteEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)
        var helper = DataHelper(this)
        var dataTable = helper.readableDatabase
        delete2.setOnClickListener {
            var idno = id2.text.toString()
            if (idno.isEmpty()) {
                id2.error="Enter ID"
            } else {
                var arg = listOf<String>(idno).toTypedArray()
                var rs = dataTable.rawQuery("SELECT ID FROM EMPLOYEE WHERE ID=?", arg)
                if (rs.moveToNext()) {
                    deleteEmployee(idno)
                    id2.setText("")
                    id2.requestFocus()
                    Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show()
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                }

            }
        }

    }

    private fun deleteEmployee(id: String) {
        var helper1 = DataHelper(this)
        var dbTable = helper1.readableDatabase
        var employeeID = arrayOf(id)
        dbTable.delete("EMPLOYEE", "ID=?", employeeID)
        dbTable.close()

    }
}