package com.latifah.machinelearningwithmlkitandobjectrecognition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.latifah.machinelearningwithmlkitandobjectrecognition.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        Log.i("Main", "onCreate: from main")
//        val fm: FragmentManager = supportFragmentManager
//        fm.beginTransaction().replace(R.id.fragmentGetImage, ).commit()
//        fm.beginTransaction().replace(R.id.fragment_two, searchNewsFragment).commit()
    }
}