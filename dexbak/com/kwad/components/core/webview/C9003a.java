package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.webview.jshandler.C9191z;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p418b.p421c.C10621b;
import com.kwad.sdk.core.webview.p422c.C10626b;
import com.kwad.sdk.core.webview.p422c.C10628d;
import com.kwad.sdk.core.webview.p422c.C10629e;
import com.kwad.sdk.core.webview.p422c.C10630f;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.C10633a;
import com.kwad.sdk.core.webview.p423d.C10637b;
import com.kwad.sdk.utils.C11071bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9003a {

    /* renamed from: NY */
    private WebView f29014NY;

    /* renamed from: Vt */
    private final Map<String, InterfaceC10625a> f29015Vt = new ConcurrentHashMap(32);

    /* renamed from: Vu */
    private InterfaceC10625a f29016Vu = new C10628d();

    /* renamed from: Vv */
    private boolean f29017Vv;

    public C9003a(WebView webView) {
        this.f29014NY = webView;
        m29400sa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m29401n(String str, String str2) {
        if (this.f29017Vv) {
            C10331c.m26254d("KSAdJSBridge", "callJS after destroy jsInterface, " + str2);
        } else if (TextUtils.isEmpty(str)) {
            C10331c.m26254d("KSAdJSBridge", "callJS callback is empty");
        } else {
            C10331c.m26254d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
            WebView webView = this.f29014NY;
            if (webView == null) {
                return;
            }
            C11071bt.m23845a(webView, str, str2);
        }
    }

    /* renamed from: sa */
    private void m29400sa() {
        m29403a(new C10633a());
        m29403a(new C10637b());
        m29403a(new C9191z());
    }

    /* renamed from: b */
    public final void m29402b(InterfaceC10625a interfaceC10625a) {
        if (!TextUtils.isEmpty(interfaceC10625a.getKey())) {
            this.f29015Vt.put(interfaceC10625a.getKey(), interfaceC10625a);
        } else {
            C10331c.m26250e("KSAdJSBridge", "handler and handler'key cannot be null");
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        InterfaceC10627c interfaceC10627c;
        C10331c.m26254d("KSAdJSBridge", "callAdBridge ==" + str);
        try {
            final C10626b c10626b = new C10626b();
            c10626b.parseJson(new JSONObject(str));
            InterfaceC10625a interfaceC10625a = this.f29015Vt.get(c10626b.aEC);
            if (interfaceC10625a == null) {
                interfaceC10625a = this.f29016Vu;
            }
            WebView webView = this.f29014NY;
            if (webView != null && (webView instanceof KsAdWebView)) {
                KsAdWebView ksAdWebView = (KsAdWebView) webView;
                C10621b.m25262a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), c10626b.aEC, c10626b.data);
            }
            if (interfaceC10625a != null) {
                if (!TextUtils.isEmpty(c10626b.aED)) {
                    interfaceC10627c = new InterfaceC10627c() { // from class: com.kwad.components.core.webview.a.1
                        @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
                        /* renamed from: a */
                        public final void mo25251a(InterfaceC9914b interfaceC9914b) {
                            C9003a.this.m29401n(c10626b.aED, new C10630f(interfaceC9914b).toJson().toString());
                        }

                        @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
                        public final void onError(int i, String str2) {
                            C9003a.this.m29401n(c10626b.aED, new C10629e(i, str2).toJson().toString());
                        }
                    };
                } else {
                    interfaceC10627c = new InterfaceC10627c() { // from class: com.kwad.components.core.webview.a.2
                        @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
                        /* renamed from: a */
                        public final void mo25251a(InterfaceC9914b interfaceC9914b) {
                        }

                        @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
                        public final void onError(int i, String str2) {
                        }
                    };
                }
                interfaceC10625a.mo25241a(c10626b.data, interfaceC10627c);
                return;
            }
            C10331c.m26250e("KSAdJSBridge", "bridgeHandler is null");
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            C10331c.m26250e("KSAdJSBridge", "callAdBridge JSONException:" + e);
        }
    }

    public final void destroy() {
        C10331c.m26248i("KSAdJSBridge", "destroy jsInterface");
        for (Map.Entry<String, InterfaceC10625a> entry : this.f29015Vt.entrySet()) {
            InterfaceC10625a value = entry.getValue();
            if (value != null) {
                value.onDestroy();
            }
        }
        this.f29017Vv = true;
    }

    /* renamed from: a */
    public final void m29403a(InterfaceC10625a interfaceC10625a) {
        if (interfaceC10625a != null && !TextUtils.isEmpty(interfaceC10625a.getKey())) {
            if (this.f29015Vt.containsKey(interfaceC10625a.getKey())) {
                C10331c.m26250e("KSAdJSBridge", "cannot register handler again, handler: " + interfaceC10625a.getKey());
            }
            this.f29015Vt.put(interfaceC10625a.getKey(), interfaceC10625a);
            return;
        }
        C10331c.m26250e("KSAdJSBridge", "handler and handler'key cannot be null");
    }
}
