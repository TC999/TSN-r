package com.mbridge.msdk.foundation.tools;

import java.util.concurrent.Executor;

/* compiled from: LimitExecutor.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f39867a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f39868b;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.f39867a == null) {
            this.f39867a = a(runnable);
            k.a().execute(this.f39867a);
        } else if (this.f39868b == null) {
            this.f39868b = a(runnable);
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() { // from class: com.mbridge.msdk.foundation.tools.n.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    n.this.a();
                    throw th;
                }
                n.this.a();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f39868b;
        this.f39867a = runnable;
        this.f39868b = null;
        if (runnable != null) {
            k.a().execute(this.f39867a);
        }
    }
}
