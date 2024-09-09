package ms.bz.bd.c.Pgl;

import java.io.File;
import ms.bz.bd.c.Pgl.pblb;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class pble extends pblb.pgla {
    @Override // ms.bz.bd.c.Pgl.pblb.pgla
    public Object b(int i4, long j4, String str, Object obj) throws Throwable {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(pgla.a().c()), (String) pblk.a(16777217, 0, 0L, "68bd2b", new byte[]{105, 55, 2, 20, 12, 97, 52}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
