package com.example.intentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

//		Declare and cast button
		val btnMoveActivity: Button = findViewById(R.id.activity_main_bt_move_activity)
		val btnMoveWithDataActivity: Button = findViewById(R.id.activity_main_bt_move_with_data_activity)
		val btnDialPhone: Button = findViewById(R.id.activity_main_bt_dial_number)

//		Set on click listener
		btnMoveActivity.setOnClickListener(this)
		btnMoveWithDataActivity.setOnClickListener(this)
		btnDialPhone.setOnClickListener(this)
	}

	override fun onClick(v: View?) {
//		Code to move to another Activity
		when (v?.id) {
			R.id.activity_main_bt_move_activity -> {
				val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
				startActivity(moveIntent)
			}

			R.id.activity_main_bt_move_with_data_activity -> {
				val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
//				Put extra is a method that store key-value, and we use it here to send a data on our intent to the next activity
				moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Naufal Aldy")
				moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
				startActivity(moveWithDataIntent)
			}

			/**
			 * We use implicit intent by calling the constructor Intent(ACTION, URI) with
			 * Action           : Intent.ACTION_DIAL
			   Uri              : Uri.parse("tel:"+phoneNumber)
			 * another intent action could be find in official documentation of intent
			 */
			R.id.activity_main_bt_dial_number -> {
				val phoneNumber = "081210841382"
				val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
				startActivity(dialPhoneIntent)
			}
		}
	}
}