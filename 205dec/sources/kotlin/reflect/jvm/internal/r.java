package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import java.lang.reflect.Member;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty2Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0006\b\u0002\u0010\u0003 \u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005:\u0001%B\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 B!\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020!\u00a2\u0006\u0004\b\u001f\u0010$J\u001f\u0010\b\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u000b\u0010\tJ \u0010\f\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\f\u0010\tRF\u0010\u0012\u001a4\u00120\u0012.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u000f*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u000e0\u000e0\r8\bX\u0088\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2 = {"Lkotlin/reflect/jvm/internal/r;", "D", "E", "V", "Lkotlin/reflect/q;", "Lkotlin/reflect/jvm/internal/s;", "receiver1", "receiver2", f3.f5657f, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/r$a;", "kotlin.jvm.PlatformType", "m", "Lkotlin/reflect/jvm/internal/y$b;", "_getter", "Lkotlin/p;", "Ljava/lang/reflect/Member;", "n", "Lkotlin/p;", "delegateSource", "T", "()Lkotlin/reflect/jvm/internal/r$a;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class r<D, E, V> extends s<V> implements kotlin.reflect.q<D, E, V> {
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final y.b<a<D, E, V>> f58635m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.p<Member> f58636n;

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0003\u0010\u0001*\u0004\b\u0004\u0010\u0002*\u0006\b\u0005\u0010\u0003 \u00012\b\u0012\u0004\u0012\u00028\u00050\u00042\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0005B!\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\b\u001a\u00028\u00052\u0006\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0007\u001a\u00028\u0004H\u0096\u0002\u00a2\u0006\u0004\b\b\u0010\tR,\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/r$a;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/s$c;", "Lkotlin/reflect/q$a;", "receiver1", "receiver2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/r;", "h", "Lkotlin/reflect/jvm/internal/r;", "O", "()Lkotlin/reflect/jvm/internal/r;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/r;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<D, E, V> extends s.c<V> implements q.a<D, E, V> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final r<D, E, V> f58637h;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull r<D, E, ? extends V> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58637h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public r<D, E, V> d() {
            return this.f58637h;
        }

        @Override // d2.p
        public V invoke(D d4, E e4) {
            return d().get(d4, e4);
        }
    }

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a.\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002 \u0004*\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"D", "E", "V", "Lkotlin/reflect/jvm/internal/r$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/r$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<D, E, ? extends V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r<D, E, V> f58638a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(r<D, E, ? extends V> rVar) {
            super(0);
            this.f58638a = rVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<D, E, V> invoke() {
            return new a<>(this.f58638a);
        }
    }

    /* compiled from: KProperty2Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"D", "E", "V", "Ljava/lang/reflect/Member;", "a", "()Ljava/lang/reflect/Member;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Member> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r<D, E, V> f58639a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(r<D, E, ? extends V> rVar) {
            super(0);
            this.f58639a = rVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Member invoke() {
            return this.f58639a.M();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature) {
        super(container, name, signature, CallableReference.NO_RECEIVER);
        kotlin.p<Member> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<D, E, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58635m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58636n = c4;
    }

    @Override // kotlin.reflect.n
    @NotNull
    /* renamed from: T */
    public a<D, E, V> getGetter() {
        a<D, E, V> invoke = this.f58635m.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_getter()");
        return invoke;
    }

    @Override // kotlin.reflect.q
    public V get(D d4, E e4) {
        return getGetter().call(d4, e4);
    }

    @Override // kotlin.reflect.q
    @Nullable
    public Object getDelegate(D d4, E e4) {
        return O(this.f58636n.getValue(), d4, e4);
    }

    @Override // d2.p
    public V invoke(D d4, E e4) {
        return get(d4, e4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.p<Member> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<D, E, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58635m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58636n = c4;
    }
}
