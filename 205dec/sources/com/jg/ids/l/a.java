package com.jg.ids.l;

import android.content.Context;
import com.jg.ids.i;
import com.jg.ids.k;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    private static Object f37859a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f37860b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f37861c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f37862d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f37863e;

    static {
        f37859a = null;
        f37860b = null;
        f37861c = null;
        f37862d = null;
        f37863e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f37860b = cls;
            f37859a = cls.newInstance();
        } catch (Throwable th) {
            f37859a = null;
        }
        try {
            f37860b.getMethod("getDefaultUDID", Context.class);
        } catch (Throwable th2) {
        }
        try {
            f37861c = f37860b.getMethod("getOAID", Context.class);
        } catch (Throwable th3) {
            f37861c = null;
        }
        try {
            f37862d = f37860b.getMethod("getVAID", Context.class);
        } catch (Throwable th4) {
            f37862d = null;
        }
        try {
            f37863e = f37860b.getMethod("getAAID", Context.class);
        } catch (Throwable th5) {
            f37863e = null;
        }
    }

    private static String a(Context context, Method method) {
        if (f37859a != null && method != null) {
            try {
                return (String) method.invoke(f37859a, context);
            } catch (Throwable th) {
            }
        }
        return "";
    }

    @Override // com.jg.ids.i
    public final String a(Context context) {
        String a4 = a(context, f37862d);
        k.a().b(a4);
        return a4;
    }

    @Override // com.jg.ids.i
    public final String b(Context context) {
        String a4 = a(context, f37861c);
        k.a().c(a4);
        return a4;
    }

    @Override // com.jg.ids.i
    public final String c(Context context) {
        String a4 = a(context, f37863e);
        k.a().a(a4);
        return a4;
    }

    @Override // com.jg.ids.i
    public final boolean d() {
        return f37859a != null;
    }
}
