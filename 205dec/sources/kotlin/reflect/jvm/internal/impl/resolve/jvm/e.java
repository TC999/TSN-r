package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: SyntheticJavaPartsProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f57880a = a.f57881a;

    /* compiled from: SyntheticJavaPartsProvider.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f57881a = new a();
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private static final kotlin.reflect.jvm.internal.impl.resolve.jvm.a f57882b;

        static {
            List F;
            F = CollectionsKt__CollectionsKt.F();
            f57882b = new kotlin.reflect.jvm.internal.impl.resolve.jvm.a(F);
        }

        private a() {
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.jvm.a a() {
            return f57882b;
        }
    }

    @NotNull
    List<f> a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.c> list);

    void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f fVar, @NotNull Collection<u0> collection);

    void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull f fVar, @NotNull Collection<u0> collection);

    @NotNull
    List<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);
}
