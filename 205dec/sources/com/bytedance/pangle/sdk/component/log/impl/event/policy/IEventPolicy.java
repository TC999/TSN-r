package com.bytedance.pangle.sdk.component.log.impl.event.policy;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IEventPolicy {
    int compare(AdLogEventFace adLogEventFace, AdLogEventFace adLogEventFace2);

    void setPolicyConfig(PolicyConfig policyConfig);
}
