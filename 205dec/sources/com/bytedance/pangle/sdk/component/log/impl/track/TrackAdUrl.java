package com.bytedance.pangle.sdk.component.log.impl.track;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface TrackAdUrl {
    void stop();

    void track(String str, List<String> list, boolean z3);

    void trackFailedUrls(String str);
}
