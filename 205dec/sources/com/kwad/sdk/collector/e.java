package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    public static String cs(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(com.kwad.sdk.core.a.c.Ds().encode(m.k(q.U(new File(str)))));
            } catch (IOException e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        return null;
    }
}
