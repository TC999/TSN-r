package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f61599a = "OpenIdHelper";

    /* renamed from: b  reason: collision with root package name */
    private static Method f61600b;

    public static String a(Context context) {
        f d4 = f.d();
        return d4.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), d4.f61608a);
    }

    public static void b(boolean z3) {
        f.d();
        f.f(z3);
    }

    public static final boolean c() {
        Context context = null;
        try {
            if (f61600b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f61600b = method;
                method.setAccessible(true);
            }
            context = (Context) f61600b.invoke(null, new Object[0]);
        } catch (Exception e4) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e4.toString());
        }
        if (context == null) {
            return false;
        }
        return f.d().h(context, false);
    }

    public static String d(Context context) {
        f d4 = f.d();
        return d4.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), d4.f61609b);
    }

    public static String e(Context context) {
        f d4 = f.d();
        return d4.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), d4.f61611d);
    }

    public static String f(Context context) {
        f d4 = f.d();
        return d4.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), d4.f61610c);
    }
}
