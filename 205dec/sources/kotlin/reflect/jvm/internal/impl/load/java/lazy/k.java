package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ModuleClassResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    public kotlin.reflect.jvm.internal.impl.resolve.jvm.c f56934a;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.j
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull m2.g javaClass) {
        f0.p(javaClass, "javaClass");
        return b().b(javaClass);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.jvm.c b() {
        kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar = this.f56934a;
        if (cVar != null) {
            return cVar;
        }
        f0.S("resolver");
        return null;
    }

    public final void c(@NotNull kotlin.reflect.jvm.internal.impl.resolve.jvm.c cVar) {
        f0.p(cVar, "<set-?>");
        this.f56934a = cVar;
    }
}
