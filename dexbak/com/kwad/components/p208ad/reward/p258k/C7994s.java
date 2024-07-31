package com.kwad.components.p208ad.reward.p258k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.presenter.C8141f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7994s implements InterfaceC10625a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    /* renamed from: xq */
    private C7907g f26700xq;

    @KsJson
    /* renamed from: com.kwad.components.ad.reward.k.s$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7995a extends C10482a {

        /* renamed from: xr */
        public boolean f26701xr;
    }

    public C7994s(Context context, C7907g c7907g) {
        this.mContext = context;
        this.mAdTemplate = c7907g.mAdTemplate;
        this.f26700xq = c7907g;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            C7995a c7995a = new C7995a();
            c7995a.parseJson(jSONObject);
            m31899a(c7995a);
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showLandingPage";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26700xq = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }

    /* renamed from: a */
    private void m31899a(C7995a c7995a) {
        if (c7995a.f26701xr) {
            C8141f.m31462p(this.f26700xq);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }
}
