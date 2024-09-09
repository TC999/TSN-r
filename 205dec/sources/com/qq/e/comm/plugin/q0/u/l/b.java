package com.qq.e.comm.plugin.q0.u.l;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.h;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.q0.u.i;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends i {

    /* renamed from: a  reason: collision with root package name */
    private final String f45637a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45638b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f45639c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.d f45640c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f45641d;

        a(com.qq.e.comm.plugin.q0.s.d dVar, h hVar) {
            this.f45640c = dVar;
            this.f45641d = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f45640c, this.f45641d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i4, com.qq.e.comm.plugin.n0.c cVar) {
        this.f45637a = str;
        this.f45638b = i4;
        this.f45639c = cVar;
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public String a() {
        return "preloadMiniProgram";
    }

    @Override // com.qq.e.comm.plugin.q0.u.i
    public void a(h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        d0.f46406b.submit(new a(dVar, hVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.q0.s.d dVar, h hVar) {
        v.a(1142000, this.f45639c, Integer.valueOf(this.f45638b));
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return;
        }
        int b4 = com.qq.e.comm.plugin.s0.b.b(a(d4), d4.optInt("preload_type", 1));
        boolean z3 = b4 == 18 || b4 == 19;
        d1.a("MiniProgram \u9884\u52a0\u8f7d\u5c0f\u7a0b\u5e8f\u662f\u5426\u6210\u529f: %s, code = %s", Boolean.valueOf(z3), Integer.valueOf(b4));
        v.a(1142001, this.f45639c, Integer.valueOf(this.f45638b), Integer.valueOf(z3 ? 0 : b4), null);
        JSONObject jSONObject = new JSONObject();
        if (z3) {
            b4 = 0;
        }
        try {
            jSONObject.putOpt("code", Integer.valueOf(b4));
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        hVar.c().a(new e(dVar, e.a.f45548c, jSONObject));
    }

    private JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("ad_trace_data", jSONObject.optString("ad_trace_data"));
            jSONObject2.putOpt("wx_appid", this.f45637a);
            jSONObject2.putOpt("username", jSONObject.optString("username"));
            jSONObject2.putOpt("path", jSONObject.optString("path"));
        } catch (JSONException unused) {
            d1.a("getLaunchInfo error");
        }
        return jSONObject2;
    }
}
