package com.iab.omid.library.mmadbridge.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.d;
import com.iab.omid.library.mmadbridge.adsession.g;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.b.e;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c extends com.iab.omid.library.mmadbridge.publisher.a {

    /* renamed from: f  reason: collision with root package name */
    private WebView f37758f;

    /* renamed from: g  reason: collision with root package name */
    private Long f37759g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, g> f37760h;

    /* renamed from: i  reason: collision with root package name */
    private final String f37761i;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WebView f37762a;

        a() {
            this.f37762a = c.this.f37758f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37762a.destroy();
        }
    }

    public c(Map<String, g> map, String str) {
        this.f37760h = map;
        this.f37761i = str;
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.a
    public void a() {
        super.a();
        z();
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.a
    public void g(h hVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, g> g4 = dVar.g();
        for (String str : g4.keySet()) {
            com.iab.omid.library.mmadbridge.d.b.h(jSONObject, str, g4.get(str));
        }
        h(hVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.a
    public void o() {
        super.o();
        new Handler().postDelayed(new a(), Math.max(4000 - (this.f37759g == null ? 4000L : TimeUnit.MILLISECONDS.convert(com.iab.omid.library.mmadbridge.d.d.a() - this.f37759g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f37758f = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void z() {
        WebView webView = new WebView(com.iab.omid.library.mmadbridge.b.d.a().c());
        this.f37758f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        c(this.f37758f);
        e.a().l(this.f37758f, this.f37761i);
        for (String str : this.f37760h.keySet()) {
            e.a().e(this.f37758f, this.f37760h.get(str).c().toExternalForm(), str);
        }
        this.f37759g = Long.valueOf(com.iab.omid.library.mmadbridge.d.d.a());
    }
}
