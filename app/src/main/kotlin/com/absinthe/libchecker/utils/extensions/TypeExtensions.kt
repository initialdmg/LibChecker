package com.absinthe.libchecker.utils.extensions

import android.content.Context
import com.absinthe.libchecker.constant.Constants
import com.absinthe.libchecker.utils.Formatter
import java.io.File

fun String.isTempApk(): Boolean {
  return endsWith("${File.separator}${Constants.TEMP_PACKAGE}")
}

fun Long.sizeToString(context: Context, showBytes: Boolean = true): String {
  val formattedSize = Formatter.formatFileSize(context, this)
  return if (showBytes) "$formattedSize ($this Bytes)" else formattedSize
}

fun ByteArray.toHex(): String {
  return buildString {
    this@toHex.forEach {
      var hex = Integer.toHexString(it.toInt() and 0xFF)
      if (hex.length == 1) {
        hex = "0$hex"
      }
      append(hex.lowercase())
    }
  }
}
