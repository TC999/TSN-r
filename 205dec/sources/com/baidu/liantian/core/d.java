package com.baidu.liantian.core;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.LiantianReceiver;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.ac.U;
import com.baidu.liantian.rp.Report;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ForHostApp.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static Context f12174b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f12175c;

    /* renamed from: e  reason: collision with root package name */
    public static List<Integer> f12176e = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private static d f12177g;

    /* renamed from: h  reason: collision with root package name */
    private static int f12178h;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.liantian.e f12179a;

    /* renamed from: d  reason: collision with root package name */
    com.baidu.liantian.a.a f12180d;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f12181f = false;

    private d(Context context) {
        com.baidu.liantian.b.a();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        f12174b = origApplicationContext;
        this.f12180d = com.baidu.liantian.a.a.a(origApplicationContext);
        this.f12179a = new com.baidu.liantian.e(f12174b);
    }

    public static d a() {
        return f12177g;
    }

    public final void b() {
        boolean z3;
        try {
            List<ApkInfo> a4 = this.f12180d.a();
            f4.a(a4);
            com.baidu.liantian.b.a();
            final List<Integer> q3 = this.f12179a.q();
            List<Integer> p3 = this.f12179a.p();
            for (int i4 = 0; i4 < p3.size(); i4++) {
                if (!q3.contains(p3.get(i4))) {
                    q3.add(p3.get(i4));
                }
            }
            Collections.sort(a4, new Comparator<ApkInfo>() { // from class: com.baidu.liantian.core.d.2
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(ApkInfo apkInfo, ApkInfo apkInfo2) {
                    int i5;
                    ApkInfo apkInfo3 = apkInfo;
                    ApkInfo apkInfo4 = apkInfo2;
                    int i6 = apkInfo3.priority;
                    if (i6 != -1 || apkInfo4.priority == -1) {
                        if ((i6 == -1 || apkInfo4.priority != -1) && i6 >= (i5 = apkInfo4.priority)) {
                            if (i6 > i5) {
                                return 1;
                            }
                            List list = q3;
                            int indexOf = (list == null || !list.contains(Integer.valueOf(apkInfo3.key))) ? -1 : q3.indexOf(Integer.valueOf(apkInfo3.key));
                            List list2 = q3;
                            int indexOf2 = (list2 == null || !list2.contains(Integer.valueOf(apkInfo4.key))) ? -1 : q3.indexOf(Integer.valueOf(apkInfo4.key));
                            if (indexOf == -1 || indexOf2 != -1) {
                                if ((indexOf != -1 || indexOf2 == -1) && indexOf <= indexOf2) {
                                    return indexOf < indexOf2 ? -1 : 0;
                                }
                                return 1;
                            }
                            return -1;
                        }
                        return -1;
                    }
                    return 1;
                }
            });
            for (ApkInfo apkInfo : a4) {
                g a5 = g.a();
                if ((a5 != null ? a5.d(apkInfo.packageName) : null) == null) {
                    if (this.f12180d.g(apkInfo.key) == 3) {
                        com.baidu.liantian.b.a();
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (this.f12179a.d() && z3) {
                        File file = new File(f12174b.getFilesDir(), ".b_liantian");
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(apkInfo.pkgPath);
                        File file3 = new File(file, apkInfo.key + "-" + apkInfo.versionName);
                        if (!com.baidu.liantian.b.e.a(file3)) {
                            com.baidu.liantian.b.e.a(file2, file3);
                        }
                        com.baidu.liantian.c.a(f12174b, apkInfo.key, file2, file3);
                    } else {
                        File file4 = new File(f12174b.getFilesDir(), ".b_liantian");
                        if (file4.exists()) {
                            File file5 = new File(file4, apkInfo.key + "-" + apkInfo.versionName);
                            if (com.baidu.liantian.b.e.a(file5)) {
                                com.baidu.liantian.c.a(file5);
                                file5.delete();
                                file5.getAbsolutePath();
                                com.baidu.liantian.b.a();
                            }
                        }
                    }
                    a(apkInfo.key, apkInfo.versionName, null);
                }
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final boolean c() {
        this.f12180d.d();
        this.f12181f = true;
        return c(f12174b);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f12177g == null) {
                f12177g = new d(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            dVar = f12177g;
        }
        return dVar;
    }

    private boolean c(Context context) {
        try {
            g a4 = g.a(context);
            if (a4 == null) {
                return false;
            }
            if (a4.d("com.baidu.liantian.x18") != null) {
                return true;
            }
            if (this.f12180d == null) {
                this.f12180d = com.baidu.liantian.a.a.a(f12174b);
            }
            ApkInfo c4 = this.f12180d.c("com.baidu.liantian.x18");
            f4.a(c4);
            com.baidu.liantian.b.a();
            if (c4 != null) {
                if (this.f12179a.d()) {
                    File file = new File(f12174b.getFilesDir(), ".b_liantian");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File file2 = new File(c4.pkgPath);
                    File file3 = new File(file, c4.key + "-" + c4.versionName);
                    if (!com.baidu.liantian.b.e.a(file3)) {
                        com.baidu.liantian.b.e.a(file2, file3);
                    }
                    com.baidu.liantian.c.a(f12174b, c4.key, file2, file3);
                }
                if (a(c4.key, c4.versionName, null)) {
                    return true;
                }
            }
            return a4.d("com.baidu.liantian.x18") != null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    public final synchronized void a(final Callback callback) {
        try {
            com.baidu.liantian.b.e.d(f12174b);
            com.baidu.liantian.b.a();
            if (this.f12181f) {
                if (callback != null) {
                    callback.onEnd(new Object[0]);
                }
                return;
            }
            this.f12181f = true;
            com.baidu.liantian.e eVar = this.f12179a;
            eVar.f12230c.putString("ssv", "3.1.6.7");
            eVar.f12230c.commit();
            Report.getInstance(f12174b).n();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            f12174b.registerReceiver(new LiantianReceiver(), intentFilter);
            com.baidu.liantian.b.b.a(f12174b);
            for (ApkInfo apkInfo : this.f12180d.a()) {
                String str = null;
                try {
                    str = f12174b.getFilesDir().getCanonicalPath();
                } catch (IOException unused) {
                    com.baidu.liantian.b.e.a();
                }
                if (str != null) {
                    apkInfo.dataDir = str + "/.liantian_" + apkInfo.key;
                    StringBuilder sb = new StringBuilder();
                    sb.append(apkInfo.dataDir);
                    sb.append("/lib");
                    com.baidu.liantian.b.e.d(sb.toString());
                }
            }
            new Thread() { // from class: com.baidu.liantian.core.d.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    try {
                        super.run();
                        d.this.f12180d.d();
                        com.baidu.liantian.b.a();
                        d.this.f12179a.a();
                        com.baidu.liantian.b.a();
                        if (!d.this.f12179a.a()) {
                            com.baidu.liantian.e eVar2 = d.this.f12179a;
                            eVar2.f12230c.putBoolean("iio", true);
                            eVar2.f12230c.commit();
                        } else {
                            com.baidu.liantian.a.a aVar = d.this.f12180d;
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("n", (Integer) 0);
                            aVar.f12105c.update("tbchliantian", contentValues, "n=-1", null);
                        }
                        new U(d.f12174b, 1, false).start();
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onEnd(new Object[0]);
                        }
                    } catch (Throwable unused2) {
                        com.baidu.liantian.b.e.a();
                    }
                }
            }.start();
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r9, java.lang.String r10, java.lang.String r11, android.content.pm.PackageInfo r12) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.d.a(int, java.lang.String, java.lang.String, android.content.pm.PackageInfo):void");
    }

    public final void b(Context context) {
        String str;
        JSONArray jSONArray;
        PackageInfo packageInfo;
        ApkInfo apkInfo;
        String str2 = "n";
        try {
            if (this.f12179a.f12228a.getBoolean("lpcf", false)) {
                return;
            }
            JSONArray jSONArray2 = new JSONArray(com.baidu.liantian.b.e.a(context, "liantian_local.cfg", "local"));
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i4);
                String optString = optJSONObject.optString("pkgname");
                String optString2 = optJSONObject.optString("version");
                int optInt = optJSONObject.optInt("id");
                if (optInt > 0) {
                    arrayList.add(Integer.valueOf(optInt));
                }
                String optString3 = optJSONObject.optString("md5");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && optInt > 0) {
                    String lowerCase = optString3.toLowerCase();
                    ApkInfo apkInfo2 = new ApkInfo();
                    apkInfo2.packageName = optString;
                    apkInfo2.versionName = optString2;
                    apkInfo2.key = optInt;
                    apkInfo2.apkMD5 = lowerCase;
                    hashMap.put(Integer.valueOf(optInt), apkInfo2);
                }
            }
            this.f12179a.a(arrayList);
            if (hashMap.size() <= 0) {
                this.f12179a.s();
                return;
            }
            String str3 = com.baidu.liantian.b.e.b() + "p/1/pio";
            JSONArray jSONArray3 = new JSONArray();
            for (ApkInfo apkInfo3 : hashMap.values()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pk", apkInfo3.packageName);
                jSONObject.put("m", apkInfo3.apkMD5);
                jSONObject.put("l", apkInfo3.key);
                jSONObject.put("v", apkInfo3.versionName);
                jSONArray3.put(jSONObject);
            }
            String jSONArray4 = jSONArray3.toString();
            com.baidu.liantian.b.a();
            String a4 = com.baidu.liantian.b.h.a(context, str3, jSONArray4);
            com.baidu.liantian.b.a();
            JSONArray jSONArray5 = new JSONArray(a4);
            if (jSONArray5.length() > 0) {
                this.f12179a.s();
            }
            int i5 = 0;
            while (i5 < jSONArray5.length()) {
                JSONObject optJSONObject2 = jSONArray5.optJSONObject(i5);
                int optInt2 = optJSONObject2.optInt("errno");
                int optInt3 = optJSONObject2.optInt("l");
                if (optInt2 == 1) {
                    try {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("detail");
                        packageInfo = new PackageInfo();
                        packageInfo.packageName = optJSONObject3.optString("p");
                        packageInfo.versionName = optJSONObject3.optString("v");
                        ApplicationInfo applicationInfo = new ApplicationInfo();
                        String optString4 = optJSONObject3.optString(str2);
                        applicationInfo.className = optString4;
                        if (!TextUtils.isEmpty(optString4) && applicationInfo.className.startsWith(".")) {
                            applicationInfo.className = packageInfo.packageName + applicationInfo.className;
                        }
                        applicationInfo.theme = optJSONObject3.optInt("t");
                        packageInfo.applicationInfo = applicationInfo;
                        JSONArray optJSONArray = optJSONObject3.optJSONArray("a");
                        if (optJSONArray == null || optJSONArray.length() <= 0) {
                            str = str2;
                            jSONArray = jSONArray5;
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            int i6 = 0;
                            while (i6 < optJSONArray.length()) {
                                try {
                                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                                    if (jSONObject2 != null) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        jSONArray = jSONArray5;
                                        try {
                                            String optString5 = jSONObject2.optString(str2);
                                            activityInfo.name = optString5;
                                            if (TextUtils.isEmpty(optString5) || !activityInfo.name.startsWith(".")) {
                                                str = str2;
                                            } else {
                                                StringBuilder sb = new StringBuilder();
                                                str = str2;
                                                try {
                                                    sb.append(packageInfo.packageName);
                                                    sb.append(activityInfo.name);
                                                    activityInfo.name = sb.toString();
                                                } catch (Throwable unused) {
                                                    try {
                                                        com.baidu.liantian.b.e.a();
                                                        continue;
                                                        i6++;
                                                        jSONArray5 = jSONArray;
                                                        str2 = str;
                                                    } catch (Throwable unused2) {
                                                        packageInfo = null;
                                                        com.baidu.liantian.b.e.a();
                                                        apkInfo = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                                                        if (apkInfo != null) {
                                                            a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                                                        }
                                                        i5++;
                                                        jSONArray5 = jSONArray;
                                                        str2 = str;
                                                    }
                                                }
                                            }
                                            activityInfo.packageName = packageInfo.packageName;
                                            activityInfo.theme = jSONObject2.optInt("t");
                                            activityInfo.labelRes = jSONObject2.optInt("l");
                                            if (TextUtils.isEmpty(activityInfo.name)) {
                                                continue;
                                            } else {
                                                arrayList2.add(activityInfo);
                                                continue;
                                            }
                                        } catch (Throwable unused3) {
                                            str = str2;
                                        }
                                    } else {
                                        str = str2;
                                        jSONArray = jSONArray5;
                                        continue;
                                    }
                                } catch (Throwable unused4) {
                                    str = str2;
                                    jSONArray = jSONArray5;
                                }
                                i6++;
                                jSONArray5 = jSONArray;
                                str2 = str;
                            }
                            str = str2;
                            jSONArray = jSONArray5;
                            if (arrayList2.size() > 0) {
                                packageInfo.activities = (ActivityInfo[]) arrayList2.toArray(new ActivityInfo[arrayList2.size()]);
                            }
                        }
                    } catch (Throwable unused5) {
                        str = str2;
                        jSONArray = jSONArray5;
                    }
                    apkInfo = (ApkInfo) hashMap.get(Integer.valueOf(optInt3));
                    if (apkInfo != null && packageInfo != null && !TextUtils.isEmpty(packageInfo.packageName)) {
                        a(apkInfo.key, apkInfo.versionName, apkInfo.apkMD5, packageInfo);
                    }
                } else {
                    str = str2;
                    jSONArray = jSONArray5;
                }
                i5++;
                jSONArray5 = jSONArray;
                str2 = str;
            }
        } catch (Throwable unused6) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final synchronized boolean a(int i4, String str, PackageInfo packageInfo) {
        return a(i4, str, false, packageInfo);
    }

    private synchronized boolean a(int i4, String str, boolean z3, PackageInfo packageInfo) {
        String str2;
        String str3;
        try {
            com.baidu.liantian.b.a();
            if (!z3 || this.f12180d.c(i4) == 1) {
                ApkInfo a4 = this.f12180d.a(i4);
                if (a4 == null) {
                    com.baidu.liantian.b.a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", 1);
                    hashMap.put("1", String.valueOf(i4));
                    hashMap.put("2", str);
                    if (!z3) {
                        com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap);
                    }
                    return false;
                }
                File file = new File(a4.pkgPath);
                file.getAbsolutePath();
                com.baidu.liantian.b.a();
                if (!com.baidu.liantian.b.e.a(file)) {
                    com.baidu.liantian.b.a();
                    this.f12180d.f(i4);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("0", 3);
                    hashMap2.put("1", String.valueOf(i4));
                    hashMap2.put("2", str);
                    if (!z3) {
                        com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap2);
                    }
                    return false;
                }
                if (packageInfo != null) {
                    a4.cloudPkgInfo = packageInfo;
                }
                g a5 = g.a(StubApp.getOrigApplicationContext(f12174b.getApplicationContext()));
                com.baidu.liantian.b.a();
                if (!a5.a(a4, false)) {
                    this.f12180d.f(i4);
                    a5.a(a4.pkgPath);
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("0", 4);
                    hashMap3.put("1", String.valueOf(i4));
                    hashMap3.put("2", str);
                    if (!z3) {
                        com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap3);
                    }
                    com.baidu.liantian.b.a();
                    return false;
                }
                com.baidu.liantian.b.a();
                String[] g4 = com.baidu.liantian.b.e.g(f12174b);
                if (g4 != null && g4.length == 2 && !TextUtils.isEmpty(g4[0]) && !TextUtils.isEmpty(g4[1])) {
                    str2 = g4[0];
                    str3 = g4[1];
                } else {
                    str2 = com.baidu.liantian.b.e.f12116d;
                    str3 = com.baidu.liantian.b.e.f12117e;
                }
                com.baidu.liantian.b.a();
                ApkInfo c4 = a5.c(a4.pkgPath);
                f fVar = (f) c4.classLoader;
                Class<?> a6 = fVar.a("com.baidu.liantian.engine.EngineImpl");
                if (a6 == null) {
                    com.baidu.liantian.b.a();
                    Class<?> a7 = fVar.a("java.lang.String");
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("0", 9);
                    hashMap4.put("1", String.valueOf(i4));
                    hashMap4.put("2", str);
                    hashMap4.put("3", Base64.encodeToString(("classloader=" + fVar + ",StringClass=" + a7).getBytes(), 0).replace("\n", "").replace("\t", "").replace("\r", ""));
                    if (!z3) {
                        com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap4);
                    }
                    this.f12180d.f(i4);
                    return false;
                }
                Object invoke = a6.getDeclaredMethod("getInstance", Context.class).invoke(a6, f12174b);
                f4.a(invoke);
                com.baidu.liantian.b.a();
                com.baidu.liantian.b.e.a(invoke, "setSecurityVerifyInfo", new Class[]{String.class, String.class}, str2, str3);
                if (!((Boolean) com.baidu.liantian.b.e.a(invoke, "init", new Class[]{Integer.TYPE, Boolean.TYPE}, 0, Boolean.valueOf(this.f12179a.o()))).booleanValue()) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("0", 6);
                    hashMap5.put("1", String.valueOf(i4));
                    hashMap5.put("2", str);
                    if (!z3) {
                        com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap5);
                    }
                    this.f12180d.f(i4);
                    a5.a(c4.pkgPath);
                    com.baidu.liantian.b.a();
                    return false;
                }
                c4.initStatus = 1;
                c4.apkParseSuc = 1;
                this.f12180d.a(c4);
                com.baidu.liantian.b.a();
                int g5 = this.f12180d.g(c4.key);
                com.baidu.liantian.b.a();
                if (g5 < 3 && g5 != -1) {
                    this.f12180d.b(c4.key, g5 + 1);
                }
                HashMap hashMap6 = new HashMap();
                hashMap6.put("0", 0);
                hashMap6.put("1", Integer.valueOf(i4));
                hashMap6.put("2", str);
                if (!z3) {
                    com.baidu.liantian.b.e.a(f12174b, "1003105", hashMap6);
                }
                com.baidu.liantian.b.e.c(f12174b);
                return true;
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    private static void b(String str) {
        g a4;
        ApkInfo d4;
        com.baidu.liantian.b.a();
        try {
            if (TextUtils.isEmpty(str) || (a4 = g.a()) == null || (d4 = a4.d(str)) == null) {
                return;
            }
            Class<?> a5 = ((f) d4.classLoader).a("com.baidu.liantian.engine.EngineImpl");
            Object invoke = a5.getDeclaredMethod("getInstance", Context.class).invoke(a5, f12174b);
            if (invoke == null) {
                return;
            }
            f4.a(com.baidu.liantian.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
            com.baidu.liantian.b.a();
            a4.b(str);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x038d: MOVE  (r9 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:104:0x0388 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195 A[Catch: all -> 0x0376, TryCatch #12 {all -> 0x0376, blocks: (B:24:0x012a, B:31:0x0156, B:33:0x0162, B:35:0x016a, B:37:0x0173, B:39:0x017c, B:42:0x018b, B:46:0x0195, B:48:0x01a1, B:41:0x0187), top: B:136:0x0105 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0276 A[Catch: all -> 0x0368, TRY_LEAVE, TryCatch #6 {all -> 0x0368, blocks: (B:61:0x024a, B:63:0x0276, B:60:0x0247), top: B:124:0x0247 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c1 A[Catch: all -> 0x0366, TryCatch #3 {all -> 0x0366, blocks: (B:65:0x02a1, B:67:0x02c1, B:69:0x02c7, B:71:0x02d6), top: B:120:0x0274 }] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.baidu.liantian.core.ApkInfo r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.d.a(com.baidu.liantian.core.ApkInfo, java.lang.String):boolean");
    }

    public final void a(final int i4, final String str, final Callback callback, final Class<?>[] clsArr, final Object... objArr) {
        try {
            com.baidu.liantian.b.a();
            HashMap hashMap = new HashMap();
            hashMap.put("0", Integer.toString(i4));
            hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
            hashMap.put("2", "0");
            com.baidu.liantian.b.e.a(f12174b, "1003136", hashMap);
            if (!TextUtils.isEmpty(str)) {
                new Thread() { // from class: com.baidu.liantian.core.d.3
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        boolean z3;
                        super.run();
                        try {
                            Callback callback2 = callback;
                            if (callback2 != null) {
                                callback2.onBegin(new Object[0]);
                            }
                            boolean d4 = d.this.f12180d.d(i4);
                            com.baidu.liantian.b.a();
                            if (d4) {
                                long currentTimeMillis = System.currentTimeMillis();
                                while (d.this.f12180d.d(i4) && System.currentTimeMillis() - currentTimeMillis < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                                    com.baidu.liantian.b.a();
                                    SystemClock.sleep(300L);
                                }
                            }
                            com.baidu.liantian.b.a();
                            if (!d.this.f12180d.d(i4)) {
                                ApkInfo apkInfo = null;
                                if (!d.this.f12181f) {
                                    d.a(3);
                                    d.this.a((Callback) null);
                                }
                                g a4 = g.a(d.f12174b.getApplicationContext());
                                long currentTimeMillis2 = System.currentTimeMillis();
                                while (System.currentTimeMillis() - currentTimeMillis2 <= PolicyConfig.THREAD_BLOCK_TIMEOUT) {
                                    com.baidu.liantian.b.a();
                                    apkInfo = d.this.f12180d.a(i4);
                                    if (apkInfo != null) {
                                        if (a4.d(apkInfo.packageName) == null) {
                                            if (apkInfo.initStatus == -1) {
                                                break;
                                            }
                                        } else {
                                            z3 = true;
                                            break;
                                        }
                                    }
                                    SystemClock.sleep(1000L);
                                }
                                z3 = false;
                                if (!z3) {
                                    Callback callback3 = callback;
                                    if (callback3 != null) {
                                        callback3.onError(4);
                                        return;
                                    }
                                    return;
                                }
                                Class<?> a5 = ((f) a4.d(apkInfo.packageName).classLoader).a("com.baidu.liantian.engine.EngineImpl");
                                Object a6 = com.baidu.liantian.b.e.a(a5.getDeclaredMethod("getInstance", Context.class).invoke(a5, d.f12174b), str, clsArr, objArr);
                                try {
                                    f4.a(a6);
                                    com.baidu.liantian.b.a();
                                } catch (Throwable unused) {
                                    com.baidu.liantian.b.e.a();
                                }
                                Callback callback4 = callback;
                                if (callback4 != null) {
                                    callback4.onEnd(a6);
                                    return;
                                }
                                return;
                            }
                            Callback callback5 = callback;
                            if (callback5 != null) {
                                callback5.onError(3);
                            }
                        } catch (IllegalAccessException e4) {
                            e4.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback6 = callback;
                            if (callback6 != null) {
                                callback6.onError(2);
                            }
                        } catch (IllegalArgumentException e5) {
                            e5.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback7 = callback;
                            if (callback7 != null) {
                                callback7.onError(2);
                            }
                        } catch (NoSuchMethodException e6) {
                            e6.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback8 = callback;
                            if (callback8 != null) {
                                callback8.onError(2);
                            }
                        } catch (InvocationTargetException e7) {
                            e7.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback9 = callback;
                            if (callback9 != null) {
                                callback9.onError(2);
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                            com.baidu.liantian.b.b();
                            Callback callback10 = callback;
                            if (callback10 != null) {
                                callback10.onError(3);
                            }
                        }
                    }
                }.start();
            } else if (callback != null) {
                callback.onError(1);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final Pair<Integer, Object> a(int i4, String str, Class<?>[] clsArr, Object... objArr) {
        com.baidu.liantian.b.a();
        HashMap hashMap = new HashMap();
        hashMap.put("0", Integer.toString(i4));
        hashMap.put("1", !TextUtils.isEmpty(str) ? str : " ");
        hashMap.put("2", "1");
        com.baidu.liantian.b.e.a(f12174b, "1003136", hashMap);
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(1, null);
        }
        try {
            boolean d4 = this.f12180d.d(i4);
            com.baidu.liantian.b.a();
            if (d4) {
                return new Pair<>(3, null);
            }
            if (!this.f12181f) {
                return new Pair<>(3, null);
            }
            g a4 = g.a();
            if (a4 == null) {
                return new Pair<>(3, null);
            }
            ApkInfo a5 = this.f12180d.a(i4);
            if (!((a5 == null || a4.d(a5.packageName) == null) ? false : true)) {
                return new Pair<>(4, null);
            }
            Class<?> a6 = ((f) a4.d(a5.packageName).classLoader).a("com.baidu.liantian.engine.EngineImpl");
            Object a7 = com.baidu.liantian.b.e.a(a6.getDeclaredMethod("getInstance", Context.class).invoke(a6, f12174b), str, clsArr, objArr);
            try {
                f4.a(a7);
                com.baidu.liantian.b.a();
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            return new Pair<>(0, a7);
        } catch (IllegalAccessException e4) {
            e4.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (IllegalArgumentException e5) {
            e5.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (NoSuchMethodException e6) {
            e6.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (InvocationTargetException e7) {
            e7.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(2, null);
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
            return new Pair<>(3, null);
        }
    }

    public final void a(final String str) {
        try {
            com.baidu.liantian.b.a();
            new Thread() { // from class: com.baidu.liantian.core.d.4
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    super.run();
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        final g a4 = g.a(d.f12174b.getApplicationContext());
                        f4.a(a4);
                        com.baidu.liantian.b.a();
                        if (a4 == null) {
                            return;
                        }
                        final ApkInfo d4 = a4.d(str);
                        f4.a(d4);
                        com.baidu.liantian.b.a();
                        if (d4 == null) {
                            ApkInfo c4 = d.this.f12180d.c(str);
                            d dVar = d.this;
                            String str2 = str;
                            String str3 = c4.pkgPath;
                            dVar.f12180d.a(str2);
                            File file = new File(str3);
                            file.getAbsolutePath();
                            file.exists();
                            com.baidu.liantian.b.a();
                            if (file.exists()) {
                                com.baidu.liantian.c.a(file);
                                file.delete();
                                file.getAbsolutePath();
                                com.baidu.liantian.b.a();
                                return;
                            }
                            return;
                        }
                        Class<?> a5 = ((f) d4.classLoader).a("com.baidu.liantian.engine.EngineImpl");
                        Object invoke = a5.getDeclaredMethod("getInstance", Context.class).invoke(a5, d.f12174b);
                        f4.a(invoke);
                        com.baidu.liantian.b.a();
                        if (invoke == null) {
                            return;
                        }
                        System.currentTimeMillis();
                        com.baidu.liantian.b.a();
                        new Timer().schedule(new TimerTask() { // from class: com.baidu.liantian.core.d.4.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public final void run() {
                                System.currentTimeMillis();
                                com.baidu.liantian.b.a();
                                a4.b(str);
                                d.this.f12180d.a(str);
                                com.baidu.liantian.b.e.c(d.f12174b);
                                File file2 = new File(d4.pkgPath);
                                file2.getAbsolutePath();
                                file2.exists();
                                com.baidu.liantian.b.a();
                                if (file2.exists()) {
                                    com.baidu.liantian.c.a(file2);
                                    file2.delete();
                                    file2.getAbsolutePath();
                                    com.baidu.liantian.b.a();
                                }
                            }
                        }, 600000L);
                        f4.a(com.baidu.liantian.b.e.a(invoke, "unload", (Class<?>[]) null, new Object[0]));
                        com.baidu.liantian.b.a();
                        a4.b(str);
                        d.this.f12180d.a(str);
                        com.baidu.liantian.b.e.c(d.f12174b);
                        File file2 = new File(d4.pkgPath);
                        file2.getAbsolutePath();
                        file2.exists();
                        com.baidu.liantian.b.a();
                        if (file2.exists()) {
                            com.baidu.liantian.c.a(file2);
                            file2.delete();
                            file2.getAbsolutePath();
                            com.baidu.liantian.b.a();
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        com.baidu.liantian.b.b();
                    }
                }
            }.start();
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public static void a(int i4) {
        if (f12178h == 0) {
            f12178h = i4;
        }
    }
}
