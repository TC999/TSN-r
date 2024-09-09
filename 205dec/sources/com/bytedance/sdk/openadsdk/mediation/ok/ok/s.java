package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s extends com.bytedance.sdk.openadsdk.h.ok.ok.ok.bl {
    private TTAdNative.FullScreenVideoAdListener ok;

    public s(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.ok = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.h.ok.ok.ok.bl, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 132102) {
            if (this.ok != null) {
                this.ok.onFullScreenVideoAdLoad(new z((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            }
        } else if (i4 == 132103 && this.ok != null) {
            this.ok.onFullScreenVideoCached(new z((Bridge) valueSet.objectValue(0, Bridge.class)));
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
