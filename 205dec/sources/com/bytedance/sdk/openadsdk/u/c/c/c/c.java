package com.bytedance.sdk.openadsdk.u.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36303c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTDrawFeedAd.DrawVideoListener f36304w;

    public c(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f36304w = drawVideoListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.f36304w;
        if (drawVideoListener == null) {
            return null;
        }
        switch (i4) {
            case 171101:
                drawVideoListener.onClick();
                break;
            case 171102:
                drawVideoListener.onClickRetry();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36303c;
    }
}
