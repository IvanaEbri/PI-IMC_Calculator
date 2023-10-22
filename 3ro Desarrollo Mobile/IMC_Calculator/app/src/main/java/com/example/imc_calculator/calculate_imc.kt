package com.example.imc_calculator

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class calculate_imc: AppCompatActivity() {
    private lateinit var btnAtras: ImageView
    private lateinit var btnCalcular: CardView
    private lateinit var pesoValue: TextView
    private lateinit var alturaValue: TextView
    private lateinit var pesoRS : RangeSlider
    private lateinit var alturaRS : RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate_imc)
        initComponent()
        initListeners()
    }

    private fun initComponent() {
        btnAtras = findViewById(R.id.i_arrow)
        btnCalcular = findViewById(R.id.btn_calcular)
        pesoValue = findViewById(R.id.peso_value)
        alturaValue = findViewById(R.id.altura_value)
        pesoRS = findViewById(R.id.peso_rs)
        alturaRS = findViewById(R.id.altura_rs)
    }

    private fun initListeners() {
        btnAtras.setOnClickListener(
            //pasar al MainActivity
        )
        btnCalcular.setOnClickListener(
            //calcular IMC y abrir pop up
        )
        pesoRS.addOnChangeListener { _, value, _ ->
            pesoValue.text = "$value kg"
        }
        alturaRS.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            alturaValue.text = "$df cm"
        }
    }
}