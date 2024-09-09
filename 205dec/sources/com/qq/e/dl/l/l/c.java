package com.qq.e.dl.l.l;

import android.text.TextUtils;
import com.qq.e.dl.f.i;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c implements h.d {

    /* renamed from: c  reason: collision with root package name */
    private final d f47225c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.dl.l.d f47226d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f47225c = dVar;
    }

    @Override // com.qq.e.dl.l.d
    public void a(h hVar, com.qq.e.dl.l.j.c cVar) {
        com.qq.e.dl.l.d dVar = this.f47226d;
        if (dVar == null) {
            return;
        }
        dVar.a(hVar, cVar);
    }

    @Override // com.qq.e.dl.l.d
    public boolean b(h hVar, com.qq.e.dl.l.j.c cVar) {
        com.qq.e.dl.l.d dVar = this.f47226d;
        boolean z3 = dVar != null && dVar.b(hVar, cVar);
        this.f47225c.a(hVar, cVar.f47124e, cVar.f47125f, cVar.f47126g);
        return z3;
    }

    @Override // com.qq.e.dl.l.d
    public void c(h hVar, com.qq.e.dl.l.j.c cVar) {
        com.qq.e.dl.l.d dVar = this.f47226d;
        if (dVar == null) {
            return;
        }
        dVar.c(hVar, cVar);
    }

    @Override // com.qq.e.dl.l.d
    public void a(h hVar, com.qq.e.dl.l.j.c cVar, float f4) {
        i a4;
        com.qq.e.dl.l.d dVar = this.f47226d;
        if (dVar == null) {
            return;
        }
        dVar.a(hVar, cVar, f4);
        if (!TextUtils.isEmpty(cVar.f47128i) && (a4 = this.f47225c.c().a(cVar.f47128i)) != null) {
            a4.a(f4);
        }
        if (cVar.f47129j != null) {
            this.f47225c.a(cVar.f47122c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.qq.e.dl.l.d dVar) {
        this.f47226d = dVar;
    }
}
