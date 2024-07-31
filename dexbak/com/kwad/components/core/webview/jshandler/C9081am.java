package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.am */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9081am implements InterfaceC10625a {
    private List<C9084c> mHolders = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.jshandler.am$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9082a extends AbstractC10298a {

        /* renamed from: XE */
        private C9084c f29172XE;

        public C9082a(C9084c c9084c) {
            this.f29172XE = c9084c;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            C9081am.m29294a(this.f29172XE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            C9081am.m29294a(this.f29172XE, 5, 1.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            C9081am.m29294a(this.f29172XE, 1, 0.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            C9081am.m29294a(this.f29172XE, 6, 1.0f);
        }

        @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
        public final void onPaused(int i) {
            C9081am.m29294a(this.f29172XE, 3, (i * 1.0f) / 100.0f);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            C9081am.m29294a(this.f29172XE, 2, (i * 1.0f) / 100.0f);
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.am$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9083b extends C10482a {
        public long creativeId = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.jshandler.am$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9084c {

        /* renamed from: XF */
        private C8619c f29173XF;

        /* renamed from: XG */
        private C9082a f29174XG;
        private AdTemplate mAdTemplate;

        /* renamed from: ns */
        private InterfaceC10627c f29175ns;

        public C9084c(C8619c c8619c, AdTemplate adTemplate) {
            this.f29173XF = c8619c;
            this.mAdTemplate = adTemplate;
        }

        public final void destroy() {
            C9082a c9082a;
            C8619c c8619c = this.f29173XF;
            if (c8619c == null || (c9082a = this.f29174XG) == null) {
                return;
            }
            c8619c.m30148c(c9082a);
        }

        public final long getCreativeId() {
            AdTemplate adTemplate = this.mAdTemplate;
            if (adTemplate == null) {
                return -1L;
            }
            return C10487e.m25631ea(adTemplate);
        }

        /* renamed from: a */
        public final void m29292a(C9082a c9082a) {
            this.f29173XF.m30151b(c9082a);
            this.f29174XG = c9082a;
        }
    }

    public C9081am(List<AdTemplate> list, List<C8619c> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mHolders.add(new C9084c(list2.get(i), list.get(i)));
        }
    }

    /* renamed from: K */
    private C9084c m29295K(long j) {
        if (j == -1) {
            return null;
        }
        for (C9084c c9084c : this.mHolders) {
            if (c9084c.getCreativeId() == j) {
                return c9084c;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C9083b c9083b = new C9083b();
                c9083b.parseJson(jSONObject);
                C9084c m29295K = m29295K(c9083b.creativeId);
                if (m29295K != null) {
                    m29295K.f29175ns = interfaceC10627c;
                    m29295K.m29292a(new C9082a(m29295K));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerMultiProgressListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        for (C9084c c9084c : this.mHolders) {
            c9084c.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m29294a(C9084c c9084c, int i, float f) {
        if (c9084c == null || c9084c.f29175ns == null) {
            return;
        }
        C10331c.m26254d("MultiProgressListener", "notifyDownloadProgress: " + c9084c.f29175ns + f);
        InterfaceC10627c interfaceC10627c = c9084c.f29175ns;
        C9119az.C9121a c9121a = new C9119az.C9121a();
        c9121a.f29216Ya = f;
        c9121a.status = i;
        c9121a.creativeId = c9084c.getCreativeId();
        c9121a.totalBytes = C10487e.m25641dQ(c9084c.mAdTemplate).totalBytes;
        interfaceC10627c.mo25251a(c9121a);
    }
}
