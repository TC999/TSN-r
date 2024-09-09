package kotlin.reflect.jvm.internal;

import com.acse.ottn.f3;
import java.lang.reflect.Member;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KProperty1Impl.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001#B\u0019\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001c\u0010\"J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\n\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\n\u0010\u0007R:\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \r*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f0\f0\u000b8\bX\u0088\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0016\u00a8\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/q;", "T", "V", "Lkotlin/reflect/p;", "Lkotlin/reflect/jvm/internal/s;", "receiver", f3.f5657f, "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/reflect/jvm/internal/y$b;", "Lkotlin/reflect/jvm/internal/q$a;", "kotlin.jvm.PlatformType", "m", "Lkotlin/reflect/jvm/internal/y$b;", "_getter", "Lkotlin/p;", "Ljava/lang/reflect/Member;", "n", "Lkotlin/p;", "delegateSource", "()Lkotlin/reflect/jvm/internal/q$a;", "getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "a", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q<T, V> extends s<V> implements kotlin.reflect.p<T, V> {
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final y.b<a<T, V>> f58630m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.p<Member> f58631n;

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/q$a;", "T", "V", "Lkotlin/reflect/jvm/internal/s$c;", "Lkotlin/reflect/p$a;", "receiver", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/q;", "h", "Lkotlin/reflect/jvm/internal/q;", "O", "()Lkotlin/reflect/jvm/internal/q;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/q;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, V> extends s.c<V> implements p.a<T, V> {
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final q<T, V> f58632h;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull q<T, ? extends V> property) {
            kotlin.jvm.internal.f0.p(property, "property");
            this.f58632h = property;
        }

        @Override // kotlin.reflect.n.a
        @NotNull
        /* renamed from: O */
        public q<T, V> d() {
            return this.f58632h;
        }

        @Override // d2.l
        public V invoke(T t3) {
            return d().get(t3);
        }
    }

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0003*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "V", "Lkotlin/reflect/jvm/internal/q$a;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/q$a;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.a<a<T, ? extends V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q<T, V> f58633a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(q<T, ? extends V> qVar) {
            super(0);
            this.f58633a = qVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final a<T, V> invoke() {
            return new a<>(this.f58633a);
        }
    }

    /* compiled from: KProperty1Impl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "V", "Ljava/lang/reflect/Member;", "a", "()Ljava/lang/reflect/Member;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Member> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ q<T, V> f58634a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(q<T, ? extends V> qVar) {
            super(0);
            this.f58634a = qVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Member invoke() {
            return this.f58634a.M();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.p<Member> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        y.b<a<T, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58630m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58631n = c4;
    }

    @Override // kotlin.reflect.n
    @NotNull
    /* renamed from: T */
    public a<T, V> getGetter() {
        a<T, V> invoke = this.f58630m.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_getter()");
        return invoke;
    }

    @Override // kotlin.reflect.p
    public V get(T t3) {
        return getGetter().call(t3);
    }

    @Override // kotlin.reflect.p
    @Nullable
    public Object getDelegate(T t3) {
        return O(this.f58631n.getValue(), t3, null);
    }

    @Override // d2.l
    public V invoke(T t3) {
        return get(t3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@NotNull KDeclarationContainerImpl container, @NotNull p0 descriptor) {
        super(container, descriptor);
        kotlin.p<Member> c4;
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        y.b<a<T, V>> b4 = y.b(new b(this));
        kotlin.jvm.internal.f0.o(b4, "lazy { Getter(this) }");
        this.f58630m = b4;
        c4 = kotlin.r.c(LazyThreadSafetyMode.PUBLICATION, new c(this));
        this.f58631n = c4;
    }
}
