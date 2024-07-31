package com.bytedance.sdk.openadsdk.p185r.p186ok.p187ok.p188ok;

import android.view.View;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6384rh;

/* renamed from: com.bytedance.sdk.openadsdk.r.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6509ok implements Bridge {

    /* renamed from: a */
    private final TTNativeAd.AdInteractionListener f22889a;

    /* renamed from: ok */
    private ValueSet f22890ok = C5930a.f21279c;

    public C6509ok(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f22889a = adInteractionListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22889a == null) {
            return null;
        }
        switch (i) {
            case 141101:
                C6384rh c6384rh = new C6384rh((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f22889a.onAdClicked((View) valueSet.objectValue(0, View.class), c6384rh);
                break;
            case 141102:
                C6384rh c6384rh2 = new C6384rh((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f22889a.onAdCreativeClick((View) valueSet.objectValue(0, View.class), c6384rh2);
                break;
            case 141103:
                this.f22889a.onAdShow(new C6384rh((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m36187ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36187ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22890ok;
    }
}
