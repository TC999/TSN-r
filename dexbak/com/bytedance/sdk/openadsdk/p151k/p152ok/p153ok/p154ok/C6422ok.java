package com.bytedance.sdk.openadsdk.p151k.p152ok.p153ok.p154ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* renamed from: com.bytedance.sdk.openadsdk.k.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6422ok implements Bridge {

    /* renamed from: a */
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f22589a;

    /* renamed from: ok */
    private ValueSet f22590ok = C5930a.f21279c;

    public C6422ok(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f22589a = fullScreenVideoAdInteractionListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f22589a;
        if (fullScreenVideoAdInteractionListener == null) {
            return null;
        }
        switch (i) {
            case 131101:
                fullScreenVideoAdInteractionListener.onAdShow();
                break;
            case 131102:
                fullScreenVideoAdInteractionListener.onAdVideoBarClick();
                break;
            case 131103:
                fullScreenVideoAdInteractionListener.onAdClose();
                break;
            case 131104:
                fullScreenVideoAdInteractionListener.onVideoComplete();
                break;
            case 131105:
                fullScreenVideoAdInteractionListener.onSkippedVideo();
                break;
        }
        m36318ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36318ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22590ok;
    }
}
