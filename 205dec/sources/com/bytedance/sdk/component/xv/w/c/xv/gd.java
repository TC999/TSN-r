package com.bytedance.sdk.component.xv.w.c.xv;

import com.bytedance.sdk.component.xv.w.fz;
import com.bytedance.sdk.component.xv.w.n;
import java.net.Proxy;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class gd {
    public static String c(n nVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(nVar.w());
        sb.append(' ');
        if (w(nVar, type)) {
            sb.append(nVar.c());
        } else {
            sb.append(c(nVar.c()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean w(n nVar, Proxy.Type type) {
        return !nVar.ev() && type == Proxy.Type.HTTP;
    }

    public static String c(fz fzVar) {
        String gd = fzVar.gd();
        try {
            String k4 = fzVar.k();
            if (k4 != null) {
                return gd + '?' + k4;
            }
            return gd;
        } catch (OutOfMemoryError unused) {
            return gd;
        }
    }
}
