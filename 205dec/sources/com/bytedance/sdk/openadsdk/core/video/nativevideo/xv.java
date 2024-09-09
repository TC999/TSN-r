package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.c;
import com.bykv.vk.openvk.component.video.api.sr.w;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.u.b;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.fp;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.res.layout.video.f;
import com.bytedance.sdk.openadsdk.res.layout.video.r;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends com.bytedance.sdk.openadsdk.core.video.c.c {

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f35207b;
    private final boolean ba;
    private long bj;
    private int bm;
    private ViewGroup gb;
    private WeakReference<c> gw;

    /* renamed from: h  reason: collision with root package name */
    private int f35208h;

    /* renamed from: m  reason: collision with root package name */
    private WeakReference<xv.sr> f35209m;
    private String me;
    private long ng;
    private int up;
    private int vc;
    private boolean wv;
    private boolean xk;
    private WeakReference<xv.w> yu;

    /* renamed from: z  reason: collision with root package name */
    private xv.c f35213z;

    /* renamed from: n  reason: collision with root package name */
    private long f35210n = 0;
    private long ck = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f35212y = false;
    private boolean eq = false;
    private boolean wx = false;
    private boolean pr = false;
    private boolean bw = true;

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f35211x = false;
    private int mt = 0;
    private boolean oo = false;
    private boolean au = true;
    private c.InterfaceC0334c wo = new c.InterfaceC0334c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1
        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.1
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.bm();
                }
            });
            xv.this.c(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void sr(com.bykv.vk.openvk.component.video.api.c cVar) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void ux(com.bykv.vk.openvk.component.video.api.c cVar) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void w(com.bykv.vk.openvk.component.video.api.c cVar) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (xv.this.f35209m != null && xv.this.f35209m.get() != null) {
                        ((xv.sr) xv.this.f35209m.get()).B_();
                    }
                    if (!xv.this.ba || gd.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f)) {
                        xv.this.ng();
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.removeCallbacks(xv.this.ls);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void w(com.bykv.vk.openvk.component.video.api.c cVar, int i4) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void xv(com.bykv.vk.openvk.component.video.api.c cVar) {
            xv.this.te();
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, long j4) {
            a.w("NativeVideoController", "onRenderStart");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.removeCallbacks(xv.this.ls);
                        xv.this.oo = false;
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35108a && xv.this.gw != null && xv.this.gw.get() != null) {
                        ((c) xv.this.gw.get()).Q_();
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.removeCallbacks(xv.this.ls);
                }
            });
            xv.this.ng();
            xv.this.bj = System.currentTimeMillis();
            xv.this.eu();
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, final com.bykv.vk.openvk.component.video.api.xv.w wVar) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.4
                @Override // java.lang.Runnable
                public void run() {
                    int c4 = wVar.c();
                    int w3 = wVar.w();
                    xv.this.sr(c4, w3);
                    a.f("NativeVideoController", "CALLBACK_ON_ERROR\u3001\u3001before isVideoPlaying\u3001\u3001\u3001\u3001\u3001");
                    if (!xv.this.oo() || w3 == -1004) {
                        a.f("NativeVideoController", "\u51fa\u9519\u540e errorcode,extra\u3001\u3001\u3001\u3001\u3001\u3001\u3001" + c4 + "," + w3);
                        if (xv.this.f(c4, w3) || com.bytedance.sdk.openadsdk.core.video.xv.c.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f)) {
                            a.f("NativeVideoController", "\u51fa\u9519\u540e\u5c55\u793a\u7ed3\u679c\u9875\u3001\u3001\u3001\u3001\u3001\u3001\u3001");
                            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).gd, false);
                            xv.this.xv(true);
                            xv.this.p();
                        } else if (c4 == 1 && (w3 == -19 || w3 == -38)) {
                            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).gd, false);
                            xv.this.p();
                        }
                        if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                        }
                        if (xv.this.f35213z != null) {
                            xv.this.f35213z.w(xv.this.ck, com.bykv.vk.openvk.component.video.c.ux.c.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35116r, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).fp));
                        }
                        if (xv.this.f35209m == null || xv.this.f35209m.get() == null || xv.this.oo()) {
                            return;
                        }
                        ((xv.sr) xv.this.f35209m.get()).c(c4, w3);
                    }
                }
            });
            xv.this.c(wVar.c(), wVar.xv());
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, boolean z3) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, final int i4, final int i5) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.6
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.xv(i4, i5);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, int i4, int i5, int i6) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.j();
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.postDelayed(xv.this.ls, 8000L);
                        xv.this.oo = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, int i4) {
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.8
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.removeCallbacks(xv.this.ls);
                    xv.this.oo = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, final long j4, final long j5) {
            if (Math.abs(j4 - ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35116r) < 50) {
                return;
            }
            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35111i != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35111i.c(j4, j5);
                    }
                    xv.this.w(j4, j5);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, JSONObject jSONObject, String str) {
            if (k.sr().z()) {
                a.w("livePlayerMonitor", "start: " + jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_START) + "\nsdk_dns_analysis_end: " + jSONObject.optString("sdk_dns_analysis_end") + "\nplayer_dns_analysis_end: " + jSONObject.optString("player_dns_analysis_end") + "\ntcp_connect_end: " + jSONObject.optString("tcp_connect_end") + "\ntcp_first_package_end: " + jSONObject.optString("tcp_first_package_end") + "\nfirst_video_package_end: " + jSONObject.optString("first_video_package_end") + "\nfirst_frame_video_decode_end: " + jSONObject.optString("first_frame_video_decode_end") + "\nfirst_frame_render_end: " + jSONObject.optString("first_frame_render_end"));
                StringBuilder sb = new StringBuilder();
                sb.append("firstframeRender cost(ms): ");
                sb.append(jSONObject.optLong("first_frame_render_end") - jSONObject.optLong(CampaignEx.JSON_NATIVE_VIDEO_START));
                a.w("livePlayerMonitor", sb.toString());
            }
            com.bytedance.sdk.openadsdk.core.a.xv.c((Context) ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).gd.get(), ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f, xv.this.me, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int ox = 0;
    private long xu = 0;
    Runnable ls = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.4
        @Override // java.lang.Runnable
        public void run() {
            if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux != null) {
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).gd, false);
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.w();
                xv.this.xv(true);
                a.f("NativeVideoController", "\u51fa\u9519\u540e\u5c55\u793a\u7ed3\u679c\u9875\u3001\u3001\u3001\u3001\u3001\u3001\u3001showAdCard");
            }
        }
    };
    private final ls.c ok = new ls.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.6
        @Override // com.bytedance.sdk.component.utils.ls.c
        public void c(Context context, Intent intent, boolean z3, int i4) {
            xv.this.xv(context, i4);
        }
    };
    private boolean oh = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv$9  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f35236c;

        static {
            int[] iArr = new int[fp.c.values().length];
            f35236c = iArr;
            try {
                iArr[fp.c.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35236c[fp.c.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35236c[fp.c.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void Q_();

        void c(int i4);
    }

    public xv(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4, boolean z5) {
        this.me = "embeded_ad";
        this.wv = false;
        this.xk = true;
        this.vc = 0;
        this.up = 0;
        this.f35208h = 1;
        this.f35208h = ys.xv(context);
        c(z3);
        this.me = str;
        try {
            this.vc = viewGroup.getWidth();
            this.up = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.gb = viewGroup;
        this.gd = new WeakReference<>(context);
        this.f35110f = meVar;
        c(context);
        this.ba = true;
        this.wv = z4;
        this.xk = z5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void f(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean sr() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean ux() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean xv() {
        return false;
    }

    private boolean b() {
        return this.ox >= 1 && wv.w(this.f35110f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm() {
        ux uxVar;
        boolean z3 = true;
        this.ox++;
        if (y() && (uxVar = this.ux) != null) {
            uxVar.w();
            xv.c cVar = this.f35213z;
            if (cVar != null) {
                cVar.c(this.ck, com.bykv.vk.openvk.component.video.c.ux.c.c(this.f35116r, this.fp));
            }
            this.ck = System.currentTimeMillis() - this.f35210n;
            this.ux.ux(true);
            boolean c4 = com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f);
            int yu = this.f35110f.yu();
            boolean z4 = yu <= 0;
            boolean z5 = !z4 && this.ox >= yu;
            boolean w3 = wv.w(this.f35110f);
            if (!w3 || z5 || c4) {
                this.ux.c(this.f35110f, this.gd, true);
            }
            if (!this.eq || b() || wo()) {
                this.eq = true;
                long j4 = this.fp;
                w(j4, j4);
                long j5 = this.fp;
                this.f35116r = j5;
                this.ev = j5;
                ia.c cVar2 = new ia.c();
                cVar2.c(k());
                cVar2.xv(t());
                cVar2.w(a());
                cVar2.f(bk());
                com.bytedance.sdk.openadsdk.ux.w.w.f(this.ux, cVar2);
            }
            if (!this.f35108a && this.fz) {
                ux(this.ux, (View) null);
            }
            this.f35117s = true;
            if (c4) {
                return;
            }
            if (w3 && (z4 || this.ox < yu)) {
                n();
                return;
            }
            if (!((gd.c(this.f35110f) && (((t() / 1000) > 10L ? 1 : ((t() / 1000) == 10L ? 0 : -1)) < 0)) ? false : false) || this.ox >= 2) {
                return;
            }
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f) && !TextUtils.isEmpty(this.me)) {
            com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
            if (this.me.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.ux(this.f35110f, "embeded_ad", System.currentTimeMillis() - c4.w("feed_show_time", 0L));
            } else if (this.me.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.ux(this.f35110f, "draw_ad", System.currentTimeMillis() - c4.w("draw_show_time", 0L));
            }
        }
    }

    private void fm() {
        if (y()) {
            ev(!this.fz);
            if (!(this.gd.get() instanceof Activity)) {
                a.w("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.w(this.gb);
                this.ux.xv(false);
            }
            ux(1);
            WeakReference<xv.w> weakReference = this.yu;
            xv.w wVar = weakReference != null ? weakReference.get() : null;
            if (wVar != null) {
                wVar.c(this.fz);
            }
        }
    }

    private void ge() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.sr(0);
            this.ux.c(false, false);
            this.ux.xv(false);
            this.ux.ux();
            this.ux.r();
        }
    }

    private boolean h() {
        b bb;
        if (ok()) {
            me meVar = this.f35110f;
            return meVar == null || (bb = meVar.bb()) == null || bb.c() != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ng() {
        if (!this.f35212y || b()) {
            ia.c cVar = new ia.c();
            if (ok()) {
                this.bw = true;
            }
            cVar.w(this.bw);
            cVar.xv(t());
            com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux, cVar);
            this.f35212y = true;
        }
    }

    private boolean oh() {
        me meVar = this.f35110f;
        return meVar != null && meVar.gw() == 1 && "draw_ad".equals(this.me) && this.gb != null;
    }

    private boolean ok() {
        return TextUtils.equals(this.me, "splash_ad") || TextUtils.equals(this.me, "cache_splash_ad");
    }

    private boolean ox() {
        return this.f35108a && k.sr().pr() > 0;
    }

    private boolean ta() {
        int i4 = Build.VERSION.SDK_INT;
        me meVar = this.f35110f;
        if (meVar == null || meVar.ou() != 1 || i4 >= 23) {
            if ((com.bytedance.sdk.openadsdk.core.eq.ls.w() && i4 == 30) || me.sr(this.f35110f)) {
                return true;
            }
            return k.sr().ls();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te() {
        ux uxVar;
        if (!this.f35211x || (uxVar = this.ux) == null || uxVar.xv() == null) {
            return;
        }
        this.f35211x = false;
        this.ux.xv().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.5
            @Override // java.lang.Runnable
            public void run() {
                if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u == null) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.w(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f.jr());
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.w(xv.this.vc);
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.xv(xv.this.up);
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.c((List<String>) null);
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.xv(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35110f.cf());
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.c(0L);
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.w(xv.this.fz());
                ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35119u.ux());
                xv xvVar = xv.this;
                xvVar.c(((com.bytedance.sdk.openadsdk.core.video.c.c) xvVar).f35119u);
                xv.this.xv(false);
            }
        });
    }

    private boolean ux(int i4, int i5) {
        return i4 < i5 && oh();
    }

    private boolean wo() {
        return this.ox >= 1 && gd.c(this.f35110f);
    }

    private void xu() {
        com.bykv.vk.openvk.component.video.api.xv.sr srVar;
        a.w("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.f35114p));
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            if (cVar.t() && !ox()) {
                if (!this.f35114p && ((srVar = this.f35119u) == null || !srVar.r())) {
                    w(this.f35112j);
                } else {
                    wx();
                }
                a.w("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.f35114p));
            } else if (ox()) {
                this.f35116r = k.sr().pr();
                k.sr().c(-1L);
                this.sr.c(this.f35116r);
                this.sr.w();
            } else {
                this.sr.c(false, this.f35116r, this.ia);
            }
        }
        if (this.f35212y) {
            ia.c cVar2 = new ia.c();
            cVar2.c(k());
            cVar2.xv(t());
            cVar2.w(a());
            com.bytedance.sdk.openadsdk.ux.w.w.xv(s(), cVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public long a() {
        if (ia() == null) {
            return 0L;
        }
        return ia().fp();
    }

    public void au() {
        if (this.oh || !this.au) {
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(com.bytedance.sdk.openadsdk.core.ls.getContext().getApplicationContext());
        this.oh = true;
        ls.c(this.ok, origApplicationContext);
    }

    public void bj() {
        if (this.oh && this.au) {
            this.oh = false;
            try {
                ls.c(this.ok);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public int bk() {
        if (ia() == null) {
            return 0;
        }
        return ia().ia();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void ev() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
        }
        ux uxVar2 = this.ux;
        if (uxVar2 != null) {
            uxVar2.ls();
        }
        xu();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void f() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.xv();
        }
        if ((!this.eq || b()) && this.f35212y) {
            ia.c cVar2 = new ia.c();
            cVar2.c(k());
            cVar2.xv(t());
            cVar2.w(a());
            com.bytedance.sdk.openadsdk.ux.w.w.w(this.ux, cVar2);
        }
    }

    public boolean gb() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        return cVar == null || cVar.gd();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void gd() {
        c(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean i() {
        return this.bw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean j() {
        return com.bytedance.sdk.openadsdk.core.ls.w().u() || ta();
    }

    protected com.bykv.vk.openvk.component.video.api.renderview.w ls() {
        ux uxVar;
        WeakReference<Context> weakReference = this.gd;
        if (weakReference == null || weakReference.get() == null || this.gd.get().getResources().getConfiguration().orientation != 1 || (uxVar = this.ux) == null) {
            return null;
        }
        return uxVar.ia();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    protected Map<String, Object> mt() {
        return this.f35207b;
    }

    public void n() {
        if (ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext()) == 0) {
            return;
        }
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
        }
        xv(false);
        if (this.sr != null) {
            up();
            this.sr.c();
        }
    }

    public boolean oo() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        return cVar != null && cVar.bk();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void p() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.ux();
            this.sr = null;
        }
        me meVar = this.f35110f;
        int yu = meVar == null ? 2 : meVar.yu();
        boolean z3 = yu > 0 && this.ox == yu;
        if (!wv.w(this.f35110f) || z3) {
            try {
                this.ux.c(this.f35110f, this.gd, true);
            } catch (Exception e4) {
                a.f("NativeVideoController", e4.getMessage());
            }
        }
        n nVar = this.f35109c;
        if (nVar != null) {
            nVar.removeCallbacksAndMessages(null);
        }
        List<Runnable> list = this.f35113k;
        if (list != null) {
            list.clear();
        }
        if (this.f35108a) {
            bj();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean q() {
        return this.oo;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void r() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.xv();
        }
    }

    public void sr(int i4) {
        this.bm = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    protected void up() {
        if (this.gd == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ux.w.w.w(this.f35110f, this.ux, this.f35119u);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void xv(int i4, int i5) {
        com.bykv.vk.openvk.component.video.api.c cVar;
        ViewGroup viewGroup;
        int i6;
        ViewGroup.LayoutParams layoutParams;
        a.w("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            WeakReference<Context> weakReference = this.gd;
            int i7 = 0;
            if (weakReference != null && weakReference.get() != null && ls() != null && (cVar = this.sr) != null && (viewGroup = this.gb) != null && viewGroup != null) {
                if (i4 < 0 && i5 < 0) {
                    i4 = cVar.k();
                    i5 = this.sr.a();
                }
                int width = this.gb.getWidth();
                int height = this.gb.getHeight();
                if (width > 0 && height > 0 && i5 > 0 && i4 > 0) {
                    if (i4 == i5) {
                        i7 = width > height ? height : width;
                        i6 = i7;
                    } else if (i4 > i5) {
                        double d4 = (i4 * 1.0f) / i5;
                        double d5 = width;
                        Double.isNaN(d5);
                        Double.isNaN(d4);
                        i7 = (int) Math.round((d5 * 1.0d) / d4);
                        i6 = width;
                    } else if (h()) {
                        i6 = 0;
                    } else {
                        double d6 = (i5 * 1.0f) / i4;
                        double d7 = height * 1.0f;
                        Double.isNaN(d7);
                        Double.isNaN(d6);
                        i6 = (int) Math.round(d7 / d6);
                        i7 = height;
                    }
                    if (i7 > height || i7 <= 0) {
                        i7 = height;
                    }
                    if (w(i4, i5, i6, width)) {
                        i6 = width;
                    }
                    if (h()) {
                        c(i4, i5, width, height);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i6, i7);
                    layoutParams2.addRule(13);
                    if (ls() instanceof TextureView) {
                        ((TextureView) ls()).setLayoutParams(layoutParams2);
                        a.w("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                    } else if (ls() instanceof SurfaceView) {
                        ((SurfaceView) ls()).setLayoutParams(layoutParams2);
                        a.w("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                    }
                    if (!ux(i4, i5) || (layoutParams = this.gb.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = i7;
                    layoutParams.width = i6;
                    this.gb.setLayoutParams(layoutParams);
                    this.ux.c(layoutParams.width, layoutParams.height);
                    return;
                }
                a.w("ChangeVideoSize", " container or video exist size <= 0");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[step-1] >>>>> mContextRef=");
            sb.append(this.gd);
            sb.append(",mContextRef.get()=");
            WeakReference<Context> weakReference2 = this.gd;
            sb.append(weakReference2 != null ? (Context) weakReference2.get() : null);
            sb.append(",getIRenderView() =");
            sb.append(ls());
            a.w("ChangeVideoSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
            sb2.append(this.sr == null);
            sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            sb2.append(this.sr != null);
            a.w("ChangeVideoSize", sb2.toString());
        } catch (Throwable th) {
            a.w("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! \uff1a" + th.toString());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public int ys() {
        return com.bykv.vk.openvk.component.video.c.ux.c.c(this.ev, this.fp);
    }

    private void sr(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        a.w("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (srVar == null) {
            a.w("tag_video_play", "VideoUrlModel is null  !!!");
            return;
        }
        final long xv = xv(srVar);
        if (this.sr != null) {
            me meVar = this.f35110f;
            if (meVar != null) {
                srVar.sr(String.valueOf(wv.gd(meVar)));
            }
            srVar.sr(0);
            this.sr.c(srVar);
            this.sr.c(me());
            a.w("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.f35210n = System.currentTimeMillis();
        if (!TextUtils.isEmpty(srVar.fp())) {
            this.ux.ux(8);
            this.ux.ux(0);
            c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.3
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.f35210n = System.currentTimeMillis();
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ux.sr(0);
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).sr == null || ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35116r != 0) {
                        if (((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).sr != null) {
                            ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).sr.c(true, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).f35116r, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ia);
                            return;
                        }
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).sr.c(true, xv, ((com.bytedance.sdk.openadsdk.core.video.c.c) xv.this).ia);
                }
            });
        }
        if (this.f35108a) {
            au();
        }
    }

    public void ux(int i4) {
        if (y()) {
            boolean z3 = i4 == 0 || i4 == 8;
            Context context = this.gd.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i4);
                } catch (Throwable unused) {
                }
                if (!z3) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i4) {
        me meVar;
        int xv = ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext());
        if (xv == 0) {
            f();
            this.ys = true;
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.c(this.f35110f, this.gd, false);
            }
        }
        if (xv != 4 && xv != 0) {
            ux uxVar2 = this.ux;
            if (uxVar2 != null) {
                uxVar2.c();
            }
            f();
            this.ys = true;
            this.wx = false;
            ux uxVar3 = this.ux;
            if (uxVar3 != null && (meVar = this.f35110f) != null) {
                return uxVar3.c(i4, ng.bk(meVar), this.xk);
            }
        } else if (xv == 4) {
            this.ys = false;
            ux uxVar4 = this.ux;
            if (uxVar4 != null) {
                uxVar4.u();
            }
        }
        return true;
    }

    public void w(int i4, int i5) {
        if (i4 == 0 || i5 == 0) {
            return;
        }
        this.vc = i4;
        this.up = i5;
        a.w("NativeVideoController", "width=" + i4 + "height=" + i5);
    }

    private View w(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387713);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387904);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387650);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387630);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(i.xv(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View c4 = new com.bytedance.sdk.openadsdk.res.layout.video.sr().c(context);
        c4.setId(2114387687);
        c4.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(c4);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387625);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageDrawable(i.xv(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, i.ux(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387652);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float ux = xk.ux(context, 1.0f);
        gradientDrawable.setCornerRadius(ux);
        int ux2 = xk.ux(context, 2.0f);
        gradientDrawable.setSize(-1, ux2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(ux);
        gradientDrawable2.setSize(-1, ux2);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(ux);
        gradientDrawable3.setSize(-1, ux2);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        View tTViewStub = new TTViewStub(context, new f());
        ViewGroup.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387745);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.w());
        ViewGroup.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387665);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new r());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387831);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public void c(me meVar) {
        this.f35110f = meVar;
    }

    public void c(com.bytedance.sdk.openadsdk.u.c.w.c.c cVar) {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c(cVar);
        }
    }

    public void f(boolean z3) {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
        }
        ux uxVar2 = this.ux;
        if (uxVar2 != null && z3) {
            uxVar2.ls();
        }
        xu();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void ux(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        c(wVar, view, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void ux(boolean z3) {
        this.au = z3;
    }

    public void c(final NativeVideoTsView.c cVar) {
        ux uxVar;
        if (!this.f35108a || (uxVar = this.ux) == null) {
            return;
        }
        uxVar.c(new NativeVideoTsView.c() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.c
            public void c(View view, int i4) {
                NativeVideoTsView.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c(view, i4);
                }
            }
        });
    }

    public void c(t tVar) {
        ux uxVar;
        if (!this.f35108a || (uxVar = this.ux) == null) {
            return;
        }
        uxVar.c(tVar);
    }

    private boolean f(int i4) {
        return this.ux.xv(i4);
    }

    @SuppressLint({"InflateParams"})
    private void c(Context context) {
        EnumSet<w.c> noneOf = EnumSet.noneOf(w.c.class);
        noneOf.add(w.c.hideCloseBtn);
        noneOf.add(w.c.hideBackBtn);
        try {
            ux c4 = c(context, noneOf);
            this.ux = c4;
            if (c4 != null) {
                c4.c((com.bykv.vk.openvk.component.video.api.sr.c) this);
                this.ux.c((c.InterfaceC0499c) this);
            }
        } catch (Throwable th) {
            a.f("NativeVideoController", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(int i4, int i5) {
        a.w("TTVideoWebPageActivity", "OnError - Error code: " + i4 + " Extra code: " + i5);
        boolean z3 = i4 == -1010 || i4 == -1007 || i4 == -1004 || i4 == -110 || i4 == 100 || i4 == 200;
        if (i5 == 1 || i5 == 700 || i5 == 800) {
            return true;
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr(int i4, int i5) {
        if (this.gd == null) {
            return;
        }
        ia.c cVar = new ia.c();
        cVar.w(a());
        cVar.xv(t());
        cVar.c(k());
        cVar.c(i4);
        cVar.w(i5);
        com.bytedance.sdk.openadsdk.ux.w.w.sr(s(), cVar);
    }

    protected ux c(Context context, EnumSet<w.c> enumSet) {
        View layoutVideoDetail;
        if (this.f35108a) {
            layoutVideoDetail = w(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.f35108a) {
            return new ux(context, view, true, enumSet, this.f35110f, this, bw(), null);
        }
        return new sr(context, view, true, enumSet, this.f35110f, this, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void sr(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        if (this.fz) {
            ev(false);
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.w(this.gb);
            }
            ux(1);
            return;
        }
        c(1);
        c(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.sr srVar) {
        this.f35209m = new WeakReference<>(srVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        a.w("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + srVar.fp());
        if (TextUtils.isEmpty(srVar.fp())) {
            a.f("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.f35119u = srVar;
        up();
        this.ia = srVar.k();
        this.f35116r = srVar.p();
        if (srVar.p() <= 0) {
            this.eq = false;
            this.f35212y = false;
        }
        if (srVar.p() > 0) {
            long p3 = srVar.p();
            this.f35116r = p3;
            long j4 = this.ev;
            if (j4 > p3) {
                p3 = j4;
            }
            this.ev = p3;
        }
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
            if (this.ox == 0) {
                this.ux.r();
            }
            this.ux.xv(srVar.ev(), srVar.gd());
            this.ux.xv(this.gb);
            this.ux.c(srVar.ev(), srVar.gd());
        }
        try {
            if (this.sr == null) {
                int ev = wv.ev(this.f35110f);
                if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
                    this.sr = new com.bytedance.sdk.component.k.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), j(), (long) ng.ux(this.f35110f), com.bytedance.sdk.openadsdk.core.ls.w().ox());
                } else if (eq.w() && srVar.s() == 1) {
                    this.sr = new com.bytedance.sdk.component.k.w.w(com.bytedance.sdk.openadsdk.core.ls.getContext(), String.valueOf(ev));
                } else {
                    this.sr = new com.bykv.vk.openvk.component.video.c.sr.sr(String.valueOf(ev));
                }
                this.sr.c(this.wo);
                c.InterfaceC0517c interfaceC0517c = this.f35115q;
                if (interfaceC0517c != null) {
                    interfaceC0517c.c(this.sr);
                }
            }
            ck();
            a.w("tag_video_play", "[video] new MediaPlayer");
            this.ck = 0L;
            sr(srVar);
            return true;
        } catch (Throwable th) {
            a.f("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void xv(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.gd();
        }
        c(1);
        c(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void sr(boolean z3) {
        this.bw = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(Context context, int i4) {
        w(context, i4);
        if (i4 == 4) {
            this.ys = false;
        }
    }

    public xv(Context context, ViewGroup viewGroup, me meVar, String str, boolean z3, boolean z4) {
        this.me = "embeded_ad";
        this.wv = false;
        this.xk = true;
        this.vc = 0;
        this.up = 0;
        this.f35208h = 1;
        this.f35208h = ys.xv(context);
        try {
            this.vc = viewGroup.getWidth();
            this.up = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.gb = viewGroup;
        this.me = str;
        this.gd = new WeakReference<>(context);
        this.f35110f = meVar;
        c(context);
        this.ba = true;
        this.wv = z3;
        this.xk = z4;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(Map<String, Object> map) {
        this.f35207b = map;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.w wVar) {
        this.yu = new WeakReference<>(wVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.c cVar) {
        this.f35213z = cVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(long j4) {
        this.f35116r = j4;
        long j5 = this.ev;
        if (j5 > j4) {
            j4 = j5;
        }
        this.ev = j4;
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
        }
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.c(true, this.f35116r, this.ia);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(boolean z3, int i4) {
        if (this.f35108a) {
            this.xu = t();
            c(1);
        }
        if ((!this.eq || b()) && this.f35212y) {
            if (z3) {
                ia.c cVar = new ia.c();
                cVar.c(k());
                cVar.xv(t());
                cVar.w(a());
                cVar.ux(i4);
                cVar.f(bk());
                com.bytedance.sdk.openadsdk.ux.w.w.c(this.ux, cVar, this.f35207b);
                this.eq = false;
            } else {
                ia.c cVar2 = new ia.c();
                cVar2.c(k());
                cVar2.xv(t());
                cVar2.w(a());
                com.bytedance.sdk.openadsdk.ux.w.w.w(this.ux, cVar2);
            }
        }
        p();
    }

    private boolean w(int i4, int i5, int i6, int i7) {
        return (i6 > i7 && !ux(i4, i5)) || i6 <= 0;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4) {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.f();
        }
    }

    private void c(int i4, int i5, int i6, int i7) {
        if (i6 == 0 || i7 == 0) {
            return;
        }
        float f4 = i6;
        float f5 = i4;
        float f6 = f4 / f5;
        float f7 = i7;
        float f8 = i5;
        float f9 = f7 / f8;
        Matrix matrix = null;
        try {
            if (ls() instanceof TextureView) {
                matrix = ((TextureView) ls()).getMatrix();
            } else if (ls() instanceof SurfaceView) {
                matrix = ((SurfaceView) ls()).getMatrix();
            }
            float max = Math.max(f6, f9);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i6 - i4) / 2, (i7 - i5) / 2);
            matrix.preScale(f5 / f4, f8 / f7);
            matrix.postScale(max, max, i6 / 2, i7 / 2);
            if (ls() instanceof TextureView) {
                ((TextureView) ls()).setTransform(matrix);
                ((TextureView) ls()).postInvalidate();
            } else if (ls() instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) ls()).setAnimationMatrix(matrix);
                }
                ((SurfaceView) ls()).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j4, long j5) {
        this.f35116r = j4;
        this.fp = j5;
        this.ux.c(j4, j5);
        this.ux.w(com.bykv.vk.openvk.component.video.c.ux.c.c(j4, j5));
        try {
            xv.c cVar = this.f35213z;
            if (cVar != null) {
                cVar.c(j4, j5);
            }
        } catch (Throwable th) {
            a.xv("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        w(wVar, view, false, false);
    }

    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3, boolean z4) {
        if (y()) {
            ev(!this.fz);
            if (!(this.gd.get() instanceof Activity)) {
                a.w("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.fz) {
                ux(z3 ? 8 : 0);
                ux uxVar = this.ux;
                if (uxVar != null) {
                    uxVar.c(this.gb);
                    this.ux.xv(false);
                }
            } else {
                ux(1);
                ux uxVar2 = this.ux;
                if (uxVar2 != null) {
                    uxVar2.w(this.gb);
                    this.ux.xv(false);
                }
            }
            WeakReference<xv.w> weakReference = this.yu;
            xv.w wVar2 = weakReference != null ? weakReference.get() : null;
            if (wVar2 != null) {
                wVar2.c(this.fz);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        if (this.sr == null || !y()) {
            return;
        }
        if (this.sr.bk()) {
            f();
            this.ux.w(true, false);
            this.ux.f();
        } else if (!this.sr.t()) {
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.xv(this.gb);
            }
            c(this.f35116r);
            ux uxVar2 = this.ux;
            if (uxVar2 != null) {
                uxVar2.w(false, false);
            }
        } else {
            f(false);
            ux uxVar3 = this.ux;
            if (uxVar3 != null) {
                uxVar3.w(false, false);
            }
        }
    }

    private void w(Context context, int i4) {
        if (!y() || context == null || this.f35208h == i4) {
            return;
        }
        this.f35208h = i4;
        if (i4 != 4 && i4 != 0) {
            this.wx = false;
        }
        if (!this.wx && !u() && this.wv) {
            ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.7
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.r(2);
                }
            });
        }
        WeakReference<c> weakReference = this.gw;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.gw.get().c(this.f35208h);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4) {
        if (this.sr == null) {
            return;
        }
        c(this.ng, f(i4));
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        this.f35119u = srVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4, boolean z3) {
        if (y()) {
            long j4 = this.fp;
            long j5 = (((float) (i4 * j4)) * 1.0f) / 100.0f;
            if (j4 > 0) {
                this.ng = (int) j5;
            } else {
                this.ng = 0L;
            }
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.c(this.ng);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w() {
        if (this.sr != null) {
            xv(false);
            this.sr.c();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3, boolean z4) {
        if (this.f35108a) {
            f();
        }
        if (z3 && !this.f35108a && !gb()) {
            this.ux.w(!oo(), false);
            this.ux.c(z4, true, false);
        }
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null && cVar.bk()) {
            this.ux.f();
            this.ux.ux();
            return;
        }
        this.ux.f();
    }

    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3) {
        fm();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c() {
        if (ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext()) == 0) {
            return;
        }
        this.f35211x = true;
        if (this.sr == null) {
            p();
            te();
            return;
        }
        p();
    }

    private void c(long j4, boolean z3) {
        if (this.sr == null) {
            return;
        }
        if (z3) {
            ge();
        }
        this.sr.c(j4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(fp.c cVar, String str) {
        int i4 = AnonymousClass9.f35236c[cVar.ordinal()];
        if (i4 == 1) {
            f();
        } else if (i4 == 2) {
            c(true, 3);
        } else if (i4 != 3) {
        } else {
            ev();
            this.ys = false;
            this.wx = true;
        }
    }

    public void c(Context context, int i4) {
        w(context, i4);
        if (i4 == 4) {
            this.ys = false;
            ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.xv.8
                @Override // java.lang.Runnable
                public void run() {
                    xv.this.ev();
                }
            });
        }
    }

    public void c(c cVar) {
        this.gw = new WeakReference<>(cVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(int i4) {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
            if (this.bj <= 0) {
                this.bj = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis() - this.bj;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i4));
                jSONObject.putOpt("buffer_count", Integer.valueOf(bk()));
                jSONObject.putOpt("buffer_time", Long.valueOf(a()));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (this.me.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.c(this.f35110f, "embeded_ad", currentTimeMillis, jSONObject);
            } else if (this.me.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.c(this.f35110f, "draw_ad", currentTimeMillis, jSONObject);
            }
            if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
                if (TTLiveCommerceHelper.getInstance().isLiveCommerceScene(this.f35110f)) {
                    TTLiveCommerceHelper.getInstance().uploadLiveEventV2(u0.a.c, this.f35110f, currentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.xv.c.c(u0.a.c, this.f35110f, currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
            if (this.me.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35110f, "embeded_ad", i4, str);
            } else if (this.me.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35110f, "draw_ad", i4, str);
            }
        }
    }
}
