package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.eq.ba;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.t;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.xv;
import com.bytedance.sdk.openadsdk.core.wx;
import com.bytedance.sdk.openadsdk.n.ev;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeVideoTsView extends FrameLayout implements xv.c, n.c, xv.c {

    /* renamed from: a  reason: collision with root package name */
    protected ImageView f35127a;
    private ViewTreeObserver au;

    /* renamed from: b  reason: collision with root package name */
    private PlayableFeedWebView f35128b;
    private long ba;
    private View.OnAttachStateChangeListener bj;
    protected ImageView bk;
    private ViewGroup bm;
    private boolean bw;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35129c;
    private NativeExpressVideoView ck;
    private boolean eq;
    protected boolean ev;

    /* renamed from: f  reason: collision with root package name */
    protected ViewGroup f35130f;
    protected int fp;
    public xv fz;
    private boolean gb;
    protected boolean gd;
    private boolean gw;

    /* renamed from: i  reason: collision with root package name */
    private String f35131i;
    AtomicBoolean ia;

    /* renamed from: j  reason: collision with root package name */
    private boolean f35132j;

    /* renamed from: k  reason: collision with root package name */
    protected ImageView f35133k;
    private boolean ls;

    /* renamed from: m  reason: collision with root package name */
    private int f35134m;
    private final String me;
    private w mt;

    /* renamed from: n  reason: collision with root package name */
    private boolean f35135n;
    private ViewTreeObserver.OnGlobalLayoutListener oo;
    private boolean ox;

    /* renamed from: p  reason: collision with root package name */
    protected RelativeLayout f35136p;
    private boolean pr;

    /* renamed from: q  reason: collision with root package name */
    private boolean f35137q;

    /* renamed from: r  reason: collision with root package name */
    protected FrameLayout f35138r;

    /* renamed from: s  reason: collision with root package name */
    boolean f35139s;
    protected me sr;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f35140t;

    /* renamed from: u  reason: collision with root package name */
    protected final AtomicBoolean f35141u;
    private boolean up;
    protected com.bykv.vk.openvk.component.video.api.sr.xv ux;
    private boolean vc;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35142w;
    private boolean wo;
    private TTViewStub wv;
    private xv.InterfaceC0335xv wx;

    /* renamed from: x  reason: collision with root package name */
    private int f35143x;
    private long xk;
    private AtomicBoolean xu;
    protected final Context xv;

    /* renamed from: y  reason: collision with root package name */
    private final n f35144y;
    protected String ys;
    private long yu;

    /* renamed from: z  reason: collision with root package name */
    private boolean f35145z;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(View view, int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w implements fp {

        /* renamed from: c  reason: collision with root package name */
        private t f35150c;

        /* renamed from: f  reason: collision with root package name */
        private int f35151f;

        /* renamed from: r  reason: collision with root package name */
        private int f35152r;
        private me sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private WeakReference<ViewGroup> f35153w;
        private WeakReference<GifView> xv = new WeakReference<>(null);

        public w(t tVar, ViewGroup viewGroup, me meVar, String str, int i4, int i5) {
            this.f35150c = tVar;
            this.f35153w = new WeakReference<>(viewGroup);
            this.sr = meVar;
            this.ux = str;
            this.f35151f = i4;
            this.f35152r = i5;
        }

        @Override // com.bytedance.sdk.component.ux.fp
        @ATSMethod(1)
        public void c(final k kVar) {
            try {
                a.w("copflg", "suc: ");
                ViewGroup viewGroup = this.f35153w.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.w.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) w.this.f35153w.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            w wVar = w.this;
                            wVar.c(context, wVar.f35150c, kVar, viewGroup2);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }, 100L);
            } catch (Exception e4) {
                c(1002, "", e4);
            }
        }

        @Override // com.bytedance.sdk.component.ux.fp
        @ATSMethod(2)
        public void c(int i4, String str, Throwable th) {
            a.f("copflg", "fail: " + str);
            GifView gifView = this.xv.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.sr, this.ux, 2);
        }

        private int c() {
            if (this.f35150c.f() > 0.0d) {
                double d4 = this.f35152r;
                double f4 = this.f35150c.f();
                Double.isNaN(d4);
                return (int) (d4 * f4);
            }
            return this.f35152r / 2;
        }

        private void c(Context context, FrameLayout.LayoutParams layoutParams, int i4) {
            if (this.f35150c.xv() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i4;
                layoutParams.bottomMargin = i4;
                return;
            }
            layoutParams.gravity = 8388659;
            layoutParams.leftMargin = i4;
            layoutParams.topMargin = xk.ux(context, 19.0f);
        }

        private void c(Object obj, k kVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (kVar.ev()) {
                    gifView.c((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                    return;
                }
                gifView.setImageDrawable(com.bytedance.sdk.openadsdk.core.eq.fp.c((byte[]) obj, 0));
            }
        }

        private void c(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Context context, t tVar, k kVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int ux = xk.ux(context, 12.0f);
            this.f35151f = viewGroup.getWidth() <= 0 ? this.f35151f : viewGroup.getWidth();
            this.f35152r = viewGroup.getHeight() <= 0 ? this.f35152r : viewGroup.getHeight();
            int c4 = c();
            if (tVar.c() == 3) {
                if (c4 > xk.ux(context, 88.0f)) {
                    c4 = xk.ux(context, 88.0f);
                }
            } else if (tVar.c() == 4 && c4 > xk.ux(context, 178.0f)) {
                c4 = xk.ux(context, 178.0f);
            }
            int i4 = this.f35151f - ux;
            double d4 = c4;
            double r3 = tVar.r();
            Double.isNaN(d4);
            int i5 = (int) (d4 * r3);
            if (i5 > i4 && i5 > 0 && i4 > 0) {
                layoutParams = new FrameLayout.LayoutParams(i4, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, c4);
            }
            c(context, layoutParams, ux);
            gifView.setVisibility(0);
            c(kVar.xv(), kVar, gifView);
            c(this.xv.get());
            viewGroup.addView(gifView, layoutParams);
            this.xv = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.sr, this.ux, 0);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface xv {
        void c(boolean z3, long j4, long j5, long j6, boolean z4, boolean z5);
    }

    public NativeVideoTsView(Context context, me meVar) {
        this(context, meVar, false, false);
    }

    private void ba() {
        if (this.bm == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.bm.hashCode()) {
                    a.w("xeasy", "bre:" + this.bm.hashCode());
                    return;
                }
            }
        }
    }

    private boolean ck() {
        if (ys()) {
            return false;
        }
        com.bytedance.sdk.component.f.c kvCache = getKvCache();
        return kvCache.w("key_video_is_from_detail_page", false) || kvCache.w("key_video_isfromvideodetailpage", false);
    }

    private boolean eq() {
        return 2 == ls.w().r(wv.gd(this.sr));
    }

    private void ev() {
        c(0L, 0);
        this.wx = null;
    }

    private void fz() {
        addView(c(this.xv));
        P_();
    }

    private void gb() {
        w(n());
        this.f35144y.sendEmptyMessageDelayed(1, this.xk);
    }

    private com.bytedance.sdk.component.f.c getKvCache() {
        return ba.c("sp_multi_native_video_data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.au;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.oo) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private boolean j() {
        return TextUtils.equals(this.ys, "splash_ad") || TextUtils.equals(this.ys, "cache_splash_ad");
    }

    private boolean ls() {
        return j() && getKvCache().w("key_video_is_form_splash_click_eye", false);
    }

    private boolean me() {
        return 5 == ls.w().r(wv.gd(this.sr));
    }

    private boolean n() {
        View view;
        if (!gd.c(this.sr)) {
            view = this;
        } else if (this.sr.y() == 2) {
            view = this.ck;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return wx.c(view, 50, 5);
    }

    private void q() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar == null) {
            return;
        }
        xvVar.sr(this.f35129c);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).c((xv.c) this);
        this.ux.c(this);
    }

    private void u() {
        if (!(this instanceof NativeDrawVideoTsView) || this.ia.get() || com.bytedance.sdk.openadsdk.core.k.sr().gb() == null) {
            return;
        }
        this.bk.setImageBitmap(com.bytedance.sdk.openadsdk.core.k.sr().gb());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bk.getLayoutParams();
        int xv2 = (int) xk.xv(getContext(), this.fp);
        layoutParams.width = xv2;
        layoutParams.height = xv2;
        this.bk.setLayoutParams(layoutParams);
        this.ia.set(true);
    }

    private void wv() {
        xk.ux(this.f35127a);
        xk.ux(this.f35136p);
    }

    private void xk() {
        if (TextUtils.isEmpty(this.ys)) {
            return;
        }
        com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
        if (this.ys.equals("draw_ad")) {
            c4.c("draw_show_time", System.currentTimeMillis());
        } else if (this.ys.equals("embeded_ad")) {
            c4.c("feed_show_time", System.currentTimeMillis());
        }
    }

    private void y() {
        com.bytedance.sdk.component.f.c kvCache = getKvCache();
        if (this.ux == null || ys() || !kvCache.w("key_video_is_update_flag", false)) {
            return;
        }
        boolean w3 = kvCache.w("key_native_video_complete", false);
        long w4 = kvCache.w("key_video_current_play_position", -1L);
        long w5 = kvCache.w("key_video_total_play_duration", this.ux.t() + this.ux.a());
        long w6 = kvCache.w("key_video_duration", this.ux.t());
        this.ux.xv(w3);
        if (w3) {
            this.ux.w(w6);
        } else {
            this.ux.w(w4);
        }
        this.ux.xv(w5);
        this.ux.sr(w6);
        kvCache.c("key_video_is_update_flag", false);
        a.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + w3 + ",position=" + w4 + ",totalPlayDuration=" + w5 + ",duration=" + w6);
    }

    private void z() {
        if (ys()) {
            return;
        }
        com.bytedance.sdk.component.f.c kvCache = getKvCache();
        kvCache.c("key_video_isfromvideodetailpage", false);
        kvCache.c("key_video_is_from_detail_page", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P_() {
        this.ux = c(this.xv, this.f35138r, this.sr, this.ys, !ys(), this.ls, this.gb);
        q();
        this.bj = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.au = nativeVideoTsView.f35130f.getViewTreeObserver();
                if (NativeVideoTsView.this.au == null || NativeVideoTsView.this.oo == null) {
                    return;
                }
                NativeVideoTsView.this.au.addOnGlobalLayoutListener(NativeVideoTsView.this.oo);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.i();
            }
        };
        this.oo = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.f35130f.getWidth();
                int height = NativeVideoTsView.this.f35130f.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) NativeVideoTsView.this.ux).w(width, height);
                NativeVideoTsView.this.i();
                NativeVideoTsView.this.w(width, height);
            }
        };
    }

    public void Q_() {
        xk.c((View) this.f35136p, 8);
        xv.InterfaceC0335xv interfaceC0335xv = this.wx;
        if (interfaceC0335xv != null && !this.ox) {
            this.ox = true;
            interfaceC0335xv.C_();
        }
        xk.c((View) this.f35136p, 8);
        PlayableFeedWebView playableFeedWebView = this.f35128b;
        if (playableFeedWebView != null) {
            playableFeedWebView.bk();
        }
    }

    public void a() {
        if (!this.f35141u.get()) {
            this.f35141u.set(true);
            com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
            if (xvVar != null) {
                xvVar.c(true, 3);
            }
        }
        this.xu.set(false);
    }

    public boolean bk() {
        return this.f35129c;
    }

    public void fp() {
        com.bykv.vk.openvk.component.video.api.sr.w s3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar == null || (s3 = xvVar.s()) == null) {
            return;
        }
        s3.c();
        View xv2 = s3.xv();
        if (xv2 != null) {
            xv2.setVisibility(8);
            if (xv2.getParent() != null) {
                ((ViewGroup) xv2.getParent()).removeView(xv2);
            }
        }
    }

    public void gd() {
        xv xvVar;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar2;
        if (this.f35142w || (xvVar = this.fz) == null || (xvVar2 = this.ux) == null) {
            return;
        }
        xvVar.c(xvVar2.u(), this.ux.t(), this.ux.t() + this.ux.a(), this.ux.k(), this.f35129c, this.ev);
    }

    public com.bykv.vk.openvk.component.video.api.sr.xv getNativeVideoController() {
        return this.ux;
    }

    public boolean getVideoError() {
        return this.f35132j;
    }

    public void ia() {
        if (this.ux != null) {
            wv();
            this.ux.w();
        }
    }

    public boolean k() {
        me meVar = this.sr;
        return meVar != null && meVar.ab() == 4 && this.sr.y() == 1 && !TextUtils.equals("draw_ad", this.ys);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.gw) {
            ViewGroup viewGroup = this.f35130f;
            if (viewGroup != null && (onAttachStateChangeListener = this.bj) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            sr();
            xk();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.f35130f;
        if (viewGroup != null && (onAttachStateChangeListener = this.bj) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        ux();
        this.mt = null;
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.gw) {
            sr();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        gd();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        ux();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar2;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar4;
        super.onWindowFocusChanged(z3);
        if (this.gw) {
            this.pr = z3;
            y();
            if (ck() && (xvVar4 = this.ux) != null && xvVar4.u()) {
                z();
                xk.c((View) this.f35136p, 8);
                sr(true);
                ev();
                return;
            }
            r();
            if (!ys() && bk() && (xvVar2 = this.ux) != null && !xvVar2.fp()) {
                if (this.f35144y != null) {
                    if (z3 && (xvVar3 = this.ux) != null && !xvVar3.u()) {
                        this.f35144y.obtainMessage(1).sendToTarget();
                        return;
                    }
                    this.f35144y.removeMessages(1);
                    w(false);
                }
            } else if (bk()) {
            } else {
                if (!z3 && (xvVar = this.ux) != null && xvVar.ia() != null && this.ux.ia().bk()) {
                    this.f35144y.removeMessages(1);
                    w(false);
                } else if (z3) {
                    this.f35144y.obtainMessage(1).sendToTarget();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i4) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar2;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar3;
        super.onWindowVisibilityChanged(i4);
        if (this.gw) {
            ba();
            y();
            if (this.wo) {
                this.wo = i4 == 0;
            }
            if (ck() && (xvVar3 = this.ux) != null && xvVar3.u()) {
                z();
                xk.c((View) this.f35136p, 8);
                sr(true);
                ev();
                return;
            }
            r();
            if (ys() || !bk() || (xvVar = this.ux) == null || xvVar.fp() || this.sr == null) {
                return;
            }
            boolean c4 = wx.c(this, 20, 5);
            a.w("NativeVideoAdView", "onWindowVisibilityChanged show:" + c4 + " " + isShown());
            if (this.f35145z && ng.bk(this.sr) != null && c4) {
                com.bykv.vk.openvk.component.video.api.xv.sr c5 = ng.c(4, this.sr);
                c5.w(this.sr.jr());
                c5.w(this.f35130f.getWidth());
                c5.xv(this.f35130f.getHeight());
                c5.xv(this.sr.cf());
                c5.c(this.ba);
                c5.w(t());
                c(c5);
                xk.c((View) this.f35136p, 8);
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onWindowVisibilityChanged materialMeta.getVideo() is null ");
                    sb.append(this.f35136p == null);
                    sb.append(" ");
                    sb.append(this.wo);
                    sb.append(" ");
                    sb.append(hashCode());
                    a.f("NativeVideoAdView", sb.toString());
                    if (this.wo && this.f35136p == null) {
                        p();
                        xk.c((View) this.f35136p, 0);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (i4 != 0 || !this.pr || this.f35144y == null || (xvVar2 = this.ux) == null || xvVar2.u()) {
                return;
            }
            this.f35144y.obtainMessage(1).sendToTarget();
        }
    }

    public void p() {
        TTViewStub tTViewStub;
        if (j() || this.xv == null || (tTViewStub = this.wv) == null || tTViewStub.getParent() == null || this.sr == null || this.f35136p != null) {
            return;
        }
        if (this.wv.getParent() != null && (this.wv.getParent() instanceof ViewGroup)) {
            this.f35136p = (RelativeLayout) this.wv.c();
        }
        this.f35133k = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387850);
        this.bk = imageView;
        if (this.f35140t) {
            xk.c((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(ng.w(this.sr))) {
            com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.sr)).c(this.f35133k);
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        me meVar = this.sr;
        if (meVar == null) {
            return;
        }
        int gd = wv.gd(meVar);
        int r3 = ls.w().r(gd);
        if (r3 == 1) {
            this.f35129c = ys.sr(this.xv);
        } else if (r3 == 2) {
            this.f35129c = ys.ux(this.xv) || ys.sr(this.xv) || ys.f(this.xv) || ys.xv(ls.getContext()) == 1;
        } else if (r3 == 3) {
            this.f35129c = false;
        } else if (r3 == 4) {
            this.f35139s = true;
        } else if (r3 == 5) {
            this.f35129c = ys.sr(this.xv) || ys.f(this.xv);
        }
        if (!this.f35142w) {
            this.ev = ls.w().sr(gd);
        } else {
            this.ev = false;
        }
        if ("splash_ad".equals(this.ys)) {
            this.f35129c = true;
            this.ev = true;
        }
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.sr(this.f35129c);
        }
        if ("feed_video_middle_page".equals(this.ys)) {
            this.f35129c = true;
        }
    }

    public void s() {
        n nVar = this.f35144y;
        if (nVar != null) {
            nVar.removeCallbacksAndMessages(null);
        }
    }

    public void setAdCreativeClickListener(c cVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) xvVar).c(cVar);
        }
    }

    public void setComplete(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.xv(z3);
        }
    }

    public void setControllerStatusCallBack(xv xvVar) {
        this.fz = xvVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) xvVar).c(cVar);
        }
    }

    public void setEnableAutoCheck(boolean z3) {
        this.gw = z3;
    }

    public void setEnableBlur(boolean z3) {
        this.gd = z3;
    }

    public void setIsAutoPlay(boolean z3) {
        me meVar;
        if (this.eq || (meVar = this.sr) == null) {
            return;
        }
        int r3 = ls.w().r(wv.gd(meVar));
        if (z3 && r3 != 4 && (!ys.ux(this.xv) ? !(!ys.f(this.xv) ? ys.sr(this.xv) : eq() || me()) : !eq())) {
            z3 = false;
        }
        this.f35129c = z3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.sr(z3);
        }
        if (!this.f35129c) {
            p();
            RelativeLayout relativeLayout = this.f35136p;
            if (relativeLayout != null) {
                xk.c((View) relativeLayout, 0);
                if (ng.bk(this.sr) != null) {
                    com.bytedance.sdk.openadsdk.r.w.c(ng.w(this.sr)).c(this.f35133k);
                } else {
                    a.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            xk.c((View) this.f35136p, 8);
        }
        this.eq = true;
    }

    public void setIsQuiet(boolean z3) {
        this.ev = z3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.w(z3);
        }
    }

    public void setMaterialMeta(me meVar) {
        this.sr = meVar;
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.ck = nativeExpressVideoView;
    }

    public void setNativeVideoAdListener(xv.c cVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(cVar);
        }
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.sr.xv xvVar) {
        this.ux = xvVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z3) {
        this.f35140t = z3;
    }

    public void setPlayableFeedWebView(PlayableFeedWebView playableFeedWebView) {
        this.f35128b = playableFeedWebView;
    }

    public void setVideoAdClickListenerTTNativeAd(com.bytedance.sdk.openadsdk.ys.w.w.t tVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) xvVar).c(tVar);
        }
    }

    public void setVideoAdInteractionListener(xv.InterfaceC0335xv interfaceC0335xv) {
        this.wx = interfaceC0335xv;
    }

    public void setVideoAdLoadListener(xv.sr srVar) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c(srVar);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.f35131i = str;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        if (i4 == 4 || i4 == 8) {
            a();
        }
    }

    public void sr() {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar == null) {
            P_();
        } else if ((xvVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) && !ys()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).au();
        }
        if (this.ux == null || !this.f35141u.get()) {
            return;
        }
        this.f35141u.set(false);
        r();
        if (bk()) {
            ImageView imageView = this.f35127a;
            if (imageView != null) {
                xk.c((View) imageView, 8);
            }
            if (ng.bk(this.sr) != null) {
                com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, this.sr);
                c4.w(this.sr.jr());
                c4.w(this.f35130f.getWidth());
                c4.xv(this.f35130f.getHeight());
                c4.xv(this.sr.cf());
                c4.c(0L);
                c4.c(gd.c(this.sr));
                c4.w(t());
                if (j()) {
                    String xv2 = ev.c(0).xv();
                    if (this.sr.ps()) {
                        xv2 = ev.c();
                    }
                    c4.c(xv2);
                }
                c(c4);
                this.ux.xv(false);
                return;
            }
            a.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        } else if (this.ux.u()) {
            a.w("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.ux.u());
            sr(true);
        } else {
            a.xv("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            p();
            xk.c((View) this.f35136p, 0);
        }
    }

    public boolean t() {
        return this.ev;
    }

    public void ux() {
        this.fz = null;
        if (ls()) {
            return;
        }
        fp();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ys() {
        return this.f35142w;
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public void w(long j4, int i4) {
        this.f35132j = true;
    }

    public void xv(boolean z3) {
        PlayableFeedWebView playableFeedWebView = this.f35128b;
        if (playableFeedWebView != null) {
            playableFeedWebView.w(z3);
        }
    }

    public NativeVideoTsView(Context context, me meVar, boolean z3, boolean z4) {
        this(context, meVar, z3, z4, "embeded_ad", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4, int i5) {
        if (ys()) {
            return;
        }
        me meVar = this.sr;
        t ti = meVar == null ? null : meVar.ti();
        if (ti == null) {
            return;
        }
        a.w("copflg", "vw: " + i4);
        a.w("copflg", "vh: " + i5);
        if (i5 <= 0) {
            return;
        }
        if (!ti.ev()) {
            com.bytedance.sdk.openadsdk.core.a.xv.xv(this.sr, this.ys, 1);
            return;
        }
        this.f35143x = i4;
        this.f35134m = i5;
        if (this.mt == null) {
            this.mt = new w(ti, this.f35130f, this.sr, this.ys, i4, i5);
        }
        com.bytedance.sdk.openadsdk.r.w.c(ti.ux()).xv(3).c(Bitmap.Config.RGB_565).c(this.mt);
    }

    public NativeVideoTsView(Context context, me meVar, String str, boolean z3, boolean z4) {
        this(context, meVar, false, false, str, z3, z4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
    public void c(long j4, int i4) {
        xv.InterfaceC0335xv interfaceC0335xv = this.wx;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.F_();
        }
    }

    public NativeVideoTsView(Context context, me meVar, boolean z3, boolean z4, String str, boolean z5, boolean z6) {
        super(context);
        this.f35129c = true;
        this.ev = true;
        this.f35142w = false;
        this.f35137q = false;
        this.f35132j = false;
        this.ls = false;
        this.gb = true;
        this.f35135n = false;
        this.f35140t = true;
        this.ys = "embeded_ad";
        this.fp = 50;
        this.f35145z = true;
        this.ia = new AtomicBoolean(false);
        this.f35144y = new n(this);
        this.eq = false;
        this.me = i.u();
        this.f35139s = false;
        this.xk = 50L;
        this.yu = 500L;
        this.pr = true;
        this.bw = false;
        this.gw = true;
        this.vc = true;
        this.f35141u = new AtomicBoolean(false);
        this.wo = true;
        this.xu = new AtomicBoolean(false);
        this.ys = str;
        this.xv = context;
        this.sr = meVar;
        this.f35142w = z3;
        this.f35135n = z4;
        this.ls = z5;
        this.gb = z6;
        setContentDescription("NativeVideoAdView");
        r();
        fz();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
    public void c() {
        if (this.wx == null || !j()) {
            return;
        }
        this.wx.F_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
    public void c(long j4, long j5) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar;
        xv.InterfaceC0335xv interfaceC0335xv = this.wx;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.c(j4, j5);
        }
        if (n() || (xvVar = this.ux) == null) {
            return;
        }
        xvVar.f();
    }

    private View c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387851);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.f35130f = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387758);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.f35138r = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.ux());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387606);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.wv = tTViewStub;
        return frameLayout;
    }

    private void w(boolean z3) {
        if (this.f35137q == z3) {
            return;
        }
        this.f35137q = z3;
        xv(z3);
        if (this.sr == null || this.ux == null) {
            return;
        }
        boolean ck = ck();
        z();
        if (ck && this.ux.u()) {
            a.w("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + ck + "\uff0cmNativeVideoController.isPlayComplete()=" + this.ux.u());
            sr(true);
            ev();
        } else if (z3 && !this.ux.u() && !this.ux.fp()) {
            if (this.ux.ia() != null && this.ux.ia().t()) {
                if (this.f35129c) {
                    if ("ALP-AL00".equals(this.me)) {
                        this.ux.ev();
                    } else {
                        if (!this.ux.j()) {
                            ck = true;
                        }
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) this.ux).f(ck);
                    }
                    xv.InterfaceC0335xv interfaceC0335xv = this.wx;
                    if (interfaceC0335xv != null) {
                        interfaceC0335xv.E_();
                        return;
                    }
                    return;
                }
                this.f35137q = false;
            } else if (this.f35129c && this.ux.ia() == null) {
                if (!this.f35141u.get()) {
                    this.f35141u.set(true);
                }
                this.xu.set(false);
                sr();
            }
        } else if (this.ux.ia() == null || !this.ux.ia().bk()) {
        } else {
            this.ux.f();
            xv.InterfaceC0335xv interfaceC0335xv2 = this.wx;
            if (interfaceC0335xv2 != null) {
                interfaceC0335xv2.D_();
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.wv.getParent() != null && (this.wv.getParent() instanceof ViewGroup)) {
            this.f35136p = (RelativeLayout) this.wv.c();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.f35133k = imageView;
        imageView.setImageDrawable(null);
        this.bk = (ImageView) findViewById(2114387850);
        com.bytedance.sdk.openadsdk.r.w.c(str).c(this.f35133k);
        xk.c((View) this.f35136p, 0);
    }

    public void sr(boolean z3) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            xvVar.xv(z3);
            com.bykv.vk.openvk.component.video.api.sr.w s3 = this.ux.s();
            if (s3 != null) {
                s3.w();
                View xv2 = s3.xv();
                if (xv2 != null) {
                    if (xv2.getParent() != null) {
                        ((ViewGroup) xv2.getParent()).removeView(xv2);
                    }
                    xv2.setVisibility(0);
                    addView(xv2);
                    s3.c(this.sr, new WeakReference<>(this.xv), false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bykv.vk.openvk.component.video.api.sr.xv c(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.xv(context, viewGroup, meVar, str, z3, z4, z5);
    }

    public boolean c(long j4, boolean z3, boolean z4) {
        boolean z5 = false;
        this.f35130f.setVisibility(0);
        if (this.ux == null) {
            this.ux = new com.bytedance.sdk.openadsdk.core.video.nativevideo.xv(this.xv, this.f35138r, this.sr, this.ys, this.ls, this.gb);
            q();
        }
        this.ba = j4;
        if (ys()) {
            this.ux.c(false);
            if (ng.bk(this.sr) != null) {
                com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, this.sr);
                c4.w(this.sr.jr());
                c4.w(this.f35130f.getWidth());
                c4.xv(this.f35130f.getHeight());
                c4.xv(this.sr.cf());
                c4.c(j4);
                c4.w(t());
                if (z4) {
                    this.ux.w(c4);
                    return true;
                }
                z5 = c(c4);
            }
            if (((j4 > 0 && !z3 && !z4) || (j4 > 0 && z3 && !this.f35135n)) && this.ux != null) {
                ia.c cVar = new ia.c();
                cVar.c(this.ux.k());
                cVar.xv(this.ux.t());
                cVar.w(this.ux.a());
                com.bytedance.sdk.openadsdk.ux.w.w.xv(this.ux.s(), cVar);
            }
            return z5;
        }
        if (k() || this.gd) {
            c(this.xv, 25, ng.w(this.sr));
        }
        return true;
    }

    public void w(boolean z3, boolean z4) {
        this.vc = z3;
        this.up = z4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(int i4) {
        if (ys.xv(ls.getContext()) == 0) {
            return;
        }
        if (this.ux.ia() != null) {
            if (this.ux.ia().bk() && i4 == 2) {
                w(false);
                n nVar = this.f35144y;
                if (nVar != null) {
                    nVar.removeMessages(1);
                }
                c(true);
                return;
            } else if (this.ux.ia().t() && i4 == 3) {
                this.f35129c = true;
                w(true);
                r();
                n nVar2 = this.f35144y;
                if (nVar2 != null) {
                    nVar2.sendEmptyMessageDelayed(1, this.xk);
                }
                c(false);
                return;
            }
        }
        if (bk() || this.xu.get()) {
            return;
        }
        this.xu.set(true);
        if (ng.bk(this.sr) != null) {
            wv();
            com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, this.sr);
            c4.w(this.sr.jr());
            c4.w(this.f35130f.getWidth());
            c4.xv(this.f35130f.getHeight());
            c4.xv(this.sr.cf());
            c4.c(this.ba);
            c4.w(t());
            c4.c(ev.c(this.sr.ou()).sr());
            c(c4);
        } else {
            a.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        n nVar3 = this.f35144y;
        if (nVar3 != null) {
            nVar3.sendEmptyMessageDelayed(1, this.xk);
        }
        c(false);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what != 1) {
            return;
        }
        gb();
    }

    public void c(PlayableFeedWebView playableFeedWebView, ViewGroup viewGroup) {
        c(playableFeedWebView);
        this.bm = viewGroup;
        setClipChildren(false);
    }

    public void c(PlayableFeedWebView playableFeedWebView) {
        setPlayableFeedWebView(playableFeedWebView);
        addView(this.f35128b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        if (this.ux != null) {
            this.f35145z = false;
            this.xk = this.yu;
            if (this.up) {
                srVar.w(this.vc);
            }
            return this.ux.c(srVar);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.c
    public void c(int i4) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z3) {
        if (this.f35127a == null) {
            this.f35127a = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.k.sr().gb() != null) {
                this.f35127a.setImageBitmap(com.bytedance.sdk.openadsdk.core.k.sr().gb());
            } else {
                this.f35127a.setImageDrawable(com.bytedance.sdk.component.utils.i.xv(ls.getContext(), "tt_new_play_video"));
            }
            this.f35127a.setScaleType(ImageView.ScaleType.FIT_XY);
            int xv2 = (int) xk.xv(getContext(), this.fp);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xv2, xv2);
            layoutParams.gravity = 17;
            this.f35130f.addView(this.f35127a, layoutParams);
        }
        if (z3) {
            this.f35127a.setVisibility(0);
        } else {
            this.f35127a.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        if (ys.xv(ls.getContext()) == 0) {
            return;
        }
        if (this.ux.ia() != null) {
            if (this.ux.ia().bk()) {
                w(false);
                n nVar = this.f35144y;
                if (nVar != null) {
                    nVar.removeMessages(1);
                }
                c(true);
                return;
            } else if (this.ux.ia().t()) {
                this.f35129c = true;
                w(true);
                r();
                n nVar2 = this.f35144y;
                if (nVar2 != null) {
                    nVar2.sendEmptyMessageDelayed(1, this.xk);
                }
                c(false);
                return;
            }
        }
        if (bk() || this.xu.get()) {
            return;
        }
        this.xu.set(true);
        if (ng.bk(this.sr) != null) {
            wv();
            com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, this.sr);
            c4.w(this.sr.jr());
            c4.w(this.f35130f.getWidth());
            c4.xv(this.f35130f.getHeight());
            c4.xv(this.sr.cf());
            c4.c(this.ba);
            c4.w(t());
            c(c4);
        } else {
            a.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        n nVar3 = this.f35144y;
        if (nVar3 != null) {
            nVar3.sendEmptyMessageDelayed(1, this.xk);
        }
        c(false);
    }

    public void c(int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) xvVar).w(i4, i5);
        }
    }

    public void c(final Context context, final int i4, String str) {
        final com.bykv.vk.openvk.component.video.api.sr.w s3;
        com.bykv.vk.openvk.component.video.api.sr.xv xvVar = this.ux;
        if (xvVar == null || (s3 = xvVar.s()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.w.c(str).c(Bitmap.Config.ARGB_4444).xv(2).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i5, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k<Bitmap> kVar) {
                Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(context, kVar.xv(), i4);
                if (c4 == null) {
                    return;
                }
                s3.c(new BitmapDrawable(NativeVideoTsView.this.getResources(), c4));
            }
        });
    }
}
