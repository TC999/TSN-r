package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: Variance.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);
    
    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    @NotNull
    private final String label;
    private final int superpositionFactor;

    Variance(String str, boolean z3, boolean z4, int i4) {
        this.label = str;
        this.allowsInPosition = z3;
        this.allowsOutPosition = z4;
        this.superpositionFactor = i4;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.label;
    }
}
