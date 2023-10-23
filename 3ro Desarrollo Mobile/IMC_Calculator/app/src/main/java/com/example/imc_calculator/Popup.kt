package com.example.imc_calculator

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class Popup (private val context: Context) {

    var dialogDontShow = false
    var name = ""
    var genre = "Female"

    fun showPopupInicio(){
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_inicio)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val aceptButton : Button = dialog.findViewById(R.id.acept)
        val dontShowButton : Button = dialog.findViewById(R.id.dont_show)

        aceptButton.setOnClickListener {
            dialog.dismiss()
        }
        dontShowButton.setOnClickListener {
            Toast.makeText(context, "No se mostrará de nuevo", Toast.LENGTH_LONG).show()
            dialogDontShow=true
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showPopupDatos(){
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_datos)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val nameInput: EditText = dialog.findViewById(R.id.name_ti)
        val aceptButton : Button = dialog.findViewById(R.id.acept)
        val femaleCard : CardView = dialog.findViewById(R.id.female_btn)
        val femaleTxt : TextView = dialog.findViewById(R.id.female_txt)
        val maleCard : CardView = dialog.findViewById(R.id.male_btn)
        val maleTxt : TextView = dialog.findViewById(R.id.male_txt)

        femaleCard.setOnClickListener {
            femaleCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.green))
            maleCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.light_gray))
            femaleTxt.setTextColor(ContextCompat.getColor(context, R.color.white))
            maleTxt.setTextColor(ContextCompat.getColor(context, R.color.light_green))
            genre = R.string.female.toString()
        }

        maleCard.setOnClickListener {
            maleCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.green))
            femaleCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.light_gray))
            maleTxt.setTextColor(ContextCompat.getColor(context, R.color.white))
            femaleTxt.setTextColor(ContextCompat.getColor(context, R.color.light_green))
            genre = R.string.male.toString()
        }

        aceptButton.setOnClickListener {
            if (nameInput.text.isEmpty()) {
                Toast.makeText(context, "Ingrese su nombre", Toast.LENGTH_LONG).show()
            } else {
                name = nameInput.text.toString()
                dialog.dismiss()
            }
        }

        dialog.show()
    }

    fun showPopupPrimerResultado( imc: Double, category: String){
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_primer_inicio)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val imcValue : TextView = dialog.findViewById(R.id.imc_value)
        val categoryValue : TextView = dialog.findViewById(R.id.categoria_value)
        val aceptButton : Button = dialog.findViewById(R.id.acept)

        imcValue.text = imc.toString()
        categoryValue.text = category

        aceptButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showPopupResNormal( imc: Double, category: String){
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.popup_normal)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val imcValue : TextView = dialog.findViewById(R.id.imc_value)
        val categoryValue : TextView = dialog.findViewById(R.id.categoria_value)
        val aceptButton : Button = dialog.findViewById(R.id.acept)

        imcValue.text = imc.toString()
        categoryValue.text = category

        aceptButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}