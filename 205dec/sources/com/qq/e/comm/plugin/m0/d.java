package com.qq.e.comm.plugin.m0;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.qq.e.comm.plugin.d0.d.h;
import com.qq.e.comm.plugin.i0.c;
import com.qq.e.comm.plugin.i0.j;
import com.qq.e.comm.plugin.i0.n.f;
import com.qq.e.comm.plugin.i0.n.g;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.util.GDTLogger;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f44693b = com.qq.e.comm.plugin.m0.a.l().f() + "/activate";

    /* renamed from: c  reason: collision with root package name */
    private static final String f44694c = com.qq.e.comm.plugin.m0.a.l().f() + "/launch";

    /* renamed from: d  reason: collision with root package name */
    private static final d f44695d = new d();

    /* renamed from: a  reason: collision with root package name */
    private volatile Boolean f44696a = Boolean.FALSE;

    public void b() {
        com.qq.e.comm.plugin.d0.a d4 = com.qq.e.comm.plugin.d0.a.d();
        a(d4.a(), d4.f(), d4.e(), d4.c(), d4.b(), System.nanoTime());
    }

    public static d a() {
        return f44695d;
    }

    private synchronized void a(Context context, h hVar, com.qq.e.comm.plugin.d0.c.d dVar, com.qq.e.comm.plugin.d0.e.c cVar, com.qq.e.comm.plugin.d0.e.a aVar, long j4) {
        if (this.f44696a.booleanValue()) {
            return;
        }
        a(hVar, dVar, cVar, aVar, context, j4);
        this.f44696a = Boolean.TRUE;
    }

    private void a(h hVar, com.qq.e.comm.plugin.d0.c.d dVar, com.qq.e.comm.plugin.d0.e.c cVar, com.qq.e.comm.plugin.d0.e.a aVar, Context context, long j4) {
        String a4 = a(hVar, dVar, cVar, aVar, j4);
        GDTLogger.d("launch request: " + a4);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        String str = e1.j() ? f44693b : "https://sdk.e.qq.com/activate";
        if (!TextUtils.isEmpty(hVar.e())) {
            atomicBoolean.set(true);
            str = e1.j() ? f44694c : "https://sdk.e.qq.com/launch";
        }
        com.qq.e.comm.plugin.i0.d.a().a(new com.qq.e.comm.plugin.i0.n.h(str, a4.getBytes(Charset.forName("UTF-8"))), c.a.f44221d, new a(atomicBoolean));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f44697a;

        a(AtomicBoolean atomicBoolean) {
            this.f44697a = atomicBoolean;
        }

        @Override // com.qq.e.comm.plugin.i0.b
        public void a(f fVar, g gVar) {
            try {
                if (gVar.getStatusCode() == 200) {
                    String b4 = gVar.b();
                    GDTLogger.d("ACTIVERESPONSE:" + b4);
                    if (TextUtils.isEmpty(b4)) {
                        d.this.a(this.f44697a.get(), 3000, "response empty");
                        GDTLogger.d("SDK Server response empty string,maybe zip or tea format error");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(b4);
                    int optInt = jSONObject.optInt("ret", -1);
                    if (optInt == 0) {
                        d.this.a(this.f44697a.get(), 0, "");
                        com.qq.e.comm.plugin.m0.a.l().b(false, jSONObject);
                        return;
                    }
                    d dVar = d.this;
                    boolean z3 = this.f44697a.get();
                    dVar.a(z3, 3000, "code=" + optInt);
                    GDTLogger.d("Response Error,retCode=" + optInt);
                    return;
                }
                d dVar2 = d.this;
                boolean z4 = this.f44697a.get();
                dVar2.a(z4, 3005, "status=" + gVar.getStatusCode());
                GDTLogger.d("SDK server response code error while launch or activate,code:" + gVar.getStatusCode());
            } catch (IOException e4) {
                GDTLogger.d("ActivateError");
                d.this.a(this.f44697a.get(), 3001, e4.getMessage());
            } catch (JSONException e5) {
                d.this.a(this.f44697a.get(), 5001, e5.getMessage());
                GDTLogger.d("Parse Active or launch response exception");
            }
        }

        @Override // com.qq.e.comm.plugin.i0.j
        public void a(f fVar, int i4, Exception exc) {
            d.this.a(this.f44697a.get(), i4, exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3, int i4, String str) {
        if (i4 != 0) {
            com.qq.e.comm.plugin.m0.a.l().a(true);
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (!TextUtils.isEmpty(str)) {
            dVar.a("msg", str);
        }
        v.a(z3 ? 9120029 : 9120039, null, Integer.valueOf((o.c() ? 1 : 2) + 20), Integer.valueOf(i4), dVar);
    }

    private String a(h hVar, com.qq.e.comm.plugin.d0.c.d dVar, com.qq.e.comm.plugin.d0.e.c cVar, com.qq.e.comm.plugin.d0.e.a aVar, long j4) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject a4 = c.a(hVar);
            a4.put("sig", c.a(hVar, dVar));
            a4.put("dev", c.b(cVar));
            a4.put("app", c.a(aVar));
            a4.put("c", c.a(cVar));
            a4.put("sdk", c.a(dVar));
            if (e1.j()) {
                a4.put("region", com.qq.e.comm.plugin.m0.a.l().e());
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("sdk_init_time", (System.nanoTime() - j4) / C.MICROS_PER_SECOND);
            jSONObject3.put("performance", jSONObject4);
            a4.put("biz", jSONObject3);
            jSONObject = a4;
        } catch (JSONException unused) {
            GDTLogger.d("JSONException while build init req");
            jSONObject = jSONObject2;
        }
        return jSONObject.toString();
    }
}
