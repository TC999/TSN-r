package com.bytedance.sdk.openadsdk.core.w.c.xv;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.w.w f35355a;
    protected boolean ev;

    /* renamed from: f  reason: collision with root package name */
    protected Map<String, Object> f35356f;

    /* renamed from: k  reason: collision with root package name */
    private String f35357k;

    /* renamed from: r  reason: collision with root package name */
    protected String f35359r;
    protected ev ux;
    private int gd = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f35358p = -1;

    public c() {
    }

    private void f() {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        long w3 = c4.w("click_to_live_duration", 0L);
        if (w3 == 0) {
            Map<String, Object> map = this.f35356f;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - w3;
        HashMap hashMap = new HashMap();
        hashMap.put("click_livead_duration", Long.valueOf(currentTimeMillis));
        w(hashMap);
        c4.w("click_to_live_duration", 0L);
    }

    public void c(String str) {
        this.f35359r = str;
    }

    protected ev sr() {
        int i4 = this.gd;
        if (i4 != -1) {
            this.gd = -1;
        } else {
            i4 = -1;
        }
        float f4 = xk.f(this.f35279w);
        int ev = xk.ev(this.f35279w);
        float r3 = xk.r(this.f35279w);
        View f5 = this.xv.f();
        View ux = this.xv.ux();
        return new ev.c().f(this.xv.bk()).ux(this.xv.t()).sr(this.xv.ys()).xv(this.xv.fp()).w(this.xv.k()).c(this.xv.a()).w(xk.c(f5)).c(xk.c(ux)).xv(xk.xv(f5)).sr(xk.xv(ux)).xv(this.xv.c()).sr(this.xv.w()).ux(this.xv.xv()).c(this.xv.gd()).w(k.sr().w() ? 1 : 2).c(this.f35357k).c(f4).c(ev).w(r3).f(i4).r(this.f35358p).ev(this.xv.s()).ux(this.xv.ia()).c();
    }

    public Map<String, Object> ux() {
        return this.f35356f;
    }

    public void w() {
        this.f35358p = 1;
    }

    public String xv() {
        return this.f35357k;
    }

    private String xv(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c4 = 0;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c4 = 1;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c4 = 4;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return "banner_call";
            case 1:
            case 4:
                return "feed_call";
            case 2:
                return "splash_ad";
            case 3:
                return "interaction_call";
            case 5:
                return "banner_call";
            default:
                return "";
        }
    }

    public void c(boolean z3) {
        this.ev = z3;
    }

    public void w(String str) {
        this.f35357k = str;
    }

    public void c() {
        this.gd = 1;
    }

    public void w(Map<String, Object> map) {
        Map<String, Object> map2 = this.f35356f;
        if (map2 == null) {
            this.f35356f = map;
        } else {
            map2.putAll(map);
        }
    }

    public c(me meVar, Context context) {
        this.f35278c = meVar;
        this.f35279w = context;
        this.f35356f = new HashMap();
    }

    public void c(ev evVar) {
        this.ux = evVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.c.xv.w, com.bytedance.sdk.openadsdk.core.w.c.c
    public boolean c(Map<String, Object> map) {
        if (this.xv == null) {
            this.xv = new gd();
        }
        if ("splash_ad".equals(this.f35359r) || "cache_splash_ad".equals(this.f35359r) || "splash_ad_landingpage".equals(this.f35359r)) {
            this.gd = this.gd == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.ux == null) {
            this.ux = sr();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            f();
        }
        this.f35356f.put("event_id", UUID.randomUUID());
        Object obj3 = map.get("is_need_report_click_button");
        boolean booleanValue2 = obj3 instanceof Boolean ? ((Boolean) obj3).booleanValue() : false;
        int i4 = this.xv.sr() ? 1 : 2;
        if (booleanValue2) {
            com.bytedance.sdk.openadsdk.core.a.xv.c("click_button", this.f35278c, this.ux, this.f35359r, true, this.f35356f, i4, this.ev);
        }
        Object obj4 = map.get("is_need_report_click_call");
        if (obj4 instanceof Boolean ? ((Boolean) obj4).booleanValue() : false) {
            String xv = xv(this.f35359r);
            if (!TextUtils.isEmpty(xv)) {
                com.bytedance.sdk.openadsdk.core.a.xv.c("click_call", this.f35278c, this.ux, xv, true, this.f35356f, i4, this.ev);
            }
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.f35356f.put("refer", "banner");
        }
        if (ls.c(this.f35278c) && !com.bytedance.sdk.openadsdk.core.bk.sr.c(String.valueOf(wv.gd(this.f35278c))) && this.f35278c.dc() != null) {
            this.f35356f.put("refresh_num", Integer.valueOf(this.f35278c.dc().xv()));
        }
        Object obj5 = map.get("click_saas_action");
        if (obj5 != null && (obj5 instanceof Integer)) {
            this.f35356f.put("click_saas_action", obj5);
        }
        Object obj6 = map.get("click_saas_area");
        if (obj5 != null && (obj5 instanceof Integer)) {
            this.f35356f.put("click_saas_area", obj6);
        }
        com.bytedance.sdk.openadsdk.core.a.xv.c("click", this.f35278c, this.ux, this.f35359r, booleanValue, this.f35356f, i4, this.ev);
        return false;
    }

    public void c(com.bytedance.sdk.openadsdk.core.video.w.w wVar) {
        this.f35355a = wVar;
    }
}
