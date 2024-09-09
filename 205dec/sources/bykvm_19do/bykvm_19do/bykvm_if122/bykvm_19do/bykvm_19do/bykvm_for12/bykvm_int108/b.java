package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

/* compiled from: Logger.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private EnumC0031b f773a;

    /* renamed from: b  reason: collision with root package name */
    private c f774b;

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public enum EnumC0031b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* compiled from: Logger.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private static final b f780a = new b();
    }

    public static void a(String str, String str2) {
        if (d.f780a.f773a.compareTo(EnumC0031b.DEBUG) <= 0) {
            d.f780a.f774b.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (d.f780a.f773a.compareTo(EnumC0031b.ERROR) <= 0) {
            d.f780a.f774b.b(str, str2);
        }
    }

    private b() {
        this.f773a = EnumC0031b.OFF;
        this.f774b = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.a();
    }
}
