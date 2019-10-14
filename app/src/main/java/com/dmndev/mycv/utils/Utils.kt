package com.dmndev.mycv.utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.ProgressBar
import java.util.*
import java.util.logging.Level


fun Date.formatToString(): String {
    return "tetttttdata"
}


fun ProgressBar.setProperLevelAndColor(int: Int) {
    this.progress = int
    if (int == 5) {
        this.progressTintList = ColorStateList.valueOf(Color.RED)
    }
}

