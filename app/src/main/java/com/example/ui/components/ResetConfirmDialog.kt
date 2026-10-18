package com.example.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.TajawalFontFamily

@Composable
fun ResetConfirmDialog(
  onConfirm: () -> Unit,
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    shape = RoundedCornerShape(24.dp),
    containerColor = MaterialTheme.colorScheme.surface,
    title = {
      Text(
        text = "تصفير العداد",
        fontFamily = TajawalFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.onSurface
      )
    },
    text = {
      Text(
        text = "هل أنت متأكد من رغبتك في تصفير عداد الاستغفار والبدء من جديد؟",
        fontFamily = TajawalFontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    },
    confirmButton = {
      TextButton(
        onClick = onConfirm,
        modifier = Modifier.testTag("confirm_reset_button"),
        colors = ButtonDefaults.textButtonColors(
          contentColor = MaterialTheme.colorScheme.error
        )
      ) {
        Text(
          text = "تصفير",
          fontFamily = TajawalFontFamily,
          fontWeight = FontWeight.Bold,
          fontSize = 16.sp
        )
      }
    },
    dismissButton = {
      TextButton(
        onClick = onDismiss,
        modifier = Modifier.testTag("cancel_reset_button")
      ) {
        Text(
          text = "إلغاء",
          fontFamily = TajawalFontFamily,
          fontSize = 16.sp,
          color = MaterialTheme.colorScheme.onSurface
        )
      }
    }
  )
}
