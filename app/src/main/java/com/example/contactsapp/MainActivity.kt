package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contactsapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        var btn: FloatingActionButton = findViewById(R.id.btn_add)
        btn.setOnClickListener({

        }
        )
    }

    lateinit var adapter: ContactAdapter
    lateinit var contactList: MutableList<Contact>
    private fun initRecyclerView() {
        createPostList()
        adapter = ContactAdapter(contactList)
        binding.rvContact.adapter = adapter
    }

    private fun createPostList() {
        contactList = mutableListOf()
        for (i in 1..1000) {
            contactList.add(
                Contact(
                    userName = "contact $i",
                    contactImageId = R.drawable.profile,
                    phone = "phone number $i",
                )
            )
        }
    }
}