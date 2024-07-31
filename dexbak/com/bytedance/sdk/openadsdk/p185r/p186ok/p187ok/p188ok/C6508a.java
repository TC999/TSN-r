package com.bytedance.sdk.openadsdk.p185r.p186ok.p187ok.p188ok;

import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* renamed from: com.bytedance.sdk.openadsdk.r.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6508a implements Bridge {

    /* renamed from: a */
    private final TTNativeAd.ExpressRenderListener f22887a;

    /* renamed from: ok */
    private ValueSet f22888ok = C5930a.f21279c;

    public C6508a(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f22887a = expressRenderListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22887a == null) {
            return null;
        }
        if (i == 142101) {
            float floatValue = valueSet.floatValue(1);
            float floatValue2 = valueSet.floatValue(2);
            boolean booleanValue = valueSet.booleanValue(3);
            this.f22887a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
        }
        m36188ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36188ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22888ok;
    }
}
