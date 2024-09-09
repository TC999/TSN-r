package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LockFreeLinkedList.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001:\u0005JKLMNB\u0007\u00a2\u0006\u0004\bI\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010\u00a2\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0016\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0081\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005\u00a2\u0006\u0004\b\u001a\u0010\fJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\f\b\u0000\u0010\u001b*\u00060\u0000j\u0002`\u00052\u0006\u0010\u0011\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\u001f\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b\u00a2\u0006\u0004\b\u001f\u0010 J4\u0010#\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!H\u0086\b\u00a2\u0006\u0004\b#\u0010$JD\u0010%\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0005\u0012\u0004\u0012\u00020\u00130!2\u000e\b\u0004\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086\b\u00a2\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001\u00a2\u0006\u0004\b'\u0010(J/\u0010+\u001a\u00020*2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010)\u001a\u00020\u0015H\u0001\u00a2\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001\u00a2\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\n\u00a2\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\nH\u0001\u00a2\u0006\u0004\b3\u00102J\u0015\u00104\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005\u00a2\u0006\u0004\b4\u00100J\u0017\u00106\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000505\u00a2\u0006\u0004\b6\u00107J.\u00108\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001b\u0018\u00012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130!H\u0086\b\u00a2\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0014\u00a2\u0006\u0004\b:\u00100J'\u0010<\u001a\u00020\n2\n\u0010;\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0000\u00a2\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016\u00a2\u0006\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010.R\u0011\u0010\t\u001a\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\bC\u0010DR\u0015\u0010F\u001a\u00060\u0000j\u0002`\u00058F\u00a2\u0006\u0006\u001a\u0004\bE\u00100R\u0015\u0010H\u001a\u00060\u0000j\u0002`\u00058F\u00a2\u0006\u0006\u001a\u0004\bG\u00100\u00a8\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/s;", "", "Lkotlinx/coroutines/internal/e0;", "e0", "()Lkotlinx/coroutines/internal/e0;", "Lkotlinx/coroutines/internal/Node;", "current", "O", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/internal/s;", "next", "Lkotlin/f1;", "P", "(Lkotlinx/coroutines/internal/s;)V", "Lkotlinx/coroutines/internal/c0;", "op", "L", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/s$c;", "Y", "(Lkotlinx/coroutines/internal/s;Ld2/a;)Lkotlinx/coroutines/internal/s$c;", "K", "(Lkotlinx/coroutines/internal/s;)Z", "D", "T", "Lkotlinx/coroutines/internal/s$b;", "M", "(Lkotlinx/coroutines/internal/s;)Lkotlinx/coroutines/internal/s$b;", "E", "(Lkotlinx/coroutines/internal/s;Ld2/a;)Z", "Lkotlin/Function1;", "predicate", "F", "(Lkotlinx/coroutines/internal/s;Ld2/l;)Z", "I", "(Lkotlinx/coroutines/internal/s;Ld2/l;Ld2/a;)Z", "J", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Z", "condAdd", "", "f0", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s$c;)I", "a0", "()Z", "d0", "()Lkotlinx/coroutines/internal/s;", "V", "()V", "W", "c0", "Lkotlinx/coroutines/internal/s$e;", "N", "()Lkotlinx/coroutines/internal/s$e;", "b0", "(Ld2/l;)Ljava/lang/Object;", "Z", "prev", "g0", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "", "toString", "()Ljava/lang/String;", "X", "isRemoved", "Q", "()Ljava/lang/Object;", "R", "nextNode", "U", "prevNode", "<init>", "a", "b", "c", "d", "e", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60400a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* renamed from: b  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60401b = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60402c = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0014J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\n\u001a\u00020\bH\u0014J \u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H$J \u0010\u000f\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\n\u0010\n\u001a\u00060\u0004j\u0002`\u0005H&J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0014\u0010\u0014\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0015J\u001c\u0010\u0018\u001a\u00020\r2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\bR\u001c\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/b;", "Lkotlinx/coroutines/internal/c0;", "op", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "m", "affected", "", "e", "next", "", "l", "Lkotlin/f1;", "f", "n", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "g", "j", "k", "Lkotlinx/coroutines/internal/d;", "c", "failure", "a", "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a extends kotlinx.coroutines.internal.b {
        @Override // kotlinx.coroutines.internal.b
        public final void a(@NotNull kotlinx.coroutines.internal.d<?> dVar, @Nullable Object obj) {
            s i4;
            boolean z3 = obj == null;
            s h4 = h();
            if (h4 == null || (i4 = i()) == null) {
                return;
            }
            if (io.netty.channel.a.a(s.f60400a, h4, dVar, z3 ? n(h4, i4) : i4) && z3) {
                f(h4, i4);
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        public final Object c(@NotNull kotlinx.coroutines.internal.d<?> dVar) {
            while (true) {
                s m4 = m(dVar);
                if (m4 != null) {
                    Object obj = m4._next;
                    if (obj == dVar || dVar.h()) {
                        return null;
                    }
                    if (obj instanceof c0) {
                        c0 c0Var = (c0) obj;
                        if (dVar.b(c0Var)) {
                            return kotlinx.coroutines.internal.c.f60351b;
                        }
                        c0Var.c(m4);
                    } else {
                        Object e4 = e(m4);
                        if (e4 != null) {
                            return e4;
                        }
                        if (l(m4, obj)) {
                            continue;
                        } else if (obj != null) {
                            d dVar2 = new d(m4, (s) obj, this);
                            if (io.netty.channel.a.a(s.f60400a, m4, obj, dVar2)) {
                                try {
                                    if (dVar2.c(m4) != t.f60417a) {
                                        return null;
                                    }
                                } catch (Throwable th) {
                                    io.netty.channel.a.a(s.f60400a, m4, dVar2, obj);
                                    throw th;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                    }
                } else {
                    return kotlinx.coroutines.internal.c.f60351b;
                }
            }
        }

        @Nullable
        protected Object e(@NotNull s sVar) {
            return null;
        }

        protected abstract void f(@NotNull s sVar, @NotNull s sVar2);

        public abstract void g(@NotNull d dVar);

        @Nullable
        protected abstract s h();

        @Nullable
        protected abstract s i();

        @Nullable
        public Object j(@NotNull d dVar) {
            g(dVar);
            return null;
        }

        public void k(@NotNull s sVar) {
        }

        protected boolean l(@NotNull s sVar, @NotNull Object obj) {
            return false;
        }

        @Nullable
        protected s m(@NotNull c0 c0Var) {
            s h4 = h();
            kotlin.jvm.internal.f0.m(h4);
            return h4;
        }

        @NotNull
        public abstract Object n(@NotNull s sVar, @NotNull s sVar2);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u00a2\u0006\u0004\b\"\u0010\u0017J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00020\u00112\n\u0010\t\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000b\u001a\u00060\u0001j\u0002`\u0002H\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00028\u00008\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001f\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001e\u00a8\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/c0;", "op", "m", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "affected", "", "next", "", "l", "(Lkotlinx/coroutines/internal/s;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/internal/s$d;)V", "n", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "b", "Lkotlinx/coroutines/internal/s;", "queue", "c", "node", "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<T extends s> extends a {

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f60403d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode = null;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final s f60404b;
        @JvmField
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public final T f60405c;

        public b(@NotNull s sVar, @NotNull T t3) {
            this.f60404b = sVar;
            this.f60405c = t3;
        }

        @Override // kotlinx.coroutines.internal.s.a
        protected void f(@NotNull s sVar, @NotNull s sVar2) {
            this.f60405c.P(this.f60404b);
        }

        @Override // kotlinx.coroutines.internal.s.a
        public void g(@NotNull d dVar) {
            io.netty.channel.a.a(f60403d, this, null, dVar.f60408a);
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s h() {
            return (s) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s i() {
            return this.f60404b;
        }

        @Override // kotlinx.coroutines.internal.s.a
        protected boolean l(@NotNull s sVar, @NotNull Object obj) {
            return obj != this.f60404b;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s m(@NotNull c0 c0Var) {
            return this.f60404b.L(c0Var);
        }

        @Override // kotlinx.coroutines.internal.s.a
        @NotNull
        public Object n(@NotNull s sVar, @NotNull s sVar2) {
            T t3 = this.f60405c;
            io.netty.channel.a.a(s.f60401b, t3, t3, sVar);
            T t4 = this.f60405c;
            io.netty.channel.a.a(s.f60400a, t4, t4, this.f60404b);
            return this.f60405c;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001e\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/d;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "Lkotlin/f1;", "j", "b", "Lkotlinx/coroutines/internal/s;", "oldNext", "c", "newNode", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    @PublishedApi
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c extends kotlinx.coroutines.internal.d<s> {
        @JvmField
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public s f60406b;
        @JvmField
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public final s f60407c;

        public c(@NotNull s sVar) {
            this.f60407c = sVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j */
        public void d(@NotNull s sVar, @Nullable Object obj) {
            boolean z3 = obj == null;
            s sVar2 = z3 ? this.f60407c : this.f60406b;
            if (sVar2 != null && io.netty.channel.a.a(s.f60400a, sVar, this, sVar2) && z3) {
                s sVar3 = this.f60407c;
                s sVar4 = this.f60406b;
                kotlin.jvm.internal.f0.m(sVar4);
                sVar3.P(sVar4);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u00060\tj\u0002`\n\u0012\n\u0010\u000e\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\u0003\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u00060\tj\u0002`\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "Lkotlin/f1;", "d", "", "toString", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "a", "Lkotlinx/coroutines/internal/s;", "b", "next", "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/s$a;", "desc", "Lkotlinx/coroutines/internal/d;", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s$a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends c0 {
        @JvmField
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final s f60408a;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final s f60409b;
        @JvmField
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        public final a f60410c;

        public d(@NotNull s sVar, @NotNull s sVar2, @NotNull a aVar) {
            this.f60408a = sVar;
            this.f60409b = sVar2;
            this.f60410c = aVar;
        }

        @Override // kotlinx.coroutines.internal.c0
        @NotNull
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f60410c.b();
        }

        @Override // kotlinx.coroutines.internal.c0
        @Nullable
        public Object c(@Nullable Object obj) {
            Object f4;
            Object obj2;
            if (obj != null) {
                s sVar = (s) obj;
                Object j4 = this.f60410c.j(this);
                Object obj3 = t.f60417a;
                if (j4 == obj3) {
                    s sVar2 = this.f60409b;
                    if (io.netty.channel.a.a(s.f60400a, sVar, this, sVar2.e0())) {
                        this.f60410c.k(sVar);
                        sVar2.L(null);
                    }
                    return obj3;
                }
                if (j4 != null) {
                    f4 = a().e(j4);
                } else {
                    f4 = a().f();
                }
                if (f4 == kotlinx.coroutines.internal.c.f60350a) {
                    obj2 = a();
                } else if (f4 == null) {
                    obj2 = this.f60410c.n(sVar, this.f60409b);
                } else {
                    obj2 = this.f60409b;
                }
                io.netty.channel.a.a(s.f60400a, sVar, this, obj2);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        public final void d() {
            this.f60410c.g(this);
        }

        @Override // kotlinx.coroutines.internal.c0
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u0006H\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\u000e2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\r\u001a\u00020\nH\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0016\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00132\n\u0010\t\u001a\u00060\u0005j\u0002`\u00062\n\u0010\r\u001a\u00060\u0005j\u0002`\u0006H\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u00060\u0005j\u0002`\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00028\u00008F\u00a2\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010$\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010#\u00a8\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/s$e;", "T", "Lkotlinx/coroutines/internal/s$a;", "Lkotlinx/coroutines/internal/c0;", "op", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "m", "(Lkotlinx/coroutines/internal/c0;)Lkotlinx/coroutines/internal/s;", "affected", "", "e", "(Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "next", "", "l", "(Lkotlinx/coroutines/internal/s;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/s$d;", "prepareOp", "Lkotlin/f1;", "g", "(Lkotlinx/coroutines/internal/s$d;)V", "n", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/s;Lkotlinx/coroutines/internal/s;)V", "b", "Lkotlinx/coroutines/internal/s;", "queue", "o", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "h", "()Lkotlinx/coroutines/internal/s;", "affectedNode", "i", "originalNext", "<init>", "(Lkotlinx/coroutines/internal/s;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e<T> extends a {

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f60411c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_affectedNode");

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f60412d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final s f60413b;

        public e(@NotNull s sVar) {
            this.f60413b = sVar;
        }

        public static /* synthetic */ void p() {
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected Object e(@NotNull s sVar) {
            if (sVar == this.f60413b) {
                return r.d();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.s.a
        protected final void f(@NotNull s sVar, @NotNull s sVar2) {
            sVar2.L(null);
        }

        @Override // kotlinx.coroutines.internal.s.a
        public void g(@NotNull d dVar) {
            io.netty.channel.a.a(f60411c, this, null, dVar.f60408a);
            io.netty.channel.a.a(f60412d, this, null, dVar.f60409b);
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s h() {
            return (s) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s i() {
            return (s) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.s.a
        protected final boolean l(@NotNull s sVar, @NotNull Object obj) {
            if (obj instanceof e0) {
                ((e0) obj).f60354a.W();
                return true;
            }
            return false;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected final s m(@NotNull c0 c0Var) {
            s sVar = this.f60413b;
            while (true) {
                Object obj = sVar._next;
                if (!(obj instanceof c0)) {
                    if (obj != null) {
                        return (s) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                c0 c0Var2 = (c0) obj;
                if (c0Var.b(c0Var2)) {
                    return null;
                }
                c0Var2.c(this.f60413b);
            }
        }

        @Override // kotlinx.coroutines.internal.s.a
        @NotNull
        public final Object n(@NotNull s sVar, @NotNull s sVar2) {
            return sVar2.e0();
        }

        public final T o() {
            T t3 = (T) h();
            kotlin.jvm.internal.f0.m(t3);
            return t3;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d2.a f60414d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ s f60415e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d2.a aVar, s sVar, s sVar2) {
            super(sVar2);
            this.f60414d = aVar;
            this.f60415e = sVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull s sVar) {
            if (((Boolean) this.f60414d.invoke()).booleanValue()) {
                return null;
            }
            return r.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (io.netty.channel.a.a(kotlinx.coroutines.internal.s.f60400a, r3, r2, ((kotlinx.coroutines.internal.e0) r4).f60354a) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.s L(kotlinx.coroutines.internal.c0 r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            kotlinx.coroutines.internal.s r0 = (kotlinx.coroutines.internal.s) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.s.f60401b
            boolean r0 = io.netty.channel.a.a(r1, r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.X()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.c0
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.c0 r0 = (kotlinx.coroutines.internal.c0) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.c0 r4 = (kotlinx.coroutines.internal.c0) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.e0
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.s.f60400a
            kotlinx.coroutines.internal.e0 r4 = (kotlinx.coroutines.internal.e0) r4
            kotlinx.coroutines.internal.s r4 = r4.f60354a
            boolean r2 = io.netty.channel.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.s r2 = (kotlinx.coroutines.internal.s) r2
            goto L7
        L52:
            if (r4 == 0) goto L59
            kotlinx.coroutines.internal.s r4 = (kotlinx.coroutines.internal.s) r4
            r3 = r2
            r2 = r4
            goto L7
        L59:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
        */
        //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r0)
            goto L62
        L61:
            throw r7
        L62:
            goto L61
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.s.L(kotlinx.coroutines.internal.c0):kotlinx.coroutines.internal.s");
    }

    private final s O(s sVar) {
        while (sVar.X()) {
            sVar = (s) sVar._prev;
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(s sVar) {
        s sVar2;
        do {
            sVar2 = (s) sVar._prev;
            if (Q() != sVar) {
                return;
            }
        } while (!io.netty.channel.a.a(f60401b, sVar, sVar2, this));
        if (X()) {
            sVar.L(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e0 e0() {
        e0 e0Var = (e0) this._removedRef;
        if (e0Var != null) {
            return e0Var;
        }
        e0 e0Var2 = new e0(this);
        f60402c.lazySet(this, e0Var2);
        return e0Var2;
    }

    public final void D(@NotNull s sVar) {
        do {
        } while (!U().J(sVar, this));
    }

    public final boolean E(@NotNull s sVar, @NotNull d2.a<Boolean> aVar) {
        int f02;
        f fVar = new f(aVar, sVar, sVar);
        do {
            f02 = U().f0(sVar, this, fVar);
            if (f02 == 1) {
                return true;
            }
        } while (f02 != 2);
        return false;
    }

    public final boolean F(@NotNull s sVar, @NotNull d2.l<? super s, Boolean> lVar) {
        s U;
        do {
            U = U();
            if (!lVar.invoke(U).booleanValue()) {
                return false;
            }
        } while (!U.J(sVar, this));
        return true;
    }

    public final boolean I(@NotNull s sVar, @NotNull d2.l<? super s, Boolean> lVar, @NotNull d2.a<Boolean> aVar) {
        int f02;
        f fVar = new f(aVar, sVar, sVar);
        do {
            s U = U();
            if (!lVar.invoke(U).booleanValue()) {
                return false;
            }
            f02 = U.f0(sVar, this, fVar);
            if (f02 == 1) {
                return true;
            }
        } while (f02 != 2);
        return false;
    }

    @PublishedApi
    public final boolean J(@NotNull s sVar, @NotNull s sVar2) {
        f60401b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60400a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, sVar2, sVar)) {
            sVar.P(sVar2);
            return true;
        }
        return false;
    }

    public final boolean K(@NotNull s sVar) {
        f60401b.lazySet(sVar, this);
        f60400a.lazySet(sVar, this);
        while (Q() == this) {
            if (io.netty.channel.a.a(f60400a, this, this, sVar)) {
                sVar.P(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final <T extends s> b<T> M(@NotNull T t3) {
        return new b<>(this, t3);
    }

    @NotNull
    public final e<s> N() {
        return new e<>(this);
    }

    @NotNull
    public final Object Q() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof c0)) {
                return obj;
            }
            ((c0) obj).c(this);
        }
    }

    @NotNull
    public final s R() {
        return r.h(Q());
    }

    @NotNull
    public final s U() {
        s L2 = L(null);
        return L2 != null ? L2 : O((s) this._prev);
    }

    public final void V() {
        Object Q = Q();
        if (Q == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
        ((e0) Q).f60354a.L(null);
    }

    @PublishedApi
    public final void W() {
        s sVar = this;
        while (true) {
            Object Q = sVar.Q();
            if (!(Q instanceof e0)) {
                sVar.L(null);
                return;
            }
            sVar = ((e0) Q).f60354a;
        }
    }

    public boolean X() {
        return Q() instanceof e0;
    }

    @PublishedApi
    @NotNull
    public final c Y(@NotNull s sVar, @NotNull d2.a<Boolean> aVar) {
        return new f(aVar, sVar, sVar);
    }

    @Nullable
    protected s Z() {
        Object Q = Q();
        if (!(Q instanceof e0)) {
            Q = null;
        }
        e0 e0Var = (e0) Q;
        if (e0Var != null) {
            return e0Var.f60354a;
        }
        return null;
    }

    public boolean a0() {
        return d0() == null;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [kotlinx.coroutines.internal.s, T, java.lang.Object] */
    @Nullable
    public final /* synthetic */ <T> T b0(@NotNull d2.l<? super T, Boolean> lVar) {
        s d02;
        while (true) {
            Object Q = Q();
            if (Q == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            s sVar = (s) Q;
            if (sVar == this) {
                return null;
            }
            kotlin.jvm.internal.f0.y(3, "T");
            if ((lVar.invoke(sVar).booleanValue() && !sVar.X()) || (d02 = sVar.d0()) == null) {
                return sVar;
            }
            d02.W();
        }
    }

    @Nullable
    public final s c0() {
        while (true) {
            Object Q = Q();
            if (Q == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            s sVar = (s) Q;
            if (sVar == this) {
                return null;
            }
            if (sVar.a0()) {
                return sVar;
            }
            sVar.V();
        }
    }

    @PublishedApi
    @Nullable
    public final s d0() {
        Object Q;
        s sVar;
        do {
            Q = Q();
            if (Q instanceof e0) {
                return ((e0) Q).f60354a;
            }
            if (Q == this) {
                return (s) Q;
            }
            if (Q != null) {
                sVar = (s) Q;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        } while (!io.netty.channel.a.a(f60400a, this, Q, sVar.e0()));
        sVar.L(null);
        return null;
    }

    @PublishedApi
    public final int f0(@NotNull s sVar, @NotNull s sVar2, @NotNull c cVar) {
        f60401b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60400a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        cVar.f60406b = sVar2;
        if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, sVar2, cVar)) {
            return cVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public final void g0(@NotNull s sVar, @NotNull s sVar2) {
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
