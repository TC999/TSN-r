package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    protected EventListener f31497c;

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4, Result result) {
        if (c()) {
            return;
        }
        this.f31497c.onEvent(i4, result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i4) {
        c(i4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c() {
        return this.f31497c == null;
    }
}
