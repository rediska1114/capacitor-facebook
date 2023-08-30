export interface FacebookPlugin {
  logEvent(options: { name: string; params?: LogEventParams }): Promise<void>;
  setAdvertiserTracking(options: { enabled: boolean }): Promise<void>;
  getAdvertiserTrackingStatus(): Promise<{ enabled: boolean }>;
  setAutoLogAppEvents(options: { enabled: boolean }): Promise<void>;
  setAdvertiserIDCollection(options: { enabled: boolean }): Promise<void>;
  getAnonymousID(): Promise<{ anonymousID: string }>;
}

export type LogEventParams = Object & { valueToSum?: number };
