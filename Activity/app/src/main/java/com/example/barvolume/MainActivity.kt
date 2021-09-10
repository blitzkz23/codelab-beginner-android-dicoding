package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
//	Define late variable so we can use it globally
	private lateinit var edtLength: EditText
	private lateinit var edtWidth: EditText
	private lateinit var edtHeight: EditText
	private lateinit var tvResult: TextView
	private lateinit var btnCalculate: Button

	companion object {
		private const val STATE_RESULT = "state_result"
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

//		Initialize view variable
		edtLength = findViewById(R.id.activity_main_et_length)
		edtWidth = findViewById(R.id.activity_main_et_width)
		edtHeight = findViewById(R.id.activity_main_et_height)
		btnCalculate = findViewById(R.id.activity_main_bt_calculate)
		tvResult = findViewById(R.id.activity_main_tv_result)

//		My approach
//		btnCalculate.setOnClickListener { hitungLuas() }

//		If setOnClickListener using this context, we must implement the View.OnClickListener interface
//		keyword [this] refer to Activity object that is implementing this onClickListener which is the btnCalculate
		btnCalculate.setOnClickListener(this)

//		We call the saved bundle value that is saved on onSaveInstanceState by calling the key STATE_RESULT
		if (savedInstanceState != null) {
			val result = savedInstanceState.getString(STATE_RESULT)
			tvResult.text = result
		}
	}

//	onSaveInstanceState is used to store the variable(result of calculation), so if the app orientation change to landscape it will be retained
	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
//		STATE_RESULT is a key, and the tvResult.text is the value that is save on the state
//	    We need to do this because if the orientation change, the activity lifecycle is destroyed and will call new onCreate method
		outState.putString(STATE_RESULT, tvResult.text.toString())
	}

	private fun hitungLuas() {
//		My approach
		val panjang = edtLength.text.toString().toInt()
		val lebar = edtWidth.text.toString().toInt()
		val tinggi = edtHeight.text.toString().toInt()

		val hasil = panjang * lebar * tinggi
		tvResult.text = hasil.toString()

	}

	override fun onClick(v: View?) {
//		Dicoding's Approach
		if (v?.id == R.id.activity_main_bt_calculate) {
//			Get value from edit text, and use trim to clear whitespace(if any)
			val inputLength = edtLength.text.toString().trim()
			val inputWidth = edtWidth.text.toString().trim()
			val inputHeight = edtHeight.text.toString().trim()

			var isEmptyFields = false

//			Check if there is an empty field or not, if not calculate the result
			if (inputLength.isEmpty()) {
				isEmptyFields = true
				edtLength.error = "Field ini tidak boleh kosong"
			}
			if (inputWidth.isEmpty()) {
				isEmptyFields = true
				edtWidth.error = "Field ini tidak boleh kosong"
			}
			if (inputHeight.isEmpty()) {
				isEmptyFields = true
				edtHeight.error = "Field ini tidak boleh kosong"
			}
			if (!isEmptyFields) {
				val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
				tvResult.text = volume.toString()
			}
		}
	}
}