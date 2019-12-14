package com.android.myclicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent


class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun increaseCount(view: View) {
        counter++

        if (counter > 10) {
            SecondActivity.start(this, counter)
            return
        }

        amTextViewCounter.text = counter.toString()
    }

    companion object {
        const val COUNTER_CURRENT_SCORE = "CCS"
    }

//    private fun navigateToSecondActivity() {
//        val openSecondActivity = Intent(this, SecondActivity::class.java)
//        openSecondActivity.putExtra(COUNTER_CURRENT_SCORE, counter)
//        startActivity(openSecondActivity)
//
//    }
}
