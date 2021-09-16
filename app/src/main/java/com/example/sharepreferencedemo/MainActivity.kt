package com.example.sharepreferencedemo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharepreferencedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var sharedPref = getSharedPreferences("myPref",Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.button2.setOnClickListener {
            val name = binding.et1.text.toString()
            val age = binding.et2.text.toString().toInt()
            val isAdult = binding.checkbox.isChecked

            editor.apply {
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
            }


        }
        binding.button1.setOnClickListener {
            val name = sharedPref.getString("name",null)
            val age = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            binding.et1.setText(name)
            binding.et2.setText(age.toString())
            binding.checkbox.isChecked = isAdult

        }
    }
}