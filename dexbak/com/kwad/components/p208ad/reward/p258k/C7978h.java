package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.k.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7978h implements InterfaceC10625a {

    /* renamed from: xk */
    private InterfaceC7979a f26690xk;

    /* renamed from: com.kwad.components.ad.reward.k.h$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7979a {
        /* renamed from: R */
        void mo31345R(int i);
    }

    public C7978h(InterfaceC7979a interfaceC7979a) {
        this.f26690xk = interfaceC7979a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f26690xk != null) {
            int i = 0;
            try {
                i = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f26690xk.mo31345R(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26690xk = null;
    }
}
