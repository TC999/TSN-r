package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KParameterImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b02\u00a2\u0006\u0004\b4\u00105J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010.\u00a8\u00066"}, d2 = {"Lkotlin/reflect/jvm/internal/o;", "Lkotlin/reflect/KParameter;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/reflect/jvm/internal/f;", "a", "Lkotlin/reflect/jvm/internal/f;", "e", "()Lkotlin/reflect/jvm/internal/f;", "callable", "b", "I", "f", "()I", "index", "Lkotlin/reflect/KParameter$Kind;", "c", "Lkotlin/reflect/KParameter$Kind;", "i", "()Lkotlin/reflect/KParameter$Kind;", "kind", "Lkotlin/reflect/jvm/internal/impl/descriptors/m0;", "d", "Lkotlin/reflect/jvm/internal/y$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/r;", "getType", "()Lkotlin/reflect/r;", "type", "w", "()Z", "isOptional", "k", "isVararg", "Lkotlin/Function0;", "computeDescriptor", "<init>", "(Lkotlin/reflect/jvm/internal/f;ILkotlin/reflect/KParameter$Kind;Ld2/a;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o implements KParameter {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f58599f = {n0.u(new PropertyReference1Impl(n0.d(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(o.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f<?> f58600a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58601b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final KParameter.Kind f58602c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final y.a f58603d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final y.a f58604e;

    /* compiled from: KParameterImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends Annotation>> {
        a() {
            super(0);
        }

        @Override // d2.a
        public final List<? extends Annotation> invoke() {
            return f0.e(o.this.h());
        }
    }

    /* compiled from: KParameterImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<Type> {
        b() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Type invoke() {
            m0 h4 = o.this.h();
            if ((h4 instanceof s0) && kotlin.jvm.internal.f0.g(f0.i(o.this.e().I()), h4) && o.this.e().I().i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                Class<?> p3 = f0.p((kotlin.reflect.jvm.internal.impl.descriptors.d) o.this.e().I().b());
                if (p3 != null) {
                    return p3;
                }
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Cannot determine receiver Java type of inherited declaration: ", h4));
            }
            return o.this.e().F().a().get(o.this.f());
        }
    }

    public o(@NotNull f<?> callable, int i4, @NotNull KParameter.Kind kind, @NotNull d2.a<? extends m0> computeDescriptor) {
        kotlin.jvm.internal.f0.p(callable, "callable");
        kotlin.jvm.internal.f0.p(kind, "kind");
        kotlin.jvm.internal.f0.p(computeDescriptor, "computeDescriptor");
        this.f58600a = callable;
        this.f58601b = i4;
        this.f58602c = kind;
        this.f58603d = y.c(computeDescriptor);
        this.f58604e = y.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m0 h() {
        Object b4 = this.f58603d.b(this, f58599f[0]);
        kotlin.jvm.internal.f0.o(b4, "<get-descriptor>(...)");
        return (m0) b4;
    }

    @NotNull
    public final f<?> e() {
        return this.f58600a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (kotlin.jvm.internal.f0.g(this.f58600a, oVar.f58600a) && f() == oVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KParameter
    public int f() {
        return this.f58601b;
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        Object b4 = this.f58604e.b(this, f58599f[1]);
        kotlin.jvm.internal.f0.o(b4, "<get-annotations>(...)");
        return (List) b4;
    }

    @Override // kotlin.reflect.KParameter
    @Nullable
    public String getName() {
        m0 h4 = h();
        d1 d1Var = h4 instanceof d1 ? (d1) h4 : null;
        if (d1Var == null || d1Var.b().e0()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f name = d1Var.getName();
        kotlin.jvm.internal.f0.o(name, "valueParameter.name");
        if (name.g()) {
            return null;
        }
        return name.b();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public kotlin.reflect.r getType() {
        kotlin.reflect.jvm.internal.impl.types.e0 type = h().getType();
        kotlin.jvm.internal.f0.o(type, "descriptor.type");
        return new u(type, new b());
    }

    public int hashCode() {
        return (this.f58600a.hashCode() * 31) + Integer.valueOf(f()).hashCode();
    }

    @Override // kotlin.reflect.KParameter
    @NotNull
    public KParameter.Kind i() {
        return this.f58602c;
    }

    @Override // kotlin.reflect.KParameter
    public boolean k() {
        m0 h4 = h();
        return (h4 instanceof d1) && ((d1) h4).t0() != null;
    }

    @NotNull
    public String toString() {
        return a0.f55871a.f(this);
    }

    @Override // kotlin.reflect.KParameter
    public boolean w() {
        m0 h4 = h();
        d1 d1Var = h4 instanceof d1 ? (d1) h4 : null;
        if (d1Var == null) {
            return false;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(d1Var);
    }
}
