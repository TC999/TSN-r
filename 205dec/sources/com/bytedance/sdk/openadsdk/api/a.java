package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {
    protected EventListener ok;

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok(int i4, Result result) {
        if (ok()) {
            return;
        }
        this.ok.onEvent(i4, result);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ok(int i4) {
        ok(i4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ok() {
        return this.ok == null;
    }
}
