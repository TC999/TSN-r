package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        int i5;
        k1 b4 = k1.b(pgla.a().c());
        b4.getClass();
        try {
            synchronized (b4) {
                i5 = b4.a();
            }
        } catch (Exception unused) {
            i5 = -1;
        }
        return "" + i5;
    }
}
