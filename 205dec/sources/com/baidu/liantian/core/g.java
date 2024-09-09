package com.baidu.liantian.core;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.LiantianReceiver;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PluginloaderHub.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    private static g f12210e;

    /* renamed from: f  reason: collision with root package name */
    private static Application f12211f;

    /* renamed from: c  reason: collision with root package name */
    private String f12214c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12215d;

    /* renamed from: g  reason: collision with root package name */
    private static Random f12212g = new Random();

    /* renamed from: b  reason: collision with root package name */
    public static List<Integer> f12209b = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private Map<String, ApkInfo> f12216h = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ApkInfo> f12213a = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    private Map<String, LiantianReceiver> f12217i = new HashMap();

    public static g a(Context context) {
        if (f12210e == null) {
            f12211f = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
            f12210e = new g();
        }
        return f12210e;
    }

    private static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable th) {
            Log.e("Utilities", "ensureDirectory - " + th);
            return false;
        }
    }

    public final synchronized void b(h hVar) {
        try {
            if (hVar.f12221d == null) {
                return;
            }
            ApkInfo apkInfo = this.f12213a.get(hVar.f12218a);
            if (apkInfo != null && apkInfo.intentFilters != null) {
                ArrayList<Integer> arrayList = new ArrayList();
                for (int i4 = 0; i4 < apkInfo.intentFilters.size(); i4++) {
                    if (hVar.a(apkInfo.intentFilters.get(i4))) {
                        arrayList.add(Integer.valueOf(i4));
                    }
                }
                for (Integer num : arrayList) {
                    int intValue = num.intValue();
                    List<h> list = apkInfo.intentFilters;
                    if (list != null) {
                        list.remove(intValue);
                    }
                }
                List<h> list2 = apkInfo.intentFilters;
                if (list2 != null && list2.size() == 0) {
                    apkInfo.intentFilters = null;
                }
            }
            String a4 = a(hVar.f12221d);
            com.baidu.liantian.b.a();
            if (!TextUtils.isEmpty(a4) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a4)) {
                for (ApkInfo apkInfo2 : b()) {
                    List<h> list3 = apkInfo2.intentFilters;
                    if (list3 != null && list3.size() > 0) {
                        for (h hVar2 : apkInfo2.intentFilters) {
                            String a5 = a(hVar2.f12221d);
                            if (!TextUtils.isEmpty(a5) && a5.equals(a4)) {
                                com.baidu.liantian.b.a();
                                return;
                            }
                        }
                        continue;
                    }
                }
                com.baidu.liantian.b.a();
                f12211f.unregisterReceiver(this.f12217i.get(a4));
                this.f12217i.remove(a4);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    public final ApkInfo c(String str) {
        try {
            return this.f12216h.get(str);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    public final ApkInfo d(String str) {
        try {
            return this.f12213a.get(str);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    public static g a() {
        return f12210e;
    }

    public final synchronized void a(h hVar) {
        try {
            if (hVar.f12221d == null) {
                return;
            }
            ApkInfo apkInfo = this.f12213a.get(hVar.f12218a);
            if (apkInfo != null) {
                if (apkInfo.intentFilters == null) {
                    apkInfo.intentFilters = new ArrayList();
                }
                boolean z3 = false;
                for (int i4 = 0; i4 < apkInfo.intentFilters.size(); i4++) {
                    if (hVar.a(apkInfo.intentFilters.get(i4))) {
                        return;
                    }
                }
                apkInfo.intentFilters.add(hVar);
                String a4 = a(hVar.f12221d);
                com.baidu.liantian.b.a();
                if (!TextUtils.isEmpty(a4) && !a4.equals("____")) {
                    if (!this.f12217i.keySet().contains(a4) && !"android.intent.action.PACKAGE_REMOVED__package".equals(a4)) {
                        LiantianReceiver liantianReceiver = new LiantianReceiver();
                        try {
                            f12211f.registerReceiver(liantianReceiver, hVar.f12221d);
                        } catch (Throwable unused) {
                            z3 = true;
                        }
                        if (z3) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException unused2) {
                                com.baidu.liantian.b.e.a();
                            }
                            f12211f.registerReceiver(liantianReceiver, hVar.f12221d);
                        }
                        this.f12217i.put(a4, liantianReceiver);
                    }
                }
            }
        } catch (Throwable unused3) {
            com.baidu.liantian.b.e.a();
        }
    }

    private static String a(IntentFilter intentFilter) {
        if (intentFilter == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int countActions = intentFilter.countActions();
            if (countActions > 0) {
                ArrayList<String> arrayList = new ArrayList();
                for (int i4 = 0; i4 < countActions; i4++) {
                    String action = intentFilter.getAction(i4);
                    if (!TextUtils.isEmpty(action)) {
                        arrayList.add(action);
                    }
                }
                if (arrayList.size() > 0) {
                    Collections.sort(arrayList);
                    for (String str : arrayList) {
                        sb.append(str);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countCategories = intentFilter.countCategories();
            if (countCategories > 0) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (int i5 = 0; i5 < countCategories; i5++) {
                    String category = intentFilter.getCategory(i5);
                    if (!TextUtils.isEmpty(category)) {
                        arrayList2.add(category);
                    }
                }
                if (arrayList2.size() > 0) {
                    Collections.sort(arrayList2);
                    for (String str2 : arrayList2) {
                        sb.append(str2);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            if (intentFilter.countDataTypes() > 0) {
                ArrayList<String> arrayList3 = new ArrayList();
                for (int i6 = 0; i6 < countCategories; i6++) {
                    String dataType = intentFilter.getDataType(i6);
                    if (!TextUtils.isEmpty(dataType)) {
                        arrayList3.add(dataType);
                    }
                }
                if (arrayList3.size() > 0) {
                    Collections.sort(arrayList3);
                    for (String str3 : arrayList3) {
                        sb.append(str3);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            int countDataSchemes = intentFilter.countDataSchemes();
            if (countDataSchemes > 0) {
                ArrayList<String> arrayList4 = new ArrayList();
                for (int i7 = 0; i7 < countDataSchemes; i7++) {
                    String dataScheme = intentFilter.getDataScheme(i7);
                    if (!TextUtils.isEmpty(dataScheme)) {
                        arrayList4.add(dataScheme);
                    }
                }
                if (arrayList4.size() > 0) {
                    Collections.sort(arrayList4);
                    for (String str4 : arrayList4) {
                        sb.append(str4);
                    }
                } else {
                    sb.append("_");
                }
            } else {
                sb.append("_");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final List<ApkInfo> b() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f12213a.keySet()) {
                arrayList.add(this.f12213a.get(str));
            }
            return arrayList;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            try {
                return new ArrayList();
            } catch (Throwable unused2) {
                com.baidu.liantian.b.e.a();
                return null;
            }
        }
    }

    public final boolean b(String str) {
        ApkInfo apkInfo = this.f12213a.get(str);
        if (apkInfo != null) {
            this.f12216h.remove(apkInfo.pkgPath);
            this.f12213a.remove(str);
            com.baidu.liantian.b.e.d(apkInfo.dataDir);
            Application application = f12211f;
            if (application != null) {
                com.baidu.liantian.b.e.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
            }
            this.f12216h.size();
            com.baidu.liantian.b.a();
            this.f12213a.size();
            com.baidu.liantian.b.a();
            return true;
        }
        return false;
    }

    public final boolean a(ApkInfo apkInfo, boolean z3) {
        System.currentTimeMillis();
        this.f12215d = z3;
        this.f12214c = apkInfo.versionName;
        boolean a4 = a(apkInfo);
        System.currentTimeMillis();
        com.baidu.liantian.b.a();
        return a4;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0208 A[Catch: all -> 0x0316, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0004, B:8:0x000e, B:10:0x001b, B:12:0x0025, B:15:0x002a, B:16:0x002f, B:18:0x003c, B:21:0x0070, B:23:0x0078, B:33:0x0125, B:36:0x012b, B:38:0x0132, B:40:0x013a, B:42:0x0142, B:55:0x0181, B:57:0x0189, B:59:0x0193, B:61:0x0197, B:63:0x019b, B:65:0x01a5, B:68:0x01ac, B:70:0x01b7, B:79:0x01f6, B:81:0x0208, B:71:0x01c1, B:73:0x01cb, B:74:0x01d5, B:76:0x01db, B:77:0x01e3, B:78:0x01ed, B:84:0x0263, B:87:0x0306, B:88:0x030d, B:43:0x0146, B:45:0x0154, B:47:0x015c, B:49:0x0164, B:51:0x0171, B:53:0x0179, B:89:0x030e, B:90:0x0315, B:24:0x007b, B:26:0x0083, B:28:0x008b, B:29:0x0112, B:30:0x0119), top: B:105:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(com.baidu.liantian.core.ApkInfo r8) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo):boolean");
    }

    private static PackageInfo a(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pk", str);
            jSONObject.put("m", str2);
            jSONArray.put(jSONObject);
            String jSONArray2 = jSONArray.toString();
            com.baidu.liantian.b.a();
            String a4 = com.baidu.liantian.b.h.a(f12211f, com.baidu.liantian.b.e.b() + "p/1/pdl", jSONArray2, false);
            com.baidu.liantian.b.a();
            JSONArray jSONArray3 = new JSONArray(a4);
            if (jSONArray3.length() <= 0) {
                return null;
            }
            JSONObject optJSONObject = jSONArray3.optJSONObject(0);
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = optJSONObject.optString("p");
            packageInfo.versionName = optJSONObject.optString("v");
            ApplicationInfo applicationInfo = new ApplicationInfo();
            String optString = optJSONObject.optString("n");
            applicationInfo.className = optString;
            if (!TextUtils.isEmpty(optString) && applicationInfo.className.startsWith(".")) {
                applicationInfo.className = packageInfo.packageName + applicationInfo.className;
            }
            applicationInfo.theme = optJSONObject.optInt("t");
            packageInfo.applicationInfo = applicationInfo;
            JSONArray optJSONArray = optJSONObject.optJSONArray("a");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                    if (jSONObject2 != null) {
                        ActivityInfo activityInfo = new ActivityInfo();
                        String optString2 = jSONObject2.optString("n");
                        activityInfo.name = optString2;
                        if (!TextUtils.isEmpty(optString2) && activityInfo.name.startsWith(".")) {
                            activityInfo.name = packageInfo.packageName + activityInfo.name;
                        }
                        activityInfo.packageName = packageInfo.packageName;
                        activityInfo.theme = jSONObject2.optInt("t");
                        activityInfo.labelRes = jSONObject2.optInt("l");
                        if (!TextUtils.isEmpty(activityInfo.name)) {
                            arrayList.add(activityInfo);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
            return packageInfo;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    private static boolean a(ApkInfo apkInfo, String str) {
        try {
            com.baidu.liantian.b.a();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Application application = (Application) apkInfo.classLoader.loadClass(str).newInstance();
            com.baidu.liantian.f.a(Application.class, f12211f, application);
            a(application, f12211f);
            application.onCreate();
            return true;
        } catch (Throwable th) {
            th.getMessage();
            com.baidu.liantian.b.b();
            return false;
        }
    }

    private void a(ApkInfo apkInfo, String str, String str2) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        a(apkInfo, str, hashSet, sb, true, false);
        String str3 = ":" + System.getProperty("java.library.path");
        String str4 = "";
        if (Build.VERSION.SDK_INT >= 25) {
            str3 = "";
        }
        String str5 = Build.CPU_ABI;
        if (hashSet.contains(str5)) {
            String str6 = str + TTPathConst.sSeparator + str5;
            String str7 = null;
            try {
                String str8 = Build.CPU_ABI2;
                if (hashSet.contains(str8)) {
                    str7 = str + TTPathConst.sSeparator + str8;
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            if (str7 != null) {
                str4 = str6 + ":" + str7 + str3;
            } else {
                str4 = str6 + str3;
            }
        } else {
            try {
                String str9 = Build.CPU_ABI2;
                if (hashSet.contains(str9)) {
                    str4 = str + TTPathConst.sSeparator + str9 + str3;
                }
            } catch (Throwable unused2) {
                com.baidu.liantian.b.e.a();
            }
        }
        if (TextUtils.isEmpty(str4) && (("armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains("armeabi")) || ("armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains("armeabi")))) {
            str4 = str + "/armeabi" + str3;
        }
        String str10 = str4;
        apkInfo.libPath = str10;
        PathClassLoader pathClassLoader = new PathClassLoader(apkInfo.hostContext.getPackageResourcePath(), g.class.getClassLoader());
        com.baidu.liantian.b.a();
        try {
            String absolutePath = new File(str2, "apkDex").getAbsolutePath();
            com.baidu.liantian.b.e.d(absolutePath);
            e(absolutePath);
            f fVar = new f(apkInfo.pkgPath, absolutePath, str10, pathClassLoader);
            apkInfo.classLoader = fVar;
            Class<?> loadClass = fVar.loadClass("com.baidu.liantian.engine.EngineImpl");
            f4.a(loadClass);
            com.baidu.liantian.b.a();
            if (loadClass == null || TextUtils.isEmpty(loadClass.getName())) {
                throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
            }
        } catch (Throwable unused3) {
            com.baidu.liantian.b.a();
            try {
                com.baidu.liantian.b.e.d(new File(str2, "apkDex").getAbsolutePath());
                String absolutePath2 = new File(str2, "dexDex").getAbsolutePath();
                com.baidu.liantian.b.e.d(absolutePath2);
                e(absolutePath2);
                a(apkInfo, str, hashSet, sb, false, true);
                com.baidu.liantian.b.a();
                f fVar2 = new f(sb.toString(), absolutePath2, str10, pathClassLoader);
                apkInfo.classLoader = fVar2;
                Class<?> loadClass2 = fVar2.loadClass("com.baidu.liantian.engine.EngineImpl");
                f4.a(loadClass2);
                com.baidu.liantian.b.a();
                com.baidu.liantian.b.a();
                File file = new File(sb.toString());
                if (file.exists()) {
                    file.delete();
                }
                if (loadClass2 == null || TextUtils.isEmpty(loadClass2.getName())) {
                    throw new Exception("class ForHostApp.ENGINE_IMPL_CLASS_FULL_PATH loaded is null");
                }
            } catch (Throwable unused4) {
                com.baidu.liantian.b.a();
                try {
                    com.baidu.liantian.b.e.d(apkInfo.dataDir);
                    Application application = f12211f;
                    if (application != null) {
                        com.baidu.liantian.b.e.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                    }
                } catch (Throwable unused5) {
                }
                throw new RuntimeException("can't load EngineImpl by both dexFile:" + sb.toString() + " and ZipFile:" + apkInfo.pkgPath);
            }
        }
    }

    public final boolean a(String str) {
        ApkInfo apkInfo = this.f12216h.get(str);
        if (apkInfo != null) {
            this.f12216h.remove(str);
            this.f12213a.remove(apkInfo.packageName);
            com.baidu.liantian.b.e.d(apkInfo.dataDir);
            Application application = f12211f;
            if (application != null) {
                com.baidu.liantian.b.e.d(application.getFileStreamPath(apkInfo.packageName).getAbsolutePath());
                return true;
            }
            return true;
        }
        return false;
    }

    private static void a(Application application, Context context) {
        Class<?> cls = context.getClass();
        for (Class<Application> cls2 = Application.class; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField("mBase");
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(cls)) {
                    declaredField.set(application, context);
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:15|(1:156)(12:20|21|22|23|(5:25|(2:27|(1:29))(1:42)|30|(1:41)(2:32|(2:34|(1:40)(2:36|(1:38))))|39)|43|44|45|46|(3:47|48|(1:50)(1:51))|52|53)|54|55|(1:132)(14:60|61|62|63|64|(3:65|66|(3:68|69|70)(1:108))|109|110|111|112|113|114|115|116)|79|80|39|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x021b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x021c, code lost:
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0228 A[Catch: EOFException -> 0x02cf, ZipException -> 0x02f3, all -> 0x0314, TryCatch #23 {all -> 0x0314, blocks: (B:24:0x00a5, B:26:0x00ab, B:28:0x00bd, B:31:0x00c5, B:35:0x00cf, B:37:0x00d8, B:39:0x00de, B:43:0x00e9, B:45:0x00f1, B:47:0x00f7, B:49:0x00fd, B:51:0x0103, B:53:0x014c, B:106:0x0220, B:108:0x0228, B:110:0x022e, B:137:0x02dd, B:148:0x0301, B:34:0x00ca), top: B:187:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:214:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.baidu.liantian.core.ApkInfo r20, java.lang.String r21, java.util.HashSet<java.lang.String> r22, java.lang.StringBuilder r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo, java.lang.String, java.util.HashSet, java.lang.StringBuilder, boolean, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:5|(1:87)(5:10|11|12|(4:19|(3:20|21|(1:23)(1:24))|25|26)|58)|27|28|(8:33|34|35|(3:36|37|(1:39)(1:40))|41|(1:43)|44|45)|56|57|58) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015c, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.baidu.liantian.core.ApkInfo r17, java.lang.String r18, java.lang.String r19, java.util.HashSet<java.lang.String> r20, byte[] r21, java.lang.StringBuilder r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.core.g.a(com.baidu.liantian.core.ApkInfo, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean, boolean):void");
    }
}
