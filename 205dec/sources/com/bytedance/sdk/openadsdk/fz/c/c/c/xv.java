package com.bytedance.sdk.openadsdk.fz.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ys.c.c.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35872c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f35873w;

    public xv(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f35873w = fullScreenVideoAdListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.f35873w;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i4) {
            case 132101:
                this.f35873w.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.f35873w.onFullScreenVideoAdLoad(new a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.f35873w.onFullScreenVideoCached(new a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35872c;
    }
}
