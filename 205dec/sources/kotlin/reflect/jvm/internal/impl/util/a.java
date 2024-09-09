package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.util.c;
import org.jetbrains.annotations.NotNull;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a {
    @NotNull
    public final c a(@NotNull w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        for (d dVar : b()) {
            if (dVar.b(functionDescriptor)) {
                return dVar.a(functionDescriptor);
            }
        }
        return c.a.f58464b;
    }

    @NotNull
    public abstract List<d> b();
}
