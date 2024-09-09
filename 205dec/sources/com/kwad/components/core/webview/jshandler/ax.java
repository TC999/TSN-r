package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ax implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;
    private final Handler WA = new Handler(Looper.getMainLooper());
    private final c XT;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> XV;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.XV = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.XV.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface c {
        void a(b bVar);
    }

    public ax(c cVar) {
        this.XT = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLiveListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
        this.WA.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
        this.WA.post(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.ax.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                ax.this.XT.a(new b(ax.this.VX));
            }
        });
    }
}
