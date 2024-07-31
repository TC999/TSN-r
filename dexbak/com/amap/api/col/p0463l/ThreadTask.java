package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.z7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class ThreadTask implements Runnable {

    /* renamed from: f */
    InterfaceC2012a f5833f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadTask.java */
    /* renamed from: com.amap.api.col.3l.z7$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2012a {
        /* renamed from: a */
        void mo53313a(ThreadTask threadTask);

        /* renamed from: b */
        void mo53312b(ThreadTask threadTask);
    }

    public final void cancelTask() {
        try {
            InterfaceC2012a interfaceC2012a = this.f5833f;
            if (interfaceC2012a != null) {
                interfaceC2012a.mo53313a(this);
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC2012a interfaceC2012a;
        try {
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (interfaceC2012a = this.f5833f) == null) {
                return;
            }
            interfaceC2012a.mo53312b(this);
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
