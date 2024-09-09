package com.bytedance.sdk.openadsdk.core.p.xv.xv;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.u.gb;
import com.bytedance.sdk.openadsdk.core.u.ia;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private me f34389c;
    private com.bytedance.sdk.openadsdk.core.p.xv.c.c ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f34392w;
    private c xv;
    private boolean sr = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34390f = false;

    /* renamed from: r  reason: collision with root package name */
    private int f34391r = 0;
    private boolean ev = false;

    public xv(Context context, me meVar) {
        this.f34392w = context;
        this.f34389c = meVar;
    }

    private String sr(String str) {
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        if (c4 == null) {
            return null;
        }
        return c4.w(str, "");
    }

    public void w(boolean z3) {
        this.f34390f = z3;
    }

    public void xv(boolean z3) {
        this.ev = z3;
    }

    private void w(final String str) {
        if (ia.fp(this.f34389c) != 4) {
            return;
        }
        TTDelegateActivity.c(new r() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.xv.xv.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str2) {
                xv.this.c(str, 1, str2);
                TTDelegateActivity.c((r) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                xv.this.c(str, 0, "");
                TTDelegateActivity.c((r) null);
            }
        });
    }

    public String xv(long j4) {
        if (j4 <= 0) {
            return "-";
        }
        double d4 = j4;
        Double.isNaN(d4);
        return String.format("%.1fMB", Double.valueOf((d4 / 1024.0d) / 1024.0d));
    }

    private r xv(final String str) {
        return new r() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.xv.xv.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str2) {
                xv xvVar = xv.this;
                xvVar.c(xvVar.f34389c, str, 6, i4, str2);
                TTDelegateActivity.c((r) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                xv xvVar = xv.this;
                xvVar.c(xvVar.f34389c, str, 5, 0, "");
                TTDelegateActivity.c((r) null);
            }
        };
    }

    public void c(c cVar) {
        c(cVar, this.f34389c);
    }

    public String w(long j4) {
        if (j4 >= 100000000) {
            double d4 = j4;
            Double.isNaN(d4);
            return String.format("%d\u4ebf+", Long.valueOf(Math.round(d4 / 1.0E8d)));
        } else if (j4 < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return j4 > 0 ? String.valueOf(j4) : "-";
        } else {
            double d5 = j4;
            Double.isNaN(d5);
            return String.format("%d\u4e07+", Long.valueOf(Math.round(d5 / 10000.0d)));
        }
    }

    public void c(c cVar, me meVar) {
        this.xv = cVar;
        if (cVar == null) {
            return;
        }
        cVar.c(this.f34392w);
        cVar.c(meVar);
        cVar.c(this.sr);
    }

    public void c(boolean z3) {
        this.sr = z3;
    }

    public void c(com.bytedance.sdk.openadsdk.core.p.xv.c.c cVar) {
        this.ux = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            c cVar = this.xv;
            jSONObject.put("download_type", cVar != null ? cVar.w() : 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public void c(int i4) {
        this.f34391r = i4;
    }

    public boolean c() {
        c cVar = this.xv;
        if (cVar == null) {
            return true;
        }
        if (cVar instanceof w) {
            w wVar = (w) cVar;
            wVar.xv(this.ev);
            wVar.w(this.f34390f);
            wVar.c(this.f34391r);
        }
        return this.xv.c();
    }

    public void c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.core.p.xv.c.w wVar) {
        me meVar = this.f34389c;
        if (meVar == null) {
            return;
        }
        if (xvVar == null && meVar.rd() == 2 && !(this.xv instanceof ux)) {
            ev.w(new p("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.p.xv.xv.xv.1
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.c(ls.c().c(xv.this.f34389c, str2), str, wVar);
                }
            });
        } else {
            c(xvVar, str, wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.u.xv xvVar, String str, com.bytedance.sdk.openadsdk.core.p.xv.c.w wVar) {
        String o4;
        String w3;
        String c4;
        f.c c5 = c(str, wVar);
        try {
            if (xvVar != null) {
                com.bytedance.sdk.openadsdk.core.u.ux zg = this.f34389c.zg();
                if (zg != null) {
                    xvVar.c(zg.sr());
                    xvVar.c(zg.xv());
                }
                o4 = xvVar.f();
                w3 = xvVar.c();
                c4 = xvVar.xv();
            } else {
                o4 = this.f34389c.o();
                w3 = k.w(this.f34389c);
                gb kr = this.f34389c.kr();
                c4 = kr != null ? kr.c() : "";
            }
            String str2 = c4;
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.k(this.f34389c)) {
                if (!com.bytedance.sdk.openadsdk.core.ugeno.f.c(this.f34392w, this.f34389c, w3)) {
                    me meVar = this.f34389c;
                    c(meVar, str, com.bytedance.sdk.openadsdk.core.ugeno.f.w(this.f34392w, meVar, w3), 0, "");
                }
            } else {
                com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34389c, str, "pop_up", w());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dialog_title", w3);
            jSONObject.put("dialog_icon_url", str2);
            jSONObject.put("dialog_app_description", this.f34389c.ju());
            String c6 = c(o4);
            w(str);
            if (com.bytedance.sdk.openadsdk.core.ugeno.f.c(this.f34392w, this.f34389c, w3)) {
                c(str, c5, c6, str2, jSONObject);
            } else {
                com.bytedance.sdk.openadsdk.core.eq.f.w(this.f34392w, this.f34389c.jr(), c6, jSONObject.toString(), c5);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private String c(String str) {
        int fp = ia.fp(this.f34389c);
        try {
            if (fp != 4) {
                if (fp == 3) {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("hand_icon_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/ugeno-source/download_hand_tap.json");
                    return jSONObject.toString();
                }
                return str;
            }
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject2.put("ugen_url", ia.s(this.f34389c));
            jSONObject2.put("ugen_md5", ia.fz(this.f34389c));
            jSONObject2.put("download_num", w(this.f34389c.tx()));
            com.bytedance.sdk.openadsdk.core.u.sr ix = this.f34389c.ix();
            if (ix == null) {
                return jSONObject2.toString();
            }
            jSONObject2.put(CampaignEx.JSON_KEY_APP_SIZE, xv(ix.r()));
            jSONObject2.put("comment_num", c(ix.f()));
            return jSONObject2.toString();
        } catch (JSONException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i4, String str2) {
        JSONObject w3 = w();
        try {
            w3.put("ugen_dl_render_fail_msg", str2);
            w3.put("ugen_dl_render_fail", i4);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34389c, str, "pop_up", w3);
    }

    public String c(long j4) {
        return j4 >= 100000000 ? String.format("%d\u4ebf+", Long.valueOf(j4 / 100000000)) : j4 >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT ? String.format("%d\u4e07+", Long.valueOf(j4 / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT)) : j4 > 0 ? String.valueOf(j4) : "-";
    }

    private void c(String str, f.c cVar, String str2, String str3, JSONObject jSONObject) throws JSONException {
        jSONObject.put("is_easy_dl_dialog_pop_up_style", true);
        com.bytedance.sdk.openadsdk.core.eq.f.c(this.f34392w, this.f34389c.jr(), com.bytedance.sdk.openadsdk.core.ugeno.f.c(this.f34392w, str2, this.f34389c, str3), jSONObject.toString(), cVar, xv(str), this.f34389c);
    }

    private f.c c(final String str, final com.bytedance.sdk.openadsdk.core.p.xv.c.w wVar) {
        return new f.c() { // from class: com.bytedance.sdk.openadsdk.core.p.xv.xv.xv.4
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                if (xv.this.ux != null) {
                    xv.this.ux.c();
                }
                com.bytedance.sdk.openadsdk.core.p.xv.c.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.c();
                }
                f.f34386w = true;
                com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f34389c, str, "pop_up_download", xv.this.w());
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f34389c, str, "pop_up_cancel", xv.this.w());
                if (xv.this.ux != null) {
                    xv.this.ux.w();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(me meVar, String str, int i4, int i5, String str2) {
        JSONObject w3 = w();
        if (6 == i4) {
            try {
                w3.put("easy_dl_render_fail_code", i5);
                if (meVar != null) {
                    String xv = meVar.il().xv();
                    w3.put("easy_dl_render_fail_msg", str2);
                    w3.put("easy_dl_render_fail_dsl", sr(xv));
                }
            } catch (Exception unused) {
            }
        }
        w3.put("show_easy_dl_dialog_code", i4);
        com.bytedance.sdk.openadsdk.core.a.xv.xv(this.f34389c, str, "pop_up", w3);
    }
}
