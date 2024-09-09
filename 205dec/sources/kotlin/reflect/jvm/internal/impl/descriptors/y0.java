package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* compiled from: SupertypeLoopChecker.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface y0 {

    /* compiled from: SupertypeLoopChecker.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements y0 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f56639a = new a();

        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y0
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.types.e0> a(@NotNull kotlin.reflect.jvm.internal.impl.types.y0 currentTypeConstructor, @NotNull Collection<? extends kotlin.reflect.jvm.internal.impl.types.e0> superTypes, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.y0, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.e0>> neighbors, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.e0, kotlin.f1> reportLoop) {
            kotlin.jvm.internal.f0.p(currentTypeConstructor, "currentTypeConstructor");
            kotlin.jvm.internal.f0.p(superTypes, "superTypes");
            kotlin.jvm.internal.f0.p(neighbors, "neighbors");
            kotlin.jvm.internal.f0.p(reportLoop, "reportLoop");
            return superTypes;
        }
    }

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.types.e0> a(@NotNull kotlin.reflect.jvm.internal.impl.types.y0 y0Var, @NotNull Collection<? extends kotlin.reflect.jvm.internal.impl.types.e0> collection, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.y0, ? extends Iterable<? extends kotlin.reflect.jvm.internal.impl.types.e0>> lVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.types.e0, kotlin.f1> lVar2);
}
