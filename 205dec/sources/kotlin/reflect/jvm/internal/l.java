package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty1Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B+\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\b\u0010\tR:\u0010\u000f\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \f*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/l;", "T", "V", "Lkotlin/reflect/jvm/internal/q;", "Lkotlin/reflect/l;", "receiver", "value", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/l$a;", "kotlin.jvm.PlatformType", "o", "Lkotlin/reflect/jvm/internal/y$b;", "_setter", "U", "()Lkotlin/reflect/jvm/internal/l$a;", "setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l<T, V> extends q<T, V> implements kotlin.reflect.l<T, V> {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final y.b<a<T, V>> f58574o;

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/l$a;", "T", "V", "Lkotlin/reflect/jvm/internal/s$d;", "Lkotlin/reflect/l$a;", "receiver", "value", "Lkotlin/f1;", "P", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/l;", "h", "Lkotlin/reflect/jvm/internal/l;", "O", "()Lkotlin/reflect/jvm/internal/l;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/l;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, V> extends s.d<V> implements l.a<T, V> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final l<T, V> f58575h;

        public a(@NotNull l<T, V> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58575h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public l<T, V> d() {
            return this.f58575h;
        }

        public void P(T t3, V v3) {
            d().set(t3, v3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.p
        public /* bridge */ /* synthetic */ f1 invoke(Object obj, Object obj2) {
            P(obj, obj2);
            return f1.f55527a;
        }
    }

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "V", "Lkotlin/reflect/jvm/internal/l$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/l$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<T, V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l<T, V> f58576a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(l<T, V> lVar) {
            super(0);
            this.f58576a = lVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<T, V> invoke() {
            return new a<>(this.f58576a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<T, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58574o = b4;
    }

    @Override // kotlin.reflect.l, kotlin.reflect.j
    @NotNull
    /* renamed from: U */
    public a<T, V> getSetter() {
        a<T, V> invoke = this.f58574o.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_setter()");
        return invoke;
    }

    @Override // kotlin.reflect.l
    public void set(T t3, V v3) {
        getSetter().call(t3, v3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<T, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58574o = b4;
    }
}
