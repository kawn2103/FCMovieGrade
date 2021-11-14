package kst.app.fcmoviegrade.extension

import java.text.DecimalFormat

fun Float.toDecimalFormatString(format: String): String = DecimalFormat(format).format(this)