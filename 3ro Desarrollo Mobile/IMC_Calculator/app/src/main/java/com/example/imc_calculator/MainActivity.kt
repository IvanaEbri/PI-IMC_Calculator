package com.example.imc_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var saludoText: TextView
    private lateinit var imcValue: TextView
    private lateinit var pesoValue: TextView
    private lateinit var alturaValue: TextView
    private lateinit var categoriaValue: TextView
    private lateinit var btnQueEs: CardView
    private lateinit var btnCalcular: CardView
    private lateinit var btnEditar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initListeners()
    }



    private fun initComponent() {
        saludoText = findViewById(R.id.hello)
        imcValue = findViewById(R.id.imc_value)
        pesoValue = findViewById(R.id.peso_value)
        alturaValue = findViewById(R.id.altura_value)
        categoriaValue = findViewById(R.id.categoria_value)
        btnQueEs = findViewById(R.id.btn_que_es)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnEditar = findViewById(R.id.i_pencil)
    }
    private fun initListeners() {
        btnEditar.setOnClickListener()
        btnQueEs.setOnClickListener()
        btnEditar.setOnClickListener()
    }
}