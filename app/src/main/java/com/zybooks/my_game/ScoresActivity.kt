package com.zybooks.my_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.zybooks.my_game.GameActivity.Companion.handsPlayed
import com.zybooks.my_game.GameActivity.Companion.playerBlackjacks
import com.zybooks.my_game.GameActivity.Companion.playerLosses
import com.zybooks.my_game.GameActivity.Companion.playerTies
import com.zybooks.my_game.GameActivity.Companion.playerWins
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_scores.*

class ScoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
        supportActionBar?.hide()

        //create shared preferences to permanently store SCORES data until data wipe
        val sharedPreferences = getSharedPreferences("My_Game", MODE_PRIVATE)
        var totalHandsPlayed = sharedPreferences.getInt("totalHandsPlayed", 0)
        totalHandsPlayed += handsPlayed
        var playerWs = sharedPreferences.getInt("playerWs", 0)
        playerWs += playerWins
        var playerLs = sharedPreferences.getInt("playerLs", 0)
        playerLs += playerLosses
        var playerTs = sharedPreferences.getInt("playerTs", 0)
        playerTs += playerTies
        var playerBJs = sharedPreferences.getInt("playerBJs", 0)
        playerBJs += playerBlackjacks

        Wins.text="Wins: $playerWs"
        Losses.text="Losses: $playerLs"
        Ties.text="Ties: $playerTs"
        Blackjacks.text="Blackjacks Drawn: $playerBJs"
        Hands.text="Total Hands Played: $totalHandsPlayed"

        val editor = sharedPreferences.edit()
        editor.putInt("totalHandsPlayed", totalHandsPlayed)
        editor.putInt("playerWs", playerWs)
        editor.putInt("playerLs", playerLs)
        editor.putInt("playerTs", playerTs)
        editor.putInt("playerBJs", playerBJs)
        editor.apply()

        var move = findViewById<Button>(R.id.backButton)
    move.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)}
    }
}