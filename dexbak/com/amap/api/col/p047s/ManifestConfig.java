package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p047s.C2212y0;
import com.amap.api.col.p047s.RequestCacheControl;
import com.amap.api.services.core.AMapException;
import com.github.mikephil.charting.utils.Utils;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.s4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ManifestConfig {

    /* renamed from: c */
    private static ManifestConfig f6491c;

    /* renamed from: d */
    private static Context f6492d;

    /* renamed from: e */
    public static C2073i1 f6493e;

    /* renamed from: a */
    private HandlerC2145b f6494a;

    /* renamed from: b */
    private HandlerThread f6495b = new HandlerThreadC2143a("manifestThread");

    /* compiled from: ManifestConfig.java */
    /* renamed from: com.amap.api.col.s.s4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class HandlerThreadC2143a extends HandlerThread {

        /* compiled from: ManifestConfig.java */
        /* renamed from: com.amap.api.col.s.s4$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        final class C2144a implements C2212y0.InterfaceC2214b {
            C2144a() {
            }

            @Override // com.amap.api.col.p047s.C2212y0.InterfaceC2214b
            /* renamed from: a */
            public final void mo52205a(C2212y0.C2215c c2215c) {
                HandlerC2145b handlerC2145b;
                JSONObject jSONObject;
                JSONObject optJSONObject;
                JSONObject jSONObject2;
                JSONObject optJSONObject2;
                Message message = new Message();
                if (c2215c != null) {
                    try {
                        C2212y0.C2215c.C2216a c2216a = c2215c.f6788g;
                        if (c2216a != null) {
                            message.obj = new ManifestResult(c2216a.f6792b, c2216a.f6791a);
                        }
                    } catch (Throwable th) {
                        try {
                            C2082j4.m52825i(th, "ManifestConfig", "run");
                            if (handlerC2145b == null) {
                                return;
                            }
                        } finally {
                            message.what = 3;
                            if (ManifestConfig.this.f6494a != null) {
                                ManifestConfig.this.f6494a.sendMessage(message);
                            }
                        }
                    }
                }
                if (c2215c != null && (jSONObject2 = c2215c.f6787f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                    ManifestConfig.m52452l(optJSONObject2);
                    C2190w.m52376a(ManifestConfig.f6492d, "amap_search", "cache_control", optJSONObject2.toString());
                }
                if (c2215c != null && (jSONObject = c2215c.f6787f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                    ManifestConfig.m52453k(optJSONObject);
                    C2190w.m52376a(ManifestConfig.f6492d, "amap_search", "parm_control", optJSONObject.toString());
                }
                message.what = 3;
                if (ManifestConfig.this.f6494a == null) {
                }
            }
        }

        HandlerThreadC2143a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            C2073i1 m52895a = C2077i4.m52895a(false);
            ManifestConfig.m52454j(ManifestConfig.f6492d);
            C2212y0.m52225g(ManifestConfig.f6492d, m52895a, "11K;001;184;185", new C2144a());
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: ManifestConfig.java */
    /* renamed from: com.amap.api.col.s.s4$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class HandlerC2145b extends Handler {

        /* renamed from: a */
        String f6498a;

        public HandlerC2145b(Looper looper) {
            super(looper);
            this.f6498a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    ManifestResult manifestResult = (ManifestResult) message.obj;
                    if (manifestResult == null) {
                        manifestResult = new ManifestResult(false, false);
                    }
                    C2060g2.m52980g(ManifestConfig.f6492d, C2077i4.m52895a(manifestResult.m52442a()));
                    ManifestConfig.f6493e = C2077i4.m52895a(manifestResult.m52442a());
                } catch (Throwable th) {
                    C2082j4.m52825i(th, "ManifestConfig", this.f6498a);
                }
            }
        }
    }

    private ManifestConfig(Context context) {
        f6492d = context;
        f6493e = C2077i4.m52895a(false);
        try {
            m52457g();
            this.f6494a = new HandlerC2145b(Looper.getMainLooper());
            this.f6495b.start();
        } catch (Throwable th) {
            C2082j4.m52825i(th, "ManifestConfig", "ManifestConfig");
        }
    }

    /* renamed from: b */
    private static RequestCacheControl.C2096a m52462b(JSONObject jSONObject, boolean z, RequestCacheControl.C2096a c2096a) {
        RequestCacheControl.C2096a c2096a2;
        boolean optBoolean;
        RequestCacheControl.C2096a c2096a3 = null;
        if (jSONObject != null) {
            try {
                c2096a2 = new RequestCacheControl.C2096a();
                boolean z2 = false;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (z) {
                    optBoolean = C2212y0.m52211u(jSONObject.optString("able"), (c2096a == null || c2096a.m52753e()) ? true : true);
                } else {
                    optBoolean = jSONObject.optBoolean("able", (c2096a == null || c2096a.m52753e()) ? true : true);
                }
                int optInt = jSONObject.optInt("timeoffset", c2096a != null ? (int) c2096a.m52752f() : 86400);
                int optInt2 = jSONObject.optInt("num", c2096a != null ? c2096a.m52751g() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", c2096a != null ? c2096a.m52750h() : Utils.DOUBLE_EPSILON);
                c2096a2.m52754d(optBoolean);
                c2096a2.m52755c(optInt);
                c2096a2.m52756b(optInt2);
                c2096a2.m52757a(optDouble);
                return c2096a2;
            } catch (Throwable th2) {
                th = th2;
                c2096a3 = c2096a2;
                th.printStackTrace();
                return c2096a3;
            }
        }
        return null;
    }

    /* renamed from: d */
    public static ManifestConfig m52460d(Context context) {
        if (f6491c == null) {
            f6491c = new ManifestConfig(context);
        }
        return f6491c;
    }

    /* renamed from: e */
    private static void m52459e(String str, JSONObject jSONObject, RequestCacheControl.C2096a c2096a) {
        if (jSONObject != null && jSONObject.has(str)) {
            RequestCacheControl.m52764b().m52760f(str, m52462b(jSONObject.optJSONObject(str), false, c2096a));
        }
    }

    /* renamed from: g */
    private static void m52457g() {
        RequestCacheConfig.m52774a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static void m52454j(Context context) {
        try {
            String str = (String) C2190w.m52375b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                m52452l(new JSONObject(str));
            }
            String str2 = (String) C2190w.m52375b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            m52453k(new JSONObject(str2));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static void m52453k(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean m52211u = C2212y0.m52211u(jSONObject.optString("passAreaAble"), true);
                boolean m52211u2 = C2212y0.m52211u(jSONObject.optString("truckAble"), true);
                boolean m52211u3 = C2212y0.m52211u(jSONObject.optString("poiPageAble"), true);
                boolean m52211u4 = C2212y0.m52211u(jSONObject.optString("rideAble"), true);
                boolean m52211u5 = C2212y0.m52211u(jSONObject.optString("walkAble"), true);
                boolean m52211u6 = C2212y0.m52211u(jSONObject.optString("passPointAble"), true);
                boolean m52211u7 = C2212y0.m52211u(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                RequestConfig.m52687a().m52680h(m52211u);
                RequestConfig.m52687a().m52674n(optInt2);
                RequestConfig.m52687a().m52662z(optInt8);
                RequestConfig.m52687a().m52690A(optInt9);
                RequestConfig.m52687a().m52675m(m52211u2);
                RequestConfig.m52687a().m52665w(optInt6);
                RequestConfig.m52687a().m52672p(m52211u3);
                RequestConfig.m52687a().m52667u(optInt5);
                RequestConfig.m52687a().m52686b(optInt);
                RequestConfig.m52687a().m52679i(optInt10);
                RequestConfig.m52687a().m52664x(m52211u7);
                RequestConfig.m52687a().m52670r(m52211u4);
                RequestConfig.m52687a().m52663y(optInt7);
                RequestConfig.m52687a().m52668t(m52211u5);
                RequestConfig.m52687a().m52671q(optInt3);
                RequestConfig.m52687a().m52666v(m52211u6);
                RequestConfig.m52687a().m52669s(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static void m52452l(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    RequestCacheControl.C2096a m52462b = m52462b(jSONObject, true, null);
                    RequestCacheControl.m52764b().m52762d(m52462b);
                    if (m52462b.m52753e()) {
                        m52459e("regeo", jSONObject, m52462b);
                        m52459e("geo", jSONObject, m52462b);
                        m52459e("placeText", jSONObject, m52462b);
                        m52459e("placeAround", jSONObject, m52462b);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
