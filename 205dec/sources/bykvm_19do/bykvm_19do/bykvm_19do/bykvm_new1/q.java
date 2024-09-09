package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.h3;
import com.bytedance.msdk.adapter.util.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* compiled from: RomUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f665a = "amigo";

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f666b = "funtouch";

    /* renamed from: c  reason: collision with root package name */
    private static ExecutorService f667c = Executors.newSingleThreadExecutor();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f668d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f669e = false;

    /* compiled from: RomUtils.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        private String f670a;

        public a(String str) {
            this.f670a = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String b4 = q.b(this.f670a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Logger.d(h3.f5722a, "property:" + b4 + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(b4)) {
                try {
                    Logger.w(h3.f5722a, "SP-getPropertyFromSP:" + b4);
                    r.a("rom_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).b("rom_property_info", b4);
                } catch (Throwable unused) {
                }
            }
            return b4;
        }
    }

    public static String b() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    public static String c() {
        if (o()) {
            return "coloros_" + c("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String d() {
        String f4 = f();
        if (f4 == null || !f4.toLowerCase().contains("emotionui")) {
            return "";
        }
        return f4 + "_" + Build.DISPLAY;
    }

    public static String e() {
        if (p()) {
            return "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String f() {
        return c("ro.build.version.emui");
    }

    public static String g() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String h() {
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static String i() {
        if (t()) {
            return "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    private static String j() {
        try {
            String a4 = r.a("rom_info", bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d()).a("rom_property_info", "");
            Logger.i(h3.f5722a, "get Property From SP...=" + a4);
            return a4;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        if (u()) {
            return l();
        }
        if (t()) {
            return i();
        }
        if (q()) {
            return g();
        }
        if (o()) {
            return c();
        }
        String d4 = d();
        if (TextUtils.isEmpty(d4)) {
            if (r()) {
                return h();
            }
            if (n()) {
                return b();
            }
            if (m()) {
                return a();
            }
            String e4 = e();
            return !TextUtils.isEmpty(e4) ? e4 : Build.DISPLAY;
        }
        return d4;
    }

    public static String l() {
        if (u()) {
            try {
                String c4 = c("ro.smartisan.version");
                return "smartisan_" + c4;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean n() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(f665a);
    }

    public static boolean o() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static boolean p() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static boolean q() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean r() {
        String c4 = c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(c4) && c4.toLowerCase().contains(f666b);
    }

    public static boolean s() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean t() {
        if (!f669e) {
            try {
                Class.forName("miui.os.Build");
                f668d = true;
                f669e = true;
                return true;
            } catch (Exception unused) {
                f669e = true;
            }
        }
        return f668d;
    }

    public static boolean u() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String a() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                exec.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    Logger.e("ToolUtils", "Exception while closing InputStream", e4);
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    Logger.e("ToolUtils", "Unable to read sysprop " + str, th);
                    return str2;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            Logger.e("ToolUtils", "Exception while closing InputStream", e5);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    private static String c(String str) {
        String str2;
        try {
            str2 = j();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new a(str));
                    f667c.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = f();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || s();
    }
}
