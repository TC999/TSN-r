package com.bytedance.sdk.openadsdk.fz.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ys.c.c.fp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35864c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.RewardVideoAdListener f35865w;

    public f(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f35865w = rewardVideoAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.f35865w;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 124101:
                this.f35865w.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.f35865w.onRewardVideoAdLoad(new fp((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.f35865w.onRewardVideoCached(new fp((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35864c;
    }
}
