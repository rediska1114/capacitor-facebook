import { WebPlugin } from '@capacitor/core';

import type { FacebookPlugin, LogEventParams } from './definitions';

export class FacebookWeb extends WebPlugin implements FacebookPlugin {
  logEvent(_: { name: string; params?: LogEventParams }): Promise<void> {
    console.warn('Method not implemented.');
    return Promise.resolve();
  }
  setAdvertiserTracking(_: { enabled: boolean }): Promise<void> {
    console.warn('Method not implemented.');
    return Promise.resolve();
  }
  getAdvertiserTrackingStatus(): Promise<{ enabled: boolean }> {
    console.warn('Method not implemented.');
    return Promise.resolve({ enabled: false });
  }
  setAutoLogAppEvents(_: { enabled: boolean }): Promise<void> {
    console.warn('Method not implemented.');
    return Promise.resolve();
  }
  setAdvertiserIDCollection(_: { enabled: boolean }): Promise<void> {
    console.warn('Method not implemented.');
    return Promise.resolve();
  }
  setAudienceNetworkAdvertiserTracking(_: { enabled: boolean }): Promise<void> {
    console.warn('Method not implemented.');
    return Promise.resolve();
  }
}
