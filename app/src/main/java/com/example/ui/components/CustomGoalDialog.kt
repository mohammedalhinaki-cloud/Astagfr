package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.TajawalFontFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomGoalDialog(
  currentGoal: Int,
  onGoalSelected: (Int) -> Unit,
  onDismiss: () -> Unit
) {
  var textInput by remember { mutableStateOf(currentGoal.toString()) }
  val presets = listOf(33, 70, 100, 500, 1000)

  AlertDialog(
    onDismissRequest = onDismiss,
    shape = RoundedCornerShape(24.dp),
    containerColor = MaterialTheme.colorScheme.surface,
    title = {
      Text(
        text = "تحديد هدف الاستغفار",
        fontFamily = TajawalFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = MaterialTheme.colorScheme.onSurface
      )
    },
    text = {
      Column(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = "اختر من الأعداد الشائعة أو أدخل رقماً مخصصاً:",
          fontFamily = TajawalFontFamily,
          fontSize = 14.sp,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        FlowRow(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          presets.forEach { preset ->
            val isSelected = textInput == preset.toString()
            FilterChip(
              selected = isSelected,
              onClick = {
                textInput = preset.toString()
              },
              label = {
                Text(
                  text = "$preset",
                  fontFamily = TajawalFontFamily,
                  fontWeight = FontWeight.SemiBold
                )
              },
              colors = FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
              )
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
          value = textInput,
          onValueChange = { newValue ->
            // Keep only digits
            val filtered = newValue.filter { it.isDigit() }.take(6)
            textInput = filtered
          },
          label = {
            Text(
              text = "العدد المستهدف",
              fontFamily = TajawalFontFamily
            )
          },
          singleLine = true,
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("custom_goal_input")
        )
      }
    },
    confirmButton = {
      Button(
        onClick = {
          val goal = textInput.toIntOrNull() ?: 100
          if (goal > 0) {
            onGoalSelected(goal)
          }
        },
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = MaterialTheme.colorScheme.primary,
          contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = Modifier.testTag("apply_goal_button")
      ) {
        Text(
          text = "تأكيد",
          fontFamily = TajawalFontFamily,
          fontWeight = FontWeight.Bold,
          fontSize = 15.sp
        )
      }
    },
    dismissButton = {
      TextButton(
        onClick = onDismiss,
        modifier = Modifier.testTag("cancel_goal_button")
      ) {
        Text(
          text = "إلغاء",
          fontFamily = TajawalFontFamily,
          fontSize = 15.sp,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }
  )
}
