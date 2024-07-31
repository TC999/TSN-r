package com.kwad.components.p208ad.p236h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.tachikoma.C9305i;
import com.kwad.components.core.webview.tachikoma.InterfaceC9339j;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.widget.p338a.C9366b;
import com.kwad.components.p208ad.p210b.p211a.InterfaceC7342b;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p391c.InterfaceC10246c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.InterfaceC11147e;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.h.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7674d extends KSFrameLayout implements InterfaceC9339j, InterfaceC10385c {

    /* renamed from: nU */
    public static String f25996nU = "PUSH_VIEW_TAG";

    /* renamed from: bQ */
    private final C9366b f25997bQ;

    /* renamed from: cQ */
    private C9109aw f25998cQ;

    /* renamed from: gj */
    private C9305i f25999gj;

    /* renamed from: nV */
    private AdTemplate f26000nV;

    /* renamed from: nW */
    private InterfaceC7342b f26001nW;

    /* renamed from: nX */
    private boolean f26002nX;

    /* renamed from: nY */
    private ViewGroup f26003nY;

    /* renamed from: nZ */
    private boolean f26004nZ;

    public C7674d(@NonNull Context context, AdTemplate adTemplate) {
        super(context);
        this.f26002nX = false;
        setTag(f25996nU);
        this.f26000nV = adTemplate;
        this.f25997bQ = new C9366b(this, 100);
        this.f25999gj = new C9305i(-1L, getContext()) { // from class: com.kwad.components.ad.h.d.1
            {
                super(-1L, r4);
            }

            @Override // com.kwad.components.core.webview.tachikoma.C9305i
            /* renamed from: a */
            public final void mo29056a(C10605b c10605b, C8619c c8619c, InterfaceC9876q interfaceC9876q, ViewGroup viewGroup) {
                super.mo29056a(c10605b, c8619c, interfaceC9876q, viewGroup);
                interfaceC9876q.mo27480c(new C9185x(c10605b, c8619c, this) { // from class: com.kwad.components.ad.h.d.1.1
                    @Override // com.kwad.components.core.webview.jshandler.C9185x
                    /* renamed from: K */
                    public final void mo29208K(int i) {
                        super.mo29208K(i);
                        if (i == 3) {
                            C7674d.this.mo28984a((WebCloseStatus) null);
                        }
                    }
                });
            }
        };
        this.f25999gj.mo29075a((Activity) null, C10485c.m25662dB(this.f26000nV), this);
    }

    private void destroy() {
        this.f25999gj.mo29029jp();
        ViewGroup viewGroup = this.f26003nY;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: eQ */
    public void m32672eQ() {
        if (this.f26004nZ) {
            return;
        }
        this.f26004nZ = true;
        m32669eT();
        destroy();
    }

    /* renamed from: eR */
    private void m32671eR() {
        InterfaceC7342b interfaceC7342b = this.f26001nW;
        if (interfaceC7342b != null) {
            interfaceC7342b.mo32675T();
        }
        C9109aw c9109aw = this.f25998cQ;
        if (c9109aw != null) {
            c9109aw.m29268sr();
            this.f25998cQ.m29267ss();
        }
    }

    /* renamed from: eT */
    private void m32669eT() {
        InterfaceC7342b interfaceC7342b = this.f26001nW;
        if (interfaceC7342b != null) {
            interfaceC7342b.mo30303U();
        }
        C9109aw c9109aw = this.f25998cQ;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f25998cQ.m29265su();
        }
    }

    /* renamed from: eU */
    private boolean m32668eU() {
        try {
            C10232b.m26625DD();
            final Activity currentActivity = C10232b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    this.f26003nY = (ViewGroup) findViewById;
                    this.f26003nY.addView(this, new ViewGroup.LayoutParams(-1, -1));
                    C10232b.m26625DD();
                    C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.components.ad.h.d.2
                        @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
                        /* renamed from: onActivityDestroyed */
                        public final void mo24589b(Activity activity) {
                            super.mo24589b(activity);
                            C10232b.m26625DD();
                            C10232b.m26621b((InterfaceC10246c) this);
                            if (activity.equals(currentActivity)) {
                                C7674d.this.m32672eQ();
                            }
                        }
                    });
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28991a(C9031a.C9033a c9033a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28988a(C9216o c9216o) {
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
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        C10331c.m26254d("PushAdView", "onPageVisible: ");
        C9109aw c9109aw = this.f25998cQ;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        }
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
        C10331c.m26254d("PushAdView", "onPageInvisible: ");
        C9109aw c9109aw = this.f25998cQ;
        if (c9109aw != null) {
            c9109aw.m29263sw();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        this.f25997bQ.mo26187a(this);
        this.f25997bQ.m28900tw();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        this.f25997bQ.release();
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C10751a.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C10751a.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bF */
    public final void mo28980bF() {
        C10331c.m26254d("PushAdView", "onTkLoadSuccess");
        this.f26002nX = true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: bG */
    public final void mo28979bG() {
    }

    /* renamed from: c */
    public final boolean m32673c(InterfaceC7342b interfaceC7342b) {
        this.f26001nW = interfaceC7342b;
        if (this.f26002nX && m32668eU()) {
            m32671eR();
            return true;
        }
        return false;
    }

    /* renamed from: eS */
    public final boolean m32670eS() {
        return this.f26002nX;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final FrameLayout getTKContainer() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTKReaderScene() {
        return "tk_push_ad";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final String getTkTemplateId() {
        return C10484b.m25673dy(this.f26000nV);
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public final InterfaceC11147e getTouchCoordsView() {
        return this;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        C10331c.m26254d("PushAdView", "onTkLoadFailed");
        this.f26002nX = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        C10331c.m26254d("PushAdView", "onAdClicked");
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28990a(C9109aw c9109aw) {
        this.f25998cQ = c9109aw;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(@Nullable WebCloseStatus webCloseStatus) {
        m32672eQ();
    }
}
