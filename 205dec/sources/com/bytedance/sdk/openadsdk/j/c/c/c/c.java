package com.bytedance.sdk.openadsdk.j.c.c.c;

import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.ys.c.c.t;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35906c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTNativeAd.AdInteractionListener f35907w;

    public c(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.f35907w = adInteractionListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35907w == null) {
            return null;
        }
        switch (i4) {
            case 141101:
                t tVar = new t((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f35907w.onAdClicked((View) valueSet.objectValue(0, View.class), tVar);
                break;
            case 141102:
                t tVar2 = new t((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f35907w.onAdCreativeClick((View) valueSet.objectValue(0, View.class), tVar2);
                break;
            case 141103:
                this.f35907w.onAdShow(new t((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35906c;
    }
}
