package com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6375i;

/* renamed from: com.bytedance.sdk.openadsdk.h.ok.ok.ok.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6415kf implements Bridge {

    /* renamed from: a */
    private final TTAdNative.RewardVideoAdListener f22575a;

    /* renamed from: ok */
    private ValueSet f22576ok = C5930a.f21279c;

    public C6415kf(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f22575a = rewardVideoAdListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.f22575a;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i) {
            case 124101:
                this.f22575a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.f22575a.onRewardVideoAdLoad(new C6375i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.f22575a.onRewardVideoCached(new C6375i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
        }
        m36325ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36325ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22576ok;
    }
}
