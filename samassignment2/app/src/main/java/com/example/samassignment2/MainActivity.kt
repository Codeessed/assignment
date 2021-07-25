package com.example.samassignment2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.util.LogWriter
import androidx.core.widget.addTextChangedListener
import com.google.android.material.button.MaterialButtonToggleGroup

class MainActivity : AppCompatActivity() {

    private var count = 0
    private lateinit var button: Button
    private lateinit var scoreView: TextView
    private lateinit var switchButton: Button
    private lateinit var switchImage: ImageView
    private lateinit var stateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scoreView = findViewById(R.id.scoreView)
        scoreView.text = getString(R.string.noOfTap, count)
        button = findViewById(R.id.button)
        switchImage = findViewById(R.id.switchImage)
        switchButton = findViewById(R.id.switchButton)
        stateButton = findViewById(R.id.stateButton)


        button.setOnClickListener { view ->
            incrementScore()
        }
        if (savedInstanceState != null){
            count = savedInstanceState.getInt("count")
            scoreView.text = getString(R.string.noOfTap, count)
        }

        switchButton.setOnClickListener{
            if(switchButton.text == "HIDE"){
                switchImage.visibility = View.INVISIBLE
                switchButton.text = "UNHIDE"
            }else{
                switchImage.visibility = View.VISIBLE
                switchButton.text = "HIDE"
            }
        }

    }
    private fun incrementScore() {
        count++
        scoreView.text = getString(R.string.noOfTap, count)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }


}