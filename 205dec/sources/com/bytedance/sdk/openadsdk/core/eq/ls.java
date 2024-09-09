package com.bytedance.sdk.openadsdk.core.eq;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.h3;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls {

    /* renamed from: c  reason: collision with root package name */
    public static int f33267c = 0;
    private static int ev = Integer.MAX_VALUE;

    /* renamed from: r  reason: collision with root package name */
    private static String f33269r;

    /* renamed from: w  reason: collision with root package name */
    public static int f33270w;
    private static final CharSequence xv = "sony";
    private static final CharSequence sr = "amigo";
    private static final CharSequence ux = "funtouch";

    /* renamed from: f  reason: collision with root package name */
    private static final CharSequence f33268f = LiveConfigKey.ORIGIN;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Callable<String> {

        /* renamed from: c  reason: collision with root package name */
        private String f33272c;

        public c(String str) {
            this.f33272c = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String xv = ls.xv(this.f33272c);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.bytedance.sdk.component.utils.a.w(h3.f5722a, "property:" + xv + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(xv)) {
                try {
                    ba.c("rom_info").c("rom_property_info", xv);
                } catch (Throwable unused) {
                }
            }
            return xv;
        }
    }

    public static String c() {
        if (TextUtils.isEmpty(f33269r)) {
            f33269r = p();
        }
        return f33269r;
    }

    public static boolean ev() {
        if (ev == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String gd = wv.gd("kllk");
            if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.ROOT).contains(gd)) {
                ev = 1;
            } else {
                ev = 0;
            }
        }
        return ev == 1;
    }

    public static boolean f() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean gd() {
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

    private static String k() {
        try {
            return ba.c("rom_info").w("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String p() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (w()) {
            return "miui_" + str;
        } else if (xv()) {
            return "huawei_" + str;
        } else {
            Locale locale = Locale.ROOT;
            if (str2.toLowerCase(locale).contains("oppo")) {
                return "oppo_" + str;
            } else if (str2.toLowerCase(locale).contains("vivo")) {
                return "vivo_" + str;
            } else if (str2.toLowerCase(locale).contains("oneplus")) {
                return "oneplus_" + str;
            } else {
                return str;
            }
        }
    }

    public static String r() {
        return sr("ro.build.version.emui");
    }

    public static boolean sr() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if (!str.toLowerCase().contains("oppo")) {
                    if (!str.toLowerCase().contains("realme")) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("romUtil", e4.getMessage());
        }
        return false;
    }

    public static boolean ux() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.f("romUtils", e4.getMessage());
            return false;
        }
    }

    public static boolean xv() {
        if (f33270w == 0) {
            try {
                Class.forName("com.huawei.system.BuildEx");
                f33270w = 1;
            } catch (Exception unused) {
            }
        }
        return f33270w == 1;
    }

    public static boolean w() {
        if (f33267c == 0) {
            try {
                Class.forName("miui.os.Build");
                f33267c = 1;
            } catch (Exception unused) {
            }
        }
        return f33267c == 1;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = r();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || gd();
    }

    private static String sr(String str) {
        String str2;
        try {
            str2 = k();
            try {
                if (TextUtils.isEmpty(str2)) {
                    final com.bytedance.sdk.component.gd.gd gdVar = new com.bytedance.sdk.component.gd.gd(new c(str), 5, 2);
                    com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.eq.ls.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gdVar.run();
                        }
                    });
                    str2 = (String) gdVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xv(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = "";
        Process process = null;
        try {
        } catch (IOException e4) {
            com.bytedance.sdk.component.utils.a.xv("ToolUtils", "Exception while closing InputStream", e4);
        }
        try {
            try {
                Process exec = Runtime.getRuntime().exec("getprop " + str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                    try {
                        str2 = bufferedReader.readLine();
                        exec.exitValue();
                        bufferedReader.close();
                    } catch (IllegalThreadStateException unused) {
                        process = exec;
                        try {
                            process.destroy();
                        } catch (Throwable unused2) {
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.bytedance.sdk.component.utils.a.xv("ToolUtils", "Unable to read sysprop " + str, th);
                            return str2;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    com.bytedance.sdk.component.utils.a.xv("ToolUtils", "Exception while closing InputStream", e5);
                                }
                            }
                        }
                    }
                } catch (IllegalThreadStateException unused3) {
                    bufferedReader = null;
                }
            } catch (IllegalThreadStateException unused4) {
                bufferedReader = null;
            }
            return str2;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }
}
