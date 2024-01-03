package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: FloatingActionButton = findViewById(R.id.btn_add)

        // Set an OnClickListener to handle the click event
        btn.setOnClickListener {
            // Open another activity when the button is clicked
            val intent = Intent(this@MainActivity, AddContact::class.java)
            startActivity(intent)
        }
    }
}