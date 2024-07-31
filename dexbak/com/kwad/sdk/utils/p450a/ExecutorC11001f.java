package com.kwad.sdk.utils.p450a;

import java.util.concurrent.Executor;

/* renamed from: com.kwad.sdk.utils.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ExecutorC11001f implements Executor {
    private Runnable aSc;
    private Runnable aSd;

    /* renamed from: d */
    private Runnable m24171d(final Runnable runnable) {
        return new Runnable() { // from class: com.kwad.sdk.utils.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    ExecutorC11001f.this.scheduleNext();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable runnable = this.aSd;
        this.aSc = runnable;
        this.aSd = null;
        if (runnable != null) {
            C10998d.getExecutor().execute(this.aSc);
        }
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.aSc == null) {
            this.aSc = m24171d(runnable);
            C10998d.getExecutor().execute(this.aSc);
            return;
        }
        if (this.aSd == null) {
            this.aSd = m24171d(runnable);
        }
    }
}
