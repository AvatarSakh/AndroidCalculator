package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.min


class MainActivity : AppCompatActivity() {

    private lateinit var oneButton: Button
    private lateinit var twoButton: Button
    private lateinit var threeButton: Button
    private lateinit var fourButton: Button
    private lateinit var fiveButton: Button
    private lateinit var sixButton: Button
    private lateinit var sevenButton: Button
    private lateinit var eightButton: Button
    private lateinit var nineButton: Button
    private lateinit var clearButton: Button
    private lateinit var addButton: Button
    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var zerozeroButton: Button
    private lateinit var zeroButton: Button
    private lateinit var resultButton: Button
    private lateinit var viewResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var blockedbuttons: Boolean = true

        oneButton = findViewById(R.id.button_one)
        twoButton = findViewById(R.id.button_two)
        threeButton = findViewById(R.id.button_three)
        fourButton = findViewById(R.id.button_four)
        fiveButton = findViewById(R.id.button_five)
        sixButton = findViewById(R.id.button_six)
        sevenButton = findViewById(R.id.button_seven)
        eightButton = findViewById(R.id.button_eight)
        nineButton = findViewById(R.id.button_nine)
        clearButton = findViewById(R.id.button_clear)
        addButton = findViewById(R.id.button_add)
        plusButton = findViewById(R.id.button_plus)
        minusButton = findViewById(R.id.button_minus)
        zerozeroButton = findViewById(R.id.button_zerozero)
        zeroButton = findViewById(R.id.button_zero)
        resultButton = findViewById(R.id.button_result)
        viewResult = findViewById(R.id.view_result)

        oneButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "1")
            blockedbuttons = false
        }

        twoButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "2")
            blockedbuttons = false
        }

        threeButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "3")
            blockedbuttons = false
        }

        fourButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "4")
            blockedbuttons = false
        }

        fiveButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "5")
            blockedbuttons = false
        }

        sixButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "6")
            blockedbuttons = false
        }

        sevenButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "7")
            blockedbuttons = false
        }
        eightButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "8")
            blockedbuttons = false
        }

        nineButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "9")
            blockedbuttons = false
        }

        clearButton.setOnClickListener{
            viewResult.setText("")
            blockedbuttons = false
        }

        addButton.setOnClickListener{
            val text = viewResult.text.toString()
            if(text[text.length-1] == '-' || text[text.length-1] == '+' || text[text.length-1] == '*' || blockedbuttons == true)
            {

            }
            else {
                viewResult.setText(text + "*")
                blockedbuttons = true
            }

        }

        plusButton.setOnClickListener{
            val text = viewResult.text.toString()
            if(text[text.length-1] == '-' || text[text.length-1] == '+' || text[text.length-1] == '*' || blockedbuttons == true)
            {

            }
            else {
                viewResult.setText(text + "+")
                blockedbuttons = true
            }
        }

        minusButton.setOnClickListener{
            val text = viewResult.text.toString()
            if(text[text.length-1] == '-' || text[text.length-1] == '+' || text[text.length-1] == '*' || blockedbuttons == true)
            {

            }
            else {
                viewResult.setText(text + "-")
                blockedbuttons = true
            }
        }

        zerozeroButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "00")
        }

        zeroButton.setOnClickListener{
            viewResult.setText(viewResult.text.toString() + "0")
        }

        resultButton.setOnClickListener{
            blockedbuttons = false
            val text = viewResult.text.toString()
            var leftoperand = ""
            var rightoperand = ""
            var operation = '*'
            var leftoperand_write = true
            for (ch in text){
                if (ch == '+') {
                    leftoperand_write = false
                    operation = '+'
                    continue
                }

                if (ch == '-') {
                    leftoperand_write = false
                    operation = '-'
                    continue
                }

                if (ch == '*') {
                    leftoperand_write = false
                    operation = '*'
                    continue
                }

                if (leftoperand_write){
                    leftoperand += ch
                }
                else{
                    rightoperand +=ch
                }
            }
            if(rightoperand != "") {
                var result: Long = 0;
                when (operation) {
                    '+' -> result = leftoperand.toLong() + rightoperand.toLong()
                    '-' -> result = leftoperand.toLong() - rightoperand.toLong()
                    '*' -> result = leftoperand.toLong() * rightoperand.toLong()
                }
                viewResult.setText(result.toString())
            }
        }


    }
}