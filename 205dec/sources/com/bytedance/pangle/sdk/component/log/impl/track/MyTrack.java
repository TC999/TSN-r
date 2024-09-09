package com.bytedance.pangle.sdk.component.log.impl.track;

import com.bytedance.pangle.sdk.component.log.impl.LogInternalManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class MyTrack {
    private static volatile TrackAdUrl sTrackAdUrl;

    public static TrackAdUrl getTrackAdUrl() {
        if (sTrackAdUrl == null) {
            synchronized (TrackAdUrl.class) {
                if (sTrackAdUrl == null) {
                    sTrackAdUrl = new TrackAdUrlImpl(LogInternalManager.getInstance().getContext(), new TrackRetryRepertoryImpl(LogInternalManager.getInstance().getContext()));
                }
            }
        }
        return sTrackAdUrl;
    }
}
