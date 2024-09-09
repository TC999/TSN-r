package com.bytedance.adsdk.ugeno.c.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.w.e;
import com.bytedance.adsdk.ugeno.w.i;
import com.bytedance.adsdk.ugeno.w.j;
import com.bytedance.adsdk.ugeno.w.l;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d extends RecyclerView.c<RecyclerView.j> {

    /* renamed from: a  reason: collision with root package name */
    private List<f> f25994a;

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, e.a> f25995b;

    /* renamed from: d  reason: collision with root package name */
    private Context f25996d;

    /* renamed from: e  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.c.c.c f25997e;

    /* renamed from: f  reason: collision with root package name */
    private e f25998f;

    /* renamed from: g  reason: collision with root package name */
    private Object f25999g;

    /* renamed from: h  reason: collision with root package name */
    private b f26000h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26001i = true;

    /* renamed from: j  reason: collision with root package name */
    private j f26002j;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.w.b f26003k;

    /* renamed from: l  reason: collision with root package name */
    private l f26004l;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface a {
        void c();

        void w();

        View xv();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface b {
        void c(RecyclerView.j jVar, int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends RecyclerView.j implements a {

        /* renamed from: b  reason: collision with root package name */
        com.bytedance.adsdk.ugeno.component.b f26005b;

        /* renamed from: d  reason: collision with root package name */
        i f26006d;

        c(View view) {
            super(view);
        }

        public void b(com.bytedance.adsdk.ugeno.component.b bVar) {
            this.f26005b = bVar;
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public void c() {
            if (d.this.f25997e != null) {
                d.this.f25997e.w(this.f26005b);
            }
        }

        public void d(i iVar) {
            this.f26006d = iVar;
        }

        public com.bytedance.adsdk.ugeno.component.b e() {
            return this.f26005b;
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public void w() {
            if (d.this.f25997e != null) {
                d.this.f25997e.c(this.f26005b);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public View xv() {
            return this.f26005b.gd();
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.c.c.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0357d extends RecyclerView.j {
        public C0357d(View view) {
            super(view);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface e {
    }

    public d(Context context) {
        this.f25996d = context;
    }

    public void b(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar instanceof com.bytedance.adsdk.ugeno.component.a) {
            bVar.c(this.f26002j);
            bVar.c(this.f26003k);
            bVar.w(true);
            bVar.w();
            List<com.bytedance.adsdk.ugeno.component.b<View>> ev = ((com.bytedance.adsdk.ugeno.component.a) bVar).ev();
            if (ev == null || ev.size() <= 0) {
                return;
            }
            for (com.bytedance.adsdk.ugeno.component.b<View> bVar2 : ev) {
                b(context, jSONObject, bVar2);
            }
            return;
        }
        JSONObject k4 = bVar.k();
        Iterator<String> keys = k4.keys();
        com.bytedance.adsdk.ugeno.component.a bk = bVar.bk();
        a.C0358a c4 = bk != null ? bk.c() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String a4 = n0.d.a(k4.optString(next), jSONObject);
            bVar.c(next, a4);
            bVar.c(this.f26002j);
            bVar.c(this.f26003k);
            if (c4 != null) {
                c4.b(context, next, a4);
            }
        }
        bVar.w(true);
        bVar.w();
    }

    public void c(List<f> list) {
        if (this.f25994a == null) {
            this.f25994a = new ArrayList();
        }
        this.f25994a.addAll(list);
    }

    public void d(com.bytedance.adsdk.ugeno.c.c.c cVar) {
        this.f25997e = cVar;
    }

    public void e(b bVar) {
        this.f26000h = bVar;
    }

    public void f(e eVar) {
        this.f25998f = eVar;
    }

    public void g(com.bytedance.adsdk.ugeno.w.b bVar) {
        this.f26003k = bVar;
    }

    public void h(j jVar) {
        this.f26002j = jVar;
    }

    public void i(l lVar) {
        this.f26004l = lVar;
    }

    public void j(Object obj) {
        this.f25999g = obj;
    }

    public void k(Map<Integer, e.a> map) {
        this.f25995b = map;
    }

    public void l(JSONObject jSONObject, com.bytedance.adsdk.ugeno.component.b bVar) {
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
                l(jSONObject, bVar2);
            }
            return;
        }
        bVar.c(jSONObject);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public RecyclerView.j c(ViewGroup viewGroup, int i4) {
        i iVar = new i(this.f25996d);
        com.bytedance.adsdk.ugeno.component.b<View> a4 = iVar.a(this.f25995b.get(Integer.valueOf(i4)));
        if (a4 != null) {
            a4.c(new ViewGroup.LayoutParams(a4.fp(), a4.ia()));
            c cVar = new c(a4.gd());
            cVar.b(a4);
            cVar.d(iVar);
            return cVar;
        }
        return new C0357d(new View(this.f25996d));
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public int c(int i4) {
        return this.f25994a.get(i4).d();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void c(RecyclerView.j jVar, int i4, List<Object> list) {
        b bVar;
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null && this.f25999g != null && TextUtils.equals(obj.toString(), this.f25999g.toString()) && (bVar = this.f26000h) != null) {
                    bVar.c(jVar, i4);
                }
            }
            return;
        }
        c(jVar, i4);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public void c(RecyclerView.j jVar, int i4) {
        f fVar;
        com.bytedance.adsdk.ugeno.c.c.c cVar;
        if (jVar == null || (fVar = this.f25994a.get(i4)) == null || !(jVar instanceof c)) {
            return;
        }
        JSONObject a4 = fVar.a();
        c cVar2 = (c) jVar;
        cVar2.f26005b.c(new ViewGroup.LayoutParams(cVar2.f26005b.fp(), cVar2.f26005b.ia()));
        l(a4, cVar2.e());
        b(this.f25996d, a4, cVar2.e());
        if (i4 == 0 && (cVar = this.f25997e) != null && this.f26001i) {
            this.f26001i = false;
            cVar.c(cVar2.f26005b);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.c
    public int c() {
        return this.f25994a.size();
    }
}
