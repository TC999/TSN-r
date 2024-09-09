package com.qq.e.comm.plugin.e0.d;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.h;
import com.qq.e.comm.plugin.m0.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.a2;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.s0;
import com.qq.e.comm.plugin.util.t0;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    private static volatile d f42786g;

    /* renamed from: a  reason: collision with root package name */
    private Context f42787a;

    /* renamed from: b  reason: collision with root package name */
    private volatile com.qq.e.comm.plugin.e0.e.c f42788b;

    /* renamed from: c  reason: collision with root package name */
    private int f42789c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicInteger f42790d;

    /* renamed from: e  reason: collision with root package name */
    private long f42791e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f42792f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f42793a;

        a(boolean z3) {
            this.f42793a = z3;
        }

        @Override // com.qq.e.comm.plugin.m0.a.i
        public void a() {
            d.this.a(this.f42793a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f42798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f42799d;

        c(boolean z3, boolean z4) {
            this.f42798c = z3;
            this.f42799d = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.f42798c, this.f42799d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.e0.d.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0807d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f42801c;

        RunnableC0807d(String str) {
            this.f42801c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.e0.d.c.b(d.this.f42787a, this.f42801c);
            d.this.c();
        }
    }

    private d(Context context) {
        this.f42787a = context.getApplicationContext();
        String a4 = com.qq.e.comm.plugin.e0.d.c.a(context);
        if (!TextUtils.isEmpty(a4)) {
            try {
                a(new JSONObject(a4));
            } catch (Exception e4) {
                d1.a("throw exception", e4);
                a(new JSONObject());
            }
        } else {
            a(new JSONObject());
        }
        this.f42789c = com.qq.e.comm.plugin.d0.a.d().f().a("lg_cfrto", 30) * 1000;
        this.f42790d = new AtomicInteger(com.qq.e.comm.plugin.d0.a.d().f().a("lg_cfrts", 2));
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3, boolean z4) {
        v.a(1231003, (com.qq.e.comm.plugin.n0.c) null);
        if (this.f42790d.getAndDecrement() > 0) {
            p0.a(new c(z3, z4), this.f42789c);
        }
    }

    public HashMap<String, String> b() {
        if (this.f42788b != null) {
            return this.f42788b.e();
        }
        return new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        d0.f46406b.execute(new RunnableC0807d(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!a() || this.f42788b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AdRequestConstant.AD_REQUEST_CONTEXT_EXT_APP_INSTALL_UPDATE_TIME_KEY, System.currentTimeMillis());
            List<com.qq.e.comm.plugin.e0.e.a> b4 = this.f42788b.b();
            JSONArray jSONArray = new JSONArray();
            if (b4 != null && b4.size() > 0) {
                for (com.qq.e.comm.plugin.e0.e.a aVar : b4) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("phyPosId", aVar.e());
                    List<com.qq.e.comm.plugin.e0.e.d> j4 = aVar.j();
                    JSONArray jSONArray2 = new JSONArray();
                    if (j4 != null && j4.size() > 0) {
                        for (com.qq.e.comm.plugin.e0.e.d dVar : j4) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", dVar.o());
                            jSONObject3.put("posId", dVar.p());
                            jSONObject3.put("ext", dVar.j());
                            jSONObject3.put("className", dVar.e());
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    jSONObject2.put("network", jSONArray2);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("layerConfigs", jSONArray);
            com.qq.e.comm.plugin.e0.d.c.c(this.f42787a, jSONObject.toString());
        } catch (JSONException e4) {
            d1.a("throw JSONException", e4);
        }
    }

    public static d a(Context context) {
        if (f42786g == null) {
            synchronized (d.class) {
                if (f42786g == null) {
                    f42786g = new d(context);
                }
            }
        }
        return f42786g;
    }

    public boolean b(String str) {
        if (!e1.j() || com.qq.e.comm.plugin.m0.a.l().n()) {
            boolean a4 = t0.a(str);
            com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
            cVar.c(str);
            if (a4) {
                v.a(1231004, cVar);
            }
            if (this.f42788b == null) {
                if (a4) {
                    v.a(1231005, cVar);
                }
                return false;
            }
            boolean z3 = a(str) != null;
            if (a4 && !z3) {
                v.a(1231011, cVar);
            }
            return z3;
        }
        return false;
    }

    public void a(JSONObject jSONObject) {
        jSONObject.toString();
        this.f42788b = new com.qq.e.comm.plugin.e0.e.c(jSONObject);
    }

    public void a(boolean z3) {
        if (e1.j()) {
            com.qq.e.comm.plugin.m0.a.l().a(new a(z3));
        } else {
            a(z3, true);
        }
    }

    private String b(boolean z3) {
        if (!e1.j()) {
            return z3 ? "https://sdk.e.qq.com/mediation?version=1" : "https://sdk.e.qq.com/mediation?version=2";
        } else if (z3) {
            return "{domain}/mediation?version=1".replace("{domain}", com.qq.e.comm.plugin.m0.a.l().f());
        } else {
            return "{domain}/mediation?version=2".replace("{domain}", com.qq.e.comm.plugin.m0.a.l().f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3, boolean z4) {
        com.qq.e.comm.plugin.i0.n.f hVar;
        synchronized (this) {
            if (this.f42792f) {
                return;
            }
            if (SystemClock.elapsedRealtime() - this.f42791e > this.f42788b.d() || z3) {
                this.f42792f = true;
                v.a(1231001, (com.qq.e.comm.plugin.n0.c) null);
                b bVar = new b(z3, z4);
                if (!z4) {
                    hVar = new com.qq.e.comm.plugin.i0.n.c(b(false), f.a.POST, b(z3, false).getBytes(com.qq.e.comm.plugin.k.a.f44515a));
                } else {
                    hVar = new h(b(true), b(z3, true).getBytes(com.qq.e.comm.plugin.k.a.f44515a));
                }
                d1.a("gdt_tag_net", d1.a(hVar));
                com.qq.e.comm.plugin.i0.d.a().a(hVar, c.a.f44221d, bVar);
            }
        }
    }

    private String b(boolean z3, boolean z4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", com.qq.e.comm.plugin.d0.a.d().b().a());
            jSONObject.put("sdk_ver", e1.i());
            jSONObject.put("plugin_ver", String.valueOf(com.qq.e.comm.plugin.d0.a.d().e().b()));
            Object a4 = com.qq.e.comm.plugin.m.b.f44639e.a(com.qq.e.comm.plugin.d0.a.d().a());
            Pair<String, String> d4 = a2.d();
            if (e1.j()) {
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_GAID_KEY, s0.a(com.qq.e.comm.plugin.util.a.a()));
            } else {
                jSONObject.put("device_id", a4);
            }
            jSONObject.put("app_ver_name", com.qq.e.comm.plugin.d0.a.d().b().d());
            if (e1.j()) {
                jSONObject.put("region", com.qq.e.comm.plugin.m0.a.l().e());
            }
            if (d4 != null) {
                jSONObject.put("taid", d4.first);
                jSONObject.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, d4.second);
            }
            jSONObject.put("android_id", com.qq.e.comm.plugin.m.b.f44640f.b().b(com.qq.e.comm.plugin.d0.a.d().a()));
            jSONObject.put(AdLogEventRepo.COL_ENCRYPT_TYPE, z4 ? 1 : 0);
            jSONObject.put("config_version", z3 ? "" : this.f42788b.a());
            String c4 = this.f42788b.c();
            if (!TextUtils.isEmpty(c4)) {
                jSONObject.put("suid", c4);
            }
            jSONObject.put("protocol_version", 2);
            jSONObject.put("os", 2);
            d1.a("Mediation request: " + jSONObject, new Object[0]);
        } catch (JSONException e4) {
            d1.a("throw JSONException", e4);
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.i0.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f42795a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f42796b;

        b(boolean z3, boolean z4) {
            this.f42795a = z3;
            this.f42796b = z4;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, com.qq.e.comm.plugin.i0.n.g gVar) {
            try {
                int statusCode = gVar.getStatusCode();
                if (statusCode == 200) {
                    String b4 = gVar.b();
                    if (!TextUtils.isEmpty(b4)) {
                        try {
                            JSONObject jSONObject = new JSONObject(b4);
                            int i4 = jSONObject.getInt("code");
                            if (!TextUtils.isEmpty(b4) && b4.length() > 4000) {
                                int length = (b4.length() / 4000) + 1;
                                int i5 = 0;
                                while (i5 < length) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Mediation config fetch config: part ");
                                    sb.append(i5);
                                    sb.append(" ");
                                    int i6 = 4000 * i5;
                                    i5++;
                                    sb.append(b4.substring(i6, Math.min(4000 * i5, b4.length())));
                                    d1.a(sb.toString(), new Object[0]);
                                }
                            } else {
                                d1.a("Mediation config fetch config: " + b4, new Object[0]);
                            }
                            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
                            dVar.a("code", Integer.valueOf(i4));
                            v.a(1231002, null, null, null, dVar);
                            if (i4 == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                d.this.a(optJSONObject);
                                if (optJSONObject != null) {
                                    d.this.c(optJSONObject.toString());
                                }
                            } else if (i4 == 110) {
                                com.qq.e.comm.plugin.m0.a.l().a();
                            }
                            d.this.f42791e = SystemClock.elapsedRealtime();
                        } catch (JSONException e4) {
                            d1.a("throw JSONException", e4);
                        }
                        d.this.f42792f = false;
                        return;
                    }
                }
                if (statusCode != 200) {
                    v.a(70022, (com.qq.e.comm.plugin.n0.c) null);
                } else {
                    v.a(70032, (com.qq.e.comm.plugin.n0.c) null);
                }
                d.this.f42792f = false;
                d.this.c(this.f42795a, this.f42796b);
            } catch (Exception e5) {
                d1.a("throw exception", e5);
                d.this.f42792f = false;
                d.this.c(this.f42795a, this.f42796b);
            }
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(com.qq.e.comm.plugin.i0.n.f fVar, Exception exc) {
            d.this.f42792f = false;
            d1.a("Mediation config fetch error", exc);
            d.this.c(this.f42795a, this.f42796b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.comm.plugin.e0.e.a a(String str) {
        List<com.qq.e.comm.plugin.e0.e.a> b4;
        if (TextUtils.isEmpty(str) || (b4 = this.f42788b.b()) == null || b4.size() <= 0) {
            return null;
        }
        for (com.qq.e.comm.plugin.e0.e.a aVar : b4) {
            if (TextUtils.equals(str, aVar.e())) {
                return aVar;
            }
        }
        return null;
    }

    private boolean a() {
        return GlobalSetting.isEnableMediationTool();
    }
}
