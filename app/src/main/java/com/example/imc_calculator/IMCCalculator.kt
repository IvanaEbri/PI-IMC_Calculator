package com.example.imc_calculator

import android.content.Context
import android.icu.text.DecimalFormat
import kotlin.math.sqrt

class IMCCalculator (private val context: Context){
    private val preferencesApp : PreferencesApp =PreferencesApp(context)
    fun calculateIMC(weigth: Double, height: Int) :String{
        val imcNew = (weigth.toFloat()) / sqrt(height.toDouble()/100)
        val df = DecimalFormat("#.##")
        val imcFormat = df.format(imcNew)
        return imcFormat.toString()
    }

    fun getCategoria(weigth: Double, height: Int) :String{
        val rangeFemale = listOf<Double>(16.0,20.0,24.0,29.0,37.0)
        val rangeMale = listOf<Double>(17.0,20.0,25.0,30.0,40.0)
        val imcNew = calculateIMC(weigth, height).toDouble()
        var categoria = ""
        if (preferencesApp.getGenre()==R.string.female.toString()){
            categoria = evaluarIMC(rangeFemale,imcNew)
        } else {
            categoria = evaluarIMC(rangeMale,imcNew)
        }
        return categoria
    }

    private fun evaluarIMC(range: List<Double>, imcEv : Double): String{
        if (imcEv< range[0]){
            return R.string.low_w2.toString()
        } else if (imcEv < range[1]) {
            return R.string.low_w1.toString()
        } else if (imcEv < range[2]) {
            return R.string.normal.toString()
        }else if (imcEv < range[3]) {
            return R.string.over_w1.toString()
        } else if (imcEv < range[4]) {
            return R.string.over_w2.toString()
        } else {
            return R.string.over_w3.toString()
        }
    }
}