package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import org.jetbrains.annotations.NotNull;

/* compiled from: VisibilityUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n {
    @NotNull
    public static final CallableMemberDescriptor a(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        Integer d4;
        f0.p(descriptors, "descriptors");
        descriptors.isEmpty();
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : descriptors) {
            if (callableMemberDescriptor == null || ((d4 = r.d(callableMemberDescriptor.getVisibility(), callableMemberDescriptor2.getVisibility())) != null && d4.intValue() < 0)) {
                callableMemberDescriptor = callableMemberDescriptor2;
            }
        }
        f0.m(callableMemberDescriptor);
        return callableMemberDescriptor;
    }
}
