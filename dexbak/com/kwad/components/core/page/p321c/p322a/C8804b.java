package com.kwad.components.core.page.p321c.p322a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.p319a.InterfaceC8792a;
import com.kwad.components.core.page.p321c.p322a.C8814f;
import com.kwad.components.core.webview.jshandler.C9102at;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.mvp.AbstractC10868a;

/* renamed from: com.kwad.components.core.page.c.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8804b extends AbstractC10868a {
    @Nullable

    /* renamed from: OI */
    public InterfaceC8792a f28549OI;
    @Nullable

    /* renamed from: OJ */
    public KsAdWebView.InterfaceC10598c f28550OJ;
    @Nullable

    /* renamed from: OL */
    public C8814f.InterfaceC8817a f28551OL;
    @Nullable

    /* renamed from: OM */
    public C9102at.InterfaceC9104b f28552OM;

    /* renamed from: ON */
    public boolean f28553ON = false;

    /* renamed from: OO */
    public boolean f28554OO = false;
    @NonNull

    /* renamed from: Os */
    public AdWebViewActivityProxy.C8777a f28555Os;
    @NonNull

    /* renamed from: gS */
    public ViewGroup f28556gS;
    @NonNull
    public AdTemplate mAdTemplate;
    @NonNull
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    @NonNull
    public Context mContext;
    @Nullable
    public String mPageTitle;
    @NonNull
    public String mPageUrl;
    public boolean mShowPermission;
    @Nullable
    public InterfaceC10636b mWebCardCloseListener;

    /* renamed from: aG */
    private void m29828aG(boolean z) {
        this.f28554OO = true;
    }

    /* renamed from: a */
    public final void m29829a(KsAdWebView.InterfaceC10598c interfaceC10598c) {
        this.f28550OJ = interfaceC10598c;
    }

    /* renamed from: pi */
    public final boolean m29827pi() {
        return this.mShowPermission;
    }

    /* renamed from: pn */
    public final void m29826pn() {
        C9102at.InterfaceC9104b interfaceC9104b = this.f28552OM;
        if (interfaceC9104b != null) {
            interfaceC9104b.mo29273pF();
        }
    }

    /* renamed from: pt */
    public final boolean m29825pt() {
        return this.f28554OO;
    }

    /* renamed from: pu */
    public final boolean m29824pu() {
        return !m29827pi();
    }

    @Override // com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        this.f28550OJ = null;
        this.f28551OL = null;
        this.mWebCardCloseListener = null;
        this.f28552OM = null;
    }

    public final void setWebCardCloseListener(@Nullable InterfaceC10636b interfaceC10636b) {
        this.mWebCardCloseListener = interfaceC10636b;
    }

    /* renamed from: a */
    public final void m29831a(C8814f.InterfaceC8817a interfaceC8817a) {
        this.f28551OL = interfaceC8817a;
    }

    /* renamed from: a */
    public final void m29830a(C9102at.InterfaceC9104b interfaceC9104b) {
        this.f28552OM = interfaceC9104b;
        m29828aG(true);
    }
}
