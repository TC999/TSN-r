package com.bytedance.sdk.openadsdk.ys.w.w;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w extends gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36526c;

    private ValueSet p() {
        b k4 = b.k(super.values());
        k4.h(110001, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public View get() {
                return w.this.c();
            }
        });
        k4.h(110002, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public View get() {
                return w.this.w();
            }
        });
        k4.h(110003, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public View get() {
                return w.this.xv();
            }
        });
        k4.h(110004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(w.this.sr());
            }
        });
        k4.h(110005, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, Object> get() {
                return w.this.ux();
            }
        });
        k4.h(110006, new ValueSet.ValueGetter<int[]>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.w.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public int[] get() {
                return w.this.f();
            }
        });
        return k4.l();
    }

    public abstract void L_();

    public abstract View c();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(ViewGroup viewGroup);

    public abstract void c(ViewGroup viewGroup, Activity activity);

    public abstract void c(com.bytedance.sdk.openadsdk.sr.c.w.c.c cVar);

    public abstract void c(com.bytedance.sdk.openadsdk.sr.c.w.c.w wVar);

    public abstract void c(com.bytedance.sdk.openadsdk.sr.c.w.c.xv xvVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 110101:
                r();
                break;
            case 110102:
                c(new com.bytedance.sdk.openadsdk.ys.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110103:
                c(new com.bytedance.sdk.openadsdk.sr.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110104:
                L_();
                break;
            case 110105:
                c(new com.bytedance.sdk.openadsdk.sr.c.w.c.xv((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110106:
                c(new com.bytedance.sdk.openadsdk.sr.c.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110107:
                w((ViewGroup) valueSet.objectValue(0, ViewGroup.class));
                break;
            case 110108:
                c((ViewGroup) valueSet.objectValue(0, ViewGroup.class));
                break;
            case 110109:
                c((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (Activity) valueSet.objectValue(1, Activity.class));
                break;
            case 110110:
                return (T) gd();
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract int[] f();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.r gd();

    public abstract void r();

    public abstract int sr();

    public abstract Map<String, Object> ux();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36526c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet p3 = p();
        this.f36526c = p3;
        return p3;
    }

    public abstract View w();

    public abstract void w(ViewGroup viewGroup);

    public abstract View xv();
}
