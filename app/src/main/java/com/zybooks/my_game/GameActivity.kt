package com.zybooks.my_game

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.Color.red
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var playerCard1: ImageView
    lateinit var playerCard2: ImageView
    lateinit var dealerCard1: ImageView
    lateinit var dealerCard2: ImageView

    lateinit var playerScore: TextView
    lateinit var dealerScore: TextView

    lateinit var hitMeBtn: Button
    lateinit var noDrawBtn: Button
    lateinit var newGameBtn: Button
    lateinit var random: Random

    companion object{
    var playerLosses = 0
    var playerWins = 0
    var playerTies = 0
    var playerBlackjacks = 0
    var handsPlayed = 0
    }

    var player=0
    var dealer=0

    var cardsArray = intArrayOf(
        R.drawable.hearts2,
        R.drawable.clubs2,
        R.drawable.diamonds2,
        R.drawable.spades2,
        R.drawable.hearts3,
        R.drawable.clubs3,
        R.drawable.diamonds3,
        R.drawable.spades3,
        R.drawable.hearts4,
        R.drawable.clubs4,
        R.drawable.diamonds4,
        R.drawable.spades4,
        R.drawable.hearts5,
        R.drawable.clubs5,
        R.drawable.diamonds5,
        R.drawable.spades5,
        R.drawable.hearts6,
        R.drawable.clubs6,
        R.drawable.diamonds6,
        R.drawable.spades6,
        R.drawable.hearts7,
        R.drawable.clubs7,
        R.drawable.diamonds7,
        R.drawable.spades7,
        R.drawable.hearts8,
        R.drawable.clubs8,
        R.drawable.diamonds8,
        R.drawable.spades8,
        R.drawable.hearts9,
        R.drawable.clubs9,
        R.drawable.diamonds9,
        R.drawable.spades9,
        R.drawable.hearts10,
        R.drawable.clubs10,
        R.drawable.diamonds10,
        R.drawable.spades10,
        R.drawable.hearts_jack,
        R.drawable.hearts_queen,
        R.drawable.hearts_king,
        R.drawable.clubs_jack,
        R.drawable.clubs_queen,
        R.drawable.clubs_king,
        R.drawable.diamonds_jack,
        R.drawable.diamonds_queen,
        R.drawable.diamonds_king,
        R.drawable.spades_jack,
        R.drawable.spades_queen,
        R.drawable.spades_king,
        R.drawable.hearts_ace,
        R.drawable.clubs_ace,
        R.drawable.diamonds_ace,
        R.drawable.spades_ace
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        supportActionBar?.hide()


        random = Random

        var move = findViewById<Button>(R.id.quitGameBtn)
    move.setOnClickListener{
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)}

        playerCard1 = findViewById(R.id.playerCard1)
        playerCard2 = findViewById(R.id.playerCard2)
        dealerCard1 = findViewById(R.id.dealerCard1)
        dealerCard2 = findViewById(R.id.dealerCard2)

        playerCard1.setImageResource(R.drawable.back_of_card)
        playerCard2.setImageResource(R.drawable.back_of_card)
        dealerCard1.setImageResource(R.drawable.back_of_card)
        dealerCard2.setImageResource(R.drawable.back_of_card)

        playerScore = findViewById(R.id.player_score)
        dealerScore = findViewById(R.id.dealer_score)

        newGameBtn = findViewById(R.id.newGameBtn) //when user clicks "New Game"
        newGameBtn.setOnClickListener {

            //generate random cards
            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)
            val card3 = random.nextInt(cardsArray.size)
            val card4 = random.nextInt(cardsArray.size)

            //display cards
            setCardImage(card1, playerCard1)
            setCardImage(card2, playerCard2)
            //setCardImage(card3, dealerCard1) //keeps first dealer card turned over
            setCardImage(card4, dealerCard2)

            //sets new game scores back to 0 to eliminate scores from prior game and displays new score new game click (first draw)
            player=0
            dealer=0

            //range and value check for player new game draw
            if (card1 in 0..3 && card2 in 0..3){
                player+=4
                player_score.text="Player: $player"
            }
            else if (card1 in 0..3 || card2 in 0..3){
                player+=2
                player_score.text="Player: $player"
            }

            if (card1 in 4..7 && card2 in 4..7){
                player+=6
                player_score.text="Player: $player"
            }
            else if (card1 in 4..7 || card2 in 4..7){
                player+=3
                player_score.text="Player: $player"
            }

            if (card1 in 8..11 && card2 in 8..11){
                player+=8
                player_score.text="Player: $player"
            }
            else if (card1 in 8..11 || card2 in 8..11){
                player+=4
                player_score.text="Player: $player"
            }

            if (card1 in 12..15 && card2 in 12..15){
                player+=10
                player_score.text="Player: $player"
            }
            else if (card1 in 12..15 || card2 in 12..15){
                player+=5
                player_score.text="Player: $player"
            }

            if (card1 in 16..19 && card2 in 16..19){
                player+=12
                player_score.text="Player: $player"
            }
            else if (card1 in 16..19 || card2 in 16..19){
                player+=6
                player_score.text="Player: $player"
            }

            if (card1 in 20..23 && card2 in 20..23){
                player+=14
                player_score.text="Player: $player"
            }
            else if (card1 in 20..23 || card2 in 20..23){
                player+=7
                player_score.text="Player: $player"
            }

            if (card1 in 24..27 && card2 in 24..27){
                player+=16
                player_score.text="Player: $player"
            }
            else if (card1 in 24..27 || card2 in 24..27){
                player+=8
                player_score.text="Player: $player"
            }

            if (card1 in 28..31 && card2 in 28..31){
                player+=18
                player_score.text="Player: $player"
            }
            else if (card1 in 28..31 || card2 in 28..31){
                player+=9
                player_score.text="Player: $player"
            }

            if (card1 in 32..47 && card2 in 32..47){
                player+=20
                player_score.text="Player: $player"
            }
            else if (card1 in 32..47 || card2 in 32..47){
                player+=10
                player_score.text="Player: $player"
            }

            if (card1 in 48..51 && card2 in 48..51){
                player+=12
                player_score.text="Player: $player"
            }
            else if (card1 in 48..51 || card2 in 48..51){
                player+=11
                player_score.text="Player: $player"
            }
            if(player == 21 && dealer == 21){
                player_score.text="TIE! : $player"
                dealer_score.text="TIE! : $dealer"
            }
            else if(player == 21){
                player_score.text="BLACKJACK! You Win! : $player"
                playerBlackjacks += 1
            }

            //range and value check for dealer new game draw
            if (card3 in 0..3 && card4 in 0..3){
                dealer+=4
                dealer_score.text="Dealer: "
            }
            else if (card3 in 0..3 || card4 in 0..3){
                dealer+=2
                dealer_score.text="Dealer: "
            }

            if (card3 in 4..7 && card4 in 4..7){
                dealer+=6
                dealer_score.text="Dealer: "
            }
            else if (card3 in 4..7 || card4 in 4..7){
                dealer+=3
                dealer_score.text="Dealer: "
            }

            if (card3 in 8..11 && card4 in 8..11){
                dealer+=8
                dealer_score.text="Dealer: "
            }
            else if (card3 in 8..11 || card4 in 8..11){
                dealer+=4
                dealer_score.text="Dealer: "
            }

            if (card3 in 12..15 && card4 in 12..15){
                dealer+=10
                dealer_score.text="Dealer: "
            }
            else if (card3 in 12..15 || card4 in 12..15){
                dealer+=5
                dealer_score.text="Dealer: "
            }

            if (card3 in 16..19 && card4 in 16..19){
                dealer+=12
                dealer_score.text="Dealer: "
            }
            else if (card3 in 16..19 || card4 in 16..19){
                dealer+=6
                dealer_score.text="Dealer: "
            }

            if (card3 in 20..23 && card4 in 20..23){
                dealer+=14
                dealer_score.text="Dealer: "
            }
            else if (card3 in 20..23 || card4 in 20..23){
                dealer+=7
                dealer_score.text="Dealer: "
            }

            if (card3 in 24..27 && card4 in 24..27){
                dealer+=16
                dealer_score.text="Dealer: "
            }
            else if (card3 in 24..27 || card4 in 24..27){
                dealer+=8
                dealer_score.text="Dealer: "
            }

            if (card3 in 28..31 && card4 in 28..31){
                dealer+=18
                dealer_score.text="Dealer: "
            }
            else if (card3 in 28..31 || card4 in 28..31){
                dealer+=9
                dealer_score.text="Dealer: "
            }

            if (card3 in 32..47 && card4 in 32..47){
                dealer+=20
                dealer_score.text="Dealer: "
            }
            else if (card3 in 32..47 || card4 in 32..47){
                dealer+=10
                dealer_score.text="Dealer: "
            }

            if (card3 in 48..51 && card4 in 48..51){
                dealer+=12
                dealer_score.text="Dealer: "
            }
            else if (card3 in 48..51 || card4 in 48..51){
                dealer+=11
                dealer_score.text="Dealer: "
            }
            if(dealer == 21 && player == 21){
                dealer_score.text="TIE! : $dealer"
                player_score.text="TIE! : $player"
            }
            else if(dealer == 21){
                dealer_score.text="Dealer: $dealer!"
                player_score.text="Player: $player"
            }
            else if(player == 21 && dealer != 21){
                dealer_score.text="Dealer Loses..."
            }

        }
        hitMeBtn = findViewById(R.id.hitMeBtn) //when user clicks "HIT!"
        hitMeBtn.setOnClickListener{
            if (player < 22){
            /*generate random "Hit" cards and turns over player's left card to only display
            the new card drawn when "Hit"*/
            val card1 = playerCard1.setImageResource(R.drawable.back_of_card)
            val card2 = random.nextInt(cardsArray.size)
            val card4 = random.nextInt(cardsArray.size)

            //display cards
            setCardImage(card2, playerCard2)
            setCardImage(card4, dealerCard2)

            //range and value check for player hit card value
            if (card2 in 0..3){
                player+=2
                player_score.text="Player: $player"
            }
            else if (card2 in 4..7){
                player+=3
                player_score.text="Player: $player"
            }
            else if (card2 in 8..11){
                player+=4
                player_score.text="Player: $player"
            }
            else if (card2 in 12..15){
                player+=5
                player_score.text="Player: $player"
            }
            else if (card2 in 16..19){
                player+=6
                player_score.text="Player: $player"
            }
            else if (card2 in 20..23){
                player+=7
                player_score.text="Player: $player"
            }
            else if (card2 in 24..27){
                player+=8
                player_score.text="Player: $player"
            }else if (card2 in 28..31) {
                player += 9
                player_score.text = "Player: $player"
            }
            else if (card2 in 32..47){
                player+=10
                player_score.text="Player: $player"
            }
            else if (card2 in 48..51){ //Ace is worth 11 if player's score is 10 or below; Otherwise, it's worth 1
                if(player <= 10){
                    player+=11
                    player_score.text="Player: $player"}
                else if(player >= 11){
                    player+=1
                    player_score.text="Player: $player"}
            }
            if(player>=22) {
                player_score.text="BUST!!"
            }

            while(dealer<=16){
                //range and value check for dealer hit card value
            if (card4 in 0..3){
                dealer+=2
                dealer_score.text="Dealer: "
            }
            else if (card4 in 4..7){
                dealer+=3
                dealer_score.text="Dealer: "
            }
            else if (card4 in 8..11){
                dealer+=4
                dealer_score.text="Dealer: "
            }
            else if (card4 in 12..15){
                dealer+=5
                dealer_score.text="Dealer: "
            }
            else if (card4 in 16..19){
                dealer+=6
                dealer_score.text="Dealer: "
            }
            else if (card4 in 20..23){
                dealer+=7
                dealer_score.text="Dealer: "
            }
            else if (card4 in 24..27){
                dealer+=8
                dealer_score.text="Dealer: "
            }else if (card4 in 28..31) {
                dealer += 9
                dealer_score.text = "Dealer: "
            }
            else if (card4 in 32..47){
                dealer+=10
                dealer_score.text="Dealer: "
            }
            else if (card4 in 48..51){ //Ace is worth 11 if dealer's score is 10 or below; Otherwise, it's worth 1
                if(dealer <= 10){
                    dealer+=11
                    dealer_score.text="Dealer: "}
                else if(dealer >= 11){
                    dealer+=1
                    dealer_score.text="Dealer: "}
            }
            if(dealer>=22) {
                //dealer_score.text="BUST!!"
            }
        }}}
        noDrawBtn = findViewById(R.id.noDrawBtn) //when user clicks "STAND!"
        noDrawBtn.setOnClickListener{

            while(dealer<=16 && player != 21){ //loop that will make the dealer hit, unless dealer score is 17 or higher because dealer must stand on 17, WHEN player clicks STAND!

            /*generate random "Hit" cards and turns over player's left card to only display
            the new card drawn when "Hit"*/
            val card1 = playerCard1.setImageResource(R.drawable.back_of_card)
            val card4 = random.nextInt(cardsArray.size)

            //display new dealer card if dealer score < 17
            setCardImage(card4, dealerCard2)


            //range and value check for dealer hit card value
            if (card4 in 0..3){
                dealer+=2
            }
            else if (card4 in 4..7){
                dealer+=3
            }
            else if (card4 in 8..11){
                dealer+=4
            }
            else if (card4 in 12..15){
                dealer+=5
            }
            else if (card4 in 16..19){
                dealer+=6
            }
            else if (card4 in 20..23){
                dealer+=7
            }
            else if (card4 in 24..27){
                dealer+=8
            }else if (card4 in 28..31) {
                dealer += 9
            }
            else if (card4 in 32..47){
                dealer+=10
            }
            else if (card4 in 48..51){ //Ace is worth 11 if dealer's score is 10 or below; Otherwise, it's worth 1
                if(dealer <= 10){
                    dealer+=11}
                else if(dealer >= 11){
                    dealer+=1}
            }

        }
            if(dealer > player && dealer <= 21){
                dealer_score.text="Dealer Wins! : $dealer"
                player_score.text="You lose! : $player"
                playerLosses += 1
                handsPlayed += 1
            }
            else if(player > dealer && player <= 21){
                player_score.text="You Win! : $player"
                dealer_score.text="Dealer Loses! : $dealer"
                playerWins += 1
                handsPlayed += 1

            }
            else if(player <= 21 && dealer > 21){
                player_score.text="You Win! : $player"
                dealer_score.text="Dealer BUSTS! : $dealer"
                playerWins += 1
                handsPlayed += 1

            }
            else if(dealer <= 21 && player > 21){
                player_score.text="You Lose! : $player"
                dealer_score.text="Dealer Wins! : $dealer"
                playerLosses += 1
                handsPlayed += 1

            }
            else if(dealer == player && dealer <= 21){
                player_score.text="TIE!! : $player"
                dealer_score.text="TIE!! : $dealer"
                playerTies += 1
                handsPlayed += 1

            }
        }
    }
    private fun setCardImage(number: Int, image: ImageView) {
        image.setImageResource(cardsArray[number])
    }
}
