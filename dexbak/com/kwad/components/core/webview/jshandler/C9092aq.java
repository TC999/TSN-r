package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.aq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9092aq implements InterfaceC10625a {

    /* renamed from: WA */
    private Handler f29181WA = new Handler(Looper.getMainLooper());

    /* renamed from: WB */
    private InterfaceC10627c f29182WB;

    /* renamed from: cU */
    private InterfaceC9095b f29183cU;
    private String mUrl;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.aq$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9094a extends C10482a {
        public String errorMsg;
        public int status;

        public final boolean isSuccess() {
            return this.status == 1;
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.aq$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9095b {
        @MainThread
        /* renamed from: a */
        void mo28994a(C9094a c9094a);
    }

    @Deprecated
    public C9092aq(InterfaceC9095b interfaceC9095b) {
        this.f29183cU = interfaceC9095b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29281b(C9094a c9094a) {
        InterfaceC9095b interfaceC9095b = this.f29183cU;
        if (interfaceC9095b != null) {
            interfaceC9095b.mo28994a(c9094a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29183cU = null;
        this.f29182WB = null;
        this.f29181WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29182WB = interfaceC10627c;
        try {
            final C9094a c9094a = new C9094a();
            c9094a.parseJson(new JSONObject(str));
            this.f29181WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.aq.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C9092aq.this.m29281b(c9094a);
                    if (C9092aq.this.f29182WB != null) {
                        C9092aq.this.f29182WB.mo25251a(null);
                    }
                }
            });
        } catch (JSONException e) {
            C10331c.m26250e("WebCardPageStatusHandler", "handleJsCall error: " + e);
            C10621b.m25259ag(this.mUrl, e.getMessage());
            interfaceC10627c.onError(-1, e.getMessage());
        }
    }

    public C9092aq(InterfaceC9095b interfaceC9095b, String str) {
        this.f29183cU = interfaceC9095b;
        this.mUrl = str;
    }
}
