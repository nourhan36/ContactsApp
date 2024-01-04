package com.example.contactsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.contactsapp.databinding.ActivityShowContactBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailsContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowContactBinding
    lateinit var btnBack : FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact: Contact? = intent.getParcelableExtra("contact")
        binding.tvShowName.text = contact?.userName
        binding.tvShowPhone.text = contact?.phone
        binding.tvShowDescription.text = contact?.description

        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener{
            val intent = Intent(this@DetailsContactActivity , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}