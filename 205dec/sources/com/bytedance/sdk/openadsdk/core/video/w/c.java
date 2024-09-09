package com.bytedance.sdk.openadsdk.core.video.w;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.c;
import com.bykv.vk.openvk.component.video.api.sr.w;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bykv.vk.openvk.component.video.c.sr.sr;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.component.utils.ls;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.ux;
import com.bytedance.sdk.openadsdk.core.widget.fp;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c extends com.bytedance.sdk.openadsdk.core.video.c.c {
    private long au;

    /* renamed from: b  reason: collision with root package name */
    private int f35246b;
    private final String bj;
    protected ViewGroup gb;
    public long ls;
    private long ox;
    private final int up;
    private WeakReference<xv.w> vc;
    private int wo;
    private xv.c wx;

    /* renamed from: x  reason: collision with root package name */
    private InterfaceC0520c f35250x;
    private int xu;

    /* renamed from: y  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.w.c f35251y;

    /* renamed from: n  reason: collision with root package name */
    protected long f35249n = 0;
    protected boolean ck = false;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f35252z = false;
    protected Map<String, Object> ba = null;
    private final AtomicInteger me = new AtomicInteger(0);
    private final AtomicInteger wv = new AtomicInteger(0);
    private long xk = 0;
    private long yu = 0;
    private final Runnable pr = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (c.this.wx != null) {
                c.this.wx.c();
            }
            if (c.this.f35250x != null) {
                c.this.f35250x.w();
            }
        }
    };
    private boolean bw = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35248m = false;
    private boolean gw = false;
    private boolean mt = false;
    private boolean oo = true;
    private boolean bm = false;
    c.InterfaceC0334c eq = new c.InterfaceC0334c() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2
        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f(false);
                }
            });
            c.this.c(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void sr(com.bykv.vk.openvk.component.video.api.c cVar) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void ux(com.bykv.vk.openvk.component.video.api.c cVar) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void w(com.bykv.vk.openvk.component.video.api.c cVar) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.3
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.removeCallbacks(c.this.pr);
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                        c.this.ux(0);
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.w();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void xv(com.bykv.vk.openvk.component.video.api.c cVar) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onRelease: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void w(com.bykv.vk.openvk.component.video.api.c cVar, int i4) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, final long j4) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                        c.this.ux(0);
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.w();
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.removeCallbacks(c.this.pr);
                        c.this.mt = false;
                    }
                    c.this.ux(j4);
                }
            });
            c.this.au = System.currentTimeMillis();
            c.this.fm();
            if (c.this.f35250x != null) {
                c.this.f35250x.xv();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(final com.bykv.vk.openvk.component.video.api.c cVar, final com.bykv.vk.openvk.component.video.api.xv.w wVar) {
            if (wVar == null) {
                return;
            }
            a.xv("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + wVar.c() + " msg:" + wVar.xv());
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.c cVar2;
                    com.bykv.vk.openvk.component.video.api.c cVar3;
                    int u3;
                    int c4 = wVar.c();
                    if (c4 != 308 || (cVar2 = ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).sr) == null || cVar2 == (cVar3 = cVar) || !(cVar3 instanceof sr) || ((u3 = ((sr) cVar3).u()) != 200 && u3 != 203)) {
                        c.this.c(c4, wVar.w());
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.removeCallbacks(c.this.pr);
                        if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                            c.this.ux(0);
                            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.w();
                        }
                        if (c.this.wx != null) {
                            c.this.wx.w(c.this.yu, com.bykv.vk.openvk.component.video.c.ux.c.c(((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35116r, c.this.ls));
                        }
                        if (c.this.f35250x != null) {
                            c.this.f35250x.c(c4, wVar.xv());
                            return;
                        }
                        return;
                    }
                    a.f("BaseVideoController", "ignore errorCode:" + c4 + " state:" + u3);
                }
            });
            c.this.c(wVar.c(), wVar.xv());
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, boolean z3) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.5
                @Override // java.lang.Runnable
                public void run() {
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.removeCallbacks(c.this.pr);
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                        c.this.ux(0);
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.w();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, int i4, int i5) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            c.this.f35246b = i4;
            c.this.wo = i5;
            c.this.te();
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, int i4, int i5, int i6) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                        c.this.ux(8);
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.j();
                        c.this.bm();
                        c.this.mt = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(com.bykv.vk.openvk.component.video.api.c cVar, int i4) {
            a.xv("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux != null) {
                        c.this.ux(0);
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.w();
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.removeCallbacks(c.this.pr);
                        c.this.mt = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.c.InterfaceC0334c
        public void c(final com.bykv.vk.openvk.component.video.api.c cVar, final long j4, final long j5) {
            if (Math.abs(j4 - ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35116r) < 50) {
                return;
            }
            a.w("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j4), "; duration=", Long.valueOf(j5));
            ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35111i != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35111i.c(j4, j5);
                    }
                    c.this.w(j4, j5);
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f.ab() != 2 || j5 <= 60000 || j4 < 60000 || ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35118t) {
                        return;
                    }
                    ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35118t = true;
                    cVar.sr();
                    c.this.f(false);
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
            com.bytedance.sdk.openadsdk.core.a.xv.c((Context) ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).gd.get(), ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f, c.this.bj, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private final ls.c ng = new ls.c() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.3
        @Override // com.bytedance.sdk.component.utils.ls.c
        public void c(Context context, Intent intent, boolean z3, int i4) {
            c.this.c(context, i4);
        }
    };
    private boolean ok = false;

    /* renamed from: h  reason: collision with root package name */
    private long f35247h = 0;
    private AtomicBoolean oh = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.w.c$9  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f35274c;

        static {
            int[] iArr = new int[fp.c.values().length];
            f35274c = iArr;
            try {
                iArr[fp.c.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35274c[fp.c.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35274c[fp.c.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0520c {
        void c();

        void c(int i4, String str);

        void c(long j4, long j5);

        void w();

        void xv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, ViewGroup viewGroup, me meVar, com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this.xu = 1;
        this.xu = ys.xv(context);
        this.gb = viewGroup;
        this.gd = new WeakReference<>(context);
        this.f35110f = meVar;
        this.f35251y = cVar;
        c(context);
        this.up = wv.gd(this.f35110f);
        this.bj = wv.c(this.f35110f);
    }

    private void eu() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.sr(0);
            this.ux.c(false, false);
            this.ux.xv(false);
            this.ux.ux();
            ux(8);
            this.ux.r();
        }
    }

    protected boolean G_() {
        me meVar = this.f35110f;
        return meVar == null || meVar.yx() == 100.0f;
    }

    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.sr srVar) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void f(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean i() {
        return false;
    }

    protected abstract int ls();

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void sr(boolean z3) {
    }

    private boolean gb() {
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

    private void gd(boolean z3) {
        if (this.f35250x != null) {
            if (!wv()) {
                this.f35250x.c();
            } else if (z3) {
                this.f35250x.c();
            }
        }
    }

    private boolean ge() throws Throwable {
        me meVar;
        WeakReference<Context> weakReference = this.gd;
        return weakReference == null || weakReference.get() == null || ta() == null || this.sr == null || (meVar = this.f35110f) == null || meVar.rh() != null || this.f35110f.up() == 1;
    }

    private void r(boolean z3) {
        if (!this.f35248m || xv() || sr()) {
            this.f35248m = true;
            if (!wv() || this.f35110f == null) {
                long j4 = this.ls;
                w(j4, j4);
                long j5 = this.ls;
                this.f35116r = j5;
                this.ev = j5;
                x();
            } else if (z3) {
                x();
                if (this.f35110f.sc() != 8) {
                    up();
                }
            } else {
                long j6 = this.ls;
                w(j6, j6);
                long j7 = this.ls;
                this.f35116r = j7;
                this.ev = j7;
            }
        }
    }

    private com.bykv.vk.openvk.component.video.api.renderview.w ta() {
        ux uxVar;
        WeakReference<Context> weakReference = this.gd;
        if (weakReference == null || weakReference.get() == null || (uxVar = this.ux) == null) {
            return null;
        }
        return uxVar.ia();
    }

    public void au() {
        me meVar = this.f35110f;
        if (meVar != null) {
            new c.C0472c().w("auto_replay").c(wv.c(meVar)).ux(this.f35110f.jr()).sr(this.f35110f.cf()).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.4
                @Override // com.bytedance.sdk.openadsdk.ux.c.c
                public void c(JSONObject jSONObject) throws JSONException {
                    com.bykv.vk.openvk.component.video.api.xv.xv gb;
                    JSONObject jSONObject2 = new JSONObject();
                    if (gd.c(((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35119u != null && (gb = ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35119u.gb()) != null && gb.r() > 0.0d) {
                        jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_START, gb.r());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public void b() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.ck();
        }
    }

    public int bj() {
        if (gd.c(this.f35110f)) {
            return this.wv.get();
        }
        return this.me.get();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public int bk() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar == null) {
            return 0;
        }
        return cVar.ia();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bm() {
        int ls = ls();
        int i4 = 5;
        if (ls == 2 || ls == 1 || ls == 5) {
            i4 = com.bytedance.sdk.openadsdk.core.ls.w().mk() * 1000;
        } else if (ls == 3) {
            i4 = com.bytedance.sdk.openadsdk.core.ls.w().p(String.valueOf(this.up));
        }
        this.f35109c.removeCallbacks(this.pr);
        this.f35109c.postDelayed(this.pr, i4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void ev() {
        com.bykv.vk.openvk.component.video.api.xv.sr srVar;
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
            this.ux.u();
            this.ux.ls();
        }
        a.w("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.f35114p));
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            if (cVar.t()) {
                if (!this.f35114p && ((srVar = this.f35119u) == null || !srVar.r())) {
                    w(this.f35112j);
                } else {
                    wx();
                }
                a.w("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.f35114p));
            } else {
                this.sr.c(false, this.f35116r, this.ia);
            }
        }
        if (!this.f35248m || xv() || sr()) {
            if (this.bw || gd.c(this.f35110f)) {
                gw();
            }
        }
    }

    public long f(long j4) {
        long t3 = t();
        long xk = (j4 - xk()) + (t3 * bj());
        long j5 = this.f35247h;
        if (xk < j5) {
            return j5;
        }
        this.f35247h = xk;
        return xk;
    }

    protected void fm() {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
            int ls = ls();
            com.bytedance.sdk.component.f.c c4 = com.bytedance.sdk.openadsdk.core.xv.c();
            if (ls == 1) {
                com.bytedance.sdk.openadsdk.core.a.xv.ux(this.f35110f, "rewarded_video", System.currentTimeMillis() - c4.w("reward_video_show_time", 0L));
            } else if (ls == 2) {
                com.bytedance.sdk.openadsdk.core.a.xv.ux(this.f35110f, "fullscreen_interstitial_ad", System.currentTimeMillis() - c4.w("full_video_show_time", 0L));
            }
        }
    }

    public boolean h() {
        boolean xv = xv();
        if (!xv || bj() >= 2) {
            return xv;
        }
        return this.f35247h >= t() - 400;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean j() {
        return com.bytedance.sdk.openadsdk.core.ls.w().u() || gb();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c
    protected Map<String, Object> mt() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.ba;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : wv.c(this.f35249n, this.f35110f, ia()).entrySet()) {
            hashMap.put(entry2.getKey(), entry2.getValue());
        }
        return hashMap;
    }

    public boolean ng() {
        return this.sr.gd();
    }

    public boolean oh() {
        if (wv()) {
            return h();
        }
        return xv();
    }

    public boolean ok() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        return cVar != null && cVar.bk();
    }

    public long oo() {
        return this.f35247h;
    }

    public boolean ox() {
        return this.bm;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void p() {
        gd();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean q() {
        return this.mt;
    }

    public void te() {
        this.f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.8
            @Override // java.lang.Runnable
            public void run() {
                if (!com.bytedance.sdk.openadsdk.core.u.fp.sr(((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f) && c.this.G_()) {
                    if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f) && ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f.fh() == 2 && c.this.G_()) {
                        return;
                    }
                    if (c.this.G_()) {
                        if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f == null || ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f.gw() != 0) {
                            if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f != null && ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35110f.gw() == 2) {
                                c cVar = c.this;
                                cVar.xv(cVar.f35246b, c.this.wo);
                                return;
                            }
                            c cVar2 = c.this;
                            cVar2.sr(cVar2.f35246b, c.this.wo);
                            return;
                        }
                        c cVar3 = c.this;
                        cVar3.ux(cVar3.f35246b, c.this.wo);
                        return;
                    }
                    c cVar4 = c.this;
                    cVar4.w(cVar4.f35246b, c.this.wo);
                    return;
                }
                c cVar5 = c.this;
                cVar5.w(cVar5.f35246b, c.this.wo);
            }
        });
    }

    public void wo() {
        if (!this.f35248m || xv() || sr()) {
            if (this.bw || gd.c(this.f35110f)) {
                gw();
            }
        }
    }

    public boolean xu() {
        return this.oh.get();
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public int ys() {
        return com.bykv.vk.openvk.component.video.c.ux.c.c(this.ev, this.ls);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean sr() {
        if (gd.c(this.f35110f)) {
            return ((double) this.wv.get()) <= ((double) ng.ys(this.f35110f).r());
        }
        return super.sr();
    }

    public void ux(long j4) {
        if (this.bw) {
            return;
        }
        this.f35249n = j4;
        vc();
        this.bw = true;
        this.f35252z = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean xv() {
        return this.me.get() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(int i4, int i5) {
        try {
            WeakReference<Context> weakReference = this.gd;
            if (weakReference != null && weakReference.get() != null && ta() != null && this.sr != null && this.f35110f != null) {
                int[] w3 = xk.w(com.bytedance.sdk.openadsdk.core.ls.getContext());
                boolean z3 = this.f35110f.fh() == 1;
                float f4 = w3[0];
                float f5 = w3[1];
                float f6 = i4;
                float f7 = i5;
                if (z3) {
                    if (f6 > f7) {
                        c(f4, f5, f6, f7, true);
                        return;
                    }
                    f5 = (f7 * f4) / f6;
                } else if (f6 < f7) {
                    c(f4, f5, f6, f7, false);
                    return;
                } else {
                    f4 = (f6 * f5) / f7;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f4, (int) f5);
                layoutParams.addRule(13);
                if (ta() == null || this.gb == null) {
                    return;
                }
                if (ta() instanceof TextureView) {
                    ((TextureView) ta()).setLayoutParams(layoutParams);
                } else if (ta() instanceof SurfaceView) {
                    ((SurfaceView) ta()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            a.xv("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void gd() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.ux();
            this.sr = null;
        }
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.gd();
        }
        this.f35109c.removeCallbacks(this.pr);
        this.f35109c.removeCallbacksAndMessages(null);
        this.wx = null;
        this.f35250x = null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w() {
        if (this.sr != null) {
            if (!ux()) {
                this.me.getAndAdd(1);
                au();
            }
            this.wv.getAndAdd(1);
            if (!wv()) {
                up();
            }
            xv(false);
            this.sr.c();
        }
    }

    private void sr(com.bykv.vk.openvk.component.video.api.xv.sr srVar) throws Exception {
        if (srVar == null) {
            return;
        }
        this.f35119u = srVar;
        final long xv = xv(srVar);
        if (this.sr != null) {
            me meVar = this.f35110f;
            if (meVar != null) {
                srVar.sr(String.valueOf(wv.gd(meVar)));
            }
            srVar.sr(1);
            this.sr.c(srVar);
            this.sr.c(me());
        }
        this.xk = System.currentTimeMillis();
        if (TextUtils.isEmpty(srVar.fp())) {
            return;
        }
        this.ux.ux(8);
        this.ux.ux(0);
        c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.xk = System.currentTimeMillis();
                ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ux.sr(0);
                if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).sr == null || ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35116r != 0) {
                    if (((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).sr != null) {
                        ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).sr.c(true, ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).f35116r, ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ia);
                        return;
                    }
                    return;
                }
                ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).sr.c(true, xv, ((com.bytedance.sdk.openadsdk.core.video.c.c) c.this).ia);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(boolean z3) {
        if (y() && this.ux != null) {
            this.f35109c.removeCallbacks(this.pr);
            ux(0);
            this.ux.w();
            this.yu = System.currentTimeMillis() - this.xk;
            this.ux.ux(true);
            if (wv.sr(this.f35110f)) {
                this.ux.c(this.f35110f, this.gd, true);
            } else {
                this.ux.n();
            }
            r(z3);
            if (!z3) {
                this.oh.set(true);
            }
            xv.c cVar = this.wx;
            if (cVar != null) {
                cVar.c(this.yu, com.bykv.vk.openvk.component.video.c.ux.c.c(this.f35116r, this.ls));
            }
            gd(z3);
            this.f35117s = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c, com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean ux() {
        if (gd.c(this.f35110f)) {
            return ((double) this.wv.get()) < ((double) ng.ys(this.f35110f).r());
        }
        return super.sr();
    }

    @SuppressLint({"InflateParams"})
    private void c(Context context) {
        EnumSet noneOf = EnumSet.noneOf(w.c.class);
        noneOf.add(w.c.hideCloseBtn);
        noneOf.add(w.c.hideBackBtn);
        ux uxVar = new ux(StubApp.getOrigApplicationContext(context.getApplicationContext()), new LayoutVideoPlayLayoutForLive(context), true, noneOf, this.f35110f, this, this.f35251y);
        this.ux = uxVar;
        uxVar.c((com.bykv.vk.openvk.component.video.api.sr.c) this);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void ux(boolean z3) {
        this.oo = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i4, int i5) {
        me meVar;
        try {
            WeakReference<Context> weakReference = this.gd;
            if (weakReference != null && weakReference.get() != null && ta() != null && this.sr != null && (meVar = this.f35110f) != null) {
                boolean z3 = meVar.fh() == 1;
                int[] w3 = xk.w(com.bytedance.sdk.openadsdk.core.ls.getContext());
                c(w3[0], w3[1], i4, i5, z3);
                a.w("changeVideoSize", "changeSize=end");
            }
        } catch (Throwable th) {
            a.c("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void r() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.xv();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public boolean c(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        if (srVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null && cVar.t()) {
            this.sr.w();
            return true;
        }
        this.f35119u = srVar;
        a.w("BaseVideoController", "video local url " + srVar.fp());
        if (TextUtils.isEmpty(srVar.fp())) {
            a.f("BaseVideoController", "No video info");
            return false;
        }
        if (!wv() || !h()) {
            up();
        }
        this.ck = (srVar.fp().startsWith("http") || com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) ? false : true;
        this.ia = srVar.k();
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
            ux(8);
            this.ux.r();
            this.ux.xv(srVar.ev(), srVar.gd());
            this.ux.xv(this.gb);
        }
        try {
            if (this.sr == null) {
                int ev = wv.ev(this.f35110f);
                if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
                    this.sr = new com.bytedance.sdk.component.k.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext(), j(), (long) ng.ux(this.f35110f), com.bytedance.sdk.openadsdk.core.ls.w().ox());
                } else if (eq.w() && srVar.s() == 1) {
                    this.sr = new com.bytedance.sdk.component.k.w.w(com.bytedance.sdk.openadsdk.core.ls.getContext(), String.valueOf(ev));
                } else {
                    this.sr = new sr(String.valueOf(ev));
                }
                this.sr.c(this.eq);
                c.InterfaceC0517c interfaceC0517c = this.f35115q;
                if (interfaceC0517c != null) {
                    interfaceC0517c.c(this.sr);
                }
            }
            ck();
            this.yu = 0L;
            sr(srVar);
            return true;
        } catch (Throwable th) {
            a.f("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i4) {
        me meVar;
        int xv = ys.xv(com.bytedance.sdk.openadsdk.core.ls.getContext());
        if (xv != 4 && xv != 0) {
            f();
            this.ys = true;
            this.gw = false;
            ux uxVar = this.ux;
            if (uxVar != null && (meVar = this.f35110f) != null) {
                return uxVar.c(i4, ng.bk(meVar), true);
            }
        } else if (xv == 4) {
            this.ys = false;
            ux uxVar2 = this.ux;
            if (uxVar2 != null) {
                uxVar2.u();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i4, int i5) {
        ViewGroup viewGroup;
        try {
            if (ta() != null && this.sr != null && (viewGroup = this.gb) != null) {
                float f4 = i4;
                float f5 = i5;
                float width = viewGroup.getWidth();
                float height = this.gb.getHeight();
                if (f4 / (width * 1.0f) <= f5 / (height * 1.0f)) {
                    width = f4 * (height / (f5 * 1.0f));
                } else {
                    height = f5 * (width / (f4 * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (ta() instanceof TextureView) {
                    ((TextureView) ta()).setLayoutParams(layoutParams);
                } else if (ta() instanceof SurfaceView) {
                    ((SurfaceView) ta()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            a.xv("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0110 A[Catch: all -> 0x017b, TryCatch #0 {all -> 0x017b, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x003f, B:14:0x004d, B:20:0x0067, B:26:0x00e0, B:33:0x00f4, B:35:0x0110, B:37:0x012f, B:39:0x0141, B:41:0x0149, B:45:0x0164, B:47:0x016c, B:42:0x0153, B:44:0x015b, B:48:0x0175, B:31:0x00ee, B:18:0x005c), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0141 A[Catch: all -> 0x017b, TryCatch #0 {all -> 0x017b, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x003f, B:14:0x004d, B:20:0x0067, B:26:0x00e0, B:33:0x00f4, B:35:0x0110, B:37:0x012f, B:39:0x0141, B:41:0x0149, B:45:0x0164, B:47:0x016c, B:42:0x0153, B:44:0x015b, B:48:0x0175, B:31:0x00ee, B:18:0x005c), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sr(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.w.c.sr(int, int):void");
    }

    private void xv(long j4, long j5) {
        if (wv()) {
            final int sc = this.f35110f.sc();
            if (w(sc)) {
                long xk = xk();
                if (oh() && j4 >= xk - 200 && this.oh.get() && Math.abs(j4 - j5) > 200) {
                    a.w("hlt", "start " + j4);
                    this.oh.set(false);
                    this.f35109c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.f(true);
                            if (sc == 8) {
                                c.this.ia().sr();
                            }
                        }
                    });
                }
            }
        }
        f(j4);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void ux(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        c(wVar, view, false);
    }

    protected void ux(int i4) {
        Context context;
        if (this.gd == null || !com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f) || this.gd.get() == null || (context = this.gd.get()) == null || !(context instanceof com.bytedance.sdk.openadsdk.core.r.w)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.r.w) context).c(i4 == 0);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void f() {
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.xv();
        }
        if (!this.f35248m || xv() || sr()) {
            if (this.bw || gd.c(this.f35110f)) {
                m();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4) {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.f();
        }
    }

    private boolean f(int i4) {
        return this.ux.xv(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(long j4, long j5) {
        this.f35116r = j4;
        this.ls = j5;
        this.ux.c(j4, j5);
        int c4 = com.bykv.vk.openvk.component.video.c.ux.c.c(j4, j5);
        if (!xv() && !sr()) {
            this.ux.w(c4);
        } else {
            this.ux.w(100);
        }
        xv(j4, j5);
        try {
            xv.c cVar = this.wx;
            if (cVar != null) {
                cVar.c(j4, j5);
            }
            InterfaceC0520c interfaceC0520c = this.f35250x;
            if (interfaceC0520c != null) {
                interfaceC0520c.c(j4, j5);
            }
        } catch (Throwable th) {
            a.xv("BaseVideoController", "onProgressUpdate error: ", th);
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

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        w(wVar, view, false, false);
    }

    public void w(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3, boolean z4) {
        if (y()) {
            ev(!this.fz);
            if (!(this.gd.get() instanceof Activity)) {
                a.w("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.fz) {
                sr(z3 ? 8 : 0);
                ux uxVar = this.ux;
                if (uxVar != null) {
                    uxVar.c(this.gb);
                    this.ux.xv(false);
                }
            } else {
                sr(1);
                ux uxVar2 = this.ux;
                if (uxVar2 != null) {
                    uxVar2.w(this.gb);
                    this.ux.xv(false);
                }
            }
            WeakReference<xv.w> weakReference = this.vc;
            xv.w wVar2 = weakReference != null ? weakReference.get() : null;
            if (wVar2 != null) {
                wVar2.c(this.fz);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(Map<String, Object> map) {
        this.ba = map;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.w wVar) {
        this.vc = new WeakReference<>(wVar);
    }

    public void sr(int i4) {
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

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(xv.c cVar) {
        this.wx = cVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(long j4) {
        this.f35116r = Math.max(j4, ia().fz());
        this.ev = Math.max(this.ev, k());
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.c();
        }
        com.bykv.vk.openvk.component.video.api.c cVar = this.sr;
        if (cVar != null) {
            cVar.c(false, this.f35116r, this.ia);
            this.sr.c(this.f35116r);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void sr(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view) {
        if (this.fz) {
            ev(false);
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.w(this.gb);
            }
            sr(1);
            return;
        }
        c(1);
        c(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void w(com.bykv.vk.openvk.component.video.api.xv.sr srVar) {
        this.f35119u = srVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(boolean z3, int i4) {
        gd();
    }

    private void c(float f4, float f5, float f6, float f7, boolean z3) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            a.w("changeVideoSize", "screenWidth=" + f4 + ",screenHeight=" + f5);
            a.w("changeVideoSize", "videoHeight=" + f7 + ",videoWidth=" + f6);
            if (f6 <= 0.0f || f7 <= 0.0f) {
                f6 = ng.sr(this.f35110f);
                f7 = ng.xv(this.f35110f);
            }
            if (f7 > 0.0f && f6 > 0.0f) {
                if (z3) {
                    if (f6 < f7) {
                        return;
                    }
                    a.w("changeVideoSize", "\u7ad6\u5c4f\u6a21\u5f0f\u4e0b\u6309\u89c6\u9891\u5bbd\u5ea6\u8ba1\u7b97\u653e\u5927\u500d\u6570\u503c");
                    layoutParams = new RelativeLayout.LayoutParams((int) f4, (int) ((f7 * f4) / f6));
                } else if (f6 > f7) {
                    return;
                } else {
                    a.w("changeVideoSize", "\u6a2a\u5c4f\u6a21\u5f0f\u4e0b\u6309\u89c6\u9891\u9ad8\u5ea6\u8ba1\u7b97\u653e\u5927\u500d\u6570\u503c");
                    layoutParams = new RelativeLayout.LayoutParams((int) ((f6 * f5) / f7), (int) f5);
                }
                layoutParams.addRule(13);
                if (ta() != null) {
                    if (ta() instanceof TextureView) {
                        ((TextureView) ta()).setLayoutParams(layoutParams);
                    } else if (ta() instanceof SurfaceView) {
                        ((SurfaceView) ta()).setLayoutParams(layoutParams);
                    }
                }
                this.bm = true;
            }
        } catch (Throwable th) {
            a.c("changeVideoSize", "changeSize error", th);
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
            ev();
            ux uxVar3 = this.ux;
            if (uxVar3 != null) {
                uxVar3.w(false, false);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4) {
        if (this.sr == null) {
            return;
        }
        c(this.ox, f(i4));
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, int i4, boolean z3) {
        if (y()) {
            long j4 = this.ls;
            long j5 = (((float) (i4 * j4)) * 1.0f) / 100.0f;
            if (j4 > 0) {
                this.ox = (int) j5;
            } else {
                this.ox = 0L;
            }
            ux uxVar = this.ux;
            if (uxVar != null) {
                uxVar.c(this.ox);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c(com.bykv.vk.openvk.component.video.api.sr.w wVar, View view, boolean z3, boolean z4) {
        if (this.f35108a) {
            f();
        }
        if (z3 && !this.f35108a && !ng()) {
            this.ux.w(!ok(), false);
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

    @Override // com.bykv.vk.openvk.component.video.api.sr.c
    public void c() {
        ux uxVar = this.ux;
        if (uxVar != null) {
            uxVar.ux();
            this.ux.c();
        }
        ux uxVar2 = this.ux;
        if (uxVar2 != null) {
            uxVar2.ls();
        }
        c(-1L);
    }

    private void c(long j4, boolean z3) {
        if (this.sr == null) {
            return;
        }
        if (z3) {
            eu();
        }
        this.sr.c(j4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(fp.c cVar, String str) {
        int i4 = AnonymousClass9.f35274c[cVar.ordinal()];
        if (i4 == 1) {
            f();
        } else if (i4 == 2) {
            c(true, 3);
        } else if (i4 != 3) {
        } else {
            ev();
            this.ys = false;
            this.gw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, int i4) {
        if (y() && this.xu != i4) {
            if (!this.gw) {
                ev.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.w.c.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.r(2);
                    }
                });
            }
            this.xu = i4;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv
    public void c(int i4) {
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f35110f)) {
            int ls = ls();
            long currentTimeMillis = System.currentTimeMillis() - this.au;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i4));
                jSONObject.putOpt("buffer_count", Integer.valueOf(bk()));
                jSONObject.putOpt("buffer_time", Long.valueOf(a()));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (ls == 1) {
                com.bytedance.sdk.openadsdk.core.a.xv.c(this.f35110f, "rewarded_video", currentTimeMillis, jSONObject);
            } else if (ls == 2) {
                com.bytedance.sdk.openadsdk.core.a.xv.c(this.f35110f, "fullscreen_interstitial_ad", currentTimeMillis, jSONObject);
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
            int ls = ls();
            if (ls == 1) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35110f, "rewarded_video", i4, str);
            } else if (ls == 2) {
                com.bytedance.sdk.openadsdk.core.a.xv.w(this.f35110f, "fullscreen_interstitial_ad", i4, str);
            }
        }
    }

    public void c(InterfaceC0520c interfaceC0520c) {
        this.f35250x = interfaceC0520c;
    }
}
