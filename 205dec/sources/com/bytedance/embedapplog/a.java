package com.bytedance.embedapplog;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends bk {

    /* renamed from: w  reason: collision with root package name */
    private long f26691w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ys ysVar) {
        super(ysVar);
    }

    @Override // com.bytedance.embedapplog.bk
    long c() {
        long s3 = this.f26705c.sr().s();
        if (s3 < 600000) {
            s3 = 600000;
        }
        return this.f26691w + s3;
    }

    @Override // com.bytedance.embedapplog.bk
    String sr() {
        return "ab";
    }

    @Override // com.bytedance.embedapplog.bk
    long[] w() {
        return fp.xv;
    }

    @Override // com.bytedance.embedapplog.bk
    boolean xv() {
        JSONObject c4 = this.f26705c.ux().c();
        if (this.f26705c.ux().gd() == 0 || c4 == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.f26705c.ux().c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", currentTimeMillis);
        JSONObject xv = gw.xv(gw.c(vc.c(this.f26705c.w(), this.f26705c.ux().c(), this.f26705c.ev().getAbUri(), true, c.xv()), gw.xv), jSONObject);
        if (xv != null) {
            c.p().onRemoteAbConfigGet(!g.c(c.ux(), xv), xv);
            if (be.f26702w) {
                be.c("getAbConfig " + xv, null);
            }
            this.f26705c.ux().c(xv);
            this.f26691w = currentTimeMillis;
            return true;
        }
        return false;
    }
}
