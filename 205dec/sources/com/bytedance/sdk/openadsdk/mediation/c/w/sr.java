package com.bytedance.sdk.openadsdk.mediation.c.w;

import android.app.Activity;
import android.content.Context;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36128c;

    private ValueSet w() {
        return b.a().l();
    }

    public abstract int c(com.bytedance.sdk.openadsdk.mediation.c.w.c.sr srVar);

    public abstract Object c(int i4, ValueSet valueSet);

    public abstract Map<String, Object> c();

    public abstract void c(int i4);

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(Activity activity, List<ux> list, int i4, int i5, Bridge bridge);

    public abstract void c(Context context);

    public abstract void c(Context context, c cVar, com.bytedance.sdk.openadsdk.mediation.c.w.c.c cVar2, Bridge bridge);

    public abstract void c(Context context, c cVar, com.bytedance.sdk.openadsdk.mediation.c.w.c.xv xvVar, Bridge bridge);

    public abstract void c(Context context, int[] iArr);

    public abstract void c(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar);

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar);

    public abstract void c(String str);

    public abstract void c(Map<String, Object> map);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 270024) {
            if (i4 != 271043) {
                if (i4 != 271050) {
                    switch (i4) {
                        case 270013:
                            Activity activity = (Activity) valueSet.objectValue(0, Activity.class);
                            List<Bridge> list = (List) valueSet.objectValue(1, List.class);
                            if (list == null) {
                                list = new ArrayList(0);
                            }
                            ArrayList arrayList = new ArrayList();
                            for (Bridge bridge : list) {
                                arrayList.add(new ux(bridge));
                            }
                            c(activity, arrayList, valueSet.intValue(2), valueSet.intValue(3), (Bridge) valueSet.objectValue(4, Bridge.class));
                            break;
                        case 270014:
                            c(new com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv((ValueSet) valueSet.objectValue(0, ValueSet.class)));
                            break;
                        case 270015:
                            c((String) valueSet.objectValue(0, String.class));
                            break;
                        case 270016:
                            c(new com.bytedance.sdk.openadsdk.ys.w.xv.sr((ValueSet) valueSet.objectValue(0, ValueSet.class)));
                            break;
                        case 270017:
                            c((Context) valueSet.objectValue(0, Context.class));
                            break;
                        case 270018:
                            c((Context) valueSet.objectValue(0, Context.class), (int[]) valueSet.objectValue(1, int[].class));
                            break;
                        case 270019:
                            c(valueSet.intValue(0));
                            break;
                        case 270020:
                            return (T) Integer.class.cast(Integer.valueOf(c(new com.bytedance.sdk.openadsdk.mediation.c.w.c.sr((Bridge) valueSet.objectValue(0, Bridge.class)))));
                        case 270021:
                            com.bytedance.sdk.openadsdk.mediation.c.w.c.xv xvVar = new com.bytedance.sdk.openadsdk.mediation.c.w.c.xv((Bridge) valueSet.objectValue(2, Bridge.class));
                            c((Context) valueSet.objectValue(0, Context.class), new c((ValueSet) valueSet.objectValue(1, ValueSet.class)), xvVar, (Bridge) valueSet.objectValue(3, Bridge.class));
                            break;
                        case 270022:
                            com.bytedance.sdk.openadsdk.mediation.c.w.c.c cVar = new com.bytedance.sdk.openadsdk.mediation.c.w.c.c((Bridge) valueSet.objectValue(2, Bridge.class));
                            c((Context) valueSet.objectValue(0, Context.class), new c((ValueSet) valueSet.objectValue(1, ValueSet.class)), cVar, (Bridge) valueSet.objectValue(3, Bridge.class));
                            break;
                    }
                } else {
                    c((Map) valueSet.objectValue(0, Map.class));
                }
                c(i4, valueSet, cls);
                return null;
            }
            return (T) c(valueSet.intValue(0), (ValueSet) valueSet.objectValue(1, ValueSet.class));
        }
        return (T) c();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36128c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet w3 = w();
        this.f36128c = w3;
        return w3;
    }
}
