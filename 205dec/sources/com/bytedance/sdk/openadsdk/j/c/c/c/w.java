package com.bytedance.sdk.openadsdk.j.c.c.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35908c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTNativeAd.ExpressRenderListener f35909w;

    public w(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.f35909w = expressRenderListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35909w == null) {
            return null;
        }
        if (i4 == 142101) {
            float floatValue = valueSet.floatValue(1);
            float floatValue2 = valueSet.floatValue(2);
            boolean booleanValue = valueSet.booleanValue(3);
            this.f35909w.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2, booleanValue);
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35908c;
    }
}
