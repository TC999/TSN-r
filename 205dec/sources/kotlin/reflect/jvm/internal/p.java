package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty0Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001!B\u0019\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bB+\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001a\u0010 J\u000f\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\u0005R.\u0010\u000e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u000b*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\n0\t8\bX\u0088\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/p;", "V", "Lkotlin/reflect/o;", "Lkotlin/reflect/jvm/internal/s;", f3.f5657f, "()Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/p$a;", "kotlin.jvm.PlatformType", "m", "Lkotlin/reflect/jvm/internal/y$b;", "_getter", "Lkotlin/p;", "n", "Lkotlin/p;", "delegateValue", "T", "()Lkotlin/reflect/jvm/internal/p$a;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class p<V> extends s<V> implements kotlin.reflect.o<V> {
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final y.b<a<V>> f58607m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.p<Object> f58608n;

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0004\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/p$a;", "R", "Lkotlin/reflect/jvm/internal/s$c;", "Lkotlin/reflect/o$a;", "invoke", "()Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/p;", "h", "Lkotlin/reflect/jvm/internal/p;", "O", "()Lkotlin/reflect/jvm/internal/p;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/p;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<R> extends s.c<R> implements o.a<R> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final p<R> f58609h;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull p<? extends R> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58609h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public p<R> d() {
            return this.f58609h;
        }

        @Override // d2.a
        public R invoke() {
            return d().get();
        }
    }

    /* compiled from: KProperty0Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/p$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/p$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<? extends V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p<V> f58610a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(p<? extends V> pVar) {
            super(0);
            this.f58610a = pVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<V> invoke() {
            return new a<>(this.f58610a);
        }
    }

    /* compiled from: KProperty0Impl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p<V> f58611a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(p<? extends V> pVar) {
            super(0);
            this.f58611a = pVar;
        }

        @Override // d2.a
        @Nullable
        public final Object invoke() {
            p<V> pVar = this.f58611a;
            return pVar.O(pVar.M(), null, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.p<Object> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58607m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58608n = c4;
    }

    @Override // kotlin.reflect.n
    @NotNull
    /* renamed from: T */
    public a<V> getGetter() {
        a<V> invoke = this.f58607m.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_getter()");
        return invoke;
    }

    @Override // kotlin.reflect.o
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.o
    @Nullable
    public Object getDelegate() {
        return this.f58608n.getValue();
    }

    @Override // d2.a
    public V invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.p<Object> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58607m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58608n = c4;
    }
}
