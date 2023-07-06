import Capacitor
import FBAudienceNetwork
import FBSDKCoreKit
import Foundation

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(FacebookPlugin)
public class FacebookPlugin: CAPPlugin {
    @objc func logEvent(_ call: CAPPluginCall) {
        guard let name = call.getString("name") else {
            return call.reject("missing name option")
        }

        guard let params = call.getObject("params") else {
            return call.reject("missing params option")
        }

        let parameters = params.reduce(into: [AppEvents.ParameterName: Any]()) { partialResult, arg1 in
            partialResult[.init(arg1.key)] = arg1.value
        }

        if let valueToSum = call.getDouble("valueToSum") {
            AppEvents.shared.logEvent(AppEvents.Name(name), valueToSum: valueToSum, parameters: parameters)
        } else {
            AppEvents.shared.logEvent(AppEvents.Name(name), parameters: parameters)
        }

        call.resolve()
    }

    @objc func setAdvertiserTracking(_ call: CAPPluginCall) {
        guard let enabled = call.getBool("enabled") else {
            return call.reject("missing enabled option")
        }

        Settings.shared.isAdvertiserTrackingEnabled = enabled
        call.resolve()
    }

    @objc func getAdvertiserTrackingStatus(_ call: CAPPluginCall) {
        let enabled = Settings.shared.isAdvertiserTrackingEnabled
        call.resolve(["enabled": enabled])
    }

    @objc func setAutoLogAppEvents(_ call: CAPPluginCall) {
        guard let enabled = call.getBool("enabled") else {
            return call.reject("missing enabled option")
        }
        Settings.shared.isAutoLogAppEventsEnabled = enabled
        call.resolve()
    }

    @objc func setAdvertiserIDCollection(_ call: CAPPluginCall) {
        guard let enabled = call.getBool("enabled") else {
            return call.reject("missing enabled option")
        }
        Settings.shared.isAdvertiserIDCollectionEnabled = enabled
        call.resolve()
    }
}
