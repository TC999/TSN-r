package com.kwad.components.p208ad.reward.p250c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.c.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7869f implements InterfaceC10625a {

    /* renamed from: qg */
    private InterfaceC7866d f26488qg;

    public C7869f(InterfaceC7866d interfaceC7866d) {
        this.f26488qg = interfaceC7866d;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26488qg = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            final C7864b c7864b = new C7864b();
            c7864b.parseJson(new JSONObject(str));
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C7869f.this.f26488qg != null) {
                        C7869f.this.f26488qg.mo31322a(c7864b);
                    }
                }
            });
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
    }
}
