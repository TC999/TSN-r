package ms.bz.bd.c.Pgl;

import java.io.File;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class b extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(pgla.a().c()), (String) pblk.a(16777217, 0, 0L, "8bddd9", new byte[]{103, 109, 4, 20, 90, 58, 58}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
