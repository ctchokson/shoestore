package com.udacity.shoestore.models

import android.os.Parcelable
import android.widget.EditText
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable



object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String {
        // Converts Double to String.
        return value.toString()
    }

    @JvmStatic fun stringToDouble( value: String): Double {
        // Converts String to long.
        if(value.isNullOrEmpty()|| value.toDoubleOrNull() == null)
            return 0.0
        return value.toDouble()
    }
}