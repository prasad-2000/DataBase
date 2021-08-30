package com.example.loginpage
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper(context: Context): SQLiteOpenHelper(context,"employee.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE EMPLOYEE(ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME VARCHAR2,AGE VARCHAR2)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS EMPLOYEE")
    }
}
