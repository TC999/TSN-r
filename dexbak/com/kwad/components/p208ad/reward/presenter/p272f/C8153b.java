package com.kwad.components.p208ad.reward.presenter.p272f;

import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9180v;
import com.kwad.components.core.webview.tachikoma.C9238b;
import com.kwad.components.core.webview.tachikoma.C9265c;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p334b.C9242c;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.components.p208ad.reward.model.C8027b;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p258k.p259a.C7964d;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.reward.presenter.f.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8153b extends AbstractDialogInterface$OnDismissListenerC8159d {

    /* renamed from: wg */
    private FrameLayout f27062wg;

    /* renamed from: wh */
    private boolean f27063wh = false;

    /* renamed from: T */
    private void m31430T(boolean z) {
        this.f27062wg.setVisibility(z ? 0 : 8);
    }

    /* renamed from: dB */
    private C9265c m31424dB() {
        return new C9265c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.C9265c, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C9242c c9242c = new C9242c();
                c9242c.aag = C8027b.m31797cO();
                interfaceC10627c.mo25251a(c9242c);
            }
        };
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (this.f27063wh) {
            return;
        }
        m31430T(true);
    }

    @IdRes
    /* renamed from: ci */
    protected int mo31426ci() {
        return C9659R.C9662id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public FrameLayout getTKContainer() {
        return this.f27062wg;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public String getTkTemplateId() {
        return C10484b.m25695dn(this.f26957qo.mAdTemplate);
    }

    /* renamed from: gn */
    public final BackPressHandleResult m31420gn() {
        C7964d c7964d = this.f27071wk;
        if (c7964d == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return c7964d.m31915gn();
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d
    /* renamed from: iM */
    protected final boolean mo31374iM() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27062wg = (FrameLayout) findViewById(mo31426ci());
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(m31424dB());
        interfaceC9876q.mo27480c(new C9238b(new C9238b.InterfaceC9239a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.C9238b.InterfaceC9239a
            /* renamed from: dL */
            public final void mo29166dL() {
                C8027b.m31799J(C8153b.this.f26957qo.mContext);
            }
        }));
        interfaceC9876q.mo27480c(new C9180v() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: a */
            public final void mo29216a(C9263x c9263x) {
                super.mo29216a(c9263x);
                C8153b.this.f26957qo.f26528oI.onVideoPlayStart();
                C8032c.m31757b(C8153b.this.f26957qo.f26544oY, C8153b.this.f26957qo.mAdTemplate, C8153b.this.f26957qo.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: b */
            public final void mo29215b(C9263x c9263x) {
                super.mo29215b(c9263x);
                long m29162sU = c9263x.m29162sU();
                C8153b.this.f26957qo.f26528oI.onVideoPlayError(c9263x.errorCode, (int) m29162sU);
                C8032c.m31767a(C8153b.this.f26957qo.f26544oY, C8153b.this.f26957qo.mAdTemplate, C8153b.this.f26957qo.f26573pv, c9263x.errorCode, m29162sU);
                C8031b.m31778c(C8153b.this.f26957qo.f26544oY, C8153b.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: c */
            public final void mo29214c(C9263x c9263x) {
                super.mo29214c(c9263x);
                C8153b.this.f26957qo.f26528oI.onVideoPlayEnd();
                C8153b.this.f26957qo.mAdTemplate.setmCurPlayTime(-1L);
                C8141f.m31459s(C8153b.this.f26957qo);
            }

            @Override // com.kwad.components.core.webview.jshandler.C9180v
            /* renamed from: d */
            public final void mo29213d(C9263x c9263x) {
                super.mo29213d(c9263x);
                C8153b.this.f26957qo.mAdTemplate.setmCurPlayTime(c9263x.f29320nE);
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: b */
    public final void mo28981b(C9043ac.C9044a c9044a) {
        float m24919aJ = C10751a.m24919aJ(getContext());
        c9044a.width = (int) ((C10751a.getScreenWidth(getContext()) / m24919aJ) + 0.5f);
        c9044a.height = (int) ((C10751a.getScreenHeight(getContext()) / m24919aJ) + 0.5f);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(final C9259t c9259t) {
        C10331c.m26254d("TKLivePresenter", "onSkipClick: " + c9259t.f29318VU);
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C8153b.this.f26957qo != null && C8153b.this.f26957qo.f26528oI != null) {
                    C8153b.this.f26957qo.f26528oI.onVideoSkipToEnd(c9259t.f29318VU * 1000);
                }
                C8141f.m31459s(C8153b.this.f26957qo);
            }
        });
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        super.mo28989a(tKRenderFailReason);
        C8031b.m31783a(this.mAdTemplate, tKRenderFailReason);
        this.f27063wh = true;
        m31430T(false);
    }
}
