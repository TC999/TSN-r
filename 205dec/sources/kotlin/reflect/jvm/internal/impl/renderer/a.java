package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassifierNamePolicy.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface a {

    /* compiled from: ClassifierNamePolicy.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1161a implements a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final C1161a f57720a = new C1161a();

        private C1161a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            f0.p(classifier, "classifier");
            f0.p(renderer, "renderer");
            if (classifier instanceof a1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((a1) classifier).getName();
                f0.o(name, "classifier.name");
                return renderer.x(name, false);
            }
            kotlin.reflect.jvm.internal.impl.name.d m4 = kotlin.reflect.jvm.internal.impl.resolve.d.m(classifier);
            f0.o(m4, "getFqName(classifier)");
            return renderer.w(m4);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final b f57721a = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            boolean z3;
            List X0;
            f0.p(classifier, "classifier");
            f0.p(renderer, "renderer");
            if (classifier instanceof a1) {
                kotlin.reflect.jvm.internal.impl.name.f name = ((a1) classifier).getName();
                f0.o(name, "classifier.name");
                return renderer.x(name, false);
            }
            ArrayList arrayList = new ArrayList();
            kotlin.reflect.jvm.internal.impl.descriptors.f fVar = classifier;
            do {
                arrayList.add(fVar.getName());
                k b4 = fVar.b();
                z3 = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d;
                fVar = b4;
            } while (z3);
            X0 = d0.X0(arrayList);
            return h.c(X0);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c implements a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final c f57722a = new c();

        private c() {
        }

        private final String b(kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
            kotlin.reflect.jvm.internal.impl.name.f name = fVar.getName();
            f0.o(name, "descriptor.name");
            String b4 = h.b(name);
            if (fVar instanceof a1) {
                return b4;
            }
            k b5 = fVar.b();
            f0.o(b5, "descriptor.containingDeclaration");
            String c4 = c(b5);
            if (c4 == null || f0.g(c4, "")) {
                return b4;
            }
            return ((Object) c4) + '.' + b4;
        }

        private final String c(k kVar) {
            if (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return b((kotlin.reflect.jvm.internal.impl.descriptors.f) kVar);
            }
            if (kVar instanceof g0) {
                kotlin.reflect.jvm.internal.impl.name.d j4 = ((g0) kVar).e().j();
                f0.o(j4, "descriptor.fqName.toUnsafe()");
                return h.a(j4);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.a
        @NotNull
        public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f classifier, @NotNull kotlin.reflect.jvm.internal.impl.renderer.b renderer) {
            f0.p(classifier, "classifier");
            f0.p(renderer, "renderer");
            return b(classifier);
        }
    }

    @NotNull
    String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.renderer.b bVar);
}
