package com.qq.e.comm.plugin.i;

import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m implements o {
    m() {
    }

    private void a(int i4, h hVar) {
        pro.getVresult(444, 0, this, Integer.valueOf(i4), hVar);
    }

    private void a(h hVar, int i4) {
        pro.getVresult(445, 0, this, hVar, Integer.valueOf(i4));
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(446, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(447, 0, this, hVar, bVar);
    }
}
