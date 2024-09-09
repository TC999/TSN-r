package com.bytedance.sdk.openadsdk.q.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36256c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f36257w;

    public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f36257w = fullScreenVideoAdInteractionListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f36257w;
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
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36256c;
    }
}
