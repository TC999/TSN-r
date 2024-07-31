package com.iab.omid.library.mmadbridge.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.mmadbridge.adsession.C7077d;
import com.iab.omid.library.mmadbridge.adsession.C7080g;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.p202b.C7089d;
import com.iab.omid.library.mmadbridge.p202b.C7090e;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7104d;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.mmadbridge.publisher.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7111c extends AbstractC7108a {

    /* renamed from: f */
    private WebView f24276f;

    /* renamed from: g */
    private Long f24277g = null;

    /* renamed from: h */
    private final Map<String, C7080g> f24278h;

    /* renamed from: i */
    private final String f24279i;

    /* renamed from: com.iab.omid.library.mmadbridge.publisher.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class RunnableC7112a implements Runnable {

        /* renamed from: a */
        private final WebView f24280a;

        RunnableC7112a() {
            this.f24280a = C7111c.this.f24276f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f24280a.destroy();
        }
    }

    public C7111c(Map<String, C7080g> map, String str) {
        this.f24278h = map;
        this.f24279i = str;
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AbstractC7108a
    /* renamed from: a */
    public void mo34629a() {
        super.mo34629a();
        m34625z();
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AbstractC7108a
    /* renamed from: g */
    public void mo34628g(C7081h c7081h, C7077d c7077d) {
        JSONObject jSONObject = new JSONObject();
        Map<String, C7080g> m34824g = c7077d.m34824g();
        for (String str : m34824g.keySet()) {
            C7101b.m34688h(jSONObject, str, m34824g.get(str));
        }
        m34645h(c7081h, c7077d, jSONObject);
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AbstractC7108a
    /* renamed from: o */
    public void mo34627o() {
        super.mo34627o();
        new Handler().postDelayed(new RunnableC7112a(), Math.max(DanmakuFactory.f43786r - (this.f24277g == null ? 4000L : TimeUnit.MILLISECONDS.convert(C7104d.m34675a() - this.f24277g.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f24276f = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: z */
    void m34625z() {
        WebView webView = new WebView(C7089d.m34738a().m34736c());
        this.f24276f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        m34649c(this.f24276f);
        C7090e.m34735a().m34724l(this.f24276f, this.f24279i);
        for (String str : this.f24278h.keySet()) {
            C7090e.m34735a().m34731e(this.f24276f, this.f24278h.get(str).m34813c().toExternalForm(), str);
        }
        this.f24277g = Long.valueOf(C7104d.m34675a());
    }
}
