package xyz.adscope.ad.control.track.inter;

import xyz.adscope.ad.control.track.inter.TrackEventEnum;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface ITrackEvent {
    void callBackEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent);

    void initWithRouter();

    void reportTrackerEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent);
}
