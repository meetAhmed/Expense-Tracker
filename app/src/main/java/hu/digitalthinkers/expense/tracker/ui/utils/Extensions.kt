package hu.digitalthinkers.expense.tracker.ui.utils

import android.app.Activity
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

/**
 * Simple Extension method to show toast message
 */
fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * Extension method to convert string to double
 * We are also handling the exceptional cases
 * So, we prefer to get 0.0 instead of forced crash
 */
fun String.toDoubleForm(): Double {
    return try {
        this.trim().toDouble()
    } catch (e: Exception) {
        0.0
    }
}

/**
 * Extension method to convert long date to readable string date
 */
fun Long.toReadableDate(): String {
    val mFormat = SimpleDateFormat("yyyy.MM.dd", Locale.ENGLISH)
    return mFormat.format(this).trim()
}