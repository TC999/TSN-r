package com.kwad.sdk.collector;

import android.os.Build;
import com.kwad.sdk.core.p385a.C9886c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11104m;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kwad.sdk.collector.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9799e {
    /* renamed from: cs */
    public static String m27755cs(String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return new String(C9886c.m27444Ds().encode(C11104m.m23769k(C11122q.m23739U(new File(str)))));
            } catch (IOException e) {
                C10331c.printStackTrace(e);
            }
        }
        return null;
    }
}
