package com.bytedance.pangle.sdk.component.log.impl;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IAdLog {
    void flushMemoryAndDB();

    void reportBatchStatsEvent(AdLogEventFace adLogEventFace);

    void reportEvent(AdLogEventFace adLogEventFace);

    void reportHighPriorityEvent(AdLogEventFace adLogEventFace);

    void reportRealStatsEvent(AdLogEventFace adLogEventFace);

    void reportRealTimeAdEvent(AdLogEventFace adLogEventFace);

    void start();

    void stop();

    void track(String str, List<String> list, boolean z3);

    void trackFailedUrls(String str);

    void trackStop();
}
