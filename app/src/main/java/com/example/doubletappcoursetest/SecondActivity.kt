package com.example.doubletappcoursetest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.doubletappcoursetest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var squareNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        squareNumber = intent.extras?.getInt(NUMBER_TAG) ?: 0
        squareNumber *= squareNumber

        binding.squareNumber.text = squareNumber.toString()

        binding.buttonSecond.setOnClickListener {
            finish()
        }

        Log.d(SECOND_ACTIVITY_TAG, "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(SECOND_ACTIVITY_TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(SECOND_ACTIVITY_TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(SECOND_ACTIVITY_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(SECOND_ACTIVITY_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(SECOND_ACTIVITY_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(SECOND_ACTIVITY_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(SECOND_ACTIVITY_TAG, "onDestroy")
    }

    companion object {
        const val NUMBER_TAG = "NUMBER_TAG"
        const val SECOND_ACTIVITY_TAG = "Second Activity"
    }
}
