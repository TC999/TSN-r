package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u0;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KTypeParameterImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004*\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007*\u00020\u0006H\u0002J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0014\u0010\"\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lkotlin/reflect/jvm/internal/v;", "Lkotlin/reflect/s;", "Lkotlin/reflect/jvm/internal/i;", "Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "Lkotlin/reflect/jvm/internal/h;", "c", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/g;", "Ljava/lang/Class;", "a", "", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/reflect/jvm/internal/impl/descriptors/a1;", "Lkotlin/reflect/jvm/internal/impl/descriptors/a1;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "descriptor", "", "Lkotlin/reflect/r;", "b", "Lkotlin/reflect/jvm/internal/y$a;", "getUpperBounds", "()Ljava/util/List;", "upperBounds", "Lkotlin/reflect/jvm/internal/w;", "Lkotlin/reflect/jvm/internal/w;", "container", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/KVariance;", "o", "()Lkotlin/reflect/KVariance;", "variance", "l", "()Z", "isReified", "<init>", "(Lkotlin/reflect/jvm/internal/w;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v implements kotlin.reflect.s, i {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f58673d = {n0.u(new PropertyReference1Impl(n0.d(v.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a1 f58674a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final y.a f58675b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final w f58676c;

    /* compiled from: KTypeParameterImpl.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58677a;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            f58677a = iArr;
        }
    }

    /* compiled from: KTypeParameterImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlin/reflect/jvm/internal/u;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<List<? extends u>> {
        b() {
            super(0);
        }

        @Override // d2.a
        public final List<? extends u> invoke() {
            int Z;
            List<kotlin.reflect.jvm.internal.impl.types.e0> upperBounds = v.this.e().getUpperBounds();
            kotlin.jvm.internal.f0.o(upperBounds, "descriptor.upperBounds");
            Z = kotlin.collections.y.Z(upperBounds, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.types.e0 e0Var : upperBounds) {
                arrayList.add(new u(e0Var, null, 2, null));
            }
            return arrayList;
        }
    }

    public v(@Nullable w wVar, @NotNull a1 descriptor) {
        h<?> hVar;
        Object C;
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        this.f58674a = descriptor;
        this.f58675b = y.c(new b());
        if (wVar == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.k b4 = e().b();
            kotlin.jvm.internal.f0.o(b4, "descriptor.containingDeclaration");
            if (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                C = c((kotlin.reflect.jvm.internal.impl.descriptors.d) b4);
            } else if (b4 instanceof CallableMemberDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.k b5 = ((CallableMemberDescriptor) b4).b();
                kotlin.jvm.internal.f0.o(b5, "declaration.containingDeclaration");
                if (b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                    hVar = c((kotlin.reflect.jvm.internal.impl.descriptors.d) b5);
                } else {
                    kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar = b4 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g ? (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g) b4 : null;
                    if (gVar != null) {
                        hVar = (h) c2.a.g(a(gVar));
                    } else {
                        throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Non-class callable descriptor must be deserialized: ", b4));
                    }
                }
                C = b4.C(new kotlin.reflect.jvm.internal.a(hVar), f1.f55527a);
            } else {
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Unknown type parameter container: ", b4));
            }
            kotlin.jvm.internal.f0.o(C, "when (val declaration = \u2026 $declaration\")\n        }");
            wVar = (w) C;
        }
        this.f58676c = wVar;
    }

    private final Class<?> a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.g gVar) {
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.f K = gVar.K();
        if (!(K instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.j)) {
            K = null;
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.j jVar = (kotlin.reflect.jvm.internal.impl.load.kotlin.j) K;
        kotlin.reflect.jvm.internal.impl.load.kotlin.p f4 = jVar == null ? null : jVar.f();
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f fVar = f4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f ? f4 : null;
        if (fVar != null) {
            return fVar.a();
        }
        throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Container of deserialized member is not resolved: ", gVar));
    }

    private final h<?> c(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        Class<?> p3 = f0.p(dVar);
        h<?> hVar = (h) (p3 == null ? null : c2.a.g(p3));
        if (hVar != null) {
            return hVar;
        }
        throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Type parameter container is not resolved: ", dVar.b()));
    }

    @Override // kotlin.reflect.jvm.internal.i
    @NotNull
    /* renamed from: b */
    public a1 e() {
        return this.f58674a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (kotlin.jvm.internal.f0.g(this.f58676c, vVar.f58676c) && kotlin.jvm.internal.f0.g(getName(), vVar.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public String getName() {
        String b4 = e().getName().b();
        kotlin.jvm.internal.f0.o(b4, "descriptor.name.asString()");
        return b4;
    }

    @Override // kotlin.reflect.s
    @NotNull
    public List<kotlin.reflect.r> getUpperBounds() {
        Object b4 = this.f58675b.b(this, f58673d[0]);
        kotlin.jvm.internal.f0.o(b4, "<get-upperBounds>(...)");
        return (List) b4;
    }

    public int hashCode() {
        return (this.f58676c.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.s
    public boolean l() {
        return e().l();
    }

    @Override // kotlin.reflect.s
    @NotNull
    public KVariance o() {
        int i4 = a.f58677a[e().o().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return KVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return KVariance.IN;
        }
        return KVariance.INVARIANT;
    }

    @NotNull
    public String toString() {
        return u0.f55683f.a(this);
    }
}
