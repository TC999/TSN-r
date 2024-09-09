package com.bytedance.sdk.openadsdk.i.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35896c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTFeedAd.VideoRewardListener f35897w;

    public w(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f35897w = videoRewardListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35897w == null) {
            return null;
        }
        if (i4 == 163101) {
            this.f35897w.onFeedRewardCountDown(valueSet.intValue(0));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35896c;
    }
}
