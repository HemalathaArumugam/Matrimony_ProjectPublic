package com.example.matrimony_project.livedata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.matrimony_project.R

data class ProfileData(
    val id:Int,
    val image:Int,
    val name: String?, val age: Int,
    val occupation: String?,
    val relatedImages: List<Int>):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createIntArray()?.toList() ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(occupation)
        parcel.writeIntArray(relatedImages.toIntArray())
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<ProfileData> {
        override fun createFromParcel(parcel: Parcel): ProfileData {
            return ProfileData(parcel)
        }

        override fun newArray(size: Int): Array<ProfileData?> {
            return arrayOfNulls(size)
        }
    }
}

class ProfileLiveData : ViewModel() {
    private val _Profiles: MutableLiveData<List<ProfileData>> = MutableLiveData()
    val Profiles: LiveData<List<ProfileData>> = _Profiles

    init {
        loadProfiles()
    }


    @SuppressLint("SuspiciousIndentation")
    private fun loadProfiles() {
        val profilesList = listOf(
            ProfileData(
                    id = 1,
                    R.drawable.image1,
                    name = "Keerthy",
                    age = 30,
                    occupation = "Software Engineer",
                    relatedImages = listOf(R.drawable.image1, R.drawable.image13, R.drawable.imag12)
                ),
            ProfileData(
                id = 2,
                R.drawable.image2 ,
                name = "Atmika",
                age = 25,
                occupation = "Product Manager",
                relatedImages = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
            ),
            ProfileData(
                id = 3,
                R.drawable.image3 ,
                name = "Alia",
                age = 35,
                occupation = "Data Scientist",
                relatedImages = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
            )
        )
           _Profiles.postValue(profilesList)
    }
}

