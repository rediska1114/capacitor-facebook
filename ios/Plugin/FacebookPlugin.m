#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(FacebookPlugin, "Facebook",
           CAP_PLUGIN_METHOD(echo, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(logEvent, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(setAdvertiserTracking, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(getAdvertiserTrackingStatus, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(setAutoLogAppEvents, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(setAdvertiserIDCollection, CAPPluginReturnPromise);
            CAP_PLUGIN_METHOD(setAudienceNetworkAdvertiserTracking, CAPPluginReturnPromise);
)
