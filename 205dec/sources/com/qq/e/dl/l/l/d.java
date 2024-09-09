package com.qq.e.dl.l.l;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.dl.e;
import com.qq.e.dl.f.g;
import com.qq.e.dl.f.i;
import com.qq.e.dl.l.f;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends ViewGroup implements b, h.f {

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.dl.a f47227c;

    /* renamed from: d  reason: collision with root package name */
    private final g f47228d;

    /* renamed from: e  reason: collision with root package name */
    protected h f47229e;

    /* renamed from: f  reason: collision with root package name */
    private View f47230f;

    /* renamed from: g  reason: collision with root package name */
    private c f47231g;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.dl.h.b f47232h;

    /* renamed from: i  reason: collision with root package name */
    private String f47233i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f47234j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            com.qq.e.dl.c e4 = d.this.f47227c.e();
            if (e4 != null) {
                e4.start();
            }
            e g4 = d.this.f47227c.g();
            if (g4 != null) {
                g4.start();
            }
            if (!d.this.f47234j) {
                d.this.f47228d.c();
                return;
            }
            d.this.f47234j = false;
            d.this.c(com.qq.e.dl.i.a.f46907o);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            com.qq.e.dl.c e4 = d.this.f47227c.e();
            if (e4 != null) {
                e4.stop();
            }
            e g4 = d.this.f47227c.g();
            if (g4 != null) {
                g4.stop();
            }
            d.this.f47228d.b();
        }
    }

    public d(com.qq.e.dl.a aVar) {
        super(aVar.b());
        this.f47234j = true;
        this.f47227c = aVar;
        this.f47228d = new g();
    }

    public h d() {
        return this.f47229e;
    }

    @Override // android.view.View, com.qq.e.dl.l.l.b
    public View getRootView() {
        return this.f47230f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        h hVar = this.f47229e;
        if (hVar != null) {
            hVar.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        h hVar = this.f47229e;
        if (hVar != null) {
            hVar.a(z3, i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        h hVar = this.f47229e;
        if (hVar != null) {
            hVar.a(i4, i5);
            setMeasuredDimension(this.f47229e.l(), this.f47229e.k());
        }
    }

    public void b(String str) {
        this.f47233i = str;
    }

    public void c(String str) {
        a(str, (com.qq.e.dl.f.b) null);
    }

    @Override // com.qq.e.dl.l.l.b
    public com.qq.e.dl.a a() {
        return this.f47227c;
    }

    @Override // com.qq.e.dl.l.l.b
    public String b() {
        String str = this.f47233i;
        return str == null ? "" : str;
    }

    public g c() {
        return this.f47228d;
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        this.f47229e = hVar;
        this.f47228d.a();
        View m4 = hVar.m();
        if (m4 != null) {
            this.f47230f = m4;
            m4.setLayoutParams(new f(hVar.j()));
            m4.addOnAttachStateChangeListener(new a());
        } else if (hVar instanceof com.qq.e.dl.l.k.d) {
            this.f47230f = this;
        }
    }

    @Override // com.qq.e.dl.l.l.b
    public void a(JSONObject jSONObject) {
        h hVar = this.f47229e;
        if (hVar != null) {
            hVar.c(jSONObject);
        }
    }

    @Override // com.qq.e.dl.l.l.b
    public void a(com.qq.e.dl.l.d dVar) {
        if (this.f47229e == null) {
            return;
        }
        if (this.f47231g == null) {
            c cVar = new c(this);
            this.f47231g = cVar;
            this.f47229e.a(cVar);
        }
        this.f47231g.a(dVar);
    }

    @Override // com.qq.e.dl.l.l.b
    public void a(com.qq.e.dl.h.b bVar) {
        if (bVar != null && this.f47232h == null) {
            this.f47229e.a((h.f) this);
        }
        this.f47232h = bVar;
    }

    @Override // com.qq.e.dl.l.l.b
    public i a(String str) {
        return this.f47228d.a(str);
    }

    public void a(String str, com.qq.e.dl.f.b bVar) {
        i a4 = a(str);
        if (a4 == null) {
            return;
        }
        a4.a(bVar);
    }

    @Override // com.qq.e.dl.l.h.f
    public void a(h hVar, com.qq.e.dl.h.a aVar) {
        com.qq.e.dl.h.b bVar = this.f47232h;
        if (bVar == null) {
            return;
        }
        bVar.a(hVar, aVar);
        a(hVar, aVar.f46896c, aVar.f46897d, aVar.f46898e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(h hVar, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (!TextUtils.isEmpty(str)) {
            c(str);
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            a(jSONObject);
        }
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        hVar.c(jSONObject2);
    }

    @Override // com.qq.e.dl.l.l.a
    public void a(String str, JSONObject jSONObject) {
        h hVar = this.f47229e;
        if (hVar != null) {
            hVar.a(str, jSONObject);
        }
    }
}
