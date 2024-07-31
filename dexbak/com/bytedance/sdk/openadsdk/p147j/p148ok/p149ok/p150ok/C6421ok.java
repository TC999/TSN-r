package com.bytedance.sdk.openadsdk.p147j.p148ok.p149ok.p150ok;

import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* renamed from: com.bytedance.sdk.openadsdk.j.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6421ok implements Bridge {

    /* renamed from: a */
    private final TTNativeExpressAd.AdInteractionListener f22587a;

    /* renamed from: ok */
    private ValueSet f22588ok = C5930a.f21279c;

    public C6421ok(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f22587a = adInteractionListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.AdInteractionListener adInteractionListener = this.f22587a;
        if (adInteractionListener == null) {
            return null;
        }
        switch (i) {
            case 151101:
                int intValue = valueSet.intValue(1);
                this.f22587a.onAdClicked((View) valueSet.objectValue(0, View.class), intValue);
                break;
            case 151102:
                int intValue2 = valueSet.intValue(1);
                this.f22587a.onAdShow((View) valueSet.objectValue(0, View.class), intValue2);
                break;
            case 151103:
                int intValue3 = valueSet.intValue(2);
                this.f22587a.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), intValue3);
                break;
            case 151104:
                float floatValue = valueSet.floatValue(1);
                float floatValue2 = valueSet.floatValue(2);
                this.f22587a.onRenderSuccess((View) valueSet.objectValue(0, View.class), floatValue, floatValue2);
                break;
            case 151105:
                adInteractionListener.onAdDismiss();
                break;
        }
        m36319ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36319ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22588ok;
    }
}
