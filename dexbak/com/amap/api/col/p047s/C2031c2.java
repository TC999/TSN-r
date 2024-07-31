package com.amap.api.col.p047s;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RomIdentifier.java */
/* renamed from: com.amap.api.col.s.c2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2031c2 {

    /* renamed from: a */
    private static volatile EnumC2043da f5969a;

    /* renamed from: b */
    private static Properties f5970b = m53141f();

    private C2031c2() {
    }

    /* renamed from: a */
    public static EnumC2043da m53146a() {
        if (f5969a == null) {
            synchronized (C2031c2.class) {
                if (f5969a == null) {
                    try {
                        EnumC2043da m53145b = m53145b(Build.MANUFACTURER);
                        if ("".equals(m53145b.m53078a())) {
                            Iterator it = Arrays.asList(EnumC2043da.MIUI.m53078a(), EnumC2043da.Flyme.m53078a(), EnumC2043da.RH.m53078a(), EnumC2043da.ColorOS.m53078a(), EnumC2043da.FuntouchOS.m53078a(), EnumC2043da.SmartisanOS.m53078a(), EnumC2043da.AmigoOS.m53078a(), EnumC2043da.Sense.m53078a(), EnumC2043da.LG.m53078a(), EnumC2043da.Google.m53078a(), EnumC2043da.NubiaUI.m53078a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    EnumC2043da m53145b2 = m53145b((String) it.next());
                                    if (!"".equals(m53145b2.m53078a())) {
                                        m53145b = m53145b2;
                                        break;
                                    }
                                } else {
                                    m53145b = EnumC2043da.Other;
                                    break;
                                }
                            }
                        }
                        f5969a = m53145b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f5969a;
    }

    /* renamed from: b */
    private static EnumC2043da m53145b(String str) {
        if (str != null && str.length() > 0) {
            EnumC2043da enumC2043da = EnumC2043da.MIUI;
            if (str.equals(enumC2043da.m53078a())) {
                if (m53143d(enumC2043da)) {
                    return enumC2043da;
                }
            } else {
                EnumC2043da enumC2043da2 = EnumC2043da.Flyme;
                if (str.equals(enumC2043da2.m53078a())) {
                    if (m53140g(enumC2043da2)) {
                        return enumC2043da2;
                    }
                } else {
                    EnumC2043da enumC2043da3 = EnumC2043da.RH;
                    if (str.equals(enumC2043da3.m53078a())) {
                        if (m53138i(enumC2043da3)) {
                            return enumC2043da3;
                        }
                    } else {
                        EnumC2043da enumC2043da4 = EnumC2043da.ColorOS;
                        if (str.equals(enumC2043da4.m53078a())) {
                            if (m53137j(enumC2043da4)) {
                                return enumC2043da4;
                            }
                        } else {
                            EnumC2043da enumC2043da5 = EnumC2043da.FuntouchOS;
                            if (str.equals(enumC2043da5.m53078a())) {
                                if (m53136k(enumC2043da5)) {
                                    return enumC2043da5;
                                }
                            } else {
                                EnumC2043da enumC2043da6 = EnumC2043da.SmartisanOS;
                                if (str.equals(enumC2043da6.m53078a())) {
                                    if (m53135l(enumC2043da6)) {
                                        return enumC2043da6;
                                    }
                                } else {
                                    EnumC2043da enumC2043da7 = EnumC2043da.AmigoOS;
                                    if (str.equals(enumC2043da7.m53078a())) {
                                        if (m53134m(enumC2043da7)) {
                                            return enumC2043da7;
                                        }
                                    } else {
                                        EnumC2043da enumC2043da8 = EnumC2043da.EUI;
                                        if (str.equals(enumC2043da8.m53078a())) {
                                            if (m53133n(enumC2043da8)) {
                                                return enumC2043da8;
                                            }
                                        } else {
                                            EnumC2043da enumC2043da9 = EnumC2043da.Sense;
                                            if (str.equals(enumC2043da9.m53078a())) {
                                                if (m53132o(enumC2043da9)) {
                                                    return enumC2043da9;
                                                }
                                            } else {
                                                EnumC2043da enumC2043da10 = EnumC2043da.LG;
                                                if (str.equals(enumC2043da10.m53078a())) {
                                                    if (m53131p(enumC2043da10)) {
                                                        return enumC2043da10;
                                                    }
                                                } else {
                                                    EnumC2043da enumC2043da11 = EnumC2043da.Google;
                                                    if (str.equals(enumC2043da11.m53078a())) {
                                                        if (m53130q(enumC2043da11)) {
                                                            return enumC2043da11;
                                                        }
                                                    } else {
                                                        EnumC2043da enumC2043da12 = EnumC2043da.NubiaUI;
                                                        if (str.equals(enumC2043da12.m53078a()) && m53129r(enumC2043da12)) {
                                                            return enumC2043da12;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return EnumC2043da.Other;
        }
        return EnumC2043da.Other;
    }

    /* renamed from: c */
    private static void m53144c(EnumC2043da enumC2043da, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                enumC2043da.m53076a(group);
                enumC2043da.m53077a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private static boolean m53143d(EnumC2043da enumC2043da) {
        if (TextUtils.isEmpty(m53142e("ro.miui.ui.version.name"))) {
            return false;
        }
        String m53142e = m53142e("ro.build.version.incremental");
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: e */
    private static String m53142e(String str) {
        Properties properties = f5970b;
        String property = properties.getProperty("[" + str + "]", null);
        if (TextUtils.isEmpty(property)) {
            return m53139h(str);
        }
        return property.replace("[", "").replace("]", "");
    }

    /* renamed from: f */
    private static Properties m53141f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /* renamed from: g */
    private static boolean m53140g(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.flyme.published");
        String m53142e2 = m53142e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(m53142e) && TextUtils.isEmpty(m53142e2)) {
            return false;
        }
        String m53142e3 = m53142e("ro.build.display.id");
        m53144c(enumC2043da, m53142e3);
        enumC2043da.m53074b(m53142e3);
        return true;
    }

    /* renamed from: h */
    private static String m53139h(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (IOException unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: i */
    private static boolean m53138i(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.build.version.emui");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: j */
    private static boolean m53137j(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.build.version.opporom");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: k */
    private static boolean m53136k(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: l */
    private static boolean m53135l(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.smartisan.version");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: m */
    private static boolean m53134m(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.build.display.id");
        if (TextUtils.isEmpty(m53142e) || !m53142e.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: n */
    private static boolean m53133n(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.letv.release.version");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: o */
    private static boolean m53132o(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.build.sense.version");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: p */
    private static boolean m53131p(EnumC2043da enumC2043da) {
        String m53142e = m53142e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }

    /* renamed from: q */
    private static boolean m53130q(EnumC2043da enumC2043da) {
        if ("android-google".equals(m53142e("ro.com.google.clientidbase"))) {
            String m53142e = m53142e("ro.build.version.release");
            enumC2043da.m53077a(Build.VERSION.SDK_INT);
            enumC2043da.m53074b(m53142e);
            return true;
        }
        return false;
    }

    /* renamed from: r */
    private static boolean m53129r(EnumC2043da enumC2043da) {
        String m53142e = m53142e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(m53142e)) {
            return false;
        }
        m53144c(enumC2043da, m53142e);
        enumC2043da.m53074b(m53142e);
        return true;
    }
}
