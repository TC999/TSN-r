package com.bytedance.pangle.sdk.component.log.impl.event.policy;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SerialPolicy implements IEventPolicy {
    private PolicyConfig mConfig;

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.policy.IEventPolicy
    public int compare(AdLogEventFace adLogEventFace, AdLogEventFace adLogEventFace2) {
        return adLogEventFace.getPriority() - adLogEventFace2.getPriority();
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.event.policy.IEventPolicy
    public void setPolicyConfig(PolicyConfig policyConfig) {
        this.mConfig = policyConfig;
    }
}
