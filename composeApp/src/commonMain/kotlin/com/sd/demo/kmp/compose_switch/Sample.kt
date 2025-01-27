package com.sd.demo.kmp.compose_switch

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sd.lib.kmp.compose_switch.DefaultSwitchBackground
import com.sd.lib.kmp.compose_switch.DefaultSwitchThumb
import com.sd.lib.kmp.compose_switch.FSwitch
import com.sd.lib.kmp.compose_switch.rememberSwitchState

@Composable
fun Sample(
  onClickBack: () -> Unit,
) {
  RouteScaffold(
    title = "Sample",
    onClickBack = onClickBack,
  ) {
    SampleDefault()
    SampleCustom1()
    SampleCustom2()
  }
}

@Composable
private fun SampleDefault() {
  var checked by remember { mutableStateOf(false) }
  val state = rememberSwitchState(checked) {
    logMsg { "onCheckedChange: $it" }
    checked = it
  }

  FSwitch(state = state)
}

@Composable
private fun SampleCustom1() {
  var checked by remember { mutableStateOf(true) }
  val state = rememberSwitchState(checked) { checked = it }

  FSwitch(
    state = state,
    background = {
      DefaultSwitchBackground(
        progress = state.progress,
        colorChecked = Color.Red,
        shape = RoundedCornerShape(5.dp),
      )
    },
    thumb = {
      DefaultSwitchThumb(shape = RoundedCornerShape(5.dp))
    },
  )
}

@Composable
private fun SampleCustom2() {
  var checked by remember { mutableStateOf(false) }
  val state = rememberSwitchState(checked) { checked = it }

  FSwitch(
    state = state,
    background = {
      DefaultSwitchBackground(
        modifier = Modifier.fillMaxHeight(state.progress.coerceAtLeast(0.2f)),
        progress = state.progress,
        shape = RoundedCornerShape(5.dp)
      )
    },
    thumb = {
      Card(
        modifier = Modifier
          .aspectRatio(1f, true)
          .padding(start = 0.dp, end = 2.dp, top = 2.dp, bottom = 2.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(Dp.Hairline, Color(0xFFE3E3E3))
      ) {}
    },
  )
}
