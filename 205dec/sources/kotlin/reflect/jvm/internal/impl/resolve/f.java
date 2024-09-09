package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberComparator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f implements Comparator<kotlin.reflect.jvm.internal.impl.descriptors.k> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f57867a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.renderer.b f57868b = kotlin.reflect.jvm.internal.impl.renderer.b.f57723a.b(new a());

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ boolean f57869c = false;

    /* compiled from: MemberComparator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {
        a() {
        }

        @Override // d2.l
        /* renamed from: a */
        public f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            dVar.c(false);
            dVar.n(true);
            dVar.h(AnnotationArgumentsRenderingPolicy.UNLESS_EMPTY);
            dVar.m(DescriptorRendererModifier.ALL);
            return f1.f55527a;
        }
    }

    /* compiled from: MemberComparator.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements Comparator<kotlin.reflect.jvm.internal.impl.descriptors.k> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57870a = new b();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static Integer c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            int d4 = d(kVar2) - d(kVar);
            if (d4 != 0) {
                return Integer.valueOf(d4);
            }
            if (d.B(kVar) && d.B(kVar2)) {
                return 0;
            }
            int compareTo = kVar.getName().compareTo(kVar2.getName());
            if (compareTo != 0) {
                return Integer.valueOf(compareTo);
            }
            return null;
        }

        private static int d(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (d.B(kVar)) {
                return 8;
            }
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.j) {
                return 7;
            }
            if (kVar instanceof p0) {
                return ((p0) kVar).Q() == null ? 6 : 5;
            } else if (kVar instanceof w) {
                return ((w) kVar).Q() == null ? 4 : 3;
            } else if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return 2;
            } else {
                return kVar instanceof z0 ? 1 : 0;
            }
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
            Integer c4 = c(kVar, kVar2);
            if (c4 != null) {
                return c4.intValue();
            }
            return 0;
        }
    }

    private f() {
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2) {
        int ordinal;
        Integer c4 = b.c(kVar, kVar2);
        if (c4 != null) {
            return c4.intValue();
        }
        if ((kVar instanceof z0) && (kVar2 instanceof z0)) {
            kotlin.reflect.jvm.internal.impl.renderer.b bVar = f57868b;
            int compareTo = bVar.y(((z0) kVar).r0()).compareTo(bVar.y(((z0) kVar2).r0()));
            if (compareTo != 0) {
                return compareTo;
            }
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar;
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) kVar2;
            s0 Q = aVar.Q();
            s0 Q2 = aVar2.Q();
            if (Q != null) {
                kotlin.reflect.jvm.internal.impl.renderer.b bVar2 = f57868b;
                int compareTo2 = bVar2.y(Q.getType()).compareTo(bVar2.y(Q2.getType()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
            }
            List<d1> h4 = aVar.h();
            List<d1> h5 = aVar2.h();
            for (int i4 = 0; i4 < Math.min(h4.size(), h5.size()); i4++) {
                kotlin.reflect.jvm.internal.impl.renderer.b bVar3 = f57868b;
                int compareTo3 = bVar3.y(h4.get(i4).getType()).compareTo(bVar3.y(h5.get(i4).getType()));
                if (compareTo3 != 0) {
                    return compareTo3;
                }
            }
            int size = h4.size() - h5.size();
            if (size != 0) {
                return size;
            }
            List<a1> typeParameters = aVar.getTypeParameters();
            List<a1> typeParameters2 = aVar2.getTypeParameters();
            for (int i5 = 0; i5 < Math.min(typeParameters.size(), typeParameters2.size()); i5++) {
                List<e0> upperBounds = typeParameters.get(i5).getUpperBounds();
                List<e0> upperBounds2 = typeParameters2.get(i5).getUpperBounds();
                int size2 = upperBounds.size() - upperBounds2.size();
                if (size2 != 0) {
                    return size2;
                }
                for (int i6 = 0; i6 < upperBounds.size(); i6++) {
                    kotlin.reflect.jvm.internal.impl.renderer.b bVar4 = f57868b;
                    int compareTo4 = bVar4.y(upperBounds.get(i6)).compareTo(bVar4.y(upperBounds2.get(i6)));
                    if (compareTo4 != 0) {
                        return compareTo4;
                    }
                }
            }
            int size3 = typeParameters.size() - typeParameters2.size();
            if (size3 != 0) {
                return size3;
            }
            if ((aVar instanceof CallableMemberDescriptor) && (aVar2 instanceof CallableMemberDescriptor) && (ordinal = ((CallableMemberDescriptor) aVar).i().ordinal() - ((CallableMemberDescriptor) aVar2).i().ordinal()) != 0) {
                return ordinal;
            }
        } else if ((kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && (kVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar;
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.d) kVar2;
            if (dVar.i().ordinal() != dVar2.i().ordinal()) {
                return dVar.i().ordinal() - dVar2.i().ordinal();
            }
            if (dVar.a0() != dVar2.a0()) {
                return dVar.a0() ? 1 : -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", kVar, kVar.getClass(), kVar2, kVar2.getClass()));
        }
        kotlin.reflect.jvm.internal.impl.renderer.b bVar5 = f57868b;
        int compareTo5 = bVar5.s(kVar).compareTo(bVar5.s(kVar2));
        return compareTo5 != 0 ? compareTo5 : d.g(kVar).getName().compareTo(d.g(kVar2).getName());
    }
}
