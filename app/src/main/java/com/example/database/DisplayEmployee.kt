package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginpage.DataHelper
import kotlinx.android.synthetic.main.employee_recycle.*
import java.util.zip.DataFormatException

class DisplayEmployee : AppCompatActivity() {
    lateinit var EAdapter :EmployeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.employee_recycle)
        var tempContactModel=ArrayList<DataClassEmplo>()

        var helper = DataHelper(this)
        var db = helper.readableDatabase
        var res = db.rawQuery("SELECT * FROM EMPLOYEE", null)

        while(res.moveToNext())
        {
            var x = res.getColumnIndex("ID")
            var y = res.getColumnIndex("NAME")
            var z = res.getColumnIndex("AGE")
            var name = DataClassEmplo(
                res.getString(x).toString(), res.getString(y).toString(), res.getString(z).toString()
            )
            tempContactModel.add(name)
        }
        res.close()


        var layoutmanager = LinearLayoutManager(this)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL
        employee_view.layoutManager = layoutmanager
        EAdapter = EmployeAdapter(this, tempContactModel)
        employee_view.adapter = EAdapter

    }
}