package com.bytedance.msdk.f;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.h3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me {
    private static final CharSequence xv = "sony";
    private static final CharSequence sr = "amigo";
    private static final CharSequence ux = "funtouch";

    /* renamed from: f  reason: collision with root package name */
    private static final ExecutorService f28343f = com.bytedance.msdk.adapter.sr.f.c("romutils", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.f.me.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });

    /* renamed from: c  reason: collision with root package name */
    public static boolean f28342c = false;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f28344w = false;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Callable<String> {

        /* renamed from: c  reason: collision with root package name */
        private final String f28345c;

        public c(String str) {
            this.f28345c = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String xv = me.xv(this.f28345c);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.bytedance.msdk.adapter.sr.xv.c(h3.f5722a, "property:" + xv + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(xv)) {
                try {
                    com.bytedance.msdk.adapter.sr.xv.xv(h3.f5722a, "SP-getPropertyFromSP:" + xv);
                    wv.c("rom_info", com.bytedance.msdk.core.c.getContext()).c("rom_property_info", xv);
                } catch (Throwable unused) {
                }
            }
            return xv;
        }
    }

    public static String a() {
        if (ux()) {
            return "miui_" + sr("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String bk() {
        String t3 = t();
        if (t3 == null || !t3.toLowerCase().contains("emotionui")) {
            return "";
        }
        return t3 + "_" + Build.DISPLAY;
    }

    public static String c() {
        if (ys()) {
            return fp();
        }
        if (ux()) {
            return a();
        }
        if (w()) {
            return ia();
        }
        if (s()) {
            return fz();
        }
        String bk = bk();
        if (TextUtils.isEmpty(bk)) {
            if (r()) {
                return f();
            }
            if (ev()) {
                return gd();
            }
            if (sr()) {
                return xv();
            }
            String p3 = p();
            return !TextUtils.isEmpty(p3) ? p3 : Build.DISPLAY;
        }
        return bk;
    }

    public static boolean ev() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(sr);
    }

    public static String f() {
        return sr("ro.vivo.os.build.display.id") + "_" + sr("ro.vivo.product.version");
    }

    public static String fp() {
        if (ys()) {
            try {
                String sr2 = sr("ro.smartisan.version");
                return "smartisan_" + sr2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String fz() {
        if (s()) {
            return "coloros_" + sr("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String gd() {
        return Build.DISPLAY + "_" + sr("ro.gn.sv.version");
    }

    private static String i() {
        try {
            String w3 = wv.c("rom_info", com.bytedance.msdk.core.c.getContext()).w("rom_property_info", "");
            com.bytedance.msdk.adapter.sr.xv.w(h3.f5722a, "get Property From SP...=" + w3);
            return w3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String ia() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(sr("ro.letv.release.version"));
    }

    public static String p() {
        if (k()) {
            return "eui_" + sr("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean r() {
        String sr2 = sr("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(sr2) && sr2.toLowerCase().contains(ux);
    }

    public static boolean s() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static boolean sr() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String t() {
        return sr("ro.build.version.emui");
    }

    public static boolean u() {
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

    public static boolean ux() {
        if (!f28344w) {
            try {
                Class.forName("miui.os.Build");
                f28342c = true;
                f28344w = true;
                return true;
            } catch (Exception unused) {
                f28344w = true;
            }
        }
        return f28342c;
    }

    public static String xv() {
        return sr("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean ys() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean w() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xv(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process exec;
        String str2 = "";
        try {
            exec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            str2 = bufferedReader.readLine();
            exec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                com.bytedance.msdk.adapter.sr.xv.w("ToolUtils", "Exception while closing InputStream", e4);
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            try {
                com.bytedance.msdk.adapter.sr.xv.w("ToolUtils", "Unable to read sysprop " + str, th);
                return str2;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                        com.bytedance.msdk.adapter.sr.xv.w("ToolUtils", "Exception while closing InputStream", e5);
                    }
                }
            }
        }
    }

    private static String sr(String str) {
        String str2;
        try {
            str2 = i();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new c(str));
                    f28343f.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = t();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || u();
    }
}
