package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok.C6490ok;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6479ok implements Bridge {

    /* renamed from: a */
    private final IMediationDrawAdTokenCallback f22845a;

    /* renamed from: ok */
    private ValueSet f22846ok = C5930a.f21279c;

    public C6479ok(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f22845a = iMediationDrawAdTokenCallback;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22845a == null) {
            return null;
        }
        switch (i) {
            case 270029:
                C6490ok c6490ok = new C6490ok((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f22845a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), c6490ok);
                break;
            case 270030:
                this.f22845a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m36221ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36221ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22846ok;
    }
}
