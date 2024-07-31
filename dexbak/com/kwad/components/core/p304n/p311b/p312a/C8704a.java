package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11095g;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.components.core.n.b.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8704a implements IAsync {
    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void execute(Runnable runnable) {
        C11095g.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnDefaultExecutor(Runnable runnable) {
        C11095g.execute(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThread(Runnable runnable) {
        C11064bn.runOnUiThread(runnable);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void runOnUiThreadDelay(Runnable runnable, long j) {
        C11064bn.runOnUiThreadDelay(runnable, j);
    }

    @Override // com.kwad.components.offline.api.core.api.IAsync
    public final void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        C11095g.schedule(runnable, j, timeUnit);
    }
}
