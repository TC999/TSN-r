package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

/* compiled from: ErrorCode.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f1030a;

    b(int i4) {
        this.f1030a = i4;
    }

    public static b a(int i4) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.f1030a == i4) {
                return bVar;
            }
        }
        return null;
    }
}
