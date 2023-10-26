package com.example.imc_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesApp : PreferencesApp
    private lateinit var comandoPopup : Popup
    private lateinit var imcCalculator: IMCCalculator

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
        preferencesApp = PreferencesApp(applicationContext)
        comandoPopup = Popup(applicationContext)
        imcCalculator = IMCCalculator(applicationContext)
        initComponent()
        initListeners()
        if (!preferencesApp.getDialog()) {
            comandoPopup.showPopupInicio()
            preferencesApp.setDialog(comandoPopup.dialogDontShow)
        }
        if (preferencesApp.getName().isEmpty()){
            popupDatos()
        }
        setView()

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
        btnEditar.setOnClickListener {
            popupDatos()
        }
        btnQueEs.setOnClickListener {
            comandoPopup.showPopupInicio()
            preferencesApp.setDialog(comandoPopup.dialogDontShow)
        }
        btnCalcular.setOnClickListener {
            val intent = Intent(this, Calculate_imc::class.java)
            intent.putExtra("WEIGHT", preferencesApp.getWeight().toDouble())
            intent.putExtra("HEIGHT", preferencesApp.getHeight())
            startActivity(intent)
        }
    }

    private fun setView(){
        saludoText.text = "¡Hola, ${preferencesApp.getName()}!"
        imcValue.text = imcCalculator.calculateIMC(preferencesApp.getWeight().toDouble(),preferencesApp.getHeight() )
        pesoValue.text  = "${preferencesApp.getWeight()} kg"
        alturaValue.text  = "${preferencesApp.getHeight()} cm"
        categoriaValue.text = imcCalculator.getCategoria(preferencesApp.getWeight().toDouble(),preferencesApp.getHeight())
    }

    private fun popupDatos(){
        comandoPopup.showPopupDatos()
        preferencesApp.setName(comandoPopup.name)
        preferencesApp.setGenre(comandoPopup.genre)
    }
}