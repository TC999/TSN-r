package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a;

import android.os.Bundle;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6476a implements Bridge {

    /* renamed from: a */
    private final IMediationInterstitialFullAdListener f22839a;

    /* renamed from: ok */
    private ValueSet f22840ok = C5930a.f21279c;

    public C6476a(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.f22839a = iMediationInterstitialFullAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener = this.f22839a;
        if (iMediationInterstitialFullAdListener == null) {
            return null;
        }
        switch (i) {
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
                this.f22839a.onInterstitialFullShowFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
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
                this.f22839a.onRewardVerify((Bundle) valueSet.objectValue(0, Bundle.class));
                break;
        }
        m36224ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36224ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22840ok;
    }
}
