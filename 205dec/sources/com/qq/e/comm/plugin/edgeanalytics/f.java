package com.qq.e.comm.plugin.edgeanalytics;

import android.os.Build;
import com.qq.e.comm.plugin.g0.b0;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.e1;
import com.qq.e.comm.plugin.util.j0;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f implements IEAB {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.edgeanalytics.h.a.c f43006a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.qq.e.comm.plugin.edgeanalytics.h.a.b bVar) {
        this.f43006a = new com.qq.e.comm.plugin.edgeanalytics.h.a.c(bVar);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String del(String str, String str2) {
        String valueOf = String.valueOf(this.f43006a.a(str, str2));
        d1.a("GDTEAM_EAB", "del %s", valueOf);
        return valueOf;
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String ge() {
        return new j0().a("m", com.qq.e.comm.plugin.d0.a.d().c().f42280j).a("sv", e1.c()).a("ov", Build.VERSION.SDK_INT).a("os", 2).a("apd", com.qq.e.comm.plugin.d0.a.d().b().a()).a("pc", Runtime.getRuntime().availableProcessors()).a("nt", com.qq.e.comm.plugin.d0.a.d().c().n().a()).a().toString();
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gexp(String str, String str2, String str3) {
        b0 a4;
        d1.a("GDTEAM_EAB", "gexp %s,%s", str, str3);
        JSONObject a5 = new j0(str3).a();
        boolean z3 = a5.optInt("preq") == 1;
        int optInt = a5.optInt("adt", -1);
        String valueOf = optInt > 0 ? String.valueOf(optInt) : "APP";
        if (z3) {
            return com.qq.e.comm.plugin.t.c.a(str, valueOf, "", str2);
        }
        if (optInt > 0) {
            a4 = com.qq.e.comm.plugin.t.a.b().a(optInt);
        } else {
            a4 = com.qq.e.comm.plugin.t.a.b().a();
        }
        return com.qq.e.comm.plugin.t.c.a(str, "", str2, a4);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String gsm(String str, String str2) {
        String a4 = com.qq.e.comm.plugin.d0.a.d().f().a(str, "", str2);
        d1.a("GDTEAM_EAB", "gsm %s", a4);
        return a4;
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String it(String str, String str2) {
        String valueOf = String.valueOf(this.f43006a.b(str, str2));
        d1.a("GDTEAM_EAB", "it %s", valueOf);
        return valueOf;
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void log(String str) {
        d1.a("gdt_tag_js", "log %s", str);
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String oc(String str, String str2, String str3) {
        return this.f43006a.a(str, str2, new j0(str3).a());
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String q(String str) {
        d1.a("GDTEAM_EAB", "q %s", str);
        String jSONArray = this.f43006a.b(str).toString();
        d1.a("GDTEAM_EAB", "qr %s", jSONArray);
        return jSONArray;
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public String sql(String str) {
        String valueOf = String.valueOf(this.f43006a.a(str));
        d1.a("GDTEAM_EAB", "sql %s", valueOf);
        return valueOf;
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void te(String str) {
        d1.a("GDTEAM_EAB", "te %s", str);
        v.a(new com.qq.e.comm.plugin.n0.e(str));
    }

    @Override // com.qq.e.comm.plugin.edgeanalytics.IEAB
    public void tp(String str) {
        d1.a("GDTEAM_EAB", "tp %s", str);
        v.a(new h(str));
    }
}
