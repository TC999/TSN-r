package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.i;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.util.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class e implements b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f58475a = new e();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f58476b = "second parameter must be of type KProperty<*> or its supertype";

    private e() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @Nullable
    public String a(@NotNull w wVar) {
        return b.a.a(this, wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    public boolean b(@NotNull w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        d1 secondParameter = functionDescriptor.h().get(1);
        i.b bVar = kotlin.reflect.jvm.internal.impl.builtins.i.f56058k;
        f0.o(secondParameter, "secondParameter");
        e0 a4 = bVar.a(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(secondParameter));
        if (a4 == null) {
            return false;
        }
        e0 type = secondParameter.getType();
        f0.o(type, "secondParameter.type");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.a.m(a4, kotlin.reflect.jvm.internal.impl.types.typeUtil.a.p(type));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public String getDescription() {
        return f58476b;
    }
}
