package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.u;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public enum AnnotationArgumentsRenderingPolicy {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);
    
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    AnnotationArgumentsRenderingPolicy(boolean z3, boolean z4) {
        this.includeAnnotationArguments = z3;
        this.includeEmptyAnnotationArguments = z4;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    /* synthetic */ AnnotationArgumentsRenderingPolicy(boolean z3, boolean z4, int i4, u uVar) {
        this((i4 & 1) != 0 ? false : z3, (i4 & 2) != 0 ? false : z4);
    }
}
