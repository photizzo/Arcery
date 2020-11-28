package com.agromall.tellerium.util

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import com.agromall.tellerium.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

fun Activity.showSnackbar(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
    actionString: String = "",
    listener: View.OnClickListener? = null,
    view: View? = null
) {
    val snackbar = Snackbar.make(view ?: findViewById(android.R.id.content), message, length)

    if (actionString.isNotEmpty()) {
        snackbar.setAction(actionString, listener)
    }
    snackbar.show()
}
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun ImageView.displayWeatherIcon(code: Int) {
    when (code) {
        in 200..299 -> {
            this.setImageResource(R.drawable.ic_storm)
        }
        in 300..399 -> {
            this.setImageResource(R.drawable.ic_partly_showers)
        }
        in 500..599 -> {
            this.setImageResource(R.drawable.ic_rain)
        }
        in 600..699 -> {
            this.setImageResource(R.drawable.ic_snow)
        }
        in 700..799 -> {
            this.setImageResource(R.drawable.ic_atmosphere)
        }
        800 -> {
            this.setImageResource(R.drawable.ic_sunny)
        }
        in 801..899 -> {
            this.setImageResource(R.drawable.ic_cloud)
        }
        else -> {
            this.setImageResource(R.drawable.ic_partly_sunny)
        }
    }
}

fun Long.getFormattedDate(): String {
    val smsTime = Calendar.getInstance()
    smsTime.timeInMillis = this

    val now = Calendar.getInstance()

    val timeFormatString = "h:mm aa"
    val dateTimeFormatString = "EEEE, MMMM d, h:mm aa"
    val HOURS = (60 * 60 * 60).toLong()
    return if (now.get(Calendar.DATE) == smsTime.get(Calendar.DATE)) {
        "Today " + DateFormat.format(timeFormatString, smsTime)
    } else if (now.get(Calendar.DATE) - smsTime.get(Calendar.DATE) == 1) {
        "Yesterday " + DateFormat.format(timeFormatString, smsTime)
    } else if (now.get(Calendar.YEAR) == smsTime.get(Calendar.YEAR)) {
        DateFormat.format(dateTimeFormatString, smsTime).toString()
    } else {
        DateFormat.format("MMMM dd yyyy", smsTime).toString()
    }
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}

fun TextInputLayout.validate(message: String, validator: (String) -> Boolean) {
    this.editText?.afterTextChanged {
        if (validator(it)) {
            this.error = message
        } else {
            this.error = null
        }
    }
}

fun TextInputEditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}
