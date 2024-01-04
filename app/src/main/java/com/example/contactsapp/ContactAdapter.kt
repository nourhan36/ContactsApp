package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val contacts: List<Contact>):
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun getItemCount(): Int = contacts?.size ?: 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        if (contact != null) {
            holder.contactImage.setImageResource(contact?.contactImageId ?: R.drawable.profile)
            holder.userName.text = contact?.userName
            holder.phone.text = contact?.phone
        }
        if (onContactClickListener != null) {
            holder.itemView.setOnClickListener {
                onContactClickListener?.onItemClick(position, contact)
            }
        }
    }

    var onContactClickListener: onItemClickListener? = null

    interface onItemClickListener {
        fun onItemClick(position: Int, contact: Contact)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage: ImageView = itemView.findViewById(R.id.contact_image)
        val userName: TextView = itemView.findViewById(R.id.name)
        val phone: TextView = itemView.findViewById(R.id.phone)
    }
}