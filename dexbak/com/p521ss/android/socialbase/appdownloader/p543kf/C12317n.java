package com.p521ss.android.socialbase.appdownloader.p543kf;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.appdownloader.C12310h;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12317n {

    /* renamed from: a */
    public static String f34737a = "";

    /* renamed from: bl */
    public static String f34738bl = null;

    /* renamed from: h */
    private static String f34739h = null;

    /* renamed from: kf */
    private static String f34740kf = null;

    /* renamed from: n */
    private static String f34741n = null;

    /* renamed from: ok */
    public static String f34742ok = null;

    /* renamed from: p */
    private static Boolean f34743p = null;

    /* renamed from: s */
    private static String f34744s = "";

    /* renamed from: a */
    public static boolean m18246a() {
        return m18235ok("MAGICUI");
    }

    /* renamed from: bl */
    public static boolean m18244bl() {
        return m18235ok("MIUI");
    }

    /* renamed from: h */
    public static boolean m18242h() {
        return m18235ok("SAMSUNG");
    }

    /* renamed from: i */
    public static boolean m18241i() {
        if (f34743p == null) {
            f34743p = Boolean.valueOf(C12329s.m18167h().equals("harmony"));
        }
        return f34743p.booleanValue();
    }

    @NonNull
    /* renamed from: j */
    public static String m18240j() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    /* renamed from: k */
    public static String m18239k() {
        if (f34738bl == null) {
            m18235ok("");
        }
        return f34738bl;
    }

    /* renamed from: kf */
    public static boolean m18238kf() {
        return m18235ok("FLYME");
    }

    /* renamed from: n */
    public static boolean m18237n() {
        m18227td();
        return m18235ok(f34742ok);
    }

    /* renamed from: ok */
    public static boolean m18236ok() {
        return m18235ok("EMUI") || m18235ok("MAGICUI");
    }

    /* renamed from: p */
    public static String m18234p() {
        if (f34741n == null) {
            m18235ok("");
        }
        return f34741n;
    }

    /* renamed from: q */
    public static String m18233q() {
        if (f34740kf == null) {
            m18235ok("");
        }
        return f34740kf;
    }

    @NonNull
    /* renamed from: r */
    public static String m18232r() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    /* renamed from: rh */
    public static boolean m18231rh() {
        m18224zz();
        return "V11".equals(f34739h);
    }

    /* renamed from: s */
    public static boolean m18230s() {
        return m18235ok("VIVO");
    }

    /* renamed from: t */
    public static boolean m18228t() {
        m18224zz();
        return "V12".equals(f34739h);
    }

    /* renamed from: td */
    private static void m18227td() {
        if (TextUtils.isEmpty(f34742ok)) {
            C12490bl.m17818fl();
            f34742ok = C12415n.f34985a;
            f34744s = "ro.build.version." + C12415n.f34986bl + "rom";
            f34737a = "com." + C12415n.f34986bl + ".market";
        }
    }

    /* renamed from: x */
    public static boolean m18226x() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: z */
    public static boolean m18225z() {
        m18224zz();
        return "V10".equals(f34739h);
    }

    /* renamed from: zz */
    private static void m18224zz() {
        if (f34739h == null) {
            try {
                f34739h = m18229s("ro.miui.ui.version.name");
            } catch (Exception e) {
                e.printStackTrace();
            }
            String str = f34739h;
            if (str == null) {
                str = "";
            }
            f34739h = str;
        }
    }

    /* renamed from: a */
    public static String m18245a(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                C12713kf.m16531ok(bufferedReader);
                return readLine;
            } catch (Throwable unused) {
                C12713kf.m16531ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    /* renamed from: bl */
    public static String m18243bl(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    /* renamed from: ok */
    public static boolean m18235ok(String str) {
        m18227td();
        String str2 = f34741n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String m18229s = m18229s("ro.miui.ui.version.name");
        f34740kf = m18229s;
        if (!TextUtils.isEmpty(m18229s)) {
            f34741n = "MIUI";
            f34738bl = "com.xiaomi.market";
            f34739h = f34740kf;
        } else {
            String m18229s2 = m18229s("ro.build.version.emui");
            f34740kf = m18229s2;
            if (!TextUtils.isEmpty(m18229s2)) {
                f34741n = m18226x() ? "MAGICUI" : "EMUI";
                f34738bl = "com.huawei.appmarket";
            } else {
                String m18229s3 = m18229s(f34744s);
                f34740kf = m18229s3;
                if (!TextUtils.isEmpty(m18229s3)) {
                    f34741n = f34742ok;
                    if (C12310h.m18377ok(f34737a) > -1) {
                        f34738bl = f34737a;
                    } else {
                        f34738bl = "com.heytap.market";
                    }
                } else {
                    String m18229s4 = m18229s("ro.vivo.os.version");
                    f34740kf = m18229s4;
                    if (!TextUtils.isEmpty(m18229s4)) {
                        f34741n = "VIVO";
                        f34738bl = "com.bbk.appstore";
                    } else {
                        String m18229s5 = m18229s("ro.smartisan.version");
                        f34740kf = m18229s5;
                        if (!TextUtils.isEmpty(m18229s5)) {
                            f34741n = "SMARTISAN";
                            f34738bl = "com.smartisanos.appstore";
                        } else {
                            String m18229s6 = m18229s("ro.gn.sv.version");
                            f34740kf = m18229s6;
                            if (!TextUtils.isEmpty(m18229s6)) {
                                f34741n = "QIONEE";
                                f34738bl = "com.gionee.aora.market";
                            } else {
                                String m18229s7 = m18229s("ro.lenovo.lvp.version");
                                f34740kf = m18229s7;
                                if (!TextUtils.isEmpty(m18229s7)) {
                                    f34741n = "LENOVO";
                                    f34738bl = "com.lenovo.leos.appstore";
                                } else if (m18232r().toUpperCase().contains("SAMSUNG")) {
                                    f34741n = "SAMSUNG";
                                    f34738bl = "com.sec.android.app.samsungapps";
                                } else if (m18232r().toUpperCase().contains("ZTE")) {
                                    f34741n = "ZTE";
                                    f34738bl = "zte.com.market";
                                } else if (m18232r().toUpperCase().contains("NUBIA")) {
                                    f34741n = "NUBIA";
                                    f34738bl = "cn.nubia.neostore";
                                } else if (m18240j().toUpperCase().contains("FLYME")) {
                                    f34741n = "FLYME";
                                    f34738bl = "com.meizu.mstore";
                                    f34740kf = m18240j();
                                } else if (m18232r().toUpperCase().contains("ONEPLUS")) {
                                    f34741n = "ONEPLUS";
                                    f34740kf = m18229s("ro.rom.version");
                                    if (C12310h.m18377ok(f34737a) > -1) {
                                        f34738bl = f34737a;
                                    } else {
                                        f34738bl = "com.heytap.market";
                                    }
                                } else {
                                    f34741n = m18232r().toUpperCase();
                                    f34738bl = "";
                                    f34740kf = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        return f34741n.equals(str);
    }

    /* renamed from: s */
    public static String m18229s(String str) {
        if (C12534ok.m17610a().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return m18243bl(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return m18245a(str);
            }
        }
        return m18245a(str);
    }
}
