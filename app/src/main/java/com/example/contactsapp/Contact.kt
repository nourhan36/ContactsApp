package com.example.contactsapp
import android.os.Parcel
import android.os.Parcelable

data class Contact(
    val contactImageId: Int,
    val userName: String,
    val phone:String,
    val description:String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(contactImageId)
        dest.writeString(userName)
        dest.writeString(phone)
        dest.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}