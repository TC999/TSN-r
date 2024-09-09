package com.bytedance.sdk.openadsdk.ys.w.w;

import android.app.Activity;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class fp extends gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36491c;

    private ValueSet f() {
        b k4 = b.k(super.values());
        k4.h(120001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.fp.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(fp.this.c());
            }
        });
        k4.h(120002, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.fp.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, Object> get() {
                return fp.this.w();
            }
        });
        k4.h(120003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.fp.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(fp.this.xv());
            }
        });
        k4.h(120004, new ValueSet.ValueGetter<Long>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.fp.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Long get() {
                return Long.valueOf(fp.this.sr());
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

    public abstract void c(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar);

    public abstract void c(com.bytedance.sdk.openadsdk.gb.c.w.c.w wVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar);

    public abstract void c(boolean z3);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 121109) {
            switch (i4) {
                case 120101:
                    c(new com.bytedance.sdk.openadsdk.gb.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120102:
                    w(new com.bytedance.sdk.openadsdk.gb.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120103:
                    c(new com.bytedance.sdk.openadsdk.gb.c.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120104:
                    c(new com.bytedance.sdk.openadsdk.ys.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120105:
                    c((Activity) valueSet.objectValue(0, Activity.class));
                    break;
                case 120106:
                    c((Activity) valueSet.objectValue(0, Activity.class), (TTAdConstant.RitScenes) valueSet.objectValue(1, TTAdConstant.RitScenes.class), (String) valueSet.objectValue(2, String.class));
                    break;
                case 120107:
                    c(valueSet.booleanValue(0));
                    break;
            }
            return (T) super.call(i4, valueSet, cls);
        }
        return (T) ux();
    }

    public abstract long sr();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.f ux();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36491c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet f4 = f();
        this.f36491c = f4;
        return f4;
    }

    public abstract Map<String, Object> w();

    public abstract void w(com.bytedance.sdk.openadsdk.gb.c.w.c.c cVar);

    public abstract int xv();
}
