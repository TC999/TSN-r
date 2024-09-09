package cn.jiguang.bf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.bj.d;
import cn.jiguang.bj.f;
import cn.jiguang.bj.h;
import cn.jiguang.bj.i;
import cn.jiguang.dy.b;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2591a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f2592b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2593c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f2594d;

    /* renamed from: e  reason: collision with root package name */
    private static c f2595e;

    /* renamed from: f  reason: collision with root package name */
    private static LinkedList<String> f2596f;

    /* renamed from: g  reason: collision with root package name */
    private static LinkedList<String> f2597g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2598h = true;

    /* renamed from: i  reason: collision with root package name */
    private String f2599i = "I7MUZXCPZWRFZAJS";

    /* renamed from: j  reason: collision with root package name */
    private String f2600j = "CBDHJXMDDVXH8THW";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f2602b;

        /* renamed from: c  reason: collision with root package name */
        private String f2603c;

        /* renamed from: d  reason: collision with root package name */
        private Context f2604d;

        /* renamed from: e  reason: collision with root package name */
        private b.a f2605e;

        public a(Context context, int i4, String str, b.a aVar) {
            this.f2604d = context;
            this.f2602b = i4;
            this.f2603c = str;
            this.f2605e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File a4 = c.this.a(this.f2604d, this.f2602b, this.f2603c);
                if (a4 == null) {
                    cn.jiguang.bi.b.b("UPM", "pluginFile is null");
                }
                b.a aVar = this.f2605e;
                if (aVar == null || aVar.a(a4)) {
                    c.this.a(this.f2604d, this.f2602b, System.currentTimeMillis());
                }
            } catch (Throwable th) {
                cn.jiguang.bi.b.e("UPM", "UpdateAction failed:" + th.getMessage());
            }
        }
    }

    static {
        String b4 = cn.jiguang.bh.a.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 114, 90, 67, 45, 123, 119});
        f2591a = b4;
        String b5 = cn.jiguang.bh.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 107, 124, 114, 4, 83, 120});
        f2592b = b5;
        String b6 = cn.jiguang.bh.a.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57, 117, 8, 78, 42, 96, 124});
        f2593c = b6;
        String b7 = cn.jiguang.bh.a.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54, 108, 46, Byte.MAX_VALUE, 3, 72, 115});
        f2594d = b7;
        f2596f = new LinkedList<>();
        f2597g = new LinkedList<>();
        f2596f.clear();
        f2597g.clear();
        f2596f.add(b4);
        f2596f.add(b5);
        f2597g.add(b6);
        f2597g.add(b7);
    }

    private c() {
    }

    public static c a() {
        if (f2595e == null) {
            synchronized (c.class) {
                if (f2595e == null) {
                    f2595e = new c();
                }
            }
        }
        return f2595e;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(android.content.Context r18, int r19, int r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bf.c.a(android.content.Context, int, int, java.lang.String):java.io.File");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [cn.jiguang.bf.c] */
    /* JADX WARN: Type inference failed for: r2v37, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v17, types: [int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public File a(Context context, int i4, String str) {
        int i5;
        int i6;
        int i7;
        StringBuilder sb;
        int a4;
        int i8;
        JSONObject jSONObject;
        String a5;
        int i9;
        StringBuilder sb2;
        Object obj;
        Object obj2;
        String jSONObject2;
        String a6;
        int i10 = context;
        try {
            cn.jiguang.bi.b.b("UPM", "u p:" + i4 + ",url:" + str);
            a4 = a(context, i4);
            try {
                jSONObject = new JSONObject();
                jSONObject.put(cn.jiguang.dy.a.f3580h, i4);
                jSONObject.put(cn.jiguang.dy.a.f3581i, a4);
                a5 = cn.jiguang.bf.a.a(i4, 4);
                try {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                i8 = a4;
            }
        } catch (Throwable th3) {
            th = th3;
            i5 = i4;
            i6 = -1;
        }
        if (!TextUtils.isEmpty(a5)) {
            jSONObject.put(cn.jiguang.dy.a.f3582j, Integer.parseInt(a5));
            cn.jiguang.dy.c a7 = cn.jiguang.dy.c.a();
            cn.jiguang.bg.a aVar = cn.jiguang.bg.a.f2612g;
            a7.a(context, i4, a4, aVar, 0, null);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            long a8 = f.a(context);
            Object a9 = h.a(context);
            Object b4 = h.b(context);
            PackageInfo a10 = f.a(i10, 0);
            String str2 = "";
            if (a10 != null) {
                try {
                    obj = a10.versionName;
                } catch (Throwable th4) {
                    th = th4;
                    i6 = a4;
                    i5 = i4;
                    try {
                        cn.jiguang.bi.b.f("UPM", "sU error:" + th.getMessage());
                        cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2612g, 2, th.getMessage());
                        sb = new StringBuilder();
                        i7 = i5;
                        sb.append("pI:");
                        sb.append(i7);
                        sb.append(" u finish");
                        cn.jiguang.bi.b.b("UPM", sb.toString());
                        return null;
                    } finally {
                        cn.jiguang.bi.b.b("UPM", "pI:" + i5 + " u finish");
                    }
                }
            } else {
                obj = "";
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                obj2 = "";
                str2 = context.getPackageManager().getApplicationLabel(applicationInfo).toString();
            } else {
                obj2 = "";
            }
            Object a11 = cn.jiguang.bj.a.a(context);
            if (a11 == null) {
                a11 = null;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(cn.jiguang.dy.a.f3583k, jSONArray);
                    try {
                        jSONObject3.put(cn.jiguang.dy.a.f3573a, System.currentTimeMillis());
                        String str3 = cn.jiguang.dy.a.f3574b;
                        if (a9 == null) {
                            a9 = obj2;
                        }
                        jSONObject3.put(str3, a9);
                        jSONObject3.put(cn.jiguang.dy.a.f3575c, a8);
                        String str4 = cn.jiguang.dy.a.f3576d;
                        if (b4 == null) {
                            b4 = obj2;
                        }
                        jSONObject3.put(str4, b4);
                        String str5 = cn.jiguang.dy.a.f3577e;
                        if (obj == null) {
                            obj = obj2;
                        }
                        jSONObject3.put(str5, obj);
                        jSONObject3.put(cn.jiguang.dy.a.f3578f, str2);
                        jSONObject3.put(cn.jiguang.dy.a.f3579g, context.getPackageName());
                        jSONObject3.put(cn.jiguang.dy.a.f3584l, a11 == null ? obj2 : a11);
                        cn.jiguang.bi.b.b("UPM", "u:" + str);
                        jSONObject2 = jSONObject3.toString();
                        cn.jiguang.bi.b.b("UPM", "request p :" + jSONObject2);
                        if (this.f2598h) {
                            try {
                                jSONObject2 = i.a(jSONObject3.toString().getBytes(), this.f2599i, this.f2600j);
                                cn.jiguang.bi.b.b("UPM", "request p after :" + jSONObject2);
                                if (TextUtils.isEmpty(jSONObject2)) {
                                    sb2 = new StringBuilder();
                                    sb2.append("pI:");
                                    i9 = i4;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                i10 = i4;
                                i6 = a4;
                                i5 = i10;
                                cn.jiguang.bi.b.f("UPM", "sU error:" + th.getMessage());
                                cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2612g, 2, th.getMessage());
                                sb = new StringBuilder();
                                i7 = i5;
                                sb.append("pI:");
                                sb.append(i7);
                                sb.append(" u finish");
                                cn.jiguang.bi.b.b("UPM", sb.toString());
                                return null;
                            }
                        }
                        i10 = i4;
                    } catch (Throwable th6) {
                        th = th6;
                        i10 = i4;
                    }
                    try {
                        a6 = a(context, str, jSONObject2);
                        cn.jiguang.bi.b.b("UPM", "request http response:" + a6);
                        if (this.f2598h) {
                            try {
                                if (!TextUtils.isEmpty(a6)) {
                                    String str6 = new String(i.a(a6, this.f2599i, this.f2600j));
                                    cn.jiguang.bi.b.b("UPM", "request http response after:" + str6);
                                    a6 = str6;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                i6 = a4;
                                i5 = i10;
                                cn.jiguang.bi.b.f("UPM", "sU error:" + th.getMessage());
                                cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2612g, 2, th.getMessage());
                                sb = new StringBuilder();
                                i7 = i5;
                                sb.append("pI:");
                                sb.append(i7);
                                sb.append(" u finish");
                                cn.jiguang.bi.b.b("UPM", sb.toString());
                                return null;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        i8 = a4;
                        i6 = i8;
                        i5 = i10;
                        cn.jiguang.bi.b.f("UPM", "sU error:" + th.getMessage());
                        cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2612g, 2, th.getMessage());
                        sb = new StringBuilder();
                        i7 = i5;
                        sb.append("pI:");
                        sb.append(i7);
                        sb.append(" u finish");
                        cn.jiguang.bi.b.b("UPM", sb.toString());
                        return null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    i10 = i4;
                    i8 = a4;
                }
            } catch (Throwable th10) {
                th = th10;
                i8 = a4;
                i10 = i4;
                i6 = i8;
                i5 = i10;
                cn.jiguang.bi.b.f("UPM", "sU error:" + th.getMessage());
                cn.jiguang.dy.c.a().a(context, i4, i6, cn.jiguang.bg.a.f2612g, 2, th.getMessage());
                sb = new StringBuilder();
                i7 = i5;
                sb.append("pI:");
                sb.append(i7);
                sb.append(" u finish");
                cn.jiguang.bi.b.b("UPM", sb.toString());
                return null;
            }
            if (TextUtils.isEmpty(a6)) {
                cn.jiguang.dy.c.a().a(context, i4, a4, aVar, 2, "config response is empty");
                sb = new StringBuilder();
                i7 = i10;
                sb.append("pI:");
                sb.append(i7);
                sb.append(" u finish");
                cn.jiguang.bi.b.b("UPM", sb.toString());
                return null;
            }
            return a(context, i10, a4, a6);
        }
        i9 = i4;
        cn.jiguang.bi.b.b("UPM", "get l_version is null");
        sb2 = new StringBuilder();
        sb2.append("pI:");
        sb2.append(i9);
        sb2.append(" u finish");
        cn.jiguang.bi.b.b("UPM", sb2.toString());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0114 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.File a(android.content.Context r12, cn.jiguang.bg.c r13) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bf.c.a(android.content.Context, cn.jiguang.bg.c):java.io.File");
    }

    private String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            LinkedList<String> linkedList = this.f2598h ? f2597g : f2596f;
            if (f.d() && f.e() != null && f.e().size() > 0) {
                linkedList = f.e();
            }
            a(context, linkedList);
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                String b4 = b(context, it.next(), str2);
                if (!TextUtils.isEmpty(b4)) {
                    return b4;
                }
            }
        }
        return b(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i4, long j4) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cn.jiguang.prefs", 0).edit();
            edit.putLong("plugin_update_time_" + i4, j4).apply();
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, List<String> list) {
        if (!f.c(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    private void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        file.delete();
    }

    private boolean a(cn.jiguang.bg.c cVar, Context context) {
        cn.jiguang.bi.b.b("UPM", "c nU l p...");
        File a4 = cn.jiguang.bf.a.a(context, cVar, true);
        cn.jiguang.bi.b.b("UPM", "pII:" + a4);
        if (a4 != null) {
            cn.jiguang.bf.a.a(context, cVar.f2641m, cVar.f2652x, false);
            cn.jiguang.bi.b.b("UPM", "p has exist, p is:" + a4.getAbsolutePath());
            return false;
        }
        return true;
    }

    private String b(Context context, String str, String str2) {
        return d.a(context, str, 10000, str2);
    }

    private boolean b(Context context, int i4) {
        boolean z3 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jiguang.prefs", 0);
        long j4 = sharedPreferences.getLong("plugin_update_time_" + i4, 0L);
        StringBuilder sb = new StringBuilder();
        sb.append("plugin_update_interval_");
        sb.append(i4);
        z3 = (j4 <= 0 || System.currentTimeMillis() > sharedPreferences.getLong(sb.toString(), 86400000L) + j4) ? true : true;
        if (!z3) {
            cn.jiguang.bi.b.b("UPM", "no need update, last is " + cn.jiguang.bj.b.a(j4));
        }
        return z3;
    }

    private void c(Context context, int i4) {
        a(cn.jiguang.bf.a.a(context, i4));
    }

    public int a(Context context, int i4) {
        cn.jiguang.bg.c b4 = cn.jiguang.bf.a.b(context, i4);
        if (cn.jiguang.bf.a.a(context, i4) == null) {
            try {
                return Integer.parseInt(cn.jiguang.bf.a.a(i4, 4));
            } catch (Throwable unused) {
                return -1;
            }
        }
        return b4.f2643o;
    }

    public void a(Context context, int i4, String str, b.a aVar) {
        if (b(context, i4)) {
            f.a(context, JConstants.SDK_TYPE, 76, null, null, new a(context, i4, str, aVar));
        }
    }
}
