package com.bytedance.sdk.openadsdk.r.ok.ok.ok;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.bl.ok.ok.rh;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTNativeAd.AdInteractionListener f36262a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f36262a = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36262a == null) {
            return null;
        }
        switch (i4) {
            case 141101:
                rh rhVar = new rh((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36262a.onAdClicked((View) valueSet.objectValue(0, View.class), rhVar);
                break;
            case 141102:
                rh rhVar2 = new rh((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36262a.onAdCreativeClick((View) valueSet.objectValue(0, View.class), rhVar2);
                break;
            case 141103:
                this.f36262a.onAdShow(new rh((Bridge) valueSet.objectValue(0, Bridge.class)));
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
