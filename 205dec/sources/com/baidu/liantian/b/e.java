package com.baidu.liantian.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.liantian.LiantianProvider;
import com.baidu.liantian.LiantianReceiver;
import com.baidu.liantian.LiantianService;
import com.baidu.liantian.ac.F;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.jni.Asc;
import com.baidu.liantian.rp.Report;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: CommonMethods.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12113a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f12114b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f12115c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12116d = "1000001";

    /* renamed from: e  reason: collision with root package name */
    public static String f12117e = "0a2ff98dd00fdca15fcdbc895fc09e6b";

    /* renamed from: f  reason: collision with root package name */
    public static LiantianReceiver f12118f = null;

    /* renamed from: g  reason: collision with root package name */
    public static Map<String, String> f12119g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private static String f12120h = "";

    /* renamed from: i  reason: collision with root package name */
    private static String f12121i = "";

    /* renamed from: j  reason: collision with root package name */
    private static int f12122j = -1;

    public static void a() {
        com.baidu.liantian.b.c();
    }

    public static String b(Context context) {
        try {
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        if (!TextUtils.isEmpty(f12120h)) {
            return f12120h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".liantian.ac.provider");
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(sb.toString(), 0);
        if (resolveContentProvider != null && !resolveContentProvider.multiprocess) {
            f12120h = resolveContentProvider.processName;
        }
        if (resolveContentProvider == null) {
            String b4 = b(context, sb.toString(), LiantianProvider.class.getCanonicalName());
            if (!TextUtils.isEmpty(b4)) {
                f12120h = b4;
            }
        }
        return f12120h;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            d(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                            file2.getAbsolutePath();
                            com.baidu.liantian.b.a();
                        }
                    }
                }
                file.delete();
                file.getAbsolutePath();
                com.baidu.liantian.b.a();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static String e(String str) {
        try {
            int length = str.length();
            int i4 = 0;
            while (i4 < length && (str.charAt(i4) <= ' ' || str.charAt(i4) == '\u00a0')) {
                i4++;
            }
            return i4 > 0 ? str.substring(i4) : str;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static String[] g(Context context) {
        String[] split;
        String[] split2;
        String str = f12114b;
        String str2 = f12115c;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.liantian.b.a();
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String b4 = new com.baidu.liantian.e(context).b();
            if (!TextUtils.isEmpty(b4) && (split = b4.split("-")) != null && split.length == 2) {
                com.baidu.liantian.b.a();
                return split;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String string = new com.baidu.liantian.e(context).f12228a.getString("svi", "");
            if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                com.baidu.liantian.b.a();
                return split2;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.liantian.b.a();
            str = f12116d;
            str2 = f12117e;
        }
        return new String[]{str, str2};
    }

    public static String[] h(Context context) {
        if (TextUtils.isEmpty(f12114b) || TextUtils.isEmpty(f12115c)) {
            String b4 = new com.baidu.liantian.e(context).b();
            if (TextUtils.isEmpty(b4)) {
                return null;
            }
            String[] split = b4.split("-");
            if (split == null || split.length != 2) {
                return new String[2];
            }
            f12114b = split[0];
            f12115c = split[1];
            return split;
        }
        return new String[]{f12114b, f12115c};
    }

    public static void i(Context context) {
        Map<String, Integer> g4;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String c4 = eVar.c();
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(c4) || (g4 = g(c4)) == null || g4.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            int i4 = 0;
            while (true) {
                String str = "";
                if (i4 < 15) {
                    Integer num = g4.get(Integer.toString(i4));
                    String num2 = Integer.toString(i4);
                    if (num != null) {
                        str = num.toString();
                    }
                    hashMap.put(num2, str);
                    i4++;
                } else {
                    a(context, "1003137", hashMap);
                    eVar.a("");
                    return;
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void j(Context context) {
        String str;
        String str2;
        byte[] encoded;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String e4 = eVar.e();
            long f4 = eVar.f();
            if (TextUtils.isEmpty(e4) && f4 == 0) {
                return;
            }
            String packageName = context.getPackageName();
            JSONArray jSONArray = new JSONArray(e4);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                str2 = packageInfo.applicationInfo.sourceDir;
                PublicKey a4 = a(packageInfo, str2);
                if (a4 == null || (encoded = a4.getEncoded()) == null) {
                    str = "";
                } else {
                    a(context, encoded);
                    str = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                    com.baidu.liantian.b.a();
                }
            } else {
                str = "";
                str2 = str;
            }
            boolean z3 = false;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                if (packageName.equals(optString) && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(optString2)) {
                    z3 = true;
                }
            }
            com.baidu.liantian.b.a();
            eVar.f12230c.putBoolean("hac", z3);
            eVar.f12230c.commit();
            if (z3) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("0", packageName);
            hashMap.put("1", str);
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (file.exists()) {
                    hashMap.put("2", o.a(file));
                } else {
                    hashMap.put("2", "");
                }
            } else {
                hashMap.put("2", "");
            }
            a(StubApp.getOrigApplicationContext(context.getApplicationContext()), "1003120", hashMap);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void k(Context context) {
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = eVar.f12228a.getLong("se_ae_fd", 0L);
        if (j4 == 0) {
            j4 = System.currentTimeMillis();
            eVar.k();
        }
        if (currentTimeMillis - j4 > 86400000) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.valueOf(eVar.n() + 1));
            eVar.c(0);
            eVar.k();
            a(context, "1003119", hashMap);
            return;
        }
        eVar.c(eVar.n() + 1);
    }

    public static String l(Context context) {
        String str;
        try {
            str = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        } catch (Throwable unused) {
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = g.e(context);
            }
            return Asc.fai(str, g(context)[0], context.getPackageName());
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    public static int m(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                if (activeNetworkInfo.getType() == 1) {
                    return 4;
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                            return 2;
                        case 4:
                            return 1;
                        case 5:
                        case 6:
                            return 2;
                        case 7:
                            return 1;
                        case 8:
                        case 9:
                        case 10:
                            return 2;
                        case 11:
                            return 1;
                        case 12:
                            return 2;
                        case 13:
                            return 3;
                        case 14:
                        case 15:
                            return 2;
                        default:
                            return 5;
                    }
                }
                return -2;
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00fe A[Catch: Exception -> 0x010c, TRY_ENTER, TryCatch #0 {Exception -> 0x010c, blocks: (B:3:0x000b, B:7:0x0014, B:10:0x001c, B:13:0x0026, B:16:0x002e, B:19:0x0038, B:22:0x0042, B:25:0x004c, B:28:0x0056, B:31:0x0069, B:34:0x0073, B:37:0x0086, B:39:0x00a3, B:41:0x00ab, B:44:0x00b4, B:52:0x00ca, B:55:0x00fe, B:56:0x0106, B:47:0x00be), top: B:60:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0106 A[Catch: Exception -> 0x010c, TRY_LEAVE, TryCatch #0 {Exception -> 0x010c, blocks: (B:3:0x000b, B:7:0x0014, B:10:0x001c, B:13:0x0026, B:16:0x002e, B:19:0x0038, B:22:0x0042, B:25:0x004c, B:28:0x0056, B:31:0x0069, B:34:0x0073, B:37:0x0086, B:39:0x00a3, B:41:0x00ab, B:44:0x00b4, B:52:0x00ca, B:55:0x00fe, B:56:0x0106, B:47:0x00be), top: B:60:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject n(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.n(android.content.Context):org.json.JSONObject");
    }

    public static int o(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e4) {
            e4.toString();
            com.baidu.liantian.b.a();
            com.baidu.liantian.b.c();
            networkInfo = null;
        }
        if (networkInfo == null) {
            com.baidu.liantian.b.a();
            return 0;
        } else if (1 == networkInfo.getType()) {
            return 2;
        } else {
            networkInfo.getType();
            return 1;
        }
    }

    public static void p(Context context) {
        try {
            String str = b() + "p/1/prt";
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            jSONObject.put("pk", packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);
            if (packageInfo != null) {
                PublicKey a4 = a(packageInfo, packageInfo.applicationInfo.sourceDir);
                if (a4 != null) {
                    byte[] encoded = a4.getEncoded();
                    if (encoded != null) {
                        a(context, encoded);
                        jSONObject.put("sm", o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", "")));
                        com.baidu.liantian.b.a();
                    }
                } else {
                    jSONObject.put("sm", "");
                }
            } else {
                jSONObject.put("sm", "");
            }
            String jSONObject2 = jSONObject.toString();
            com.baidu.liantian.b.a();
            String a5 = h.a(context, str, jSONObject2, false);
            com.baidu.liantian.b.a();
            if (a5 != null) {
                JSONObject jSONObject3 = new JSONObject(a5);
                JSONArray optJSONArray = jSONObject3.optJSONArray(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT);
                long optLong = jSONObject3.optLong("pt");
                if (optJSONArray != null && optLong > 0) {
                    new com.baidu.liantian.e(context).a(optJSONArray.toString(), optLong);
                }
                if (optLong > 0) {
                    j(context);
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void q(Context context) {
        try {
            f12119g.clear();
            String e4 = new com.baidu.liantian.e(context).e();
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(e4)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(e4);
            HashMap hashMap = new HashMap();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                com.baidu.liantian.b.a();
                hashMap.put(optString, optString2);
            }
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(64)) {
                String str = packageInfo.packageName;
                com.baidu.liantian.b.a();
                if (hashMap.keySet().contains(str) && !str.equals(context.getPackageName())) {
                    String str2 = (String) hashMap.get(str);
                    com.baidu.liantian.b.a();
                    String str3 = packageInfo.applicationInfo.sourceDir;
                    com.baidu.liantian.b.a();
                    PublicKey a4 = a(packageInfo, str3);
                    com.baidu.liantian.b.a();
                    if (a4 != null) {
                        byte[] encoded = a4.getEncoded();
                        com.baidu.liantian.b.a();
                        if (encoded != null) {
                            a(context, encoded);
                            String a5 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                            com.baidu.liantian.b.a();
                            if (!TextUtils.isEmpty(a5) && a5.equals(str2)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("pk", str);
                                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_AV_KEY, packageInfo.versionName);
                                jSONObject.put("sm", a5);
                                jSONObject.put("dm", Build.MODEL);
                                jSONObject.put(CampaignEx.JSON_KEY_AD_AL, String.valueOf(Build.VERSION.SDK_INT));
                                f12119g.put(str, jSONObject.toString());
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    private static String r(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "1.0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey a(android.content.pm.PackageInfo r2, java.lang.String r3) {
        /*
            android.content.pm.Signature[] r2 = r2.signatures
            if (r2 == 0) goto L16
            int r0 = r2.length
            if (r0 <= 0) goto L16
            r0 = 0
            r1 = r2[r0]
            if (r1 == 0) goto L16
            r2 = r2[r0]     // Catch: java.lang.Throwable -> L13
            java.security.PublicKey r2 = com.baidu.liantian.b.d.a(r2)     // Catch: java.lang.Throwable -> L13
            goto L17
        L13:
            com.baidu.liantian.b.c()
        L16:
            r2 = 0
        L17:
            if (r2 != 0) goto L1d
            java.security.PublicKey r2 = com.baidu.liantian.b.d.a(r3)
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.pm.PackageInfo, java.lang.String):java.security.PublicKey");
    }

    public static void c(Context context) {
        try {
            Report report = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.liantian.a.a a4 = com.baidu.liantian.a.a.a(context);
            Map<Integer, String> b4 = a4.b();
            jSONObject.put("0", b4.keySet());
            jSONObject.put("1", b4.values());
            jSONObject.toString();
            com.baidu.liantian.b.a();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> c4 = a4.c();
            JSONArray jSONArray = new JSONArray();
            for (String str : c4.values()) {
                jSONArray.put(str);
            }
            jSONArray.put("com.baidu.liantian");
            jSONArray.toString();
            com.baidu.liantian.b.a();
            jSONObject2.put("2", jSONArray);
            report.w(jSONObject2.toString());
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    public static void f(String str) {
        Map g4;
        try {
            Context context = com.baidu.liantian.core.d.f12174b;
            if (context == null) {
                return;
            }
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String c4 = eVar.c();
            if (TextUtils.isEmpty(c4)) {
                g4 = new HashMap();
                g4.put(str, 1);
            } else {
                g4 = g(c4);
                if (g4 != null && g4.size() > 0) {
                    if (g4.get(str) != null) {
                        g4.put(str, Integer.valueOf(((Integer) g4.get(str)).intValue() + 1));
                    } else {
                        g4.put(str, 1);
                    }
                }
            }
            if (g4 == null || g4.size() <= 0) {
                return;
            }
            eVar.a(new JSONObject(g4).toString());
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static String a(Class<?> cls) {
        try {
            if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                return Integer.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                return Boolean.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    private static String h(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String a4 = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return a4;
            } catch (Throwable unused2) {
                try {
                    com.baidu.liantian.b.c();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable unused5) {
            fileInputStream = null;
        }
    }

    private static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str + " " + str2 + "\n").waitFor();
            return true;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(f12121i)) {
                f12121i = a(Process.myPid());
            }
            return !str.equals(f12121i);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static void d(Context context) {
        com.baidu.liantian.b.a();
        if (TextUtils.isEmpty("3.1.6.7")) {
            return;
        }
        Report report = Report.getInstance(context);
        try {
            c(context);
            report.i("liantian", "com.baidu.liantian", "3.1.6.7", "1003003", "1003002");
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    private static String b(Context context, String str, String str2) {
        int next;
        String attributeValue;
        String str3;
        String canonicalName;
        try {
            String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str4)).intValue(), "AndroidManifest.xml");
            if (openXmlResourceParser != null) {
                do {
                    next = openXmlResourceParser.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next == 2 && openXmlResourceParser.getName().equals("manifest") && (attributeValue = openXmlResourceParser.getAttributeValue(null, "package")) != null && attributeValue.length() != 0) {
                    int length = attributeValue.length();
                    int i4 = 0;
                    boolean z3 = false;
                    boolean z4 = true;
                    while (true) {
                        if (i4 < length) {
                            char charAt = attributeValue.charAt(i4);
                            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                                z4 = false;
                            } else if (z4 || ((charAt < '0' || charAt > '9') && charAt != '_')) {
                                if (charAt != '.') {
                                    str3 = "bad character '" + charAt + "'";
                                    break;
                                }
                                z3 = true;
                                z4 = true;
                            }
                            i4++;
                        } else {
                            str3 = z3 ? null : "must have at least one '.' separator";
                        }
                    }
                    if (str3 != null && !"android".equals(attributeValue)) {
                        return null;
                    }
                    if (str2.equals("provider")) {
                        canonicalName = LiantianProvider.class.getCanonicalName();
                    } else if (str2.equals("service")) {
                        canonicalName = LiantianService.class.getCanonicalName();
                    } else {
                        canonicalName = str2.equals("receiver") ? LiantianReceiver.class.getCanonicalName() : null;
                    }
                    com.baidu.liantian.b.a();
                    while (true) {
                        int next2 = openXmlResourceParser.next();
                        if (next2 == 1) {
                            break;
                        } else if (next2 == 2) {
                            String name = openXmlResourceParser.getName();
                            if ("provider".equals(name)) {
                                if (openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name").equals(canonicalName)) {
                                    String attributeValue2 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "multiprocess");
                                    if (TextUtils.isEmpty(attributeValue2) || !"true".equals(attributeValue2.toLowerCase())) {
                                        String attributeValue3 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "authorities");
                                        if (TextUtils.isEmpty(attributeValue3) || !str.equals(attributeValue3)) {
                                            return null;
                                        }
                                        String attributeValue4 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                        if (!TextUtils.isEmpty(attributeValue4)) {
                                            if (attributeValue4.startsWith(":")) {
                                                return context.getPackageName() + attributeValue4;
                                            }
                                            return attributeValue4;
                                        }
                                        return context.getPackageName();
                                    }
                                    return null;
                                }
                            } else if ("service".equals(name)) {
                                String attributeValue5 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                if (!TextUtils.isEmpty(attributeValue5) && attributeValue5.equals(canonicalName)) {
                                    String attributeValue6 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                        if (attributeValue6.startsWith(":")) {
                                            return context.getPackageName() + attributeValue6;
                                        }
                                        return attributeValue6;
                                    }
                                    return context.getPackageName();
                                }
                            } else if ("receiver".equals(name)) {
                                String attributeValue7 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
                                if (!TextUtils.isEmpty(attributeValue7) && attributeValue7.equals(canonicalName)) {
                                    String attributeValue8 = openXmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "process");
                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                        if (attributeValue8.startsWith(":")) {
                                            return context.getPackageName() + attributeValue8;
                                        }
                                        return attributeValue8;
                                    }
                                    return context.getPackageName();
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        return null;
    }

    private static Map<String, Integer> g(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (Integer) jSONObject.get(next));
            }
            return hashMap;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            if (str.contains(Integer.class.getCanonicalName())) {
                return Integer.TYPE;
            }
            if (str.contains(Boolean.class.getCanonicalName())) {
                return Boolean.TYPE;
            }
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return null;
        }
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                for (int i4 = 0; i4 < split.length && i4 < split2.length; i4++) {
                    int intValue = Integer.valueOf(split[i4]).intValue() - Integer.valueOf(split2[i4]).intValue();
                    if (intValue != 0) {
                        return intValue > 0;
                    }
                }
                if (split.length > split2.length) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void d(Context context, String str) {
        String str2 = "";
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str3 = "";
                    while (optJSONObject.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        String optString = optJSONObject.optString(str3);
                        SharedPreferences.Editor editor = eVar.f12233f;
                        editor.putString("al_da" + str3, optString);
                        eVar.f12233f.commit();
                    }
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    while (optJSONObject2.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String optString2 = optJSONObject2.optString(str2);
                        SharedPreferences.Editor editor2 = eVar.f12233f;
                        editor2.putString("in_da" + str2, optString2);
                        eVar.f12233f.commit();
                    }
                }
            } catch (Throwable unused2) {
                com.baidu.liantian.b.c();
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    optJSONArray.toString();
                    com.baidu.liantian.b.a();
                    eVar.f12233f.putString("li_pk_s", optJSONArray.toString());
                    eVar.f12233f.commit();
                }
            } catch (Throwable unused3) {
                com.baidu.liantian.b.c();
            }
        } catch (Throwable unused4) {
            com.baidu.liantian.b.c();
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            System.currentTimeMillis();
            eVar.f12232e.getInt("re_net_ty", 2);
            JSONObject optJSONObject = jSONObject.optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt("5");
            int optInt2 = optJSONObject.optInt("6");
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt("11");
            String optString2 = optJSONObject.optString("12", "");
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.liantian.rp.c.a aVar = new com.baidu.liantian.rp.c.a();
            aVar.f12254d = str;
            aVar.f12252b = optString;
            aVar.f12257g = optInt;
            aVar.f12253c = 3;
            aVar.f12255e = optLong;
            aVar.f12256f = optInt2;
            aVar.f12258h = optInt3;
            aVar.f12259i = optInt4;
            aVar.f12260j = optString2;
            f a4 = f.a(context);
            Message message = new Message();
            message.what = 1;
            message.obj = aVar;
            a4.f12125a.a(message);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static void a(String str, String str2) {
        f12114b = str;
        f12115c = str2;
    }

    public static boolean a(Context context) {
        try {
            String b4 = b(context);
            if (TextUtils.isEmpty(f12121i)) {
                f12121i = a(Process.myPid());
            }
            if (TextUtils.isEmpty(b4)) {
                return context.getPackageName().equals(f12121i);
            }
            return b4.equals(f12121i);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return false;
        }
    }

    public static synchronized boolean a(Context context, boolean z3) {
        boolean a4;
        synchronized (e.class) {
            try {
                int i4 = f12122j;
                if (i4 != -1) {
                    return i4 == 1;
                }
                String b4 = b(context);
                if (TextUtils.isEmpty(b4)) {
                    a4 = a(context, context.getPackageName(), true, z3);
                } else {
                    a4 = a(context, b4, false, z3);
                }
                if (a4) {
                    f12122j = 1;
                } else {
                    f12122j = 0;
                }
                return a4;
            } catch (Throwable unused) {
                com.baidu.liantian.b.c();
                return false;
            }
        }
    }

    public static String c() {
        Calendar calendar = Calendar.getInstance();
        int i4 = calendar.get(1);
        int i5 = calendar.get(2);
        int i6 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append(i5);
        sb.append(i6);
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:2|3)|(3:50|51|(13:53|6|7|(2:9|(9:11|12|(2:14|(1:16))(6:(2:43|(1:45))|18|(1:20)|(4:27|(1:(1:35)(1:(1:37)))(1:30)|(1:32)|33)|38|39)|17|18|(0)|(6:22|27|(0)|(0)(0)|(0)|33)|38|39))|48|12|(0)(0)|17|18|(0)|(0)|38|39))|5|6|7|(0)|48|12|(0)(0)|17|18|(0)|(0)|38|39) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
        com.baidu.liantian.b.c();
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:10:0x0032, B:12:0x0053), top: B:53:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[Catch: all -> 0x007e, TRY_ENTER, TryCatch #3 {all -> 0x007e, blocks: (B:17:0x0060, B:21:0x0070), top: B:56:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = r9.getPackageName()     // Catch: java.lang.Throwable -> L30
            java.lang.Class<com.baidu.liantian.LiantianService> r6 = com.baidu.liantian.LiantianService.class
            java.lang.String r6 = r6.getCanonicalName()     // Catch: java.lang.Throwable -> L30
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> L30
            r3.setComponent(r4)     // Catch: java.lang.Throwable -> L30
            android.content.pm.PackageManager r4 = r9.getPackageManager()     // Catch: java.lang.Throwable -> L30
            android.content.pm.ResolveInfo r3 = r4.resolveService(r3, r2)     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L31
            android.content.pm.ServiceInfo r4 = r3.serviceInfo     // Catch: java.lang.Throwable -> L31
            java.lang.String r4 = r4.processName     // Catch: java.lang.Throwable -> L31
            boolean r4 = r10.equals(r4)     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L31
            r4 = 1
            goto L32
        L30:
            r3 = r0
        L31:
            r4 = 0
        L32:
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Throwable -> L5d
            r5.<init>()     // Catch: java.lang.Throwable -> L5d
            android.content.ComponentName r6 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L5d
            java.lang.String r7 = r9.getPackageName()     // Catch: java.lang.Throwable -> L5d
            java.lang.Class<com.baidu.liantian.LiantianReceiver> r8 = com.baidu.liantian.LiantianReceiver.class
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Throwable -> L5d
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L5d
            r5.setComponent(r6)     // Catch: java.lang.Throwable -> L5d
            android.content.pm.PackageManager r5 = r9.getPackageManager()     // Catch: java.lang.Throwable -> L5d
            android.content.pm.ActivityInfo r0 = r5.getReceiverInfo(r6, r2)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L5d
            java.lang.String r5 = r0.processName     // Catch: java.lang.Throwable -> L5d
            boolean r5 = r10.equals(r5)     // Catch: java.lang.Throwable -> L5d
            if (r5 == 0) goto L5d
            r5 = 1
            goto L5e
        L5d:
            r5 = 0
        L5e:
            if (r3 != 0) goto L6e
            java.lang.String r0 = "service"
            java.lang.String r0 = b(r9, r10, r0)     // Catch: java.lang.Throwable -> L7e
            boolean r0 = r10.equals(r0)     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L81
            r4 = 1
            goto L81
        L6e:
            if (r0 != 0) goto L81
            java.lang.String r0 = "receiver"
            java.lang.String r0 = b(r9, r10, r0)     // Catch: java.lang.Throwable -> L7e
            boolean r0 = r10.equals(r0)     // Catch: java.lang.Throwable -> L7e
            if (r0 == 0) goto L81
            r5 = 1
            goto L81
        L7e:
            com.baidu.liantian.b.c()
        L81:
            java.lang.String r0 = com.baidu.liantian.b.e.f12121i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L93
            int r0 = android.os.Process.myPid()
            java.lang.String r0 = a(r0)
            com.baidu.liantian.b.e.f12121i = r0
        L93:
            if (r12 == 0) goto Ld6
            java.lang.String r12 = com.baidu.liantian.b.e.f12121i
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto Ld6
            if (r5 == 0) goto La3
            if (r4 == 0) goto La3
            if (r11 == 0) goto Ld6
        La3:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.String r12 = "0"
            if (r5 != 0) goto Lb7
            if (r4 != 0) goto Lb7
            r0 = 2
            java.lang.String r0 = java.lang.Integer.toString(r0)
            r10.put(r12, r0)
            goto Lca
        Lb7:
            if (r4 != 0) goto Lc1
            java.lang.String r0 = java.lang.Integer.toString(r1)
            r10.put(r12, r0)
            goto Lca
        Lc1:
            if (r5 != 0) goto Lca
            java.lang.String r0 = java.lang.Integer.toString(r2)
            r10.put(r12, r0)
        Lca:
            if (r11 == 0) goto Ld1
            java.lang.String r11 = "1"
            r10.put(r11, r12)
        Ld1:
            java.lang.String r11 = "1003140"
            a(r9, r11, r10)
        Ld6:
            r9 = r5 & r4
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.Context, java.lang.String, boolean, boolean):boolean");
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(new File(str), new File(str2));
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode(n.f12147a, 0), "30212102dicudiab".getBytes()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null || !a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        file.getAbsolutePath();
                        file2.getAbsolutePath();
                        com.baidu.liantian.b.a();
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            e4.getMessage();
                            com.baidu.liantian.b.b();
                        }
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        try {
                            com.baidu.liantian.b.c();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e5) {
                                    e5.getMessage();
                                    com.baidu.liantian.b.b();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e6) {
                                    e6.getMessage();
                                    com.baidu.liantian.b.b();
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    e7.getMessage();
                                    com.baidu.liantian.b.b();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable unused2) {
                    fileOutputStream = null;
                }
            } catch (Throwable unused3) {
                fileOutputStream = null;
            }
        } catch (IOException e8) {
            e8.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    public static String b(Context context, String str) {
        String str2;
        try {
            str2 = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
        } catch (Throwable unused) {
            str2 = "";
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = g.e(context);
            }
            return Asc.fai(str2, str, context.getPackageName());
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
            return "";
        }
    }

    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            if (clsArr != null && objArr != null && clsArr.length != objArr.length) {
                com.baidu.liantian.b.a();
                throw new NoSuchMethodException("paramTypes or args fail");
            }
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            Method method = null;
            int length = declaredMethods.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                Method method2 = declaredMethods[i4];
                if (a(method2, str, clsArr)) {
                    method = method2;
                    break;
                }
                i4++;
            }
            if (method != null) {
                return method.invoke(obj, objArr);
            }
            com.baidu.liantian.b.a();
            throw new NoSuchMethodException("cannot find method in target methodName=" + str);
        }
        com.baidu.liantian.b.a();
        throw new NoSuchMethodException("object=" + obj + ", methodName=" + str);
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        if (str.equals(method.getName())) {
            com.baidu.liantian.b.a();
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((parameterTypes != null && parameterTypes.length != 0) || (clsArr != null && clsArr.length != 0)) {
                if ((clsArr == null || clsArr.length == 0) && parameterTypes != null && parameterTypes.length > 0) {
                    com.baidu.liantian.b.a();
                    return false;
                } else if ((parameterTypes == null || parameterTypes.length == 0) && clsArr != null && clsArr.length > 0) {
                    com.baidu.liantian.b.a();
                    return false;
                } else if (parameterTypes.length != clsArr.length) {
                    com.baidu.liantian.b.a();
                    return false;
                } else {
                    for (int i4 = 0; i4 < parameterTypes.length; i4++) {
                        if (parameterTypes[i4] != clsArr[i4]) {
                            com.baidu.liantian.b.a();
                            return false;
                        }
                    }
                    com.baidu.liantian.b.a();
                    return true;
                }
            }
            com.baidu.liantian.b.a();
            return true;
        }
        return false;
    }

    public static void a(String str, boolean z3) {
        d("771", str);
        com.baidu.liantian.b.a();
        if (z3) {
            d("771", new File(str).getParentFile().getAbsolutePath());
            com.baidu.liantian.b.a();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        String str2;
        if (TextUtils.isEmpty(str) || !com.baidu.liantian.core.d.f12175c) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] g4 = g(context);
            if (g4 != null && g4.length == 2 && !TextUtils.isEmpty(g4[0]) && !TextUtils.isEmpty(g4[1])) {
                str2 = g4[0];
            } else {
                str2 = f12116d;
            }
            jSONObject2.put("3", str2);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "liantian");
            jSONObject2.put("9", "3.1.6.7");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String jSONObject3 = jSONObject.toString();
            com.baidu.liantian.b.a();
            report.s(jSONObject3);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3 = "";
        try {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                properties.load(inputStream);
                str3 = properties.getProperty(str2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                        e.getMessage();
                        com.baidu.liantian.b.b();
                        return str3;
                    }
                }
            } catch (IOException e5) {
                e5.getMessage();
                com.baidu.liantian.b.b();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e = e6;
                        e.getMessage();
                        com.baidu.liantian.b.b();
                        return str3;
                    }
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        return str3;
    }

    public static boolean a(Context context, int i4) {
        if (i4 != 1 || e(context)) {
            return true;
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (f12118f == null) {
            f12118f = new LiantianReceiver().a();
        }
        StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(f12118f, intentFilter);
        f12113a = true;
        return false;
    }

    public static boolean a(Context context, String str) {
        PublicKey a4;
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String e4 = eVar.e();
            long f4 = eVar.f();
            if (TextUtils.isEmpty(e4) && f4 == 0) {
                return false;
            }
            JSONArray jSONArray = new JSONArray(e4);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (a4 = a(packageInfo, packageInfo.applicationInfo.sourceDir)) == null) {
                return true;
            }
            byte[] encoded = a4.getEncoded();
            String str2 = "";
            if (encoded != null) {
                a(context, encoded);
                str2 = o.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                com.baidu.liantian.b.a();
            }
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                String optString = optJSONObject.optString("p");
                String optString2 = optJSONObject.optString("s");
                if (str.equals(optString) && !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(optString2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
            return true;
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] g4 = g(context);
            if (g4 == null || g4.length != 2) {
                return;
            }
            if (TextUtils.isEmpty(g4[0]) || TextUtils.isEmpty(g4[1]) || !"200080".equals(g4[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                return;
            }
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr[i4] = (byte) (bArr[i4] ^ 246);
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.liantian.rp.a.a aVar, String str, boolean z3) {
        return a(context, aVar.f12240a, aVar.f12242c, z3 ? aVar.f12243d : aVar.f12244e, str);
    }

    private static String a(int i4) {
        String str;
        try {
            str = h(String.format("/proc/%d/cmdline", Integer.valueOf(i4)));
        } catch (Exception unused) {
            str = null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
        } catch (Exception unused2) {
            com.baidu.liantian.b.c();
            return str;
        }
        return str;
    }

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append('\n');
                }
                sb.append(readLine);
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c3 A[Catch: all -> 0x0153, TRY_ENTER, TryCatch #1 {all -> 0x0153, blocks: (B:7:0x003d, B:9:0x0043, B:13:0x0056, B:17:0x00b7, B:20:0x00c3, B:22:0x00cb, B:30:0x010b, B:33:0x0142, B:34:0x0146, B:21:0x00c7, B:12:0x0052), top: B:41:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c7 A[Catch: all -> 0x0153, TryCatch #1 {all -> 0x0153, blocks: (B:7:0x003d, B:9:0x0043, B:13:0x0056, B:17:0x00b7, B:20:0x00c3, B:22:0x00cb, B:30:0x010b, B:33:0x0142, B:34:0x0146, B:21:0x00c7, B:12:0x0052), top: B:41:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0142 A[Catch: all -> 0x0153, TRY_ENTER, TryCatch #1 {all -> 0x0153, blocks: (B:7:0x003d, B:9:0x0043, B:13:0x0056, B:17:0x00b7, B:20:0x00c3, B:22:0x00cb, B:30:0x010b, B:33:0x0142, B:34:0x0146, B:21:0x00c7, B:12:0x0052), top: B:41:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0146 A[Catch: all -> 0x0153, TRY_LEAVE, TryCatch #1 {all -> 0x0153, blocks: (B:7:0x003d, B:9:0x0043, B:13:0x0056, B:17:0x00b7, B:20:0x00c3, B:22:0x00cb, B:30:0x010b, B:33:0x0142, B:34:0x0146, B:21:0x00c7, B:12:0x0052), top: B:41:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r17, org.json.JSONObject r18) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.e.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        com.baidu.liantian.rp.a.a aVar;
        f.a(context).a();
        f a4 = f.a(context);
        Message message = new Message();
        message.what = 8;
        a4.f12125a.a(message);
        com.baidu.liantian.rp.a.a aVar2 = new com.baidu.liantian.rp.a.a();
        aVar2.f12240a = str;
        aVar2.f12241b = str2;
        aVar2.f12242c = str3;
        aVar2.f12243d = str4;
        aVar2.f12244e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
        List<com.baidu.liantian.rp.a.a> w3 = eVar.w();
        if (w3 == null) {
            eVar.a(aVar2);
        } else if (!w3.contains(aVar2)) {
            eVar.a(aVar2);
        } else {
            int indexOf = w3.indexOf(aVar2);
            if (indexOf != -1 && (aVar = w3.get(indexOf)) != null) {
                eVar.f12233f.putString("re_con", eVar.f12232e.getString("re_con", "").replace(com.baidu.liantian.rp.a.a.a(aVar), com.baidu.liantian.rp.a.a.a(aVar2)));
                eVar.f12233f.commit();
            }
            f.a(context).b();
            return;
        }
        String str6 = aVar2.f12244e;
        SharedPreferences sharedPreferences = eVar.f12232e;
        if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
            f a5 = f.a(context);
            Message message2 = new Message();
            message2.what = 3;
            message2.obj = aVar2;
            a5.f12125a.a(message2);
        }
        f.a(context).b();
        f.a(context).c();
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] g4 = g(context);
            if (g4 != null && g4.length == 2) {
                jSONObject2.put("3", g4[0]);
            } else {
                jSONObject2.put("3", f12116d);
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject3 = new JSONObject(str4);
                } catch (Exception unused) {
                    com.baidu.liantian.b.c();
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
        return jSONObject;
    }

    public static void a(Context context, long j4) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j4, broadcast);
        } catch (Throwable unused2) {
            com.baidu.liantian.b.c();
        }
    }

    public static String a(byte[] bArr) {
        String str = "";
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static void a(Context context, Intent intent) {
        try {
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false) && f12119g.containsKey(schemeSpecificPart)) {
                f12119g.remove(schemeSpecificPart);
                new U(context, 4, false).start();
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.c();
        }
    }
}
