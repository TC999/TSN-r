package com.bytedance.sdk.openadsdk.gb.c.c.c;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35881c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdInteractionListener f35882w;

    public c(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f35882w = rewardAdInteractionListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.f35882w;
        if (rewardAdInteractionListener == null) {
            return null;
        }
        switch (i4) {
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
                this.f35882w.onRewardVerify(valueSet.booleanValue(0), valueSet.intValue(1), (String) valueSet.objectValue(2, String.class), valueSet.intValue(3), (String) valueSet.objectValue(4, String.class));
                break;
            case 121107:
                this.f35882w.onRewardArrived(valueSet.booleanValue(0), valueSet.intValue(1), (Bundle) valueSet.objectValue(2, Bundle.class));
                break;
            case 121108:
                rewardAdInteractionListener.onSkippedVideo();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35881c;
    }
}
