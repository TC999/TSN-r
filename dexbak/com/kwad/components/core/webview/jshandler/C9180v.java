package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9263x;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9180v implements InterfaceC10625a {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29216a(C9263x c9263x) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        final C9263x c9263x = new C9263x();
        try {
            c9263x.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.v.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (c9263x.m29165sR()) {
                    C9180v.this.mo29216a(c9263x);
                } else if (c9263x.m29163sT()) {
                    C9180v.this.mo29213d(c9263x);
                } else if (c9263x.m29164sS()) {
                    C9180v.this.mo29214c(c9263x);
                } else if (c9263x.isFailed()) {
                    C9180v.this.mo29215b(c9263x);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo29215b(C9263x c9263x) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo29214c(C9263x c9263x) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo29213d(C9263x c9263x) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "updateVideoPlayStatus";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
