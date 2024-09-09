package com.bytedance.sdk.openadsdk.p.ok.ok.ok;

import com.bykv.ok.ok.ok.ok.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTDrawFeedAd.DrawVideoListener f36255a;
    private ValueSet ok = a.f24747c;

    public ok(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f36255a = drawVideoListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.f36255a;
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
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
