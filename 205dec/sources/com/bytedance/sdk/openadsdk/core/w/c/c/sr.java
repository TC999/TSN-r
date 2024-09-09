package com.bytedance.sdk.openadsdk.core.w.c.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.eq.u;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.pr;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.u.ys;
import com.bytedance.sdk.openadsdk.core.u.z;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private ux f35281c;

    public sr(ux uxVar) {
        this.f35281c = uxVar;
    }

    public boolean c(Map<String, Object> map, boolean z3, String str, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        ux uxVar = this.f35281c;
        if (uxVar == null) {
            return false;
        }
        int t3 = uxVar.t();
        Object obj = map.get("key_open_video_detail_page_direct");
        boolean z8 = obj != null && ((Boolean) obj).booleanValue();
        if (t3 == -1) {
            com.bytedance.sdk.openadsdk.core.p.w.xv ev = this.f35281c.ev();
            if (ev != null) {
                ev.w(me.ux(this.f35281c.w()));
                z7 = true;
            } else {
                z7 = false;
            }
        } else if (t3 != 0) {
            z7 = c(z3, str, true, z8);
        } else {
            com.bytedance.sdk.openadsdk.core.p.w.xv ev2 = this.f35281c.ev();
            if (z6 && ev2 != null) {
                ev2.w(me.ux(this.f35281c.w()));
                z7 = true;
            } else {
                z7 = c(z3, str, false, z8);
            }
        }
        me w3 = this.f35281c.w();
        com.bytedance.sdk.openadsdk.core.video.w.w s3 = this.f35281c.s();
        if ((s3 == null || s3.k() != 1) && w3 != null && z4) {
            ys qu = w3.qu();
            if (!z5 || z7 || qu == null || qu.xv() != 2) {
                c();
                map.put("convert_res", Boolean.valueOf(z7));
                return true;
            }
            return false;
        }
        return false;
    }

    public void w() {
        me w3 = this.f35281c.w();
        if (w3 == null) {
            return;
        }
        boolean xv = u.xv(w3);
        ux uxVar = this.f35281c;
        c(xv, xv ? uxVar.k() : wv.c(uxVar.gd()), true, false);
    }

    boolean c(boolean z3, String str, boolean z4, boolean z5) {
        pr.c(z5);
        return pr.c(this.f35281c, str, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        int t3 = this.f35281c.t();
        me w3 = this.f35281c.w();
        Map<String, Object> p3 = this.f35281c.p();
        if (t3 != Integer.MIN_VALUE && u.sr(w3)) {
            boolean z3 = true;
            if (t3 != 1 && t3 != 3) {
                z3 = false;
            }
            p3.put("openPlayableLandingPage", Boolean.valueOf(z3));
            p3.put("allow_open_playable_landing_page", Boolean.valueOf(wx.ux(w3)));
        }
        if (u.sr(w3)) {
            p3.put("is_play_with_download", Boolean.valueOf(wx.sr(w3)));
        }
    }

    public void c(me meVar, Map<String, Object> map) {
        z ed;
        if (meVar == null || !bw.c(meVar) || (ed = meVar.ed()) == null) {
            return;
        }
        String xv = ed.xv();
        String sr = ed.sr();
        int w3 = bw.w(meVar);
        long ux = ed.ux();
        Long l4 = TTAdConstant.LIVE_REWARD_TIME;
        if (ux > l4.longValue()) {
            ux -= l4.longValue();
        }
        try {
            if (!TextUtils.isEmpty(xv)) {
                JSONObject jSONObject = new JSONObject(xv);
                if (ux <= 0 || w3 == 1) {
                    jSONObject.put("ad_slot_type", -1);
                    ed.xv(jSONObject.toString());
                }
            }
            if (!TextUtils.isEmpty(sr)) {
                JSONObject jSONObject2 = new JSONObject(sr);
                if (ux <= 0) {
                    ux = 0;
                }
                jSONObject2.put("count_down_time", ux / 1000);
                jSONObject2.put("pkg_name", wv.ev());
                jSONObject2.put("act_name", wv.p(wv.ev()));
                ed.sr(jSONObject2.toString());
            }
            map.put("is_reward_live", Boolean.TRUE);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
