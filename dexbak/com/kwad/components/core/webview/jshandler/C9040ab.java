package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;

/* renamed from: com.kwad.components.core.webview.jshandler.ab */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9040ab implements InterfaceC10625a {

    /* renamed from: WI */
    private InterfaceC9042a f29091WI;

    /* renamed from: Wf */
    private final C10605b f29092Wf;

    /* renamed from: fS */
    private Handler f29093fS = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.core.webview.jshandler.ab$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9042a {
        /* renamed from: bA */
        void mo29331bA();
    }

    public C9040ab(C10605b c10605b, InterfaceC9042a interfaceC9042a) {
        this.f29092Wf = c10605b;
        this.f29091WI = interfaceC9042a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29093fS.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29093fS.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ab.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9040ab.this.f29091WI.mo29331bA();
            }
        });
        interfaceC10627c.mo25251a(null);
    }
}
