package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Channel.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u000b\u001eB\u0016\b\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0010\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00198F\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/m0;", "T", "", "", "m", "(Ljava/lang/Object;)Ljava/lang/String;", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Object;", "holder", "l", "(Ljava/lang/Object;)Z", "isClosed", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue$annotations", "()V", "value", "j", "getValueOrNull$annotations", "valueOrNull", "", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getCloseCause$annotations", "closeCause", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m0<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f59459b = new b(null);

    /* renamed from: a  reason: collision with root package name */
    private final Object f59460a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Channel.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/m0$a;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @JvmField
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f59461a;

        public a(@Nullable Throwable th) {
            this.f59461a = th;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.f0.g(this.f59461a, ((a) obj).f59461a);
        }

        public int hashCode() {
            Throwable th = this.f59461a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Closed(" + this.f59461a + ')';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Channel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\u0080\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0001\u0010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0080\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/m0$b;", "", "E", "value", "Lkotlinx/coroutines/channels/m0;", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "cause", "a", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        @NotNull
        public final <E> Object a(@Nullable Throwable th) {
            return m0.b(new a(th));
        }

        @NotNull
        public final <E> Object b(E e4) {
            return m0.b(e4);
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    private /* synthetic */ m0(@Nullable Object obj) {
        this.f59460a = obj;
    }

    @NotNull
    public static final /* synthetic */ m0 a(@Nullable Object obj) {
        return new m0(obj);
    }

    @NotNull
    public static Object b(@Nullable Object obj) {
        return obj;
    }

    public static boolean c(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof m0) && kotlin.jvm.internal.f0.g(obj, ((m0) obj2).n());
    }

    public static final boolean d(@Nullable Object obj, @Nullable Object obj2) {
        return kotlin.jvm.internal.f0.g(obj, obj2);
    }

    public static /* synthetic */ void e() {
    }

    @Nullable
    public static final Throwable f(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).f59461a;
        }
        throw new IllegalStateException("Channel was not closed".toString());
    }

    public static /* synthetic */ void g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T h(Object obj) {
        if (obj instanceof a) {
            throw new IllegalStateException("Channel was closed".toString());
        }
        return obj;
    }

    public static /* synthetic */ void i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final T j(Object obj) {
        if (obj instanceof a) {
            return null;
        }
        return obj;
    }

    public static int k(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final boolean l(Object obj) {
        return obj instanceof a;
    }

    @NotNull
    public static String m(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f59460a, obj);
    }

    public int hashCode() {
        return k(this.f59460a);
    }

    @Nullable
    public final /* synthetic */ Object n() {
        return this.f59460a;
    }

    @NotNull
    public String toString() {
        return m(this.f59460a);
    }
}
