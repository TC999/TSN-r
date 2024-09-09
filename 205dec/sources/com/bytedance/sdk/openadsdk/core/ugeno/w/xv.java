package com.bytedance.sdk.openadsdk.core.ugeno.w;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.w.b;
import com.bytedance.adsdk.ugeno.w.h;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.adsdk.ugeno.w.l;
import com.bytedance.sdk.component.adexpress.w.ev;
import com.bytedance.sdk.component.adexpress.w.r;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.eq;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.control.interaction.view.InteractionCommon;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements b, l, com.bytedance.sdk.component.adexpress.dynamic.sr, com.bytedance.sdk.component.adexpress.w.sr<View> {

    /* renamed from: a  reason: collision with root package name */
    private String f35051a;

    /* renamed from: c  reason: collision with root package name */
    protected i f35052c;
    protected com.bytedance.adsdk.ugeno.component.b ev;

    /* renamed from: f  reason: collision with root package name */
    protected FrameLayout f35053f;

    /* renamed from: k  reason: collision with root package name */
    private String f35054k;

    /* renamed from: p  reason: collision with root package name */
    private ev f35055p;

    /* renamed from: r  reason: collision with root package name */
    protected t f35056r;
    protected me sr;

    /* renamed from: t  reason: collision with root package name */
    private WeakReference<ViewGroup> f35057t;
    protected c ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f35058w;
    protected com.bytedance.adsdk.ugeno.component.b<View> xv;
    private boolean ys;
    private gd bk = new gd();
    protected AtomicBoolean gd = new AtomicBoolean(false);

    public xv(Context context, me meVar, c cVar, ViewGroup viewGroup) {
        JSONObject optJSONObject;
        this.ys = false;
        this.f35058w = context;
        this.f35052c = new i(context);
        this.sr = meVar;
        this.ux = cVar;
        this.f35053f = new FrameLayout(context);
        this.f35057t = new WeakReference<>(viewGroup);
        JSONObject c4 = c();
        if (meVar == null || !meVar.dd() || c4 == null || (optJSONObject = c4.optJSONObject("event_template")) == null) {
            return;
        }
        this.ys = true;
        com.bytedance.sdk.component.p.xv.w.INSTANCE.c(optJSONObject);
    }

    public void ev() {
        com.bytedance.adsdk.ugeno.component.b bVar = this.ev;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) bVar).i();
        }
    }

    public void f() {
        com.bytedance.adsdk.ugeno.component.b bVar = this.ev;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) bVar).u();
        }
    }

    public void gd() {
        com.bytedance.adsdk.ugeno.component.b bVar = this.ev;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) bVar).q();
        }
    }

    public void p() {
        com.bytedance.adsdk.ugeno.component.b bVar = this.ev;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) bVar).j();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public View r() {
        return this.f35053f;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void setSoundMute(boolean z3) {
        com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w("mute_image");
        if (w3 != null) {
            if (z3) {
                if (!TextUtils.isEmpty(this.f35054k)) {
                    ((com.bytedance.adsdk.ugeno.component.image.b) w3).h(this.f35054k);
                }
            } else if (!TextUtils.isEmpty(this.f35051a)) {
                ((com.bytedance.adsdk.ugeno.component.image.b) w3).h(this.f35051a);
            }
            w3.w();
        }
    }

    public void sr() {
        com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w("corver_container");
        if (w3 == null || w3.gd() == null) {
            return;
        }
        w3.gd().setVisibility(0);
    }

    public void ux() {
        com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w("corver_container");
        if (w3 == null || w3.gd() == null) {
            return;
        }
        w3.gd().setVisibility(8);
    }

    public boolean w() {
        return this.ys;
    }

    public int xv() {
        return 7;
    }

    private void w(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.component.b<View> w3;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(optString2) || (w3 = this.xv.w(optString2)) == null) {
            return;
        }
        if (TextUtils.equals(optString, "onDismiss")) {
            w3.w(8);
        } else if (TextUtils.equals(optString, "onShow")) {
            w3.w(0);
        }
    }

    public void c(ev evVar) {
        this.f35055p = evVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public void c(r rVar) {
        this.ux.n().c();
        JSONObject c4 = c();
        JSONObject gb = this.ux.gb();
        if (c4 != null && gb != null) {
            this.f35052c.g(this);
            this.f35052c.i(this);
            this.xv = this.f35052c.c(c4);
            this.ux.n().w();
            this.ux.n().xv();
            this.f35052c.k(gb);
            if (this.xv != null) {
                w wVar = new w();
                this.f35056r = wVar;
                wVar.c(true);
                this.f35056r.c(xv());
                com.bytedance.adsdk.ugeno.component.b<View> w3 = this.xv.w("VideoPlaceholder");
                this.ev = w3;
                if (w3 != null && (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c)) {
                    ((w) this.f35056r).c((FrameLayout) w3.gd());
                }
                int fp = this.xv.fp();
                int ia = this.xv.ia();
                a.w("UGenRender", "render: width=" + fp + "; height=" + ia);
                View gd = this.xv.gd();
                ViewGroup viewGroup = (ViewGroup) gd.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(gd);
                }
                this.f35053f.addView(this.xv.gd(), new FrameLayout.LayoutParams(fp, ia));
                float j4 = this.ux.j();
                float ls = this.ux.ls();
                a.w("UGenRender", "render: adWidth = " + j4 + "; adHeight = " + ls);
                float xv = xk.xv(this.f35058w, j4);
                float xv2 = xk.xv(this.f35058w, ls);
                int sr = xk.sr(this.f35058w);
                int ux = xk.ux(this.f35058w);
                float f4 = (float) sr;
                if (xv > f4) {
                    xv = f4;
                }
                float f5 = ux;
                if (xv2 > f5) {
                    xv2 = f5;
                }
                if (ls <= 0.0f) {
                    this.f35053f.setLayoutParams(new FrameLayout.LayoutParams((int) xv, -2));
                } else {
                    this.f35053f.setLayoutParams(new FrameLayout.LayoutParams((int) xv, (int) xv2));
                }
                if (ls > 0.0f && j4 > 0.0f) {
                    this.f35056r.c(j4);
                    this.f35056r.w(ls);
                } else {
                    this.f35053f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    int sr2 = xk.sr(this.f35058w, this.f35053f.getMeasuredWidth());
                    int sr3 = xk.sr(this.f35058w, this.f35053f.getMeasuredHeight());
                    this.f35056r.c(sr2);
                    this.f35056r.w(sr3);
                }
                if (this.gd.get()) {
                    rVar.c(137, (String) null);
                    return;
                } else {
                    rVar.c(this.f35053f, this.f35056r);
                    return;
                }
            }
            rVar.c(138, (String) null);
            return;
        }
        rVar.c(133, (String) null);
    }

    private void w(final h hVar, final b.InterfaceC0363b interfaceC0363b, final b.a aVar) {
        WeakReference<ViewGroup> weakReference = this.f35057t;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        eq.c(this.f35057t, new com.bytedance.sdk.openadsdk.core.w.xv() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.xv.1
            @Override // com.bytedance.sdk.openadsdk.core.w.xv
            public void c() {
                if (xv.this.f35057t == null || xv.this.f35057t.get() == null || !eq.c((View) xv.this.f35057t.get())) {
                    return;
                }
                xv.this.c(hVar, interfaceC0363b, aVar, true);
            }
        });
    }

    protected JSONObject c() {
        return this.ux.xv();
    }

    public void c(boolean z3) {
        this.gd.set(z3);
    }

    @Override // com.bytedance.adsdk.ugeno.w.b
    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar) {
        if (hVar == null) {
            return;
        }
        if (hVar.g() != 3) {
            if (hVar.g() == 9) {
                w(hVar.i());
                return;
            } else if (hVar.g() == 10) {
                c(hVar.i());
                return;
            } else if (hVar.g() == 17) {
                c(hVar, interfaceC0363b, aVar, false);
                return;
            } else {
                c(hVar, interfaceC0363b, aVar, false);
                return;
            }
        }
        w(hVar, interfaceC0363b, aVar);
    }

    private void c(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.component.b<View> w3;
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(optString2) || (w3 = this.xv.w(optString2)) == null) {
            return;
        }
        if (TextUtils.equals(optString, "onShow")) {
            w3.w(0);
        } else if (TextUtils.equals(optString, "onDismiss")) {
            w3.w(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, b.InterfaceC0363b interfaceC0363b, b.a aVar, boolean z3) {
        com.bytedance.adsdk.ugeno.component.b a4;
        int i4;
        CharSequence text;
        if (hVar == null || (a4 = hVar.a()) == null) {
            return;
        }
        JSONObject i5 = hVar.i();
        String optString = i5.optString("type");
        int i6 = -1;
        String str = "";
        if (TextUtils.equals(optString, "clickEvent")) {
            i4 = 2;
            str = i5.optString("subConvertLinkTag");
            i6 = i5.optInt("dpaPosition", -1);
        } else if (TextUtils.equals(optString, "muteVideo")) {
            i4 = 5;
            this.f35054k = i5.optString("muteSrc");
            this.f35051a = i5.optString("unmuteSrc");
        } else if (TextUtils.equals(optString, InteractionCommon.DISLIKE_TYPE_EXECUTION)) {
            i4 = 3;
        } else if (TextUtils.equals(optString, "skip")) {
            i4 = 6;
        } else if (TextUtils.equals(optString, "openPolicy")) {
            i4 = 7;
        } else if (TextUtils.equals(optString, "openAppPolicy")) {
            i4 = 9;
        } else if (TextUtils.equals(optString, "openAppPermission")) {
            i4 = 10;
        } else if (TextUtils.equals(optString, "close")) {
            i4 = 8;
        } else if (TextUtils.equals(optString, "openAppFunctionDesc")) {
            i4 = 12;
        } else {
            i4 = (TextUtils.equals(optString, "videoControl") || TextUtils.equals(optString, "pauseVideo")) ? 4 : 0;
        }
        u.c ux = new u.c().sr(this.bk.bk()).xv(this.bk.t()).w(this.bk.ys()).c(this.bk.fp()).c(a4.t()).w(this.bk.k()).c(this.bk.a()).ux(str).ux(i6);
        JSONObject jSONObject = new JSONObject();
        if (z3) {
            try {
                jSONObject.put("convertActionType", 1);
            } catch (Throwable unused) {
            }
        }
        View gd = a4.gd();
        try {
            if ((gd instanceof TextView) && (text = ((TextView) gd).getText()) != null && text.toString().contains("\u4e0b\u8f7d")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            me meVar = this.sr;
            if (meVar != null && meVar.dd() && this.ys && i5.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", optString);
            }
        } catch (JSONException unused3) {
        }
        ux.c(jSONObject);
        u c4 = ux.c();
        ev evVar = this.f35055p;
        if (evVar != null) {
            evVar.c(gd, i4, c4);
        }
        if (interfaceC0363b == null || hVar.f() == null) {
            return;
        }
        interfaceC0363b.c(hVar.f());
    }

    public void c(long j4, long j5) {
        com.bytedance.adsdk.ugeno.component.b bVar = this.ev;
        if (bVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.c.c) bVar).c(j4, j5);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.sr
    public void c(CharSequence charSequence, int i4, int i5, boolean z3) {
        com.bytedance.adsdk.ugeno.component.b<View> bVar = this.xv;
        if (bVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.component.b<View> w3 = bVar.w("count_down_skip_container");
        if (w3 != null && w3.gd() != null) {
            w3.gd().setVisibility(0);
        }
        com.bytedance.adsdk.ugeno.component.b<View> w4 = this.xv.w("count_down");
        com.bytedance.adsdk.ugeno.component.b<View> w5 = this.xv.w("skip");
        if ((w4 instanceof com.bytedance.adsdk.ugeno.component.text.b) && (w5 instanceof com.bytedance.adsdk.ugeno.component.text.b)) {
            if (i5 == 0) {
                if (!TextUtils.equals(charSequence, "0") && !z3) {
                    ((com.bytedance.adsdk.ugeno.component.text.b) w4).j(((Object) charSequence) + "s ");
                    com.bytedance.adsdk.ugeno.component.text.b bVar2 = (com.bytedance.adsdk.ugeno.component.text.b) w5;
                    bVar2.j("| \u8df3\u8fc7");
                    bVar2.gd().setVisibility(0);
                    return;
                }
                ((com.bytedance.adsdk.ugeno.component.text.b) w4).gd().setVisibility(8);
                ((com.bytedance.adsdk.ugeno.component.text.b) w5).j("\u8df3\u8fc7");
                return;
            }
            ((com.bytedance.adsdk.ugeno.component.text.b) w4).j(((Object) charSequence) + "s ");
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.l
    public void c(com.bytedance.adsdk.ugeno.component.b bVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.bk.xv(motionEvent.getRawX());
            this.bk.sr(motionEvent.getRawY());
            this.bk.w(System.currentTimeMillis());
            return;
        }
        this.bk.sr((int) motionEvent.getRawX());
        this.bk.ux((int) motionEvent.getRawY());
        this.bk.c(motionEvent.getRawX());
        this.bk.w(motionEvent.getRawY());
        this.bk.c(System.currentTimeMillis());
        this.bk.c(motionEvent.getToolType(0));
        this.bk.w(motionEvent.getDeviceId());
        this.bk.xv(motionEvent.getSource());
    }
}
