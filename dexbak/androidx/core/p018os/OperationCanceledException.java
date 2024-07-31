package androidx.core.p018os;

import androidx.annotation.Nullable;

/* renamed from: androidx.core.os.OperationCanceledException */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(@Nullable String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
