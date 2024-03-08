package com.example.calender_prac

import android.app.Application
import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var day: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        val dayText = findViewById<TextView>(R.id.day_text)
        val memoEditText = findViewById<EditText>(R.id.memoEdit)

        val dateFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        var date: Date = Date(calendarView.date)
        dayText.text = dateFormat.format(date)

        day = dateFormat.format(date)
        calendarView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            MyApplication.preferences.setString(day, memoEditText.text.toString())

            day = "${year}-${month}-${dayOfMonth}"
            dayText.text = day

//            runOnUiThread {
//                date = Date(calendarView.date)
//                dayText.text = dateFormat.format(date)
//            }
            val memo = MyApplication.preferences.getString(day, "")
            memoEditText.setText(memo)
        }

        val datePicker = findViewById<DatePicker>(R.id.date_picker_actions)

        val iYear = datePicker.year
        val iMonth = datePicker.month
        val iDay = datePicker.dayOfMonth

    }
}

