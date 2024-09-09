package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class d extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Context c4 = pgla.a().c();
        try {
            return c4.getPackageManager().getPackageInfo(c4.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }
}
