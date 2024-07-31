package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.az */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9119az implements InterfaceC10625a {
    @Nullable

    /* renamed from: VG */
    private KsAppDownloadListener f29211VG;
    @Nullable

    /* renamed from: VX */
    private InterfaceC10627c f29212VX;
    @Nullable

    /* renamed from: XY */
    private KsAppDownloadListener f29213XY;

    /* renamed from: cO */
    private final C10605b f29214cO;
    private final C8619c mApkDownloadHelper;

    /* renamed from: com.kwad.components.core.webview.jshandler.az$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9121a implements InterfaceC9914b {

        /* renamed from: Ya */
        public float f29216Ya;
        public long creativeId;
        public int status;
        public long totalBytes;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, this.f29216Ya);
            C11126t.putValue(jSONObject, "status", this.status);
            C11126t.putValue(jSONObject, "totalBytes", this.totalBytes);
            C11126t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public C9119az(C10605b c10605b, @Nullable C8619c c8619c) {
        this.f29214cO = c10605b;
        this.mApkDownloadHelper = c8619c;
    }

    /* renamed from: sm */
    private KsAppDownloadListener m29252sm() {
        return new AbstractC10298a() { // from class: com.kwad.components.core.webview.jshandler.az.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                C9119az.this.m29255a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                C9119az.this.m29255a(5, 1.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                C9119az.this.m29255a(1, 0.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                C9119az.this.m29255a(6, 1.0f);
                if (C9119az.this.f29213XY != null) {
                    C9119az.this.f29213XY.onInstalled();
                }
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                C9119az.this.m29255a(3, (i * 1.0f) / 100.0f);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                C9119az.this.m29255a(2, (i * 1.0f) / 100.0f);
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        KsAppDownloadListener ksAppDownloadListener;
        this.f29212VX = null;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c == null || (ksAppDownloadListener = this.f29211VG) == null) {
            return;
        }
        c8619c.m30148c(ksAppDownloadListener);
        this.f29211VG = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29214cO.m25325GN()) {
            interfaceC10627c.onError(-1, "native photo is null");
            return;
        }
        this.f29212VX = interfaceC10627c;
        C8619c c8619c = this.mApkDownloadHelper;
        if (c8619c != null) {
            KsAppDownloadListener ksAppDownloadListener = this.f29211VG;
            if (ksAppDownloadListener == null) {
                KsAppDownloadListener m29252sm = m29252sm();
                this.f29211VG = m29252sm;
                this.mApkDownloadHelper.m30151b(m29252sm);
                return;
            }
            c8619c.m30146d(ksAppDownloadListener);
        }
    }

    public C9119az(C10605b c10605b, @Nullable C8619c c8619c, @Nullable KsAppDownloadListener ksAppDownloadListener) {
        this.f29214cO = c10605b;
        this.mApkDownloadHelper = c8619c;
        this.f29213XY = ksAppDownloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29255a(int i, float f) {
        if (this.f29212VX != null) {
            C9121a c9121a = new C9121a();
            c9121a.f29216Ya = f;
            c9121a.status = i;
            c9121a.totalBytes = C10487e.m25641dQ(this.f29214cO.getAdTemplate()).totalBytes;
            this.f29212VX.mo25251a(c9121a);
        }
    }
}
