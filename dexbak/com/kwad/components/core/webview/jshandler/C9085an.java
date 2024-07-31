package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11012af;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.an */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9085an implements InterfaceC10625a {

    /* renamed from: cO */
    private final C10605b f29176cO;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.an$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9087a extends C10482a {

        /* renamed from: XB */
        public String f29178XB;
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.an$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9088b extends C10482a {

        /* renamed from: XI */
        public double f29179XI;
        public int status;
        public long totalBytes;
    }

    /* renamed from: aL */
    private KsAppDownloadListener m29285aL(String str) {
        return new AbstractC10298a(str) { // from class: com.kwad.components.core.webview.jshandler.an.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(1, 0.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(5, 1.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(1, 0.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(6, 1.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(3, (i * 1.0f) / 100.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (C9085an.this.f29176cO.aDK != null) {
                    C9085an.this.m29288a(2, (i * 1.0f) / 100.0f, C9085an.this.f29176cO.aDK.m24134gB(m26368nX()));
                }
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
        C11012af c11012af = this.f29176cO.aDK;
        if (c11012af != null) {
            c11012af.release();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9087a c9087a = new C9087a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            c9087a.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(c9087a.f29178XB));
        } catch (Exception e) {
            adTemplate = null;
            C10331c.printStackTraceOnly(e);
        }
        if (adTemplate == null || !C10487e.m25649dI(adTemplate) || this.f29176cO.aDK == null) {
            return;
        }
        C8619c c8619c = new C8619c(adTemplate);
        String mo26271nX = c8619c.mo26271nX();
        c8619c.m30151b(m29285aL(mo26271nX));
        this.f29176cO.aDK.m24137a(mo26271nX, c8619c);
        this.f29176cO.aDK.m24136b(mo26271nX, interfaceC10627c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29288a(int i, float f, InterfaceC10627c interfaceC10627c) {
        if (interfaceC10627c != null) {
            C9088b c9088b = new C9088b();
            c9088b.f29179XI = f;
            c9088b.status = i;
            c9088b.totalBytes = C10487e.m25641dQ(this.f29176cO.getAdTemplate()).totalBytes;
            interfaceC10627c.mo25251a(c9088b);
        }
    }
}
