package com.bytedance.sdk.openadsdk.core.component.c;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ys;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.multipro.w.c;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.ux;
import com.bytedance.sdk.openadsdk.n.gd;
import com.bytedance.sdk.openadsdk.ux.xv.ia;
import com.bytedance.sdk.openadsdk.ys.w.sr;
import com.bytedance.sdk.openadsdk.ys.w.w.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends sr implements xv.sr, xv.InterfaceC0335xv, com.bykv.vk.openvk.component.video.api.w.c, c.InterfaceC0499c {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f32125a;
    private volatile boolean bk;

    /* renamed from: c  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.multipro.w.c f32126c;
    private com.bytedance.sdk.openadsdk.i.c.w.w.c ev;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.i.c f32127f;
    private boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.c.w.c.w f32128k;

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<NativeVideoTsView> f32129p;

    /* renamed from: r  reason: collision with root package name */
    private int f32130r;
    private int[] sr;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.j.c.w.c.c f32131t;
    private com.bytedance.sdk.openadsdk.i.c.w.c.c ux;

    /* renamed from: w  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.ys.w.xv.w f32132w;
    int xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xv(Context context, me meVar, int i4, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(new com.bytedance.sdk.openadsdk.core.i.c(context, meVar, i4, wVar, true));
        this.sr = null;
        this.gd = false;
        this.f32129p = null;
        this.f32131t = new com.bytedance.sdk.openadsdk.j.c.w.c.c(null) { // from class: com.bytedance.sdk.openadsdk.core.component.c.xv.4
            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdClicked(View view, t tVar) {
                if (xv.this.f32129p == null || xv.this.f32129p.get() == null) {
                    return;
                }
                ((NativeVideoTsView) xv.this.f32129p.get()).gd();
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdCreativeClick(View view, t tVar) {
                if (xv.this.f32129p == null || xv.this.f32129p.get() == null) {
                    return;
                }
                ((NativeVideoTsView) xv.this.f32129p.get()).gd();
            }

            @Override // com.bytedance.sdk.openadsdk.j.c.w.c.c
            public void onAdShow(t tVar) {
                NativeVideoTsView nativeVideoTsView;
                if (xv.this.f32129p == null || (nativeVideoTsView = (NativeVideoTsView) xv.this.f32129p.get()) == null) {
                    return;
                }
                nativeVideoTsView.s();
            }
        };
        com.bytedance.sdk.openadsdk.core.i.c cVar = (com.bytedance.sdk.openadsdk.core.i.c) me();
        this.f32127f = cVar;
        cVar.xv().c(this);
        this.xv = i4;
        this.f32132w = wVar;
        this.f32126c = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
        int gd = wv.gd(meVar);
        this.f32130r = gd;
        c(gd);
        this.f32127f.c(this.f32131t);
    }

    private NativeVideoTsView wv() {
        NativeVideoTsView nativeVideoTsView = new NativeVideoTsView(this.f32127f.getContext(), this.f32127f.sr(), false, false, wv.w(this.xv), false, false);
        WeakReference<NativeVideoTsView> weakReference = new WeakReference<>(nativeVideoTsView);
        this.f32129p = weakReference;
        this.f32127f.c(weakReference);
        this.f32127f.c();
        return nativeVideoTsView;
    }

    private int[] xk() {
        if (this.f32127f.sr() != null) {
            if (this.f32127f.sr().tz() == 166 && ba.c(this.f32127f.sr())) {
                return new int[]{ba.a(this.f32127f.sr()), ba.bk(this.f32127f.sr())};
            }
            if (this.f32127f.sr().ou() == 1 && this.f32127f.sr().yn() == 1 && ng.t(this.f32127f.sr()) != null) {
                return ng.t(this.f32127f.sr()).p();
            }
            if (ng.bk(this.f32127f.sr()) != null) {
                return ng.bk(this.f32127f.sr()).p();
            }
            return null;
        }
        return null;
    }

    private boolean yu() {
        if (this.f32127f.sr() == null || this.f32128k == null) {
            return false;
        }
        int m4 = this.f32127f.sr().m();
        return m4 == 1 || m4 == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void B_() {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoLoad(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void C_() {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoAdStartPlay(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void D_() {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoAdPaused(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void E_() {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoAdContinuePlay(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void F_() {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoAdComplete(this);
        }
        if (!yu() || this.bk) {
            return;
        }
        this.f32128k.onFeedRewardCountDown(0);
        this.bk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public boolean ba() {
        return this.gd;
    }

    public int ck() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.w.c.InterfaceC0499c
    public com.bytedance.sdk.openadsdk.core.multipro.w.c eq() {
        return this.f32126c;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public ux gb() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.sr, com.bytedance.sdk.openadsdk.ys.w.w.t
    public View i() {
        WeakReference<NativeVideoTsView> weakReference;
        NativeVideoTsView wv;
        NativeVideoTsView nativeVideoTsView;
        if (this.f32127f.sr() != null && this.f32127f.getContext() != null) {
            if (y()) {
                try {
                    weakReference = this.f32129p;
                } catch (Exception unused) {
                }
                if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
                    return nativeVideoTsView;
                }
                wv = wv();
                wv.setVideoAdClickListenerTTNativeAd(this);
                wv.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.c.xv.1
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.c
                    public void c(View view, int i4) {
                        if (xv.this.f32127f.xv() != null) {
                            xv.this.f32127f.xv().c(view, i4);
                        }
                    }
                });
                k.sr().c(-1L);
                wv.setControllerStatusCallBack(new NativeVideoTsView.xv() { // from class: com.bytedance.sdk.openadsdk.core.component.c.xv.2
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xv
                    public void c(boolean z3, long j4, long j5, long j6, boolean z4, boolean z5) {
                        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = xv.this.f32126c;
                        if (cVar != null) {
                            cVar.f33977c = z3;
                            cVar.ux = j4;
                            cVar.f33978f = j5;
                            cVar.f33979r = j6;
                            cVar.sr = z4;
                            cVar.ev = z5;
                        }
                    }
                });
                wv.setVideoAdLoadListener(this);
                wv.setVideoAdInteractionListener(this);
                if (5 == this.xv) {
                    wv.setIsAutoPlay(this.f32127f.ck() ? this.f32132w.r() : this.f32127f.n());
                } else {
                    wv.setIsAutoPlay(this.f32127f.n());
                }
                wv.setIsQuiet(ls.w().sr(this.f32130r));
                com.bytedance.sdk.openadsdk.core.p.w.xv c4 = this.f32127f.xv().c();
                if (c4 != null) {
                    c4.c(this);
                }
                com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.f32127f.sr()).c(this.xv).w(this.f32130r);
                if (!y() && wv != null && wv.c(0L, true, false)) {
                    return wv;
                }
            }
            wv = null;
            com.bytedance.sdk.openadsdk.core.ux.sr.c().c(this.f32127f.sr()).c(this.xv).w(this.f32130r);
            if (!y()) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.sr, com.bytedance.sdk.openadsdk.ys.w.w.t
    public void ls() {
        WeakReference<NativeVideoTsView> weakReference = this.f32129p;
        if (weakReference != null) {
            NativeVideoTsView nativeVideoTsView = weakReference.get();
            if (nativeVideoTsView != null) {
                nativeVideoTsView.s();
            }
            this.f32129p.clear();
        }
        com.bytedance.sdk.openadsdk.core.i.c cVar = this.f32127f;
        if (cVar != null) {
            cVar.ls();
        }
    }

    public NativeVideoTsView n() {
        WeakReference<NativeVideoTsView> weakReference = this.f32129p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.sr, com.bytedance.sdk.openadsdk.ys.w.w.t
    public Map<String, Object> q() {
        Map<String, Object> q3 = this.f32127f.q();
        if (this.f32127f.sr() == null) {
            return q3;
        }
        if (this.f32127f.sr().nh() != null) {
            if (q3 == null) {
                q3 = new HashMap<>();
            }
            q3.put("group_info", this.f32127f.sr().nh().sr());
            try {
                q3.put("live_support_saas_live", Boolean.valueOf(TTLiveCommerceHelper.getInstance().getLiveSdkStatus() == 2 && TTLiveCommerceHelper.getInstance().isSdkLiveRoomType(this.f32127f.sr().yw(), this.f32127f.sr().kp())));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (this.f32127f.sr().tz() != 166) {
            return q3;
        }
        if (com.bytedance.sdk.openadsdk.core.video.xv.c.c(this.f32127f.sr())) {
            int sr = ba.sr(this.f32127f.sr());
            int ux = ba.ux(this.f32127f.sr());
            if (q3 == null) {
                q3 = new HashMap<>();
            }
            q3.put("live_author_follower_count", Integer.valueOf(sr));
            q3.put("live_watch_count", Integer.valueOf(ux));
        }
        return q3;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int sr() {
        try {
            if (this.sr == null) {
                this.sr = xk();
            }
            int[] iArr = this.sr;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            a.xv("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y() {
        return me.w(this.f32127f.sr());
    }

    public int z() {
        return this.f32130r;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public com.bytedance.sdk.openadsdk.i.c.w.w.c w() {
        if (me.c(this.f32127f.sr())) {
            if (this.ev == null) {
                this.ev = new com.bytedance.sdk.openadsdk.i.c.w.w.c() { // from class: com.bytedance.sdk.openadsdk.core.component.c.xv.3

                    /* renamed from: w  reason: collision with root package name */
                    private long f32136w = 0;

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public String c() {
                        if (xv.this.f32127f.sr() == null || xv.this.f32127f.sr().z() != 1 || ng.bk(xv.this.f32127f.sr()) == null) {
                            return null;
                        }
                        if (!xv.this.gd) {
                            xv.this.gd = true;
                        }
                        return ng.c(xv.this.f32127f.sr());
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void sr() {
                        com.bytedance.sdk.openadsdk.core.a.xv.c(xv.this.f32127f.sr(), wv.c(xv.this.f32127f.sr()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                        if (ng.bk(xv.this.f32127f.sr()) != null) {
                            com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(4, xv.this.f32127f.sr());
                            c4.c("material_meta", xv.this.f32127f.sr());
                            com.bytedance.sdk.openadsdk.ys.w.xv.w oo = xv.this.f32127f.sr().oo();
                            c4.c("ad_slot", Integer.valueOf(oo != null ? oo.q() : 0));
                            c4.ux(-1);
                            com.bytedance.sdk.openadsdk.ux.w.w.w(xv.this.f32127f.sr(), xv.this, c4);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void w() {
                        this.f32136w = SystemClock.elapsedRealtime();
                        ia.c cVar = new ia.c();
                        cVar.w(true);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.c(xv.this, cVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void xv() {
                        if (this.f32136w == 0) {
                            this.f32136w = SystemClock.elapsedRealtime();
                        }
                        long c4 = ((long) xv.this.c()) * 1000;
                        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f32136w) - c4;
                        long j4 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                        ia.c cVar = new ia.c();
                        cVar.c(c4);
                        cVar.xv(c4);
                        cVar.w(j4);
                        cVar.f(0);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.f(xv.this, cVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void w(long j4) {
                        if (this.f32136w == 0) {
                            this.f32136w = SystemClock.elapsedRealtime();
                        }
                        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f32136w) - j4;
                        long j5 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                        ia.c cVar = new ia.c();
                        cVar.c(j4);
                        cVar.xv(((long) xv.this.c()) * 1000);
                        cVar.w(j5);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.xv(xv.this, cVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void c(long j4) {
                        if (this.f32136w == 0) {
                            this.f32136w = SystemClock.elapsedRealtime();
                        }
                        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f32136w) - j4;
                        long j5 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                        ia.c cVar = new ia.c();
                        cVar.c(j4);
                        cVar.xv(((long) xv.this.c()) * 1000);
                        cVar.w(j5);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.w(xv.this, cVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void xv(long j4) {
                        if (this.f32136w == 0) {
                            this.f32136w = SystemClock.elapsedRealtime();
                        }
                        long c4 = ((long) xv.this.c()) * 1000;
                        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f32136w) - j4;
                        long j5 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                        ia.c cVar = new ia.c();
                        cVar.c(j4);
                        cVar.xv(c4);
                        cVar.w(j5);
                        cVar.ux(0);
                        cVar.f(0);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.c(xv.this, cVar, (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void c(int i4, int i5) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(CampaignEx.JSON_KEY_CREATIVE_ID, xv.this.f32127f.sr().jr());
                        hashMap.put("error_code", Integer.valueOf(i4));
                        hashMap.put("extra_error_code", Integer.valueOf(i5));
                        com.bykv.vk.openvk.component.video.api.xv.xv bk = ng.bk(xv.this.f32127f.sr());
                        if (bk != null) {
                            hashMap.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(bk.ux()));
                            hashMap.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, bk.gd());
                        }
                        com.bytedance.sdk.openadsdk.core.a.xv.xv(xv.this.f32127f.sr(), wv.c(xv.this.f32127f.sr()), "play_start_error", hashMap);
                    }

                    @Override // com.bytedance.sdk.openadsdk.i.c.w.w.c
                    public void c(long j4, int i4, int i5) {
                        if (this.f32136w == 0) {
                            this.f32136w = SystemClock.elapsedRealtime();
                        }
                        long c4 = ((long) xv.this.c()) * 1000;
                        long elapsedRealtime = (SystemClock.elapsedRealtime() - this.f32136w) - j4;
                        long j5 = elapsedRealtime >= 0 ? elapsedRealtime : 0L;
                        ia.c cVar = new ia.c();
                        cVar.w(j5);
                        cVar.xv(c4);
                        cVar.c(j4);
                        cVar.c(i4);
                        cVar.w(i5);
                        cVar.c(true);
                        com.bytedance.sdk.openadsdk.ux.w.w.sr(xv.this, cVar);
                    }
                };
            }
            return this.ev;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public int xv() {
        try {
            if (this.sr == null) {
                this.sr = xk();
            }
            int[] iArr = this.sr;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return 1280;
        } catch (Throwable th) {
            a.xv("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    public void c(NativeVideoTsView nativeVideoTsView) {
        this.f32129p = new WeakReference<>(nativeVideoTsView);
    }

    private void c(int i4) {
        int r3 = ls.w().r(i4);
        if (3 == r3) {
            this.f32127f.w(false);
            this.f32127f.c(false);
        } else if (1 == r3 && ys.sr(this.f32127f.getContext())) {
            this.f32127f.w(false);
            this.f32127f.c(true);
        } else if (2 == r3) {
            if (ys.ux(this.f32127f.getContext()) || ys.sr(this.f32127f.getContext()) || ys.f(this.f32127f.getContext())) {
                this.f32127f.w(false);
                this.f32127f.c(true);
            }
        } else if (4 == r3) {
            this.f32127f.w(true);
        } else if (5 == r3) {
            if (ys.sr(this.f32127f.getContext()) || ys.f(this.f32127f.getContext())) {
                this.f32127f.c(true);
            }
        }
    }

    private void w(long j4, long j5) {
        int i4;
        if (yu() && !this.bk) {
            int m4 = this.f32127f.sr().m();
            long j6 = 0;
            if (m4 == 1) {
                j6 = 15000;
            } else if (m4 == 2) {
                j6 = PolicyConfig.mServerBusyRetryBaseInternal;
            }
            if (j5 <= j6) {
                i4 = (int) ((j5 - j4) / 1000);
            } else {
                i4 = (int) ((j6 - j4) / 1000);
            }
            if (i4 < 0) {
                i4 = 0;
            }
            if (i4 == this.f32125a) {
                return;
            }
            this.f32125a = i4;
            if (this.f32125a == 0) {
                this.bk = true;
            }
            this.f32128k.onFeedRewardCountDown(this.f32125a);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.c cVar) {
        this.ux = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public double c() {
        if (gd.c(this.f32127f.sr())) {
            return 0.0d;
        }
        return ng.ux(this.f32127f.sr());
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k
    public void c(com.bytedance.sdk.openadsdk.i.c.w.c.w wVar) {
        this.f32128k = wVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void c(int i4, int i5) {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onVideoError(i4, i5);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void c(long j4, long j5) {
        com.bytedance.sdk.openadsdk.i.c.w.c.c cVar = this.ux;
        if (cVar != null) {
            cVar.onProgressUpdate(j4, j5);
        }
        w(j4, j5);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.j.c.w.c.c cVar, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        View i4;
        try {
            c(viewGroup, (List<View>) null, list, list2, list3, (View) null, cVar);
            if (srVar != null) {
                View findViewById = viewGroup.findViewById(srVar.a());
                if (findViewById != null && f() != null) {
                    findViewById.setVisibility(0);
                    if (findViewById instanceof ViewGroup) {
                        ((ViewGroup) findViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(f());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                        layoutParams.width = xk.ux(viewGroup.getContext(), 38.0f);
                        layoutParams.height = xk.ux(viewGroup.getContext(), 38.0f);
                        findViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) findViewById).addView(imageView, -1, -1);
                    } else if (findViewById instanceof ImageView) {
                        ((ImageView) findViewById).setImageBitmap(f());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(srVar.r());
                if (frameLayout == null || (i4 = i()) == null) {
                    return;
                }
                xk.ev(i4);
                frameLayout.removeAllViews();
                frameLayout.addView(i4, -1, -1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
