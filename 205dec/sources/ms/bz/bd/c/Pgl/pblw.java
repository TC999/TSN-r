package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pblt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pblw implements pblt.pblb {
    public String a(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }
}
