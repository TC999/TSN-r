package com.beizi.fusion.e.a;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: XiaomiDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private Context f14722a;

    /* renamed from: b  reason: collision with root package name */
    private Class f14723b;

    /* renamed from: c  reason: collision with root package name */
    private Object f14724c;

    /* renamed from: d  reason: collision with root package name */
    private Method f14725d;

    public k(Context context) {
        this.f14722a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f14723b = cls;
            this.f14724c = cls.newInstance();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            this.f14725d = this.f14723b.getMethod("getOAID", Context.class);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private String a(Context context, Method method) {
        Object obj = this.f14724c;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public String a() {
        return a(this.f14722a, this.f14725d);
    }
}
