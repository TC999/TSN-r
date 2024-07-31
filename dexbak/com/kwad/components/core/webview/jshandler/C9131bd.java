package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.webview.jshandler.bd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9131bd implements InterfaceC10625a {

    /* renamed from: Yg */
    private InterfaceC9133a f29225Yg;

    /* renamed from: com.kwad.components.core.webview.jshandler.bd$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9133a {
        /* renamed from: sh */
        void mo29243sh();
    }

    public C9131bd(InterfaceC9133a interfaceC9133a) {
        this.f29225Yg = interfaceC9133a;
    }

    /* renamed from: sx */
    private void m29244sx() {
        if (AlertDialogC8602b.m30267nr()) {
            return;
        }
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.bd.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C9131bd.this.f29225Yg != null) {
                    C9131bd.this.f29225Yg.mo29243sh();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "showDownloadTips";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        m29244sx();
    }
}
