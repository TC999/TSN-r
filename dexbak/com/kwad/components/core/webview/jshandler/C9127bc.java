package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.bc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9127bc implements InterfaceC10625a {
    @Nullable

    /* renamed from: WB */
    private InterfaceC10627c f29221WB;

    /* renamed from: Yd */
    private InterfaceC9130b f29222Yd;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.bc$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9129a extends C10482a implements InterfaceC9914b {
        public int visibility;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.bc$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9130b {
        @MainThread
        /* renamed from: a */
        void mo29246a(C9129a c9129a);
    }

    public C9127bc(InterfaceC9130b interfaceC9130b) {
        this.f29222Yd = interfaceC9130b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29247b(C9129a c9129a) {
        InterfaceC9130b interfaceC9130b = this.f29222Yd;
        if (interfaceC9130b != null) {
            interfaceC9130b.mo29246a(c9129a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29222Yd = null;
        this.f29221WB = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29221WB = interfaceC10627c;
        final C9129a c9129a = new C9129a();
        try {
            c9129a.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9127bc.this.m29247b(c9129a);
                if (C9127bc.this.f29221WB != null) {
                    C9127bc.this.f29221WB.mo25251a(null);
                }
            }
        });
    }
}
