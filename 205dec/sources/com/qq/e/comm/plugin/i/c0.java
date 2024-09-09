package com.qq.e.comm.plugin.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c0 implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f44068a = com.qq.e.comm.plugin.d0.a.d().f().a("tcd", 500);

    /* renamed from: b  reason: collision with root package name */
    private static final Class<o>[] f44069b = {l.class};

    /* renamed from: c  reason: collision with root package name */
    private static final Class<o>[] f44070c = {q.class, n.class, m.class};

    @Override // com.qq.e.comm.plugin.i.p
    public void a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        int i4;
        com.qq.e.comm.plugin.i.d0.a aVar = new com.qq.e.comm.plugin.i.d0.a(bVar);
        j.a(false, 0, hVar);
        y yVar = new y();
        if (yVar.a(hVar) && yVar.a(hVar, aVar)) {
            return;
        }
        if (a(f44069b, hVar, aVar) && (i4 = f44068a) > 0) {
            try {
                Thread.sleep(i4);
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
        }
        a(f44070c, hVar, aVar);
        a0 a0Var = new a0();
        if (a0Var.a(hVar)) {
            a0Var.a(hVar, aVar);
        }
    }

    private boolean a(Class<o>[] clsArr, h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        if (clsArr != null && clsArr.length != 0) {
            for (Class<o> cls : clsArr) {
                try {
                    o newInstance = cls.newInstance();
                    if (newInstance.a(hVar) && newInstance.a(hVar, bVar)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }
}
