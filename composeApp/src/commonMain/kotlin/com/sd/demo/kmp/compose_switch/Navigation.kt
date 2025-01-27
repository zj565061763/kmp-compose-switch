package com.sd.demo.kmp.compose_switch

import kotlinx.serialization.Serializable

sealed interface AppRoute {
  @Serializable
  data object Home : AppRoute

  @Serializable
  data object Sample : AppRoute
}