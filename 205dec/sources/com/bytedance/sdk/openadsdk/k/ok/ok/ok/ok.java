package com.bytedance.sdk.openadsdk.k.ok.ok.ok;

import com.bykv.ok.ok.ok.ok.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f35937a;
    private ValueSet ok = a.f24747c;

    public ok(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f35937a = fullScreenVideoAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f35937a;
        if (fullScreenVideoAdInteractionListener == null) {
            return null;
        }
        switch (i4) {
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
