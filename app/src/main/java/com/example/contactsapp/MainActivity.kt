package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.contactsapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContactAdapter
    private lateinit var contactList: MutableList<Contact>
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button
    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etDescription: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        addContact()
    }


    private fun initRecyclerView() {
        contactList = mutableListOf()
        adapter = ContactAdapter(contactList)
        binding.rvContact.adapter = adapter
        adapter.onContactClickListener = object : ContactAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, contact: Contact) {
                val intent = Intent(this@MainActivity, DetailsContactActivity::class.java)
                intent.putExtra("contact", contact)
                startActivity(intent)
            }
        }
    }

    private fun addContact() {
        btnAdd = findViewById(R.id.btn_add_contact)
        binding.apply {
            btnAdd.setOnClickListener {
                val dialogView = LayoutInflater.from(this@MainActivity)
                    .inflate(R.layout.activity_add_contact, null)
                val addContactDialog =
                    AlertDialog.Builder(this@MainActivity, R.style.AlertDialogCustom)
                        .setView(dialogView).create()

                btnSave = dialogView.findViewById(R.id.btn_add)
                btnCancel = dialogView.findViewById(R.id.btn_cancel)
                etName = dialogView.findViewById(R.id.et_name)
                etPhone = dialogView.findViewById(R.id.et_phone)
                etDescription = dialogView.findViewById(R.id.et_description)
                btnCancel.setOnClickListener {
                    addContactDialog.dismiss()
                }
                btnSave.setOnClickListener {
                    if (validateName(etName.text.toString()) && validatePhoneNumber(etPhone.text.toString())) {
                        contactList.add(
                            Contact(
                                R.drawable.profile,
                                etName.text.toString(),
                                etPhone.text.toString(),
                                etDescription.text.toString()
                            )
                        )
                        adapter.notifyItemInserted(contactList.size - 1)
                        Toast.makeText(
                            this@MainActivity,
                            "Contact Added Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        addContactDialog.dismiss()
                    }
                }
                addContactDialog.show()
            }
        }
    }

    private fun validateName(name: String): Boolean {
        return name.trim().isNotEmpty() && name.length >= 3
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        val regex = Regex("^01\\d{9}$")
        return regex.matches(phoneNumber)
    }

}