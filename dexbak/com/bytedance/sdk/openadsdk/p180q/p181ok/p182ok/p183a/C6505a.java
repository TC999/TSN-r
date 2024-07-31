package com.bytedance.sdk.openadsdk.p180q.p181ok.p182ok.p183a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* renamed from: com.bytedance.sdk.openadsdk.q.ok.ok.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6505a implements Bridge {

    /* renamed from: a */
    private final TTFeedAd.VideoRewardListener f22882a;

    /* renamed from: ok */
    private ValueSet f22883ok = C5930a.f21279c;

    public C6505a(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f22882a = videoRewardListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22882a == null) {
            return null;
        }
        if (i == 163101) {
            this.f22882a.onFeedRewardCountDown(valueSet.intValue(0));
        }
        m36190ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36190ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22883ok;
    }
}
