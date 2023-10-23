package com.example.imc_calculator

import android.content.Context

class PreferencesApp (val context: Context) {

    val SHARED_NAME = "user_data"
    val SHARED_USER_NAME = "user"
    val SHARED_USER_GENRE = "genre"
    val DONT_SHOW_DIALOG = "dialog_preference"
    val SHARED_USER_WEIGHT = "weigth"
    val SHARED_USER_HEIGHT = "height"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun setName (name: String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun setGenre(genre :String){
        storage.edit().putString(SHARED_USER_GENRE, genre).apply()
    }

    fun setDialog (pref : Boolean){
        storage.edit().putBoolean(DONT_SHOW_DIALOG, pref).apply()
    }

    fun setWeight (weight : Float){
        storage.edit().putFloat(SHARED_USER_WEIGHT, weight).apply()
    }

    fun setHeight(height : Int){
        storage.edit().putInt(SHARED_USER_HEIGHT, height).apply()
    }

    fun getName():String{
        return  storage.getString(SHARED_USER_NAME, "")!!
    }

    fun getGenre():String{
        return  storage.getString(SHARED_USER_GENRE, "")!!
    }

    fun getDialog():Boolean{
        return  storage.getBoolean(DONT_SHOW_DIALOG, false)
    }

    fun getWeight ():Float{
        return  storage.getFloat(SHARED_USER_WEIGHT, 0.0F)
    }

    fun getHeight():Int{
        return  storage.getInt(SHARED_USER_HEIGHT, 0)
    }
}