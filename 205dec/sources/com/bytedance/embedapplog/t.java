package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class t extends bk {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ys ysVar) {
        super(ysVar);
    }

    @Override // com.bytedance.embedapplog.bk
    long c() {
        return this.f26705c.sr().r() + 21600000;
    }

    @Override // com.bytedance.embedapplog.bk
    String sr() {
        return "c";
    }

    @Override // com.bytedance.embedapplog.bk
    long[] w() {
        return fp.xv;
    }

    @Override // com.bytedance.embedapplog.bk
    public boolean xv() {
        JSONObject c4 = this.f26705c.ux().c();
        if (this.f26705c.ux().gd() == 0 || c4 == null || this.f26705c.sr().r() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", c4);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject w3 = gw.w(gw.c(vc.c(this.f26705c.w(), this.f26705c.ux().c(), this.f26705c.ev().getSettingUri(), true, c.xv()), gw.xv), jSONObject);
        c.p().onRemoteConfigGet(!g.c(w3, this.f26705c.sr().f()), w3);
        if (w3 != null) {
            this.f26705c.sr().c(w3);
            return true;
        }
        return false;
    }
}
