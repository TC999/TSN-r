package com.kwad.components.core.n.b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.n.b.a.j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.c.c;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {
    private static final AtomicBoolean Kc = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    public static void an(Context context) {
        com.kwad.components.offline.a.b.au(context);
        com.kwad.components.offline.b.b.au(context);
        c.au(context);
    }

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = Kc;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new j());
        g.execute(new ay() { // from class: com.kwad.components.core.n.b.b.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                b.ac(context);
            }
        });
    }
}