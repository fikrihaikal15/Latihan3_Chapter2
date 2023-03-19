package com.example.latihan3_chapter2

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.latihan3_chapter2.databinding.ActivityHomeBinding
import com.example.latihan3_chapter2.databinding.ActivityMainBinding
import org.intellij.lang.annotations.Language
import java.util.Locale

class MainActivity : AppCompatActivity() {
    //viewBinding
    private lateinit var binding: ActivityMainBinding

    //pilihBahasa(Localization)
    private lateinit var pilihBahasa:TextView
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //viweBinding
        setContentView(binding.root)
        binding.btn1.setOnClickListener{
           startActivity(Intent(this,Home::class.java))
        }
        binding.tv2.setOnClickListener{
            startActivity(Intent(this,Register::class.java))
        }

        //localization
        LoadLocald()

        //localization
        pilihBahasa = findViewById(R.id.pilihBahasa)
        pilihBahasa.setOnClickListener(View.OnClickListener {
            openDialogforLanguageChange()
        })
    }



    private fun openDialogforLanguageChange() {
        val list = arrayOf("Indonesia","Spanyol","Jerman")
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Pilih Bahasa")
        alertDialog.setSingleChoiceItems(list,-1,DialogInterface.OnClickListener { dialog, i ->

            if (i==0){
                setLocale("id")
                recreate()

            }else if (i==1){
                setLocale("es")
                recreate()

            }else if (i==2){
                setLocale("de")
                recreate()
            }
        })
        alertDialog.setNeutralButton("Cancle",DialogInterface.OnClickListener { dialog, which ->
            dialog.cancel()
        })

        val mDialog = alertDialog.create()
        mDialog.show()

    }

    private fun setLocale(language: String) {
        val local = Locale(language)

        Locale.setDefault(local)

        val config = Configuration()

        config.locale = local

        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
        editor = getSharedPreferences(" ",Context.MODE_PRIVATE).edit()
        editor.putString("Pilih Bahasa",language)
        editor.apply()
    }

    private fun LoadLocald() {
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val language = sharedPreferences.getString("Pilih Bahasa", " ")

        if (language != null) {
            setLocale(language)
        }


    }
}