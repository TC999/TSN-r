package com.kwad.components.p208ad.p247k;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p417a.C10603c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;

/* renamed from: com.kwad.components.ad.k.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7815a {

    /* renamed from: HA */
    protected AdBaseFrameLayout f26359HA;

    /* renamed from: HB */
    private InterfaceC7822a f26360HB;

    /* renamed from: HF */
    private C10603c.C10604a f26364HF;

    /* renamed from: HG */
    private InterfaceC7823b f26365HG;

    /* renamed from: Hx */
    private KsAdWebView f26367Hx;

    /* renamed from: Hy */
    private boolean f26368Hy;

    /* renamed from: Hz */
    private boolean f26369Hz;
    @Nullable

    /* renamed from: cR */
    private InterfaceC10635a f26370cR;

    /* renamed from: dB */
    private AdBaseFrameLayout f26371dB;

    /* renamed from: da */
    private FrameLayout f26372da;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;

    /* renamed from: Hw */
    private boolean f26366Hw = true;

    /* renamed from: fS */
    private Handler f26373fS = new Handler(Looper.getMainLooper());

    /* renamed from: HC */
    private boolean f26361HC = false;

    /* renamed from: HD */
    private boolean f26362HD = false;

    /* renamed from: HE */
    private boolean f26363HE = false;

    /* renamed from: com.kwad.components.ad.k.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7822a {
        /* renamed from: R */
        void mo31537R(boolean z);
    }

    /* renamed from: com.kwad.components.ad.k.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7823b {
        /* renamed from: iv */
        void mo31538iv();
    }

    /* renamed from: B */
    private static String m32254B(AdTemplate adTemplate) {
        return C10483a.m25943aS(C10487e.m25641dQ(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bx */
    public boolean m32241bx() {
        return this.f26363HE ? !this.f26366Hw : (this.f26366Hw || this.f26361HC || this.f26362HD) ? false : true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: fj */
    private void m32234fj() {
        this.f26372da.removeAllViews();
        this.f26372da.setVisibility(4);
        this.f26359HA = (AdBaseFrameLayout) ((ViewGroup) C10751a.m24922a((ViewGroup) this.f26372da, C9659R.C9663layout.ksad_ad_landingpage_layout, true)).findViewById(C9659R.C9662id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.f26372da.findViewById(C9659R.C9662id.ksad_web_card_webView);
        this.f26367Hx = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        C10603c.C10604a m25339b = this.f26367Hx.getClientConfig().m25336bu(false).m25334bw(true).m25335bv(false).m25337bt(true).m25331ei(this.mAdTemplate).m25341a(m32228mh()).m25339b(m32230ij());
        this.f26364HF = m25339b;
        this.f26367Hx.setClientConfig(m25339b);
        this.f26367Hx.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.k.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                C7815a.m32248a(C7815a.this, true);
                if (C7815a.this.f26360HB != null) {
                    C7815a.this.f26360HB.mo31537R(C7815a.this.m32241bx());
                }
            }
        });
        ImageView imageView = (ImageView) this.f26359HA.findViewById(C9659R.C9662id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.k.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (C7815a.this.f26365HG != null) {
                    C7815a.this.f26365HG.mo31538iv();
                }
            }
        });
    }

    /* renamed from: ij */
    private KsAdWebView.InterfaceC10599d m32230ij() {
        return new KsAdWebView.InterfaceC10599d() { // from class: com.kwad.components.ad.k.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageFinished() {
                if (C7815a.this.f26360HB != null) {
                    C7815a.this.f26360HB.mo31537R(C7815a.this.m32241bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10599d
            public final void onReceivedHttpError(int i, String str, String str2) {
                C7815a.m32242b(C7815a.this, true);
                if (C7815a.this.f26360HB != null) {
                    C7815a.this.f26360HB.mo31537R(C7815a.this.m32241bx());
                }
            }
        };
    }

    /* renamed from: mh */
    private KsAdWebView.InterfaceC10597b m32228mh() {
        return new KsAdWebView.InterfaceC10597b() { // from class: com.kwad.components.ad.k.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10597b
            public final void onFailed() {
                C7815a.m32239c(C7815a.this, true);
                if (C7815a.this.f26360HB != null) {
                    C7815a.this.f26360HB.mo31537R(C7815a.this.m32241bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.InterfaceC10597b
            public final void onSuccess() {
                C7815a.m32239c(C7815a.this, true);
                if (C7815a.this.f26360HB != null) {
                    C7815a.this.f26360HB.mo31537R(C7815a.this.m32241bx());
                }
            }
        };
    }

    /* renamed from: mi */
    private boolean m32227mi() {
        if (m32241bx()) {
            FrameLayout frameLayout = this.f26372da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return true;
            }
            return true;
        }
        FrameLayout frameLayout2 = this.f26372da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    /* renamed from: af */
    public final C7815a m32246af(boolean z) {
        this.f26369Hz = true;
        return this;
    }

    /* renamed from: ar */
    public final boolean m32245ar() {
        boolean m32227mi = m32227mi();
        this.f26363HE = true;
        if (m32227mi && this.mActivity != null) {
            if (this.f26367Hx.getClientConfig() != null) {
                this.f26367Hx.getClientConfig().m25336bu(true);
                this.f26367Hx.getClientConfig().m25335bv(true);
            }
            this.f26359HA.m25392a(new View.OnTouchListener() { // from class: com.kwad.components.ad.k.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > C7815a.this.mBackIcon.getX() && motionEvent.getX() - C7815a.this.mBackIcon.getX() < C7815a.this.mBackIcon.getWidth() && motionEvent.getY() > C7815a.this.mBackIcon.getY() && motionEvent.getY() - C7815a.this.mBackIcon.getY() < C7815a.this.mBackIcon.getHeight()) {
                        C10331c.m26254d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        C7815a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - C7815a.this.mLastDown;
                        if (C7815a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            C9908c.m27349a(C7815a.this.mAdTemplate, 155, C7815a.this.f26371dB.getTouchCoords());
                            if (!C7815a.this.f26368Hy) {
                                C7815a.m32237d(C7815a.this, true);
                                if (C7815a.this.f26370cR != null) {
                                    C10640a c10640a = new C10640a();
                                    c10640a.f29644XC = 3;
                                    C7815a.this.f26370cR.mo25245a(c10640a);
                                }
                            }
                        }
                        C7815a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long m25923am = C10483a.m25923am(C10487e.m25641dQ(this.mAdTemplate));
            if (m25923am != 0 && this.f26369Hz) {
                this.f26373fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.k.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (C7815a.this.mActivity == null || C7815a.this.mActivity.isFinishing()) {
                            return;
                        }
                        C7815a.this.mBackIcon.setVisibility(0);
                        C7815a.this.mBackIcon.setAlpha(0.0f);
                        C7815a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, m25923am);
            } else {
                this.mBackIcon.setVisibility(0);
            }
            KsAdWebView ksAdWebView = this.f26367Hx;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return m32227mi;
    }

    /* renamed from: ay */
    public final void m32244ay() {
        this.f26372da.setVisibility(4);
        String m32254B = m32254B(this.mAdTemplate);
        if (TextUtils.isEmpty(m32254B)) {
            return;
        }
        this.f26367Hx.loadUrl(m32254B);
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m32242b(C7815a c7815a, boolean z) {
        c7815a.f26366Hw = true;
        return true;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m32239c(C7815a c7815a, boolean z) {
        c7815a.f26361HC = true;
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m32237d(C7815a c7815a, boolean z) {
        c7815a.f26368Hy = true;
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32248a(C7815a c7815a, boolean z) {
        c7815a.f26362HD = true;
        return true;
    }

    /* renamed from: a */
    public final void m32252a(InterfaceC7822a interfaceC7822a) {
        this.f26360HB = interfaceC7822a;
    }

    /* renamed from: a */
    public final void m32253a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.f26372da = frameLayout;
        this.f26371dB = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        m32234fj();
        this.f26366Hw = false;
    }

    /* renamed from: a */
    public final void m32251a(InterfaceC7823b interfaceC7823b) {
        this.f26365HG = interfaceC7823b;
    }

    /* renamed from: a */
    public final void m32247a(InterfaceC10635a interfaceC10635a) {
        this.f26370cR = interfaceC10635a;
    }
}
