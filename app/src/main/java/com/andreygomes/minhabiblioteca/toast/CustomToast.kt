package com.andreygomes.minhabiblioteca.toast

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.andreygomes.minhabiblioteca.R

class CustomToast(val context: Context, val inflater: LayoutInflater) {

    companion object {
        val WARNING = 1
        val SUCCESS = 2
        val ERROR = 3
        val INFO = 4
    }

    fun showToast(text: String, type: Int) {
        val customToastroot = inflater.inflate(R.layout.custom_toast, null)
        val customtoast = Toast(context)

        val textView = customToastroot.findViewById<TextView>(R.id.textView1)
        textView.text = text

        when (type) {
            WARNING -> customToastroot.setBackgroundResource(R.drawable.mycustom_toast_border_warning)
            SUCCESS -> customToastroot.setBackgroundResource(R.drawable.mycustom_toast_border_success)
            ERROR -> customToastroot.setBackgroundResource(R.drawable.mycustom_toast_border_error)
            INFO -> customToastroot.setBackgroundResource(R.drawable.mycustom_toast_border_info)
            else -> { // Note the block
                customToastroot.setBackgroundResource(R.drawable.mycustom_toast_border)
            }
        }

        customtoast.view = customToastroot
        customtoast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)
        customtoast.duration = Toast.LENGTH_LONG

        customtoast.show()
    }

}