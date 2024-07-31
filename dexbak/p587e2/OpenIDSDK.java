package p587e2;

import android.content.Context;
import com.stub.StubApp;
import p583d2.HeytapIDSDK;
import p583d2.OpenIDHelper;

/* renamed from: e2.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OpenIDSDK {
    /* renamed from: a */
    public static void m12816a(Context context) {
        HeytapIDSDK.f40107b = OpenIDHelper.C13573b.f40114a.m12838b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        HeytapIDSDK.f40106a = true;
    }

    /* renamed from: b */
    public static boolean m12815b() {
        if (HeytapIDSDK.f40106a) {
            return HeytapIDSDK.f40107b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: c */
    public static String m12814c(Context context) {
        if (HeytapIDSDK.f40106a) {
            return OpenIDHelper.C13573b.f40114a.m12839a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: d */
    public static String m12813d(Context context) {
        if (HeytapIDSDK.f40106a) {
            return OpenIDHelper.C13573b.f40114a.m12839a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: e */
    public static String m12812e(Context context) {
        if (HeytapIDSDK.f40106a) {
            return OpenIDHelper.C13573b.f40114a.m12839a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    /* renamed from: f */
    public static String m12811f(Context context) {
        if (HeytapIDSDK.f40106a) {
            return OpenIDHelper.C13573b.f40114a.m12839a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
