package ms.bz.bd.c.Pgl;

import android.content.Context;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        int i5;
        Context c4 = pgla.a().c();
        try {
            i5 = c4.getPackageManager().getPackageInfo(c4.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            i5 = -1;
        }
        String str2 = (String) pblk.a(16777217, 0, 0L, "012323", new byte[]{55, 54, 83, 84, 4, 43, 61, 51, 108, 103, 36, 115, 12, 10, 64, 100, 115, 80});
        return String.valueOf(i5);
    }
}
