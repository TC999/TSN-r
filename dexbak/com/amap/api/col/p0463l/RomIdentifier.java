package com.amap.api.col.p0463l;

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

/* renamed from: com.amap.api.col.3l.o5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RomIdentifier {

    /* renamed from: a */
    private static volatile Rom f4803a;

    /* renamed from: b */
    private static Properties f4804b = m54376f();

    private RomIdentifier() {
    }

    /* renamed from: a */
    public static Rom m54381a() {
        if (f4803a == null) {
            synchronized (RomIdentifier.class) {
                if (f4803a == null) {
                    try {
                        Rom m54380b = m54380b(Build.MANUFACTURER);
                        if ("".equals(m54380b.m54873a())) {
                            Iterator it = Arrays.asList(Rom.MIUI.m54873a(), Rom.Flyme.m54873a(), Rom.RH.m54873a(), Rom.ColorOS.m54873a(), Rom.FuntouchOS.m54873a(), Rom.SmartisanOS.m54873a(), Rom.AmigoOS.m54873a(), Rom.Sense.m54873a(), Rom.LG.m54873a(), Rom.Google.m54873a(), Rom.NubiaUI.m54873a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Rom m54380b2 = m54380b((String) it.next());
                                    if (!"".equals(m54380b2.m54873a())) {
                                        m54380b = m54380b2;
                                        break;
                                    }
                                } else {
                                    m54380b = Rom.Other;
                                    break;
                                }
                            }
                        }
                        f4803a = m54380b;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return f4803a;
    }

    /* renamed from: b */
    private static Rom m54380b(String str) {
        if (str != null && str.length() > 0) {
            Rom rom = Rom.MIUI;
            if (str.equals(rom.m54873a())) {
                if (m54378d(rom)) {
                    return rom;
                }
            } else {
                Rom rom2 = Rom.Flyme;
                if (str.equals(rom2.m54873a())) {
                    if (m54375g(rom2)) {
                        return rom2;
                    }
                } else {
                    Rom rom3 = Rom.RH;
                    if (str.equals(rom3.m54873a())) {
                        if (m54373i(rom3)) {
                            return rom3;
                        }
                    } else {
                        Rom rom4 = Rom.ColorOS;
                        if (str.equals(rom4.m54873a())) {
                            if (m54372j(rom4)) {
                                return rom4;
                            }
                        } else {
                            Rom rom5 = Rom.FuntouchOS;
                            if (str.equals(rom5.m54873a())) {
                                if (m54371k(rom5)) {
                                    return rom5;
                                }
                            } else {
                                Rom rom6 = Rom.SmartisanOS;
                                if (str.equals(rom6.m54873a())) {
                                    if (m54370l(rom6)) {
                                        return rom6;
                                    }
                                } else {
                                    Rom rom7 = Rom.AmigoOS;
                                    if (str.equals(rom7.m54873a())) {
                                        if (m54369m(rom7)) {
                                            return rom7;
                                        }
                                    } else {
                                        Rom rom8 = Rom.EUI;
                                        if (str.equals(rom8.m54873a())) {
                                            if (m54368n(rom8)) {
                                                return rom8;
                                            }
                                        } else {
                                            Rom rom9 = Rom.Sense;
                                            if (str.equals(rom9.m54873a())) {
                                                if (m54367o(rom9)) {
                                                    return rom9;
                                                }
                                            } else {
                                                Rom rom10 = Rom.LG;
                                                if (str.equals(rom10.m54873a())) {
                                                    if (m54366p(rom10)) {
                                                        return rom10;
                                                    }
                                                } else {
                                                    Rom rom11 = Rom.Google;
                                                    if (str.equals(rom11.m54873a())) {
                                                        if (m54365q(rom11)) {
                                                            return rom11;
                                                        }
                                                    } else {
                                                        Rom rom12 = Rom.NubiaUI;
                                                        if (str.equals(rom12.m54873a()) && m54364r(rom12)) {
                                                            return rom12;
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
            return Rom.Other;
        }
        return Rom.Other;
    }

    /* renamed from: c */
    private static void m54379c(Rom rom, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                rom.m54871a(group);
                rom.m54872a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private static boolean m54378d(Rom rom) {
        if (TextUtils.isEmpty(m54377e("ro.miui.ui.version.name"))) {
            return false;
        }
        String m54377e = m54377e("ro.build.version.incremental");
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: e */
    private static String m54377e(String str) {
        Properties properties = f4804b;
        String property = properties.getProperty("[" + str + "]", null);
        if (TextUtils.isEmpty(property)) {
            return m54374h(str);
        }
        return property.replace("[", "").replace("]", "");
    }

    /* renamed from: f */
    private static Properties m54376f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /* renamed from: g */
    private static boolean m54375g(Rom rom) {
        String m54377e = m54377e("ro.flyme.published");
        String m54377e2 = m54377e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(m54377e) && TextUtils.isEmpty(m54377e2)) {
            return false;
        }
        String m54377e3 = m54377e("ro.build.display.id");
        m54379c(rom, m54377e3);
        rom.m54869b(m54377e3);
        return true;
    }

    /* renamed from: h */
    private static String m54374h(String str) {
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
    private static boolean m54373i(Rom rom) {
        String m54377e = m54377e("ro.build.version.emui");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: j */
    private static boolean m54372j(Rom rom) {
        String m54377e = m54377e("ro.build.version.opporom");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: k */
    private static boolean m54371k(Rom rom) {
        String m54377e = m54377e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: l */
    private static boolean m54370l(Rom rom) {
        String m54377e = m54377e("ro.smartisan.version");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: m */
    private static boolean m54369m(Rom rom) {
        String m54377e = m54377e("ro.build.display.id");
        if (TextUtils.isEmpty(m54377e) || !m54377e.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: n */
    private static boolean m54368n(Rom rom) {
        String m54377e = m54377e("ro.letv.release.version");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: o */
    private static boolean m54367o(Rom rom) {
        String m54377e = m54377e("ro.build.sense.version");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: p */
    private static boolean m54366p(Rom rom) {
        String m54377e = m54377e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }

    /* renamed from: q */
    private static boolean m54365q(Rom rom) {
        if ("android-google".equals(m54377e("ro.com.google.clientidbase"))) {
            String m54377e = m54377e("ro.build.version.release");
            rom.m54872a(Build.VERSION.SDK_INT);
            rom.m54869b(m54377e);
            return true;
        }
        return false;
    }

    /* renamed from: r */
    private static boolean m54364r(Rom rom) {
        String m54377e = m54377e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(m54377e)) {
            return false;
        }
        m54379c(rom, m54377e);
        rom.m54869b(m54377e);
        return true;
    }
}
