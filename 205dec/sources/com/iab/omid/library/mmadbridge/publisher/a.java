package com.iab.omid.library.mmadbridge.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.adsession.ErrorType;
import com.iab.omid.library.mmadbridge.adsession.d;
import com.iab.omid.library.mmadbridge.adsession.g;
import com.iab.omid.library.mmadbridge.adsession.h;
import com.iab.omid.library.mmadbridge.b.e;
import com.stub.StubApp;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private o0.b f37749a;

    /* renamed from: b  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.a f37750b;

    /* renamed from: c  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f37751c;

    /* renamed from: d  reason: collision with root package name */
    private EnumC0548a f37752d;

    /* renamed from: e  reason: collision with root package name */
    private long f37753e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iab.omid.library.mmadbridge.publisher.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum EnumC0548a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public a() {
        x();
        this.f37749a = new o0.b(null);
    }

    public void a() {
    }

    public void b(float f4) {
        e.a().c(v(), f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.f37749a = new o0.b(webView);
    }

    public void d(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.f37750b = aVar;
    }

    public void e(com.iab.omid.library.mmadbridge.adsession.c cVar) {
        e.a().j(v(), cVar.d());
    }

    public void f(ErrorType errorType, String str) {
        e.a().d(v(), errorType, str);
    }

    public void g(h hVar, d dVar) {
        h(hVar, dVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(h hVar, d dVar, JSONObject jSONObject) {
        String e4 = hVar.e();
        JSONObject jSONObject2 = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "environment", "app");
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "adSessionType", dVar.d());
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "deviceInfo", com.iab.omid.library.mmadbridge.d.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject3, "partnerName", dVar.i().b());
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject3, "partnerVersion", dVar.i().c());
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject4, "libraryVersion", "1.3.29-Mmadbridge");
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject4, "appId", StubApp.getOrigApplicationContext(com.iab.omid.library.mmadbridge.b.d.a().c().getApplicationContext()).getPackageName());
        com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "app", jSONObject4);
        if (dVar.e() != null) {
            com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "contentUrl", dVar.e());
        }
        if (dVar.f() != null) {
            com.iab.omid.library.mmadbridge.d.b.h(jSONObject2, "customReferenceData", dVar.f());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (g gVar : dVar.j()) {
            com.iab.omid.library.mmadbridge.d.b.h(jSONObject5, gVar.d(), gVar.e());
        }
        e.a().g(v(), e4, jSONObject2, jSONObject5, jSONObject);
    }

    public void i(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f37751c = aVar;
    }

    public void j(String str) {
        e.a().f(v(), str, null);
    }

    public void k(String str, long j4) {
        if (j4 >= this.f37753e) {
            this.f37752d = EnumC0548a.AD_STATE_VISIBLE;
            e.a().n(v(), str);
        }
    }

    public void l(String str, JSONObject jSONObject) {
        e.a().f(v(), str, jSONObject);
    }

    public void m(@NonNull JSONObject jSONObject) {
        e.a().o(v(), jSONObject);
    }

    public void n(boolean z3) {
        if (s()) {
            e.a().q(v(), z3 ? "foregrounded" : "backgrounded");
        }
    }

    public void o() {
        this.f37749a.clear();
    }

    public void p(String str, long j4) {
        if (j4 >= this.f37753e) {
            EnumC0548a enumC0548a = this.f37752d;
            EnumC0548a enumC0548a2 = EnumC0548a.AD_STATE_NOTVISIBLE;
            if (enumC0548a != enumC0548a2) {
                this.f37752d = enumC0548a2;
                e.a().n(v(), str);
            }
        }
    }

    public com.iab.omid.library.mmadbridge.adsession.a q() {
        return this.f37750b;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a r() {
        return this.f37751c;
    }

    public boolean s() {
        return this.f37749a.get() != null;
    }

    public void t() {
        e.a().b(v());
    }

    public void u() {
        e.a().m(v());
    }

    public WebView v() {
        return this.f37749a.get();
    }

    public void w() {
        e.a().p(v());
    }

    public void x() {
        this.f37753e = com.iab.omid.library.mmadbridge.d.d.a();
        this.f37752d = EnumC0548a.AD_STATE_IDLE;
    }
}
