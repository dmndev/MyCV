package com.dmndev.mycv.utils

import java.text.SimpleDateFormat
import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ProgressBar
import java.util.*


fun Date.formatToString(): String {
    val sdf = SimpleDateFormat("MM/yyyy", Locale.UK)
    return sdf.format(this)
}


fun ProgressBar.setProperLevelAndColor(int: Int) {
    this.progress = int
    if (int == 5) {
        this.progressTintList = ColorStateList.valueOf(Color.RED)
    }
}

