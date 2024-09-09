package cn.jiguang.ab;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.ag.h;
import cn.jiguang.ah.a;
import cn.jiguang.ah.d;
import cn.jiguang.ah.e;
import cn.jiguang.ao.c;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f2032a = "";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f2033b = "Android";

    /* renamed from: c  reason: collision with root package name */
    private static final String f2034c = c.b(new byte[]{88, 99, 23, 33, 91, 70, 122, 67, 18, 113, Byte.MAX_VALUE, 85, 75, 114, 108, 120});

    /* renamed from: d  reason: collision with root package name */
    private static final String f2035d = c.b(new byte[]{65, 8, 65, 72, 109, 123, 93, 64, 118, 122, 88, 68, 82, 67, 76, 43});

    /* renamed from: e  reason: collision with root package name */
    private static final String f2036e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f2037f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f2038g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f2039h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f2040i;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f2041j;

    /* renamed from: k  reason: collision with root package name */
    private static final byte[] f2042k;

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f2043l;

    /* renamed from: m  reason: collision with root package name */
    private static final String f2044m;

    /* renamed from: t  reason: collision with root package name */
    private static LinkedList<String> f2045t;

    /* renamed from: n  reason: collision with root package name */
    private String f2046n;

    /* renamed from: o  reason: collision with root package name */
    private String f2047o;

    /* renamed from: p  reason: collision with root package name */
    private String f2048p;

    /* renamed from: q  reason: collision with root package name */
    private Context f2049q;

    /* renamed from: r  reason: collision with root package name */
    private long f2050r;

    /* renamed from: s  reason: collision with root package name */
    private long f2051s;

    /* renamed from: cn.jiguang.ab.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private class C0047a extends e {
        private C0047a() {
        }

        @Override // cn.jiguang.ah.e
        public void a() {
            JSONObject optJSONObject;
            try {
                if (!d.m(a.this.f2049q)) {
                    cn.jiguang.w.a.b("JUaidManager", "current is not mobile net or net not connected, so return");
                } else if (d.u(a.this.f2049q)) {
                    cn.jiguang.w.a.b("JUaidManager", "device is root, no need request config");
                } else if (d.t(a.this.f2049q)) {
                    cn.jiguang.w.a.b("JUaidManager", "sdk is banned, no need request config");
                } else if (!a.this.d()) {
                    cn.jiguang.w.a.b("JUaidManager", "the next request time is not reached");
                } else {
                    JSONObject e4 = a.this.e();
                    if (e4 == null || (optJSONObject = e4.optJSONObject("data")) == null) {
                        return;
                    }
                    boolean optBoolean = optJSONObject.optBoolean("token_switch");
                    long optLong = optJSONObject.optLong("next_time") * 1000;
                    cn.jiguang.w.a.b("JUaidManager", "mSwitch=" + optBoolean + " internalTime=" + optLong);
                    boolean a4 = cn.jiguang.ar.c.a().a(2201);
                    boolean b4 = cn.jiguang.ar.c.a().b(2201);
                    a.this.a(optLong);
                    if (!(optBoolean && a4) && (!optBoolean || b4)) {
                        return;
                    }
                    a.this.b();
                }
            } catch (Throwable th) {
                cn.jiguang.w.a.b("JUaidManager", "Throwable e=" + th.getMessage());
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f2053a = new a();
    }

    static {
        String b4 = c.b(new byte[]{88, 84, 109, 120, 101, 43, 31, 15, 122, 109, 37, 116, 7, 21, 125, 61, 56, 123, 64, 85, 106, 96, 56, 114, 94, 15, 110, 97, 57});
        f2036e = b4;
        String b5 = c.b(new byte[]{121, 68, 84, 105, 123, 44, 62, 31, 67, 124, 59, 115, 38, 5, 68, 44, 37, Byte.MAX_VALUE, 97, 70, 22, 55, 98, 102, 100, 67, 72, 55, 107, 120, 62, 71, 73, 54});
        f2037f = b5;
        f2038g = c.b(new byte[]{121, 68, 84, 105, 50, 57, 62, 82, 68, 106, 37, 98, 116, 67, 84, 55, 98, 102, 100, 67, 72, 118, 105, 56, 114, 95, 77, 35, 48, 38, 62, 71, 73, 54});
        f2039h = c.b(new byte[]{126, 101, 68, 80, 106, 50, 57, 62, 89, 77, 126, 38, 124, 120, 87, 85, 120, 102, 113, 63, 83, 78, 54, 123, 98, 112, 68, 73, 122, 39, 101, 117, 91, 15, 108, 105, Byte.MAX_VALUE, 117, 31, 74, 112, 111, 99, 112, 94, 71, 55, 96, 98, 124, 92});
        f2040i = new byte[]{105, 120, 117, 66, 79, 112, 108, 56, 102, 85, 66, 114, 97, 98, 63, 103, 69, 123, 91, 115, 101, 68, 73, 119, 111, 101};
        f2041j = new byte[]{83, 124, 124, 87, 125, 92, 79, 110, 78, Byte.MAX_VALUE, 125, 85, 97, 122, 107, 115, 98, 67};
        f2042k = new byte[]{123, 115, 101, 122, 65, 111, 105, 69, 114, 66, 73, 105, 124, 83, Byte.MAX_VALUE, 81, 66, 117, 109, 114};
        f2043l = new byte[]{112, 84, 68, 83, 105, 96, 112, 67, 67, 107, 97, 102, 101, 121, 78, 109, 109, 100, 119, 81, 67, 124};
        f2044m = b4;
        LinkedList<String> linkedList = new LinkedList<>();
        f2045t = linkedList;
        linkedList.clear();
        f2045t.add(b4);
        f2045t.add(b5);
    }

    private a() {
        this.f2046n = f() + c.b(new byte[]{83, 110, 109, 122, 115, 70});
        this.f2047o = f() + c.b(new byte[]{67, 109, 60, 114, 120, 0});
        this.f2048p = f() + c.b(new byte[]{123, 125, 114, 120, 69, 82, 57});
        this.f2050r = 0L;
        this.f2051s = 604800000L;
    }

    public static a a() {
        return b.f2053a;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(cn.jiguang.ap.b.a(Base64.decode(str, 2), f2035d, f2034c, false));
        } catch (Throwable unused) {
            return "";
        }
    }

    private JSONObject a(String str, JSONObject jSONObject) {
        String optString;
        String upperCase;
        try {
            optString = jSONObject.optString("uid");
            String upperCase2 = h.d(d.g(this.f2049q)).toUpperCase();
            upperCase = h.d(optString + upperCase2).toUpperCase();
        } catch (Throwable th) {
            cn.jiguang.w.a.b("JUaidManager", "Throwable E=" + th);
        }
        if (TextUtils.isEmpty(upperCase)) {
            return null;
        }
        String encodeToString = Base64.encodeToString((optString + ":" + upperCase).getBytes(), 10);
        if (TextUtils.isEmpty(encodeToString)) {
            return null;
        }
        h.a(this.f2049q, f2045t);
        int i4 = 0;
        String str2 = str;
        boolean z3 = false;
        while (i4 < f2045t.size()) {
            if (!cn.jiguang.h.a.b(this.f2049q) || z3) {
                str2 = (z3 || i4 != f2045t.size() - 1) ? str : str.replace(f2036e, f2037f);
            } else {
                str2 = str2.replace(f2036e, f2037f);
                z3 = true;
            }
            cn.jiguang.w.a.b("JUaidManager", "url:" + str2 + ", param json:" + jSONObject.toString());
            cn.jiguang.ak.a aVar = new cn.jiguang.ak.a(str2);
            aVar.a("Content-Type", "application/json");
            aVar.a("Accept", "application/json");
            aVar.a("X-Http-Platform", "android");
            aVar.a("X-Http-Appkey", jSONObject.optString("appkey"));
            aVar.a("Authorization", "Basic " + encodeToString);
            aVar.a("Charset", "UTF-8");
            aVar.a(b(jSONObject.toString()));
            cn.jiguang.ak.b b4 = cn.jiguang.ak.c.b(this.f2049q, aVar);
            int b5 = b4.b();
            cn.jiguang.w.a.b("JUaidManager", "responseCode:" + b5);
            String a4 = b4.a();
            cn.jiguang.w.a.b("JUaidManager", "response:" + a4);
            if (200 == b5 && !TextUtils.isEmpty(a4)) {
                String a5 = a(a4);
                cn.jiguang.w.a.b("JUaidManager", "request success,response body:" + a5);
                JSONObject jSONObject2 = new JSONObject(a5);
                if (2000 == jSONObject2.optInt("code")) {
                    return jSONObject2;
                }
            }
            i4++;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4) {
        this.f2050r = System.currentTimeMillis();
        if (j4 <= 0) {
            j4 = 604800000;
        }
        SharedPreferences sharedPreferences = this.f2049q.getSharedPreferences("cn.jiguang.common", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("uaid_last_time", this.f2050r).putLong("uaid_internal_time", j4).apply();
        }
        this.f2051s = j4;
        cn.jiguang.w.a.b("JUaidManager", "save reqTime requestTime=" + this.f2050r + " next_time=" + this.f2051s);
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                cn.jiguang.w.a.b("JUaidManager", "reportToken paramJson is null ");
            } catch (Throwable unused) {
                return;
            }
        }
        if (b(jSONObject)) {
            cn.jiguang.w.a.b("JUaidManager", "start to reportToken paramJson=" + jSONObject);
            JSONObject a4 = a(this.f2047o, jSONObject);
            cn.jiguang.w.a.b("JUaidManager", "reportToken response=" + a4);
            cn.jiguang.w.a.b("JUaidManager", a4.optInt("code") == 2000 ? "reportToken success" : "reportToken fail");
        }
    }

    private String b(String str) {
        try {
            return Base64.encodeToString(cn.jiguang.ap.b.a(str.getBytes("UTF-8"), f2035d, f2034c, true), 2);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            JSONObject c4 = c();
            if (c4 == null) {
                return;
            }
            JSONObject optJSONObject = c4.optJSONObject("data");
            cn.jiguang.w.a.b("JUaidManager", "url dataJson:" + optJSONObject);
            String optString = optJSONObject.optString("url");
            cn.jiguang.w.a.b("JUaidManager", "url:" + optString);
            cn.jiguang.ak.b a4 = cn.jiguang.ak.c.a(this.f2049q, optString);
            cn.jiguang.w.a.b("JUaidManager", "token httpResponse:" + a4);
            if (a4 != null) {
                int b4 = a4.b();
                String a5 = a4.a();
                cn.jiguang.w.a.b("JUaidManager", "token code:" + b4);
                cn.jiguang.w.a.b("JUaidManager", "tokenResponse:" + a5);
                if (200 != b4 || TextUtils.isEmpty(a5)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(a5);
                if (jSONObject.optInt("result") == 0) {
                    String string = jSONObject.getString("data");
                    cn.jiguang.w.a.b("JUaidManager", "token:" + string);
                    JSONObject jSONObject2 = new JSONObject();
                    c(jSONObject2);
                    jSONObject2.put("ctData", string);
                    a(jSONObject2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean b(JSONObject jSONObject) {
        try {
            String b4 = d.b(this.f2049q);
            if (TextUtils.isEmpty(b4)) {
                cn.jiguang.w.a.f("JUaidManager", "appKey is null, no need req");
                return false;
            }
            long c4 = d.c(this.f2049q);
            if (0 == c4) {
                cn.jiguang.w.a.f("JUaidManager", "uid is 0,no need req");
                return false;
            }
            jSONObject.put("appkey", b4);
            jSONObject.put("uid", c4);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private JSONObject c() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (b(jSONObject)) {
                c(jSONObject);
                jSONObject.put("core_sdk_ver", d.a());
                cn.jiguang.w.a.b("JUaidManager", "start to reqUrlInternal paramJson=" + jSONObject);
                return a(this.f2048p, jSONObject);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void c(JSONObject jSONObject) {
        if (cn.jiguang.ar.a.a().e(1014)) {
            jSONObject.put("os_ver", cn.jiguang.ag.a.v(this.f2049q));
        }
        jSONObject.put("platform", "a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        SharedPreferences sharedPreferences;
        if (0 == this.f2050r && (sharedPreferences = this.f2049q.getSharedPreferences("cn.jiguang.common", 0)) != null) {
            this.f2050r = sharedPreferences.getLong("uaid_last_time", 0L);
            this.f2051s = sharedPreferences.getLong("uaid_internal_time", 604800000L);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - this.f2050r);
        cn.jiguang.w.a.b("JUaidManager", "mLastRequestTime=" + this.f2050r + " next_time=" + this.f2051s + " currentTimeMillis=" + currentTimeMillis + " diffTime=" + abs);
        return abs >= this.f2051s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (b(jSONObject)) {
                c(jSONObject);
                jSONObject.put("core_sdk_ver", d.a());
                cn.jiguang.w.a.b("JUaidManager", "start to reqTokenSwitch paramJson=" + jSONObject);
                return a(this.f2046n, jSONObject);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String f() {
        String str = f2044m;
        if (!a.C0049a.f2212a || TextUtils.isEmpty(f2032a)) {
            return str;
        }
        cn.jiguang.w.a.b("JUaidManager", "use folder data config url :" + f2032a);
        return f2032a;
    }

    public void a(Context context) {
        this.f2049q = context;
    }

    public void b(Context context) {
        if (this.f2049q == null) {
            this.f2049q = context;
        }
        cn.jiguang.w.a.b("JUaidManager", "getUaidAsyn");
        d.b(new C0047a());
    }
}
