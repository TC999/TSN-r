package com.bytedance.sdk.openadsdk.kf.ok.ok.ok;

import com.bykv.ok.ok.ok.ok.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdDislike.DislikeInteractionCallback f35945a;
    private ValueSet ok = a.f24747c;

    public ok(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f35945a = dislikeInteractionCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.f35945a;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i4) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                boolean booleanValue = valueSet.booleanValue(2);
                this.f35945a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), booleanValue);
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
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
