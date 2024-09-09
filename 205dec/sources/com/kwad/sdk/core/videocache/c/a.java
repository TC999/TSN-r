package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static f aCC;

    public static f b(Context context, int i4, int i5) {
        f fVar = aCC;
        if (fVar == null) {
            f c4 = c(context, i4, i5);
            aCC = c4;
            return c4;
        }
        return fVar;
    }

    public static f bl(Context context) {
        return b(context, 0, 0);
    }

    private static f c(Context context, int i4, int i5) {
        return new f.a(context).as(536870912L).ds(i4).dt(i5).Gr();
    }
}
