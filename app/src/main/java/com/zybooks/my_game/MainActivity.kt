package com.zybooks.my_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_exit.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


    var moveToPlay = findViewById<Button>(R.id.playButton)
    moveToPlay.setOnClickListener{
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)}

    var moveToSettings = findViewById<Button>(R.id.settingsButton)
    moveToSettings.setOnClickListener{
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)}

    var moveToHighScores = findViewById<Button>(R.id.highscoresButton)
    moveToHighScores.setOnClickListener{
        val intent = Intent(this, ScoresActivity::class.java)
        startActivity(intent)}

    var moveToHelp = findViewById<Button>(R.id.helpButton)
    moveToHelp.setOnClickListener{
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)}

    var moveToExit = findViewById<Button>(R.id.exitButton)
    moveToExit.setOnClickListener{
        val intent = Intent(this, ExitActivity::class.java)
        startActivity(intent)
        }

    }
}
