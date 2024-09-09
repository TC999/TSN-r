package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

/* compiled from: NamedRunnable.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public abstract class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected final String f885a;

    public b(String str, Object... objArr) {
        this.f885a = c.a(str, objArr);
    }

    protected abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("tt_pangle_thread_" + this.f885a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
