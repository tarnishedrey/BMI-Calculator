package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.app.Activity
import android.content.Intent

class MainActivity : AppCompatActivity() {
    private var gender: String = "Laki-laki"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        buttonCalculate.setOnClickListener {
            calculateBMI()
            val resultText = calculateBMI()
            val intent = Intent(this, ThirdAct::class.java)
            val bundle = Bundle()
            bundle.putString("resultText", resultText)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    private fun calculateBMI(): String {
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight) // Add this line
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val editUrname = findViewById<EditText>(R.id.EditUrname)
        val editAdress = findViewById<EditText>(R.id.EditAdress)

        val name = editUrname.text
        val alamat = editAdress.text
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()
        val selectedGenderId = radioGroupGender.checkedRadioButtonId

        gender = when (selectedGenderId) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"
        }

        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }

        val result = when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi >= 18.5 && bmi < 24.9 -> "Berat badan normal"
            bmi >= 25 && bmi < 29.9 -> "Berat badan berlebih"
            else -> "Obesitas"
        }
        val res = "BMI: %.2f\n$result\n$name\n$alamat".format(bmi)
        return res
    }
}