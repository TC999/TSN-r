package com.amap.api.col.p0003l;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RomIdentifier.java */
/* renamed from: com.amap.api.col.3l.p5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p5 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile gv f8642a;

    /* renamed from: b  reason: collision with root package name */
    private static Properties f8643b = f();

    private p5() {
    }

    public static gv a() {
        if (f8642a == null) {
            synchronized (p5.class) {
                if (f8642a == null) {
                    try {
                        gv b4 = b(Build.MANUFACTURER);
                        if ("".equals(b4.a())) {
                            Iterator it = Arrays.asList(gv.MIUI.a(), gv.Flyme.a(), gv.RH.a(), gv.ColorOS.a(), gv.FuntouchOS.a(), gv.SmartisanOS.a(), gv.AmigoOS.a(), gv.Sense.a(), gv.LG.a(), gv.Google.a(), gv.NubiaUI.a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    gv b5 = b((String) it.next());
                                    if (!"".equals(b5.a())) {
                                        b4 = b5;
                                        break;
                                    }
                                } else {
                                    b4 = gv.Other;
                                    break;
                                }
                            }
                        }
                        f8642a = b4;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return f8642a;
    }

    private static gv b(String str) {
        if (str != null && str.length() > 0) {
            gv gvVar = gv.MIUI;
            if (str.equals(gvVar.a())) {
                if (d(gvVar)) {
                    return gvVar;
                }
            } else {
                gv gvVar2 = gv.Flyme;
                if (str.equals(gvVar2.a())) {
                    if (g(gvVar2)) {
                        return gvVar2;
                    }
                } else {
                    gv gvVar3 = gv.RH;
                    if (str.equals(gvVar3.a())) {
                        if (i(gvVar3)) {
                            return gvVar3;
                        }
                    } else {
                        gv gvVar4 = gv.ColorOS;
                        if (str.equals(gvVar4.a())) {
                            if (j(gvVar4)) {
                                return gvVar4;
                            }
                        } else {
                            gv gvVar5 = gv.FuntouchOS;
                            if (str.equals(gvVar5.a())) {
                                if (k(gvVar5)) {
                                    return gvVar5;
                                }
                            } else {
                                gv gvVar6 = gv.SmartisanOS;
                                if (str.equals(gvVar6.a())) {
                                    if (l(gvVar6)) {
                                        return gvVar6;
                                    }
                                } else {
                                    gv gvVar7 = gv.AmigoOS;
                                    if (str.equals(gvVar7.a())) {
                                        if (m(gvVar7)) {
                                            return gvVar7;
                                        }
                                    } else {
                                        gv gvVar8 = gv.EUI;
                                        if (str.equals(gvVar8.a())) {
                                            if (n(gvVar8)) {
                                                return gvVar8;
                                            }
                                        } else {
                                            gv gvVar9 = gv.Sense;
                                            if (str.equals(gvVar9.a())) {
                                                if (o(gvVar9)) {
                                                    return gvVar9;
                                                }
                                            } else {
                                                gv gvVar10 = gv.LG;
                                                if (str.equals(gvVar10.a())) {
                                                    if (p(gvVar10)) {
                                                        return gvVar10;
                                                    }
                                                } else {
                                                    gv gvVar11 = gv.Google;
                                                    if (str.equals(gvVar11.a())) {
                                                        if (q(gvVar11)) {
                                                            return gvVar11;
                                                        }
                                                    } else {
                                                        gv gvVar12 = gv.NubiaUI;
                                                        if (str.equals(gvVar12.a()) && r(gvVar12)) {
                                                            return gvVar12;
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
            return gv.Other;
        }
        return gv.Other;
    }

    private static void c(gv gvVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                gvVar.a(group);
                gvVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private static boolean d(gv gvVar) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            return false;
        }
        String e4 = e("ro.build.version.incremental");
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static String e(String str) {
        Properties properties = f8643b;
        String property = properties.getProperty("[" + str + "]", null);
        if (TextUtils.isEmpty(property)) {
            return h(str);
        }
        return property.replace("[", "").replace("]", "");
    }

    private static Properties f() {
        Properties properties = new Properties();
        try {
            properties.load(Runtime.getRuntime().exec("getprop").getInputStream());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return properties;
    }

    private static boolean g(gv gvVar) {
        String e4 = e("ro.flyme.published");
        String e5 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(e4) && TextUtils.isEmpty(e5)) {
            return false;
        }
        String e6 = e("ro.build.display.id");
        c(gvVar, e6);
        gvVar.b(e6);
        return true;
    }

    private static String h(String str) {
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

    private static boolean i(gv gvVar) {
        String e4 = e("ro.build.version.emui");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean j(gv gvVar) {
        String e4 = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean k(gv gvVar) {
        String e4 = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean l(gv gvVar) {
        String e4 = e("ro.smartisan.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean m(gv gvVar) {
        String e4 = e("ro.build.display.id");
        if (TextUtils.isEmpty(e4) || !e4.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean n(gv gvVar) {
        String e4 = e("ro.letv.release.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean o(gv gvVar) {
        String e4 = e("ro.build.sense.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean p(gv gvVar) {
        String e4 = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }

    private static boolean q(gv gvVar) {
        if ("android-google".equals(e("ro.com.google.clientidbase"))) {
            String e4 = e("ro.build.version.release");
            gvVar.a(Build.VERSION.SDK_INT);
            gvVar.b(e4);
            return true;
        }
        return false;
    }

    private static boolean r(gv gvVar) {
        String e4 = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(gvVar, e4);
        gvVar.b(e4);
        return true;
    }
}
