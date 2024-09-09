package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class t extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        Context c4 = pgla.a().c();
        String[] strArr = (String[]) obj;
        if (c4 == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(c4.getPackageName());
        for (int i5 = 0; i5 < strArr.length; i5 += 2) {
            intent.putExtra(strArr[i5], strArr[i5 + 1]);
        }
        c4.sendBroadcast(intent);
        return null;
    }
}
