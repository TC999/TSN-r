package com.kwad.components.core.webview.p332a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11071bt;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9006a {

    /* renamed from: Kz */
    private C8619c f29021Kz;

    /* renamed from: NY */
    private WebView f29022NY;

    /* renamed from: VG */
    private KsAppDownloadListener f29023VG;

    /* renamed from: VH */
    private int f29024VH = -100;

    /* renamed from: VI */
    private int f29025VI = 0;

    /* renamed from: Vv */
    private boolean f29026Vv;

    /* renamed from: cO */
    private C10605b f29027cO;
    private AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9009a extends C10482a {
        public String packageName;
        public String url;
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.a.a$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9010b extends C10482a {
        public int progress;
        public int status;
    }

    public C9006a(WebView webView, C10605b c10605b) {
        this.f29022NY = webView;
        this.mAdTemplate = c10605b.getAdTemplate();
        this.f29027cO = c10605b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aG */
    public void m29397aG(String str) {
        try {
            C9009a c9009a = new C9009a();
            c9009a.parseJson(new JSONObject(str));
            if (m29393p(c9009a.url, c9009a.packageName)) {
                return;
            }
            if (this.f29021Kz == null) {
                m29395o(c9009a.url, c9009a.packageName);
            }
            C8615a.C8616a m30195ar = new C8615a.C8616a(this.f29027cO.f29620NY.getContext()).m30202ao(true).m30200ap(false).m30198aq(this.mAdTemplate).m30195ar(false);
            if (this.f29021Kz.m30127s(m30195ar)) {
                return;
            }
            this.f29021Kz.m30146d(this.f29023VG);
            this.f29021Kz.m30128r(m30195ar);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
    }

    /* renamed from: n */
    private void m29396n(String str, String str2) {
        WebView webView;
        if (this.f29026Vv || TextUtils.isEmpty(str) || (webView = this.f29022NY) == null) {
            return;
        }
        C11071bt.m23845a(webView, str, str2);
    }

    /* renamed from: o */
    private synchronized void m29395o(String str, String str2) {
        this.f29021Kz = new C8619c(this.mAdTemplate, null, str, str2);
        if (this.f29023VG == null) {
            KsAppDownloadListener m29392sm = m29392sm();
            this.f29023VG = m29392sm;
            this.f29021Kz.m30151b(m29392sm);
        }
    }

    /* renamed from: p */
    private static boolean m29393p(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* renamed from: sm */
    private KsAppDownloadListener m29392sm() {
        return new AbstractC10298a() { // from class: com.kwad.components.core.webview.a.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                C9006a.this.m29394p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                C9006a.this.m29394p(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                C9006a.this.m29394p(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                C9006a.this.m29394p(12, 100);
            }

            @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
            public final void onPaused(int i) {
                C9006a.this.m29394p(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    C9006a.this.m29394p(1, 0);
                } else {
                    C9006a.this.m29394p(2, i);
                }
            }
        };
    }

    public final void destroy() {
        this.f29026Vv = true;
        C8619c c8619c = this.f29021Kz;
        if (c8619c != null) {
            c8619c.m30148c(this.f29023VG);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (m29393p(str, str2)) {
            return 0;
        }
        if (this.f29021Kz == null) {
            m29395o(str, str2);
        }
        return this.f29021Kz.m30141nW();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (m29393p(str, str2)) {
            return 0;
        }
        if (this.f29021Kz == null) {
            m29395o(str, str2);
        }
        return this.f29025VI;
    }

    @JavascriptInterface
    @WorkerThread
    public final void handleAdClick(final String str) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.a.a.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9006a.this.m29397aG(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public void m29394p(int i, int i2) {
        this.f29025VI = i2;
        if (this.f29024VH != i) {
            this.f29024VH = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            m29396n("onDownLoadStatusCallback", sb.toString());
        }
    }
}
