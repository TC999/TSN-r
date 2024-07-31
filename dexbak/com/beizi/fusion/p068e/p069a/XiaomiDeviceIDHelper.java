package com.beizi.fusion.p068e.p069a;

import android.content.Context;
import java.lang.reflect.Method;

/* renamed from: com.beizi.fusion.e.a.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class XiaomiDeviceIDHelper {

    /* renamed from: a */
    private Context f11204a;

    /* renamed from: b */
    private Class f11205b;

    /* renamed from: c */
    private Object f11206c;

    /* renamed from: d */
    private Method f11207d;

    public XiaomiDeviceIDHelper(Context context) {
        this.f11204a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f11205b = cls;
            this.f11206c = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f11207d = this.f11205b.getMethod("getOAID", Context.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m48549a(Context context, Method method) {
        Object obj = this.f11206c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m48550a() {
        return m48549a(this.f11204a, this.f11207d);
    }
}
