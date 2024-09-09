package com.bytedance.sdk.openadsdk.mediation.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36111c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationDrawAdTokenCallback f36112w;

    public c(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f36112w = iMediationDrawAdTokenCallback;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36112w == null) {
            return null;
        }
        switch (i4) {
            case 270029:
                com.bytedance.sdk.openadsdk.mediation.c.c.c.c cVar = new com.bytedance.sdk.openadsdk.mediation.c.c.c.c((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36112w.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), cVar);
                break;
            case 270030:
                this.f36112w.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36111c;
    }
}
