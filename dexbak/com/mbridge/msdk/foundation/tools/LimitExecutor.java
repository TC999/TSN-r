package com.mbridge.msdk.foundation.tools;

import java.util.concurrent.Executor;

/* renamed from: com.mbridge.msdk.foundation.tools.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class LimitExecutor implements Executor {

    /* renamed from: a */
    private Runnable f31094a;

    /* renamed from: b */
    private Runnable f31095b;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.f31094a == null) {
            this.f31094a = m21839a(runnable);
            FastKVConfig.m21847a().execute(this.f31094a);
        } else if (this.f31095b == null) {
            this.f31095b = m21839a(runnable);
        }
    }

    /* renamed from: a */
    private Runnable m21839a(final Runnable runnable) {
        return new Runnable() { // from class: com.mbridge.msdk.foundation.tools.n.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    LimitExecutor.this.m21841a();
                    throw th;
                }
                LimitExecutor.this.m21841a();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m21841a() {
        Runnable runnable = this.f31095b;
        this.f31094a = runnable;
        this.f31095b = null;
        if (runnable != null) {
            FastKVConfig.m21847a().execute(this.f31094a);
        }
    }
}
