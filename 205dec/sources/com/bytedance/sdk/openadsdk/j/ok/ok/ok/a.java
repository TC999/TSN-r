package com.bytedance.sdk.openadsdk.j.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTNativeExpressAd.ExpressAdInteractionListener f35912a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f35912a = expressAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35912a == null) {
            return null;
        }
        switch (i4) {
            case 151101:
                int intValue = valueSet.intValue(1);
                this.f35912a.onAdClicked((View) valueSet.objectValue(0, View.class), intValue);
                break;
            case 151102:
                int intValue2 = valueSet.intValue(1);
                this.f35912a.onAdShow((View) valueSet.objectValue(0, View.class), intValue2);
                break;
            case 151103:
                int intValue3 = valueSet.intValue(2);
                this.f35912a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue3);
                break;
            case 151104:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                this.f35912a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2);
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
