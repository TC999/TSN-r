package com.bytedance.sdk.openadsdk.ys.w.w;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class a extends gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36474c;

    private ValueSet f() {
        b k4 = b.k(super.values());
        k4.h(130001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.a.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(a.this.c());
            }
        });
        k4.h(130002, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.a.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, Object> get() {
                return a.this.w();
            }
        });
        k4.h(130003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.a.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(a.this.xv());
            }
        });
        k4.h(130004, new ValueSet.ValueGetter<Long>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.a.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Long get() {
                return Long.valueOf(a.this.sr());
            }
        });
        return k4.l();
    }

    public abstract int c();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Activity activity);

    public abstract void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str);

    public abstract void c(com.bytedance.sdk.openadsdk.q.c.w.c.c cVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar);

    public abstract void c(boolean z3);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 130101:
                c(new com.bytedance.sdk.openadsdk.q.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 130102:
                c(new com.bytedance.sdk.openadsdk.ys.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 130103:
                c((Activity) valueSet.objectValue(0, Activity.class));
                break;
            case 130104:
                c((Activity) valueSet.objectValue(0, Activity.class), (TTAdConstant.RitScenes) valueSet.objectValue(1, TTAdConstant.RitScenes.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 130105:
                c(valueSet.booleanValue(0));
                break;
            case 130106:
                return (T) ux();
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract long sr();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.sr ux();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36474c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet f4 = f();
        this.f36474c = f4;
        return f4;
    }

    public abstract Map<String, Object> w();

    public abstract int xv();
}
