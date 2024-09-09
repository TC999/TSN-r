package com.qq.e.comm.plugin.b0;

import android.widget.ImageView;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f42051a;

    /* renamed from: b  reason: collision with root package name */
    private final long f42052b = System.currentTimeMillis();

    public d(c cVar) {
        this.f42051a = cVar;
    }

    @Override // com.qq.e.comm.plugin.b0.c
    public void a(String str, int i4, Exception exc) {
        c cVar = this.f42051a;
        if (cVar != null) {
            cVar.a(str, i4, exc);
        }
    }

    @Override // com.qq.e.comm.plugin.b0.c
    public void a(String str, ImageView imageView, f fVar) {
        a(str, fVar, this.f42052b);
        c cVar = this.f42051a;
        if (cVar != null) {
            cVar.a(str, imageView, fVar);
        }
    }

    private void a(String str, f fVar, long j4) {
        int i4;
        if (fVar.a() || j4 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j4;
        if (fVar.g()) {
            i4 = 2130004;
        } else {
            i4 = fVar.h() ? 2130003 : 2130001;
        }
        h hVar = new h(i4);
        hVar.b(currentTimeMillis);
        hVar.b((int) (fVar.d().length() / 1024));
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("vu", str);
        hVar.a(dVar);
        v.a(hVar);
    }
}
