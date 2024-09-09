package com.bytedance.sdk.openadsdk.j.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTNativeExpressAd.AdInteractionListener f35914a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f35914a = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.AdInteractionListener adInteractionListener = this.f35914a;
        if (adInteractionListener == null) {
            return null;
        }
        switch (i4) {
            case 151101:
                int intValue = valueSet.intValue(1);
                this.f35914a.onAdClicked((View) valueSet.objectValue(0, View.class), intValue);
                break;
            case 151102:
                int intValue2 = valueSet.intValue(1);
                this.f35914a.onAdShow((View) valueSet.objectValue(0, View.class), intValue2);
                break;
            case 151103:
                int intValue3 = valueSet.intValue(2);
                this.f35914a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue3);
                break;
            case 151104:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                this.f35914a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2);
                break;
            case 151105:
                adInteractionListener.onAdDismiss();
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
