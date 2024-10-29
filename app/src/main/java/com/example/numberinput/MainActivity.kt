package com.example.numberinput

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//class MainActivity : AppCompatActivity() {
//    private lateinit var editText: EditText
//    private lateinit var textView: TextView
//    private lateinit var radioGroup: RadioGroup
//    private lateinit var button: Button
//    private lateinit var listView: ListView
//    private val numbersList = mutableListOf<Int>()
//    private lateinit var adapter: ArrayAdapter<Int>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        editText = findViewById(R.id.editText)
//        textView = findViewById(R.id.textView)
//        radioGroup = findViewById(R.id.radioGroup)
//        button = findViewById(R.id.button)
//
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbersList)
//        listView.adapter = adapter
//
//        button.setOnClickListener {
//            calculateResult()
//        }
//    }
//
//    private fun calculateResult() {
//        textView.text = ""
//
//        val inputText = editText.text.toString()
//        if (inputText.isEmpty()) {
//            textView.error = "Chưa nhập số"
//            return
//        }
//
//        val number = inputText.toIntOrNull()
//        if (number == null || number < 0) {
//            textView.error = "Không hợp lệ"
//            return
//        }
//
//        numbersList.clear()
//
//        when (radioGroup.checkedRadioButtonId) {
//            R.id.even -> {
//                for (i in 1..number) {
//                    if (i % 2 == 0) numbersList.add(i)
//                }
//            }
//            R.id.odd -> {
//                for (i in 1..number) {
//                    if (i % 2 != 0) numbersList.add(i)
//                }
//            }
//            R.id.square -> {
//                var i = 1
//                while (i * i <= number) {
//                    numbersList.add(i * i)
//                    i++
//                }
//            }
//        }
//
//        adapter.notifyDataSetChanged()
//
//        editText.text.clear()
//    }
//}

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var button: Button
    private lateinit var listView: ListView
    private lateinit var textView: TextView
    private val numbersList = mutableListOf<Int>()
    private lateinit var adapter: ArrayAdapter<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        radioGroup = findViewById(R.id.radioGroup)
        button = findViewById(R.id.button)
        listView = findViewById(R.id.listView)
        textView = findViewById(R.id.textView)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbersList)
        listView.adapter = adapter

        button.setOnClickListener {
            processInput()
        }
    }

    private fun processInput() {
        textView.text = ""
        val inputText = editText.text.toString()
        if (inputText.isEmpty()) {
            textView.text = "Chưa nhập số"
            return
        }

        val number = inputText.toIntOrNull()
        if (number == null || number < 0) {
            textView.text = "Không hợp lệ"
            return
        }

        numbersList.clear()

        when (radioGroup.checkedRadioButtonId) {
            R.id.even -> {
                for (i in 1..number) {
                    if (i % 2 == 0) numbersList.add(i)
                }
            }
            R.id.odd -> {
                for (i in 1..number) {
                    if (i % 2 != 0) numbersList.add(i)
                }
            }
            R.id.square -> {
                var i = 1
                while (i * i <= number) {
                    numbersList.add(i * i)
                    i++
                }
            }
        }

        adapter.notifyDataSetChanged()

        editText.text.clear()
    }
}