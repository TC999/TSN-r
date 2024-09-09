package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.j;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f35888a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public bl(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f35888a = fullScreenVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.f35888a;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 132101:
                this.f35888a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.f35888a.onFullScreenVideoAdLoad(new j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.f35888a.onFullScreenVideoCached(new j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
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
