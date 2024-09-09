package com.bytedance.sdk.openadsdk.ys.w.w;

import android.app.Activity;
import android.view.View;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ys extends gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36541c;

    private ValueSet gd() {
        b k4 = b.k(super.values());
        k4.h(150001, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.ys.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public View get() {
                return ys.this.c();
            }
        });
        k4.h(150002, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.ys.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(ys.this.w());
            }
        });
        k4.h(150003, new ValueSet.ValueGetter<sr>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.ys.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public sr get() {
                return ys.this.f();
            }
        });
        k4.h(150004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.ys.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(ys.this.xv());
            }
        });
        k4.h(150005, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.ys.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, Object> get() {
                return ys.this.r();
            }
        });
        return k4.l();
    }

    public abstract View c();

    public abstract ev c(Activity activity);

    public abstract void c(int i4);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar);

    public abstract void c(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    public abstract void c(com.bytedance.sdk.openadsdk.ls.c.w.c.c cVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ls.c.w.c.w wVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar);

    public abstract void c(String str);

    public abstract void c(boolean z3);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 150101:
                c(new com.bytedance.sdk.openadsdk.ls.c.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150102:
                c(new com.bytedance.sdk.openadsdk.ls.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150103:
                c(new com.bytedance.sdk.openadsdk.ys.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150104:
                sr();
                break;
            case 150105:
                ux();
                break;
            case 150106:
                c((Activity) valueSet.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.s.c.w.c.c((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 150107:
                c((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
                break;
            case 150108:
                return (T) c((Activity) valueSet.objectValue(0, Activity.class));
            case 150109:
                w((Activity) valueSet.objectValue(0, Activity.class));
                break;
            case 150110:
                c(valueSet.intValue(0));
                break;
            case 150111:
                c(new com.bytedance.sdk.openadsdk.ls.c.w.c.xv((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150112:
                c(valueSet.booleanValue(0));
                break;
            case 150113:
                return (T) ev();
            case 150114:
                c((String) valueSet.objectValue(0, String.class));
                break;
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux ev();

    public abstract sr f();

    public abstract Map<String, Object> r();

    public abstract void sr();

    public abstract void ux();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36541c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet gd = gd();
        this.f36541c = gd;
        return gd;
    }

    public abstract int w();

    public abstract void w(Activity activity);

    public abstract int xv();
}
