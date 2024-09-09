package com.bytedance.sdk.openadsdk.mediation.c.c.w;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36117c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationInterstitialFullAdListener f36118w;

    public w(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.f36118w = iMediationInterstitialFullAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener = this.f36118w;
        if (iMediationInterstitialFullAdListener == null) {
            return null;
        }
        switch (i4) {
            case 131101:
                iMediationInterstitialFullAdListener.onAdShow();
                break;
            case 131102:
                iMediationInterstitialFullAdListener.onAdVideoBarClick();
                break;
            case 131103:
                iMediationInterstitialFullAdListener.onAdClose();
                break;
            case 131104:
                iMediationInterstitialFullAdListener.onVideoComplete();
                break;
            case 131105:
                iMediationInterstitialFullAdListener.onSkippedVideo();
                break;
            case 131106:
                this.f36118w.onInterstitialFullShowFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 131107:
                iMediationInterstitialFullAdListener.onVideoError();
                break;
            case 131108:
                iMediationInterstitialFullAdListener.onAdOpened();
                break;
            case 131109:
                iMediationInterstitialFullAdListener.onAdLeftApplication();
                break;
            case 131110:
                this.f36118w.onRewardVerify((Bundle) valueSet.objectValue(0, Bundle.class));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36117c;
    }
}
