package com.bytedance.embedapplog;

import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class fp extends bk {
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    static final long[] f26728w = {920000};
    static final long[] xv = {920000};
    private static final long[] sr = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 6000, 180000, 180000, 540000, 540000};

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ys ysVar) {
        super(ysVar);
        this.ux = true;
    }

    @Override // com.bytedance.embedapplog.bk
    long c() {
        return this.f26705c.ux().p() + (this.f26705c.r().xv() ? 21600000 : 43200000);
    }

    @Override // com.bytedance.embedapplog.bk
    String sr() {
        return "r";
    }

    @Override // com.bytedance.embedapplog.bk
    long[] w() {
        int gd = this.f26705c.ux().gd();
        if (gd != 0) {
            if (gd != 1) {
                if (gd != 2) {
                    be.w((Throwable) null);
                    return xv;
                }
                return f26728w;
            }
            return xv;
        }
        return sr;
    }

    @Override // com.bytedance.embedapplog.bk
    boolean xv() {
        JSONObject jSONObject = new JSONObject();
        JSONObject c4 = this.f26705c.ux().c();
        if (c4 != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", c4);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            if (!TextUtils.isEmpty(c4.optString("device_id"))) {
                boolean sr2 = g.sr();
                Log.d("tp_dr_embed", "meet dr:" + sr2 + " first:" + this.ux);
                if (sr2 && this.ux) {
                    this.ux = false;
                    return false;
                }
            }
            Log.d("tp_dr_embed", "reg begin");
            JSONObject c5 = gw.c(vc.c(this.f26705c.w(), this.f26705c.ux().c(), this.f26705c.ev().getRegisterUri(), true, c.xv()), jSONObject);
            if (c5 != null) {
                return this.f26705c.ux().c(c5, c5.optString("device_id", ""), c5.optString("install_id", ""), c5.optString("ssid", ""));
            }
        } else {
            be.w((Throwable) null);
        }
        return false;
    }
}
