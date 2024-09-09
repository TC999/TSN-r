package com.qq.e.comm.plugin.q0.u;

import com.qq.e.comm.plugin.l0.d;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends i {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final f f45621a = new f(null);
    }

    /* synthetic */ f(a aVar) {
        this();
    }

    public static f b() {
        return b.f45621a;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "loadAD";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        String e4 = dVar.e();
        com.qq.e.comm.plugin.b.g a4 = com.qq.e.comm.plugin.b.g.a(e4);
        if (a4 == null) {
            d1.a("loadAD with error service(adtype)" + e4);
            return;
        }
        JSONObject d4 = dVar.d();
        if (d4 != null) {
            try {
                String optString = d4.optString("posid");
                a(hVar, dVar, optString, a(a4, d4, optString));
                return;
            } catch (Throwable th) {
                d1.a("Exception occurred while Loading AD,request=" + dVar, th);
                hVar.c().a(new com.qq.e.comm.plugin.q0.s.e(dVar, e.a.f45549d, "Exception occurred when fetching ad"));
                return;
            }
        }
        d1.a("ParaObj should not be null while loadAD");
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.h f45619a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.d f45620b;

        a(f fVar, com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
            this.f45619a = hVar;
            this.f45620b = dVar;
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(JSONObject jSONObject) {
            this.f45619a.c().a(new com.qq.e.comm.plugin.q0.s.e(this.f45620b, e.a.f45548c, jSONObject.toString()));
        }

        @Override // com.qq.e.comm.plugin.l0.d.c
        public void a(com.qq.e.comm.plugin.s.b bVar) {
            HashMap hashMap = new HashMap();
            hashMap.put("errorCode", Integer.valueOf(bVar.a()));
            this.f45619a.c().a(new com.qq.e.comm.plugin.q0.s.e(this.f45620b, e.a.f45549d, new JSONObject(hashMap)));
        }
    }

    private com.qq.e.comm.plugin.b.d a(com.qq.e.comm.plugin.b.g gVar, JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("jsver");
        JSONObject optJSONObject = jSONObject.optJSONObject("extreq");
        int optInt = jSONObject.optInt("adposcount");
        int optInt2 = jSONObject.optInt("count");
        int optInt3 = jSONObject.optInt("posw");
        int optInt4 = jSONObject.optInt("posh");
        com.qq.e.comm.plugin.b.d dVar = new com.qq.e.comm.plugin.b.d();
        dVar.a(optJSONObject);
        if (optInt <= 0) {
            optInt = 1;
        }
        dVar.a(optInt);
        if (optInt2 <= 0) {
            optInt2 = gVar.a();
        }
        dVar.b(optInt2);
        dVar.f(str);
        if (optInt3 > 0 && optInt4 > 0) {
            dVar.m(optInt3);
            dVar.k(optInt4);
        } else {
            com.qq.e.comm.plugin.b.f a4 = com.qq.e.comm.plugin.b.e.a(gVar, com.qq.e.comm.plugin.d0.a.d().c().f());
            dVar.m(a4.b());
            dVar.k(a4.a());
        }
        dVar.c(2);
        dVar.l(gVar.d());
        dVar.b(optString);
        return dVar;
    }

    private void a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar, String str, com.qq.e.comm.plugin.b.d dVar2) throws JSONException {
        com.qq.e.comm.plugin.b.g g4 = ((com.qq.e.comm.plugin.q0.s.h) hVar.c()).a().g();
        com.qq.e.comm.plugin.l0.d.a(dVar2, new com.qq.e.comm.plugin.l0.b(g4, str), new a(this, hVar, dVar));
    }
}
