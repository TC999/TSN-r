package com.ss.android.socialbase.appdownloader.f;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.c4;
import com.acse.ottn.f3;
import com.ss.android.socialbase.appdownloader.r;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    public static String f49090c = null;
    private static Boolean ev = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f49091f = null;

    /* renamed from: r  reason: collision with root package name */
    private static String f49092r = null;
    private static String sr = "";
    private static String ux = null;

    /* renamed from: w  reason: collision with root package name */
    public static String f49093w = "";
    public static String xv;

    @NonNull
    public static String a() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean bk() {
        fz();
        return "V10".equals(f49092r);
    }

    public static boolean c() {
        return c("EMUI") || c("MAGICUI");
    }

    public static String ev() {
        if (ux == null) {
            c("");
        }
        return ux;
    }

    public static boolean f() {
        return c("FLYME");
    }

    public static boolean fp() {
        if (ev == null) {
            ev = Boolean.valueOf(sr.r().equals(c4.f5363a));
        }
        return ev.booleanValue();
    }

    private static void fz() {
        if (f49092r == null) {
            try {
                f49092r = sr("ro.miui.ui.version.name");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String str = f49092r;
            if (str == null) {
                str = "";
            }
            f49092r = str;
        }
    }

    public static String gd() {
        if (f49091f == null) {
            c("");
        }
        return f49091f;
    }

    public static boolean ia() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static String k() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String p() {
        if (xv == null) {
            c("");
        }
        return xv;
    }

    public static boolean r() {
        return c("SAMSUNG");
    }

    private static void s() {
        if (TextUtils.isEmpty(f49090c)) {
            com.ss.android.socialbase.downloader.downloader.xv.wv();
            f49090c = com.ss.android.socialbase.downloader.constants.ux.f49354w;
            sr = "ro.build.version." + com.ss.android.socialbase.downloader.constants.ux.xv + "rom";
            f49093w = "com." + com.ss.android.socialbase.downloader.constants.ux.xv + ".market";
        }
    }

    public static boolean sr() {
        return c("VIVO");
    }

    public static boolean t() {
        fz();
        return "V11".equals(f49092r);
    }

    public static boolean ux() {
        s();
        return c(f49090c);
    }

    public static boolean w() {
        return c("MAGICUI");
    }

    public static boolean xv() {
        return c("MIUI");
    }

    public static boolean ys() {
        fz();
        return "V12".equals(f49092r);
    }

    public static boolean c(String str) {
        s();
        String str2 = ux;
        if (str2 != null) {
            return str2.equals(str);
        }
        String sr2 = sr("ro.miui.ui.version.name");
        f49091f = sr2;
        if (!TextUtils.isEmpty(sr2)) {
            ux = "MIUI";
            xv = "com.xiaomi.market";
            f49092r = f49091f;
        } else {
            String sr3 = sr("ro.build.version.emui");
            f49091f = sr3;
            if (!TextUtils.isEmpty(sr3)) {
                String str3 = ia() ? "MAGICUI" : "EMUI";
                ux = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    xv = "com.hihonor.appmarket";
                } else {
                    xv = "com.huawei.appmarket";
                }
            } else {
                String sr4 = sr(sr);
                f49091f = sr4;
                if (!TextUtils.isEmpty(sr4)) {
                    ux = f49090c;
                    if (r.c(f49093w) > -1) {
                        xv = f49093w;
                    } else {
                        xv = "com.heytap.market";
                    }
                } else {
                    String sr5 = sr("ro.vivo.os.version");
                    f49091f = sr5;
                    if (!TextUtils.isEmpty(sr5)) {
                        ux = "VIVO";
                        xv = "com.bbk.appstore";
                    } else {
                        String sr6 = sr("ro.smartisan.version");
                        f49091f = sr6;
                        if (!TextUtils.isEmpty(sr6)) {
                            ux = "SMARTISAN";
                            xv = "com.smartisanos.appstore";
                        } else {
                            String sr7 = sr("ro.gn.sv.version");
                            f49091f = sr7;
                            if (!TextUtils.isEmpty(sr7)) {
                                ux = "QIONEE";
                                xv = "com.gionee.aora.market";
                            } else {
                                String sr8 = sr("ro.lenovo.lvp.version");
                                f49091f = sr8;
                                if (!TextUtils.isEmpty(sr8)) {
                                    ux = "LENOVO";
                                    xv = "com.lenovo.leos.appstore";
                                } else if (k().toUpperCase().contains("SAMSUNG")) {
                                    ux = "SAMSUNG";
                                    xv = "com.sec.android.app.samsungapps";
                                } else if (k().toUpperCase().contains("ZTE")) {
                                    ux = "ZTE";
                                    xv = "zte.com.market";
                                } else if (k().toUpperCase().contains("NUBIA")) {
                                    ux = "NUBIA";
                                    xv = "cn.nubia.neostore";
                                } else if (a().toUpperCase().contains("FLYME")) {
                                    ux = "FLYME";
                                    xv = "com.meizu.mstore";
                                    f49091f = a();
                                } else if (k().toUpperCase().contains("ONEPLUS")) {
                                    ux = "ONEPLUS";
                                    f49091f = sr("ro.rom.version");
                                    if (r.c(f49093w) > -1) {
                                        xv = f49093w;
                                    } else {
                                        xv = "com.heytap.market";
                                    }
                                } else {
                                    ux = k().toUpperCase();
                                    xv = "";
                                    f49091f = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return ux.equals(str);
    }

    public static String sr(String str) {
        if (com.ss.android.socialbase.downloader.r.c.w().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return xv(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return w(str);
            }
        }
        return w(str);
    }

    public static String w(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.gd.f.c(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.gd.f.c(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String xv(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(f3.f5657f, String.class).invoke(null, str);
    }
}
