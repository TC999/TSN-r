package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.zg;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class sr implements zg {

    /* renamed from: c  reason: collision with root package name */
    private static Object f26801c;

    /* renamed from: w  reason: collision with root package name */
    private static Class<?> f26802w;
    private static Method xv;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f26802w = cls;
            f26801c = cls.newInstance();
            xv = f26802w.getMethod("getOAID", Context.class);
        } catch (Exception e4) {
            be.c("Api#static reflect exception! " + e4.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return (f26802w == null || f26801c == null || xv == null) ? false : true;
    }

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        try {
            zg.c cVar = new zg.c();
            cVar.f26861w = c(context, xv);
            return cVar;
        } catch (Exception e4) {
            be.c(e4);
            return null;
        }
    }

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        return c();
    }

    private static String c(Context context, Method method) {
        Object obj = f26801c;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
