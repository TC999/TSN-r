package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

/* compiled from: Logger.java */
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1003b {

    /* renamed from: a */
    private EnumC1005b f780a;

    /* renamed from: b */
    private InterfaceC1006c f781b;

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public enum EnumC1005b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1006c {
        /* renamed from: a */
        void mo58990a(String str, String str2);

        /* renamed from: b */
        void mo58989b(String str, String str2);
    }

    /* compiled from: Logger.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class C1007d {

        /* renamed from: a */
        private static final C1003b f787a = new C1003b();
    }

    /* renamed from: a */
    public static void m58992a(String str, String str2) {
        if (C1007d.f787a.f780a.compareTo(EnumC1005b.DEBUG) <= 0) {
            C1007d.f787a.f781b.mo58990a(str, str2);
        }
    }

    /* renamed from: b */
    public static void m58991b(String str, String str2) {
        if (C1007d.f787a.f780a.compareTo(EnumC1005b.ERROR) <= 0) {
            C1007d.f787a.f781b.mo58989b(str, str2);
        }
    }

    private C1003b() {
        this.f780a = EnumC1005b.OFF;
        this.f781b = new C1002a();
    }
}
