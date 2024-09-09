package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: SealedClassInheritorsProvider.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f57809a = new a();

    private a() {
    }

    private static final void b(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, LinkedHashSet<kotlin.reflect.jvm.internal.impl.descriptors.d> linkedHashSet, kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar, boolean z3) {
        for (kotlin.reflect.jvm.internal.impl.descriptors.k kVar : k.a.a(hVar, kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57907t, null, 2, null)) {
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
                if (dVar2.i0()) {
                    kotlin.reflect.jvm.internal.impl.name.f name = dVar2.getName();
                    f0.o(name, "descriptor.name");
                    kotlin.reflect.jvm.internal.impl.descriptors.f h4 = hVar.h(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                        dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) h4;
                    } else {
                        dVar2 = h4 instanceof z0 ? ((z0) h4).w() : null;
                    }
                }
                if (dVar2 != null) {
                    if (d.z(dVar2, dVar)) {
                        linkedHashSet.add(dVar2);
                    }
                    if (z3) {
                        kotlin.reflect.jvm.internal.impl.resolve.scopes.h U = dVar2.U();
                        f0.o(U, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        b(dVar, linkedHashSet, U, z3);
                    }
                }
            }
        }
    }

    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d sealedClass, boolean z3) {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar;
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar2;
        List F;
        f0.p(sealedClass, "sealedClass");
        if (sealedClass.s() != Modality.SEALED) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z3) {
            kVar2 = sealedClass.b();
        } else {
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.k> it = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.m(sealedClass).iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = it.next();
                if (kVar instanceof g0) {
                    break;
                }
            }
            kVar2 = kVar;
        }
        if (kVar2 instanceof g0) {
            b(sealedClass, linkedHashSet, ((g0) kVar2).p(), z3);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h U = sealedClass.U();
        f0.o(U, "sealedClass.unsubstitutedInnerClassesScope");
        b(sealedClass, linkedHashSet, U, true);
        return linkedHashSet;
    }
}
