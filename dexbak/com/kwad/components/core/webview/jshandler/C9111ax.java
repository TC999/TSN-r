package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.core.webview.jshandler.ax */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9111ax implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29203VX;

    /* renamed from: WA */
    private final Handler f29204WA = new Handler(Looper.getMainLooper());

    /* renamed from: XT */
    private final InterfaceC9115c f29205XT;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ax$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9113a extends C10482a implements InterfaceC9914b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ax$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9114b {

        /* renamed from: XV */
        WeakReference<InterfaceC10627c> f29207XV;

        public C9114b(InterfaceC10627c interfaceC10627c) {
            this.f29207XV = new WeakReference<>(interfaceC10627c);
        }

        /* renamed from: a */
        public final void m29259a(C9113a c9113a) {
            InterfaceC10627c interfaceC10627c = this.f29207XV.get();
            if (interfaceC10627c != null) {
                interfaceC10627c.mo25251a(c9113a);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ax$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9115c {
        /* renamed from: a */
        void mo29258a(C9114b c9114b);
    }

    public C9111ax(InterfaceC9115c interfaceC9115c) {
        this.f29205XT = interfaceC9115c;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29203VX = null;
        this.f29204WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29203VX = interfaceC10627c;
        this.f29204WA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9111ax.this.f29205XT.mo29258a(new C9114b(C9111ax.this.f29203VX));
            }
        });
    }
}
