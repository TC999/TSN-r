package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Boolean bool = Boolean.FALSE;
        try {
            Context c4 = pgla.a().c();
            if (c4 != null) {
                return Boolean.valueOf((c4.getApplicationInfo() == null || (c4.getApplicationInfo().flags & 2) == 0) ? false : true);
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
