package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.C8791a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.core.webview.jshandler.bf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9138bf implements InterfaceC10625a {

    /* renamed from: Yp */
    private InterfaceC9139a f29234Yp;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    /* renamed from: com.kwad.components.core.webview.jshandler.bf$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9139a {
        /* renamed from: dK */
        boolean mo29239dK();
    }

    public C9138bf(Context context, AdTemplate adTemplate) {
        this.mContext = C10887l.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    /* renamed from: a */
    public final void m29240a(InterfaceC9139a interfaceC9139a) {
        this.f29234Yp = interfaceC9139a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        InterfaceC9139a interfaceC9139a = this.f29234Yp;
        boolean mo29239dK = interfaceC9139a != null ? interfaceC9139a.mo29239dK() : true;
        C10331c.m26254d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + mo29239dK);
        if (mo29239dK) {
            C8791a.launch(this.mContext, this.mAdTemplate);
        }
    }
}
