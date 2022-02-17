package com.example.doubletappcoursetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.doubletappcoursetest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var squareNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        squareNumber = intent.extras?.getInt(numberTag) ?: 0
        squareNumber *= squareNumber

        binding.squareNumber.text = squareNumber.toString()

        binding.buttonSecond.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val numberTag = "NUMBER_TAG"
    }
}
