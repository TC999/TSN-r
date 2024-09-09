package com.bytedance.adsdk.ugeno.c.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.c.c.d;
import com.bytedance.adsdk.ugeno.component.a;
import com.bytedance.adsdk.ugeno.w.e;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.ux;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends com.bytedance.adsdk.ugeno.component.a<RecyclerView> {
    private com.bytedance.adsdk.ugeno.c.c.c A;
    private d.e B;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.gd f25987d;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, e.a> f25988e;

    /* renamed from: l  reason: collision with root package name */
    private List<f> f25989l;

    /* renamed from: o  reason: collision with root package name */
    private c f25990o;

    /* renamed from: v  reason: collision with root package name */
    private d f25991v;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class a extends e {
        a(com.bytedance.adsdk.ugeno.c.c.a aVar) {
            super(aVar);
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.e
        public void b() {
            if (b.this.f25990o != null) {
                b.this.f25990o.c();
            }
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.e
        public void d(int i4, int i5) {
            if (b.this.f25990o != null) {
                b.this.f25990o.c(i4, i5);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.e
        public void e(int i4, View view) {
            if (b.this.f25990o == null || i4 < 0 || b.this.f25989l == null || i4 >= b.this.f25989l.size()) {
                return;
            }
            b.this.f25990o.c(i4, view, (f) b.this.f25989l.get(i4));
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.e
        public void g(RecyclerView recyclerView, int i4) {
            if (b.this.f25990o != null) {
                b.this.f25990o.c(recyclerView, i4);
            }
        }
    }

    /* renamed from: com.bytedance.adsdk.ugeno.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class C0356b extends RecyclerView.ev implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private int f25993a;

        public C0356b(int i4) {
            this.f25993a = i4;
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public void c() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.ev
        public void c(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
            super.c(rect, view, recyclerView, uVar);
            int i4 = this.f25993a;
            rect.left = i4;
            rect.right = i4;
            rect.bottom = i4;
            if (recyclerView.f(view) == 0) {
                rect.top = this.f25993a;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public void w() {
        }

        @Override // com.bytedance.adsdk.ugeno.c.c.d.a
        public View xv() {
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(int i4, int i5);

        void c(int i4, View view, f fVar);

        void c(RecyclerView recyclerView, int i4);
    }

    public b(Context context) {
        super(context);
        this.f25988e = new HashMap();
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public a.C0358a c() {
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
    }

    public void d(int i4, Object obj) {
        d dVar = this.f25991v;
        if (dVar != null) {
            dVar.j(obj);
            this.f25991v.c(i4, obj);
        }
    }

    public void e(c cVar) {
        this.f25990o = cVar;
    }

    public void g(com.bytedance.adsdk.ugeno.c.c.c cVar) {
        this.A = cVar;
    }

    public void h(d.b bVar) {
        this.f25991v.e(bVar);
    }

    public void i(List<f> list) {
        this.f25989l = list;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void l(List<f> list) {
        if (this.f25991v == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.f25989l == null) {
            this.f25989l = new ArrayList();
        }
        int size = this.f25989l.size();
        this.f25989l.addAll(list);
        this.f25991v.c(list);
        this.f25991v.c(size, this.f25989l.size());
    }

    @Override // com.bytedance.adsdk.ugeno.component.a, com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        d dVar = new d(this.f26040w);
        this.f25991v = dVar;
        dVar.h(this.f26032m);
        this.f25991v.g(this.gw);
        this.f25991v.i(this.vc);
        this.f25991v.d(this.A);
        this.f25991v.f(this.B);
        this.f25991v.k(this.f25988e);
        this.f25991v.c(this.f25989l);
        ((RecyclerView) this.ux).setLayoutManager(this.f25987d);
        ((RecyclerView) this.ux).setAdapter(this.f25991v);
        ((RecyclerView) this.ux).c((RecyclerView.ev) new C0356b((int) l0.b.a(this.f26040w, 10.0f)));
        ((RecyclerView) this.ux).c((RecyclerView.t) new a(new com.bytedance.adsdk.ugeno.c.c.a()));
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public View xv() {
        return new RecyclerView(this.f26040w);
    }

    @Override // com.bytedance.adsdk.ugeno.component.a
    public void c(com.bytedance.adsdk.ugeno.component.b bVar) {
        if (bVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.component.a) this).f26014c.add(bVar);
        if (bVar.t() != null) {
            this.f25988e.put(Integer.valueOf(bVar.t().hashCode()), bVar.a());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.f25987d = new ux(this.f26040w);
        }
    }
}
