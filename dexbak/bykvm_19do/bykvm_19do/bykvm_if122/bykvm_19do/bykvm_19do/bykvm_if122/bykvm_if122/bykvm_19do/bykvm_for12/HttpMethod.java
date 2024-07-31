package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class HttpMethod {
    /* renamed from: a */
    public static boolean m58763a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m58762b(String str) {
        return m58759e(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    /* renamed from: c */
    public static boolean m58761c(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m58760d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m58759e(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
