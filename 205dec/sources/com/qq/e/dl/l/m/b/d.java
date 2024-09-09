package com.qq.e.dl.l.m.b;

import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends com.qq.e.dl.l.k.b<c> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(h hVar, c cVar) {
        super(hVar, cVar);
    }

    @Override // com.qq.e.dl.l.k.b, com.qq.e.dl.l.k.c
    public void b() {
        com.qq.e.dl.l.b j4 = this.f47182a.j();
        if (j4.p()) {
            int j5 = j4.j();
            if (j5 > 0) {
                ((c) this.f47188g).setMaxWidth(j5);
            }
            int l4 = j4.l();
            if (l4 > 0) {
                ((c) this.f47188g).setMinWidth(l4);
            }
            int k4 = j4.k();
            if (k4 > 0) {
                ((c) this.f47188g).setMinHeight(k4);
            }
            int i4 = j4.i();
            if (i4 > 0) {
                ((c) this.f47188g).setMaxHeight(i4);
            }
        }
        super.b();
    }
}
