package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.i;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class kf implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdNative.RewardVideoAdListener f35889a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public kf(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f35889a = rewardVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.f35889a;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 124101:
                this.f35889a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.f35889a.onRewardVideoAdLoad(new i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.f35889a.onRewardVideoCached(new i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
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
