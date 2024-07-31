package com.kwad.components.core.page.p321c.p322a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.p286b.C8542b;
import com.kwad.components.core.p286b.View$OnClickListenerC8540a;
import com.kwad.components.core.page.p319a.InterfaceC8792a;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;

/* renamed from: com.kwad.components.core.page.c.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8814f extends AbstractC8803a {

    /* renamed from: Pg */
    private boolean f28580Pg;
    private View$OnClickListenerC8540a mTitleBarHelper;

    /* renamed from: com.kwad.components.core.page.c.a.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8817a {
        /* renamed from: aB */
        void mo29795aB(int i);
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.f28548OH.mPageTitle)) {
            return this.f28548OH.mPageTitle;
        }
        List<AdInfo> list = this.f28548OH.mAdTemplate.adInfoList;
        return (list == null || list.size() <= 0 || this.f28548OH.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : C10483a.m25823cc(C10487e.m25641dQ(this.f28548OH.mAdTemplate));
    }

    /* renamed from: pD */
    private void m29798pD() {
        View$OnClickListenerC8540a view$OnClickListenerC8540a = new View$OnClickListenerC8540a(this.f28548OH.f28556gS);
        this.mTitleBarHelper = view$OnClickListenerC8540a;
        view$OnClickListenerC8540a.m30411a(new C8542b(getTitle()));
        this.mTitleBarHelper.m30410ah(true);
        this.mTitleBarHelper.m30412a(new View$OnClickListenerC8540a.InterfaceC8541a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: u */
            public final void mo29634u(View view) {
                C8814f.this.m29797x(view);
            }

            @Override // com.kwad.components.core.p286b.View$OnClickListenerC8540a.InterfaceC8541a
            /* renamed from: v */
            public final void mo29633v(View view) {
                C8814f.this.m29796y(view);
            }
        });
        ViewGroup m30409gF = this.mTitleBarHelper.m30409gF();
        AdTemplate adTemplate = this.f28548OH.mAdTemplate;
        int i = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !C10483a.m25880bZ(adTemplate) && !C10484b.m25706di(C10487e.m25641dQ(this.f28548OH.mAdTemplate))) {
            i = 8;
        }
        m30409gF.setVisibility(i);
        this.f28548OH.m29831a(new InterfaceC8817a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.p321c.p322a.C8814f.InterfaceC8817a
            /* renamed from: aB */
            public final void mo29795aB(int i2) {
                C8814f.this.mTitleBarHelper.m30409gF().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m29797x(View view) {
        KsAdWebView ksAdWebView = this.f28548OH.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.f28548OH.mAdWebView.goBack();
            if (this.f28580Pg) {
                C9908c.m27322bM(this.f28548OH.mAdTemplate);
                return;
            }
            return;
        }
        InterfaceC8792a interfaceC8792a = this.f28548OH.f28549OI;
        if (interfaceC8792a != null) {
            interfaceC8792a.mo29848pd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m29796y(View view) {
        InterfaceC8792a interfaceC8792a = this.f28548OH.f28549OI;
        if (interfaceC8792a != null) {
            interfaceC8792a.mo29847pe();
        }
    }

    @Override // com.kwad.components.core.page.p321c.p322a.AbstractC8803a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C8804b c8804b = this.f28548OH;
        this.f28580Pg = TextUtils.equals(c8804b.mPageUrl, C10483a.m25943aS(C10487e.m25641dQ(c8804b.mAdTemplate)));
        m29798pD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
