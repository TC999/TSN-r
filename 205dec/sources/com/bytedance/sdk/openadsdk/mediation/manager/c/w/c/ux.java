package com.bytedance.sdk.openadsdk.mediation.manager.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ux extends xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36224c;

    private ValueSet c() {
        b k4 = b.k(super.values());
        k4.h(270008, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(ux.this.hasDislike());
            }
        });
        k4.h(270011, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(ux.this.isExpress());
            }
        });
        return k4.l();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 270009:
                setUseCustomVideo(valueSet.booleanValue(0));
                break;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.f((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 271048:
                onResume();
                break;
            case 271049:
                onPause();
                break;
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.f fVar);

    public abstract void setUseCustomVideo(boolean z3);

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36224c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36224c = c4;
        return c4;
    }
}
