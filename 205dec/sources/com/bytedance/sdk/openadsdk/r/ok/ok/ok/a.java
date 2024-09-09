package com.bytedance.sdk.openadsdk.r.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTNativeAd.ExpressRenderListener f36261a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f36261a = expressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36261a == null) {
            return null;
        }
        if (i4 == 142101) {
            float floatValue = valueSet.floatValue(1);
            float floatValue2 = valueSet.floatValue(2);
            boolean booleanValue = valueSet.booleanValue(3);
            this.f36261a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
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
