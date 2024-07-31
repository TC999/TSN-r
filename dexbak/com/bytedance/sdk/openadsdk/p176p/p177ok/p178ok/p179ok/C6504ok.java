package com.bytedance.sdk.openadsdk.p176p.p177ok.p178ok.p179ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;

/* renamed from: com.bytedance.sdk.openadsdk.p.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6504ok implements Bridge {

    /* renamed from: a */
    private final TTDrawFeedAd.DrawVideoListener f22880a;

    /* renamed from: ok */
    private ValueSet f22881ok = C5930a.f21279c;

    public C6504ok(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f22880a = drawVideoListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.f22880a;
        if (drawVideoListener == null) {
            return null;
        }
        switch (i) {
            case 171101:
                drawVideoListener.onClick();
                break;
            case 171102:
                drawVideoListener.onClickRetry();
                break;
        }
        m36191ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36191ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22881ok;
    }
}
