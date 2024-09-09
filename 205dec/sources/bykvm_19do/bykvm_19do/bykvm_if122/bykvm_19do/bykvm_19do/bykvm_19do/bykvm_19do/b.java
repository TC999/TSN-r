package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

/* compiled from: Logger.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private EnumC0027b f682a;

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public enum EnumC0027b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface c {
    }

    /* compiled from: Logger.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private static final b f688a = new b();
    }

    public static void a(EnumC0027b enumC0027b) {
        synchronized (b.class) {
            d.f688a.f682a = enumC0027b;
        }
    }

    private b() {
        EnumC0027b enumC0027b = EnumC0027b.OFF;
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a();
    }
}
