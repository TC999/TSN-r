package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr extends com.bytedance.sdk.openadsdk.fz.c.c.c.xv {

    /* renamed from: c  reason: collision with root package name */
    private TTAdNative.FullScreenVideoAdListener f36108c;

    public sr(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.f36108c = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.fz.c.c.c.xv, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 132102) {
            if (this.f36108c != null) {
                this.f36108c.onFullScreenVideoAdLoad(new bk((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            }
        } else if (i4 == 132103 && this.f36108c != null) {
            this.f36108c.onFullScreenVideoCached(new bk((Bridge) valueSet.objectValue(0, Bridge.class)));
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
