package com.ss.android.socialbase.appdownloader.kf;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.c4;
import com.acse.ottn.f3;
import com.ss.android.socialbase.appdownloader.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static String f49124a = "";
    public static String bl = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f49125h = null;
    private static String kf = null;

    /* renamed from: n  reason: collision with root package name */
    private static String f49126n = null;
    public static String ok = null;

    /* renamed from: p  reason: collision with root package name */
    private static Boolean f49127p = null;

    /* renamed from: s  reason: collision with root package name */
    private static String f49128s = "";

    public static boolean a() {
        return ok("MAGICUI");
    }

    public static boolean bl() {
        return ok("MIUI");
    }

    public static boolean h() {
        return ok("SAMSUNG");
    }

    public static boolean i() {
        if (f49127p == null) {
            f49127p = Boolean.valueOf(s.h().equals(c4.f5363a));
        }
        return f49127p.booleanValue();
    }

    @NonNull
    public static String j() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static String k() {
        if (bl == null) {
            ok("");
        }
        return bl;
    }

    public static boolean kf() {
        return ok("FLYME");
    }

    public static boolean n() {
        td();
        return ok(ok);
    }

    public static boolean ok() {
        return ok("EMUI") || ok("MAGICUI");
    }

    public static String p() {
        if (f49126n == null) {
            ok("");
        }
        return f49126n;
    }

    public static String q() {
        if (kf == null) {
            ok("");
        }
        return kf;
    }

    @NonNull
    public static String r() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean rh() {
        zz();
        return "V11".equals(f49125h);
    }

    public static boolean s() {
        return ok("VIVO");
    }

    public static boolean t() {
        zz();
        return "V12".equals(f49125h);
    }

    private static void td() {
        if (TextUtils.isEmpty(ok)) {
            com.ss.android.socialbase.downloader.downloader.bl.fl();
            ok = com.ss.android.socialbase.downloader.constants.n.f49329a;
            f49128s = "ro.build.version." + com.ss.android.socialbase.downloader.constants.n.bl + "rom";
            f49124a = "com." + com.ss.android.socialbase.downloader.constants.n.bl + ".market";
        }
    }

    public static boolean x() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    public static boolean z() {
        zz();
        return "V10".equals(f49125h);
    }

    private static void zz() {
        if (f49125h == null) {
            try {
                f49125h = s("ro.miui.ui.version.name");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            String str = f49125h;
            if (str == null) {
                str = "";
            }
            f49125h = str;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.q.kf.ok(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.q.kf.ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String bl(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(f3.f5657f, String.class).invoke(null, str);
    }

    public static boolean ok(String str) {
        td();
        String str2 = f49126n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String s3 = s("ro.miui.ui.version.name");
        kf = s3;
        if (!TextUtils.isEmpty(s3)) {
            f49126n = "MIUI";
            bl = "com.xiaomi.market";
            f49125h = kf;
        } else {
            String s4 = s("ro.build.version.emui");
            kf = s4;
            if (!TextUtils.isEmpty(s4)) {
                f49126n = x() ? "MAGICUI" : "EMUI";
                bl = "com.huawei.appmarket";
            } else {
                String s5 = s(f49128s);
                kf = s5;
                if (!TextUtils.isEmpty(s5)) {
                    f49126n = ok;
                    if (h.ok(f49124a) > -1) {
                        bl = f49124a;
                    } else {
                        bl = "com.heytap.market";
                    }
                } else {
                    String s6 = s("ro.vivo.os.version");
                    kf = s6;
                    if (!TextUtils.isEmpty(s6)) {
                        f49126n = "VIVO";
                        bl = "com.bbk.appstore";
                    } else {
                        String s7 = s("ro.smartisan.version");
                        kf = s7;
                        if (!TextUtils.isEmpty(s7)) {
                            f49126n = "SMARTISAN";
                            bl = "com.smartisanos.appstore";
                        } else {
                            String s8 = s("ro.gn.sv.version");
                            kf = s8;
                            if (!TextUtils.isEmpty(s8)) {
                                f49126n = "QIONEE";
                                bl = "com.gionee.aora.market";
                            } else {
                                String s9 = s("ro.lenovo.lvp.version");
                                kf = s9;
                                if (!TextUtils.isEmpty(s9)) {
                                    f49126n = "LENOVO";
                                    bl = "com.lenovo.leos.appstore";
                                } else if (r().toUpperCase().contains("SAMSUNG")) {
                                    f49126n = "SAMSUNG";
                                    bl = "com.sec.android.app.samsungapps";
                                } else if (r().toUpperCase().contains("ZTE")) {
                                    f49126n = "ZTE";
                                    bl = "zte.com.market";
                                } else if (r().toUpperCase().contains("NUBIA")) {
                                    f49126n = "NUBIA";
                                    bl = "cn.nubia.neostore";
                                } else if (j().toUpperCase().contains("FLYME")) {
                                    f49126n = "FLYME";
                                    bl = "com.meizu.mstore";
                                    kf = j();
                                } else if (r().toUpperCase().contains("ONEPLUS")) {
                                    f49126n = "ONEPLUS";
                                    kf = s("ro.rom.version");
                                    if (h.ok(f49124a) > -1) {
                                        bl = f49124a;
                                    } else {
                                        bl = "com.heytap.market";
                                    }
                                } else {
                                    f49126n = r().toUpperCase();
                                    bl = "";
                                    kf = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f49126n.equals(str);
    }

    public static String s(String str) {
        if (com.ss.android.socialbase.downloader.h.ok.a().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return bl(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return a(str);
            }
        }
        return a(str);
    }
}
