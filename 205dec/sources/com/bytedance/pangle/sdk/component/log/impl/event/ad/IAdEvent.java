package com.bytedance.pangle.sdk.component.log.impl.event.ad;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IAdEvent {
    JSONObject getDelayEvent(String str);

    long getGlobalEventIndex();

    long getNewCreateTime();
}
