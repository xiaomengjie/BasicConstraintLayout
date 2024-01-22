package com.xiao.today.basicconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class PracticeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var currentSelectedView: TextView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        textView1 = findViewById<TextView>(R.id.text1).apply {
            currentSelectedView = this
            setOnClickListener(this@PracticeActivity)
        }
        textView2 = findViewById<TextView>(R.id.text2).apply {
            setOnClickListener(this@PracticeActivity)
        }

        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.text1 -> {
                currentSelectedView = textView1
            }
            R.id.text2 -> {
                currentSelectedView = textView2
            }
            R.id.button1, R.id.button2 -> changeText(view.id)
        }
    }

    private fun changeText(id: Int) {
        when(id){
            R.id.button1 -> {
                val text = currentSelectedView.text
                currentSelectedView.text = text.dropLast(1)
            }
            R.id.button2 -> {
                val text = currentSelectedView.text
                currentSelectedView.text = text.padEnd(text.length + 1, text[0])
            }
        }
    }
}