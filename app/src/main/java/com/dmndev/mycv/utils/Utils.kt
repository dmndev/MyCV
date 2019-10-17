package com.dmndev.mycv.utils

import java.text.SimpleDateFormat
import java.util.*


fun Date.formatToString(): String {
    val sdf = SimpleDateFormat("MM/yyyy", Locale.UK)
    return sdf.format(this)
}
