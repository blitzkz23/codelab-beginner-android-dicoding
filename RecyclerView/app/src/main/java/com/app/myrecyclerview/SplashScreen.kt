package com.app.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)

		val splashImage: ImageView = findViewById(R.id.splash_iv_soekarno)
		val splashText: TextView = findViewById(R.id.splash_tv)

		splashImage.alpha = 0f
		splashImage.animate().setDuration(2000).alpha(1f).withEndAction {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
		}
	}
}