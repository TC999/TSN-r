package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.w.c;
import com.bytedance.adsdk.ugeno.w.e;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private Context f26388a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f26389b;

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.component.b<View> f26390c;

    /* renamed from: d  reason: collision with root package name */
    private j f26391d;

    /* renamed from: e  reason: collision with root package name */
    private b f26392e;

    /* renamed from: f  reason: collision with root package name */
    private f f26393f;

    /* renamed from: g  reason: collision with root package name */
    private l f26394g;

    /* renamed from: h  reason: collision with root package name */
    private e f26395h;

    /* renamed from: i  reason: collision with root package name */
    private String f26396i;

    /* renamed from: j  reason: collision with root package name */
    private g f26397j;

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f26398k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26399l = true;

    /* renamed from: m  reason: collision with root package name */
    private boolean f26400m = false;

    public i(Context context) {
        this.f26388a = context;
    }

    private void e(com.bytedance.adsdk.ugeno.component.b<View> bVar) {
        List<com.bytedance.adsdk.ugeno.component.b<View>> ev;
        if (bVar == null) {
            return;
        }
        JSONObject k4 = bVar.k();
        Iterator<String> keys = k4.keys();
        com.bytedance.adsdk.ugeno.component.a bk = bVar.bk();
        a.C0358a c4 = bk != null ? bk.c() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String a4 = n0.d.a(k4.optString(next), this.f26389b);
            bVar.c(next, a4);
            bVar.c(this.f26391d);
            bVar.c(this.f26392e);
            bVar.c(this.f26394g);
            if (c4 != null) {
                c4.b(this.f26388a, next, a4);
            }
        }
        if ((bVar instanceof com.bytedance.adsdk.ugeno.component.a) && (ev = ((com.bytedance.adsdk.ugeno.component.a) bVar).ev()) != null && ev.size() > 0) {
            for (com.bytedance.adsdk.ugeno.component.b<View> bVar2 : ev) {
                e(bVar2);
            }
        }
        if (c4 != null) {
            bVar.c(c4.a());
        }
        bVar.w();
    }

    public com.bytedance.adsdk.ugeno.component.b<View> a(e.a aVar) {
        com.bytedance.adsdk.ugeno.component.b<View> b4 = b(aVar, null);
        this.f26390c = b4;
        return b4;
    }

    public com.bytedance.adsdk.ugeno.component.b<View> b(e.a aVar, com.bytedance.adsdk.ugeno.component.b<View> bVar) {
        List<e.a> e4;
        a.C0358a c0358a = null;
        if (e.c(aVar)) {
            String k4 = aVar.k();
            n a4 = k.a(k4);
            if (a4 == null) {
                Log.d("UGTemplateEngine", "not found component " + k4);
                return null;
            }
            com.bytedance.adsdk.ugeno.component.b c4 = a4.c(this.f26388a);
            if (c4 == null) {
                return null;
            }
            c4.xv(n0.d.a(aVar.b(), this.f26389b));
            c4.sr(k4);
            c4.w(aVar.f());
            c4.c(aVar);
            c4.c(this.f26397j);
            if (bVar instanceof com.bytedance.adsdk.ugeno.component.a) {
                com.bytedance.adsdk.ugeno.component.a aVar2 = (com.bytedance.adsdk.ugeno.component.a) bVar;
                c4.c(aVar2);
                c0358a = aVar2.c();
            }
            Iterator<String> keys = aVar.f().keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String a5 = n0.d.a(aVar.f().optString(next), this.f26389b);
                c4.c(next, a5);
                if (c0358a != null) {
                    c0358a.b(this.f26388a, next, a5);
                }
            }
            if (c4 instanceof com.bytedance.adsdk.ugeno.component.a) {
                List<e.a> g4 = aVar.g();
                if (g4 != null && g4.size() > 0) {
                    if (TextUtils.equals(c4.ys(), "Swiper") && g4.size() != 1) {
                        Log.e("UGTemplateEngine", "Swiper must be only one widget");
                    }
                    for (e.a aVar3 : g4) {
                        com.bytedance.adsdk.ugeno.component.b<View> b4 = b(aVar3, c4);
                        if (b4 != null && b4.s()) {
                            ((com.bytedance.adsdk.ugeno.component.a) c4).c(b4);
                        }
                    }
                } else {
                    if (TextUtils.equals(c4.ys(), "RecyclerLayout") && (e4 = this.f26395h.e()) != null && e4.size() > 0) {
                        for (e.a aVar4 : e4) {
                            com.bytedance.adsdk.ugeno.component.b<View> b5 = b(aVar4, c4);
                            if (b5 != null && b5.s()) {
                                ((com.bytedance.adsdk.ugeno.component.a) c4).c(b5);
                            }
                        }
                    }
                    return c4;
                }
            }
            if (c0358a != null) {
                c4.c(c0358a.a());
            }
            this.f26390c = c4;
            return c4;
        }
        return null;
    }

    public com.bytedance.adsdk.ugeno.component.b<View> c(JSONObject jSONObject) {
        f fVar = this.f26393f;
        if (fVar != null) {
            fVar.c();
        }
        e eVar = new e(jSONObject, this.f26389b);
        this.f26395h = eVar;
        b bVar = this.f26392e;
        if (bVar instanceof c.b) {
            ((c.b) bVar).f(eVar.d());
        }
        this.f26390c = b(this.f26395h.a(), null);
        f fVar2 = this.f26393f;
        if (fVar2 != null) {
            fVar2.w();
            this.f26390c.c(this.f26393f);
        }
        return this.f26390c;
    }

    public void d() {
    }

    public void f(com.bytedance.adsdk.ugeno.component.b bVar, JSONObject jSONObject) {
        if (bVar == null) {
            return;
        }
        if (bVar instanceof com.bytedance.adsdk.ugeno.component.a) {
            bVar.c(jSONObject);
            List<com.bytedance.adsdk.ugeno.component.b<View>> ev = ((com.bytedance.adsdk.ugeno.component.a) bVar).ev();
            if (ev == null || ev.size() <= 0) {
                return;
            }
            for (com.bytedance.adsdk.ugeno.component.b<View> bVar2 : ev) {
                f(bVar2, jSONObject);
            }
            return;
        }
        bVar.c(jSONObject);
    }

    public void g(b bVar) {
        c.b bVar2 = new c.b(bVar);
        bVar2.g(this.f26398k);
        bVar2.h(this.f26399l);
        bVar2.l(this.f26400m);
        e eVar = this.f26395h;
        if (eVar != null) {
            bVar2.f(eVar.d());
        }
        this.f26392e = bVar2;
    }

    public void h(j jVar) {
        this.f26391d = jVar;
    }

    public void i(l lVar) {
        this.f26394g = lVar;
    }

    public void j(String str, g gVar) {
        this.f26397j = gVar;
        this.f26396i = str;
        if (gVar != null) {
            this.f26389b = gVar.a();
        }
    }

    public void k(JSONObject jSONObject) {
        f fVar = this.f26393f;
        if (fVar != null) {
            fVar.xv();
        }
        this.f26389b = jSONObject;
        f(this.f26390c, jSONObject);
        e(this.f26390c);
        if (this.f26393f != null) {
            p pVar = new p();
            pVar.b(0);
            pVar.c(this.f26390c);
            this.f26393f.c(pVar);
        }
    }
}
