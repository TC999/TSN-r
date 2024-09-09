package com.mbridge.msdk.foundation.same.net;

import android.os.Handler;
import com.mbridge.msdk.foundation.tools.x;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private final String f39498a = d.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f39499b;

    /* compiled from: ExecutorDelivery.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f39520b;

        /* renamed from: c  reason: collision with root package name */
        private final k f39521c;

        public a(i iVar, k kVar) {
            this.f39520b = iVar;
            this.f39521c = kVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f39520b.c()) {
                this.f39520b.a("canceled-at-delivery");
                this.f39520b.n();
                return;
            }
            k kVar = this.f39521c;
            com.mbridge.msdk.foundation.same.net.a.a aVar = kVar.f39629b;
            if (aVar == null) {
                this.f39520b.a(kVar);
            } else {
                this.f39520b.a(aVar);
            }
            this.f39520b.a("done");
            this.f39520b.p();
        }
    }

    public d(final Handler handler) {
        this.f39499b = new Executor() { // from class: com.mbridge.msdk.foundation.same.net.d.1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, k<?> kVar) {
        String str = this.f39498a;
        x.b(str, "postResponse response=" + kVar.f39628a);
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new a(iVar, kVar));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void b(final i<?> iVar) {
        String str = this.f39498a;
        x.b(str, "postCancel request=" + iVar.b());
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.n();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void c(final i<?> iVar) {
        String str = this.f39498a;
        x.b(str, "postPreExecute request=" + iVar.b());
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.o();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void d(final i<?> iVar) {
        String str = this.f39498a;
        x.b(str, "postNetworking request=" + iVar.b());
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.5
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.r();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void e(final i<?> iVar) {
        String str = this.f39498a;
        x.b(str, "postRetry request=" + iVar.b());
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.6
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.q();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(i<?> iVar, com.mbridge.msdk.foundation.same.net.a.a aVar) {
        String str = this.f39498a;
        x.b(str, "postError error=" + aVar.f39484a);
        if (this.f39499b != null) {
            this.f39499b.execute(new a(iVar, k.a(aVar)));
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar) {
        String str = this.f39498a;
        x.b(str, "postFinish request=" + iVar.b());
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.p();
                }
            });
        }
    }

    @Override // com.mbridge.msdk.foundation.same.net.c
    public final void a(final i<?> iVar, final long j4, final long j5) {
        String str = this.f39498a;
        x.b(str, "postDownloadProgress downloadedSize=" + j5 + "/ fileSize=" + j4);
        Executor executor = this.f39499b;
        if (executor != null) {
            executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.d.7
                @Override // java.lang.Runnable
                public final void run() {
                    iVar.a(j4, j5);
                }
            });
        }
    }
}
