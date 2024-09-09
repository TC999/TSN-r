package com.kwad.components.ad.feed.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.q;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.c {
    private KsAdVideoPlayConfig dU;
    private a.b eY;
    private long ey;
    private com.kwad.components.core.widget.b fM;
    private float fN;
    private float fO;
    private boolean fP;
    private b.a fZ;
    private com.kwad.components.core.webview.tachikoma.i gj;
    private KSFrameLayout gk;
    private boolean gl;
    private aw gm;
    private com.kwad.sdk.core.webview.c.c gn;
    private o go;
    private a gp;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mHeight;
    private int mWidth;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void c(int i4, String str);
    }

    public n(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD() {
        if (this.gn == null) {
            return;
        }
        bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.n.3
            private boolean a(boolean z3, boolean z4, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i4) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z3 : z4;
                            }
                            return a(z3, z4);
                        }
                        return false;
                    }
                    return z4;
                }
                return z3;
            }

            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                boolean isNetworkConnected = ag.isNetworkConnected(n.this.mContext);
                boolean isWifiConnected = ag.isWifiConnected(n.this.mContext);
                if (n.this.dU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) n.this.dU;
                    dVar.aah = a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.aah = a(isNetworkConnected, isWifiConnected);
                }
                n.this.gn.a(dVar);
            }

            private boolean a(boolean z3, boolean z4) {
                AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(n.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.bU(dQ)) {
                    return z3;
                }
                if (com.kwad.sdk.core.response.b.a.bV(dQ)) {
                    return z4;
                }
                if (com.kwad.sdk.core.response.b.a.bW(dQ)) {
                    return false;
                }
                return com.kwad.sdk.core.config.d.Ce() ? z3 : z4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE() {
        if (this.fM == null) {
            this.gl = true;
            com.kwad.components.core.widget.b a4 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
            this.fM = a4;
            if (a4 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(this.mContext, 16.0f));
                this.gk.removeAllViews();
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.gk.addView(this.fM);
                this.gp.c(1, "");
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.n.5
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                }
            });
        }
        return this.eY;
    }

    private void init(final Context context) {
        int a4 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.asE);
        this.gj = new com.kwad.components.core.webview.tachikoma.i(context, a4, a4);
        com.kwad.sdk.core.c.b.DD();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.b.n.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Context context2 = context;
                if ((context2 instanceof Activity) && context2.equals(activity)) {
                    if (n.this.gj != null) {
                        n.this.gj.jp();
                    }
                    if (n.this.gm != null) {
                        n.this.gm.onDestroy();
                    }
                    com.kwad.sdk.core.c.b.DD();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                }
            }
        });
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.j.a.oG().a(getCurrentVoiceItem());
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sv();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sw();
            com.kwad.components.core.j.a.oG().c(this.eY);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.gk = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sr();
            this.gm.ss();
            com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 3, 3);
        }
        b.a aVar = this.abm;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
        if ((r0 * r5) < r7) goto L26;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            int r0 = r10.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            boolean r1 = com.kwad.sdk.core.config.d.Co()
            if (r1 == 0) goto L8d
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.b.d.dF(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.b.b.cf(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.gk
            if (r0 == 0) goto L88
            boolean r0 = r9.gl
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.gk
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.fO
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r3 = r1.maxRange
            double r3 = (double) r3
            double r3 = java.lang.Math.tan(r3)
            double r5 = (double) r0
            java.lang.Double.isNaN(r5)
            double r3 = r3 * r5
            double r7 = (double) r2
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 < 0) goto L82
            int r0 = r1.minRange
            double r0 = (double) r0
            double r0 = java.lang.Math.tan(r0)
            java.lang.Double.isNaN(r5)
            double r0 = r0 * r5
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 >= 0) goto L88
        L82:
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.gk
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
        L88:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L8d:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.gp;
        if (aVar2 != null) {
            aVar2.c(this.gl ? 1 : 3, "");
        }
        this.gp = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
        bD();
    }

    public final void setWidth(int i4) {
        if (i4 <= 0) {
            i4 = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i4;
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((n) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.ey = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate) > 0.0d) {
            double d4 = this.mWidth;
            double cM = com.kwad.sdk.core.response.b.b.cM(this.mAdTemplate);
            Double.isNaN(d4);
            this.mHeight = (int) (d4 * cM);
        } else {
            this.mHeight = this.gk.getHeight();
        }
        this.gj.a(com.kwad.sdk.n.l.dn(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.b.n.2
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                n.this.bE();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void b(ac.a aVar) {
                aVar.width = com.kwad.sdk.d.a.a.px2dip(n.this.mContext, n.this.mWidth);
                aVar.height = com.kwad.sdk.d.a.a.px2dip(n.this.mContext, n.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bF() {
                if (n.this.gp != null) {
                    n.this.gp.c(3, "");
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return n.this.gk;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.dA(n.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(q qVar, com.kwad.sdk.core.webview.b bVar) {
                qVar.c(new x(bVar, n.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) n.this.gj, true));
                qVar.c(new com.kwad.components.core.webview.tachikoma.a.n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        n.this.gn = cVar2;
                        n.this.bD();
                    }
                });
                qVar.c(new v() { // from class: com.kwad.components.ad.feed.b.n.2.2
                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.a(xVar);
                        if (com.kwad.components.core.s.a.ah(n.this.mContext).qW() && n.this.go != null) {
                            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                            mVar.aao = true;
                            n.this.go.c(mVar);
                        }
                        com.kwad.components.core.j.a.oG().a(n.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.ey);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.b(xVar);
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.ey);
                        com.kwad.components.core.o.a.qi().c(n.this.mAdTemplate, xVar.errorCode, xVar.sU());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.c(xVar);
                        com.kwad.components.core.j.a.oG().c(n.this.eY);
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (n.this.abm != null) {
                    n.this.abm.onAdClicked();
                }
                n.this.bw();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
                n.this.go = oVar;
                n.this.go.a(new o.a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
                        if (com.kwad.components.core.j.a.b(r3.gs.gr.eY) == false) goto L5;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
                    @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final boolean isMuted() {
                        /*
                            r3 = this;
                            boolean r0 = com.kwad.sdk.core.config.d.gs()
                            r1 = 1
                            if (r0 != 0) goto L1a
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            android.content.Context r0 = com.kwad.components.ad.feed.b.n.z(r0)
                            com.kwad.components.core.s.a r0 = com.kwad.components.core.s.a.ah(r0)
                            boolean r0 = r0.qW()
                            if (r0 == 0) goto L1a
                            goto L70
                        L1a:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            if (r0 == 0) goto L36
                            com.kwad.components.core.j.a.oG()
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.ad.feed.b.n.r(r0)
                            boolean r0 = com.kwad.components.core.j.a.b(r0)
                            if (r0 != 0) goto L36
                            goto L70
                        L36:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                            int r0 = r0.getVideoSoundValue()
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.ad.feed.b.n.A(r0)
                            boolean r0 = r0.isVideoSoundEnable()
                            r0 = r0 ^ r1
                            goto L71
                        L60:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.ad.feed.b.n.B(r0)
                            boolean r0 = com.kwad.sdk.core.response.b.a.bT(r0)
                            if (r0 != 0) goto L6f
                            goto L70
                        L6f:
                            r1 = 0
                        L70:
                            r0 = r1
                        L71:
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.C(r1)
                            if (r1 == 0) goto L87
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.ad.feed.b.n.AnonymousClass2.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.ad.feed.b.n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.ad.feed.b.n.D(r1)
                            r2 = r0 ^ 1
                            r1.mIsAudioEnable = r2
                        L87:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.b.n.AnonymousClass2.AnonymousClass3.isMuted():boolean");
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (n.this.gm != null) {
                    n.this.gm.st();
                    n.this.gm.su();
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.n.2.4
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        n.this.tk();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(aw awVar) {
                n.this.gm = awVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0652a c0652a) {
                if (n.this.abm != null) {
                    String str = c0652a.VR;
                    str.hashCode();
                    char c4 = '\uffff';
                    switch (str.hashCode()) {
                        case -1929947611:
                            if (str.equals("adShowCallback")) {
                                c4 = 0;
                                break;
                            }
                            break;
                        case -1291763712:
                            if (str.equals("adDownloadConfirmTipCancel")) {
                                c4 = 1;
                                break;
                            }
                            break;
                        case -1228923142:
                            if (str.equals("adCloseCallback")) {
                                c4 = 2;
                                break;
                            }
                            break;
                        case -532703741:
                            if (str.equals("adDownloadConfirmTipShow")) {
                                c4 = 3;
                                break;
                            }
                            break;
                        case -268512828:
                            if (str.equals("adDownloadConfirmTipDismiss")) {
                                c4 = 4;
                                break;
                            }
                            break;
                        case 1852274314:
                            if (str.equals("adClickCallback")) {
                                c4 = 5;
                                break;
                            }
                            break;
                    }
                    switch (c4) {
                        case 0:
                            n.this.abm.onAdShow();
                            return;
                        case 1:
                        case 4:
                            n.this.abm.onDownloadTipsDialogDismiss();
                            return;
                        case 2:
                            n.this.abm.onDislikeClicked();
                            return;
                        case 3:
                            n.this.abm.onDownloadTipsDialogShow();
                            return;
                        case 5:
                            n.this.abm.onAdClicked();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    private n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.gl = false;
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.n.4
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (n.this.abm != null) {
                    n.this.abm.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, n.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (n.this.gl) {
                    if (n.this.abm != null) {
                        n.this.abm.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0688a c0688a = new a.C0688a();
                    FeedType fromInt = FeedType.fromInt(n.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0688a.templateId = String.valueOf(fromInt.getType());
                    bVar.b(c0688a);
                    bVar.v(n.this.getHeight(), n.this.mWidth);
                    com.kwad.components.core.s.b.qY().a(n.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (n.this.abm != null) {
                    n.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (n.this.abm != null) {
                    n.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (n.this.abm != null) {
                    n.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.fN = motionEvent.getX();
            this.fO = motionEvent.getY();
        }
    }
}
