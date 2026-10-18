package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.IstighfarMode
import com.example.data.IstighfarPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("استغفار", appName)
  }

  @Test
  fun `test istighfar preferences persistence`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val prefs = IstighfarPreferences(context)

    prefs.saveGeneralCount(150L)
    prefs.saveTargetGoal(33)
    prefs.saveTargetCount(33)
    prefs.saveMode(IstighfarMode.TARGET)

    val state = prefs.loadState()
    assertEquals(150L, state.generalCount)
    assertEquals(33, state.targetGoal)
    assertEquals(33, state.targetCount)
    assertTrue(state.isGoalReached)
    assertEquals(IstighfarMode.TARGET, state.mode)
  }
}
