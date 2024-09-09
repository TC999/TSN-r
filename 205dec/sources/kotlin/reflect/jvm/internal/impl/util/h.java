package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.util.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class h implements b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f58481a = new h();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f58482b = "should not have varargs or parameters with default values";

    private h() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @Nullable
    public String a(@NotNull w wVar) {
        return b.a.a(this, wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    public boolean b(@NotNull w functionDescriptor) {
        boolean z3;
        f0.p(functionDescriptor, "functionDescriptor");
        List<d1> h4 = functionDescriptor.h();
        f0.o(h4, "functionDescriptor.valueParameters");
        if (!(h4 instanceof Collection) || !h4.isEmpty()) {
            for (d1 it : h4) {
                f0.o(it, "it");
                if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(it) || it.t0() != null) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (!z3) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public String getDescription() {
        return f58482b;
    }
}
