import { registerPlugin } from '@capacitor/core';

import type { FacebookPlugin, LogEventParams } from './definitions';

const CapacitorFacebook = registerPlugin<FacebookPlugin>('Facebook', {
  web: () => import('./web').then(m => new m.FacebookWeb()),
});

export class Facebook {
  private plugin = CapacitorFacebook;

  async logEvent(name: string, params?: LogEventParams) {
    return this.plugin.logEvent({ name, params });
  }

  async setAdvertiserTracking(enabled: boolean) {
    return this.plugin.setAdvertiserTracking({ enabled });
  }

  async getAdvertiserTrackingStatus() {
    return this.plugin
      .getAdvertiserTrackingStatus()
      .then(({ enabled }) => enabled);
  }

  async setAutoLogAppEvents(enabled: boolean) {
    return this.plugin.setAutoLogAppEvents({ enabled });
  }

  async setAdvertiserIDCollection(enabled: boolean) {
    return this.plugin.setAdvertiserIDCollection({ enabled });
  }

  async setAudienceNetworkAdvertiserTracking(enabled: boolean) {
    return this.plugin.setAudienceNetworkAdvertiserTracking({ enabled });
  }
}

export * from './definitions';
