package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.n;
import com.amap.api.col.s.y0;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ManifestConfig.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s4 {

    /* renamed from: c  reason: collision with root package name */
    private static s4 f10219c;

    /* renamed from: d  reason: collision with root package name */
    private static Context f10220d;

    /* renamed from: e  reason: collision with root package name */
    public static i1 f10221e;

    /* renamed from: a  reason: collision with root package name */
    private b f10222a;

    /* renamed from: b  reason: collision with root package name */
    private HandlerThread f10223b = new a("manifestThread");

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ManifestConfig.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends HandlerThread {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: ManifestConfig.java */
        /* renamed from: com.amap.api.col.s.s4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        final class C0104a implements y0.b {
            C0104a() {
            }

            @Override // com.amap.api.col.s.y0.b
            public final void a(y0.c cVar) {
                b bVar;
                JSONObject jSONObject;
                JSONObject optJSONObject;
                JSONObject jSONObject2;
                JSONObject optJSONObject2;
                Message message = new Message();
                if (cVar != null) {
                    try {
                        y0.c.a aVar = cVar.f10511g;
                        if (aVar != null) {
                            message.obj = new t4(aVar.f10515b, aVar.f10514a);
                        }
                    } catch (Throwable th) {
                        try {
                            j4.i(th, "ManifestConfig", "run");
                            if (bVar == null) {
                                return;
                            }
                        } finally {
                            message.what = 3;
                            if (s4.this.f10222a != null) {
                                s4.this.f10222a.sendMessage(message);
                            }
                        }
                    }
                }
                if (cVar != null && (jSONObject2 = cVar.f10510f) != null && (optJSONObject2 = jSONObject2.optJSONObject("184")) != null) {
                    s4.l(optJSONObject2);
                    w.a(s4.f10220d, "amap_search", "cache_control", optJSONObject2.toString());
                }
                if (cVar != null && (jSONObject = cVar.f10510f) != null && (optJSONObject = jSONObject.optJSONObject("185")) != null) {
                    s4.k(optJSONObject);
                    w.a(s4.f10220d, "amap_search", "parm_control", optJSONObject.toString());
                }
                message.what = 3;
                if (s4.this.f10222a == null) {
                }
            }
        }

        a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Thread.currentThread().setName("ManifestConfigThread");
            i1 a4 = i4.a(false);
            s4.j(s4.f10220d);
            y0.g(s4.f10220d, a4, "11K;001;184;185", new C0104a());
            try {
                Thread.sleep(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ManifestConfig.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        String f10226a;

        public b(Looper looper) {
            super(looper);
            this.f10226a = "handleMessage";
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    t4 t4Var = (t4) message.obj;
                    if (t4Var == null) {
                        t4Var = new t4(false, false);
                    }
                    g2.g(s4.f10220d, i4.a(t4Var.a()));
                    s4.f10221e = i4.a(t4Var.a());
                } catch (Throwable th) {
                    j4.i(th, "ManifestConfig", this.f10226a);
                }
            }
        }
    }

    private s4(Context context) {
        f10220d = context;
        f10221e = i4.a(false);
        try {
            g();
            this.f10222a = new b(Looper.getMainLooper());
            this.f10223b.start();
        } catch (Throwable th) {
            j4.i(th, "ManifestConfig", "ManifestConfig");
        }
    }

    private static n.a b(JSONObject jSONObject, boolean z3, n.a aVar) {
        n.a aVar2;
        boolean optBoolean;
        n.a aVar3 = null;
        if (jSONObject != null) {
            try {
                aVar2 = new n.a();
                boolean z4 = false;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (z3) {
                    optBoolean = y0.u(jSONObject.optString("able"), (aVar == null || aVar.e()) ? true : true);
                } else {
                    optBoolean = jSONObject.optBoolean("able", (aVar == null || aVar.e()) ? true : true);
                }
                int optInt = jSONObject.optInt("timeoffset", aVar != null ? (int) aVar.f() : 86400);
                int optInt2 = jSONObject.optInt("num", aVar != null ? aVar.g() : 10);
                double optDouble = jSONObject.optDouble("limitDistance", aVar != null ? aVar.h() : 0.0d);
                aVar2.d(optBoolean);
                aVar2.c(optInt);
                aVar2.b(optInt2);
                aVar2.a(optDouble);
                return aVar2;
            } catch (Throwable th2) {
                th = th2;
                aVar3 = aVar2;
                th.printStackTrace();
                return aVar3;
            }
        }
        return null;
    }

    public static s4 d(Context context) {
        if (f10219c == null) {
            f10219c = new s4(context);
        }
        return f10219c;
    }

    private static void e(String str, JSONObject jSONObject, n.a aVar) {
        if (jSONObject != null && jSONObject.has(str)) {
            n.b().f(str, b(jSONObject.optJSONObject(str), false, aVar));
        }
    }

    private static void g() {
        m.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Context context) {
        try {
            String str = (String) w.b(context, "amap_search", "cache_control", "");
            if (!TextUtils.isEmpty(str)) {
                l(new JSONObject(str));
            }
            String str2 = (String) w.b(context, "amap_search", "parm_control", "");
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            k(new JSONObject(str2));
        } catch (Throwable th) {
            j4.i(th, "ManifestConfig", "ManifestConfig-readAuthFromCache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                boolean u3 = y0.u(jSONObject.optString("passAreaAble"), true);
                boolean u4 = y0.u(jSONObject.optString("truckAble"), true);
                boolean u5 = y0.u(jSONObject.optString("poiPageAble"), true);
                boolean u6 = y0.u(jSONObject.optString("rideAble"), true);
                boolean u7 = y0.u(jSONObject.optString("walkAble"), true);
                boolean u8 = y0.u(jSONObject.optString("passPointAble"), true);
                boolean u9 = y0.u(jSONObject.optString("keyWordLenAble"), true);
                int optInt = jSONObject.optInt("poiPageMaxSize", 25);
                int optInt2 = jSONObject.optInt("passAreaMaxCount", 100);
                int optInt3 = jSONObject.optInt("walkMaxLength", 100);
                int optInt4 = jSONObject.optInt("passPointMaxCount", 6);
                int optInt5 = jSONObject.optInt("poiPageMaxNum", 100);
                int optInt6 = jSONObject.optInt("truckMaxLength", 5000);
                int optInt7 = jSONObject.optInt("rideMaxLength", 1200);
                int optInt8 = jSONObject.optInt("passAreaMaxArea", 100000000);
                int optInt9 = jSONObject.optInt("passAreaPointCount", 16);
                int optInt10 = jSONObject.optInt("keyWordLenMaxNum", 100);
                q.a().h(u3);
                q.a().n(optInt2);
                q.a().z(optInt8);
                q.a().A(optInt9);
                q.a().m(u4);
                q.a().w(optInt6);
                q.a().p(u5);
                q.a().u(optInt5);
                q.a().b(optInt);
                q.a().i(optInt10);
                q.a().x(u9);
                q.a().r(u6);
                q.a().y(optInt7);
                q.a().t(u7);
                q.a().q(optInt3);
                q.a().v(u8);
                q.a().s(optInt4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has("able")) {
                    n.a b4 = b(jSONObject, true, null);
                    n.b().d(b4);
                    if (b4.e()) {
                        e("regeo", jSONObject, b4);
                        e("geo", jSONObject, b4);
                        e("placeText", jSONObject, b4);
                        e("placeAround", jSONObject, b4);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
