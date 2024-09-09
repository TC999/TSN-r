package ms.bz.bd.c.Pgl;

import java.util.UUID;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class v extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
        return UUID.randomUUID().toString();
    }
}
