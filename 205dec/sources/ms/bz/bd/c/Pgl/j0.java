package ms.bz.bd.c.Pgl;

import java.util.TimeZone;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class j0 extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        String str2;
        int i5;
        try {
            TimeZone timeZone = TimeZone.getDefault();
            str2 = timeZone.getID();
            try {
                i5 = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused) {
                i5 = 0;
                return str2 + ((String) pblk.a(16777217, 0, 0L, "08378f", new byte[]{109})) + i5;
            }
        } catch (Throwable unused2) {
            str2 = null;
        }
        return str2 + ((String) pblk.a(16777217, 0, 0L, "08378f", new byte[]{109})) + i5;
    }
}
