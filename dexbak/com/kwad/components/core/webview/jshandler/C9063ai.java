package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ai */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9063ai implements InterfaceC10625a {

    /* renamed from: WA */
    private final Handler f29139WA = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: WB */
    private InterfaceC10627c f29140WB;

    /* renamed from: cT */
    private InterfaceC9066b f29141cT;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ai$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9065a extends C10482a {

        /* renamed from: Xn */
        public int f29144Xn = -1;
        public int type;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ai$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9066b {
        @MainThread
        /* renamed from: a */
        void mo29313a(C9065a c9065a);
    }

    public C9063ai(InterfaceC9066b interfaceC9066b) {
        this.f29141cT = interfaceC9066b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29314b(C9065a c9065a) {
        InterfaceC9066b interfaceC9066b = this.f29141cT;
        if (interfaceC9066b != null) {
            interfaceC9066b.mo29313a(c9065a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29141cT = null;
        this.f29140WB = null;
        this.f29139WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            this.f29140WB = interfaceC10627c;
            final C9065a c9065a = new C9065a();
            if (!TextUtils.isEmpty(str)) {
                c9065a.parseJson(new JSONObject(str));
            }
            this.f29139WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ai.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9063ai.this.f29140WB != null) {
                        C9063ai.this.f29140WB.mo25251a(null);
                    }
                    C9063ai.this.m29314b(c9065a);
                }
            });
        } catch (Exception e) {
            this.f29140WB.onError(-1, e.getMessage());
            C10331c.printStackTraceOnly(e);
        }
    }
}
