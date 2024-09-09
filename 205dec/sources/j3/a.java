package j3;

import android.content.Context;
import com.stub.StubApp;
import i3.b;

/* compiled from: OpenIDSDK.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {
    public static void a(Context context) {
        i3.a.f54766b = b.C1080b.f54773a.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        i3.a.f54765a = true;
    }

    public static boolean b() {
        if (i3.a.f54765a) {
            return i3.a.f54766b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (i3.a.f54765a) {
            return b.C1080b.f54773a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (i3.a.f54765a) {
            return b.C1080b.f54773a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (i3.a.f54765a) {
            return b.C1080b.f54773a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String f(Context context) {
        if (i3.a.f54765a) {
            return b.C1080b.f54773a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
