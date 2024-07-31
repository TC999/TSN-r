package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6414bl;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6494s extends C6414bl {

    /* renamed from: ok */
    private TTAdNative.FullScreenVideoAdListener f22862ok;

    public C6494s(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.f22862ok = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6414bl, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 132102) {
            if (this.f22862ok != null) {
                this.f22862ok.onFullScreenVideoAdLoad(new C6495z((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            }
        } else if (i == 132103 && this.f22862ok != null) {
            this.f22862ok.onFullScreenVideoCached(new C6495z((Bridge) valueSet.objectValue(0, Bridge.class)));
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
