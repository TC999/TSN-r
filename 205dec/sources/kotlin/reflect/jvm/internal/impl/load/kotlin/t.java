package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: methodSignatureBuildingUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    @NotNull
    public static final String a(@NotNull w wVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull String jvmDescriptor) {
        f0.p(wVar, "<this>");
        f0.p(classDescriptor, "classDescriptor");
        f0.p(jvmDescriptor, "jvmDescriptor");
        return wVar.k(u.f(classDescriptor), jvmDescriptor);
    }
}
