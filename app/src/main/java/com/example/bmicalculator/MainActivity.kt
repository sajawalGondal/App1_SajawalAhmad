package com.example.bmicalculator


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate_btn.setOnClickListener {
            if (etHeight.text.isNotEmpty() && etWeight.text.isNotEmpty()){
                val height= (etHeight.text.toString().toInt())
                val weight=(etWeight.text.toString().toInt())
                val BMI =calculateBMI(height, weight)
                bmi.text =BMI.toString()
                bmi.visibility = View.VISIBLE
                if (BMI < 18.5) {
                    status.text = " Under Weight"
                } else if (BMI >= 18.5 && BMI < 24.9){
                    status.text = "Healthy"
                } else if (BMI >= 24.9 && BMI<30){
                    status.text ="Over Weight"
                } else if (BMI >= 30){
                    status.text = "Suffering from Obesity"
                }
                bmi_tv.visibility = View.VISIBLE
                status.visibility = View.VISIBLE
                Recalculate.visibility = View.VISIBLE
                calculate_btn.visibility = View.GONE

            }
            else {
                Toast.makeText(this,"please enter the valid height and weight",Toast.LENGTH_SHORT).show()
            }
        }
        Recalculate.setOnClickListener{
            ResetEverything()
        }
    }
    private fun ResetEverything() {
        calculate_btn.visibility=View.VISIBLE
        Recalculate.visibility=View.GONE
        etHeight.text.clear()
        etWeight.text.clear()
        status.text=" "
        bmi.text=" "
        bmi_tv.visibility=View.GONE
    }
    private fun calculateBMI (height: Int, weight:Int) : Float{
        val Height_in_metre = height.toFloat() /100
        val BMI = weight.toFloat() / (Height_in_metre * Height_in_metre)
        return BMI
    }
}