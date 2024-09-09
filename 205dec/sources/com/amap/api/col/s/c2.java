package com.amap.api.col.s;

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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile da f9697a;

    /* renamed from: b  reason: collision with root package name */
    private static Properties f9698b = f();

    private c2() {
    }

    public static da a() {
        if (f9697a == null) {
            synchronized (c2.class) {
                if (f9697a == null) {
                    try {
                        da b4 = b(Build.MANUFACTURER);
                        if ("".equals(b4.a())) {
                            Iterator it = Arrays.asList(da.MIUI.a(), da.Flyme.a(), da.RH.a(), da.ColorOS.a(), da.FuntouchOS.a(), da.SmartisanOS.a(), da.AmigoOS.a(), da.Sense.a(), da.LG.a(), da.Google.a(), da.NubiaUI.a()).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    da b5 = b((String) it.next());
                                    if (!"".equals(b5.a())) {
                                        b4 = b5;
                                        break;
                                    }
                                } else {
                                    b4 = da.Other;
                                    break;
                                }
                            }
                        }
                        f9697a = b4;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return f9697a;
    }

    private static da b(String str) {
        if (str != null && str.length() > 0) {
            da daVar = da.MIUI;
            if (str.equals(daVar.a())) {
                if (d(daVar)) {
                    return daVar;
                }
            } else {
                da daVar2 = da.Flyme;
                if (str.equals(daVar2.a())) {
                    if (g(daVar2)) {
                        return daVar2;
                    }
                } else {
                    da daVar3 = da.RH;
                    if (str.equals(daVar3.a())) {
                        if (i(daVar3)) {
                            return daVar3;
                        }
                    } else {
                        da daVar4 = da.ColorOS;
                        if (str.equals(daVar4.a())) {
                            if (j(daVar4)) {
                                return daVar4;
                            }
                        } else {
                            da daVar5 = da.FuntouchOS;
                            if (str.equals(daVar5.a())) {
                                if (k(daVar5)) {
                                    return daVar5;
                                }
                            } else {
                                da daVar6 = da.SmartisanOS;
                                if (str.equals(daVar6.a())) {
                                    if (l(daVar6)) {
                                        return daVar6;
                                    }
                                } else {
                                    da daVar7 = da.AmigoOS;
                                    if (str.equals(daVar7.a())) {
                                        if (m(daVar7)) {
                                            return daVar7;
                                        }
                                    } else {
                                        da daVar8 = da.EUI;
                                        if (str.equals(daVar8.a())) {
                                            if (n(daVar8)) {
                                                return daVar8;
                                            }
                                        } else {
                                            da daVar9 = da.Sense;
                                            if (str.equals(daVar9.a())) {
                                                if (o(daVar9)) {
                                                    return daVar9;
                                                }
                                            } else {
                                                da daVar10 = da.LG;
                                                if (str.equals(daVar10.a())) {
                                                    if (p(daVar10)) {
                                                        return daVar10;
                                                    }
                                                } else {
                                                    da daVar11 = da.Google;
                                                    if (str.equals(daVar11.a())) {
                                                        if (q(daVar11)) {
                                                            return daVar11;
                                                        }
                                                    } else {
                                                        da daVar12 = da.NubiaUI;
                                                        if (str.equals(daVar12.a()) && r(daVar12)) {
                                                            return daVar12;
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
            return da.Other;
        }
        return da.Other;
    }

    private static void c(da daVar, String str) {
        Matcher matcher = Pattern.compile("([\\d.]+)[^\\d]*").matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                daVar.a(group);
                daVar.a(Integer.parseInt(group.split("\\.")[0]));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private static boolean d(da daVar) {
        if (TextUtils.isEmpty(e("ro.miui.ui.version.name"))) {
            return false;
        }
        String e4 = e("ro.build.version.incremental");
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static String e(String str) {
        Properties properties = f9698b;
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

    private static boolean g(da daVar) {
        String e4 = e("ro.flyme.published");
        String e5 = e("ro.meizu.setupwizard.flyme");
        if (TextUtils.isEmpty(e4) && TextUtils.isEmpty(e5)) {
            return false;
        }
        String e6 = e("ro.build.display.id");
        c(daVar, e6);
        daVar.b(e6);
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

    private static boolean i(da daVar) {
        String e4 = e("ro.build.version.emui");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean j(da daVar) {
        String e4 = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean k(da daVar) {
        String e4 = e("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean l(da daVar) {
        String e4 = e("ro.smartisan.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean m(da daVar) {
        String e4 = e("ro.build.display.id");
        if (TextUtils.isEmpty(e4) || !e4.matches("amigo([\\d.]+)[a-zA-Z]*")) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean n(da daVar) {
        String e4 = e("ro.letv.release.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean o(da daVar) {
        String e4 = e("ro.build.sense.version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean p(da daVar) {
        String e4 = e("sys.lge.lgmdm_version");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }

    private static boolean q(da daVar) {
        if ("android-google".equals(e("ro.com.google.clientidbase"))) {
            String e4 = e("ro.build.version.release");
            daVar.a(Build.VERSION.SDK_INT);
            daVar.b(e4);
            return true;
        }
        return false;
    }

    private static boolean r(da daVar) {
        String e4 = e("ro.build.nubia.rom.code");
        if (TextUtils.isEmpty(e4)) {
            return false;
        }
        c(daVar, e4);
        daVar.b(e4);
        return true;
    }
}
