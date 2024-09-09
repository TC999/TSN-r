package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderSurfaceView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.api.sr.w;
import com.bykv.vk.openvk.component.video.c.ux.w;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.fz;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.w.c.c.w;
import com.bytedance.sdk.openadsdk.core.w.c.w.r;
import com.bytedance.sdk.openadsdk.core.widget.fp;
import com.bytedance.sdk.openadsdk.core.widget.ys;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.n.ev;
import com.bytedance.sdk.openadsdk.n.f;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements com.bykv.vk.openvk.component.video.api.renderview.c, com.bykv.vk.openvk.component.video.api.sr.w<me>, n.c, fp.w, ys.c {

    /* renamed from: a  reason: collision with root package name */
    TextView f35171a;
    private RelativeLayout au;

    /* renamed from: b  reason: collision with root package name */
    private TextView f35172b;
    boolean ba;
    private RoundImageView bj;
    TextView bk;
    private TextView bm;
    private TextView bw;

    /* renamed from: c  reason: collision with root package name */
    View f35173c;
    fp ck;
    com.bykv.vk.openvk.component.video.api.sr.xv eq;
    View ev;

    /* renamed from: f  reason: collision with root package name */
    ImageView f35174f;
    private final int fm;
    protected TTViewStub fp;
    int fz;
    me gb;
    ImageView gd;
    private RoundImageView gw;

    /* renamed from: h  reason: collision with root package name */
    private final int f35175h;

    /* renamed from: i  reason: collision with root package name */
    boolean f35176i;
    int ia;

    /* renamed from: j  reason: collision with root package name */
    int f35177j;

    /* renamed from: k  reason: collision with root package name */
    RoundImageView f35178k;
    EnumSet<w.c> ls;

    /* renamed from: m  reason: collision with root package name */
    private RelativeLayout f35179m;
    com.bytedance.sdk.openadsdk.core.w.c me;
    private TTViewStub mt;

    /* renamed from: n  reason: collision with root package name */
    Context f35180n;
    private com.bytedance.sdk.openadsdk.core.w.c ng;
    private final int oh;
    private Bitmap ok;
    private View oo;
    private int ox;

    /* renamed from: p  reason: collision with root package name */
    View f35181p;
    private TextView pr;

    /* renamed from: q  reason: collision with root package name */
    volatile boolean f35182q;

    /* renamed from: r  reason: collision with root package name */
    protected TTViewStub f35183r;

    /* renamed from: s  reason: collision with root package name */
    int f35184s;
    View sr;

    /* renamed from: t  reason: collision with root package name */
    TextView f35185t;
    private AtomicBoolean te;

    /* renamed from: u  reason: collision with root package name */
    int f35186u;
    private RelativeLayout up;
    View ux;
    private TextView vc;

    /* renamed from: w  reason: collision with root package name */
    com.bykv.vk.openvk.component.video.api.renderview.w f35187w;
    private String wo;
    com.bytedance.sdk.openadsdk.core.w.c wv;
    private View wx;

    /* renamed from: x  reason: collision with root package name */
    private NativeVideoTsView.c f35188x;
    com.bytedance.sdk.openadsdk.u.c.w.c.c xk;
    private boolean xu;
    ImageView xv;

    /* renamed from: y  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.p.w.xv f35189y;
    TTProgressBar ys;
    boolean yu;

    /* renamed from: z  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.video.nativevideo.c f35190z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c implements ITTDownloadAdapter.OnEventLogHandler {

        /* renamed from: c  reason: collision with root package name */
        private final boolean f35205c;

        /* renamed from: w  reason: collision with root package name */
        private final me f35206w;

        @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler
        public boolean onEventLog(int i4, String str, String str2, String str3, Object obj) {
            if (i4 == 2 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (str3.equals("click_start_play")) {
                    com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35206w, str2, this.f35205c ? "click_start" : "click_start_detail", (JSONObject) null);
                    return true;
                } else if (str3.equals("click_open")) {
                    if (this.f35205c) {
                        me meVar = this.f35206w;
                        com.bytedance.sdk.openadsdk.core.a.xv.gd(meVar, str2, wv.r(meVar), null);
                        return false;
                    }
                    com.bytedance.sdk.openadsdk.core.a.xv.ev(this.f35206w, str2, "click_open_detail", null);
                }
            }
            return true;
        }

        private c(boolean z3, me meVar) {
            this.f35205c = z3;
            this.f35206w = meVar;
        }
    }

    public ux(Context context, View view, boolean z3, EnumSet<w.c> enumSet, me meVar, com.bykv.vk.openvk.component.video.api.sr.xv xvVar, boolean z4, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this.f35176i = true;
        this.ba = true;
        this.yu = true;
        this.f35175h = 1;
        this.oh = 2;
        this.fm = 3;
        this.te = new AtomicBoolean(false);
        if (this instanceof sr) {
            return;
        }
        this.f35180n = StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext());
        sr(z4);
        this.f35173c = view;
        this.f35176i = z3;
        this.ls = enumSet == null ? EnumSet.noneOf(w.c.class) : enumSet;
        this.eq = xvVar;
        this.ng = cVar;
        this.gb = meVar;
        ba();
        sr(8);
        c(context, this.f35173c, meVar);
        sr();
        fp();
        bw();
    }

    private void ba() {
        this.ox = 1;
        String c4 = wv.c(this.gb);
        String str = "embeded_ad_landingpage";
        if (c4 == null) {
            c4 = this.ba ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.ox = wv.c(c4);
        if (!this.ba && c4.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.ba || !c4.equals("embeded_ad")) {
            str = c4;
        }
        this.wo = str;
    }

    private void bw() {
        if (this.gb == null || k.sr().ls()) {
            return;
        }
        f.c(new p("init_backup_cover_image") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!ux.this.te.get() && ng.bk(ux.this.gb) == null && ux.this.gb.sc() == 4) {
                        File file = new File(ev.c(ux.this.gb.ou()).c(), ng.f(ux.this.gb));
                        if (file.exists() && file.length() > 0) {
                            ux.this.ok = gd.c(file.getPath());
                        }
                        if (ux.this.ok == null) {
                            ux uxVar = ux.this;
                            uxVar.ok = gd.c(ng.w(uxVar.gb), new HashMap());
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
    }

    private void eq() {
        if (this.f35180n == null || this.f35173c == null) {
            return;
        }
        View view = new View(this.f35180n) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.8

            /* renamed from: w  reason: collision with root package name */
            private final AtomicBoolean f35203w = new AtomicBoolean(true);

            private void c() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar;
                if (!this.f35203w.getAndSet(false) || (xvVar = ux.this.f35189y) == null) {
                    return;
                }
                xvVar.xv();
            }

            private void w() {
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar;
                if (this.f35203w.getAndSet(true) || (xvVar = ux.this.f35189y) == null) {
                    return;
                }
                xvVar.f();
            }

            @Override // android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                ux.this.te.set(false);
                c();
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                ux.this.te.set(true);
                w();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                c();
            }

            @Override // android.view.View
            protected void onMeasure(int i4, int i5) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                w();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z3) {
                super.onWindowFocusChanged(z3);
                com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = ux.this.f35189y;
                if (xvVar != null) {
                    if (z3) {
                        xvVar.sr();
                    } else {
                        xvVar.ux();
                    }
                }
            }
        };
        View view2 = this.f35173c;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    private void ev(int i4) {
        xk.c(this.f35181p, i4);
        xk.c(this.wx, i4);
    }

    private boolean me() {
        if (this.gb == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.wo) || "rewarded_video".equals(this.wo)) {
            int fh = this.gb.fh();
            float yx = this.gb.yx();
            if (fh == 1 && yx == 100.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean pr() {
        me meVar;
        return this.ba && this.f35181p != null && (meVar = this.gb) != null && meVar.ck() == 1;
    }

    private void wv() {
        final long currentTimeMillis = System.currentTimeMillis();
        me meVar = this.gb;
        if (meVar != null && com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            String gd = ba.gd(this.gb);
            if (!TextUtils.isEmpty(gd)) {
                com.bytedance.sdk.openadsdk.r.w.c(gd).c(this.gw);
            }
            String xv = ba.xv(this.gb);
            String ev = ba.ev(this.gb);
            if (!TextUtils.isEmpty(xv)) {
                xk.c(this.vc, xv);
            }
            if (this.f35179m == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.r.w.c(ev).xv(2).c(new com.bytedance.sdk.component.ux.fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.10
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(com.bytedance.sdk.component.ux.k<Bitmap> kVar) {
                    Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(ux.this.f35180n, kVar.xv(), 25);
                    if (c4 == null) {
                        return;
                    }
                    ux.this.f35179m.setBackground(new BitmapDrawable(ux.this.f35179m.getResources(), c4));
                    ux uxVar = ux.this;
                    com.bytedance.sdk.openadsdk.core.a.xv.sr(uxVar.gb, uxVar.wo, System.currentTimeMillis() - currentTimeMillis);
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                    ux uxVar = ux.this;
                    com.bytedance.sdk.openadsdk.core.a.xv.c(uxVar.gb, uxVar.wo, i4, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.f35181p;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.f35173c;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.f35173c.getMeasuredHeight();
            int ux = xk.ux(this.f35180n, 200.0f);
            int ux2 = xk.ux(this.f35180n, 331.0f);
            int ux3 = xk.ux(this.f35180n, 110.0f);
            int ux4 = xk.ux(this.f35180n, 100.0f);
            if (measuredWidth >= ux && measuredHeight >= ux2) {
                f(1);
                return;
            }
            if (measuredWidth > ux3 && measuredHeight > ux4) {
                f(3);
                return;
            }
            f(2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private boolean xk() {
        return TextUtils.equals(this.wo, "splash_ad") || TextUtils.equals(this.wo, "cache_splash_ad");
    }

    private boolean y() {
        me meVar = this.gb;
        return meVar != null && meVar.rh() == null && this.gb.x() == 1 && me.w(this.gb);
    }

    private void yu() {
        if (xk()) {
            xk.c(this.sr, 8);
            xk.c(this.ux, 8);
            xk.c((View) this.f35174f, 8);
            xk.c((View) this.xv, 8);
            return;
        }
        xk.c(this.sr, 0);
        xk.c((View) this.f35179m, 8);
        xk.f(this.sr);
        xk.f(this.ux);
        if (this.f35174f == null || TextUtils.isEmpty(ng.w(this.gb))) {
            return;
        }
        xk.f(this.f35174f);
        com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.gb)).c(this.f35174f);
    }

    public void a() {
        c(true, false);
    }

    public boolean bk() {
        return this.f35182q;
    }

    public void c(long j4) {
    }

    public void c(long j4, long j5) {
    }

    public void c(Message message) {
    }

    public void c(View view, boolean z3) {
    }

    public void c(ViewGroup viewGroup) {
    }

    public void c(String str) {
    }

    public void ck() {
        me meVar;
        if (this.ok == null || (meVar = this.gb) == null || meVar.sc() != 4) {
            return;
        }
        c(false, this.f35176i);
        c(this.f35173c, ls.getContext());
        if (this.gd != null) {
            xk.c(this.ev, 0);
            xk.c((View) this.gd, 0);
            xk.c(this.f35181p, 8);
            this.gd.setImageBitmap(this.ok);
            this.ok = null;
        }
    }

    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fp() {
        com.bytedance.sdk.openadsdk.core.w.c cVar;
        View view;
        ba();
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            this.f35189y = com.bytedance.sdk.openadsdk.core.p.xv.c(this.f35180n, this.gb, this.wo);
            com.bytedance.sdk.openadsdk.core.w.c cVar2 = this.ng;
            if (cVar2 != null) {
                this.me = cVar2;
            } else {
                this.me = new com.bytedance.sdk.openadsdk.core.w.c(this.f35180n, this.gb, this.wo, this.ox);
            }
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f35189y);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.1
                @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
                public void c(View view2, int i4) {
                    if (ux.this.f35188x != null) {
                        ux.this.f35188x.c(view2, i4);
                    }
                }
            });
            if (this.ng == null && (view = this.f35173c) != null) {
                view.setOnClickListener(this.me);
                this.f35173c.setOnTouchListener(this.me);
            }
            if (xk.sr(this.up)) {
                this.up.setOnClickListener(this.me);
                this.up.setOnTouchListener(this.me);
                return;
            }
            return;
        }
        me meVar = this.gb;
        if (meVar != null && meVar.v() == 4) {
            this.f35189y = com.bytedance.sdk.openadsdk.core.p.xv.c(this.f35180n, this.gb, this.wo);
            this.f35189y.c(2, new c(this.ba, this.gb));
        }
        eq();
        com.bytedance.sdk.openadsdk.core.w.c cVar3 = new com.bytedance.sdk.openadsdk.core.w.c(this.f35180n, this.gb, this.wo, this.ox);
        this.me = cVar3;
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w(true);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.5
            @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
            public void c(View view2, int i4) {
                if (ux.this.f35188x != null) {
                    ux.this.f35188x.c(view2, i4);
                }
            }
        });
        w(this.me);
        ((com.bytedance.sdk.openadsdk.core.w.c.c.ev) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.ev.class)).ux(true);
        if (this.ba) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(false);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
        }
        if (this.f35189y != null && (cVar = this.me) != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f35189y);
        }
        if (y()) {
            com.bytedance.sdk.openadsdk.core.w.c cVar4 = new com.bytedance.sdk.openadsdk.core.w.c(this.f35180n, this.gb, this.wo, this.ox);
            this.wv = cVar4;
            w(cVar4);
            ((r) this.wv.c(r.class)).c(new r.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.6
                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.r.c
                public boolean c() {
                    fp fpVar = ux.this.ck;
                    boolean c4 = fpVar != null ? fpVar.c() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(c4);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(ux.this.xv.getVisibility() == 0);
                    a.xv("ClickCreativeListener", sb.toString());
                    return c4 || ux.this.xv.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.w.c.w.r.c
                public boolean w() {
                    if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(ux.this.gb)) {
                        return true;
                    }
                    View view2 = ux.this.ev;
                    if (view2 == null || view2.getVisibility() != 0) {
                        View view3 = ux.this.f35181p;
                        if (view3 == null || view3.getVisibility() != 0) {
                            RoundImageView roundImageView = ux.this.f35178k;
                            if (roundImageView == null || roundImageView.getVisibility() != 0) {
                                TextView textView = ux.this.f35171a;
                                return textView != null && textView.getVisibility() == 0;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            });
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).w(true);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(new w.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.7
                @Override // com.bytedance.sdk.openadsdk.core.w.c.c.w.c
                public void c(View view2, int i4) {
                    if (ux.this.f35188x != null) {
                        ux.this.f35188x.c(view2, i4);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.w.c.c.ev) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.ev.class)).ux(true);
            if (this.ba) {
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(false);
            }
            if (this.f35189y != null) {
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(this.f35189y);
            }
            c(this.wv);
            View view2 = this.f35173c;
            if (view2 != null) {
                view2.setOnClickListener(this.wv);
                this.f35173c.setOnTouchListener(this.wv);
            }
        }
    }

    void fz() {
        if (this.f35190z == null || this.ck != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        fp fpVar = new fp();
        this.ck = fpVar;
        fpVar.c(this.f35180n, this.f35173c);
        this.ck.c(this.f35190z, this);
        a.w("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gb() {
        xk.c(this.ev, 8);
        xk.c((View) this.gd, 8);
        xk.c(this.f35181p, 8);
        xk.c((View) this.f35178k, 8);
        xk.c((View) this.f35171a, 8);
        xk.c((View) this.bk, 8);
        xk.c((View) this.f35185t, 8);
        xk.c(this.oo, 8);
        xk.c((View) this.au, 8);
    }

    public void gd() {
        TTProgressBar tTProgressBar = this.ys;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.ys.setSecondaryProgress(0);
        }
        sr(8);
        if (z()) {
            this.f35187w.setVisibility(8);
        }
        ImageView imageView = this.f35174f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.gd;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        sr(8);
        xk.c(this.ev, 8);
        xk.c((View) this.gd, 8);
        xk.c(this.f35181p, 8);
        xk.c((View) this.f35178k, 8);
        xk.c((View) this.f35171a, 8);
        xk.c((View) this.bk, 8);
        xk.c(this.oo, 8);
        xk.c((View) this.au, 8);
        fp fpVar = this.ck;
        if (fpVar != null) {
            fpVar.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        if (this.f35190z == null) {
            a.f("NewLiveViewLayout", "callback is null");
            return false;
        }
        return true;
    }

    public com.bykv.vk.openvk.component.video.api.renderview.w ia() {
        return this.f35187w;
    }

    public void j() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            q();
        } else {
            xk.c((View) this.f35179m, 8);
            xk.f(this.sr);
            xk.f(this.ux);
        }
        ImageView imageView = this.xv;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        xk.c((View) this.xv, 8);
    }

    public boolean k() {
        return this.f35176i;
    }

    @TargetApi(14)
    public void ls() {
        xk.c(this.f35173c, 0);
        com.bykv.vk.openvk.component.video.api.renderview.w wVar = this.f35187w;
        if (wVar != null) {
            View view = wVar.getView();
            xk.c(view, 8);
            xk.c(view, 0);
        }
    }

    public void n() {
        me meVar = this.gb;
        if (meVar == null) {
            return;
        }
        if (this.gb.sc() != 5 ? meVar.sc() == 1 && m.ia(this.gb) : true) {
            c(false, this.f35176i);
            c(this.f35173c, ls.getContext());
            if (this.gd == null || TextUtils.isEmpty(ng.w(this.gb))) {
                return;
            }
            xk.c(this.ev, 0);
            xk.c((View) this.gd, 0);
            xk.c(this.f35181p, 8);
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.gb)).c(this.gd);
        }
    }

    public boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        xk.c(this.sr, 8);
        xk.c((View) this.f35179m, 0);
        wv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        if (this.gb == null) {
            return;
        }
        if (this.xu) {
            xk.c((View) this.f35172b, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            String gd = ba.gd(this.gb);
            String xv = ba.xv(this.gb);
            String ev = ba.ev(this.gb);
            xk.c(this.oo, 0);
            xk.c((View) this.au, 0);
            if (!TextUtils.isEmpty(gd)) {
                com.bytedance.sdk.openadsdk.r.w.c(gd).c(this.bj);
            }
            if (!TextUtils.isEmpty(xv)) {
                xk.c(this.bm, xv);
            }
            if (this.au == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.r.w.c(ev).xv(2).c(new com.bytedance.sdk.component.ux.fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.9
                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(2)
                public void c(int i4, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.ux.fp
                @ATSMethod(1)
                public void c(com.bytedance.sdk.component.ux.k<Bitmap> kVar) {
                    Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(ux.this.f35180n, kVar.xv(), 25);
                    if (c4 == null) {
                        return;
                    }
                    ux.this.au.setBackground(new BitmapDrawable(ux.this.au.getResources(), c4));
                }
            });
        }
    }

    public void t() {
    }

    public void u() {
        fp fpVar = this.ck;
        if (fpVar != null) {
            fpVar.c(false);
        }
    }

    public void ux() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void w(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void w(SurfaceTexture surfaceTexture, int i4, int i5) {
    }

    public void w(ViewGroup viewGroup) {
    }

    public void w(boolean z3) {
    }

    public void xv(boolean z3) {
    }

    public boolean xv(int i4) {
        return false;
    }

    public boolean ys() {
        fp fpVar = this.ck;
        return fpVar != null && fpVar.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return !this.ls.contains(w.c.alwayShowMediaView) || this.f35176i;
    }

    private int r(int i4) {
        if (this.fz <= 0 || this.f35186u <= 0) {
            return 0;
        }
        int ux = xk.ux(this.f35180n, 228.0f);
        int ux2 = xk.ux(this.f35180n, 160.0f);
        int i5 = (int) (this.f35186u * ((i4 * 1.0f) / this.fz));
        return i5 > ux ? ux : i5 < ux2 ? ux2 : i5;
    }

    private void w(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        me meVar;
        if (cVar == null || (meVar = this.gb) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ys.w.w.ys c4 = com.bytedance.sdk.openadsdk.core.video.sr.c.c(Integer.valueOf(meVar.hashCode()));
        if (c4 instanceof fz) {
            ((fz) c4).c((com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class));
        }
    }

    public void f(int i4) {
        me meVar;
        a.w("NewLiveViewLayout", "mode:" + i4);
        if (this.f35178k == null || (meVar = this.gb) == null || meVar.kr() == null || this.gb.kr().c() == null) {
            return;
        }
        if (i4 == 1) {
            int ux = xk.ux(this.f35180n, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ux, ux);
            layoutParams.addRule(14);
            this.f35178k.setLayoutParams(layoutParams);
            this.f35171a.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = xk.ux(this.f35180n, 16.0f);
            layoutParams2.topMargin = xk.ux(this.f35180n, 8.0f);
            layoutParams2.leftMargin = xk.ux(this.f35180n, 16.0f);
            layoutParams2.rightMargin = xk.ux(this.f35180n, 16.0f);
            layoutParams2.addRule(3, this.f35178k.getId());
            layoutParams2.addRule(14);
            this.bk.setLayoutParams(layoutParams2);
            this.bk.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, xk.ux(this.f35180n, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.bk.getId());
            layoutParams3.leftMargin = xk.ux(this.f35180n, 20.0f);
            layoutParams3.rightMargin = xk.ux(this.f35180n, 20.0f);
            this.f35185t.setPadding(xk.ux(this.f35180n, 36.0f), xk.ux(this.f35180n, 7.0f), xk.ux(this.f35180n, 36.0f), xk.ux(this.f35180n, 8.0f));
            this.f35185t.setLayoutParams(layoutParams3);
            this.f35185t.setEllipsize(TextUtils.TruncateAt.END);
            this.f35185t.setSingleLine(true);
            this.f35185t.setTextSize(14.0f);
        } else if (i4 == 2) {
            int ux2 = xk.ux(this.f35180n, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(ux2, ux2);
            layoutParams4.addRule(14);
            this.f35178k.setLayoutParams(layoutParams4);
            this.f35171a.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = xk.ux(this.f35180n, 8.0f);
            layoutParams5.topMargin = xk.ux(this.f35180n, 8.0f);
            layoutParams5.addRule(3, this.f35178k.getId());
            layoutParams5.addRule(14);
            this.bk.setLayoutParams(layoutParams5);
            this.bk.setTextSize(10.0f);
            xk.c((View) this.f35185t, 8);
        } else {
            int ux3 = xk.ux(this.f35180n, 49.0f);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(ux3, ux3);
            layoutParams6.addRule(14);
            this.f35178k.setLayoutParams(layoutParams6);
            this.f35171a.setLayoutParams(layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.bottomMargin = xk.ux(this.f35180n, 8.0f);
            layoutParams7.topMargin = xk.ux(this.f35180n, 8.0f);
            layoutParams7.addRule(3, this.f35178k.getId());
            layoutParams7.addRule(14);
            this.bk.setLayoutParams(layoutParams7);
            this.bk.setTextSize(13.0f);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, xk.ux(this.f35180n, 28.0f));
            layoutParams8.addRule(13);
            layoutParams8.addRule(3, this.bk.getId());
            int ux4 = xk.ux(this.f35180n, 20.0f);
            int ux5 = xk.ux(this.f35180n, 25.0f);
            int ux6 = xk.ux(this.f35180n, 6.0f);
            TextPaint paint = this.f35185t.getPaint();
            Rect rect = new Rect();
            CharSequence text = this.f35185t.getText();
            if (TextUtils.isEmpty(text)) {
                text = "";
            }
            String charSequence = text.toString();
            paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
            this.f35185t.setTextSize(13.0f);
            if (this.f35185t.getWidth() > (ux5 * 2) + rect.width() && this.f35185t.getHeight() > (ux6 * 2) + rect.height()) {
                layoutParams8.leftMargin = ux4;
                layoutParams8.rightMargin = ux4;
                this.f35185t.setPadding(ux5, xk.ux(this.f35180n, 5.0f), ux5, ux6);
            }
            this.f35185t.setEllipsize(TextUtils.TruncateAt.END);
            this.f35185t.setSingleLine(true);
            this.f35185t.setLayoutParams(layoutParams8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sr() {
        this.f35187w.c(this);
        ImageView imageView = this.xv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ux.this.i()) {
                        TextView textView = ux.this.f35185t;
                        if (textView == null || textView.getVisibility() != 0) {
                            ux uxVar = ux.this;
                            uxVar.f35190z.c(uxVar, view);
                        }
                    }
                }
            });
        }
    }

    public void ux(int i4) {
        xk.c(this.f35173c, 0);
        com.bykv.vk.openvk.component.video.api.renderview.w wVar = this.f35187w;
        if (wVar != null) {
            wVar.setVisibility(i4);
        }
    }

    public void xv(int i4, int i5) {
        this.fz = i4;
        this.f35186u = i5;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void c(Object obj, WeakReference weakReference, boolean z3) {
        c((me) obj, (WeakReference<Context>) weakReference, z3);
    }

    public void ev() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            xk.c((View) this.f35179m, 8);
        } else {
            xk.ux(this.sr);
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        me meVar;
        if (cVar == null || (meVar = this.gb) == null || !com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("click_live_element", "click_live_feed");
        ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).w(hashMap);
    }

    public void xv(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f35173c.getParent() == null) {
            viewGroup.addView(this.f35173c);
        }
        sr(0);
    }

    public void sr(boolean z3) {
        this.ba = z3;
        if (z3) {
            com.bytedance.sdk.openadsdk.core.w.c cVar = this.me;
            if (cVar != null) {
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
            }
            com.bytedance.sdk.openadsdk.core.w.c cVar2 = this.wv;
            if (cVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.w.c cVar3 = this.me;
        if (cVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar3.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.me.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
        }
        com.bytedance.sdk.openadsdk.core.w.c cVar4 = this.wv;
        if (cVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar4.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).xv(true);
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) this.wv.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(true);
        }
    }

    public void ux(boolean z3) {
        this.xu = z3;
    }

    private void w(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387892);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387687);
        if (me()) {
            xk.c((View) relativeLayout, 0);
            xk.c((View) relativeLayout2, 8);
            this.f35179m = relativeLayout;
        } else {
            xk.c((View) relativeLayout2, 0);
            xk.c((View) relativeLayout, 8);
            this.f35179m = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.f35179m;
        if (relativeLayout3 == null) {
            return;
        }
        this.gw = (RoundImageView) relativeLayout3.findViewById(2114387834);
        this.vc = (TextView) this.f35179m.findViewById(2114387743);
        this.up = (RelativeLayout) this.f35179m.findViewById(2114387692);
    }

    public void r() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.gb)) {
            q();
        } else {
            yu();
        }
        ImageView imageView = this.xv;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        xk.c((View) this.xv, 8);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.w
    public View xv() {
        return this.f35173c;
    }

    public void c(NativeVideoTsView.c cVar) {
        this.f35188x = cVar;
    }

    public void c(t tVar) {
        c(tVar, this.me);
        c(tVar, this.wv);
    }

    private void c(t tVar, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        j xv;
        if (cVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(tVar);
        com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar = (com.bytedance.sdk.openadsdk.core.w.c.xv.sr) cVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class);
        if ((tVar instanceof com.bytedance.sdk.openadsdk.core.i.c) && (xv = ((com.bytedance.sdk.openadsdk.core.i.c) tVar).xv()) != null) {
            xv.c(srVar);
        }
    }

    public void sr(int i4) {
        this.f35177j = i4;
        xk.c(this.f35173c, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView] */
    public void c(Context context, View view, me meVar) {
        SSRenderSurfaceView sSRenderSurfaceView;
        long currentTimeMillis = System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.eq;
        if (xvVar != null && xvVar.j()) {
            ?? sSRenderTextureView = new SSRenderTextureView(this.f35180n);
            a.w("NewLiveViewLayout", "use TextureView......");
            sSRenderSurfaceView = sSRenderTextureView;
        } else {
            SSRenderSurfaceView sSRenderSurfaceView2 = new SSRenderSurfaceView(this.f35180n);
            a.w("NewLiveViewLayout", "use SurfaceView......");
            sSRenderSurfaceView = sSRenderSurfaceView2;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderSurfaceView, 0, layoutParams);
            if (xk()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(-16777216);
            }
        }
        xk.c((View) sSRenderSurfaceView, 8);
        this.f35187w = sSRenderSurfaceView;
        this.xv = (ImageView) view.findViewById(2114387625);
        this.ys = (TTProgressBar) view.findViewById(2114387652);
        this.sr = view.findViewById(2114387904);
        this.ux = view.findViewById(2114387630);
        this.f35174f = (ImageView) view.findViewById(2114387650);
        this.f35183r = (TTViewStub) view.findViewById(2114387745);
        this.mt = (TTViewStub) view.findViewById(2114387665);
        this.fp = (TTViewStub) view.findViewById(2114387831);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            w(context, view);
        }
        a.w("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void w(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.fp) == null || tTViewStub.getParent() == null || this.wx != null) {
            return;
        }
        this.fp.c();
        this.wx = view.findViewById(2114387673);
        this.pr = (TextView) view.findViewById(2114387871);
        this.bw = (TextView) view.findViewById(2114387845);
    }

    public ux(Context context, View view, boolean z3, EnumSet<w.c> enumSet, me meVar, com.bykv.vk.openvk.component.video.api.sr.xv xvVar, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this(context, view, z3, enumSet, meVar, xvVar, true, cVar);
    }

    public void w(boolean z3, boolean z4) {
        ImageView imageView = this.xv;
        if (imageView != null) {
            if (z3) {
                imageView.setImageDrawable(i.xv(this.f35180n, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageDrawable(i.xv(this.f35180n, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void w(int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.f35173c;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i4 == -1 || i4 == -2 || i4 > 0) {
            layoutParams.width = i4;
        }
        if (i5 == -1 || i5 == -2 || i5 > 0) {
            layoutParams.height = i5;
        }
        this.f35173c.setLayoutParams(layoutParams);
    }

    public void w(int i4) {
        a.xv("Progress", "setSeekProgress-percent=" + i4);
        xk.c((View) this.ys, 0);
        TTProgressBar tTProgressBar = this.ys;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i4);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.w
    public void w() {
        if (xk()) {
            xk.c(this.sr, 8);
            xk.c(this.ux, 8);
            xk.c((View) this.f35174f, 8);
            xk.c((View) this.xv, 8);
            return;
        }
        xk.c((View) this.f35179m, 8);
        xk.ux(this.sr);
        xk.ux(this.ux);
        ImageView imageView = this.f35174f;
        if (imageView != null) {
            xk.ux(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.mt) == null || tTViewStub.getParent() == null || this.oo != null) {
            return;
        }
        this.oo = this.mt.c();
        this.au = (RelativeLayout) view.findViewById(2114387953);
        this.bj = (RoundImageView) view.findViewById(2114387958);
        this.bm = (TextView) view.findViewById(2114387932);
        this.f35172b = (TextView) view.findViewById(2114387880);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void w(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f35187w.getHolder()) {
            return;
        }
        this.f35182q = false;
        if (i()) {
            this.f35190z.w(this, surfaceHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.f35183r) == null || tTViewStub.getParent() == null || this.ev != null) {
            return;
        }
        this.ev = this.f35183r.c();
        this.f35183r.setVisibility(0);
        this.gd = (ImageView) view.findViewById(2114387806);
        this.f35181p = view.findViewById(2114387961);
        this.f35178k = (RoundImageView) view.findViewById(2114387663);
        this.f35171a = (TextView) view.findViewById(2114387957);
        this.bk = (TextView) view.findViewById(2114387766);
        this.f35185t = (TextView) view.findViewById(2114387685);
    }

    public boolean c(int i4, com.bykv.vk.openvk.component.video.api.xv.xv xvVar, boolean z3) {
        fp fpVar = this.ck;
        return fpVar == null || fpVar.c(i4, xvVar, z3);
    }

    public void c(com.bykv.vk.openvk.component.video.api.sr.c cVar) {
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.c) {
            this.f35190z = (com.bytedance.sdk.openadsdk.core.video.nativevideo.c) cVar;
            fz();
        }
    }

    public void c(int i4, int i5) {
        if (i4 == -1) {
            i4 = xk.sr(this.f35180n);
        }
        if (i4 <= 0) {
            return;
        }
        this.ia = i4;
        if (!k() && !p() && !this.ls.contains(w.c.fixedSize)) {
            this.f35184s = r(i4);
        } else {
            this.f35184s = i5;
        }
        w(this.ia, this.f35184s);
    }

    public void c() {
        c(false, this.f35176i);
        gb();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.w
    public void c(boolean z3) {
        this.yu = z3;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c(me meVar, WeakReference<Context> weakReference, boolean z3) {
        String ju;
        me meVar2;
        if (meVar == null || xk()) {
            return;
        }
        c(false, this.f35176i);
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(meVar)) {
            c(ls.getContext(), this.f35173c);
            s();
            return;
        }
        c(this.f35173c, ls.getContext());
        View view = this.ev;
        if (view != null) {
            xk.c(view, 0);
        }
        ImageView imageView = this.gd;
        if (imageView != null) {
            xk.c((View) imageView, 0);
        }
        if (wv.w(this.gb)) {
            w(this.f35173c, ls.getContext());
            xk.c(this.f35181p, 8);
            xk.c((View) this.gd, 0);
            xk.c(this.wx, 0);
            xk.c((View) this.pr, 0);
            xk.c((View) this.bw, 0);
            if (this.bw != null && com.bytedance.sdk.component.utils.ys.xv(ls.getContext()) == 0) {
                xk.c((View) this.bw, 8);
            }
            View view2 = this.ev;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.12
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = ux.this.eq;
                        if (xvVar != null) {
                            ((com.bykv.vk.openvk.component.video.api.sr.c) xvVar).c();
                            com.bytedance.sdk.openadsdk.u.c.w.c.c cVar = ux.this.xk;
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    }
                });
            }
            if (this.gd != null && !TextUtils.isEmpty(ng.w(this.gb))) {
                com.bykv.vk.openvk.component.video.c.ux.w.c(2147483647L, ng.c(this.gb), new w.InterfaceC0338w() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.2
                    @Override // com.bykv.vk.openvk.component.video.c.ux.w.InterfaceC0338w
                    public void c(Bitmap bitmap) {
                        if (bitmap != null) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ux.this.gd.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                layoutParams.width = xk.sr(ls.getContext());
                                layoutParams.height = (bitmap.getHeight() * xk.sr(ls.getContext())) / bitmap.getWidth();
                                layoutParams.addRule(13);
                                ux.this.gd.setLayoutParams(layoutParams);
                            }
                            ux.this.gd.setImageBitmap(bitmap);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.r.w.c(ng.w(ux.this.gb)).c(ux.this.gd);
                    }
                });
            }
        } else {
            xk.c(this.f35181p, 0);
            if (this.gd != null && !TextUtils.isEmpty(ng.w(this.gb))) {
                com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.gb)).c(this.gd);
            }
            if (pr()) {
                this.f35181p.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.ux.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ux.this.wx();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(meVar.yh())) {
            ju = meVar.yh();
        } else if (!TextUtils.isEmpty(meVar.ny())) {
            ju = meVar.ny();
        } else {
            ju = !TextUtils.isEmpty(meVar.ju()) ? meVar.ju() : "";
        }
        if (this.f35178k != null && (meVar2 = this.gb) != null && meVar2.kr() != null && this.gb.kr().c() != null) {
            xk.c((View) this.f35178k, 0);
            xk.c((View) this.f35171a, 4);
            com.bytedance.sdk.openadsdk.r.w.c(this.gb.kr()).c(this.f35178k);
            if (y()) {
                this.f35178k.setOnClickListener(this.wv);
                this.f35178k.setOnTouchListener(this.wv);
            } else {
                this.f35178k.setOnClickListener(this.me);
                this.f35178k.setOnTouchListener(this.me);
            }
        } else if (!TextUtils.isEmpty(ju)) {
            xk.c((View) this.f35178k, 4);
            xk.c((View) this.f35171a, 0);
            TextView textView = this.f35171a;
            if (textView != null) {
                textView.setText(ju.substring(0, 1));
                if (y()) {
                    this.f35171a.setOnClickListener(this.wv);
                    this.f35171a.setOnTouchListener(this.wv);
                } else {
                    this.f35171a.setOnClickListener(this.me);
                    this.f35171a.setOnTouchListener(this.me);
                }
            }
        }
        if (this.bk != null && !TextUtils.isEmpty(ju)) {
            this.bk.setText(ju);
        }
        xk.c((View) this.bk, 0);
        xk.c((View) this.f35185t, 0);
        String dk = meVar.dk();
        if (TextUtils.isEmpty(dk)) {
            int v3 = meVar.v();
            dk = v3 != 4 ? v3 != 5 ? "\u67e5\u770b\u8be6\u60c5" : "\u7acb\u5373\u62e8\u6253" : "\u7acb\u5373\u4e0b\u8f7d";
        }
        TextView textView2 = this.f35185t;
        if (textView2 != null) {
            textView2.setText(dk);
            this.f35185t.setOnClickListener(this.me);
            this.f35185t.setOnTouchListener(this.me);
        }
        TextView textView3 = this.pr;
        if (textView3 != null) {
            textView3.setText(dk);
            this.pr.setOnClickListener(this.me);
            this.pr.setOnTouchListener(this.me);
        }
        if (this.yu) {
            return;
        }
        ev(4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void c(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f35187w.getHolder()) {
            return;
        }
        this.f35182q = true;
        if (i()) {
            this.f35190z.c(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void c(SurfaceHolder surfaceHolder, int i4, int i5, int i6) {
        if (surfaceHolder == this.f35187w.getHolder() && i()) {
            this.f35190z.c(this, surfaceHolder, i4, i5, i6);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public void c(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.f35182q = true;
        if (i()) {
            this.f35190z.c(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.c
    public boolean c(SurfaceTexture surfaceTexture) {
        this.f35182q = false;
        if (i()) {
            this.f35190z.w(this, surfaceTexture);
            return true;
        }
        return true;
    }

    public void c(boolean z3, boolean z4, boolean z5) {
        int i4 = 0;
        xk.c((View) this.ys, 0);
        xk.c((View) this.xv, (z3 && (xk.sr(this.sr) && xk.sr(this.f35179m))) ? 8 : 8);
    }

    public void c(boolean z3, boolean z4) {
        xk.c((View) this.ys, z3 ? 0 : 8);
        xk.c((View) this.xv, 8);
    }

    public void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
        this.xk = cVar;
        com.bytedance.sdk.openadsdk.core.w.c cVar2 = this.me;
        if (cVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.w.c.c.w) cVar2.c(com.bytedance.sdk.openadsdk.core.w.c.c.w.class)).c(cVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.w
    public void c(Drawable drawable) {
        View view = this.f35173c;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.w
    public void c(int i4) {
        xk.c((View) this.up, i4);
    }

    public void c(c.InterfaceC0499c interfaceC0499c) {
        com.bytedance.sdk.openadsdk.core.p.w.xv xvVar = this.f35189y;
        if (xvVar != null) {
            xvVar.c(interfaceC0499c);
        }
    }
}
