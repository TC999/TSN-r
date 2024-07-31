package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.y */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9189y implements InterfaceC10625a {

    /* renamed from: WA */
    private Handler f29284WA = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: WB */
    private InterfaceC10627c f29285WB;
    private InterfaceC10636b mWebCardCloseListener;

    public C9189y(InterfaceC10636b interfaceC10636b) {
        this.mWebCardCloseListener = interfaceC10636b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m29192c(WebCloseStatus webCloseStatus) {
        InterfaceC10636b interfaceC10636b = this.mWebCardCloseListener;
        if (interfaceC10636b != null) {
            interfaceC10636b.mo25244b(webCloseStatus);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "close";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.mWebCardCloseListener = null;
        this.f29285WB = null;
        this.f29284WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29285WB = interfaceC10627c;
        final WebCloseStatus webCloseStatus = new WebCloseStatus();
        try {
            webCloseStatus.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
        }
        this.f29284WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.y.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9189y.this.m29192c(webCloseStatus);
                if (C9189y.this.f29285WB != null) {
                    C9189y.this.f29285WB.mo25251a(null);
                }
            }
        });
    }
}
