package com.example.intentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MoveWithDataActivity : AppCompatActivity() {

	companion object {
//		This constant is used to accept value from main intent
		const val EXTRA_AGE = "extra_age"
		const val EXTRA_NAME = "extra_name"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_move_with_data)

		val tvDataReceived: TextView = findViewById(R.id.activity_move_tv_data_received)

//		getExtra is used to get the data from key on the intent's const 
		val name = intent.getStringExtra(EXTRA_NAME)
		val age = intent.getIntExtra(EXTRA_AGE, 0)

		val text = "Name: $name, \nYour Age: $age"
		tvDataReceived.text = text
	}
}