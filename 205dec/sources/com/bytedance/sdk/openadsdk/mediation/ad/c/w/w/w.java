package com.bytedance.sdk.openadsdk.mediation.ad.c.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36048c;

    private ValueSet ys() {
        return b.a().l();
    }

    public abstract int a();

    public abstract int bk();

    public abstract int c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 271021:
                return (T) Integer.class.cast(Integer.valueOf(c()));
            case 271022:
                return (T) Integer.class.cast(Integer.valueOf(w()));
            case 271023:
                return (T) Integer.class.cast(Integer.valueOf(xv()));
            case 271024:
                return (T) Integer.class.cast(Integer.valueOf(sr()));
            case 271025:
                return (T) Integer.class.cast(Integer.valueOf(ux()));
            case 271026:
                return (T) Integer.class.cast(Integer.valueOf(f()));
            case 271027:
                return (T) Integer.class.cast(Integer.valueOf(r()));
            case 271028:
                return (T) Integer.class.cast(Integer.valueOf(ev()));
            case 271029:
                return (T) Integer.class.cast(Integer.valueOf(gd()));
            case 271030:
                return (T) Integer.class.cast(Integer.valueOf(p()));
            case 271031:
                return (T) Integer.class.cast(Integer.valueOf(k()));
            case 271032:
                return (T) Integer.class.cast(Integer.valueOf(a()));
            case 271033:
                return (T) Integer.class.cast(Integer.valueOf(bk()));
            case 271034:
                return (T) t();
            default:
                c(i4, valueSet, cls);
                return null;
        }
    }

    public abstract int ev();

    public abstract int f();

    public abstract int gd();

    public abstract int k();

    public abstract int p();

    public abstract int r();

    public abstract int sr();

    public abstract Map<String, Integer> t();

    public abstract int ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36048c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet ys = ys();
        this.f36048c = ys;
        return ys;
    }

    public abstract int w();

    public abstract int xv();
}
