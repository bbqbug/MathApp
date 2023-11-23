package com.example.studentb2012020_canculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private var firstNum = StringBuilder()
    private var Opera = ""
    private var lastNum = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultview = findViewById<TextView>(R.id.viewoutput)

        val btn0  = findViewById<Button>(R.id.btnzero)
        val btn1 = findViewById<Button>(R.id.btnone)
        val btn2 = findViewById<Button>(R.id.btntwo)
        val btn3 = findViewById<Button>(R.id.btnthree)
        val btn4 = findViewById<Button>(R.id.btnfour)
        val btn5 = findViewById<Button>(R.id.btnfive)
        val btn6 = findViewById<Button>(R.id.btnsix)
        val btn7 = findViewById<Button>(R.id.btnseven)
        val btn8 = findViewById<Button>(R.id.btneight)
        val btn9 = findViewById<Button>(R.id.btnnine)
        val btnclr = findViewById<Button>(R.id.btnclr)
        val btnadd = findViewById<Button>(R.id.btnadd)
        val btnminus = findViewById<Button>(R.id.btnminus)
        val btntimes = findViewById<Button>(R.id.btntimes)
        val btndiv = findViewById<Button>(R.id.btndiv)
        val btnexe = findViewById<Button>(R.id.btnexe)
        val btndot = findViewById<Button>(R.id.btndot)

        btndot.setOnClickListener() {
            if(Opera != "") {
                if(!("," in lastNum)) {
                    lastNum.append(",")
                    val sb = StringBuilder()
                    sb.append(resultview.text).append(".")
                    resultview.text = sb.toString()
                }
            } else {
                if(!("," in firstNum)) {
                    firstNum.append(",")
                    val sb = StringBuilder()
                    sb.append(resultview.text).append(".")
                    resultview.text = sb.toString()
                }
            }


        }

        btnexe.setOnClickListener() {
            when(Opera) {
                "+"->{
                    val temp = (firstNum.toString().toDouble() + lastNum.toString().toDouble()).toString()
                    resultview.text = check(temp)
                }
                "-"->{
                    val temp = (firstNum.toString().toDouble() - lastNum.toString().toDouble()).toString()
                    resultview.text = check(temp)
                }
                "*"->{
                    val temp = (firstNum.toString().toDouble() * lastNum.toString().toDouble()).toString()
                    resultview.text = check(temp)
                }
                "/"->{
                    val temp = (firstNum.toString().toDouble() / lastNum.toString().toDouble()).toString()
                    resultview.text = check(temp)
                }
            }
            firstNum.setLength(0)
            firstNum.append(resultview.text)
            lastNum.setLength(0)
            Opera = ""
        }



        fun operaaction(opera : String, btn : Button) {
            when(Opera) {

                "+"->{
                    val temp = firstNum.toString().toDouble()
                    firstNum.setLength(0)
                    firstNum.append((temp + lastNum.toString().toDouble()).toString())
                    lastNum.setLength(0)

                }

                "-"->{
                    val temp = firstNum.toString().toDouble()
                    firstNum.setLength(0)
                    firstNum.append((temp - lastNum.toString().toDouble()).toString())
                    lastNum.setLength(0)

                }

                "*"->{
                    val temp = firstNum.toString().toDouble()
                    firstNum.setLength(0)
                    firstNum.append((temp * lastNum.toString().toDouble()).toString())
                    lastNum.setLength(0)


                }

                "/"->{
                    val temp = firstNum.toString().toDouble()
                    firstNum.setLength(0)
                    firstNum.append((temp / lastNum.toString().toDouble()).toString())
                    lastNum.setLength(0)

                }

                ""-> {
                    firstNum.setLength(0)
                    firstNum = firstNum.append(resultview.text)
                }

            }



            val textbtn = btn.text
            val sb = StringBuilder()
            sb.append(resultview.text).append(textbtn)
            resultview.text = sb.toString()
            Opera = opera
        }

        fun numaction(num : String, btn : Button) {
            if(Opera !="") {
                lastNum.append(num)

            } else {
                firstNum.append(num)
            }
            val textbtn = btn.text
            val sb = StringBuilder()
            sb.append(resultview.text).append(textbtn)
            resultview.text = sb.toString()
        }


        btnadd.setOnClickListener() {
            operaaction("+" , btnadd)
        }

        btnminus.setOnClickListener() {
            operaaction("-" , btnminus)
        }
        btntimes.setOnClickListener() {
            operaaction("*" , btntimes)
        }
        btndiv.setOnClickListener() {
            operaaction("/" , btndiv)
        }

        btnclr.setOnClickListener() {
            Opera = ""
            resultview.text = ""
            firstNum.setLength(0)
            lastNum.setLength(0)
        }



        btn0.setOnClickListener() {
            numaction(btn0.text.toString(), btn0)
        }

        btn1.setOnClickListener() {
            numaction(btn1.text.toString(), btn1)
        }
        btn2.setOnClickListener() {
            numaction(btn2.text.toString(), btn2)
        }
        btn3.setOnClickListener() {
            numaction(btn3.text.toString(), btn3)
        }
        btn4.setOnClickListener() {
            numaction(btn4.text.toString(), btn4)
        }
        btn5.setOnClickListener() {
            numaction(btn5.text.toString(), btn5)
        }
        btn6.setOnClickListener() {
            numaction(btn6.text.toString(), btn6)
        }
        btn7.setOnClickListener() {
            numaction(btn7.text.toString(), btn7)
        }
        btn8.setOnClickListener() {
            numaction(btn8.text.toString(), btn8)
        }
        btn9.setOnClickListener() {
            numaction(btn1.text.toString(), btn9)
        }

    }

    private fun check(num: String):String {
        var temp :String = num
        if(num.endsWith(".0")) {
            temp =  num.substring(0,num.length-2);
        }
        return temp;
    }

}

