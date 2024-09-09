package cn.jiguang.bs;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ah.a;
import cn.jiguang.f.h;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static a f2856a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile FutureTask<?> f2857b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2858c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final LinkedHashSet<String> f2859d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f2860e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f2861f;

    /* renamed from: g  reason: collision with root package name */
    private static final LinkedHashSet<String> f2862g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class a extends cn.jiguang.cm.b {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2863a;

        private a(Context context) {
            this.f2863a = context;
            this.f3462h = "SisTask";
        }

        @Override // cn.jiguang.cm.b
        public void a() {
            try {
                String c4 = e.c(this.f2863a);
                LinkedHashSet d4 = e.d(this.f2863a);
                d4.addAll(e.a());
                LinkedHashSet<String> a4 = i.a(this.f2863a, d4);
                cn.jiguang.bq.d.c("ReportSis", "sis urls=" + a4.toString() + " post json=" + c4);
                if (!cn.jiguang.f.a.e(this.f2863a)) {
                    cn.jiguang.bq.d.i("ReportSis", "give up sis, because network is not connected");
                    return;
                }
                Iterator<String> it = a4.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        if (Build.VERSION.SDK_INT >= 28 && !next.startsWith(a.C0049a.f2215d)) {
                            cn.jiguang.bq.d.i("ReportSis", "won't use http at device since 28");
                        } else if (e.b(this.f2863a, next, c4)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    static {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        f2859d = linkedHashSet;
        String b4 = cn.jiguang.cn.d.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 68, 83, 112, 123, 56, 123, 64, 85, 106, 96, 56, 114, 94});
        f2860e = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{96, 98, 101, 64, 83, 35, 39, 57, 101, 67, 73, 106, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120});
        f2861f = b5;
        linkedHashSet.add(b4);
        linkedHashSet.add(b5);
        f2862g = new LinkedHashSet<>();
    }

    public static LinkedHashSet<String> a() {
        if (JConstants.isTestEnv()) {
            LinkedHashSet<String> linkedHashSet = f2862g;
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
        }
        return f2859d;
    }

    public static void a(Context context, boolean z3) {
        String str;
        StringBuilder sb;
        if (f2856a == null) {
            f2856a = new a(context);
        }
        if (f2857b == null || f2857b.isCancelled() || f2857b.isDone()) {
            synchronized (f2858c) {
                if (f2857b == null || f2857b.isCancelled() || f2857b.isDone()) {
                    f2857b = new FutureTask<>(f2856a, null);
                    cn.jiguang.cm.d.a("FUTURE_TASK", f2857b);
                }
            }
        }
        if (z3) {
            try {
                f2857b.get(10L, TimeUnit.SECONDS);
            } catch (InterruptedException e4) {
                e = e4;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bq.d.i(str, sb.toString());
            } catch (ExecutionException e5) {
                e = e5;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bq.d.i(str, sb.toString());
            } catch (TimeoutException e6) {
                e = e6;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bq.d.i(str, sb.toString());
            } catch (Throwable th) {
                e = th;
                str = "ReportSis";
                sb = new StringBuilder();
                sb.append("sis task e:");
                sb.append(e);
                cn.jiguang.bq.d.i(str, sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        g a4 = b.a(str, str2, context, true, 3, 2);
        cn.jiguang.bq.d.c("ReportSis", "report sis code[" + a4.a() + "] from url=" + str + "\n body=" + a4.b());
        if (a4.a() == 0) {
            String b4 = a4.b();
            if (TextUtils.isEmpty(b4)) {
                return false;
            }
            try {
                cn.jiguang.bs.a.a().a(context, new JSONObject(b4).getJSONObject("ret"));
                return true;
            } catch (Throwable th) {
                cn.jiguang.bq.d.i("ReportSis", "getUrls e:" + th);
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context) {
        long j4;
        Object a4;
        double d4;
        double d5;
        JSONObject jSONObject = new JSONObject();
        try {
            String e4 = cn.jiguang.d.a.e(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.x())).longValue();
            int a5 = h.a(context);
            String b4 = h.b(context);
            jSONObject.put("type", a5);
            jSONObject.put("appkey", e4);
            jSONObject.put("sdkver", cn.jiguang.a.a.f2010b);
            jSONObject.put("platform", 0);
            j4 = 0;
            if (longValue != 0) {
                jSONObject.put("uid", longValue);
            }
            if (b4 != null) {
                jSONObject.put("opera", b4);
            }
            a4 = cn.jiguang.bx.e.a(context, "get_loc_info", null);
            d4 = 200.0d;
        } catch (Throwable unused) {
        }
        if (a4 instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) a4;
                double d6 = bundle.getDouble("lat");
                try {
                    d4 = bundle.getDouble("lot");
                    j4 = bundle.getLong("time");
                } catch (Throwable unused2) {
                }
                double d7 = d4;
                d4 = d6;
                d5 = d7;
            } catch (Throwable unused3) {
            }
            if (d4 > -90.0d && d4 < 90.0d && d5 > -180.0d && d5 < 180.0d) {
                jSONObject.put("lat", d4);
                jSONObject.put("lng", d5);
                jSONObject.put("time", j4);
            }
            return jSONObject.toString();
        }
        d5 = 200.0d;
        if (d4 > -90.0d) {
            jSONObject.put("lat", d4);
            jSONObject.put("lng", d5);
            jSONObject.put("time", j4);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashSet<String> d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.R());
        if (TextUtils.isEmpty(str)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                linkedHashSet.add(jSONArray.optString(i4));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }
}
