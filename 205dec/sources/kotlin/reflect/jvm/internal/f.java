package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.m0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KCallableImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\bM\u0010NJ%\u0010\b\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J'\u0010\u0010\u001a\u00028\u00002\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u000f\"\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016\u00a2\u0006\u0004\b\u0012\u0010\tJ3\u0010\u0015\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R.\u0010\u001d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0019 \u001a*\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR.\u0010 \u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u001a*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001e0\u001e0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\"\u0010#\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010!0!0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR.\u0010&\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020$ \u001a*\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001cR\u0018\u0010*\u001a\u0006\u0012\u0002\b\u00030'8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010'8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u00100\u001a\u00020-8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u0010<\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u00106R\u0016\u0010C\u001a\u0004\u0018\u00010@8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u0002018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u00103R\u0014\u0010E\u001a\u0002018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u00103R\u0014\u0010F\u001a\u0002018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u00103R\u0014\u0010H\u001a\u0002018DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u00103R\u0014\u0010L\u001a\u00020I8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u0010K\u00a8\u0006O"}, d2 = {"Lkotlin/reflect/jvm/internal/f;", "R", "Lkotlin/reflect/c;", "Lkotlin/reflect/jvm/internal/w;", "", "Lkotlin/reflect/KParameter;", "", "args", "h", "(Ljava/util/Map;)Ljava/lang/Object;", "Lkotlin/reflect/r;", "type", "o", "Ljava/lang/reflect/Type;", "x", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "Lkotlin/coroutines/c;", "continuationArgument", "l", "(Ljava/util/Map;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/y$a;", "", "", "kotlin.jvm.PlatformType", "a", "Lkotlin/reflect/jvm/internal/y$a;", "_annotations", "Ljava/util/ArrayList;", "b", "_parameters", "Lkotlin/reflect/jvm/internal/u;", "c", "_returnType", "Lkotlin/reflect/jvm/internal/v;", "d", "_typeParameters", "Lkotlin/reflect/jvm/internal/calls/c;", "F", "()Lkotlin/reflect/jvm/internal/calls/c;", "caller", "H", "defaultCaller", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "G", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "K", "()Z", "isBound", "getAnnotations", "()Ljava/util/List;", "annotations", "getParameters", "parameters", "getReturnType", "()Lkotlin/reflect/r;", "returnType", "Lkotlin/reflect/s;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "isFinal", "isOpen", "isAbstract", "J", "isAnnotationConstructor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class f<R> implements kotlin.reflect.c<R>, w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final y.a<List<Annotation>> f55941a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final y.a<ArrayList<KParameter>> f55942b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final y.a<u> f55943c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final y.a<List<v>> f55944d;

    /* compiled from: KCallableImpl.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends Annotation>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f<R> f55945a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(f<? extends R> fVar) {
            super(0);
            this.f55945a = fVar;
        }

        @Override // d2.a
        public final List<? extends Annotation> invoke() {
            return f0.e(this.f55945a.I());
        }
    }

    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "a", "()Ljava/util/ArrayList;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<ArrayList<KParameter>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f<R> f55946a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KCallableImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/m0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/m0;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.a<m0> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s0 f55947a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(s0 s0Var) {
                super(0);
                this.f55947a = s0Var;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final m0 invoke() {
                return this.f55947a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KCallableImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/m0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/m0;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.f$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1115b extends Lambda implements d2.a<m0> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ s0 f55948a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1115b(s0 s0Var) {
                super(0);
                this.f55948a = s0Var;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final m0 invoke() {
                return this.f55948a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KCallableImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/impl/descriptors/m0;", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/m0;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends Lambda implements d2.a<m0> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CallableMemberDescriptor f55949a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f55950b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(CallableMemberDescriptor callableMemberDescriptor, int i4) {
                super(0);
                this.f55949a = callableMemberDescriptor;
                this.f55950b = i4;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final m0 invoke() {
                d1 d1Var = this.f55949a.h().get(this.f55950b);
                kotlin.jvm.internal.f0.o(d1Var, "descriptor.valueParameters[i]");
                return d1Var;
            }
        }

        /* compiled from: Comparisons.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class d<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int g4;
                g4 = kotlin.comparisons.b.g(((KParameter) t3).getName(), ((KParameter) t4).getName());
                return g4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(f<? extends R> fVar) {
            super(0);
            this.f55946a = fVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final ArrayList<KParameter> invoke() {
            int i4;
            CallableMemberDescriptor I = this.f55946a.I();
            ArrayList<KParameter> arrayList = new ArrayList<>();
            int i5 = 0;
            if (this.f55946a.K()) {
                i4 = 0;
            } else {
                s0 i6 = f0.i(I);
                if (i6 != null) {
                    arrayList.add(new o(this.f55946a, 0, KParameter.Kind.INSTANCE, new a(i6)));
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                s0 Q = I.Q();
                if (Q != null) {
                    arrayList.add(new o(this.f55946a, i4, KParameter.Kind.EXTENSION_RECEIVER, new C1115b(Q)));
                    i4++;
                }
            }
            int size = I.h().size();
            while (i5 < size) {
                arrayList.add(new o(this.f55946a, i4, KParameter.Kind.VALUE, new c(I, i5)));
                i5++;
                i4++;
            }
            if (this.f55946a.J() && (I instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.a) && arrayList.size() > 1) {
                kotlin.collections.b0.n0(arrayList, new d());
            }
            arrayList.trimToSize();
            return arrayList;
        }
    }

    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlin/reflect/jvm/internal/u;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/u;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<u> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f<R> f55951a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: KCallableImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "Ljava/lang/reflect/Type;", "a", "()Ljava/lang/reflect/Type;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.a<Type> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f<R> f55952a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(f<? extends R> fVar) {
                super(0);
                this.f55952a = fVar;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Type invoke() {
                Type x3 = this.f55952a.x();
                return x3 == null ? this.f55952a.F().getReturnType() : x3;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(f<? extends R> fVar) {
            super(0);
            this.f55951a = fVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final u invoke() {
            kotlin.reflect.jvm.internal.impl.types.e0 returnType = this.f55951a.I().getReturnType();
            kotlin.jvm.internal.f0.m(returnType);
            kotlin.jvm.internal.f0.o(returnType, "descriptor.returnType!!");
            return new u(returnType, new a(this.f55951a));
        }
    }

    /* compiled from: KCallableImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "Lkotlin/reflect/jvm/internal/v;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<List<? extends v>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f<R> f55953a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(f<? extends R> fVar) {
            super(0);
            this.f55953a = fVar;
        }

        @Override // d2.a
        public final List<? extends v> invoke() {
            int Z;
            List<a1> typeParameters = this.f55953a.I().getTypeParameters();
            kotlin.jvm.internal.f0.o(typeParameters, "descriptor.typeParameters");
            f<R> fVar = this.f55953a;
            Z = kotlin.collections.y.Z(typeParameters, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (a1 descriptor : typeParameters) {
                kotlin.jvm.internal.f0.o(descriptor, "descriptor");
                arrayList.add(new v(fVar, descriptor));
            }
            return arrayList;
        }
    }

    public f() {
        y.a<List<Annotation>> c4 = y.c(new a(this));
        kotlin.jvm.internal.f0.o(c4, "lazySoft { descriptor.computeAnnotations() }");
        this.f55941a = c4;
        y.a<ArrayList<KParameter>> c5 = y.c(new b(this));
        kotlin.jvm.internal.f0.o(c5, "lazySoft {\n        val d\u2026ze()\n        result\n    }");
        this.f55942b = c5;
        y.a<u> c6 = y.c(new c(this));
        kotlin.jvm.internal.f0.o(c6, "lazySoft {\n        KType\u2026eturnType\n        }\n    }");
        this.f55943c = c6;
        y.a<List<v>> c7 = y.c(new d(this));
        kotlin.jvm.internal.f0.o(c7, "lazySoft {\n        descr\u2026this, descriptor) }\n    }");
        this.f55944d = c7;
    }

    private final R h(Map<KParameter, ? extends Object> map) {
        int Z;
        Object o4;
        List<KParameter> parameters = getParameters();
        Z = kotlin.collections.y.Z(parameters, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                o4 = map.get(kParameter);
                if (o4 == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.w()) {
                o4 = null;
            } else if (!kParameter.k()) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("No argument provided for a required parameter: ", kParameter));
            } else {
                o4 = o(kParameter.getType());
            }
            arrayList.add(o4);
        }
        kotlin.reflect.jvm.internal.calls.c<?> H = H();
        if (H != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    return (R) H.call(array);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            } catch (IllegalAccessException e4) {
                throw new IllegalCallableAccessException(e4);
            }
        }
        throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("This callable does not support a default call: ", I()));
    }

    private final Object o(kotlin.reflect.r rVar) {
        Class c4 = c2.a.c(kotlin.reflect.jvm.c.b(rVar));
        if (c4.isArray()) {
            Object newInstance = Array.newInstance(c4.getComponentType(), 0);
            kotlin.jvm.internal.f0.o(newInstance, "type.jvmErasure.java.run\u2026\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + ((Object) c4.getSimpleName()) + ", because it is not an array type");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Type x() {
        Object g32;
        Object Cs;
        Type[] lowerBounds;
        Object ob;
        CallableMemberDescriptor I = I();
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar = I instanceof kotlin.reflect.jvm.internal.impl.descriptors.w ? (kotlin.reflect.jvm.internal.impl.descriptors.w) I : null;
        boolean z3 = false;
        if (wVar != null && wVar.isSuspend()) {
            z3 = true;
        }
        if (z3) {
            g32 = kotlin.collections.f0.g3(F().a());
            ParameterizedType parameterizedType = g32 instanceof ParameterizedType ? (ParameterizedType) g32 : null;
            if (kotlin.jvm.internal.f0.g(parameterizedType == null ? null : parameterizedType.getRawType(), kotlin.coroutines.c.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.f0.o(actualTypeArguments, "continuationType.actualTypeArguments");
                Cs = kotlin.collections.p.Cs(actualTypeArguments);
                WildcardType wildcardType = Cs instanceof WildcardType ? (WildcardType) Cs : null;
                if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
                    return null;
                }
                ob = kotlin.collections.p.ob(lowerBounds);
                return (Type) ob;
            }
            return null;
        }
        return null;
    }

    @NotNull
    public abstract kotlin.reflect.jvm.internal.calls.c<?> F();

    @NotNull
    public abstract KDeclarationContainerImpl G();

    @Nullable
    public abstract kotlin.reflect.jvm.internal.calls.c<?> H();

    @NotNull
    public abstract CallableMemberDescriptor I();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J() {
        return kotlin.jvm.internal.f0.g(getName(), "<init>") && G().d().isAnnotation();
    }

    public abstract boolean K();

    @Override // kotlin.reflect.c
    public R call(@NotNull Object... args) {
        kotlin.jvm.internal.f0.p(args, "args");
        try {
            return (R) F().call(args);
        } catch (IllegalAccessException e4) {
            throw new IllegalCallableAccessException(e4);
        }
    }

    @Override // kotlin.reflect.c
    public R callBy(@NotNull Map<KParameter, ? extends Object> args) {
        kotlin.jvm.internal.f0.p(args, "args");
        return J() ? h(args) : l(args, null);
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this.f55941a.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_annotations()");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this.f55942b.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_parameters()");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public kotlin.reflect.r getReturnType() {
        u invoke = this.f55943c.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_returnType()");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        List<v> invoke = this.f55944d.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_typeParameters()");
        return invoke;
    }

    @Override // kotlin.reflect.c
    @Nullable
    public KVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s visibility = I().getVisibility();
        kotlin.jvm.internal.f0.o(visibility, "descriptor.visibility");
        return f0.q(visibility);
    }

    @Override // kotlin.reflect.c
    public boolean isAbstract() {
        return I().s() == Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.c
    public boolean isFinal() {
        return I().s() == Modality.FINAL;
    }

    @Override // kotlin.reflect.c
    public boolean isOpen() {
        return I().s() == Modality.OPEN;
    }

    public final R l(@NotNull Map<KParameter, ? extends Object> args, @Nullable kotlin.coroutines.c<?> cVar) {
        kotlin.jvm.internal.f0.p(args, "args");
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                if (cVar != null) {
                    arrayList.add(cVar);
                }
                if (!z3) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    if (array != null) {
                        return call(Arrays.copyOf(array, array.length));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                arrayList2.add(Integer.valueOf(i5));
                kotlin.reflect.jvm.internal.calls.c<?> H = H();
                if (H != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add(null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        if (array2 != null) {
                            return (R) H.call(array2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    } catch (IllegalAccessException e4) {
                        throw new IllegalCallableAccessException(e4);
                    }
                }
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("This callable does not support a default call: ", I()));
            }
            KParameter next = it.next();
            if (i4 != 0 && i4 % 32 == 0) {
                arrayList2.add(Integer.valueOf(i5));
                i5 = 0;
            }
            if (args.containsKey(next)) {
                arrayList.add(args.get(next));
            } else if (next.w()) {
                arrayList.add(f0.k(next.getType()) ? null : f0.g(kotlin.reflect.jvm.d.g(next.getType())));
                i5 = (1 << (i4 % 32)) | i5;
                z3 = true;
            } else if (next.k()) {
                arrayList.add(o(next.getType()));
            } else {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("No argument provided for a required parameter: ", next));
            }
            if (next.i() == KParameter.Kind.VALUE) {
                i4++;
            }
        }
    }
}
