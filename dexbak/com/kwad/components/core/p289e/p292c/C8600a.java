package com.kwad.components.core.p289e.p292c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.widget.KSFrameLayout;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.kwad.components.core.e.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8600a extends KSFrameLayout {

    /* renamed from: Ke */
    private final AlertDialogC8602b f28175Ke;

    /* renamed from: Kf */
    private final AlertDialogC8602b.C8605b f28176Kf;

    /* renamed from: Kg */
    private C8607d f28177Kg;

    /* renamed from: Kh */
    private InterfaceC8601a f28178Kh;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.e.c.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8601a {
        /* renamed from: nq */
        void mo30265nq();
    }

    public C8600a(Context context, AlertDialogC8602b alertDialogC8602b, AlertDialogC8602b.C8605b c8605b) {
        super(context);
        this.mContext = context;
        this.f28175Ke = alertDialogC8602b;
        this.f28176Kf = c8605b;
        this.mAdTemplate = c8605b.adTemplate;
        C10887l.inflate(context, C9659R.C9663layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        m30272a(adBaseFrameLayout, "rootView is null");
        m30272a((KsAdWebView) adBaseFrameLayout.findViewById(C9659R.C9662id.ksad_download_tips_web_card_webView), "webView is null");
    }

    /* renamed from: a */
    private void m30272a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + C8600a.class.getClassLoader().getClass().getName());
    }

    /* renamed from: af */
    private static Presenter m30271af() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new View$OnClickListenerC8608e());
        return presenter;
    }

    /* renamed from: np */
    private C8607d m30270np() {
        C8607d c8607d = new C8607d();
        c8607d.f28189Ke = this.f28175Ke;
        c8607d.f28190Kf = this.f28176Kf;
        AdTemplate adTemplate = this.mAdTemplate;
        c8607d.mAdTemplate = adTemplate;
        c8607d.mRootContainer = this.mRootContainer;
        if (C10483a.m25956aF(C10487e.m25641dQ(adTemplate))) {
            c8607d.mApkDownloadHelper = new C8619c(this.mAdTemplate);
        }
        return c8607d;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ac */
    public final void mo23565ac() {
        super.mo23565ac();
        this.f28177Kg = m30270np();
        Presenter m30271af = m30271af();
        this.mPresenter = m30271af;
        m30271af.m24616G(this.mRootContainer);
        this.mPresenter.m24605k(this.f28177Kg);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        C8607d c8607d = this.f28177Kg;
        if (c8607d != null) {
            c8607d.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC8601a interfaceC8601a = this.f28178Kh;
        if (interfaceC8601a != null) {
            interfaceC8601a.mo30265nq();
        }
    }

    public final void setChangeListener(InterfaceC8601a interfaceC8601a) {
        this.f28178Kh = interfaceC8601a;
    }
}
