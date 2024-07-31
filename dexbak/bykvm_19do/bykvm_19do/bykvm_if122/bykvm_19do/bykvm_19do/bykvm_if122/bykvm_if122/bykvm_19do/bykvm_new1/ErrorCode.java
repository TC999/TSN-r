package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: a */
    public final int f1037a;

    ErrorCode(int i) {
        this.f1037a = i;
    }

    /* renamed from: a */
    public static ErrorCode m58677a(int i) {
        ErrorCode[] values;
        for (ErrorCode errorCode : values()) {
            if (errorCode.f1037a == i) {
                return errorCode;
            }
        }
        return null;
    }
}
