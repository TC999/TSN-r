package com.kwad.components.core.page;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.p301l.AbstractC8692c;
import com.kwad.components.core.p326q.C8898a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.p319a.InterfaceC8792a;
import com.kwad.components.core.page.p321c.p322a.C8804b;
import com.kwad.components.core.page.p321c.p322a.C8805c;
import com.kwad.components.core.page.p321c.p322a.C8808d;
import com.kwad.components.core.page.p321c.p322a.C8811e;
import com.kwad.components.core.page.p321c.p322a.C8814f;
import com.kwad.components.core.page.p321c.p322a.C8818g;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.core.page.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8798c extends AbstractC8692c<C8804b> {

    /* renamed from: Os */
    private AdWebViewActivityProxy.C8777a f28537Os;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private InterfaceC8792a mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private InterfaceC10636b mWebCardCloseListener;

    private C8798c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static C8798c m29840a(Context context, AdWebViewActivityProxy.C8777a c8777a) {
        C8798c c8798c = new C8798c(context);
        c8798c.m29839b(context, c8777a);
        return c8798c;
    }

    /* renamed from: b */
    private void m29839b(Context context, AdWebViewActivityProxy.C8777a c8777a) {
        this.f28537Os = c8777a;
        this.mContext = context;
        this.mAdTemplate = c8777a.getAdTemplate();
        this.mPageUrl = c8777a.m29864pg();
        this.mPageTitle = c8777a.m29865pf();
        this.mShowPermission = c8777a.m29862pi();
        this.mAutoShow = c8777a.m29860pk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.p301l.AbstractC8692c
    /* renamed from: pm */
    public C8804b mo29837kt() {
        C8804b c8804b = new C8804b();
        c8804b.mContext = this.mContext;
        c8804b.mAdTemplate = this.mAdTemplate;
        c8804b.f28555Os = this.f28537Os;
        c8804b.mPageTitle = this.mPageTitle;
        c8804b.mPageUrl = this.mPageUrl;
        c8804b.mAutoShow = this.mAutoShow;
        c8804b.mShowPermission = this.mShowPermission;
        c8804b.f28549OI = this.mLandPageViewListener;
        c8804b.setWebCardCloseListener(this.mWebCardCloseListener);
        c8804b.f28556gS = this.f28361lD;
        return c8804b;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c, com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    public final boolean getCanInterceptBackClick() {
        return ((C8804b) this.mPresenter.m24613Jx()).m29825pt();
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    public final int getLayoutId() {
        return C9659R.C9663layout.ksad_activity_ad_webview;
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    public final void initData() {
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    /* renamed from: kr */
    public final void mo29838kr() {
        this.mAdWebView = (KsAdWebView) findViewById(C9659R.C9662id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.p301l.AbstractC8692c
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.m24612a(new C8814f());
        presenter.m24612a(new C8811e());
        if (C10487e.m25654F(((C8804b) this.f28360Mu).mAdTemplate)) {
            presenter.m24612a(new C8805c());
        }
        if (C10483a.m25947aO(C10487e.m25641dQ(((C8804b) this.f28360Mu).mAdTemplate)) && C8898a.m29651qH().m29645qN() && C8898a.m29651qH().m29650qI() == 1) {
            presenter.m24612a(new C8808d());
        }
        presenter.m24612a(new C8818g());
        return presenter;
    }

    /* renamed from: pn */
    public final void m29835pn() {
        ((C8804b) this.mPresenter.m24613Jx()).m29826pn();
    }

    public final void setLandPageViewListener(InterfaceC8792a interfaceC8792a) {
        this.mLandPageViewListener = interfaceC8792a;
    }

    public final void setWebCardCloseListener(InterfaceC10636b interfaceC10636b) {
        this.mWebCardCloseListener = interfaceC10636b;
        if (this.mAdWebView != null || interfaceC10636b == null) {
            return;
        }
        interfaceC10636b.mo25244b(null);
    }
}
