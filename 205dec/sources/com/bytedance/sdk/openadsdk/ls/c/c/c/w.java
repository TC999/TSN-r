package com.bytedance.sdk.openadsdk.ls.c.c.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35964c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTNativeExpressAd.ExpressAdInteractionListener f35965w;

    public w(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f35965w = expressAdInteractionListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35965w == null) {
            return null;
        }
        switch (i4) {
            case 151101:
                int intValue = valueSet.intValue(1);
                this.f35965w.onAdClicked((View) valueSet.objectValue(0, View.class), intValue);
                break;
            case 151102:
                int intValue2 = valueSet.intValue(1);
                this.f35965w.onAdShow((View) valueSet.objectValue(0, View.class), intValue2);
                break;
            case 151103:
                int intValue3 = valueSet.intValue(2);
                this.f35965w.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue3);
                break;
            case 151104:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                this.f35965w.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2);
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35964c;
    }
}
