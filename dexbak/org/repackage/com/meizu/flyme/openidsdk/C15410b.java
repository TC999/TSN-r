package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import com.stub.StubApp;
import java.lang.reflect.Method;

/* renamed from: org.repackage.com.meizu.flyme.openidsdk.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15410b {

    /* renamed from: a */
    private static final String f44173a = "OpenIdHelper";

    /* renamed from: b */
    private static Method f44174b;

    /* renamed from: a */
    public static String m2787a(Context context) {
        C15414f m2773d = C15414f.m2773d();
        return m2773d.m2776a(StubApp.getOrigApplicationContext(context.getApplicationContext()), m2773d.f44182a);
    }

    /* renamed from: b */
    public static void m2786b(boolean z) {
        C15414f.m2773d();
        C15414f.m2771f(z);
    }

    /* renamed from: c */
    public static final boolean m2785c() {
        Context context = null;
        try {
            if (f44174b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f44174b = method;
                method.setAccessible(true);
            }
            context = (Context) f44174b.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e(f44173a, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return C15414f.m2773d().m2769h(context, false);
    }

    /* renamed from: d */
    public static String m2784d(Context context) {
        C15414f m2773d = C15414f.m2773d();
        return m2773d.m2776a(StubApp.getOrigApplicationContext(context.getApplicationContext()), m2773d.f44183b);
    }

    /* renamed from: e */
    public static String m2783e(Context context) {
        C15414f m2773d = C15414f.m2773d();
        return m2773d.m2776a(StubApp.getOrigApplicationContext(context.getApplicationContext()), m2773d.f44185d);
    }

    /* renamed from: f */
    public static String m2782f(Context context) {
        C15414f m2773d = C15414f.m2773d();
        return m2773d.m2776a(StubApp.getOrigApplicationContext(context.getApplicationContext()), m2773d.f44184c);
    }
}
