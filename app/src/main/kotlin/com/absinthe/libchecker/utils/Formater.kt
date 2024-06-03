package com.absinthe.libchecker.utils

import android.content.Context;
import java.util.Locale

object Formater {
  fun formatFileSize(context: Context, roundedBytes: Long): String {
    if (context == null) {
      // nothing to do
    }
    return formatFileSize(roundedBytes, false, Locale.US)
  }

  private fun formatFileSize(roundedBytes: Long, shorter: Boolean, locale: Locale): String {
    var result = roundedBytes.toFloat()
    var suffix = "B"
    if (result > 900) {
      suffix = "KB"
      result = result / 1024
    }
    if (result > 900) {
      suffix = "MB"
      result = result / 1024
    }
    if (result > 900) {
      suffix = "GB"
      result = result / 1024
    }
    if (result > 900) {
      suffix = "TB"
      result = result / 1024
    }
    if (result > 900) {
      suffix = "PB"
      result = result / 1024
    }
    val value: String
    if (result < 1) {
      value = String.format(locale, "%.2f", result)
    } else if (result < 10) {
      if (shorter) {
        value = String.format(locale, "%.1f", result)
      } else {
        value = String.format(locale, "%.2f", result)
      }
    } else if (result < 100) {
      if (shorter) {
        value = String.format(locale, "%.0f", result)
      } else {
        value = String.format(locale, "%.2f", result)
      }
    } else {
      value = String.format(locale, "%.0f", result)
    }
    return String.format("%s%s", value, suffix)
  }
}
