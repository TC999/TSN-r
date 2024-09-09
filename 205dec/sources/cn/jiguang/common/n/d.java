package cn.jiguang.common.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.ag.h;
import cn.jiguang.ah.a;
import cn.jiguang.ao.i;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.ax.d;
import cn.jiguang.common.m.f;
import cn.jiguang.internal.JConstants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"PackageManagerGetSignatures"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    private static Map<String, cn.jiguang.common.m.d> f3561i;

    /* renamed from: k  reason: collision with root package name */
    private static List<PackageInfo> f3563k;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f3556d = {102, 124, 16, 76, 112, 123, 98, 49, 64, 65, 122, 99, 119, 118, 85};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f3557e = {111, 115, 101, 121, 78, 106, 124, 119, 125, 92, 69, 125, 88, 119, 114, 91, 65, 126, 109, 101};

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, Signature[]> f3558f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, String> f3559g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static String f3560h = "JAppHelper";

    /* renamed from: j  reason: collision with root package name */
    private static List<cn.jiguang.common.m.d> f3562j = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public static int f3553a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f3554b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f3555c = 2;

    public static int a(ApplicationInfo applicationInfo) {
        if (applicationInfo == null) {
            return -1;
        }
        try {
            int i4 = applicationInfo.flags;
            if ((i4 & 1) != 0) {
                return (i4 & 128) != 0 ? 2 : 1;
            }
            String a4 = cn.jiguang.ag.a.a(applicationInfo);
            if (TextUtils.isEmpty(a4)) {
                return -1;
            }
            return (a4.startsWith("/system/") || !a4.contains(applicationInfo.packageName)) ? 3 : 0;
        } catch (Throwable th) {
            String str = f3560h;
            cn.jiguang.w.a.f(str, "getAppInstalledType throwable:" + th.getMessage());
            return -1;
        }
    }

    public static ApplicationInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            String str2 = f3560h;
            cn.jiguang.w.a.f(str2, "getApplicationInfo throwable:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    public static Object a(Context context, boolean z3, Object obj) {
        int i4;
        int i5;
        if (cn.jiguang.ar.a.a().g(1100)) {
            cn.jiguang.w.a.b(f3560h, "not allowed to get applist");
            i4 = -3;
        } else if (d(context)) {
            List<cn.jiguang.common.m.d> a4 = a(context, true, false);
            if (a4 != null && a4.size() > 0) {
                ArrayList<cn.jiguang.common.m.d> arrayList = new ArrayList();
                if (z3) {
                    arrayList.addAll(a4);
                } else {
                    for (cn.jiguang.common.m.d dVar : a4) {
                        if (dVar != null && ((i5 = dVar.f3499e) == 0 || i5 == 3)) {
                            arrayList.add(dVar);
                        }
                    }
                }
                if (obj instanceof List) {
                    obj = (List) obj;
                    for (cn.jiguang.common.m.d dVar2 : arrayList) {
                        if (dVar2 != null && !TextUtils.isEmpty(dVar2.f3496b)) {
                            obj.add(dVar2.f3496b);
                        }
                    }
                }
                return obj;
            }
            cn.jiguang.w.a.b(f3560h, "get third applist failed");
            i4 = -1;
        } else {
            cn.jiguang.w.a.f(f3560h, "no QUERY_ALL_PACKAGES permission, can not get third applist");
            i4 = -2;
        }
        return Integer.valueOf(i4);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        Signature[] signatureArr;
        try {
            String str2 = packageInfo.packageName;
            HashMap<String, Signature[]> hashMap = f3558f;
            if (hashMap.containsKey(str2)) {
                signatureArr = hashMap.get(str2);
            } else {
                signatureArr = a(context, packageInfo);
                if (signatureArr != null && signatureArr.length > 0) {
                    hashMap.put(str2, signatureArr);
                }
            }
            if (signatureArr != null && signatureArr.length != 0) {
                byte[] digest = MessageDigest.getInstance(str).digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < digest.length; i4++) {
                    String upperCase = Integer.toHexString(digest[i4] & 255).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase);
                    if (i4 < digest.length - 1) {
                        sb.append(":");
                    }
                }
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            String str3 = f3560h;
            cn.jiguang.w.a.f(str3, "getSign fail, error is " + th.getMessage());
            return "";
        }
    }

    public static String a(Collection<cn.jiguang.common.m.d> collection) {
        StringBuilder sb = new StringBuilder();
        for (cn.jiguang.common.m.d dVar : collection) {
            sb.append(dVar.f3496b);
            sb.append("&");
            sb.append(dVar.f3504j);
            sb.append("&");
            sb.append(dVar.f3505k);
            sb.append("&&");
        }
        return sb.toString();
    }

    public static ArrayList<JSONArray> a(JSONArray jSONArray) {
        String str;
        StringBuilder sb;
        String message;
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList<JSONArray> arrayList = new ArrayList<>();
                int i4 = 0;
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                    if (optJSONObject != null && optJSONObject.length() != 0) {
                        int length = optJSONObject.toString().getBytes("UTF-8").length;
                        i4 += length;
                        if (i4 > 102400) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            jSONArray2 = new JSONArray();
                            jSONArray2.put(optJSONObject);
                            i4 = length;
                        } else {
                            jSONArray2.put(optJSONObject);
                        }
                    }
                }
                if (jSONArray2.length() > 0) {
                    arrayList.add(jSONArray2);
                }
                return arrayList;
            } catch (UnsupportedEncodingException e4) {
                str = f3560h;
                sb = new StringBuilder();
                sb.append("partition exception:");
                message = e4.getMessage();
                sb.append(message);
                cn.jiguang.w.a.f(str, sb.toString());
                return null;
            } catch (Throwable th) {
                str = f3560h;
                sb = new StringBuilder();
                sb.append("partition throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.w.a.f(str, sb.toString());
                return null;
            }
        }
        return null;
    }

    public static List<PackageInfo> a() {
        List<PackageInfo> list = f3563k;
        return list == null ? new ArrayList() : list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (cn.jiguang.ar.a.a().e(1109) != false) goto L3;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[Catch: all -> 0x0095, TryCatch #0 {all -> 0x0095, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0028, B:11:0x002f, B:12:0x0034, B:14:0x003a, B:16:0x0046, B:19:0x004f, B:23:0x005e, B:25:0x006a, B:31:0x007f, B:32:0x0086, B:29:0x0079, B:33:0x0089, B:35:0x008d), top: B:40:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<android.content.pm.PackageInfo> a(android.content.Context r7, int r8, boolean r9) {
        /*
            r0 = 0
            if (r9 != 0) goto Lf
            cn.jiguang.ar.a r1 = cn.jiguang.ar.a.a()     // Catch: java.lang.Throwable -> L95
            r2 = 1109(0x455, float:1.554E-42)
            boolean r1 = r1.e(r2)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto Lb0
        Lf:
            java.lang.String r1 = cn.jiguang.common.n.d.f3560h     // Catch: java.lang.Throwable -> L95
            java.lang.String r2 = "start to getInstalledApps by shell "
            cn.jiguang.w.a.b(r1, r2)     // Catch: java.lang.Throwable -> L95
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L95
            byte[] r3 = cn.jiguang.common.n.d.f3556d     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = cn.jiguang.ao.c.b(r3)     // Catch: java.lang.Throwable -> L95
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> L95
            java.util.List r1 = cn.jiguang.ao.g.a(r2, r1)     // Catch: java.lang.Throwable -> L95
            if (r1 == 0) goto L8d
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L2f
            goto L8d
        L2f:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L95
            r2.<init>()     // Catch: java.lang.Throwable -> L95
        L34:
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L95
            if (r4 >= r3) goto L8c
            java.lang.Object r3 = r1.get(r4)     // Catch: java.lang.Throwable -> L95
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L95
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L95
            if (r5 != 0) goto L89
            java.lang.String r5 = "package:"
            boolean r5 = r3.startsWith(r5)     // Catch: java.lang.Throwable -> L95
            if (r5 != 0) goto L4f
            goto L89
        L4f:
            r5 = 8
            java.lang.String r3 = r3.substring(r5)     // Catch: java.lang.Throwable -> L95
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L95
            if (r5 == 0) goto L5c
            goto L89
        L5c:
            if (r9 != 0) goto L79
            cn.jiguang.ar.a r5 = cn.jiguang.ar.a.a()     // Catch: java.lang.Throwable -> L95
            r6 = 1105(0x451, float:1.548E-42)
            boolean r5 = r5.g(r6)     // Catch: java.lang.Throwable -> L95
            if (r5 != 0) goto L77
            cn.jiguang.ar.a r5 = cn.jiguang.ar.a.a()     // Catch: java.lang.Throwable -> L95
            r6 = 1100(0x44c, float:1.541E-42)
            boolean r5 = r5.g(r6)     // Catch: java.lang.Throwable -> L95
            if (r5 != 0) goto L77
            goto L79
        L77:
            r5 = r0
            goto L7d
        L79:
            android.content.pm.PackageInfo r5 = cn.jiguang.ag.a.a(r7, r3, r8)     // Catch: java.lang.Throwable -> L95
        L7d:
            if (r5 != 0) goto L86
            android.content.pm.PackageInfo r5 = new android.content.pm.PackageInfo     // Catch: java.lang.Throwable -> L95
            r5.<init>()     // Catch: java.lang.Throwable -> L95
            r5.packageName = r3     // Catch: java.lang.Throwable -> L95
        L86:
            r2.add(r5)     // Catch: java.lang.Throwable -> L95
        L89:
            int r4 = r4 + 1
            goto L34
        L8c:
            return r2
        L8d:
            java.lang.String r7 = cn.jiguang.common.n.d.f3560h     // Catch: java.lang.Throwable -> L95
            java.lang.String r8 = "execute command pm list package failed"
            cn.jiguang.w.a.f(r7, r8)     // Catch: java.lang.Throwable -> L95
            return r0
        L95:
            r7 = move-exception
            java.lang.String r8 = cn.jiguang.common.n.d.f3560h
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "getInstalledPackagesByShell throwable:"
            r9.append(r1)
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            cn.jiguang.w.a.f(r8, r7)
        Lb0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.common.n.d.a(android.content.Context, int, boolean):java.util.List");
    }

    private static List<cn.jiguang.common.m.d> a(Context context, PackageManager packageManager, List<PackageInfo> list, boolean z3) {
        cn.jiguang.common.m.d dVar;
        a(context);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                PackageInfo packageInfo = list.get(i4);
                int a4 = a(packageInfo.applicationInfo);
                if (z3 || a4 == 0 || a4 == 3) {
                    cn.jiguang.common.m.d dVar2 = new cn.jiguang.common.m.d();
                    String str = packageInfo.packageName;
                    dVar2.f3496b = str;
                    dVar2.f3497c = packageInfo.versionName;
                    dVar2.f3498d = packageInfo.versionCode;
                    dVar2.f3499e = a4;
                    dVar2.f3500f = b(context, str);
                    dVar2.f3504j = cn.jiguang.ag.a.a(packageInfo);
                    dVar2.f3505k = packageInfo.lastUpdateTime;
                    dVar2.f3506l = packageInfo.requestedPermissions;
                    Map<String, cn.jiguang.common.m.d> map = f3561i;
                    if (map != null && map.containsKey(dVar2.f3496b) && (dVar = f3561i.get(dVar2.f3496b)) != null && dVar.equals(dVar2)) {
                        dVar2.f3495a = dVar.f3495a;
                    }
                    dVar2.f3501g = a(context, packageInfo, cn.jiguang.ap.b.f2348a);
                    dVar2.f3502h = a(context, packageInfo, cn.jiguang.ap.b.f2349b);
                    dVar2.f3503i = a(context, packageInfo, cn.jiguang.ap.b.f2350c);
                    if (dVar2.f3495a == null) {
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        if (applicationInfo != null) {
                            dVar2.f3495a = applicationInfo.loadLabel(packageManager).toString();
                        }
                        Map<String, cn.jiguang.common.m.d> map2 = f3561i;
                        if (map2 != null) {
                            map2.put(dVar2.f3496b, dVar2);
                        }
                    }
                    arrayList.add(dVar2);
                }
            } catch (Throwable unused) {
            }
        }
        System.gc();
        String b4 = b(arrayList);
        if (!h.a(b4)) {
            cn.jiguang.ao.e.d(context, "ban.catch");
            String b5 = i.b(b4);
            cn.jiguang.ah.c.b(context, 1100, System.currentTimeMillis());
            cn.jiguang.ao.e.a(context, "ban.catch", b5);
        }
        String str2 = f3560h;
        cn.jiguang.w.a.b(str2, "fillAppInfo app list size is " + arrayList.size());
        return arrayList;
    }

    public static synchronized List<cn.jiguang.common.m.d> a(Context context, boolean z3, boolean z4) {
        List<cn.jiguang.common.m.d> a4;
        synchronized (d.class) {
            a4 = a(context, z3, z4, false);
        }
        return a4;
    }

    public static synchronized List<cn.jiguang.common.m.d> a(final Context context, final boolean z3, boolean z4, boolean z5) {
        synchronized (d.class) {
            List<cn.jiguang.common.m.d> arrayList = new ArrayList<>();
            if (z5) {
                return b(context, z3, z5);
            }
            if (cn.jiguang.ar.a.a().e(1100)) {
                Object b4 = cn.jiguang.ax.d.b(context, 1100, 1800000L, 86400000L, z5, new d.b() { // from class: cn.jiguang.common.n.d.1
                    @Override // cn.jiguang.ax.d.b
                    public Object a() {
                        return d.f3562j;
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void a(Object obj) {
                        if (obj instanceof List) {
                            List unused = d.f3562j = (List) obj;
                        }
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object b() {
                        return d.b(context, z3);
                    }

                    @Override // cn.jiguang.ax.d.b
                    public void b(Object obj) {
                    }

                    @Override // cn.jiguang.ax.d.b
                    public Object c() {
                        ArrayList arrayList2 = new ArrayList();
                        Map<String, cn.jiguang.common.m.d> a4 = d.a(context);
                        if (a4 != null && a4.size() > 0) {
                            for (String str : a4.keySet()) {
                                cn.jiguang.common.m.d dVar = a4.get(str);
                                if (dVar != null) {
                                    arrayList2.add(dVar);
                                }
                            }
                        }
                        return arrayList2;
                    }
                });
                if (b4 instanceof List) {
                    arrayList = (List) b4;
                }
            }
            return arrayList;
        }
    }

    public static Map<String, cn.jiguang.common.m.d> a(Context context) {
        if (f3561i == null) {
            synchronized (d.class) {
                if (f3561i == null) {
                    String c4 = cn.jiguang.ao.e.c(context, "ban.catch");
                    if (!h.a(c4)) {
                        f3561i = c(i.a(c4));
                    }
                }
            }
        }
        return f3561i;
    }

    public static Set<cn.jiguang.common.m.d> a(String str) {
        HashSet hashSet = new HashSet();
        String[] split = str.split("&&");
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        cn.jiguang.common.m.d dVar = new cn.jiguang.common.m.d();
                        String[] split2 = str2.split("&");
                        int length = split2.length;
                        if (length == 1) {
                            dVar.f3496b = split2[0];
                        } else if (length == 2) {
                            dVar.f3496b = split2[0];
                            dVar.f3504j = Long.valueOf(split2[1]).longValue();
                        } else if (length == 3) {
                            dVar.f3496b = split2[0];
                            dVar.f3504j = Long.valueOf(split2[1]).longValue();
                            dVar.f3505k = Long.valueOf(split2[2]).longValue();
                        }
                        hashSet.add(dVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return hashSet;
    }

    private static void a(Context context, int i4) {
        if (f(context)) {
            cn.jiguang.ah.c.e(context, f3560h);
            String str = f3560h;
            cn.jiguang.w.a.b(str, "reportEvent :" + i4);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "app_list_fail");
                jSONObject.put("eventcode", i4);
                jSONObject.put("itime", System.currentTimeMillis());
                cn.jiguang.ah.d.a(context, (Object) jSONObject);
            } catch (Throwable th) {
                String str2 = f3560h;
                cn.jiguang.w.a.f(str2, "report error:" + th);
            }
        }
    }

    public static Signature[] a(Context context, PackageInfo packageInfo) {
        SigningInfo signingInfo;
        Signature[] signatureArr = null;
        if (Build.VERSION.SDK_INT > 28) {
            if (packageInfo.signingInfo == null) {
                if (cn.jiguang.ar.a.a().g(1100)) {
                    return null;
                }
                packageInfo = cn.jiguang.ag.a.a(context, packageInfo.packageName, 134217728, !cn.jiguang.ar.a.a().g(1105));
            }
            if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                signatureArr = signingInfo.hasMultipleSigners() ? packageInfo.signingInfo.getApkContentsSigners() : packageInfo.signingInfo.getSigningCertificateHistory();
            }
        } else {
            if (packageInfo.signatures == null) {
                if (cn.jiguang.ar.a.a().g(1100)) {
                    return null;
                }
                packageInfo = cn.jiguang.ag.a.a(context, packageInfo.packageName, 64, !cn.jiguang.ar.a.a().g(1105));
            }
            if (packageInfo != null) {
                signatureArr = packageInfo.signatures;
            }
        }
        if (packageInfo != null) {
            HashMap<String, String> hashMap = f3559g;
            if (!hashMap.containsKey(packageInfo.packageName)) {
                String str = packageInfo.packageName;
                hashMap.put(str, cn.jiguang.ag.a.a(packageInfo) + "&" + packageInfo.lastUpdateTime);
            }
        }
        return signatureArr;
    }

    public static int b(Context context, String str) {
        int i4 = 0;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setClassName(str, a.C0049a.f2216e);
            int i5 = packageManager.resolveService(intent, 0) != null ? 2 : 0;
            try {
                Intent intent2 = new Intent();
                intent2.setClassName(str, a.C0049a.f2218g);
                if (packageManager.resolveService(intent2, 0) != null) {
                    i5++;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(str, a.C0049a.f2219h);
                return packageManager.resolveService(intent3, 0) != null ? i5 + 4 : i5;
            } catch (Throwable th) {
                th = th;
                i4 = i5;
                String str2 = f3560h;
                cn.jiguang.w.a.f(str2, "filterThirdSdk throwable:" + th.getMessage());
                return i4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str) {
        try {
            return f3559g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b(List<cn.jiguang.common.m.d> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (cn.jiguang.common.m.d dVar : list) {
                sb.append(dVar.f3496b);
                sb.append("&");
                sb.append(dVar.f3495a);
                sb.append("&");
                sb.append(dVar.f3498d);
                sb.append("&");
                sb.append(dVar.f3497c);
                sb.append("&");
                sb.append(dVar.f3499e);
                sb.append("&");
                sb.append(dVar.f3500f);
                sb.append("&");
                sb.append(dVar.f3501g);
                sb.append("&");
                sb.append(dVar.f3502h);
                sb.append("&");
                sb.append(dVar.f3503i);
                sb.append("&");
                sb.append(dVar.f3504j);
                sb.append("&");
                sb.append(dVar.f3505k);
                sb.append("&&");
            }
            return sb.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<cn.jiguang.common.m.d> b(Context context, boolean z3) {
        return b(context, z3, false);
    }

    private static List<cn.jiguang.common.m.d> b(Context context, boolean z3, boolean z4) {
        if (!d(context)) {
            a(context, 1);
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> c4 = c(context, z4);
            if (c4 != null && !c4.isEmpty()) {
                return a(context, packageManager, c4, z3);
            }
            a(context, 2);
            return null;
        } finally {
            System.gc();
        }
    }

    public static Set<cn.jiguang.common.m.d> b(Context context) {
        String c4 = cn.jiguang.ao.e.c(context, "bal.catch");
        if (TextUtils.isEmpty(c4)) {
            return null;
        }
        return a(c4);
    }

    private static int c() {
        return (Build.VERSION.SDK_INT >= 28 ? 134217792 : 64) | 4 | 4096;
    }

    public static cn.jiguang.common.m.d c(Context context, String str) {
        cn.jiguang.common.m.d dVar;
        PackageInfo d4 = d(context, str);
        if (d4 == null) {
            return null;
        }
        try {
            a(context);
            cn.jiguang.common.m.d dVar2 = new cn.jiguang.common.m.d();
            dVar2.f3496b = d4.packageName;
            dVar2.f3498d = d4.versionCode;
            dVar2.f3497c = d4.versionName;
            dVar2.f3499e = a(d4.applicationInfo);
            dVar2.f3500f = b(context, str);
            dVar2.f3504j = cn.jiguang.ag.a.a(d4);
            dVar2.f3505k = d4.lastUpdateTime;
            Map<String, cn.jiguang.common.m.d> map = f3561i;
            if (map != null && map.containsKey(dVar2.f3496b) && (dVar = f3561i.get(dVar2.f3496b)) != null && dVar.equals(dVar2)) {
                dVar2.f3495a = dVar.f3495a;
            }
            dVar2.f3501g = a(context, d4, cn.jiguang.ap.b.f2348a);
            dVar2.f3502h = a(context, d4, cn.jiguang.ap.b.f2349b);
            dVar2.f3503i = a(context, d4, cn.jiguang.ap.b.f2350c);
            if (dVar2.f3495a == null) {
                dVar2.f3495a = d(d4.applicationInfo.loadLabel(context.getPackageManager()).toString());
                Map<String, cn.jiguang.common.m.d> map2 = f3561i;
                if (map2 != null) {
                    map2.put(dVar2.f3496b, dVar2);
                }
            }
            return dVar2;
        } catch (Throwable th) {
            try {
                String str2 = f3560h;
                cn.jiguang.w.a.f(str2, "getAppInfoFromPackage throwable:" + th.getMessage());
                return null;
            } finally {
                System.gc();
            }
        }
    }

    public static List<cn.jiguang.common.m.d> c(Context context) {
        return e(context);
    }

    private static List<PackageInfo> c(Context context, boolean z3) {
        List<PackageInfo> a4;
        PackageManager packageManager;
        String t3;
        cn.jiguang.as.b d4;
        int i4;
        List<PackageInfo> list;
        int c4 = c();
        try {
            JCoreManager.onEvent(context, JConstants.SDK_TYPE, 112, null, null, new Object[0]);
            packageManager = context.getPackageManager();
            t3 = cn.jiguang.ag.a.t(context);
        } catch (Throwable unused) {
            cn.jiguang.w.a.b(f3560h, "getInstalledApps by shell throwable");
            cn.jiguang.as.b.d().a(cn.jiguang.as.b.f2384a);
            a4 = a(context, c4, z3);
        }
        if (TextUtils.isEmpty(t3)) {
            d4 = cn.jiguang.as.b.d();
            i4 = cn.jiguang.as.b.f2384a;
        } else {
            String lowerCase = t3.toLowerCase();
            if (Build.VERSION.SDK_INT <= 30 || !(lowerCase.contains("oppo") || lowerCase.contains("realme"))) {
                if (f3555c == f3554b) {
                    cn.jiguang.w.a.b(f3560h, "getInstalledApps by shell ");
                    List<PackageInfo> a5 = a(context, c4, z3);
                    cn.jiguang.as.b.d().a(cn.jiguang.as.b.f2384a);
                    if (a5 != null || !cn.jiguang.ar.a.a().e(1108)) {
                        a4 = a5;
                        f3563k = a4;
                        return a4;
                    }
                    cn.jiguang.w.a.b(f3560h, "getInstalledApps by api\uff0cshell  pkgs is null");
                    cn.jiguang.as.b.d().a(cn.jiguang.as.b.f2385b);
                    list = (List) packageManager.getClass().getDeclaredMethod(cn.jiguang.ao.c.b(f3557e), Integer.TYPE).invoke(packageManager, Integer.valueOf(c()));
                } else {
                    if (cn.jiguang.ar.a.a().e(1108)) {
                        cn.jiguang.w.a.b(f3560h, "getInstalledApps by api  ");
                        cn.jiguang.as.b.d().a(cn.jiguang.as.b.f2385b);
                        list = (List) packageManager.getClass().getDeclaredMethod(cn.jiguang.ao.c.b(f3557e), Integer.TYPE).invoke(packageManager, Integer.valueOf(c()));
                    } else {
                        list = null;
                    }
                    if (list != null) {
                        if (list.size() == 1) {
                        }
                    }
                    cn.jiguang.w.a.b(f3560h, "getInstalledApps by shell, api pkgs is null");
                    d4 = cn.jiguang.as.b.d();
                    i4 = cn.jiguang.as.b.f2384a;
                }
                a4 = list;
                f3563k = a4;
                return a4;
            }
            cn.jiguang.w.a.b(f3560h, "getInstalledApps by shell oppo or realme");
            d4 = cn.jiguang.as.b.d();
            i4 = cn.jiguang.as.b.f2384a;
        }
        d4.a(i4);
        a4 = a(context, c4, z3);
        f3563k = a4;
        return a4;
    }

    private static Map<String, cn.jiguang.common.m.d> c(String str) {
        String[] split;
        cn.jiguang.common.m.d dVar;
        String str2;
        if (h.a(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str3 : str.split("&&")) {
            if (str3 != null) {
                try {
                    String[] split2 = str3.split("&");
                    if (split2.length == 9) {
                        dVar = new cn.jiguang.common.m.d();
                        dVar.f3496b = split2[0];
                        dVar.f3495a = split2[1];
                        dVar.f3498d = Integer.parseInt(split2[2]);
                        dVar.f3497c = split2[3];
                        dVar.f3499e = Integer.parseInt(split2[4]);
                        dVar.f3500f = Integer.parseInt(split2[5]);
                        dVar.f3501g = split2[6];
                        dVar.f3502h = split2[7];
                        dVar.f3503i = split2[8];
                        str2 = dVar.f3496b;
                    } else if (split2.length == 6) {
                        dVar = new cn.jiguang.common.m.d();
                        dVar.f3496b = split2[0];
                        dVar.f3495a = split2[1];
                        dVar.f3498d = Integer.parseInt(split2[2]);
                        dVar.f3497c = split2[3];
                        dVar.f3499e = Integer.parseInt(split2[4]);
                        dVar.f3500f = Integer.parseInt(split2[5]);
                        str2 = dVar.f3496b;
                    } else if (split2.length == 11) {
                        dVar = new cn.jiguang.common.m.d();
                        dVar.f3496b = split2[0];
                        dVar.f3495a = split2[1];
                        dVar.f3498d = Integer.parseInt(split2[2]);
                        dVar.f3497c = split2[3];
                        dVar.f3499e = Integer.parseInt(split2[4]);
                        dVar.f3500f = Integer.parseInt(split2[5]);
                        dVar.f3501g = split2[6];
                        dVar.f3502h = split2[7];
                        dVar.f3503i = split2[8];
                        dVar.f3504j = Long.parseLong(split2[9]);
                        dVar.f3505k = Long.parseLong(split2[10]);
                        str2 = dVar.f3496b;
                    }
                    hashMap.put(str2, dVar);
                } catch (Throwable th) {
                    cn.jiguang.w.a.f(f3560h, "parse appinfo error:" + th);
                }
            }
        }
        return hashMap;
    }

    private static PackageInfo d(Context context, String str) {
        int i4 = Build.VERSION.SDK_INT >= 28 ? 134217792 : 64;
        PackageInfo a4 = cn.jiguang.ag.a.a(context, str, i4);
        if (a4 == null) {
            int indexOf = str.indexOf(":");
            if (indexOf <= 0) {
                return null;
            }
            return cn.jiguang.ag.a.a(context, str.substring(0, indexOf), i4);
        }
        return a4;
    }

    private static String d(String str) {
        String str2;
        StringBuilder sb;
        String message;
        if (!TextUtils.isEmpty(str)) {
            String e4 = e(str);
            try {
                byte[] bytes = str.getBytes();
                if (bytes.length > 30) {
                    return e4.substring(0, new String(bytes, 0, 30, "UTF-8").length());
                }
            } catch (UnsupportedEncodingException e5) {
                str2 = f3560h;
                sb = new StringBuilder();
                sb.append("getAppName exception:");
                message = e5.getMessage();
                sb.append(message);
                cn.jiguang.w.a.f(str2, sb.toString());
                return str;
            } catch (Throwable th) {
                str2 = f3560h;
                sb = new StringBuilder();
                sb.append("getAppName throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.w.a.f(str2, sb.toString());
                return str;
            }
        }
        return str;
    }

    public static boolean d(Context context) {
        if (context == null) {
            cn.jiguang.w.a.f(f3560h, "[hasQueryAllPackagesPermission] context is null");
            return false;
        }
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 30 || context.getApplicationInfo().targetSdkVersion < 30 || cn.jiguang.ah.d.b(context, "android.permission.QUERY_ALL_PACKAGES")) {
                return true;
            }
            String str = f3560h;
            cn.jiguang.w.a.b(str, "current sdk code: " + i4 + ", no permission: QUERY_ALL_PACKAGES");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String e(String str) {
        return Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
    }

    private static List<cn.jiguang.common.m.d> e(Context context) {
        HashMap hashMap = new HashMap();
        List<f> a4 = e.a(context, 1);
        if (a4 == null) {
            return new ArrayList(hashMap.values());
        }
        Map<String, cn.jiguang.common.m.d> a5 = a(context);
        for (f fVar : a4) {
            cn.jiguang.common.m.d dVar = null;
            if (a5 != null) {
                String str = fVar.f3516d;
                int indexOf = str.indexOf(":");
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
                dVar = a5.get(str);
            }
            if (dVar == null || TextUtils.isEmpty(dVar.f3496b)) {
                dVar = c(context, fVar.f3516d);
            }
            if (dVar != null) {
                hashMap.put(dVar.f3496b, dVar);
            }
        }
        return new ArrayList(hashMap.values());
    }

    private static boolean f(Context context) {
        return System.currentTimeMillis() - cn.jiguang.ah.c.f(context, f3560h) >= cn.jiguang.ar.a.a().d(f3560h);
    }
}
