package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty0Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016B+\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u0015\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R.\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \n*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/k;", "V", "Lkotlin/reflect/jvm/internal/p;", "Lkotlin/reflect/k;", "value", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/k$a;", "kotlin.jvm.PlatformType", "o", "Lkotlin/reflect/jvm/internal/y$b;", "_setter", "U", "()Lkotlin/reflect/jvm/internal/k$a;", "setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k<V> extends p<V> implements kotlin.reflect.k<V> {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final y.b<a<V>> f58571o;

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R \u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/k$a;", "R", "Lkotlin/reflect/jvm/internal/s$d;", "Lkotlin/reflect/k$a;", "value", "Lkotlin/f1;", "P", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/k;", "h", "Lkotlin/reflect/jvm/internal/k;", "O", "()Lkotlin/reflect/jvm/internal/k;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/k;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> extends s.d<R> implements k.a<R> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final k<R> f58572h;

        public a(@NotNull k<R> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58572h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public k<R> d() {
            return this.f58572h;
        }

        public void P(R r3) {
            d().set(r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Object obj) {
            P(obj);
            return f1.f55527a;
        }
    }

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/k$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/k$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k<V> f58573a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(k<V> kVar) {
            super(0);
            this.f58573a = kVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<V> invoke() {
            return new a<>(this.f58573a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58571o = b4;
    }

    @Override // kotlin.reflect.k, kotlin.reflect.j
    @NotNull
    /* renamed from: U */
    public a<V> getSetter() {
        a<V> invoke = this.f58571o.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_setter()");
        return invoke;
    }

    @Override // kotlin.reflect.k
    public void set(V v3) {
        getSetter().call(v3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58571o = b4;
    }
}
