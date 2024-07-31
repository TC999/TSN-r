package com.bytedance.sdk.openadsdk.p155kf.p156ok.p157ok.p158ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* renamed from: com.bytedance.sdk.openadsdk.kf.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6423ok implements Bridge {

    /* renamed from: a */
    private final TTAdDislike.DislikeInteractionCallback f22591a;

    /* renamed from: ok */
    private ValueSet f22592ok = C5930a.f21279c;

    public C6423ok(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f22591a = dislikeInteractionCallback;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.f22591a;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                boolean booleanValue = valueSet.booleanValue(2);
                this.f22591a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), booleanValue);
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
                break;
        }
        m36317ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36317ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22592ok;
    }
}
