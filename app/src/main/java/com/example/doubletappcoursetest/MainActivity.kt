package com.example.doubletappcoursetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.doubletappcoursetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var number = 0
    private var isMoveToSecondActivity = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.number.text = number.toString()

        binding.buttonFirst.setOnClickListener {
            isMoveToSecondActivity = true
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(SecondActivity.numberTag, number)
            }
            startActivity(intent)
        }

        Log.d(MAIN_ACTIVITY_TAG, "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (!isMoveToSecondActivity) {
            number += 1
        }
        outState.putInt(NUMBER_TAG, number)
        Log.d(MAIN_ACTIVITY_TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        number = savedInstanceState.getInt(NUMBER_TAG)
        binding.number.text = number.toString()
        Log.d(MAIN_ACTIVITY_TAG, "onRestoreInstanceState. Restored number is $number")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    companion object {
        const val NUMBER_TAG = "NUMBER_TAG"
        const val MAIN_ACTIVITY_TAG = "Main Activity"
    }
}