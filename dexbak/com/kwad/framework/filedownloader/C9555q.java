package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.InterfaceC9580x;
import com.kwad.framework.filedownloader.message.C9532e;
import com.kwad.framework.filedownloader.p353f.C9490b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.kwad.framework.filedownloader.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9555q {
    private final C9557b aeV = new C9557b();

    /* renamed from: com.kwad.framework.filedownloader.q$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9556a {
        private static final C9555q aeW = new C9555q();

        static {
            C9532e.m28463wf().m28465a(new C9437aa());
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.q$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C9557b {
        private ThreadPoolExecutor aeX;
        private LinkedBlockingQueue<Runnable> aeY;

        C9557b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aeY = linkedBlockingQueue;
            this.aeX = C9490b.m28553a(3, linkedBlockingQueue, "LauncherTask");
        }

        /* renamed from: b */
        public final void m28427b(InterfaceC9580x.InterfaceC9582b interfaceC9582b) {
            this.aeY.remove(interfaceC9582b);
        }

        /* renamed from: c */
        public final void m28426c(InterfaceC9580x.InterfaceC9582b interfaceC9582b) {
            this.aeX.execute(new RunnableC9558c(interfaceC9582b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.framework.filedownloader.q$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class RunnableC9558c implements Runnable {
        private final InterfaceC9580x.InterfaceC9582b aeZ;
        private boolean afa = false;

        RunnableC9558c(InterfaceC9580x.InterfaceC9582b interfaceC9582b) {
            this.aeZ = interfaceC9582b;
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

    C9555q() {
    }

    /* renamed from: uS */
    public static C9555q m28429uS() {
        return C9556a.aeW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void m28431a(InterfaceC9580x.InterfaceC9582b interfaceC9582b) {
        this.aeV.m28426c(interfaceC9582b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void m28430b(InterfaceC9580x.InterfaceC9582b interfaceC9582b) {
        this.aeV.m28427b(interfaceC9582b);
    }
}
