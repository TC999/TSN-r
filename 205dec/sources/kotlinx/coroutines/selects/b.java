package kotlinx.coroutines.selects;

import d2.l;
import d2.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.selects.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Select.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004[\\DFB\u0015\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0004\bY\u0010ZJ.\u0010\r\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0082\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0018\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001aH\u0001\u00a2\u0006\u0004\b!\u0010\u001dJ\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0016\u00a2\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016\u00a2\u0006\u0004\b'\u0010(J\u001b\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016\u00a2\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020-H\u0016\u00a2\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016\u00a2\u0006\u0004\b2\u00103J5\u00106\u001a\u00020\u000b*\u0002042\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u00107JG\u0010;\u001a\u00020\u000b\"\u0004\b\u0001\u00108*\b\u0012\u0004\u0012\u00028\u0001092\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J[\u0010@\u001a\u00020\u000b\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u00108*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020>2\u0006\u0010?\u001a\u00028\u00012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0:H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010AJ8\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020B2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t05H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010ER\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR(\u0010L\u001a\u0004\u0018\u00010\"2\b\u0010\n\u001a\u0004\u0018\u00010\"8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010%R\u001c\u0010O\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006]"}, d2 = {"Lkotlinx/coroutines/selects/b;", "R", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/selects/a;", "Lkotlinx/coroutines/selects/f;", "Lkotlin/coroutines/c;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/Function0;", "", "value", "Lkotlin/f1;", "block", "m0", "(Ld2/a;Ld2/a;)V", "H", "()V", "l0", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "exception", "v", "(Ljava/lang/Throwable;)V", "o0", "()Ljava/lang/Object;", "e", "p0", "Lkotlinx/coroutines/i1;", "handle", "k", "(Lkotlinx/coroutines/i1;)V", "", "p", "()Z", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "m", "(Lkotlinx/coroutines/internal/s$d;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/b;", "desc", "w", "(Lkotlinx/coroutines/internal/b;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/c;", "Lkotlin/Function1;", "l", "(Lkotlinx/coroutines/selects/c;Ld2/l;)V", "Q", "Lkotlinx/coroutines/selects/d;", "Lkotlin/Function2;", "j", "(Lkotlinx/coroutines/selects/d;Ld2/p;)V", "P", "Lkotlinx/coroutines/selects/e;", "param", "x", "(Lkotlinx/coroutines/selects/e;Ljava/lang/Object;Ld2/p;)V", "", "timeMillis", "c", "(JLd2/l;)V", "d", "Lkotlin/coroutines/c;", "uCont", "n0", "()Lkotlinx/coroutines/i1;", "q0", "parentHandle", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "t", "()Lkotlin/coroutines/c;", "completion", "h", "isSelected", "<init>", "(Lkotlin/coroutines/c;)V", "a", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b<R> extends q implements kotlinx.coroutines.selects.a<R>, f<R>, kotlin.coroutines.c<R>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: e  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60631e = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");

    /* renamed from: f  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60632f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.c<R> f60633d;
    volatile Object _state = g.f();
    volatile Object _result = g.c();
    private volatile Object _parentHandle = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/selects/b$a;", "Lkotlinx/coroutines/internal/d;", "", "k", "Lkotlin/f1;", "l", "failure", "j", "affected", "i", "d", "", "toString", "", "b", "J", "g", "()J", "opSequence", "Lkotlinx/coroutines/selects/b;", "c", "Lkotlinx/coroutines/selects/b;", "impl", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/b;", "desc", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/internal/b;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlinx.coroutines.internal.d<Object> {

        /* renamed from: b  reason: collision with root package name */
        private final long f60634b = g.b().a();
        @JvmField
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public final b<?> f60635c;
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final kotlinx.coroutines.internal.b f60636d;

        public a(@NotNull b<?> bVar, @NotNull kotlinx.coroutines.internal.b bVar2) {
            this.f60635c = bVar;
            this.f60636d = bVar2;
            bVar2.d(this);
        }

        private final void j(Object obj) {
            boolean z3 = obj == null;
            if (io.netty.channel.a.a(b.f60631e, this.f60635c, this, z3 ? null : g.f()) && z3) {
                this.f60635c.l0();
            }
        }

        private final Object k() {
            b<?> bVar = this.f60635c;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof c0) {
                    ((c0) obj).c(this.f60635c);
                } else if (obj == g.f()) {
                    if (io.netty.channel.a.a(b.f60631e, this.f60635c, g.f(), this)) {
                        return null;
                    }
                } else {
                    return g.d();
                }
            }
        }

        private final void l() {
            io.netty.channel.a.a(b.f60631e, this.f60635c, this, g.f());
        }

        @Override // kotlinx.coroutines.internal.d
        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.f60636d.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.d
        public long g() {
            return this.f60634b;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        public Object i(@Nullable Object obj) {
            Object k4;
            if (obj != null || (k4 = k()) == null) {
                try {
                    return this.f60636d.c(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        l();
                    }
                    throw th;
                }
            }
            return k4;
        }

        @Override // kotlinx.coroutines.internal.c0
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/b$b;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/i1;", "d", "Lkotlinx/coroutines/i1;", "handle", "<init>", "(Lkotlinx/coroutines/i1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.selects.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1222b extends s {
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final i1 f60637d;

        public C1222b(@NotNull i1 i1Var) {
            this.f60637d = i1Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/selects/b$c;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlinx/coroutines/internal/s$d;", "a", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/s$d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends c0 {
        @JvmField
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final s.d f60638a;

        public c(@NotNull s.d dVar) {
            this.f60638a = dVar;
        }

        @Override // kotlinx.coroutines.internal.c0
        @Nullable
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f60638a.a();
        }

        @Override // kotlinx.coroutines.internal.c0
        @Nullable
        public Object c(@Nullable Object obj) {
            if (obj != null) {
                b bVar = (b) obj;
                this.f60638a.d();
                Object e4 = this.f60638a.a().e(null);
                io.netty.channel.a.a(b.f60631e, bVar, this, e4 == null ? this.f60638a.f60410c : g.f());
                return e4;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Select.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/b$d;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "h0", "", "toString", "job", "<init>", "(Lkotlinx/coroutines/selects/b;Lkotlinx/coroutines/e2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class d extends f2<e2> {
        public d(@NotNull e2 e2Var) {
            super(e2Var);
        }

        @Override // kotlinx.coroutines.f0
        public void h0(@Nullable Throwable th) {
            if (b.this.p()) {
                b.this.v(this.f60463d.l());
            }
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            h0(th);
            return f1.f55527a;
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "SelectOnCancelling[" + b.this + ']';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Runnable.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotlin/f1;", "run", "()V", "kotlinx/coroutines/a3$a", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f60641b;

        public e(l lVar) {
            this.f60641b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.p()) {
                z2.a.b(this.f60641b, b.this.t());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull kotlin.coroutines.c<? super R> cVar) {
        this.f60633d = cVar;
    }

    private final void H() {
        e2 e2Var = (e2) getContext().get(e2.f59626i0);
        if (e2Var != null) {
            i1 f4 = e2.a.f(e2Var, true, false, new d(e2Var), 2, null);
            q0(f4);
            if (h()) {
                f4.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        i1 n02 = n0();
        if (n02 != null) {
            n02.dispose();
        }
        Object Q = Q();
        if (Q != null) {
            for (s sVar = (s) Q; !f0.g(sVar, this); sVar = sVar.R()) {
                if (sVar instanceof C1222b) {
                    ((C1222b) sVar).f60637d.dispose();
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final void m0(d2.a<? extends Object> aVar, d2.a<f1> aVar2) {
        Object h4;
        Object h5;
        while (true) {
            Object obj = this._result;
            if (obj == g.c()) {
                if (io.netty.channel.a.a(f60632f, this, g.c(), aVar.invoke())) {
                    return;
                }
            } else {
                h4 = kotlin.coroutines.intrinsics.b.h();
                if (obj != h4) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60632f;
                h5 = kotlin.coroutines.intrinsics.b.h();
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, h5, g.a())) {
                    aVar2.invoke();
                    return;
                }
            }
        }
    }

    private final i1 n0() {
        return (i1) this._parentHandle;
    }

    private final void q0(i1 i1Var) {
        this._parentHandle = i1Var;
    }

    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void b(@NotNull kotlinx.coroutines.selects.e<? super P, ? extends Q> eVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        a.C1221a.a(this, eVar, pVar);
    }

    @Override // kotlinx.coroutines.selects.a
    public void c(long j4, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        if (j4 <= 0) {
            if (p()) {
                z2.b.c(lVar, t());
                return;
            }
            return;
        }
        k(a1.d(getContext()).f(j4, new e(lVar), getContext()));
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<R> cVar = this.f60633d;
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        return (kotlin.coroutines.jvm.internal.c) cVar;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return this.f60633d.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean h() {
        while (true) {
            Object obj = this._state;
            if (obj == g.f()) {
                return false;
            }
            if (!(obj instanceof c0)) {
                return true;
            }
            ((c0) obj).c(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <Q> void j(@NotNull kotlinx.coroutines.selects.d<? extends Q> dVar, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        dVar.I(this, pVar);
    }

    @Override // kotlinx.coroutines.selects.f
    public void k(@NotNull i1 i1Var) {
        C1222b c1222b = new C1222b(i1Var);
        if (!h()) {
            D(c1222b);
            if (!h()) {
                return;
            }
        }
        i1Var.dispose();
    }

    @Override // kotlinx.coroutines.selects.a
    public void l(@NotNull kotlinx.coroutines.selects.c cVar, @NotNull l<? super kotlin.coroutines.c<? super R>, ? extends Object> lVar) {
        cVar.N(this, lVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        l0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return kotlinx.coroutines.q.f60535d;
     */
    @Override // kotlinx.coroutines.selects.f
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.s.d r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.g.f()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.b.f60631e
            java.lang.Object r1 = kotlinx.coroutines.selects.g.f()
            boolean r0 = io.netty.channel.a.a(r0, r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.b$c r0 = new kotlinx.coroutines.selects.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.b.f60631e
            java.lang.Object r2 = kotlinx.coroutines.selects.g.f()
            boolean r1 = io.netty.channel.a.a(r1, r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.l0()
            kotlinx.coroutines.internal.j0 r4 = kotlinx.coroutines.q.f60535d
            return r4
        L37:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.c0
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            kotlinx.coroutines.internal.d r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.b.a
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.b$a r2 = (kotlinx.coroutines.selects.b.a) r2
            kotlinx.coroutines.selects.b<?> r2 = r2.f60635c
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            kotlinx.coroutines.internal.c0 r2 = (kotlinx.coroutines.internal.c0) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = kotlinx.coroutines.internal.c.f60351b
            return r4
        L65:
            kotlinx.coroutines.internal.c0 r0 = (kotlinx.coroutines.internal.c0) r0
            r0.c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            kotlinx.coroutines.internal.s$a r4 = r4.f60410c
            if (r0 != r4) goto L75
            kotlinx.coroutines.internal.j0 r4 = kotlinx.coroutines.q.f60535d
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.b.m(kotlinx.coroutines.internal.s$d):java.lang.Object");
    }

    @PublishedApi
    @Nullable
    public final Object o0() {
        Object h4;
        Object h5;
        if (!h()) {
            H();
        }
        Object obj = this._result;
        if (obj == g.c()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60632f;
            Object c4 = g.c();
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, c4, h4)) {
                h5 = kotlin.coroutines.intrinsics.b.h();
                return h5;
            }
            obj = this._result;
        }
        if (obj != g.a()) {
            if (obj instanceof d0) {
                throw ((d0) obj).f59534a;
            }
            return obj;
        }
        throw new IllegalStateException("Already resumed");
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean p() {
        Object m4 = m(null);
        if (m4 == kotlinx.coroutines.q.f60535d) {
            return true;
        }
        if (m4 == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + m4).toString());
    }

    @PublishedApi
    public final void p0(@NotNull Throwable th) {
        if (p()) {
            Result.a aVar = Result.Companion;
            resumeWith(Result.m119constructorimpl(kotlin.d0.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object o02 = o0();
            if ((o02 instanceof d0) && ((d0) o02).f59534a == th) {
                return;
            }
            n0.b(getContext(), th);
        }
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        Object h4;
        Object h5;
        while (true) {
            Object obj2 = this._result;
            if (obj2 == g.c()) {
                if (io.netty.channel.a.a(f60632f, this, g.c(), i0.d(obj, null, 1, null))) {
                    return;
                }
            } else {
                h4 = kotlin.coroutines.intrinsics.b.h();
                if (obj2 != h4) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60632f;
                h5 = kotlin.coroutines.intrinsics.b.h();
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, h5, g.a())) {
                    if (Result.m125isFailureimpl(obj)) {
                        kotlin.coroutines.c<R> cVar = this.f60633d;
                        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
                        f0.m(m122exceptionOrNullimpl);
                        Result.a aVar = Result.Companion;
                        cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(m122exceptionOrNullimpl)));
                        return;
                    }
                    this.f60633d.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.f
    @NotNull
    public kotlin.coroutines.c<R> t() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.s
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.f
    public void v(@NotNull Throwable th) {
        Object h4;
        Object h5;
        kotlin.coroutines.c d4;
        while (true) {
            Object obj = this._result;
            if (obj == g.c()) {
                if (io.netty.channel.a.a(f60632f, this, g.c(), new d0(th, false, 2, null))) {
                    return;
                }
            } else {
                h4 = kotlin.coroutines.intrinsics.b.h();
                if (obj != h4) {
                    throw new IllegalStateException("Already resumed");
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60632f;
                h5 = kotlin.coroutines.intrinsics.b.h();
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, h5, g.a())) {
                    d4 = IntrinsicsKt__IntrinsicsJvmKt.d(this.f60633d);
                    Result.a aVar = Result.Companion;
                    d4.resumeWith(Result.m119constructorimpl(kotlin.d0.a(th)));
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.selects.f
    @Nullable
    public Object w(@NotNull kotlinx.coroutines.internal.b bVar) {
        return new a(this, bVar).c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <P, Q> void x(@NotNull kotlinx.coroutines.selects.e<? super P, ? extends Q> eVar, P p3, @NotNull p<? super Q, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        eVar.D(this, p3, pVar);
    }
}
