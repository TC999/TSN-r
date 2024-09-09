package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class o {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static zg c(Context context) {
        if (w.f()) {
            return new yn(new sr());
        }
        if (w.r() && sr.c()) {
            return new sr();
        }
        if (mk.c()) {
            return new mk(context);
        }
        if (w.xv() && w.sr()) {
            return new zt();
        }
        if (w.xv() && !w.sr()) {
            return new lw();
        }
        if (!w.c(context) && !w.xv()) {
            if (w.gd()) {
                return new yn();
            }
            if (w.ev()) {
                return new qy();
            }
            if (Build.VERSION.SDK_INT > 28) {
                if (w.p()) {
                    return new v();
                }
                if (w.a()) {
                    return new iw();
                }
                if (w.k()) {
                    return new kn();
                }
                if (w.bk()) {
                    return new ba();
                }
                tl tlVar = new tl(context);
                return tlVar.c(context) ? tlVar : new e();
            } else if (w.ux() || !zt.xv(context)) {
                return null;
            } else {
                return new zt();
            }
        }
        return new zt();
    }
}
