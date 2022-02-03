package com.example.tasbhi

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    val PREF_NAME:String="tasbhi_app"
    val COUNT:String="COUNT"
    val TOTAL:String="TOTAL"
    val sharedPreferences: SharedPreferences? =context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun saveCount(count:String){
        val editor=sharedPreferences?.edit()
        editor?.putString(COUNT,count)
        editor?.apply()
    }
    fun saveTotalCount(total:String){
        val editor=sharedPreferences?.edit()
        editor?.putString(TOTAL,total)
        editor?.apply()
    }


    fun getCount(): String? = sharedPreferences?.getString(COUNT,"")
    fun getTotalCount(): String? = sharedPreferences?.getString(TOTAL,"")


}
