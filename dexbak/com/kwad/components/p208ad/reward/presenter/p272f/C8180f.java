package com.kwad.components.p208ad.reward.presenter.p272f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p298i.C8665a;
import com.kwad.components.core.p298i.C8674c;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.C9151h;
import com.kwad.components.core.webview.jshandler.InterfaceC9165n;
import com.kwad.components.core.webview.tachikoma.C9238b;
import com.kwad.components.core.webview.tachikoma.C9265c;
import com.kwad.components.core.webview.tachikoma.C9287e;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.p334b.C9240a;
import com.kwad.components.core.webview.tachikoma.p334b.C9242c;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9289a;
import com.kwad.components.p208ad.reward.C7838a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.model.C8027b;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.p250c.C7864b;
import com.kwad.components.p208ad.reward.p250c.C7869f;
import com.kwad.components.p208ad.reward.p250c.InterfaceC7866d;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7881b;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7890j;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7894n;
import com.kwad.components.p208ad.reward.p258k.C7984l;
import com.kwad.components.p208ad.reward.p258k.InterfaceC7958a;
import com.kwad.components.p208ad.reward.p258k.p259a.C7964d;
import com.kwad.components.p208ad.reward.page.BackPressHandleResult;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.p392d.C10274a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p434g.InterfaceC10761a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.presenter.f.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8180f extends AbstractC8149a implements InterfaceC7890j, C8665a.InterfaceC8672a {

    /* renamed from: lh */
    private C9287e f27104lh;

    /* renamed from: tn */
    private List<C8674c> f27106tn;

    /* renamed from: wg */
    protected FrameLayout f27107wg;

    /* renamed from: wh */
    private boolean f27108wh = false;

    /* renamed from: oV */
    private final InterfaceC9289a f27105oV = new InterfaceC9289a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9289a
        /* renamed from: ja */
        public final void mo29102ja() {
            if (C8180f.this.f27104lh != null) {
                C9240a c9240a = new C9240a();
                c9240a.aae = C8180f.this.f26957qo.f26523fP ? 1 : 0;
                C8180f.this.f27104lh.m29103b(c9240a);
            }
        }
    };

    /* renamed from: V */
    private void m31334V(boolean z) {
        C10331c.m26254d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.f27107wg;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(z ? 0 : 8);
    }

    /* renamed from: dB */
    private C9265c m31327dB() {
        return new C9265c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
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

    /* renamed from: dC */
    private C9287e m31326dC() {
        return new C9287e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.C9287e, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
            /* renamed from: a */
            public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
                super.mo25241a(str, interfaceC10627c);
                C9240a c9240a = new C9240a();
                c9240a.aae = C8180f.this.f26957qo.f26523fP ? 1 : 0;
                interfaceC10627c.mo25251a(c9240a);
            }
        };
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        if (!this.f27108wh) {
            m31334V(true);
        }
        C7907g c7907g = this.f26957qo;
        c7907g.f26545oZ = true ^ this.f27108wh;
        c7907g.m32042a((C8665a.InterfaceC8672a) this);
        C7838a.m32198eX().m32205a(this);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bY */
    public final void mo31048bY() {
        FrameLayout frameLayout;
        if (this.f27108wh || (frameLayout = this.f27107wg) == null) {
            return;
        }
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: bZ */
    public final void mo31047bZ() {
    }

    @IdRes
    /* renamed from: ci */
    protected int mo31329ci() {
        return C9659R.C9662id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    public FrameLayout getTKContainer() {
        return this.f27107wg;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    public String getTkTemplateId() {
        return C10484b.m25697dm(this.f26957qo.mAdTemplate);
    }

    /* renamed from: gn */
    public final BackPressHandleResult m31323gn() {
        C7964d c7964d = this.f27071wk;
        if (c7964d == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return c7964d.m31915gn();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27107wg = (FrameLayout) findViewById(mo31329ci());
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    public final void onRequestResult(int i) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f26957qo.m32026b((C8665a.InterfaceC8672a) this);
        C7838a.m32198eX().m32203b(this);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28982a(@Nullable C10640a c10640a) {
        if (c10640a != null && !C10487e.m25651b(this.f26957qo.mAdResultData.getProceedTemplateList(), c10640a.creativeId, c10640a.adStyle)) {
            if (c10640a.adTemplate != null && !c10640a.aEO) {
                this.f26957qo.f26528oI.mo32088bJ();
                return;
            }
            C8674c m32039a = C7907g.m32039a(this.f27106tn, c10640a.creativeId);
            if (m32039a != null) {
                this.f26957qo.m32041a(m32039a);
                return;
            }
            return;
        }
        this.f26957qo.f26528oI.mo32088bJ();
    }

    @Override // com.kwad.components.core.p298i.C8665a.InterfaceC8672a
    /* renamed from: e */
    public final void mo30038e(@Nullable List<C8674c> list) {
        if (list == null || list.size() == 0 || this.f27071wk == null) {
            return;
        }
        this.f27106tn = list;
        List<AdTemplate> m31332a = m31332a(list, this.f26957qo.mAdTemplate);
        C10605b m29018sD = this.f27071wk.m29018sD();
        if (m29018sD != null) {
            m29018sD.setAdTemplateList(m31332a);
        }
        C7984l m31912jo = this.f27071wk.m31912jo();
        if (m31912jo != null) {
            m31912jo.m31906g(m31332a);
        } else {
            this.f27071wk.m31914h(m31332a);
        }
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28989a(TKRenderFailReason tKRenderFailReason) {
        super.mo28989a(tKRenderFailReason);
        C8031b.m31783a(this.mAdTemplate, tKRenderFailReason);
        C10331c.m26254d("TkRewardPagePresenter", "onTkLoadFailed");
        this.f27108wh = true;
        this.f26957qo.f26545oZ = false;
        m31334V(false);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractC8149a, com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28983a(InterfaceC9876q interfaceC9876q, C10605b c10605b) {
        super.mo28983a(interfaceC9876q, c10605b);
        interfaceC9876q.mo27480c(new C7869f(new InterfaceC7866d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.p208ad.reward.p250c.InterfaceC7866d
            /* renamed from: a */
            public final void mo31322a(C7864b c7864b) {
                C10331c.m26254d("TkRewardPagePresenter", "onUpdateExtraReward : " + c7864b.m32129gO());
                C8180f.this.m31388a(c7864b);
            }
        }));
        this.f27104lh = m31326dC();
        this.f26957qo.m32040a(this.f27105oV);
        interfaceC9876q.mo27480c(this.f27104lh);
        interfaceC9876q.mo27480c(new C9238b(new C9238b.InterfaceC9239a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.C9238b.InterfaceC9239a
            /* renamed from: dL */
            public final void mo29166dL() {
                C8027b.m31799J(C8180f.this.f26957qo.mContext);
            }
        }));
        interfaceC9876q.mo27480c(m31327dB());
        interfaceC9876q.mo27480c(new C9151h(new InterfaceC9165n() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.InterfaceC9165n
            /* renamed from: a */
            public final void mo29222a(C9151h c9151h, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    c9151h.m29233aT(C7907g.m31991g(C10487e.m25641dQ(C8180f.this.f26957qo.mAdTemplate)) && C10274a.m26474DG() && C8180f.this.f26957qo.mScreenOrientation == 0);
                }
            }
        }));
    }

    /* renamed from: a */
    private static List<AdTemplate> m31332a(List<C8674c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(C8674c.m30037m(list));
        return arrayList;
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7890j
    /* renamed from: a */
    public final void mo31050a(PlayableSource playableSource, @Nullable InterfaceC7894n interfaceC7894n) {
        FrameLayout frameLayout;
        if (this.f27108wh || (frameLayout = this.f27107wg) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28985a(C9259t c9259t) {
        InterfaceC7881b interfaceC7881b;
        C10331c.m26254d("TkRewardPagePresenter", "onSkipClick: " + c9259t.f29318VU);
        C7907g c7907g = this.f26957qo;
        if (c7907g != null && (interfaceC7881b = c7907g.f26528oI) != null) {
            interfaceC7881b.onVideoSkipToEnd(c9259t.f29318VU * 1000);
        }
        C8141f.m31459s(this.f26957qo);
        C7907g.m32038a(this.f26957qo.f26537oR, new InterfaceC10761a<InterfaceC7958a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            /* renamed from: c */
            private static void m31321c(InterfaceC7958a interfaceC7958a) {
                interfaceC7958a.mo31476iL();
            }

            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            public final /* synthetic */ void accept(InterfaceC7958a interfaceC7958a) {
                m31321c(interfaceC7958a);
            }
        });
    }

    @Override // com.kwad.components.p208ad.reward.presenter.p272f.AbstractDialogInterface$OnDismissListenerC8159d, com.kwad.components.core.webview.tachikoma.InterfaceC9339j
    /* renamed from: a */
    public final void mo28984a(WebCloseStatus webCloseStatus) {
        super.mo28984a(webCloseStatus);
    }
}
