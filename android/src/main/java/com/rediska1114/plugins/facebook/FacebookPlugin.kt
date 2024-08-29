package com.rediska1114.plugins.facebook

import android.os.Bundle
import com.facebook.FacebookSdk.setAdvertiserIDCollectionEnabled
import com.facebook.FacebookSdk.setAutoLogAppEventsEnabled
import com.facebook.appevents.AppEventsLogger
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

@CapacitorPlugin(name = "Facebook")
class FacebookPlugin : Plugin() {
  private lateinit var logger: AppEventsLogger

  override fun load() {
    super.load()
    logger = AppEventsLogger.newLogger(context)
  }

  @PluginMethod
  fun logEvent(call: PluginCall) {
    val name = call.getString("name")
    if (name == null) {
      call.reject("missing name option")
      return
    }

    val parameters = call.getObject("params", JSObject())?.toBundle()
  
    val valueToSum = call.getDouble("valueToSum")
    if (valueToSum != null) {
      logger.logEvent(name, valueToSum, parameters)
    } else {
      logger.logEvent(name, parameters)
    }

    call.resolve()
  }

  @PluginMethod
  fun getAnonymousID(call: PluginCall) {
    val anonymousID = AppEventsLogger.getAnonymousAppDeviceGUID(context)
    val result = JSObject()
    result.put("anonymousID", anonymousID)
    call.resolve(result)
  }

  @PluginMethod
  fun setAdvertiserTracking(call: PluginCall) {
    val enabled = call.getBoolean("enabled")
    if (enabled == null) {
      call.reject("missing enabled option")
      return
    }

    //    setAdvertiserTrackingEnabled(enabled)
    call.resolve()
  }

  @PluginMethod
  fun getAdvertiserTrackingStatus(call: PluginCall) {
    val enabled = false // AppEventsLogger.getAdvertiserTrackingEnabled()
    val result = JSObject().apply {
      put("enabled", enabled)
    }
    call.resolve(result)
  }

  @PluginMethod
  fun setAutoLogAppEvents(call: PluginCall) {
    val enabled = call.getBoolean("enabled")
    if (enabled == null) {
      call.reject("missing enabled option")
      return
    }

    setAutoLogAppEventsEnabled(enabled)
    call.resolve()
  }

  @PluginMethod
  fun setAdvertiserIDCollection(call: PluginCall) {
    val enabled = call.getBoolean("enabled")
    if (enabled == null) {
      call.reject("missing enabled option")
      return
    }

    setAdvertiserIDCollectionEnabled(enabled)
    call.resolve()
  }

}

fun JSObject.toBundle(): Bundle {
  val bundle = Bundle()
  this.keys().forEach { key ->
    when (val value = this.get(key)) {
      is String -> bundle.putString(key, value)
      is Int -> bundle.putInt(key, value)
      is Boolean -> bundle.putBoolean(key, value)
      is Double -> bundle.putDouble(key, value)
      is Long -> bundle.putLong(key, value)
      else -> bundle.putString(key, value.toString())
    }
  }
  return bundle
}
