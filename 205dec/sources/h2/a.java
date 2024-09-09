package h2;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AdditionalClassPartsProvider.kt */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface a {

    /* compiled from: AdditionalClassPartsProvider.kt */
    /* renamed from: h2.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class C1078a implements a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final C1078a f54734a = new C1078a();

        private C1078a() {
        }

        @Override // h2.a
        @NotNull
        public Collection<u0> a(@NotNull f name, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            List F;
            f0.p(name, "name");
            f0.p(classDescriptor, "classDescriptor");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // h2.a
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            List F;
            f0.p(classDescriptor, "classDescriptor");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // h2.a
        @NotNull
        public Collection<e0> d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            List F;
            f0.p(classDescriptor, "classDescriptor");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // h2.a
        @NotNull
        public Collection<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            List F;
            f0.p(classDescriptor, "classDescriptor");
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
    }

    @NotNull
    Collection<u0> a(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<e0> d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);
}
