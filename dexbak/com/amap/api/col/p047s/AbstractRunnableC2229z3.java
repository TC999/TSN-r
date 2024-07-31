package com.amap.api.col.p047s;

/* compiled from: ThreadTask.java */
/* renamed from: com.amap.api.col.s.z3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractRunnableC2229z3 implements Runnable {

    /* renamed from: a */
    InterfaceC2230a f6829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ThreadTask.java */
    /* renamed from: com.amap.api.col.s.z3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2230a {
        /* renamed from: a */
        void mo52170a(AbstractRunnableC2229z3 abstractRunnableC2229z3);
    }

    /* renamed from: a */
    public abstract void mo52171a();

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC2230a interfaceC2230a;
        try {
            if (Thread.interrupted()) {
                return;
            }
            mo52171a();
            if (Thread.interrupted() || (interfaceC2230a = this.f6829a) == null) {
                return;
            }
            interfaceC2230a.mo52170a(this);
        } catch (Throwable th) {
            C2060g2.m52972o(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
