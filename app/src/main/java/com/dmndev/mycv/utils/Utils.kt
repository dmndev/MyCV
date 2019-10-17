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
    when (int) {
        1 -> this.progressTintList = ColorStateList.valueOf(Color.parseColor("#d1c4e9"))
        2 -> this.progressTintList = ColorStateList.valueOf(Color.parseColor("#b39ddb"))
        3 -> this.progressTintList = ColorStateList.valueOf(Color.parseColor("#9575cd"))
        4 -> this.progressTintList = ColorStateList.valueOf(Color.parseColor("#7e57c2"))
        5 -> this.progressTintList = ColorStateList.valueOf(Color.parseColor("#673ab7"))
    }
}

