package com.kwad.components.core.p304n.p311b;

import android.content.Context;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.p304n.p311b.p312a.C8720j;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.p339a.C9381b;
import com.kwad.components.offline.p342b.C9395b;
import com.kwad.components.offline.p343c.C9418c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.core.n.b.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C8735b {

    /* renamed from: JB */
    private static final AtomicBoolean f28424JB = new AtomicBoolean();

    @ForInvoker(methodId = "initOC")
    /* renamed from: ac */
    public static void m29982ac(Context context) {
        C9381b.m28862aj(context);
        C9395b.m28848aj(context);
        C9418c.m28826aj(context);
    }

    public static void init(final Context context) {
        AtomicBoolean atomicBoolean = f28424JB;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        OfflineHostProvider.get().init(context, new C8720j());
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.n.b.b.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C8735b.m29982ac(context);
            }
        });
    }
}
