package com.bytedance.sdk.openadsdk.core.ugeno.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.bk;
import com.bytedance.sdk.openadsdk.core.u.ev;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.gd.xv;
import com.bytedance.sdk.openadsdk.core.ugeno.r.ux;
import com.bytedance.sdk.openadsdk.core.w.c.w.sr;
import com.bytedance.sdk.openadsdk.core.ys.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements p, ev, sr, xv {

    /* renamed from: a  reason: collision with root package name */
    protected String f34984a;
    protected Map<String, Object> bk;

    /* renamed from: c  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.f.c f34985c;
    protected b<View> ev;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.ugeno.sr.c f34986f;
    protected int fp;
    protected w fz;
    private FrameLayout gb;
    protected List<com.bytedance.adsdk.ugeno.c.c.f> gd;
    protected int ia;
    private f ls;

    /* renamed from: n  reason: collision with root package name */
    private boolean f34990n;

    /* renamed from: r  reason: collision with root package name */
    protected b<View> f34993r;

    /* renamed from: s  reason: collision with root package name */
    protected int f34994s;
    protected com.bytedance.sdk.openadsdk.core.a.ux sr;

    /* renamed from: t  reason: collision with root package name */
    protected JSONObject f34995t;

    /* renamed from: u  reason: collision with root package name */
    protected InterfaceC0515c f34996u;
    protected me ux;

    /* renamed from: w  reason: collision with root package name */
    protected Context f34997w;
    protected ViewGroup xv;
    protected int ys;

    /* renamed from: q  reason: collision with root package name */
    private boolean f34992q = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f34988j = true;

    /* renamed from: i  reason: collision with root package name */
    protected AtomicInteger f34987i = new AtomicInteger(2);

    /* renamed from: p  reason: collision with root package name */
    protected AtomicInteger f34991p = new AtomicInteger();

    /* renamed from: k  reason: collision with root package name */
    protected Map<Integer, Boolean> f34989k = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.r.c$5  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class AnonymousClass5 extends com.bytedance.sdk.component.gd.p {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f35002c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(String str, b bVar) {
            super(str);
            this.f35002c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            com.bytedance.sdk.openadsdk.core.q.w.c(cVar.ux, cVar.f34995t, new com.bytedance.sdk.openadsdk.core.ia.xv() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.5.1
                @Override // com.bytedance.sdk.openadsdk.core.ia.xv
                public void c(boolean z3, List<me> list, boolean z4) {
                    if (list != null && list.size() > 0) {
                        c.this.fp = list.size();
                        c.this.ia += list.size();
                        c cVar2 = c.this;
                        cVar2.f34994s = cVar2.t();
                        a.w("BasePageInflater", "\u5728\u3010" + c.this.f34994s + "\u3011\u4f4d\u7f6e\u5904\u8fdb\u884c\u9884\u8bf7\u6c42");
                        me meVar = list.get(0);
                        if (meVar != null) {
                            c.this.f34995t = meVar.ya();
                        }
                        final List<com.bytedance.adsdk.ugeno.c.c.f> c4 = c.this.c(list);
                        q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b bVar = AnonymousClass5.this.f35002c;
                                if (bVar == null || !(bVar instanceof com.bytedance.adsdk.ugeno.c.c.b)) {
                                    return;
                                }
                                ((com.bytedance.adsdk.ugeno.c.c.b) bVar).l(c4);
                            }
                        });
                        InterfaceC0515c interfaceC0515c = c.this.f34996u;
                        if (interfaceC0515c != null) {
                            interfaceC0515c.c();
                        }
                    } else if (c.this.f34987i.get() <= 0) {
                        InterfaceC0515c interfaceC0515c2 = c.this.f34996u;
                        if (interfaceC0515c2 != null) {
                            interfaceC0515c2.w();
                        }
                    } else {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        c.this.c(anonymousClass5.f35002c);
                        c.this.f34987i.decrementAndGet();
                    }
                }
            }, c.this.ux.oo());
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.r.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0515c {
        void c();

        void w();
    }

    public c(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.a.ux uxVar, me meVar, String str, int i4) {
        this.f34997w = context;
        this.xv = viewGroup;
        this.sr = uxVar;
        this.ux = meVar;
        this.f34984a = str;
        this.f34985c = meVar.ys();
        f fVar = new f(this.f34997w, this.sr, meVar, str, i4);
        this.ls = fVar;
        fVar.c((sr) this);
        this.ls.c((xv) this);
        if (this.ux.l() != null) {
            this.ls.c((ev) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public View fp() {
        this.gb = new FrameLayout(this.f34997w);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.gb.setBackground(gradientDrawable);
        GifView gifView = new GifView(this.f34997w);
        gifView.c(i.sr(this.f34997w, "tt_shop_page_guide_gif"), false);
        int ux = xk.ux(this.f34997w, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ux, ux);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = xk.ux(this.f34997w, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.gb.addView(gifView);
        TextView textView = new TextView(this.f34997w);
        textView.setText("\u9700\u8981\u6d4f\u89c8\u9875\u9762\u624d\u80fd\u9886\u53d6\u5956\u52b1");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = xk.ux(this.f34997w, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.gb.addView(textView);
        this.gb.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.gd.xv(this.f34997w, new xv.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.gd.xv.c
            public void c() {
                b<View> bVar = c.this.ev;
                if ((bVar instanceof com.bytedance.adsdk.ugeno.c.c.b) && bVar.gd() != null) {
                    ((RecyclerView) c.this.ev.gd()).xv(1);
                }
                c cVar = c.this;
                cVar.c(cVar.ev);
                c.this.gb.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.a.xv.c(c.this.ux, "landingpage", "in_web_click", (com.bytedance.sdk.openadsdk.ux.c.c) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.gd.xv.c
            public void w() {
                c.this.gb.setVisibility(8);
            }
        }, 200));
        this.gb.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.this.gb.setVisibility(8);
            }
        }, 3000L);
        return this.gb;
    }

    public void a() {
        try {
            this.gd = k();
            ux.c(this.f34985c, new ux.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ux.c
                public void c(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        c.this.sr.c(-1, "template info load fail");
                        com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.f34986f;
                        if (cVar != null) {
                            cVar.c(-1);
                            return;
                        }
                        return;
                    }
                    c cVar2 = c.this;
                    cVar2.c(jSONObject, cVar2.gd);
                }
            });
        } catch (Exception e4) {
            this.sr.c(-3, e4.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = this.f34986f;
            if (cVar != null) {
                cVar.c(-3);
            }
        }
    }

    public boolean bk() {
        b<View> w3;
        b<View> bVar = this.f34993r;
        return (bVar == null || (w3 = bVar.w("interactionWebView")) == null || w3.gd() == null || w3.gd().getVisibility() != 0) ? false : true;
    }

    public abstract List<com.bytedance.adsdk.ugeno.c.c.f> k();

    /* JADX INFO: Access modifiers changed from: protected */
    public int t() {
        int i4;
        a.w("BasePageInflater", "\u8ba1\u7b97\u9884\u8bf7\u6c42\u4f4d\u7f6e mCurrentAdCount = " + this.fp + "; mPreRequestNum = " + this.ys + "; mTotalAdCount = " + this.ia);
        int i5 = this.fp;
        int i6 = this.ys;
        if (i5 < i6) {
            i4 = this.ia - i5;
        } else {
            i4 = this.ia - i6;
        }
        return Math.max(i4, 0);
    }

    public void ys() {
    }

    public void w(boolean z3) {
        this.f34990n = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(me meVar, b bVar) {
        String c4 = wv.c(this.ux);
        com.bytedance.sdk.openadsdk.core.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c(this.f34997w, meVar, c4, wv.c(c4));
        Map<String, Object> ux = ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).ux();
        ux.put("click_element_type", bVar.t());
        Map<String, Object> map = this.bk;
        if (map != null) {
            ux.putAll(map);
        }
        final String jr = meVar.jr();
        com.bytedance.sdk.openadsdk.core.p.w.sr w3 = com.bytedance.sdk.openadsdk.core.p.xv.w(this.f34997w, meVar, c4);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c((com.bytedance.sdk.openadsdk.core.p.w.xv) w3);
        cVar.c(null, new gd());
        if (w3 != null) {
            w3.c(new com.bytedance.sdk.openadsdk.core.p.w.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.8
                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c() {
                    c.C0525c.c(jr, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void w(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 2, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void xv(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 4, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, long j5, String str, String str2) {
                    if (j4 > 0) {
                        c.C0525c.c(jr, 3, (int) ((j5 * 100) / j4));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(long j4, String str, String str2) {
                    c.C0525c.c(jr, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.w.c
                public void c(String str, String str2) {
                    c.C0525c.c(jr, 6, 100);
                }
            });
        }
        Context context = this.f34997w;
        if (context instanceof com.bytedance.sdk.openadsdk.core.r.w) {
            ((com.bytedance.sdk.openadsdk.core.r.w) context).c(2);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar) {
        this.f34986f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(JSONObject jSONObject, List<com.bytedance.adsdk.ugeno.c.c.f> list) {
        this.sr.w();
        this.ls.c((p) this);
        this.ls.c(jSONObject, list, new r() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(int i4, String str) {
                com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar = c.this.f34986f;
                if (cVar != null) {
                    cVar.c(i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.r
            public void c(b<View> bVar) {
                c cVar = c.this;
                cVar.f34993r = bVar;
                cVar.ev = cVar.ls.c();
                c.this.xv.addView(bVar.gd(), new FrameLayout.LayoutParams(bVar.fp(), bVar.ia()));
                if (c.this.f34990n) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) xk.xv(c.this.f34997w, 200.0f), (int) xk.xv(c.this.f34997w, 200.0f));
                    layoutParams.gravity = 17;
                    c cVar2 = c.this;
                    cVar2.xv.addView(cVar2.fp(), layoutParams);
                }
                com.bytedance.sdk.openadsdk.core.ugeno.sr.c cVar3 = c.this.f34986f;
                if (cVar3 != null) {
                    cVar3.c(bVar.gd());
                }
                c cVar4 = c.this;
                com.bytedance.sdk.openadsdk.core.a.xv.c(cVar4.ux, cVar4.f34984a, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.ux.c.c) null);
            }
        });
    }

    public void c(w wVar) {
        this.fz = wVar;
        f fVar = this.ls;
        if (fVar != null) {
            fVar.c(wVar);
        }
    }

    public void c(b bVar) {
        com.bytedance.sdk.component.gd.ev.w(new AnonymousClass5("shop_page", bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<com.bytedance.adsdk.ugeno.c.c.f> c(List<me> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (me meVar : list) {
            com.bytedance.adsdk.ugeno.c.c.f fVar = new com.bytedance.adsdk.ugeno.c.c.f();
            JSONObject mo = meVar.mo();
            try {
                mo.put("voice_btn_position", fp.t(this.ux));
            } catch (JSONException unused) {
            }
            fVar.b(-2134548432);
            fVar.c(mo);
            arrayList.add(fVar);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.ev
    public void w(b bVar) {
        Log.d("interact", "onTimer: webview\u7ec4\u4ef6\u5c55\u793a");
        me meVar = this.ux;
        if (meVar == null || meVar.l() == null) {
            return;
        }
        bVar.w(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(final me meVar, final b bVar) {
        if (TextUtils.equals(bVar.t(), CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
            com.bytedance.adsdk.ugeno.component.a bk = bVar.bk();
            if (bk != null) {
                b w3 = bk.w("video_" + meVar.tz());
                if (w3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.w wVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.w) w3;
                    if (wVar.ev()) {
                        wVar.xv(false);
                        if (bVar instanceof com.bytedance.adsdk.ugeno.component.image.b) {
                            ((com.bytedance.adsdk.ugeno.component.image.b) bVar).d(i.xv(this.f34997w, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    wVar.xv(true);
                    if (bVar instanceof com.bytedance.adsdk.ugeno.component.image.b) {
                        ((com.bytedance.adsdk.ugeno.component.image.b) bVar).d(i.xv(this.f34997w, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.f34992q) {
            if (!com.bytedance.sdk.openadsdk.core.ugeno.f.f(this.ux)) {
                c(this.ux, this.bk);
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, this.f34984a, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.ux.c.c) null);
            com.bytedance.sdk.openadsdk.core.a.xv.c(meVar, this.f34984a, "page_click", (com.bytedance.sdk.openadsdk.ux.c.c) null);
            this.f34992q = false;
        }
        c(meVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.gd.sr) {
            meVar.sr(1);
            me meVar2 = this.ux;
            if (meVar2 != null) {
                meVar.c(meVar2.ys());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.w.c.w.sr.c(meVar, this.f34997w) && com.bytedance.sdk.openadsdk.core.w.c.w.sr.c(meVar)) {
            com.bytedance.sdk.openadsdk.core.w.c.w.sr srVar = new com.bytedance.sdk.openadsdk.core.w.c.w.sr(meVar, this.f34997w);
            srVar.c(new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.6
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.w
                public void c() {
                    Log.d("BasePageInflater", "onCouponSuccess: ");
                    q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            me meVar3 = meVar;
                            if (meVar3 == null || meVar3.ue() == null) {
                                return;
                            }
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            Toast.makeText(c.this.f34997w, meVar.ue().sr(), 0).show();
                        }
                    });
                    c.this.w(meVar, bVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.w
                public void c(final String str, final boolean z3) {
                    Log.d("BasePageInflater", "onCouponSuccess: ");
                    q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z3 && "has_applied".equals(str)) {
                                Toast.makeText(c.this.f34997w, "\u4f60\u5df2\u9886\u5238\uff0c\u5feb\u53bb\u76f4\u64ad\u95f4\u4e0b\u5355\u5427", 0).show();
                            } else {
                                Toast.makeText(c.this.f34997w, "\u9886\u5238\u5931\u8d25", 0).show();
                            }
                        }
                    });
                    c.this.w(meVar, bVar);
                }
            });
            srVar.c(new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.r.c.7
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.sr.c
                public void c() {
                }
            });
            return;
        }
        w(meVar, bVar);
    }

    private void c(me meVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp;
        JSONObject w3;
        bk c4;
        if (meVar == null || (fp = meVar.fp()) == null || (w3 = fp.w()) == null || (c4 = bk.c(w3)) == null) {
            return;
        }
        if (c4.xv() == 0 || c4.xv() == 5) {
            meVar.c(c4);
        }
    }

    public void c(JSONObject jSONObject) {
        me c4;
        if (jSONObject == null || (c4 = com.bytedance.sdk.openadsdk.core.w.c(jSONObject)) == null) {
            return;
        }
        String c5 = wv.c(this.ux);
        HashMap hashMap = new HashMap();
        hashMap.put("is_slide", this.f34991p);
        com.bytedance.sdk.openadsdk.core.a.xv.c(c4, c5, hashMap, (Double) null);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.f34988j && this.f34991p.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.f34991p);
            jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.a.xv.c(c4, c5, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.ux.c.c) null);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    public void c(Map<String, Object> map) {
        this.bk = map;
    }

    public void c(InterfaceC0515c interfaceC0515c) {
        this.f34996u = interfaceC0515c;
    }

    private void c(me meVar, Map<String, Object> map) {
        if (meVar == null) {
            return;
        }
        String c4 = wv.c(meVar);
        int ev = xk.ev(ls.getContext());
        com.bytedance.sdk.openadsdk.core.a.xv.c("click", meVar, new ev.c().f(-1.0f).ux(-1.0f).sr(-1.0f).xv(-1.0f).w(-1L).c(-1L).xv(-1).sr(-1).ux(-1024).w(k.sr().w() ? 1 : 2).c(ev).c(xk.f(ls.getContext())).w(xk.r(ls.getContext())).c(), c4, true, map, -1, false);
    }
}
