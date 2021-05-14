package com.sahar.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var spFrom : Spinner
    lateinit var result : TextView
    lateinit var input : EditText

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spFrom =findViewById(R.id.spFromUnit)
        input =findViewById(R.id.inputNumber)

            result =findViewById(R.id.result)
        val fromUnit = listOf( "kilometer","Decimeter","Centimeter","Millimeter")
        val unitValue = listOf("1000","10","100","1000")


            val adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,fromUnit)
        spFrom.adapter = adapter
        spFrom.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = calculatUnit(fromUnit[position],unitValue[position])
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    fun calculatUnit(selectedUnit: String, selectedValue: String): String {

        return if (selectedUnit == "kilometer") {
            (input.text.toString().toDouble() / selectedValue.toDouble()).toString()
        } else (input.text.toString().toDouble() * selectedValue.toDouble()).toString()
    }
}