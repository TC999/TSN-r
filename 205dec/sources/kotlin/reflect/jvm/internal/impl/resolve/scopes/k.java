package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ResolutionScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface k {

    /* compiled from: ResolutionScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(k kVar, d dVar, d2.l lVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    dVar = d.f57902o;
                }
                d2.l<kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar2 = lVar;
                if ((i4 & 2) != 0) {
                    lVar2 = h.f57927a.a();
                }
                return kVar.f(dVar, lVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void b(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            f0.p(kVar, "this");
            f0.p(name, "name");
            f0.p(location, "location");
            kVar.a(name, location);
        }
    }

    @NotNull
    Collection<? extends w> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

    void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull d dVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);
}
