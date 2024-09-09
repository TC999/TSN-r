package io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.PlatformDependent")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class PlatformDependentSubstitution {
    @RecomputeFieldValue(declClass = byte[].class, kind = RecomputeFieldValue.Kind.ArrayBaseOffset)
    @Alias
    private static long BYTE_ARRAY_BASE_OFFSET;

    private PlatformDependentSubstitution() {
    }
}
