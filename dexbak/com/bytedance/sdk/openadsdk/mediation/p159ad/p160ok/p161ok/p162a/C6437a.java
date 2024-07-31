package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6437a implements Bridge {

    /* renamed from: a */
    private final IMediationDislikeCallback f22690a;

    /* renamed from: ok */
    private ValueSet f22691ok = C5930a.f21279c;

    public C6437a(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f22690a = iMediationDislikeCallback;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f22690a;
        if (iMediationDislikeCallback == null) {
            return null;
        }
        switch (i) {
            case 268013:
                this.f22690a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 268014:
                iMediationDislikeCallback.onCancel();
                break;
            case 268015:
                iMediationDislikeCallback.onShow();
                break;
        }
        m36279ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36279ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22691ok;
    }
}
