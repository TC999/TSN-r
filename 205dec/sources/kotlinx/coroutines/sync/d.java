package kotlinx.coroutines.sync;

import d2.l;
import d2.p;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.j0;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Mutex.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006\u0006\u001a\t\u0015\u0014\u001fB\u000f\u0012\u0006\u0010\"\u001a\u00020\u0005\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\nJT\u0010\u0012\u001a\u00020\b\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00058@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\"\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lkotlinx/coroutines/sync/d;", "Lkotlinx/coroutines/sync/c;", "Lkotlinx/coroutines/selects/e;", "", "owner", "", "a", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "c", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "h", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "e", "d", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "b", "()Z", "isLocked", "g", "isLockedEmptyQueueState", "f", "()Lkotlinx/coroutines/selects/e;", "onLock", "locked", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d implements kotlinx.coroutines.sync.c, kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> {

    /* renamed from: a  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60679a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_state");
    volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/d$a;", "Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/sync/d;", "", "i0", "token", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/o;", "f", "Lkotlinx/coroutines/o;", "cont", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends c {
        @JvmField
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public final o<f1> f60680f;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Mutex.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.sync.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1223a extends Lambda implements l<Throwable, f1> {
            C1223a() {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                a aVar = a.this;
                d.this.d(aVar.f60687d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(@Nullable Object obj, @NotNull o<? super f1> oVar) {
            super(obj);
            this.f60680f = oVar;
        }

        @Override // kotlinx.coroutines.sync.d.c
        public void h0(@NotNull Object obj) {
            this.f60680f.S(obj);
        }

        @Override // kotlinx.coroutines.sync.d.c
        @Nullable
        public Object i0() {
            return this.f60680f.n(f1.f55527a, null, new C1223a());
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "LockCont[" + this.f60687d + ", " + this.f60680f + "] for " + d.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/sync/d$b;", "R", "Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/sync/d;", "", "i0", "token", "Lkotlin/f1;", "h0", "", "toString", "Lkotlinx/coroutines/selects/f;", "f", "Lkotlinx/coroutines/selects/f;", "select", "owner", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/c;", "Lkotlin/coroutines/c;", "block", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b<R> extends c {
        @JvmField
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public final kotlinx.coroutines.selects.f<R> f60683f;
        @JvmField
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public final p<kotlinx.coroutines.sync.c, kotlin.coroutines.c<? super R>, Object> f60684g;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Mutex.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements l<Throwable, f1> {
            a() {
                super(1);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
                invoke2(th);
                return f1.f55527a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                b bVar = b.this;
                d.this.d(bVar.f60687d);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable Object obj, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull p<? super kotlinx.coroutines.sync.c, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            super(obj);
            this.f60683f = fVar;
            this.f60684g = pVar;
        }

        @Override // kotlinx.coroutines.sync.d.c
        public void h0(@NotNull Object obj) {
            z2.a.c(this.f60684g, d.this, this.f60683f.t(), new a());
        }

        @Override // kotlinx.coroutines.sync.d.c
        @Nullable
        public Object i0() {
            j0 j0Var;
            if (this.f60683f.p()) {
                j0Var = MutexKt.f60665c;
                return j0Var;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "LockSelect[" + this.f60687d + ", " + this.f60683f + "] for " + d.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u00a2\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/d$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "", "i0", "token", "h0", "d", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public abstract class c extends s implements i1 {
        @JvmField
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final Object f60687d;

        public c(@Nullable Object obj) {
            this.f60687d = obj;
        }

        @Override // kotlinx.coroutines.i1
        public final void dispose() {
            a0();
        }

        public abstract void h0(@NotNull Object obj);

        @Nullable
        public abstract Object i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/d$d;", "Lkotlinx/coroutines/internal/q;", "", "toString", "", "d", "Ljava/lang/Object;", "owner", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.sync.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1224d extends q {
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public Object f60689d;

        public C1224d(@NotNull Object obj) {
            this.f60689d = obj;
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.f60689d + ']';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/d$e;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/d;", "op", "", "c", "failure", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/sync/d;", "b", "Lkotlinx/coroutines/sync/d;", "mutex", "Ljava/lang/Object;", "owner", "<init>", "(Lkotlinx/coroutines/sync/d;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class e extends kotlinx.coroutines.internal.b {
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final d f60690b;
        @JvmField
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final Object f60691c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Mutex.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001e\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/d$e$a;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlinx/coroutines/internal/d;", "a", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/sync/d$e;Lkotlinx/coroutines/internal/d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        private final class a extends c0 {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final kotlinx.coroutines.internal.d<?> f60692a;

            public a(@NotNull kotlinx.coroutines.internal.d<?> dVar) {
                this.f60692a = dVar;
            }

            @Override // kotlinx.coroutines.internal.c0
            @NotNull
            public kotlinx.coroutines.internal.d<?> a() {
                return this.f60692a;
            }

            @Override // kotlinx.coroutines.internal.c0
            @Nullable
            public Object c(@Nullable Object obj) {
                Object a4 = a().h() ? MutexKt.f60669g : a();
                if (obj != null) {
                    io.netty.channel.a.a(d.f60679a, (d) obj, this, a4);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public e(@NotNull d dVar, @Nullable Object obj) {
            this.f60690b = dVar;
            this.f60691c = obj;
        }

        @Override // kotlinx.coroutines.internal.b
        public void a(@NotNull kotlinx.coroutines.internal.d<?> dVar, @Nullable Object obj) {
            kotlinx.coroutines.sync.b bVar;
            if (obj != null) {
                bVar = MutexKt.f60669g;
            } else {
                Object obj2 = this.f60691c;
                bVar = obj2 == null ? MutexKt.f60668f : new kotlinx.coroutines.sync.b(obj2);
            }
            io.netty.channel.a.a(d.f60679a, this.f60690b, dVar, bVar);
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        public Object c(@NotNull kotlinx.coroutines.internal.d<?> dVar) {
            kotlinx.coroutines.sync.b bVar;
            j0 j0Var;
            a aVar = new a(dVar);
            d dVar2 = this.f60690b;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f60679a;
            bVar = MutexKt.f60669g;
            if (io.netty.channel.a.a(atomicReferenceFieldUpdater, dVar2, bVar, aVar)) {
                return aVar.c(this.f60690b);
            }
            j0Var = MutexKt.f60663a;
            return j0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Mutex.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/sync/d$f;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/sync/d;", "affected", "", "k", "failure", "Lkotlin/f1;", "j", "Lkotlinx/coroutines/sync/d$d;", "b", "Lkotlinx/coroutines/sync/d$d;", "queue", "<init>", "(Lkotlinx/coroutines/sync/d$d;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends kotlinx.coroutines.internal.d<d> {
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final C1224d f60694b;

        public f(@NotNull C1224d c1224d) {
            this.f60694b = c1224d;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j */
        public void d(@NotNull d dVar, @Nullable Object obj) {
            io.netty.channel.a.a(d.f60679a, dVar, this, obj == null ? MutexKt.f60669g : this.f60694b);
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull d dVar) {
            j0 j0Var;
            if (this.f60694b.i0()) {
                return null;
            }
            j0Var = MutexKt.f60664b;
            return j0Var;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core", "kotlinx/coroutines/sync/MutexImpl$$special$$inlined$loop$lambda$1"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends s.c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s f60695d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f60696e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ o f60697f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ a f60698g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ d f60699h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ Object f60700i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(s sVar, s sVar2, Object obj, o oVar, a aVar, d dVar, Object obj2) {
            super(sVar2);
            this.f60695d = sVar;
            this.f60696e = obj;
            this.f60697f = oVar;
            this.f60698g = aVar;
            this.f60699h = dVar;
            this.f60700i = obj2;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull s sVar) {
            if (this.f60699h._state == this.f60696e) {
                return null;
            }
            return r.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h extends s.c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ s f60701d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f60702e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Object f60703f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(s sVar, s sVar2, d dVar, Object obj) {
            super(sVar2);
            this.f60701d = sVar;
            this.f60702e = dVar;
            this.f60703f = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull s sVar) {
            if (this.f60702e._state == this.f60703f) {
                return null;
            }
            return r.a();
        }
    }

    public d(boolean z3) {
        this._state = z3 ? MutexKt.f60668f : MutexKt.f60669g;
    }

    @Override // kotlinx.coroutines.selects.e
    public <R> void D(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @Nullable Object obj, @NotNull p<? super kotlinx.coroutines.sync.c, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        j0 j0Var;
        j0 j0Var2;
        while (!fVar.h()) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj2;
                Object obj3 = bVar.f60678a;
                j0Var = MutexKt.f60667e;
                if (obj3 != j0Var) {
                    io.netty.channel.a.a(f60679a, this, obj2, new C1224d(bVar.f60678a));
                } else {
                    Object w3 = fVar.w(new e(this, obj));
                    if (w3 == null) {
                        z2.b.d(pVar, this, fVar.t());
                        return;
                    } else if (w3 == kotlinx.coroutines.selects.g.d()) {
                        return;
                    } else {
                        j0Var2 = MutexKt.f60663a;
                        if (w3 != j0Var2 && w3 != kotlinx.coroutines.internal.c.f60351b) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + w3).toString());
                        }
                    }
                }
            } else if (obj2 instanceof C1224d) {
                C1224d c1224d = (C1224d) obj2;
                boolean z3 = false;
                if (c1224d.f60689d != obj) {
                    b bVar2 = new b(obj, fVar, pVar);
                    h hVar = new h(bVar2, bVar2, this, obj2);
                    while (true) {
                        int f02 = c1224d.U().f0(bVar2, c1224d, hVar);
                        if (f02 == 1) {
                            z3 = true;
                            break;
                        } else if (f02 == 2) {
                            break;
                        }
                    }
                    if (z3) {
                        fVar.k(bVar2);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((c0) obj2).c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean a(@Nullable Object obj) {
        j0 j0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                Object obj3 = ((kotlinx.coroutines.sync.b) obj2).f60678a;
                j0Var = MutexKt.f60667e;
                if (obj3 != j0Var) {
                    return false;
                }
                if (io.netty.channel.a.a(f60679a, this, obj2, obj == null ? MutexKt.f60668f : new kotlinx.coroutines.sync.b(obj))) {
                    return true;
                }
            } else if (obj2 instanceof C1224d) {
                if (((C1224d) obj2).f60689d != obj) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (!(obj2 instanceof c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((c0) obj2).c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean b() {
        j0 j0Var;
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                Object obj2 = ((kotlinx.coroutines.sync.b) obj).f60678a;
                j0Var = MutexKt.f60667e;
                return obj2 != j0Var;
            } else if (obj instanceof C1224d) {
                return true;
            } else {
                if (!(obj instanceof c0)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((c0) obj).c(this);
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    @Nullable
    public Object c(@Nullable Object obj, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        if (a(obj)) {
            return f1.f55527a;
        }
        Object h5 = h(obj, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return h5 == h4 ? h5 : f1.f55527a;
    }

    @Override // kotlinx.coroutines.sync.c
    public void d(@Nullable Object obj) {
        kotlinx.coroutines.sync.b bVar;
        j0 j0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                if (obj == null) {
                    Object obj3 = ((kotlinx.coroutines.sync.b) obj2).f60678a;
                    j0Var = MutexKt.f60667e;
                    if (!(obj3 != j0Var)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.b bVar2 = (kotlinx.coroutines.sync.b) obj2;
                    if (!(bVar2.f60678a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.f60678a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60679a;
                bVar = MutexKt.f60669g;
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, obj2, bVar)) {
                    return;
                }
            } else if (obj2 instanceof c0) {
                ((c0) obj2).c(this);
            } else if (obj2 instanceof C1224d) {
                if (obj != null) {
                    C1224d c1224d = (C1224d) obj2;
                    if (!(c1224d.f60689d == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c1224d.f60689d + " but expected " + obj).toString());
                    }
                }
                C1224d c1224d2 = (C1224d) obj2;
                s c02 = c1224d2.c0();
                if (c02 == null) {
                    f fVar = new f(c1224d2);
                    if (io.netty.channel.a.a(f60679a, this, obj2, fVar) && fVar.c(this) == null) {
                        return;
                    }
                } else {
                    c cVar = (c) c02;
                    Object i02 = cVar.i0();
                    if (i02 != null) {
                        Object obj4 = cVar.f60687d;
                        if (obj4 == null) {
                            obj4 = MutexKt.f60666d;
                        }
                        c1224d2.f60689d = obj4;
                        cVar.h0(i02);
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.sync.c
    public boolean e(@NotNull Object obj) {
        Object obj2 = this._state;
        if (obj2 instanceof kotlinx.coroutines.sync.b) {
            if (((kotlinx.coroutines.sync.b) obj2).f60678a == obj) {
                return true;
            }
        } else if ((obj2 instanceof C1224d) && ((C1224d) obj2).f60689d == obj) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.c
    @NotNull
    public kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> f() {
        return this;
    }

    public final boolean g() {
        Object obj = this._state;
        return (obj instanceof C1224d) && ((C1224d) obj).i0();
    }

    @Nullable
    final /* synthetic */ Object h(@Nullable Object obj, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        j0 j0Var;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p b4 = kotlinx.coroutines.r.b(d4);
        a aVar = new a(obj, b4);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                kotlinx.coroutines.sync.b bVar = (kotlinx.coroutines.sync.b) obj2;
                Object obj3 = bVar.f60678a;
                j0Var = MutexKt.f60667e;
                if (obj3 != j0Var) {
                    io.netty.channel.a.a(f60679a, this, obj2, new C1224d(bVar.f60678a));
                } else {
                    if (io.netty.channel.a.a(f60679a, this, obj2, obj == null ? MutexKt.f60668f : new kotlinx.coroutines.sync.b(obj))) {
                        f1 f1Var = f1.f55527a;
                        Result.a aVar2 = Result.Companion;
                        b4.resumeWith(Result.m119constructorimpl(f1Var));
                        break;
                    }
                }
            } else if (obj2 instanceof C1224d) {
                C1224d c1224d = (C1224d) obj2;
                boolean z3 = false;
                if (c1224d.f60689d != obj) {
                    g gVar = new g(aVar, aVar, obj2, b4, aVar, this, obj);
                    while (true) {
                        int f02 = c1224d.U().f0(aVar, c1224d, gVar);
                        if (f02 == 1) {
                            z3 = true;
                            break;
                        } else if (f02 == 2) {
                            break;
                        }
                    }
                    if (z3) {
                        kotlinx.coroutines.r.c(b4, aVar);
                        break;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (!(obj2 instanceof c0)) {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            } else {
                ((c0) obj2).c(this);
            }
        }
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return "Mutex[" + ((kotlinx.coroutines.sync.b) obj).f60678a + ']';
            } else if (!(obj instanceof c0)) {
                if (!(obj instanceof C1224d)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((C1224d) obj).f60689d + ']';
            } else {
                ((c0) obj).c(this);
            }
        }
    }
}
