package com.iab.omid.library.mmadbridge.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.adsession.C7074a;
import com.iab.omid.library.mmadbridge.adsession.C7076c;
import com.iab.omid.library.mmadbridge.adsession.C7077d;
import com.iab.omid.library.mmadbridge.adsession.C7080g;
import com.iab.omid.library.mmadbridge.adsession.C7081h;
import com.iab.omid.library.mmadbridge.adsession.ErrorType;
import com.iab.omid.library.mmadbridge.adsession.media.C7082a;
import com.iab.omid.library.mmadbridge.p202b.C7089d;
import com.iab.omid.library.mmadbridge.p202b.C7090e;
import com.iab.omid.library.mmadbridge.p204d.C7100a;
import com.iab.omid.library.mmadbridge.p204d.C7101b;
import com.iab.omid.library.mmadbridge.p204d.C7104d;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import p626o0.C15396b;

/* renamed from: com.iab.omid.library.mmadbridge.publisher.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC7108a {

    /* renamed from: a */
    private C15396b f24267a;

    /* renamed from: b */
    private C7074a f24268b;

    /* renamed from: c */
    private C7082a f24269c;

    /* renamed from: d */
    private EnumC7109a f24270d;

    /* renamed from: e */
    private long f24271e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.iab.omid.library.mmadbridge.publisher.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum EnumC7109a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AbstractC7108a() {
        m34630x();
        this.f24267a = new C15396b(null);
    }

    /* renamed from: a */
    public void mo34629a() {
    }

    /* renamed from: b */
    public void m34650b(float f) {
        C7090e.m34735a().m34733c(m34632v(), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m34649c(WebView webView) {
        this.f24267a = new C15396b(webView);
    }

    /* renamed from: d */
    public void m34648d(C7074a c7074a) {
        this.f24268b = c7074a;
    }

    /* renamed from: e */
    public void m34647e(C7076c c7076c) {
        C7090e.m34735a().m34726j(m34632v(), c7076c.m34831d());
    }

    /* renamed from: f */
    public void m34646f(ErrorType errorType, String str) {
        C7090e.m34735a().m34732d(m34632v(), errorType, str);
    }

    /* renamed from: g */
    public void mo34628g(C7081h c7081h, C7077d c7077d) {
        m34645h(c7081h, c7077d, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m34645h(C7081h c7081h, C7077d c7077d, JSONObject jSONObject) {
        String mo34803e = c7081h.mo34803e();
        JSONObject jSONObject2 = new JSONObject();
        C7101b.m34688h(jSONObject2, "environment", Constants.JumpUrlConstants.SRC_TYPE_APP);
        C7101b.m34688h(jSONObject2, "adSessionType", c7077d.m34827d());
        C7101b.m34688h(jSONObject2, "deviceInfo", C7100a.m34696d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C7101b.m34688h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        C7101b.m34688h(jSONObject3, "partnerName", c7077d.m34822i().m34818b());
        C7101b.m34688h(jSONObject3, "partnerVersion", c7077d.m34822i().m34817c());
        C7101b.m34688h(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        C7101b.m34688h(jSONObject4, "libraryVersion", "1.3.29-Mmadbridge");
        C7101b.m34688h(jSONObject4, "appId", StubApp.getOrigApplicationContext(C7089d.m34738a().m34736c().getApplicationContext()).getPackageName());
        C7101b.m34688h(jSONObject2, Constants.JumpUrlConstants.SRC_TYPE_APP, jSONObject4);
        if (c7077d.m34826e() != null) {
            C7101b.m34688h(jSONObject2, "contentUrl", c7077d.m34826e());
        }
        if (c7077d.m34825f() != null) {
            C7101b.m34688h(jSONObject2, "customReferenceData", c7077d.m34825f());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (C7080g c7080g : c7077d.m34821j()) {
            C7101b.m34688h(jSONObject5, c7080g.m34812d(), c7080g.m34811e());
        }
        C7090e.m34735a().m34729g(m34632v(), mo34803e, jSONObject2, jSONObject5, jSONObject);
    }

    /* renamed from: i */
    public void m34644i(C7082a c7082a) {
        this.f24269c = c7082a;
    }

    /* renamed from: j */
    public void m34643j(String str) {
        C7090e.m34735a().m34730f(m34632v(), str, null);
    }

    /* renamed from: k */
    public void m34642k(String str, long j) {
        if (j >= this.f24271e) {
            this.f24270d = EnumC7109a.AD_STATE_VISIBLE;
            C7090e.m34735a().m34722n(m34632v(), str);
        }
    }

    /* renamed from: l */
    public void m34641l(String str, JSONObject jSONObject) {
        C7090e.m34735a().m34730f(m34632v(), str, jSONObject);
    }

    /* renamed from: m */
    public void m34640m(@NonNull JSONObject jSONObject) {
        C7090e.m34735a().m34721o(m34632v(), jSONObject);
    }

    /* renamed from: n */
    public void m34639n(boolean z) {
        if (m34635s()) {
            C7090e.m34735a().m34719q(m34632v(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: o */
    public void mo34627o() {
        this.f24267a.clear();
    }

    /* renamed from: p */
    public void m34638p(String str, long j) {
        if (j >= this.f24271e) {
            EnumC7109a enumC7109a = this.f24270d;
            EnumC7109a enumC7109a2 = EnumC7109a.AD_STATE_NOTVISIBLE;
            if (enumC7109a != enumC7109a2) {
                this.f24270d = enumC7109a2;
                C7090e.m34735a().m34722n(m34632v(), str);
            }
        }
    }

    /* renamed from: q */
    public C7074a m34637q() {
        return this.f24268b;
    }

    /* renamed from: r */
    public C7082a m34636r() {
        return this.f24269c;
    }

    /* renamed from: s */
    public boolean m34635s() {
        return this.f24267a.get() != null;
    }

    /* renamed from: t */
    public void m34634t() {
        C7090e.m34735a().m34734b(m34632v());
    }

    /* renamed from: u */
    public void m34633u() {
        C7090e.m34735a().m34723m(m34632v());
    }

    /* renamed from: v */
    public WebView m34632v() {
        return this.f24267a.get();
    }

    /* renamed from: w */
    public void m34631w() {
        C7090e.m34735a().m34720p(m34632v());
    }

    /* renamed from: x */
    public void m34630x() {
        this.f24271e = C7104d.m34675a();
        this.f24270d = EnumC7109a.AD_STATE_IDLE;
    }
}
