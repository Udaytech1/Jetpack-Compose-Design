package com.findandhire.utils

import android.content.Context
import android.widget.Toast

class Commons {
    companion object{
        var toast : Toast? = null
        fun showToast(context: Context,msg: String){
            toast?.cancel()
            toast = Toast.makeText(context,msg,Toast.LENGTH_LONG)
            toast?.show()

        }
    }
}