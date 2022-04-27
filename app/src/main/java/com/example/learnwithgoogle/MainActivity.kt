package com.example.learnwithgoogle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btnRoll)
        var player0 = true
        rollButton.setOnClickListener {

            player0 = if (player0){
                rollDice(0)
                false

            } else {
                rollDice(1)
                true
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice(x: Int) {
        /** Create new Dice object with 6 sides and roll it*/
        val dice = Dice(6)
        val diceRoll = dice.roll()
        /** Update the screen with the dice roll*/

        /** Find the ImageView in the layout */
        val diceImage1: ImageView = findViewById(R.id.ivDice1)
        val diceImage2: ImageView = findViewById(R.id.ivDice2)

        //diceImage.setImageResource(R.drawable.dice_2)

        /** Determine which drawable resource ID to use based on the dice roll */
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val text: TextView = findViewById(R.id.tv_playerturn)

        if ( x == 0 ){
            diceImage1.setImageResource(drawableResource)
            text.text="Player 2, It's your turn  "
            Toast.makeText(this, "Player 1 : your roll is $diceRoll ", Toast.LENGTH_SHORT).show()
        }
        else{
            /**Update the ImageView with the correct drawable resource ID*/
            diceImage2.setImageResource(drawableResource)
            text.text="Player 1, It's your turn"
            Toast.makeText(this, "Player 2 : your roll is $diceRoll ", Toast.LENGTH_SHORT).show()
        }

        /** update the content description */
        diceImage1.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }

}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}