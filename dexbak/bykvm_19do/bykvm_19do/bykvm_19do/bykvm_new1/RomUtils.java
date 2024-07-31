package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.os.Build;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.bytedance.msdk.adapter.util.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RomUtils {

    /* renamed from: a */
    private static final CharSequence f672a = "amigo";

    /* renamed from: b */
    private static final CharSequence f673b = "funtouch";

    /* renamed from: c */
    private static ExecutorService f674c = Executors.newSingleThreadExecutor();

    /* renamed from: d */
    public static boolean f675d = false;

    /* renamed from: e */
    public static boolean f676e = false;

    /* compiled from: RomUtils.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.q$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class CallableC0988a implements Callable<String> {

        /* renamed from: a */
        private String f677a;

        public CallableC0988a(String str) {
            this.f677a = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String m59158b = RomUtils.m59158b(this.f677a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Logger.m37562d("RomUtils", "property:" + m59158b + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(m59158b)) {
                try {
                    Logger.m37547w("RomUtils", "SP-getPropertyFromSP:" + m59158b);
                    SPUtils.m59131a("rom_info", InternalContainer.m59945d()).m59123b("rom_property_info", m59158b);
                } catch (Throwable unused) {
                }
            }
            return m59158b;
        }
    }

    /* renamed from: b */
    public static String m59159b() {
        return Build.DISPLAY + "_" + m59156c("ro.gn.sv.version");
    }

    /* renamed from: c */
    public static String m59157c() {
        if (m59143o()) {
            return "coloros_" + m59156c("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    /* renamed from: d */
    public static String m59155d() {
        String m59152f = m59152f();
        if (m59152f == null || !m59152f.toLowerCase().contains("emotionui")) {
            return "";
        }
        return m59152f + "_" + Build.DISPLAY;
    }

    /* renamed from: e */
    public static String m59153e() {
        if (m59142p()) {
            return "eui_" + m59156c("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    /* renamed from: f */
    public static String m59152f() {
        return m59156c("ro.build.version.emui");
    }

    /* renamed from: g */
    public static String m59151g() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    /* renamed from: h */
    public static String m59150h() {
        return m59156c("ro.vivo.os.build.display.id") + "_" + m59156c("ro.vivo.product.version");
    }

    /* renamed from: i */
    public static String m59149i() {
        if (m59138t()) {
            return "miui_" + m59156c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    /* renamed from: j */
    private static String m59148j() {
        try {
            String m59130a = SPUtils.m59131a("rom_info", InternalContainer.m59945d()).m59130a("rom_property_info", "");
            Logger.m37554i("RomUtils", "get Property From SP...=" + m59130a);
            return m59130a;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: k */
    public static String m59147k() {
        if (m59137u()) {
            return m59146l();
        }
        if (m59138t()) {
            return m59149i();
        }
        if (m59141q()) {
            return m59151g();
        }
        if (m59143o()) {
            return m59157c();
        }
        String m59155d = m59155d();
        if (TextUtils.isEmpty(m59155d)) {
            if (m59140r()) {
                return m59150h();
            }
            if (m59144n()) {
                return m59159b();
            }
            if (m59145m()) {
                return m59161a();
            }
            String m59153e = m59153e();
            return !TextUtils.isEmpty(m59153e) ? m59153e : Build.DISPLAY;
        }
        return m59155d;
    }

    /* renamed from: l */
    public static String m59146l() {
        if (m59137u()) {
            try {
                String m59156c = m59156c("ro.smartisan.version");
                return "smartisan_" + m59156c;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    /* renamed from: m */
    public static boolean m59145m() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    /* renamed from: n */
    public static boolean m59144n() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(f672a);
    }

    /* renamed from: o */
    public static boolean m59143o() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    /* renamed from: p */
    public static boolean m59142p() {
        return !TextUtils.isEmpty(m59156c("ro.letv.release.version"));
    }

    /* renamed from: q */
    public static boolean m59141q() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* renamed from: r */
    public static boolean m59140r() {
        String m59156c = m59156c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(m59156c) && m59156c.toLowerCase().contains(f673b);
    }

    /* renamed from: s */
    public static boolean m59139s() {
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

    /* renamed from: t */
    public static boolean m59138t() {
        if (!f676e) {
            try {
                Class.forName("miui.os.Build");
                f675d = true;
                f676e = true;
                return true;
            } catch (Exception unused) {
                f676e = true;
            }
        }
        return f675d;
    }

    /* renamed from: u */
    public static boolean m59137u() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    /* renamed from: a */
    public static String m59161a() {
        return m59156c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m59158b(String str) {
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
                } catch (IOException e) {
                    Logger.m37556e("ToolUtils", "Exception while closing InputStream", e);
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                try {
                    Logger.m37556e("ToolUtils", "Unable to read sysprop " + str, th);
                    return str2;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            Logger.m37556e("ToolUtils", "Exception while closing InputStream", e2);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    /* renamed from: c */
    private static String m59156c(String str) {
        String str2;
        try {
            str2 = m59148j();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new CallableC0988a(str));
                    f674c.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    /* renamed from: d */
    public static boolean m59154d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m59152f();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || m59139s();
    }
}
