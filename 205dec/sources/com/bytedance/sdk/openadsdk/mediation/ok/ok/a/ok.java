package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationDrawAdTokenCallback f36237a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f36237a = iMediationDrawAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36237a == null) {
            return null;
        }
        switch (i4) {
            case 270029:
                com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.ok okVar = new com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36237a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), okVar);
                break;
            case 270030:
                this.f36237a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
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
