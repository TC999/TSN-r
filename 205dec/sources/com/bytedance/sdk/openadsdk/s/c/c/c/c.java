package com.bytedance.sdk.openadsdk.s.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36273c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdDislike.DislikeInteractionCallback f36274w;

    public c(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f36274w = dislikeInteractionCallback;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.f36274w;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i4) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                boolean booleanValue = valueSet.booleanValue(2);
                this.f36274w.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), booleanValue);
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36273c;
    }
}
