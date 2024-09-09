package com.bytedance.sdk.openadsdk.core.ugeno.xv;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.a.ux;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.eq.f;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.p.xv.gd;
import com.bytedance.sdk.openadsdk.core.p.xv.k;
import com.bytedance.sdk.openadsdk.core.q.w;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.ugeno.r.r;
import com.bytedance.sdk.openadsdk.core.ugeno.r.ux;
import com.bytedance.sdk.openadsdk.core.ugeno.xv.w;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements w.c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.xv f35069a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    protected me f35070c;
    private ViewGroup ev;

    /* renamed from: f  reason: collision with root package name */
    private ux f35071f;
    private com.bytedance.sdk.openadsdk.core.multipro.w.c fp;
    private b gd;
    private com.bytedance.sdk.openadsdk.core.p.w.c ia = new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.8
        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, long j5, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(long j4, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void c(String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void w(long j4, long j5, String str, String str2) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.p.w.c
        public void xv(long j4, long j5, String str, String str2) {
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f35072k;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.p.w.xv f35073p;

    /* renamed from: r  reason: collision with root package name */
    private Activity f35074r;
    protected String sr;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.w f35075t;
    protected int ux;

    /* renamed from: w  reason: collision with root package name */
    protected w f35076w;
    protected com.bytedance.sdk.openadsdk.core.ugeno.sr.c xv;
    private com.bytedance.adsdk.ugeno.component.image.b ys;

    public c(Activity activity, ViewGroup viewGroup, ux uxVar, me meVar, String str, int i4, com.bytedance.sdk.openadsdk.core.multipro.w.c cVar) {
        this.f35070c = meVar;
        this.f35074r = activity;
        this.f35071f = uxVar;
        this.ev = viewGroup;
        this.sr = str;
        this.ux = i4;
        this.fp = cVar;
    }

    private void ev() {
        if (this.f35073p == null) {
            com.bytedance.sdk.openadsdk.core.p.w.xv c4 = com.bytedance.sdk.openadsdk.core.p.xv.c(this.f35074r, this.bk, this.f35070c, this.sr);
            this.f35073p = c4;
            c4.c(k.c(this.f35070c));
            this.f35073p.c(this.ia, false);
            this.f35073p.ux(false);
        }
        this.f35073p.c(this.f35074r);
    }

    private void gd() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f35075t;
        if (wVar != null) {
            wVar.c(this.fp);
        }
    }

    private String r() {
        return wv.t(this.f35070c);
    }

    protected void c(b<View> bVar) {
    }

    protected void c(JSONObject jSONObject) {
    }

    private String f() {
        JSONObject jSONObject = this.f35072k;
        if (jSONObject == null) {
            return r();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("download_buttons");
        if (optJSONArray == null) {
            return r();
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return r();
        }
        String optString = optJSONObject.optString("url");
        return TextUtils.isEmpty(optString) ? r() : optString;
    }

    private void sr(final JSONObject jSONObject) {
        if (this.f35069a != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(this.f35069a.f());
                jSONObject2.put("is_support_func_desc", "true");
                jSONObject.put("app", jSONObject2);
                xv(jSONObject);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        String f4 = f();
        this.bk = f4;
        if (TextUtils.isEmpty(f4)) {
            com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = this.xv;
            if (cVar != null) {
                cVar.c(-4);
                return;
            }
            return;
        }
        ev.w(new p("tt_pl_download_check") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.4
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3;
                c cVar2 = c.this;
                ck<com.bytedance.sdk.openadsdk.core.a.c> c4 = ls.c();
                c cVar3 = c.this;
                cVar2.f35069a = c4.c(cVar3.f35070c, cVar3.bk);
                try {
                    if (c.this.f35069a != null) {
                        jSONObject3 = new JSONObject(c.this.f35069a.f());
                    } else if (c.this.f35070c.o() != null) {
                        jSONObject3 = new JSONObject(c.this.f35070c.o());
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    jSONObject3.put("is_support_func_desc", "true");
                    jSONObject.put("app", jSONObject3);
                    jSONObject3.put(DownloadModel.DOWNLOAD_URL, c.this.bk);
                    c.this.xv(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        me meVar = this.f35070c;
        if (meVar == null || ng.ev(meVar) != 200) {
            return;
        }
        b w3 = this.gd.w("video");
        if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3;
            this.f35075t = wVar;
            wVar.sr(true);
            gd();
        }
        b w4 = this.gd.w(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (w4 instanceof com.bytedance.adsdk.ugeno.component.image.b) {
            this.ys = (com.bytedance.adsdk.ugeno.component.image.b) w4;
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.parseColor("#99333333"));
            shapeDrawable.setIntrinsicWidth(xk.ux(this.f35074r, 28.0f));
            shapeDrawable.setIntrinsicHeight(xk.ux(this.f35074r, 28.0f));
            this.ys.gd().setBackground(shapeDrawable);
        }
        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = this.fp;
        if (cVar != null) {
            c(cVar.ev);
        } else {
            c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c(this.f35070c.ev(), "lp_" + this.f35070c.r(), this.f35070c.gd(), new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c
            public void c(JSONObject jSONObject2) {
                if (jSONObject2 == null) {
                    c.this.f35071f.c(-1, "template info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.xv;
                    if (cVar != null) {
                        cVar.c(-1);
                        return;
                    }
                    return;
                }
                try {
                    jSONObject.put("creative", c.this.f35070c.mo());
                    c.this.c(jSONObject);
                    c.this.c(jSONObject2, jSONObject);
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(JSONObject jSONObject) {
        this.f35072k = jSONObject;
        sr(jSONObject);
    }

    private void w(boolean z3) {
        ev();
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f35073p;
        if (xvVar instanceof gd) {
            ((gd) xvVar).c().c(z3);
        }
    }

    private void xv(boolean z3) {
        w(false);
        sr(z3);
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar) {
        this.xv = cVar;
    }

    private void xv(me meVar) {
        String gd;
        if (meVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
        com.bytedance.sdk.openadsdk.core.u.xv xvVar = this.f35069a;
        if (xvVar != null) {
            gd = xvVar.sr();
        } else {
            gd = zg == null ? "" : zg.gd();
        }
        f.w(this.f35074r, gd, meVar.jr(), new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.7
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                c.this.sr(true);
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }
        });
    }

    public void c() {
        this.f35076w = new w(this.f35074r, this.f35071f, this.sr, this.ux);
        if (this.f35070c.k() != null) {
            try {
                w(new JSONObject(this.f35070c.k().toString()));
                return;
            } catch (JSONException e4) {
                e4.printStackTrace();
                return;
            }
        }
        int r3 = this.f35070c.r();
        if (r3 != 5 && r3 != 4) {
            com.bytedance.sdk.openadsdk.core.q.w.c(this.f35070c.f(), new w.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.1
                @Override // com.bytedance.sdk.openadsdk.core.q.w.c
                public void c(JSONObject jSONObject) {
                    c.this.w(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.q.w.c
                public void c(int i4, String str) {
                    c.this.f35071f.c(-3, "ad meta info load fail");
                    com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.xv;
                    if (cVar != null) {
                        cVar.c(-3);
                    }
                }
            });
        } else {
            w(new JSONObject());
        }
    }

    private boolean w(h hVar) {
        if (hVar == null) {
            return false;
        }
        View gd = hVar.a().gd();
        if (gd instanceof TextView) {
            CharSequence text = ((TextView) gd).getText();
            if (TextUtils.isEmpty(text)) {
                return false;
            }
            return text.toString().contains("\u4e0b\u8f7d");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(boolean z3) {
        ev();
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.f35074r, this.f35070c, "embeded_ad_landingpage", this.ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
        JSONObject ux = me.ux(this.f35070c);
        this.f35073p.sr(z3);
        this.f35073p.w(ux);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f35073p);
        this.f35073p.c(ux);
    }

    public void xv() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f35073p;
        if (xvVar != null) {
            xvVar.sr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f35075t;
        if (wVar != null) {
            wVar.u();
        }
    }

    private void w(me meVar) {
        String o4;
        if (meVar == null) {
            return;
        }
        if (this.f35069a != null) {
            com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
            if (zg != null) {
                this.f35069a.c(zg.sr());
                this.f35069a.c(zg.xv());
            }
            o4 = this.f35069a.f();
        } else {
            o4 = meVar.o();
        }
        Activity activity = this.f35074r;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).xv();
        }
        f.c(this.f35074r, meVar.jr(), new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.6
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                c.this.sr(true);
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }
        }, o4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        this.f35071f.w();
        this.f35076w.c(this);
        this.f35076w.c(jSONObject, jSONObject2, new r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.xv;
                if (cVar != null) {
                    cVar.c(i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                c.this.gd = bVar;
                c.this.ev.addView(bVar.gd(), new FrameLayout.LayoutParams(bVar.fp(), bVar.ia()));
                com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.xv;
                if (cVar != null) {
                    cVar.c(bVar.gd());
                }
                c.this.ux();
                c.this.c(bVar);
            }
        });
    }

    private void c(boolean z3) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f35075t;
        if (wVar != null) {
            wVar.xv(z3);
        }
        com.bytedance.adsdk.ugeno.component.image.b bVar = this.ys;
        if (bVar == null || bVar.gd() == null) {
            return;
        }
        this.ys.gd().setImageDrawable(i.xv(this.f35074r, z3 ? "tt_mute" : "tt_unmute"));
    }

    public void sr() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f35073p;
        if (xvVar != null) {
            xvVar.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.xv.w.c
    public void c(h hVar) {
        JSONObject i4;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar;
        if (hVar == null || hVar.g() != 1 || (i4 = hVar.i()) == null) {
            return;
        }
        String optString = i4.optString("type");
        optString.hashCode();
        char c4 = '\uffff';
        switch (optString.hashCode()) {
            case -1822902106:
                if (optString.equals("openAppPermission")) {
                    c4 = 0;
                    break;
                }
                break;
            case -785542189:
                if (optString.equals("clickVideo")) {
                    c4 = 1;
                    break;
                }
                break;
            case -459025504:
                if (optString.equals("openAppFunctionDesc")) {
                    c4 = 2;
                    break;
                }
                break;
            case 7917298:
                if (optString.equals("downloadEvent")) {
                    c4 = 3;
                    break;
                }
                break;
            case 205179537:
                if (optString.equals("downloadDirect")) {
                    c4 = 4;
                    break;
                }
                break;
            case 1151744482:
                if (optString.equals("muteVideo")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1237425033:
                if (optString.equals("openAppPolicy")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1250090940:
                if (optString.equals("openInfringement")) {
                    c4 = 7;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                c(this.f35070c);
                return;
            case 1:
                com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar2 = this.f35075t;
                if (wVar2 != null) {
                    wVar2.gb();
                    return;
                }
                return;
            case 2:
                xv(this.f35070c);
                return;
            case 3:
                w(true);
                sr(w(hVar));
                return;
            case 4:
                xv(w(hVar));
                return;
            case 5:
                if (this.ys == null || (wVar = this.f35075t) == null) {
                    return;
                }
                c(!wVar.ev());
                return;
            case 6:
                w(this.f35070c);
                return;
            case 7:
                f.c(this.f35074r, this.sr, this.f35070c);
                return;
            default:
                return;
        }
    }

    public void w() {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f35073p;
        if (xvVar != null) {
            xvVar.ux();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = this.f35075t;
        if (wVar != null) {
            wVar.i();
        }
    }

    private void c(me meVar) {
        String o4;
        if (meVar == null) {
            return;
        }
        if (this.f35069a != null) {
            com.bytedance.sdk.openadsdk.core.u.ux zg = meVar.zg();
            if (zg != null) {
                this.f35069a.c(zg.sr());
                this.f35069a.c(zg.xv());
            }
            o4 = this.f35069a.f();
        } else {
            o4 = meVar.o();
        }
        Activity activity = this.f35074r;
        if (activity instanceof TTNativePageActivity) {
            ((TTNativePageActivity) activity).xv();
        }
        f.c(this.f35074r, meVar.jr(), o4, new f.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xv.c.5
            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void c() {
                c.this.sr(true);
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void w() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.f.c
            public void xv() {
                if (c.this.f35074r instanceof TTNativePageActivity) {
                    ((TTNativePageActivity) c.this.f35074r).sr();
                }
            }
        });
    }
}
