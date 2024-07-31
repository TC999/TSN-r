package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9157k implements InterfaceC10625a {

    /* renamed from: Kz */
    private C8619c f29247Kz;

    /* renamed from: VG */
    private KsAppDownloadListener f29248VG;
    private AdTemplate mAdTemplate;
    private Context mContext;

    /* renamed from: ns */
    private InterfaceC10627c f29249ns;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.k$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9159a extends C10482a {

        /* renamed from: We */
        public String f29251We;
        public String packageName;
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.k$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9160b extends C10482a {
        public int progress;
        public int status;
    }

    public C9157k(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    /* renamed from: o */
    private synchronized void m29229o(String str, String str2) {
        this.f29247Kz = new C8619c(this.mAdTemplate, null, str, str2);
        if (this.f29248VG == null) {
            KsAppDownloadListener m29226sm = m29226sm();
            this.f29248VG = m29226sm;
            this.f29247Kz.m30151b(m29226sm);
        }
    }

    /* renamed from: p */
    private static boolean m29227p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: sm */
    private KsAppDownloadListener m29226sm() {
        return new AbstractC10298a() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                C9157k.this.m29228p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                C9157k.this.m29228p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                C9157k.this.m29228p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                C9157k.this.m29228p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                C9157k.this.m29228p(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    C9157k.this.m29228p(1, 0);
                } else {
                    C9157k.this.m29228p(2, i);
                }
            }
        };
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "installAppForDownload";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29249ns = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m29228p(int i, int i2) {
        if (this.f29249ns != null) {
            C9160b c9160b = new C9160b();
            c9160b.status = i;
            c9160b.progress = i2;
            this.f29249ns.mo25251a(c9160b);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29249ns = interfaceC10627c;
        C9159a c9159a = new C9159a();
        try {
            c9159a.parseJson(new JSONObject(str));
            if (m29227p(c9159a.f29251We, c9159a.packageName)) {
                interfaceC10627c.onError(-1, "param is empty");
                return;
            }
            if (this.f29247Kz == null) {
                m29229o(c9159a.f29251We, c9159a.packageName);
            }
            C8615a.C8616a m30195ar = new C8615a.C8616a(this.mContext).m30202ao(true).m30200ap(false).m30198aq(this.mAdTemplate).m30195ar(false);
            if (this.f29247Kz.m30127s(m30195ar)) {
                return;
            }
            this.f29247Kz.m30146d(this.f29248VG);
            this.f29247Kz.m30128r(m30195ar);
        } catch (Exception unused) {
            interfaceC10627c.onError(-1, "data parse error");
        }
    }
}
