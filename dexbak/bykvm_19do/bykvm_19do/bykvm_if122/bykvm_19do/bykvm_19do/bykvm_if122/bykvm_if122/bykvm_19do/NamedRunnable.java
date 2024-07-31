package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: a */
    protected final String f892a;

    public NamedRunnable(String str, Object... objArr) {
        this.f892a = C1061c.m58464a(str, objArr);
    }

    /* renamed from: b */
    protected abstract void mo58214b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("tt_pangle_thread_" + this.f892a);
        try {
            mo58214b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
