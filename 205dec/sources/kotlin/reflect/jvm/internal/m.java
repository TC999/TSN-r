package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: KProperty2Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB!\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001eJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bRF\u0010\u0011\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u000e*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/m;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/r;", "Lkotlin/reflect/m;", "receiver1", "receiver2", "value", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/m$a;", "kotlin.jvm.PlatformType", "o", "Lkotlin/reflect/jvm/internal/y$b;", "_setter", "U", "()Lkotlin/reflect/jvm/internal/m$a;", "setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m<D, E, V> extends r<D, E, V> implements kotlin.reflect.m<D, E, V> {
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final y.b<a<D, E, V>> f58577o;

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0004\b\u0005\u0010\u00032\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0007\u001a\u00028\u00042\u0006\u0010\b\u001a\u00028\u0005H\u0096\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lkotlin/reflect/jvm/internal/m$a;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/s$d;", "Lkotlin/reflect/m$a;", "receiver1", "receiver2", "value", "Lkotlin/f1;", "P", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/m;", "h", "Lkotlin/reflect/jvm/internal/m;", "O", "()Lkotlin/reflect/jvm/internal/m;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/m;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<D, E, V> extends s.d<V> implements m.a<D, E, V> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final m<D, E, V> f58578h;

        public a(@NotNull m<D, E, V> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58578h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public m<D, E, V> d() {
            return this.f58578h;
        }

        public void P(D d4, E e4, V v3) {
            d().set(d4, e4, v3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.q
        public /* bridge */ /* synthetic */ f1 invoke(Object obj, Object obj2, Object obj3) {
            P(obj, obj2, obj3);
            return f1.f55527a;
        }
    }

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"D", "E", "V", "Lkotlin/reflect/jvm/internal/m$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/m$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<D, E, V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m<D, E, V> f58579a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(m<D, E, V> mVar) {
            super(0);
            this.f58579a = mVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<D, E, V> invoke() {
            return new a<>(this.f58579a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature) {
        super(container, name, signature);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<D, E, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58577o = b4;
    }

    @Override // kotlin.reflect.m, kotlin.reflect.j
    @NotNull
    /* renamed from: U */
    public a<D, E, V> getSetter() {
        a<D, E, V> invoke = this.f58577o.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_setter()");
        return invoke;
    }

    @Override // kotlin.reflect.m
    public void set(D d4, E e4, V v3) {
        getSetter().call(d4, e4, v3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<D, E, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Setter(this) }");
        this.f58577o = b4;
    }
}
