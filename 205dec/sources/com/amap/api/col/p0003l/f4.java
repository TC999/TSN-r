package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.Cif;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: R8$$SyntheticClass */
/* renamed from: com.amap.api.col.3l.f4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class f4 {

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    final class a extends z7 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f7670a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7671b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f7672c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7673d;

        a(String str, String str2, String str3, String str4) {
            this.f7670a = str;
            this.f7671b = str2;
            this.f7672c = str3;
            this.f7673d = str4;
        }

        public final void runTask() {
            e eVar = (e) f4.V().get(this.f7670a);
            if (eVar == null) {
                return;
            }
            b bVar = eVar.f7694c;
            c b4 = f4.b(f4.g, eVar.f7692a, eVar.f7693b, this.f7671b, this.f7672c, this.f7673d);
            if (b4 == null || bVar == null) {
                return;
            }
            bVar.a(b4);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$b */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface b {
        void a(c cVar);
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$c */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class c {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f7674a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f7675b;

        /* renamed from: c  reason: collision with root package name */
        public String f7676c;

        /* renamed from: d  reason: collision with root package name */
        public int f7677d = -1;

        /* renamed from: e  reason: collision with root package name */
        public long f7678e = 0;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f7679f;

        /* renamed from: g  reason: collision with root package name */
        public a f7680g;

        /* renamed from: h  reason: collision with root package name */
        public b f7681h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f7682i;

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.f4$c$a */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public boolean f7683a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f7684b;

            /* renamed from: c  reason: collision with root package name */
            public JSONObject f7685c;
        }

        /* compiled from: AuthConfigManager.java */
        /* renamed from: com.amap.api.col.3l.f4$c$b */
        /* loaded from: E:\TSN-r\205dec\6276784.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public boolean f7686a;
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$d */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    static class d extends q6 {

        /* renamed from: i  reason: collision with root package name */
        private String f7687i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, String> f7688j;

        /* renamed from: k  reason: collision with root package name */
        private String f7689k;

        /* renamed from: p  reason: collision with root package name */
        private String f7690p;

        /* renamed from: q  reason: collision with root package name */
        private String f7691q;

        /* JADX WARN: Multi-variable type inference failed */
        d(Context context, o4 o4Var, String str, Map<String, String> map, String str2, String str3, String str4) {
            super(context, o4Var);
            this.f7687i = str;
            this.f7688j = map;
            this.f7689k = str2;
            this.f7690p = str3;
            this.f7691q = str4;
            setHttpProtocol(Cif.c.HTTPS);
            setDegradeAbility(Cif.a.FIX);
        }

        private static String m(String str, String str2) {
            try {
                return !TextUtils.isEmpty(str2) ? Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (Throwable unused) {
                return str;
            }
        }

        public final byte[] c() {
            return null;
        }

        public final byte[] d() {
            String Z = h4.Z(((q6) this).a);
            if (!TextUtils.isEmpty(Z)) {
                Z = l4.d(new StringBuilder(Z).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", TextUtils.isEmpty(this.f7687i) ? "" : this.f7687i);
            hashMap.put("plattype", "android");
            hashMap.put("ccver", "1");
            hashMap.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, ((q6) this).b.a());
            hashMap.put("version", ((q6) this).b.e());
            hashMap.put("output", "json");
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", Z);
            hashMap.put("manufacture", Build.MANUFACTURER);
            Map<String, String> map = this.f7688j;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.f7688j);
            }
            hashMap.put("abitype", p4.d(((q6) this).a));
            hashMap.put("ext", ((q6) this).b.g());
            return p4.o(p4.f(hashMap));
        }

        protected final String e() {
            return "3.0";
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected final String getIPDNSName() {
            if (!TextUtils.isEmpty(this.f7691q)) {
                return this.f7691q;
            }
            return super/*com.amap.api.col.3l.if*/.getIPDNSName();
        }

        public final String getIPV6URL() {
            return m("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.f7690p);
        }

        public final Map<String, String> getRequestHead() {
            if (TextUtils.isEmpty(this.f7691q)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host", this.f7691q);
            return hashMap;
        }

        public final String getURL() {
            return m("https://restsdk.amap.com/v3/iasdkauth", this.f7689k);
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$e */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class e {

        /* renamed from: a  reason: collision with root package name */
        o4 f7692a;

        /* renamed from: b  reason: collision with root package name */
        String f7693b;

        /* renamed from: c  reason: collision with root package name */
        b f7694c;

        private e() {
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$f */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private String f7695a;

        /* renamed from: b  reason: collision with root package name */
        private String f7696b;

        /* renamed from: c  reason: collision with root package name */
        private AtomicInteger f7697c;

        public f(String str, String str2, int i4) {
            this.f7695a = str;
            this.f7696b = str2;
            this.f7697c = new AtomicInteger(i4);
        }

        public static f d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new f(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (Throwable unused) {
                return null;
            }
        }

        public final int a() {
            AtomicInteger atomicInteger = this.f7697c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void c(String str) {
            this.f7696b = str;
        }

        public final String e() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("a", this.f7695a);
                jSONObject.put("f", this.f7696b);
                jSONObject.put("h", this.f7697c.get());
                return jSONObject.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$g */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f7698a = true;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f7699b = false;

        /* renamed from: c  reason: collision with root package name */
        public static boolean f7700c = true;

        /* renamed from: d  reason: collision with root package name */
        public static int f7701d;

        /* renamed from: e  reason: collision with root package name */
        public static boolean f7702e;

        /* renamed from: f  reason: collision with root package name */
        public static int f7703f;
    }

    /* compiled from: AuthConfigManager.java */
    /* renamed from: com.amap.api.col.3l.f4$h */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public long f7704a;

        /* renamed from: b  reason: collision with root package name */
        public String f7705b;

        h(Long l4, String str) {
            this.f7704a = 0L;
            this.f7705b = "";
            this.f7704a = l4.longValue();
            this.f7705b = str;
        }
    }

    public static /* synthetic */ void a(Object obj) {
        if (obj != null) {
            obj.toString();
        }
    }
}
