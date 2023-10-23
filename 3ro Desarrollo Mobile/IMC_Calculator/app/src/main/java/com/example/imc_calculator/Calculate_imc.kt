package com.example.imc_calculator

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class Calculate_imc: AppCompatActivity() {

    private lateinit var preferencesApp : PreferencesApp
    private lateinit var comandoPopup : Popup
    private lateinit var imcCalculator: IMCCalculator

    private lateinit var btnAtras: ImageView
    private lateinit var btnCalcular: CardView
    private lateinit var pesoValue: TextView
    private lateinit var alturaValue: TextView
    private lateinit var pesoRS : RangeSlider
    private lateinit var alturaRS : RangeSlider
    private var pesoAnt : Double = 0.0
    private var alturaAnt : Int = 0
    private var pesoN : Double= 0.0
    private var alturaN : Int = 0
    private var imcAnt : Double = imcCalculator.calculateIMC(pesoAnt,alturaAnt).toDouble()
    private var imcN : Double = 0.0
    private var categoriaAnt: String = imcCalculator.getCategoria(pesoAnt,alturaAnt)
    private var categoriaN : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculate_imc)
        pesoAnt = intent.extras?.getDouble("WEIGHT") ?: 0.0
        alturaAnt = intent.extras?.getInt("HEIGHT") ?: 0
        preferencesApp = PreferencesApp(applicationContext)
        comandoPopup = Popup(applicationContext)
        imcCalculator = IMCCalculator(applicationContext)
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
        btnAtras.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        btnCalcular.setOnClickListener {
            imcN = imcCalculator.calculateIMC(pesoN,alturaN).toDouble()
            categoriaN = imcCalculator.getCategoria(pesoN,alturaN)

            preferencesApp.setWeight(pesoN.toFloat())
            preferencesApp.setHeight(alturaN)

            if (pesoAnt==0.0){
                comandoPopup.showPopupPrimerResultado(imcN, categoriaN)
            } else if (categoriaN == R.string.normal.toString()){
                comandoPopup.showPopupResNormal(imcN,categoriaN)
            } else if (imcN < 25.0){
                if (imcN<imcAnt){
                    comandoPopup.showPopupEmpeoro(imcN,categoriaN)
                }else{
                    //mejoro el paciente
                }
            } else {
                if (imcN>imcAnt){
                    comandoPopup.showPopupEmpeoro(imcN,categoriaN)
                } else {
                    //mejoro
                }
            }

            onBackPressedDispatcher.onBackPressed()
        }
        pesoRS.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            pesoN = df.format(value).toDouble()
            pesoValue.text = "${df.format(value)} kg"
        }
        alturaRS.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            alturaN = df.format(value).toInt()
            alturaValue.text = "${df.format(value)} cm"
        }
    }
}