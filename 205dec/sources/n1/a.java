package n1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.e;
import com.snail.antifake.jni.PropertiesGet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import m1.b;
import m1.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EmuCheckUtil.java */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a {

    /* compiled from: EmuCheckUtil.java */
    /* renamed from: n1.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC1245a {
        void a();

        void b(boolean z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (androidx.core.content.PermissionChecker.checkSelfPermission(r5, r6) == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5, java.lang.String r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 1
            if (r0 < r1) goto L29
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Exception -> L29
            java.lang.String r3 = r5.getPackageName()     // Catch: java.lang.Exception -> L29
            r4 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L29
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch: java.lang.Exception -> L29
            int r0 = r0.targetSdkVersion     // Catch: java.lang.Exception -> L29
            if (r0 < r1) goto L23
            int r5 = r5.checkSelfPermission(r6)     // Catch: java.lang.Exception -> L29
            if (r5 != 0) goto L21
            goto L29
        L21:
            r2 = 0
            goto L29
        L23:
            int r5 = androidx.core.content.PermissionChecker.checkSelfPermission(r5, r6)     // Catch: java.lang.Exception -> L29
            if (r5 != 0) goto L21
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static String b() {
        e.a b4 = e.b("cat /proc/cpuinfo", false);
        return b4 == null ? "" : b4.f48146b;
    }

    public static String c() {
        return PropertiesGet.a("ro.kernel.qemu");
    }

    public static String d(Context context) {
        return m1.a.a(context);
    }

    public static String e(Context context) {
        return b.b(context);
    }

    public static String f(Context context) {
        return c.b(context);
    }

    public static String g() {
        File file = new File("/proc/tty/drivers");
        StringBuilder sb = new StringBuilder();
        if (file.exists() && file.canRead()) {
            try {
                char[] cArr = new char[1024];
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, 1024);
                    if (read < 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return sb.toString();
        }
        return "";
    }

    public static boolean h() {
        return new File("/dev/socket/qemud").exists();
    }

    public static boolean i() {
        return new File("/dev/socket/qemud").exists();
    }

    private static boolean j() {
        String e4 = com.snail.antifake.deviceid.a.e();
        return !TextUtils.isEmpty(e4) && e4.contains("x86");
    }

    private static boolean k() {
        e.a b4 = e.b("cat /proc/cpuinfo", false);
        String str = b4 == null ? "" : b4.f48146b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("intel") || str.toLowerCase().contains("amd");
    }

    public static boolean l(Context context) {
        if (TextUtils.isEmpty(PropertiesGet.a("ro.product.model")) || !PropertiesGet.a("ro.product.model").toLowerCase().contains("sdk")) {
            if (TextUtils.isEmpty(PropertiesGet.a("ro.product.manufacturer")) || !PropertiesGet.a("ro.product.manufacture").toLowerCase().contains("unknown")) {
                return !TextUtils.isEmpty(PropertiesGet.a("ro.product.device")) && PropertiesGet.a("ro.product.device").toLowerCase().contains("generic");
            }
            return true;
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean m(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = null;
        }
        return !TextUtils.isEmpty(str) && TextUtils.isEmpty(b.b(context)) && TextUtils.isEmpty(c.b(context));
    }

    public static boolean n(Context context) {
        return o(context) || l(context) || j() || k();
    }

    public static boolean o(Context context) {
        return "1".equals(PropertiesGet.a("ro.kernel.qemu"));
    }
}
