package com.iab.omid.library.mmadbridge.adsession;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h extends b {

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f37691l = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a  reason: collision with root package name */
    private final d f37692a;

    /* renamed from: b  reason: collision with root package name */
    private final c f37693b;

    /* renamed from: d  reason: collision with root package name */
    private o0.a f37695d;

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.publisher.a f37696e;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37700i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37701j;

    /* renamed from: k  reason: collision with root package name */
    private f f37702k;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.iab.omid.library.mmadbridge.b.c> f37694c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f37697f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f37698g = false;

    /* renamed from: h  reason: collision with root package name */
    private final String f37699h = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, d dVar) {
        this.f37693b = cVar;
        this.f37692a = dVar;
        t(null);
        this.f37696e = (dVar.d() == AdSessionContextType.HTML || dVar.d() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.mmadbridge.publisher.b(dVar.k()) : new com.iab.omid.library.mmadbridge.publisher.c(dVar.g(), dVar.h());
        this.f37696e.a();
        com.iab.omid.library.mmadbridge.b.a.a().b(this);
        this.f37696e.e(cVar);
    }

    private void C() {
        if (this.f37700i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void D() {
        if (this.f37701j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    private com.iab.omid.library.mmadbridge.b.c l(View view) {
        for (com.iab.omid.library.mmadbridge.b.c cVar : this.f37694c) {
            if (cVar.a().get() == view) {
                return cVar;
            }
        }
        return null;
    }

    private void n(String str) {
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!f37691l.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
    }

    private static void q(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    private void t(View view) {
        this.f37695d = new o0.a(view);
    }

    private void v(View view) {
        Collection<h> c4 = com.iab.omid.library.mmadbridge.b.a.a().c();
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        for (h hVar : c4) {
            if (hVar != this && hVar.w() == view) {
                hVar.f37695d.clear();
            }
        }
    }

    public boolean A() {
        return this.f37693b.b();
    }

    public boolean B() {
        return this.f37693b.c();
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        if (this.f37698g) {
            return;
        }
        q(view);
        n(str);
        if (l(view) == null) {
            this.f37694c.add(new com.iab.omid.library.mmadbridge.b.c(view, friendlyObstructionPurpose, str));
        }
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void c(ErrorType errorType, String str) {
        if (this.f37698g) {
            throw new IllegalStateException("AdSession is finished");
        }
        com.iab.omid.library.mmadbridge.d.e.d(errorType, "Error type is null");
        com.iab.omid.library.mmadbridge.d.e.f(str, "Message is null");
        f().f(errorType, str);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void d() {
        if (this.f37698g) {
            return;
        }
        this.f37695d.clear();
        h();
        this.f37698g = true;
        f().t();
        com.iab.omid.library.mmadbridge.b.a.a().f(this);
        f().o();
        this.f37696e = null;
        this.f37702k = null;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public String e() {
        return this.f37699h;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public com.iab.omid.library.mmadbridge.publisher.a f() {
        return this.f37696e;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void g(View view) {
        if (this.f37698g) {
            return;
        }
        com.iab.omid.library.mmadbridge.d.e.d(view, "AdView is null");
        if (w() == view) {
            return;
        }
        t(view);
        f().x();
        v(view);
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void h() {
        if (this.f37698g) {
            return;
        }
        this.f37694c.clear();
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void i(View view) {
        if (this.f37698g) {
            return;
        }
        q(view);
        com.iab.omid.library.mmadbridge.b.c l4 = l(view);
        if (l4 != null) {
            this.f37694c.remove(l4);
        }
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void j(f fVar) {
        this.f37702k = fVar;
    }

    @Override // com.iab.omid.library.mmadbridge.adsession.b
    public void k() {
        if (this.f37697f) {
            return;
        }
        this.f37697f = true;
        com.iab.omid.library.mmadbridge.b.a.a().d(this);
        this.f37696e.b(com.iab.omid.library.mmadbridge.b.f.b().f());
        this.f37696e.g(this, this.f37692a);
    }

    public List<com.iab.omid.library.mmadbridge.b.c> m() {
        return this.f37694c;
    }

    public void o(List<o0.a> list) {
        if (r()) {
            ArrayList arrayList = new ArrayList();
            for (o0.a aVar : list) {
                View view = aVar.get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            this.f37702k.a(this.f37699h, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(@NonNull JSONObject jSONObject) {
        D();
        f().m(jSONObject);
        this.f37701j = true;
    }

    public boolean r() {
        return this.f37702k != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        C();
        f().u();
        this.f37700i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        D();
        f().w();
        this.f37701j = true;
    }

    public View w() {
        return this.f37695d.get();
    }

    public boolean x() {
        return this.f37697f && !this.f37698g;
    }

    public boolean y() {
        return this.f37697f;
    }

    public boolean z() {
        return this.f37698g;
    }
}
