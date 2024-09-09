package com.bytedance.sdk.openadsdk.mediation.ad.c.w.w;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36045c;

    private ValueSet t() {
        b a4 = b.a();
        a4.h(268101, new ValueSet.ValueGetter<sr>() { // from class: com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public sr get() {
                return c.this.k();
            }
        });
        return a4.l();
    }

    public abstract boolean a();

    public abstract com.bytedance.sdk.openadsdk.ys.w.w.sr bk();

    public abstract xv c(Activity activity);

    public abstract xv c(Activity activity, Map<String, Object> map);

    public abstract String c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar);

    public abstract void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar);

    public abstract void c(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 268001:
                return (T) c();
            case 268002:
                return (T) w();
            case 268003:
                return (T) xv();
            case 268004:
                return (T) sr();
            case 268005:
                return (T) ux();
            case 268006:
                return (T) Double.class.cast(Double.valueOf(f()));
            case 268007:
                return (T) r();
            case 268008:
                return (T) ev();
            case 268009:
                return (T) Integer.class.cast(Integer.valueOf(gd()));
            case 268010:
                return (T) Integer.class.cast(Integer.valueOf(p()));
            case 268011:
                c((Activity) valueSet.objectValue(0, Activity.class), (ViewGroup) valueSet.objectValue(1, ViewGroup.class), (List) valueSet.objectValue(2, List.class), (List) valueSet.objectValue(3, List.class), (List) valueSet.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr((Bridge) valueSet.objectValue(5, Bridge.class)));
                break;
            case 268012:
                return (T) Boolean.class.cast(Boolean.valueOf(a()));
            default:
                switch (i4) {
                    case 268016:
                        c((Activity) valueSet.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.s.c.w.c.c((Bridge) valueSet.objectValue(1, Bridge.class)));
                        break;
                    case 268017:
                        c((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
                        break;
                    case 268018:
                        return (T) w((Activity) valueSet.objectValue(0, Activity.class));
                    case 268019:
                        return (T) w((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
                    case 268020:
                        return (T) bk();
                    default:
                        switch (i4) {
                            case 268102:
                                return (T) c((Activity) valueSet.objectValue(0, Activity.class));
                            case 268103:
                                return (T) c((Activity) valueSet.objectValue(0, Activity.class), (Map) valueSet.objectValue(1, Map.class));
                        }
                }
        }
        c(i4, valueSet, cls);
        return null;
    }

    public abstract String ev();

    public abstract double f();

    public abstract int gd();

    public abstract sr k();

    public abstract int p();

    public abstract List<String> r();

    public abstract String sr();

    public abstract String ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36045c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet t3 = t();
        this.f36045c = t3;
        return t3;
    }

    public abstract ev w(Activity activity);

    public abstract ev w(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    public abstract String w();

    public abstract String xv();
}
