package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Set;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: CompanionObjectMappingUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    public static final boolean a(@NotNull c cVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
        boolean H1;
        f0.p(cVar, "<this>");
        f0.p(classDescriptor, "classDescriptor");
        if (kotlin.reflect.jvm.internal.impl.resolve.d.x(classDescriptor)) {
            Set<kotlin.reflect.jvm.internal.impl.name.b> b4 = cVar.b();
            kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(classDescriptor);
            H1 = kotlin.collections.f0.H1(b4, h4 == null ? null : h4.g());
            if (H1) {
                return true;
            }
        }
        return false;
    }
}
