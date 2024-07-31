package p651v0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.snail.antifake.deviceid.AndroidDeviceIMEIUtil;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.snail.antifake.jni.PropertiesGet;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import p648u0.DeviceIdUtil;
import p648u0.IPhoneSubInfoUtil;
import p648u0.ITelephonyUtil;
import tv.cjump.jni.DeviceUtils;

/* renamed from: v0.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EmuCheckUtil {

    /* compiled from: EmuCheckUtil.java */
    /* renamed from: v0.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC16233a {
        /* renamed from: a */
        void m194a();

        /* renamed from: b */
        void m193b(boolean z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (androidx.core.content.PermissionChecker.checkSelfPermission(r5, r6) == 0) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m209a(android.content.Context r5, java.lang.String r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: p651v0.EmuCheckUtil.m209a(android.content.Context, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static String m208b() {
        ShellAdbUtils.C11947a m19677b = ShellAdbUtils.m19677b("cat /proc/cpuinfo", false);
        return m19677b == null ? "" : m19677b.f33812b;
    }

    /* renamed from: c */
    public static String m207c() {
        return PropertiesGet.m19666a("ro.kernel.qemu");
    }

    /* renamed from: d */
    public static String m206d(Context context) {
        return DeviceIdUtil.m243a(context);
    }

    /* renamed from: e */
    public static String m205e(Context context) {
        return IPhoneSubInfoUtil.m239b(context);
    }

    /* renamed from: f */
    public static String m204f(Context context) {
        return ITelephonyUtil.m234b(context);
    }

    /* renamed from: g */
    public static String m203g() {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }
        return "";
    }

    /* renamed from: h */
    public static boolean m202h() {
        return new File("/dev/socket/qemud").exists();
    }

    /* renamed from: i */
    public static boolean m201i() {
        return new File("/dev/socket/qemud").exists();
    }

    /* renamed from: j */
    private static boolean m200j() {
        String m19701e = AndroidDeviceIMEIUtil.m19701e();
        return !TextUtils.isEmpty(m19701e) && m19701e.contains(DeviceUtils.f47125a);
    }

    /* renamed from: k */
    private static boolean m199k() {
        ShellAdbUtils.C11947a m19677b = ShellAdbUtils.m19677b("cat /proc/cpuinfo", false);
        String str = m19677b == null ? "" : m19677b.f33812b;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("intel") || str.toLowerCase().contains("amd");
    }

    /* renamed from: l */
    public static boolean m198l(Context context) {
        if (TextUtils.isEmpty(PropertiesGet.m19666a("ro.product.model")) || !PropertiesGet.m19666a("ro.product.model").toLowerCase().contains("sdk")) {
            if (TextUtils.isEmpty(PropertiesGet.m19666a("ro.product.manufacturer")) || !PropertiesGet.m19666a("ro.product.manufacture").toLowerCase().contains("unknown")) {
                return !TextUtils.isEmpty(PropertiesGet.m19666a("ro.product.device")) && PropertiesGet.m19666a("ro.product.device").toLowerCase().contains("generic");
            }
            return true;
        }
        return true;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: m */
    public static boolean m197m(Context context) {
        String str;
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            str = null;
        }
        return !TextUtils.isEmpty(str) && TextUtils.isEmpty(IPhoneSubInfoUtil.m239b(context)) && TextUtils.isEmpty(ITelephonyUtil.m234b(context));
    }

    /* renamed from: n */
    public static boolean m196n(Context context) {
        return m195o(context) || m198l(context) || m200j() || m199k();
    }

    /* renamed from: o */
    public static boolean m195o(Context context) {
        return "1".equals(PropertiesGet.m19666a("ro.kernel.qemu"));
    }
}
