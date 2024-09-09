package com.bytedance.sdk.openadsdk.ys.w.w;

import android.graphics.Bitmap;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class p extends k implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36502c;

    private ValueSet n() {
        return b.k(super.values()).l();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k, com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Bitmap bitmap, int i4);

    public abstract void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar);

    public abstract void c(boolean z3);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k, com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 170101:
                c(valueSet.booleanValue(0));
                break;
            case 170102:
                c((Bitmap) valueSet.objectValue(0, Bitmap.class), valueSet.intValue(1));
                break;
            case 170103:
                c(new com.bytedance.sdk.openadsdk.u.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return (T) super.call(i4, valueSet, cls);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k, com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36502c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet n4 = n();
        this.f36502c = n4;
        return n4;
    }
}
