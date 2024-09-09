package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36035c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationDislikeCallback f36036w;

    public w(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f36036w = iMediationDislikeCallback;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f36036w;
        if (iMediationDislikeCallback == null) {
            return null;
        }
        switch (i4) {
            case 268013:
                this.f36036w.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 268014:
                iMediationDislikeCallback.onCancel();
                break;
            case 268015:
                iMediationDislikeCallback.onShow();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36035c;
    }
}
