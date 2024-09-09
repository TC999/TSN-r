package com.bytedance.sdk.openadsdk.q.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTFeedAd.VideoRewardListener f36259a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f36259a = videoRewardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36259a == null) {
            return null;
        }
        if (i4 == 163101) {
            this.f36259a.onFeedRewardCountDown(valueSet.intValue(0));
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
