package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationDislikeCallback f36050a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f36050a = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f36050a;
        if (iMediationDislikeCallback == null) {
            return null;
        }
        switch (i4) {
            case 268013:
                this.f36050a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 268014:
                iMediationDislikeCallback.onCancel();
                break;
            case 268015:
                iMediationDislikeCallback.onShow();
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
