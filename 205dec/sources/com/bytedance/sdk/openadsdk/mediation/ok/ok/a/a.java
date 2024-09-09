package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationInterstitialFullAdListener f36234a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.f36234a = iMediationInterstitialFullAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener = this.f36234a;
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
                this.f36234a.onInterstitialFullShowFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
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
                this.f36234a.onRewardVerify((Bundle) valueSet.objectValue(0, Bundle.class));
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
