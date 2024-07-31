package p000XI.p005XI.p006K0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.stub.StubApp;
import java.lang.reflect.Method;
import p000XI.p001CA.p002XI.C0000K0;
import p000XI.p003K0.p004XI.InterfaceC0004XI;
import p000XI.p008xo.p009XI.p010XI.C0018CA;

/* renamed from: XI.XI.K0.XI */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0012XI {

    /* renamed from: K0 */
    public static boolean f31K0;

    /* renamed from: XI */
    public static boolean f32XI;

    /* renamed from: CA */
    public static Context m60068CA(Context context) {
        return (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* renamed from: K0 */
    public static String m60067K0(Context context) {
        C0000K0 m60074XI = C0000K0.m60074XI(context);
        if (m60074XI == null) {
            return null;
        }
        String str = C0000K0.f5WI;
        if (str != null) {
            return str;
        }
        m60074XI.m60075XI(0, null);
        if (C0000K0.f9kM == null) {
            C0000K0.m60073XI(C0000K0.f6XI, 0, null);
        }
        return C0000K0.f5WI;
    }

    /* renamed from: XI */
    public static String m60063XI(Context context, String str) {
        C0000K0 m60074XI = C0000K0.m60074XI(context);
        if (m60074XI == null) {
            return null;
        }
        String str2 = C0000K0.f8cs;
        if (str2 != null) {
            return str2;
        }
        m60074XI.m60075XI(2, str);
        if (C0000K0.f0CA == null && C0000K0.f8cs != null) {
            C0000K0.m60073XI(C0000K0.f6XI, 2, str);
        }
        return C0000K0.f8cs;
    }

    /* renamed from: XI */
    public static final boolean m60065XI() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e) {
            e.toString();
        }
        if (context == null) {
            return false;
        }
        return C0018CA.m60060XI().m60057XI(context, false);
    }

    /* renamed from: kM */
    public static String m60062kM(Context context) {
        C0000K0 m60074XI = C0000K0.m60074XI(context);
        if (m60074XI == null || Build.VERSION.SDK_INT == 28) {
            return null;
        }
        String str = C0000K0.f7bs;
        if (str != null) {
            return str;
        }
        String packageName = C0000K0.f6XI.getPackageName();
        m60074XI.m60075XI(1, packageName);
        if (C0000K0.f12xo == null && C0000K0.f7bs != null) {
            C0000K0.m60073XI(C0000K0.f6XI, 1, packageName);
        }
        return C0000K0.f7bs;
    }

    /* renamed from: xo */
    public static void m60061xo(Context context) {
        if (f32XI) {
            return;
        }
        InterfaceC0004XI.C0005K0 c0005k0 = InterfaceC0004XI.C0005K0.C0006K0.f22XI;
        Context m60068CA = m60068CA(context);
        c0005k0.getClass();
        boolean z = false;
        try {
            PackageInfo packageInfo = m60068CA.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (packageInfo != null) {
                if (packageInfo.versionCode >= 1) {
                    z = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        f31K0 = z;
        f32XI = true;
    }

    /* renamed from: K0 */
    public static String m60066K0(Context context, String str) {
        C0000K0 m60074XI = C0000K0.m60074XI(context);
        if (m60074XI == null) {
            return null;
        }
        String str2 = C0000K0.f7bs;
        if (str2 != null) {
            return str2;
        }
        m60074XI.m60075XI(1, str);
        if (C0000K0.f12xo == null && C0000K0.f7bs != null) {
            C0000K0.m60073XI(C0000K0.f6XI, 1, str);
        }
        return C0000K0.f7bs;
    }

    /* renamed from: XI */
    public static String m60064XI(Context context) {
        C0000K0 m60074XI = C0000K0.m60074XI(context);
        if (m60074XI == null || Build.VERSION.SDK_INT == 28) {
            return null;
        }
        String str = C0000K0.f8cs;
        if (str != null) {
            return str;
        }
        String packageName = C0000K0.f6XI.getPackageName();
        m60074XI.m60075XI(2, packageName);
        if (C0000K0.f0CA == null && C0000K0.f8cs != null) {
            C0000K0.m60073XI(C0000K0.f6XI, 2, packageName);
        }
        return C0000K0.f8cs;
    }
}
