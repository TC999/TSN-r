package com.bytedance.sdk.openadsdk.mediation.ad.c.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36047c;

    private ValueSet p() {
        return b.a().l();
    }

    public abstract String c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 271047) {
            switch (i4) {
                case 271035:
                    return (T) c();
                case 271036:
                    return (T) w();
                case 271037:
                    return (T) Long.class.cast(Long.valueOf(xv()));
                case 271038:
                    return (T) sr();
                case 271039:
                    return (T) ux();
                case 271040:
                    return (T) f();
                case 271041:
                    return (T) r();
                case 271042:
                    return (T) gd();
                default:
                    c(i4, valueSet, cls);
                    return null;
            }
        }
        return (T) ev();
    }

    public abstract String ev();

    public abstract String f();

    public abstract Map<String, Object> gd();

    public abstract String r();

    public abstract String sr();

    public abstract Map<String, String> ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36047c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet p3 = p();
        this.f36047c = p3;
        return p3;
    }

    public abstract String w();

    public abstract long xv();
}
