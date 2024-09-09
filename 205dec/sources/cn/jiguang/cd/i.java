package cn.jiguang.cd;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3305a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f3306b;

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f3307c;

    /* renamed from: d  reason: collision with root package name */
    private static AtomicBoolean f3308d;

    /* renamed from: e  reason: collision with root package name */
    private static LinkedList<String> f3309e;

    static {
        String b4 = cn.jiguang.cn.d.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 107, 115, 34, 85, 23, 44, 108, 35, 63, 90, 80, 108, 123, 126, 63, 83, 78, 54, Byte.MAX_VALUE, Byte.MAX_VALUE, 62, 64, 76, 105, 48, 124, 33, 91});
        f3305a = b4;
        String b5 = cn.jiguang.cn.d.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 59, 120, 64, 86, 47, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, 31, 87, 112, 39, 102, 125, 64, 24, 115, 56, 125});
        f3306b = b5;
        f3307c = new AtomicBoolean(false);
        f3308d = new AtomicBoolean(false);
        LinkedList<String> linkedList = new LinkedList<>();
        f3309e = linkedList;
        linkedList.clear();
        f3309e.add(b4);
        f3309e.add(b5);
    }

    public static void a(final Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ay())).longValue();
        cn.jiguang.bq.d.c("SentryEntryHelper", "currentTime is : " + currentTimeMillis + ", lastTime is : " + longValue);
        if (currentTimeMillis - longValue > 86400000) {
            cn.jiguang.cm.d.a("FUTURE_TASK", new cn.jiguang.cm.b() { // from class: cn.jiguang.cd.i.1
                @Override // cn.jiguang.cm.b
                public void a() {
                    JSONObject b4 = i.b(context);
                    if (i.f3308d.get()) {
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.ay().a((cn.jiguang.g.a<Long>) Long.valueOf(currentTimeMillis)));
                        if (b4 != null) {
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.az().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(b4.optBoolean("crash_switch", false))));
                            i.f3307c.set(b4.optBoolean("crash_switch", false));
                            cn.jiguang.cf.c.a().a(context, b4.optBoolean("net_switch", true));
                            cn.jiguang.bv.c.a(context, b4.optBoolean("use_tcp_ssl", false));
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.j().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(b4.optBoolean("count_switch", true))));
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.k().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(b4.optBoolean("android_tcpreport_switch", true))));
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.l().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(b4.optBoolean("net_length_switch", true))));
                            long optLong = b4.optLong("net_count_threshold");
                            if (optLong < 0) {
                                optLong = cn.jiguang.cf.b.f3374b;
                            }
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.m().a((cn.jiguang.g.a<Long>) Long.valueOf(optLong)));
                            long optLong2 = b4.optLong("net_conn_count_threshold");
                            if (optLong2 < 0) {
                                optLong2 = cn.jiguang.cf.b.f3376d;
                            }
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.o().a((cn.jiguang.g.a<Long>) Long.valueOf(optLong2)));
                            long optLong3 = b4.optLong("net_length_threshold");
                            long j4 = optLong3 > 0 ? optLong3 * 1024 * 1024 : cn.jiguang.cf.b.f3373a;
                            long optLong4 = b4.optLong("net_conn_length_threshold");
                            long j5 = optLong4 > 0 ? optLong4 * 1024 * 1024 : cn.jiguang.cf.b.f3373a;
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.n().a((cn.jiguang.g.a<Long>) Long.valueOf(j4)));
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.p().a((cn.jiguang.g.a<Long>) Long.valueOf(j5)));
                        }
                        i.d(context);
                    }
                }
            });
        } else {
            f3307c.set(((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.az())).booleanValue());
            d(context);
            cn.jiguang.cf.c.a().a(context);
        }
        cn.jiguang.cf.a.a().a(context);
        cn.jiguang.cf.b.a().a(context);
    }

    public static boolean a() {
        return f3307c.get();
    }

    public static JSONObject b(Context context) {
        f3308d.set(false);
        try {
        } finally {
            try {
                return null;
            } finally {
            }
        }
        if (cn.jiguang.f.a.e(context)) {
            String a4 = cn.jiguang.bk.a.a(context);
            if (!TextUtils.isEmpty(a4)) {
                cn.jiguang.f.g.a(context, f3309e);
                Iterator<String> it = f3309e.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("platform", "a");
                    jSONObject.put("app_key", a4);
                    jSONObject.put("core_sdk_ver", cn.jiguang.a.a.f2010b);
                    jSONObject.put("os_ver", Integer.toString(Build.VERSION.SDK_INT));
                    String q3 = cn.jiguang.f.a.q(context);
                    if (TextUtils.isEmpty(q3)) {
                        q3 = "";
                    }
                    jSONObject.put("brand", q3);
                    cn.jiguang.bq.d.c("SentryEntryHelper", "url:" + next + ", param json:" + jSONObject.toString());
                    HttpRequest httpRequest = new HttpRequest(next);
                    httpRequest.setRequestProperty("Content-Type", "application/json");
                    httpRequest.setRequestProperty("Accept", "application/json");
                    httpRequest.setRequestProperty("X-Http-Platform", "android");
                    httpRequest.setRequestProperty("X-Http-Appkey", a4);
                    httpRequest.setRequestProperty("Charset", "UTF-8");
                    httpRequest.setBody(jSONObject.toString());
                    HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                    int responseCode = httpPost.getResponseCode();
                    cn.jiguang.bq.d.c("SentryEntryHelper", "responseCode:" + responseCode);
                    if (200 == responseCode) {
                        String responseBody = httpPost.getResponseBody();
                        cn.jiguang.bq.d.c("SentryEntryHelper", "responseBody:" + responseBody);
                        if (TextUtils.isEmpty(responseBody)) {
                            continue;
                        } else {
                            cn.jiguang.bq.d.c("SentryEntryHelper", "request sentry sample success,response body:" + responseBody);
                            JSONObject jSONObject2 = new JSONObject(responseBody);
                            if (jSONObject2.optInt("code") == 2000 && jSONObject2.optJSONObject("data") != null) {
                                return jSONObject2.optJSONObject("data");
                            }
                        }
                    }
                }
                return null;
            }
            cn.jiguang.bq.d.i("SentryEntryHelper", "request sentry sample failed because can't get appKey");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        if (a()) {
            h.a().a(context);
        }
        h.a().b();
        b.a(context);
    }
}
