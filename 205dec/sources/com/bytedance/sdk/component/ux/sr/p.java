package com.bytedance.sdk.component.ux.sr;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ux.s;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends c {
    private Bitmap w(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        Collection<s> c4 = xvVar.u().c();
        Bitmap bitmap = null;
        if (c4 == null) {
            return null;
        }
        Iterator<s> it = c4.iterator();
        while (it.hasNext() && (bitmap = it.next().c((s) xvVar.r())) == null) {
        }
        return bitmap;
    }

    private Bitmap xv(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        return xvVar.u().c(xvVar.i()).c((s) xvVar.r());
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "memory_cache";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(com.bytedance.sdk.component.ux.xv.xv xvVar) {
        Bitmap w3;
        int bk = xvVar.bk();
        if (bk != 2 && bk != 1) {
            w3 = null;
        } else if (!xvVar.q() && !xvVar.i().f()) {
            w3 = xv(xvVar);
        } else {
            w3 = w(xvVar);
        }
        if (w3 == null) {
            xvVar.c(new a());
        } else {
            xvVar.c(new bk(w3, null, false));
        }
    }
}
