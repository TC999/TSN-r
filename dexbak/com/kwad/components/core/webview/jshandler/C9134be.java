package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.be */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9134be implements InterfaceC10625a {

    /* renamed from: Ym */
    private static Handler f29227Ym;

    /* renamed from: Kz */
    private C8619c f29228Kz;

    /* renamed from: Yl */
    private C10605b f29229Yl;

    /* renamed from: Yn */
    private InterfaceC9137b f29230Yn;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.be$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9136a extends C10482a {

        /* renamed from: kl */
        public int f29233kl;
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.be$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9137b {
        @MainThread
        /* renamed from: Q */
        void mo29241Q(int i);
    }

    public C9134be(C10605b c10605b, C8619c c8619c, InterfaceC9137b interfaceC9137b) {
        this.f29229Yl = c10605b;
        this.f29228Kz = c8619c;
        this.f29230Yn = interfaceC9137b;
        if (f29227Ym == null) {
            f29227Ym = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C9136a c9136a = new C9136a();
            c9136a.parseJson(new JSONObject(str));
            final int i = c9136a.f29233kl;
            f29227Ym.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.be.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    if (C9134be.this.f29230Yn != null) {
                        C9134be.this.f29230Yn.mo29241Q(i);
                    }
                }
            });
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }
}
