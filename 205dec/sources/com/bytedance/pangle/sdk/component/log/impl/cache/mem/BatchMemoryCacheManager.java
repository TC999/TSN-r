package com.bytedance.pangle.sdk.component.log.impl.cache.mem;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.Queue;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BatchMemoryCacheManager extends EventMemoryCacheManager<AdLogEventFace> {
    public BatchMemoryCacheManager(PolicyConfig policyConfig, Queue<String> queue) {
        super(policyConfig, queue, "Batch");
    }
}
