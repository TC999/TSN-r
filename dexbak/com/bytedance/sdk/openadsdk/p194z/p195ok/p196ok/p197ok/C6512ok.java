package com.bytedance.sdk.openadsdk.p194z.p195ok.p196ok.p197ok;

import android.os.Bundle;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* renamed from: com.bytedance.sdk.openadsdk.z.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6512ok implements Bridge {

    /* renamed from: a */
    private final TTRewardVideoAd.RewardAdInteractionListener f22894a;

    /* renamed from: ok */
    private ValueSet f22895ok = C5930a.f21279c;

    public C6512ok(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f22894a = rewardAdInteractionListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.f22894a;
        if (rewardAdInteractionListener == null) {
            return null;
        }
        switch (i) {
            case 121101:
                rewardAdInteractionListener.onAdShow();
                break;
            case 121102:
                rewardAdInteractionListener.onAdVideoBarClick();
                break;
            case 121103:
                rewardAdInteractionListener.onAdClose();
                break;
            case 121104:
                rewardAdInteractionListener.onVideoComplete();
                break;
            case 121105:
                rewardAdInteractionListener.onVideoError();
                break;
            case 121106:
                this.f22894a.onRewardVerify(valueSet.booleanValue(0), valueSet.intValue(1), (String) valueSet.objectValue(2, String.class), valueSet.intValue(3), (String) valueSet.objectValue(4, String.class));
                break;
            case 121107:
                this.f22894a.onRewardArrived(valueSet.booleanValue(0), valueSet.intValue(1), (Bundle) valueSet.objectValue(2, Bundle.class));
                break;
            case 121108:
                rewardAdInteractionListener.onSkippedVideo();
                break;
        }
        m36185ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36185ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22895ok;
    }
}
