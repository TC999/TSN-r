package com.bytedance.sdk.openadsdk.api;

import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bykv.p110vk.openvk.api.proto.Result;

/* renamed from: com.bytedance.sdk.openadsdk.api.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6279a {

    /* renamed from: ok */
    protected EventListener f22359ok;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ok */
    public void m36775ok(int i, Result result) {
        if (m36777ok()) {
            return;
        }
        this.f22359ok.onEvent(i, result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ok */
    public void m36776ok(int i) {
        m36775ok(i, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ok */
    public boolean m36777ok() {
        return this.f22359ok == null;
    }
}
