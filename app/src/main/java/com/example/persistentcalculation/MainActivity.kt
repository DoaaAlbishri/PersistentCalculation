package com.example.persistentcalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var ETdouble :EditText
    lateinit var ETfloat :EditText
    lateinit var multiply : Button
    lateinit var result :TextView
    var float = 0.0f
    var doub = 0.0
    var res = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        multiply=findViewById(R.id.button)
        result=findViewById(R.id.result)
        ETfloat=findViewById(R.id.ETfloat)
        ETdouble=findViewById(R.id.ETdouble)
        multiply.setOnClickListener {
            var edit1 = ETdouble.text.toString()
            val maybeDouble = edit1.toDoubleOrNull()
            if (maybeDouble != null) {
                 doub = ETdouble.text.toString().toDouble()
            } else {
                Toast.makeText(this, "Type double number!!", Toast.LENGTH_SHORT).show()
            }

            var edit2 = ETfloat.text.toString()
            val maybeFloat = edit2.toFloatOrNull()
            if (maybeFloat != null) {
                 float = ETfloat.text.toString().toFloat()
            } else {
                Toast.makeText(this, "Type float number!!", Toast.LENGTH_SHORT).show()
            }
            res =  doub * float
            result.text = "$res"
        }
    }

    //rotate device
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("res", res)
        outState.putDouble("doub", doub)
        outState.putFloat("float", float)

    }
    //rotate device
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        res= savedInstanceState.getDouble("res")
        doub= savedInstanceState.getDouble("doub")
        float= savedInstanceState.getFloat("float")
        result.text = "$res"
    }
}