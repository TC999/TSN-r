package cn.jiguang.bs;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.ah.a;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.bx.i;
import cn.jiguang.f.h;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2868e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f2869f;

    /* renamed from: g  reason: collision with root package name */
    public static String f2870g;

    /* renamed from: h  reason: collision with root package name */
    public static String f2871h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f2872i;

    /* renamed from: o  reason: collision with root package name */
    private static LinkedList<String> f2878o;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f2879p;

    /* renamed from: j  reason: collision with root package name */
    private static final String f2873j = cn.jiguang.cn.d.b(new byte[]{62, 82, 38, 113, 19, 93, 73, 85, 84, 2, 23, 92, 58, 34, 40, 115, 19, 47, 78, 84, 32, 3, 19, 40, 57, 83, 32, 114, 23, 93, 49, 82});

    /* renamed from: k  reason: collision with root package name */
    private static String f2874k = "";

    /* renamed from: l  reason: collision with root package name */
    private static String f2875l = "/v3/report";

    /* renamed from: a  reason: collision with root package name */
    public static final String f2864a = cn.jiguang.cn.d.b(new byte[]{33, 1, 16, 43, 56, 37, 33, 4, 16, 44, 56, 32, 33, 7, 16, 33});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2865b = cn.jiguang.cn.d.b(new byte[]{120, 95, 80, 43, 56, 37, 33, 4, 16, 44, 56, 32, 112, 96, 75, 56});

    /* renamed from: c  reason: collision with root package name */
    public static JSONObject f2866c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f2867d = true;

    /* renamed from: m  reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f2876m = new ConcurrentHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    private static Handler f2877n = new Handler(b());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.cm.b {

        /* renamed from: a  reason: collision with root package name */
        public Context f2882a;

        /* renamed from: b  reason: collision with root package name */
        public String f2883b;

        /* renamed from: c  reason: collision with root package name */
        public String f2884c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f2885d;

        /* renamed from: e  reason: collision with root package name */
        public File f2886e;

        /* renamed from: f  reason: collision with root package name */
        public long f2887f = SystemClock.elapsedRealtime();

        public a(Context context, String str, String str2, JSONObject jSONObject) {
            this.f2882a = context;
            this.f2883b = str;
            this.f2884c = str2;
            this.f2885d = jSONObject;
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            a aVar;
            File a4 = d.a(this.f2882a, this.f2884c, this.f2885d, true);
            this.f2886e = a4;
            if (a4 == null || (aVar = (a) f.f2876m.get(this.f2883b)) == null) {
                return;
            }
            aVar.f2886e = this.f2886e;
            f.f2876m.replace(this.f2883b, aVar);
        }
    }

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{123, 98, 112, 68, 83, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2868e = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{106, 124, 119, 101, 67, 13, 112, 120, 96, 39, 30, 74, 105, 125, 101, 121, 30, 67, 119});
        f2869f = b5;
        f2870g = "";
        f2871h = "";
        LinkedList<String> linkedList = new LinkedList<>();
        f2878o = linkedList;
        linkedList.clear();
        f2878o.add(b4);
        f2878o.add(b5);
        f2879p = false;
        f2872i = true;
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack) {
        return a(context, set, jSONObject, file, reportCallBack, "");
    }

    public static int a(Context context, Set<String> set, JSONObject jSONObject, File file, ReportCallBack reportCallBack, String str) {
        Object obj;
        if (jSONObject != null) {
            try {
                if (jSONObject.length() != 0) {
                    if (!cn.jiguang.f.a.e(context)) {
                        cn.jiguang.bq.d.i("ReportUtils", "no network, give up upload");
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    } else if (!cn.jiguang.cf.b.a().b(context)) {
                        cn.jiguang.bq.d.i("NetDataMonitorManager", "report sdk limit");
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-2);
                        }
                        return -2;
                    } else {
                        Pair<byte[], Integer> a4 = a(jSONObject.toString(), true, 2);
                        if (a4 != null && (obj = a4.first) != null && ((byte[]) obj).length != 0) {
                            byte[] bArr = (byte[]) obj;
                            int intValue = ((Integer) a4.second).intValue();
                            cn.jiguang.bq.d.c("ReportUtils", "will upload length=" + bArr.length);
                            if (a(context, set, bArr.length, cn.jiguang.bv.c.d(context))) {
                                i.a().a(context, i.a().a(context, jSONObject, bArr, intValue, file, set, reportCallBack, str));
                                return 1;
                            }
                            int a5 = a(context, bArr, intValue, set);
                            if (a5 == 0) {
                                cn.jiguang.bq.d.c("ReportUtils", "http upload success json=" + cn.jiguang.f.d.a(jSONObject));
                                if (TextUtils.isEmpty(str)) {
                                    cn.jiguang.f.c.a(file);
                                } else {
                                    c(str);
                                }
                            }
                            if (a5 != 1) {
                                if (TextUtils.isEmpty(str)) {
                                    d.a(file);
                                }
                                if (reportCallBack != null) {
                                    reportCallBack.onFinish(a5);
                                }
                            }
                            return a5;
                        }
                        cn.jiguang.bq.d.i("ReportUtils", "package body failed, give up upload");
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                        return -1;
                    }
                }
            } catch (Throwable th) {
                try {
                    cn.jiguang.bq.d.i("ReportUtils", "upload failed, error:" + th);
                    if (TextUtils.isEmpty(str)) {
                        d.a(file);
                    }
                    if (reportCallBack != null) {
                        reportCallBack.onFinish(-1);
                    }
                    return -1;
                } catch (Throwable th2) {
                    if (0 != 1) {
                        if (TextUtils.isEmpty(str)) {
                            d.a(file);
                        }
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(0);
                        }
                    }
                    throw th2;
                }
            }
        }
        cn.jiguang.bq.d.i("ReportUtils", "upload content is empty, do nothing");
        if (TextUtils.isEmpty(str)) {
            d.a(file);
        }
        if (reportCallBack != null) {
            reportCallBack.onFinish(-1);
        }
        return -1;
    }

    private static int a(Context context, byte[] bArr, int i4, Set<String> set) {
        g a4;
        String str;
        LinkedHashSet<String> a5 = a(context, set);
        if (a5 == null || a5.isEmpty()) {
            cn.jiguang.bq.d.i("ReportUtils", "can't get url, give up upload");
            return -2;
        } else if (c(set)) {
            cn.jiguang.bq.d.c("ReportUtils", "types=" + set + " support tcp report only");
            return -2;
        } else {
            String str2 = " type=" + set;
            for (String str3 : a5) {
                if (TextUtils.isEmpty(str3)) {
                    cn.jiguang.bq.d.i("ReportUtils", "can't get url, give up upload");
                } else if (Build.VERSION.SDK_INT < 28 || str3.startsWith(a.C0049a.f2215d)) {
                    if (!str3.endsWith(f2875l)) {
                        str3 = str3 + f2875l;
                    }
                    String str4 = str3;
                    cn.jiguang.bq.d.c("ReportUtils", "upload" + str2 + " to url:" + str4);
                    int a6 = b.a(context, str4, bArr, i4, 3, 1, set).a();
                    if (a6 == -3) {
                        d.a(context, cn.jiguang.d.a.e(context));
                        return -2;
                    }
                    if (a6 == -1) {
                        str = "upload" + str2 + " error:" + a4.b();
                    } else if (a6 == 0) {
                        return 0;
                    } else {
                        str = "upload" + str2 + " failed";
                    }
                    cn.jiguang.bq.d.c("ReportUtils", str);
                } else {
                    cn.jiguang.bq.d.i("ReportUtils", "won't use http at device since 28");
                }
            }
            return -1;
        }
    }

    private static Pair<byte[], Integer> a(String str, boolean z3, int i4) {
        String str2;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (z3) {
                try {
                    bytes = cn.jiguang.f.i.a(bytes);
                } catch (IOException unused) {
                    return null;
                }
            }
            int a4 = cn.jiguang.cn.g.a();
            String a5 = cn.jiguang.cn.g.a(a4);
            if (i4 == 1) {
                str2 = f2864a;
            } else if (i4 != 2) {
                return null;
            } else {
                str2 = f2865b;
            }
            return new Pair<>(cn.jiguang.cn.g.a(bytes, a5, str2, true), Integer.valueOf(a4));
        } catch (UnsupportedEncodingException | Exception unused2) {
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        return a(context, str, str2, false);
    }

    public static String a(Context context, String str, String str2, boolean z3) {
        String e4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
        if (longValue == 0) {
            cn.jiguang.bq.d.c("ReportUtils", " miss uid,generate report token failed");
            return null;
        }
        if (z3) {
            e4 = f2873j;
        } else {
            String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.A());
            if (TextUtils.isEmpty(str3)) {
                str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.B());
            }
            e4 = cn.jiguang.f.g.e(str3);
        }
        String k4 = cn.jiguang.f.g.k(longValue + e4 + str);
        if (cn.jiguang.f.g.a(k4)) {
            return null;
        }
        try {
            return Base64.encodeToString((longValue + ":" + k4 + ":" + str2).getBytes(), 10);
        } catch (Exception unused) {
            cn.jiguang.bq.d.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    public static String a(String str) {
        try {
            return cn.jiguang.cn.g.b(str, cn.jiguang.cn.b.a(), cn.jiguang.cn.b.f3474a);
        } catch (Throwable unused) {
            cn.jiguang.bq.d.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i4, int i5) {
        ArrayList<JSONArray> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            if (jSONArray.length() == 1) {
                arrayList.add(jSONArray);
                return arrayList;
            }
            JSONArray jSONArray2 = new JSONArray();
            int i6 = 0;
            int i7 = 0;
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                JSONObject optJSONObject = jSONArray.optJSONObject(length);
                try {
                    int b4 = cn.jiguang.f.d.b(optJSONObject);
                    if (b4 != 0) {
                        int i8 = i6 + b4;
                        if (i8 > i5) {
                            break;
                        }
                        int i9 = i7 + b4;
                        if (i9 > i4) {
                            if (jSONArray2.length() > 0) {
                                arrayList.add(jSONArray2);
                            }
                            JSONArray jSONArray3 = new JSONArray();
                            try {
                                jSONArray3.put(optJSONObject);
                                jSONArray2 = jSONArray3;
                            } catch (Throwable th) {
                                th = th;
                                jSONArray2 = jSONArray3;
                                cn.jiguang.bq.d.i("ReportUtils", "partition exception:" + th);
                            }
                        } else {
                            jSONArray2.put(optJSONObject);
                            b4 = i9;
                        }
                        i7 = b4;
                        i6 = i8;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
        }
        return arrayList;
    }

    public static LinkedHashSet<String> a(Context context, Set<String> set) {
        String[] split;
        StringBuilder sb;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        LinkedList<String> c4 = c();
        if (JCoreManager.isTestEnv() && c4 != null) {
            linkedHashSet.addAll(c4);
            return linkedHashSet;
        }
        Set<String> b4 = cn.jiguang.bs.a.a().b(context).b(set);
        if (b4 != null) {
            for (String str : b4) {
                if (!TextUtils.isEmpty(str)) {
                    linkedHashSet.add(str);
                }
            }
        }
        String str2 = a.C0049a.f2215d;
        Iterator<String> it = c4.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                linkedHashSet.add(str2 + next);
            }
        }
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(true));
        if (!TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                if (!cn.jiguang.f.g.f(str4)) {
                    if (!cn.jiguang.f.g.g(str4)) {
                        sb = new StringBuilder();
                    } else if (!f2872i) {
                        sb = new StringBuilder();
                    }
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                } else if (f2872i) {
                    sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str4);
                    linkedHashSet.add(sb.toString());
                }
            }
        }
        LinkedHashSet<String> a4 = cn.jiguang.f.i.a(context, linkedHashSet);
        cn.jiguang.bq.d.c("ReportUtils", "types=" + set + " find after urls=" + a4);
        return a4;
    }

    public static Set<String> a(JSONObject jSONObject) {
        return jSONObject == null ? new HashSet() : c(jSONObject.optJSONArray("content"));
    }

    public static JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
            if (longValue == 0) {
                cn.jiguang.bq.d.i("ReportUtils", "miss uid when wrap container info");
                return null;
            }
            jSONObject.put("uid", longValue);
            String e4 = cn.jiguang.d.a.e(context);
            if (cn.jiguang.f.g.a(e4)) {
                cn.jiguang.bq.d.l("ReportUtils", "miss app_key when wrap container info");
                return null;
            }
            jSONObject.put("app_key", e4);
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
            jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f2010b);
            String g4 = cn.jiguang.d.a.g(context);
            if (cn.jiguang.f.g.a(g4)) {
                cn.jiguang.bq.d.j("ReportUtils", "miss channel when wrap container info,but continue report...");
            } else {
                jSONObject.put("channel", g4);
            }
            Pair<String, Long> c4 = cn.jiguang.c.b.c(context);
            if (c4 == null || cn.jiguang.f.g.a((String) c4.first)) {
                cn.jiguang.bq.d.j("ReportUtils", "miss app version when wrap container info,but continue report...");
            } else {
                jSONObject.put("app_version", c4.first);
            }
            String m4 = cn.jiguang.f.a.m(context);
            if (TextUtils.isEmpty(m4)) {
                m4 = h.c(context);
            }
            if (!TextUtils.isEmpty(m4)) {
                jSONObject.put("network_type", m4);
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReportUtils", "wrapContainerInfo exception:" + th);
            return null;
        }
    }

    private static JSONObject a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("content", jSONArray);
        } catch (JSONException unused) {
        }
        cn.jiguang.f.d.a(jSONObject2, jSONObject);
        return jSONObject2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
        if (android.text.TextUtils.isEmpty(r10) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r2, int r3, org.json.JSONObject r4, byte[] r5, int r6, java.io.File r7, java.util.Set<java.lang.String> r8, cn.jiguang.api.ReportCallBack r9, java.lang.String r10) {
        /*
            java.lang.String r4 = "ReportUtils"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b
            r0.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = "onTcpReportResult, types="
            r0.append(r1)     // Catch: java.lang.Throwable -> L5b
            r0.append(r8)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r1 = " code="
            r0.append(r1)     // Catch: java.lang.Throwable -> L5b
            r0.append(r3)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5b
            cn.jiguang.bq.d.c(r4, r0)     // Catch: java.lang.Throwable -> L5b
            r4 = -3
            if (r3 == r4) goto L42
            if (r3 == 0) goto L39
            int r3 = a(r2, r5, r6, r8)     // Catch: java.lang.Throwable -> L5b
            if (r3 != 0) goto L4f
            boolean r2 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L35
        L31:
            cn.jiguang.f.c.a(r7)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L35:
            c(r10)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L39:
            boolean r2 = cn.jiguang.internal.JConstants.DEBUG_MODE     // Catch: java.lang.Throwable -> L5b
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L35
            goto L31
        L42:
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5b
            r5 = 0
            java.lang.String r6 = cn.jiguang.d.a.e(r2)     // Catch: java.lang.Throwable -> L5b
            r4[r5] = r6     // Catch: java.lang.Throwable -> L5b
            cn.jiguang.bs.d.a(r2, r4)     // Catch: java.lang.Throwable -> L5b
        L4f:
            if (r9 == 0) goto L54
            r9.onFinish(r3)
        L54:
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L6a
            goto L67
        L5b:
            if (r9 == 0) goto L61
            r9.onFinish(r3)
        L61:
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L6a
        L67:
            cn.jiguang.bs.d.a(r7)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bs.f.a(android.content.Context, int, org.json.JSONObject, byte[], int, java.io.File, java.util.Set, cn.jiguang.api.ReportCallBack, java.lang.String):void");
    }

    public static void a(final Context context, final Object obj) {
        try {
            if (b(obj)) {
                cn.jiguang.cm.d.a("UPLOAD_REPORT", new cn.jiguang.cm.b("ReportUtils#report") { // from class: cn.jiguang.bs.f.1
                    @Override // cn.jiguang.cm.b
                    public void a() {
                        try {
                            JSONArray c4 = f.c(obj);
                            if (c4 != null) {
                                Set c5 = f.c(c4);
                                if (f.b((Set<String>) c5)) {
                                    f.c(context, c4, c5);
                                } else {
                                    f.d(context, c4, c5);
                                }
                            } else {
                                cn.jiguang.bq.d.c("ReportUtils", "data" + obj + " is empty");
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            } else {
                cn.jiguang.bq.d.c("ReportUtils", "data is invalid or empty");
            }
            d.b(context);
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("ReportUtils", "report e:" + th);
        }
    }

    public static void a(Context context, String str, Object obj) {
        try {
            cn.jiguang.bq.d.c("ReportUtils", "going to report data at push service");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("sdk_type", str);
            }
            if (b(obj)) {
                bundle.putString("report_data", obj.toString());
            }
            cn.jiguang.a.a.a(context, "a1", bundle);
        } catch (Throwable th) {
            try {
                cn.jiguang.bq.d.d("ReportUtils", "reportAtPushService", th);
            } catch (Throwable th2) {
                cn.jiguang.bq.d.d("ReportUtils", "reportAtPushService", th2);
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        b(context, jSONObject, reportCallBack);
    }

    private static void a(String str, JSONObject jSONObject, String str2) {
        Context appContext = JConstants.getAppContext(null);
        if (appContext == null) {
            return;
        }
        try {
            a aVar = new a(appContext, str2, str, jSONObject);
            f2877n.postDelayed(aVar, 500L);
            f2876m.put(aVar.f2883b, aVar);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        try {
            if (cn.jiguang.f.g.a(str)) {
                cn.jiguang.bq.d.c("ReportUtils", "file_name is null , give up save ");
                return false;
            } else if (context != null) {
                return cn.jiguang.f.c.c(cn.jiguang.f.c.a(context, str), jSONObject != null ? jSONObject.toString() : "");
            } else {
                cn.jiguang.bq.d.c("ReportUtils", "context is null , give up save " + str);
                return false;
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.c("ReportUtils", "writeLogFile e:" + th);
            return false;
        }
    }

    private static boolean a(Context context, Set<String> set, int i4, boolean z3) {
        return f2867d && ((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.k())).booleanValue() && i4 < (z3 ? 30650 : 30680) && set != null && !set.contains("crash_log") && !set.contains("operate_event");
    }

    private static Looper b() {
        HandlerThread handlerThread = new HandlerThread("jg_timer") { // from class: cn.jiguang.bs.f.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        return handlerThread.getLooper();
    }

    public static String b(String str) {
        try {
            return cn.jiguang.cn.g.b(str, cn.jiguang.cn.b.b(), cn.jiguang.cn.b.f3475b);
        } catch (Throwable unused) {
            cn.jiguang.bq.d.l("getBasicAuthorization", "basic authorization encode failed");
            return null;
        }
    }

    private static String b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("type");
        }
        return null;
    }

    private static JSONArray b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            if (optJSONObject != null && optJSONObject.length() > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    private static void b(Context context, JSONObject jSONObject, ReportCallBack reportCallBack) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    JSONObject a4 = a(context);
                    if (a4 == null) {
                        cn.jiguang.bq.d.l("ReportUtils", "wrap data failed");
                        if (reportCallBack != null) {
                            reportCallBack.onFinish(-1);
                        }
                    } else {
                        String b4 = b(jSONObject);
                        JSONObject a5 = a(new JSONArray().put(jSONObject), a4);
                        HashSet hashSet = new HashSet();
                        hashSet.add(b4);
                        a(context, hashSet, a5, null, reportCallBack);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("ReportUtils", "reportWithoutStore exception:" + th);
            }
        }
        d.b(context);
    }

    private static boolean b(Object obj) {
        return obj instanceof String ? ((String) obj).length() > 2 : obj instanceof JSONObject ? ((JSONObject) obj).length() > 0 : (obj instanceof JSONArray) && b((JSONArray) obj).length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Set<String> set) {
        if (set == null) {
            return false;
        }
        return set.contains(PushSA.REPORT_ACTIVE_LAUNCH) || set.contains(PushSA.REPORT_ACTIVE_TERMINATE) || set.contains("sdk_type") || set.contains("android_notification_state") || set.contains("operate_event");
    }

    private static LinkedList<String> c() {
        return f2878o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set<String> c(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String b4 = b(jSONArray.optJSONObject(i4));
                if (b4 == null) {
                    b4 = "";
                }
                hashSet.add(b4);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:3:0x0001, B:16:0x0037, B:18:0x003d, B:9:0x0020, B:11:0x0024, B:12:0x002e, B:14:0x0032), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray c(java.lang.Object r3) {
        /*
            r0 = 0
            boolean r1 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L20
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Le
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Le
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Le
            goto L37
        Le:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L36
            r1.<init>()     // Catch: java.lang.Throwable -> L36
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L36
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L36
            org.json.JSONArray r3 = r1.put(r2)     // Catch: java.lang.Throwable -> L36
            r1 = r3
            goto L37
        L20:
            boolean r1 = r3 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L2e
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L44
            org.json.JSONArray r1 = r1.put(r3)     // Catch: java.lang.Throwable -> L44
            goto L37
        L2e:
            boolean r1 = r3 instanceof org.json.JSONArray     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto L36
            r1 = r3
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch: java.lang.Throwable -> L44
            goto L37
        L36:
            r1 = r0
        L37:
            org.json.JSONArray r3 = b(r1)     // Catch: java.lang.Throwable -> L44
            if (r3 == 0) goto L5b
            int r1 = r3.length()     // Catch: java.lang.Throwable -> L44
            if (r1 <= 0) goto L5b
            return r3
        L44:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "adapt JSONArray e:"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            java.lang.String r1 = "ReportUtils"
            cn.jiguang.bq.d.i(r1, r3)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bs.f.c(java.lang.Object):org.json.JSONArray");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a4 = cn.jiguang.bs.a.a().a(context).a(set);
            JSONObject a5 = a(context);
            boolean z3 = a5 != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(a4);
            sb.append(str);
            sb.append(z3 ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                JSONObject a6 = a(it.next(), a5);
                File a7 = d.a(context, sb2, a6, z3);
                if (z3) {
                    a(context, set, a6, a7, null);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("ReportUtils", "report exception:" + th);
        }
    }

    private static void c(String str) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = f2876m.get(str)) == null) {
            return;
        }
        if (SystemClock.elapsedRealtime() - aVar.f2887f > 500) {
            File file = aVar.f2886e;
            if (file != null) {
                cn.jiguang.f.c.a(file);
            }
            d.a(aVar.f2886e);
        } else {
            f2877n.removeCallbacks(aVar);
        }
        f2876m.remove(aVar.f2883b);
    }

    private static boolean c(Set<String> set) {
        return set.contains("sdk_jid") && set.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, JSONArray jSONArray, Set<String> set) {
        try {
            String a4 = cn.jiguang.bs.a.a().a(context).a(set);
            JSONObject a5 = a(context);
            boolean z3 = a5 != null;
            StringBuilder sb = new StringBuilder();
            String str = File.separator;
            sb.append(str);
            sb.append(a4);
            sb.append(str);
            sb.append(z3 ? "tmp" : "nowrap");
            String sb2 = sb.toString();
            Iterator<JSONArray> it = a(jSONArray, 40960, 204800).iterator();
            while (it.hasNext()) {
                JSONObject a6 = a(it.next(), a5);
                if (z3) {
                    String uuid = UUID.randomUUID().toString();
                    a(sb2, a6, uuid);
                    a(context, set, a6, null, null, uuid);
                } else {
                    d.a(context, sb2, a6, false);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("ReportUtils", "report exception:" + th);
        }
    }
}
