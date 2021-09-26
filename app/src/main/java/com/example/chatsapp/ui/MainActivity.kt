package com.example.chatsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatsapp.databinding.ActivityMainBinding
import com.sawolabs.androidsdk.Sawo


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            Sawo(
                this,
                "45f9cdb8-a4f2-47f9-ac8a-3a7a1941f22e", // your api key
                "6150a9218e2ebbe8b4bff53drMslOoazKX5s2hAse9qWZKav"  // your api key secret
            ).login(
                "email", // can be one of 'email' or 'phone_number_sms'
                SecondActivity::class.java.name // Callback class name
            )
        }
    }
}