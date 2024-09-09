package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class q {
    private final b aeV = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class a {
        private static final q aeW = new q();

        static {
            com.kwad.framework.filedownloader.message.e.wf().a(new aa());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b {
        private ThreadPoolExecutor aeX;
        private LinkedBlockingQueue<Runnable> aeY;

        b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aeY = linkedBlockingQueue;
            this.aeX = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aeY.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aeX.execute(new c(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class c implements Runnable {
        private final x.b aeZ;
        private boolean afa = false;

        c(x.b bVar) {
            this.aeZ = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aeZ;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.afa) {
                return;
            }
            this.aeZ.start();
        }
    }

    q() {
    }

    public static q uS() {
        return a.aeW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(x.b bVar) {
        this.aeV.c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(x.b bVar) {
        this.aeV.b(bVar);
    }
}
