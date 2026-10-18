package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.R

val AmiriFontFamily = FontFamily(
  Font(R.font.amiri, FontWeight.Normal)
)

val TajawalFontFamily = FontFamily(
  Font(R.font.tajawal, FontWeight.Normal)
)

val Typography = Typography(
  displayLarge = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 72.sp,
    lineHeight = 76.sp,
    letterSpacing = 0.sp
  ),
  displayMedium = TextStyle(
    fontFamily = AmiriFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 38.sp,
    lineHeight = 52.sp,
    letterSpacing = 0.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp
  ),
  titleLarge = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 20.sp,
    lineHeight = 28.sp
  ),
  bodyLarge = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
  ),
  bodyMedium = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp
  ),
  labelLarge = TextStyle(
    fontFamily = TajawalFontFamily,
    fontWeight = FontWeight.Medium,
    fontSize = 15.sp,
    lineHeight = 20.sp
  )
)
