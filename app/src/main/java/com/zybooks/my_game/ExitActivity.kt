package com.zybooks.my_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.shutdown
import android.view.View
import android.widget.Button
import kotlin.system.exitProcess
class ExitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exit)
        supportActionBar?.hide()

    var quitGame = findViewById<Button>(R.id.yesQuit)
        quitGame.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            finishAffinity()
        }

    var move = findViewById<Button>(R.id.noQuit)
        move.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)}

    }
}