package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AmiriFontFamily
import com.example.ui.theme.TajawalFontFamily

@Composable
fun GoalReachedDialog(
  targetGoal: Int,
  onStartNewRound: () -> Unit,
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    shape = RoundedCornerShape(28.dp),
    containerColor = MaterialTheme.colorScheme.surface,
    tonalElevation = 6.dp,
    title = null,
    text = {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(top = 8.dp, bottom = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        // Icon badge
        Box(
          modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Rounded.CheckCircle,
            contentDescription = "تم الوصول للهدف",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(40.dp)
          )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Calm, beautiful message requested
        Text(
          text = "الله يتقبل منك",
          fontFamily = AmiriFontFamily,
          fontSize = 32.sp,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colorScheme.primary,
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "أتممت وردك بعدد $targetGoal استغفاراً مباركاً بإذن الله",
          fontFamily = TajawalFontFamily,
          fontSize = 16.sp,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
          textAlign = TextAlign.Center,
          lineHeight = 24.sp
        )
      }
    },
    confirmButton = {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Button(
          onClick = onStartNewRound,
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("start_new_round_button"),
          shape = RoundedCornerShape(14.dp),
          colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
          )
        ) {
          Icon(
            imageVector = Icons.Rounded.Refresh,
            contentDescription = null,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.size(8.dp))
          Text(
            text = "بدء عداد جديد",
            fontFamily = TajawalFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
          )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
          onClick = onDismiss,
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("continue_istighfar_button"),
          shape = RoundedCornerShape(14.dp)
        ) {
          Text(
            text = "متابعة الاستغفار",
            fontFamily = TajawalFontFamily,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.primary
          )
        }
      }
    },
    dismissButton = null
  )
}
