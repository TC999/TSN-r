package com.bytedance.sdk.openadsdk.fp.c.c.w.c;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35861c;

    private ValueSet c() {
        return b.a().l();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Bundle bundle);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 123101) {
            c((Bundle) valueSet.objectValue(0, Bundle.class));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f35861c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f35861c = c4;
        return c4;
    }
}
