package com.qq.e.dl.l.k;

import android.graphics.Canvas;
import android.view.ViewGroup;
import com.qq.e.dl.k.g;
import com.qq.e.dl.l.h;
import com.qq.e.dl.l.k.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class d<T extends a> extends h<T> {

    /* renamed from: w  reason: collision with root package name */
    private final List<h> f47189w;

    public d(com.qq.e.dl.a aVar) {
        super(aVar);
        this.f47189w = new ArrayList();
    }

    @Override // com.qq.e.dl.l.h
    public void a(h.d dVar) {
        super.a(dVar);
        for (h hVar : this.f47189w) {
            hVar.a(dVar);
        }
    }

    @Override // com.qq.e.dl.l.h
    public void b(Canvas canvas) {
        super.b(canvas);
        for (h hVar : this.f47189w) {
            hVar.a(canvas);
        }
    }

    @Override // com.qq.e.dl.l.h
    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        for (h hVar : this.f47189w) {
            hVar.c(jSONObject);
        }
        super.c(jSONObject);
    }

    public h i(int i4) {
        if (i4 < 0 || i4 >= this.f47189w.size()) {
            return null;
        }
        return this.f47189w.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        if (!this.f47079q.a() || m() == null) {
            return;
        }
        m().setWillNotDraw(false);
    }

    public boolean v() {
        return false;
    }

    public final int w() {
        return this.f47189w.size();
    }

    public List<h> x() {
        return this.f47189w;
    }

    @Override // com.qq.e.dl.l.h
    public void a(h.f fVar) {
        super.a(fVar);
        for (h hVar : this.f47189w) {
            hVar.a(fVar);
        }
    }

    public void b(h hVar) {
        if (hVar != null) {
            this.f47189w.add(hVar);
            hVar.a((d) this);
            this.f47070h.b(hVar);
        }
    }

    @Override // com.qq.e.dl.l.h
    public void a(String str, JSONObject jSONObject) {
        for (h hVar : this.f47189w) {
            hVar.a(str, jSONObject);
        }
        super.a(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroup.LayoutParams a(com.qq.e.dl.l.b bVar) {
        return this.f47070h.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, g gVar) {
        if ("60".equals(str)) {
            T t3 = this.f47070h;
            if (t3 instanceof b) {
                ((b) t3).c(gVar.b(new JSONObject[0]) == 1);
                return true;
            }
        }
        return super.a(str, gVar);
    }
}
