package com.kwad.components.p208ad.feed.p226b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p299j.C8682a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.p330s.C8932a;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9180v;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9215n;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9243d;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b;
import com.kwad.components.model.FeedType;
import com.kwad.components.p208ad.feed.C7499b;
import com.kwad.components.p208ad.feed.monitor.C7601b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.adlog.C9893a;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.InterfaceC11147e;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.feed.b.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7566n extends AbstractDialogInterface$OnDismissListenerC9367b<AdResultData, AdTemplate> implements InterfaceC11145c {

    /* renamed from: dU */
    private KsAdVideoPlayConfig f25777dU;

    /* renamed from: eY */
    private C8682a.C8684b f25778eY;

    /* renamed from: ey */
    private long f25779ey;

    /* renamed from: fM */
    private AbstractDialogInterface$OnDismissListenerC9367b f25780fM;

    /* renamed from: fN */
    private float f25781fN;

    /* renamed from: fO */
    private float f25782fO;

    /* renamed from: fP */
    private boolean f25783fP;

    /* renamed from: fZ */
    private AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a f25784fZ;

    /* renamed from: gj */
    private C9305i f25785gj;

    /* renamed from: gk */
    private KSFrameLayout f25786gk;

    /* renamed from: gl */
    private boolean f25787gl;

    /* renamed from: gm */
    private C9109aw f25788gm;

    /* renamed from: gn */
    private InterfaceC10627c f25789gn;

    /* renamed from: go */
    private C9216o f25790go;

    /* renamed from: gp */
    private InterfaceC7576a f25791gp;
    private C8619c mApkDownloadHelper;
    private int mHeight;
    private int mWidth;

    /* renamed from: com.kwad.components.ad.feed.b.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7576a {
        /* renamed from: c */
        void mo32842c(int i, String str);
    }

    public C7566n(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bD */
    public void m32884bD() {
        if (this.f25789gn == null) {
            return;
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.n.3
            /* renamed from: a */
            private boolean m32856a(boolean z, boolean z2, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z : z2;
                            }
                            return m32857a(z, z2);
                        }
                        return false;
                    }
                    return z2;
                }
                return z;
            }

            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9243d c9243d = new C9243d();
                boolean isNetworkConnected = C11013ag.isNetworkConnected(C7566n.this.mContext);
                boolean isWifiConnected = C11013ag.isWifiConnected(C7566n.this.mContext);
                if (C7566n.this.f25777dU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) C7566n.this.f25777dU;
                    c9243d.aah = m32856a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    c9243d.aah = m32857a(isNetworkConnected, isWifiConnected);
                }
                C7566n.this.f25789gn.mo25251a(c9243d);
            }

            /* renamed from: a */
            private boolean m32857a(boolean z, boolean z2) {
                AdInfo m25641dQ = C10487e.m25641dQ(C7566n.this.mAdTemplate);
                if (C10483a.m25887bU(m25641dQ)) {
                    return z;
                }
                if (C10483a.m25886bV(m25641dQ)) {
                    return z2;
                }
                if (C10483a.m25885bW(m25641dQ)) {
                    return false;
                }
                return C10251d.m26550Ce() ? z : z2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bE */
    public void m32883bE() {
        if (this.f25780fM == null) {
            this.f25787gl = true;
            AbstractDialogInterface$OnDismissListenerC9367b m33145a = C7499b.m33145a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), C10483a.m25875be(this.mAdInfo));
            this.f25780fM = m33145a;
            if (m33145a != null) {
                this.f25780fM.setMargin(C10751a.m24924a(this.mContext, 16.0f));
                this.f25786gk.removeAllViews();
                this.f25780fM.setInnerAdInteractionListener(this.f25784fZ);
                this.f25786gk.addView(this.f25780fM);
                this.f25791gp.mo32842c(1, "");
                this.f25780fM.mo28891b((AbstractDialogInterface$OnDismissListenerC9367b) this.mAdResultData);
                AbstractDialogInterface$OnDismissListenerC9367b abstractDialogInterface$OnDismissListenerC9367b = this.f25780fM;
                if (abstractDialogInterface$OnDismissListenerC9367b instanceof AbstractView$OnClickListenerC7506c) {
                    ((AbstractView$OnClickListenerC7506c) abstractDialogInterface$OnDismissListenerC9367b).m33124a(this.f25777dU);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bw */
    public void m32882bw() {
        if (this.f25783fP) {
            return;
        }
        this.f25783fP = true;
        C7601b.m32814a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C8682a.C8684b getCurrentVoiceItem() {
        if (this.f25778eY == null) {
            this.f25778eY = new C8682a.C8684b(new C8682a.InterfaceC8685c() { // from class: com.kwad.components.ad.feed.b.n.5
                @Override // com.kwad.components.core.p299j.C8682a.InterfaceC8685c
                /* renamed from: bk */
                public final void mo30017bk() {
                }
            });
        }
        return this.f25778eY;
    }

    private void init(final Context context) {
        int m26524a = C10251d.m26524a(C10250c.asE);
        this.f25785gj = new C9305i(context, m26524a, m26524a);
        C10232b.m26625DD();
        C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.components.ad.feed.b.n.1
            @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
            /* renamed from: onActivityDestroyed */
            public final void mo24589b(@NonNull Activity activity) {
                Context context2 = context;
                if ((context2 instanceof Activity) && context2.equals(activity)) {
                    if (C7566n.this.f25785gj != null) {
                        C7566n.this.f25785gj.mo29029jp();
                    }
                    if (C7566n.this.f25788gm != null) {
                        C7566n.this.f25788gm.onDestroy();
                    }
                    C10232b.m26625DD();
                    C10232b.m26621b((InterfaceC10246c) this);
                }
            }
        });
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        super.mo26182aM();
        C8682a.m30020oG().m30023a(getCurrentVoiceItem());
        C9109aw c9109aw = this.f25788gm;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b, com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        super.mo26181aN();
        C9109aw c9109aw = this.f25788gm;
        if (c9109aw != null) {
            c9109aw.m29263sw();
            C8682a.m30020oG().m30021c(this.f25778eY);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bc */
    public final void mo28890bc() {
        this.f25786gk = (KSFrameLayout) findViewById(C9659R.C9662id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: bv */
    public final void mo28888bv() {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        C9109aw c9109aw = this.f25788gm;
        if (c9109aw != null) {
            c9109aw.m29268sr();
            this.f25788gm.m29267ss();
            C7601b.m32817a((AdTemplate) this.mAdTemplate, 3, 3);
        }
        AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a interfaceC9370a = this.abm;
        if (interfaceC9370a != null) {
            interfaceC9370a.onAdShow();
        }
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_feed_tkview;
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
            boolean r1 = com.kwad.sdk.core.config.C10251d.m26540Co()
            if (r1 == 0) goto L8d
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            boolean r1 = com.kwad.sdk.core.response.p409b.C10486d.m25657dF(r1)
            if (r1 != 0) goto L16
            goto L8d
        L16:
            R extends com.kwad.sdk.core.response.model.AdTemplate r1 = r9.mAdTemplate
            com.kwad.sdk.core.response.model.FeedSlideConf r1 = com.kwad.sdk.core.response.p409b.C10484b.m25762cf(r1)
            if (r1 != 0) goto L23
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L23:
            r9.m32894a(r10)
            r2 = 2
            if (r0 == r2) goto L2c
            r2 = 3
            if (r0 != r2) goto L88
        L2c:
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.f25786gk
            if (r0 == 0) goto L88
            boolean r0 = r9.f25787gl
            if (r0 != 0) goto L88
            float r0 = r10.getX()
            float r2 = r9.f25781fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L88
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.f25786gk
            r2 = 1
            r0.requestDisallowInterceptTouchEvent(r2)
            float r0 = r10.getX()
            float r2 = r9.f25781fN
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r10.getY()
            float r3 = r9.f25782fO
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
            com.kwad.sdk.widget.KSFrameLayout r0 = r9.f25786gk
            r1 = 0
            r0.requestDisallowInterceptTouchEvent(r1)
        L88:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        L8d:
            boolean r10 = super.onInterceptTouchEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.C7566n.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setTKLoadListener(InterfaceC7576a interfaceC7576a) {
        InterfaceC7576a interfaceC7576a2 = this.f25791gp;
        if (interfaceC7576a2 != null) {
            interfaceC7576a2.mo32842c(this.f25787gl ? 1 : 3, "");
        }
        this.f25791gp = interfaceC7576a;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f25777dU = ksAdVideoPlayConfig;
        m32884bD();
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    private C7566n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b
    /* renamed from: b */
    public final void mo28891b(@NonNull AdResultData adResultData) {
        super.mo28891b((C7566n) adResultData);
        C8619c c8619c = new C8619c(this.mAdTemplate);
        this.mApkDownloadHelper = c8619c;
        c8619c.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.f25779ey = SystemClock.elapsedRealtime();
        if (C10484b.m25779cM(this.mAdTemplate) > Utils.DOUBLE_EPSILON) {
            double d = this.mWidth;
            double m25779cM = C10484b.m25779cM(this.mAdTemplate);
            Double.isNaN(d);
            this.mHeight = (int) (d * m25779cM);
        } else {
            this.mHeight = this.f25786gk.getHeight();
        }
        this.f25785gj.mo29075a(C10887l.m24559dn(this.mContext), adResultData, new InterfaceC9339j() { // from class: com.kwad.components.ad.feed.b.n.2
            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
                C7566n.this.m32883bE();
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28987a(C9218p c9218p) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28986a(C9252m c9252m) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28985a(C9259t c9259t) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: b */
            public final void mo28981b(C9043ac.C9044a c9044a) {
                c9044a.width = C10751a.px2dip(C7566n.this.mContext, C7566n.this.mWidth);
                c9044a.height = C10751a.px2dip(C7566n.this.mContext, C7566n.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: bF */
            public final void mo28980bF() {
                if (C7566n.this.f25791gp != null) {
                    C7566n.this.f25791gp.mo32842c(3, "");
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: bG */
            public final void mo28979bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final FrameLayout getTKContainer() {
                return C7566n.this.f25786gk;
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final String getTkTemplateId() {
                return C10484b.m25740dA(C7566n.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            public final InterfaceC11147e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
                interfaceC9876q.mo27480c(new C9185x(c10605b, C7566n.this.mApkDownloadHelper, (InterfaceC10635a) C7566n.this.f25785gj, true));
                interfaceC9876q.mo27480c(new C9215n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
                    /* renamed from: a */
                    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                        super.mo25241a(str, interfaceC10627c);
                        C7566n.this.f25789gn = interfaceC10627c;
                        C7566n.this.m32884bD();
                    }
                });
                interfaceC9876q.mo27480c(new C9180v() { // from class: com.kwad.components.ad.feed.b.n.2.2
                    @Override // com.kwad.components.core.webview.jshandler.C9180v
                    /* renamed from: a */
                    public final void mo29216a(C9263x c9263x) {
                        super.mo29216a(c9263x);
                        if (C8932a.m29575ah(C7566n.this.mContext).m29573qW() && C7566n.this.f25790go != null) {
                            C9252m c9252m = new C9252m();
                            c9252m.aao = true;
                            C7566n.this.f25790go.m29179c(c9252m);
                        }
                        C8682a.m30020oG().m30023a(C7566n.this.getCurrentVoiceItem());
                        C7601b.m32815a(C7566n.this.mAdTemplate, 1, 1, C10483a.m25977K(C7566n.this.mAdInfo), null, SystemClock.elapsedRealtime() - C7566n.this.f25779ey);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.C9180v
                    /* renamed from: b */
                    public final void mo29215b(C9263x c9263x) {
                        super.mo29215b(c9263x);
                        C7601b.m32815a(C7566n.this.mAdTemplate, 2, 1, C10483a.m25977K(C7566n.this.mAdInfo), c9263x.errorReason, SystemClock.elapsedRealtime() - C7566n.this.f25779ey);
                        C8766a.m29888qi().m29900c(C7566n.this.mAdTemplate, c9263x.errorCode, c9263x.m29162sU());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.C9180v
                    /* renamed from: c */
                    public final void mo29214c(C9263x c9263x) {
                        super.mo29214c(c9263x);
                        C8682a.m30020oG().m30021c(C7566n.this.f25778eY);
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28982a(@Nullable C10640a c10640a) {
                if (C7566n.this.abm != null) {
                    C7566n.this.abm.onAdClicked();
                }
                C7566n.this.m32882bw();
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28988a(C9216o c9216o) {
                C7566n.this.f25790go = c9216o;
                C7566n.this.f25790go.m29180a(new C9216o.InterfaceC9217a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
                        if (com.kwad.components.core.p299j.C8682a.m30022b(r3.f25797gs.f25794gr.f25778eY) == false) goto L5;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
                    @Override // com.kwad.components.core.webview.tachikoma.p333a.C9216o.InterfaceC9217a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final boolean isMuted() {
                        /*
                            r3 = this;
                            boolean r0 = com.kwad.sdk.core.config.C10251d.m26517gs()
                            r1 = 1
                            if (r0 != 0) goto L1a
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            android.content.Context r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32858z(r0)
                            com.kwad.components.core.s.a r0 = com.kwad.components.core.p330s.C8932a.m29575ah(r0)
                            boolean r0 = r0.m29573qW()
                            if (r0 == 0) goto L1a
                            goto L70
                        L1a:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32866r(r0)
                            if (r0 == 0) goto L36
                            com.kwad.components.core.p299j.C8682a.m30020oG()
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.components.core.j.a$b r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32866r(r0)
                            boolean r0 = com.kwad.components.core.p299j.C8682a.m30022b(r0)
                            if (r0 != 0) goto L36
                            goto L70
                        L36:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32920A(r0)
                            boolean r0 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32920A(r0)
                            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
                            int r0 = r0.getVideoSoundValue()
                            if (r0 == 0) goto L60
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32920A(r0)
                            boolean r0 = r0.isVideoSoundEnable()
                            r0 = r0 ^ r1
                            goto L71
                        L60:
                            com.kwad.components.ad.feed.b.n$2 r0 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r0 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.core.response.model.AdInfo r0 = com.kwad.components.p208ad.feed.p226b.C7566n.m32919B(r0)
                            boolean r0 = com.kwad.sdk.core.response.p409b.C10483a.m25888bT(r0)
                            if (r0 != 0) goto L6f
                            goto L70
                        L6f:
                            r1 = 0
                        L70:
                            r0 = r1
                        L71:
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.p208ad.feed.p226b.C7566n.m32918C(r1)
                            if (r1 == 0) goto L87
                            com.kwad.components.ad.feed.b.n$2 r1 = com.kwad.components.p208ad.feed.p226b.C7566n.C75682.this
                            com.kwad.components.ad.feed.b.n r1 = com.kwad.components.p208ad.feed.p226b.C7566n.this
                            com.kwad.sdk.core.response.model.AdTemplate r1 = com.kwad.components.p208ad.feed.p226b.C7566n.m32917D(r1)
                            r2 = r0 ^ 1
                            r1.mIsAudioEnable = r2
                        L87:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.feed.p226b.C7566n.C75682.C75713.isMuted():boolean");
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28984a(WebCloseStatus webCloseStatus) {
                if (C7566n.this.f25788gm != null) {
                    C7566n.this.f25788gm.m29266st();
                    C7566n.this.f25788gm.m29265su();
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.feed.b.n.2.4
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C7566n.this.m28884tk();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28990a(C9109aw c9109aw) {
                C7566n.this.f25788gm = c9109aw;
            }

            @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
            /* renamed from: a */
            public final void mo28991a(C9031a.C9033a c9033a) {
                if (C7566n.this.abm != null) {
                    String str = c9033a.f29075VR;
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -1929947611:
                            if (str.equals("adShowCallback")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1291763712:
                            if (str.equals("adDownloadConfirmTipCancel")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1228923142:
                            if (str.equals("adCloseCallback")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -532703741:
                            if (str.equals("adDownloadConfirmTipShow")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -268512828:
                            if (str.equals("adDownloadConfirmTipDismiss")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1852274314:
                            if (str.equals("adClickCallback")) {
                                c = 5;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            C7566n.this.abm.onAdShow();
                            return;
                        case 1:
                        case 4:
                            C7566n.this.abm.onDownloadTipsDialogDismiss();
                            return;
                        case 2:
                            C7566n.this.abm.onDislikeClicked();
                            return;
                        case 3:
                            C7566n.this.abm.onDownloadTipsDialogShow();
                            return;
                        case 5:
                            C7566n.this.abm.onAdClicked();
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    private C7566n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.f25787gl = false;
        this.f25784fZ = new AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a() { // from class: com.kwad.components.ad.feed.b.n.4
            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdClicked() {
                if (C7566n.this.abm != null) {
                    C7566n.this.abm.onAdClicked();
                }
                C7601b.m32814a(C7566n.this.mAdTemplate, 1, C7566n.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onAdShow() {
                if (C7566n.this.f25787gl) {
                    if (C7566n.this.abm != null) {
                        C7566n.this.abm.onAdShow();
                    }
                    C9913b c9913b = new C9913b();
                    C9893a.C9894a c9894a = new C9893a.C9894a();
                    FeedType fromInt = FeedType.fromInt(C7566n.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c9894a.templateId = String.valueOf(fromInt.getType());
                    c9913b.m27268b(c9894a);
                    c9913b.m27245v(C7566n.this.getHeight(), C7566n.this.mWidth);
                    C8934b.m29570qY().m29571a(C7566n.this.mAdTemplate, null, c9913b);
                    C7601b.m32817a(C7566n.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDislikeClicked() {
                if (C7566n.this.abm != null) {
                    C7566n.this.abm.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogDismiss() {
                if (C7566n.this.abm != null) {
                    C7566n.this.abm.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.AbstractDialogInterface$OnDismissListenerC9367b.InterfaceC9370a
            public final void onDownloadTipsDialogShow() {
                if (C7566n.this.abm != null) {
                    C7566n.this.abm.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    /* renamed from: a */
    private void m32894a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f25781fN = motionEvent.getX();
            this.f25782fO = motionEvent.getY();
        }
    }
}
