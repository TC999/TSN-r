package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Logger {

    /* renamed from: a */
    private EnumC0991b f689a;

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC0991b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC0992c {
    }

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C0993d {

        /* renamed from: a */
        private static final Logger f695a = new Logger();
    }

    /* renamed from: a */
    public static void m59086a(EnumC0991b enumC0991b) {
        synchronized (Logger.class) {
            C0993d.f695a.f689a = enumC0991b;
        }
    }

    private Logger() {
        EnumC0991b enumC0991b = EnumC0991b.OFF;
        new DefaultLoggerDelegate();
    }
}
