package kotlinx.coroutines.channels;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.channels.m0;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.o;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007-0UVWXDB)\u0012 \u0010R\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0014\u0018\u00010Pj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`Q\u00a2\u0006\u0004\bS\u0010TJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002J\u001b\u0010\n\u001a\u0004\u0018\u00018\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJT\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0001\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2$\u0010\u0013\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016JZ\u0010\u0018\u001a\u00020\u0014\"\u0004\b\u0001\u0010\f* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019JT\u0010\u001a\u001a\u00020\u0006\"\u0004\b\u0001\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\r2$\u0010\u0013\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001e\u001a\u00020\u00142\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0014J\u0016\u0010 \u001a\u0004\u0018\u00010\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014J\u0013\u0010!\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J!\u0010#\u001a\u00028\u0001\"\u0004\b\u0001\u0010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0014J\u0015\u0010&\u001a\u0004\u0018\u00018\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\"J\u001f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b(\u0010\"J\u000f\u0010)\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0007J\u0016\u00100\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0018\u00010.j\u0004\u0018\u0001`/J\u0019\u00101\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0000\u00a2\u0006\u0004\b1\u00102J\u0010\u00104\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0006H\u0014J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0086\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0004J\u0010\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000109H\u0014J\b\u0010;\u001a\u00020\u0014H\u0014J\b\u0010<\u001a\u00020\u0014H\u0014R\u0014\u0010?\u001a\u00020\u00068$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00068$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010C\u001a\u00020\u00068DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010>R\u0014\u0010F\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010>R\u0014\u0010H\u001a\u00020\u00068DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010>R\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000I8F\u00a2\u0006\u0006\u001a\u0004\bJ\u0010KR\u0019\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000I8F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010KR \u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'0I8F\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\bN\u0010K\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006Y"}, d2 = {"Lkotlinx/coroutines/channels/a;", "E", "Lkotlinx/coroutines/channels/c;", "Lkotlinx/coroutines/channels/n;", "Lkotlinx/coroutines/channels/c0;", "receive", "", "V", "", "result", "h0", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "Lkotlinx/coroutines/selects/f;", "select", "", "receiveMode", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "Lkotlin/f1;", "j0", "(Lkotlinx/coroutines/selects/f;ILd2/p;)V", "value", "l0", "(Ld2/p;Lkotlinx/coroutines/selects/f;ILjava/lang/Object;)V", "X", "(Lkotlinx/coroutines/selects/f;Ld2/p;I)Z", "Lkotlinx/coroutines/o;", "cont", "k0", "f0", "g0", "J", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "i0", "(ILkotlin/coroutines/c;)Ljava/lang/Object;", "W", "F", "Lkotlinx/coroutines/channels/m0;", "w", "poll", "()Ljava/lang/Object;", "", "cause", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "T", "(Ljava/lang/Throwable;)Z", "wasClosed", "c0", "Lkotlinx/coroutines/channels/p;", "iterator", "Lkotlinx/coroutines/channels/a$g;", "U", "Lkotlinx/coroutines/channels/e0;", "M", "e0", "d0", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "Y", "hasReceiveOrClosed", "g", "isClosedForReceive", "isEmpty", "b0", "isEmptyImpl", "Lkotlinx/coroutines/selects/d;", "C", "()Lkotlinx/coroutines/selects/d;", "onReceive", "onReceiveOrNull", "L", "onReceiveOrClosed", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ld2/l;)V", "c", "d", "e", "f", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class a<E> extends kotlinx.coroutines.channels.c<E> implements n<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0013\u0010\u0007\u001a\u00020\u0005H\u0096B\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/a$a;", "E", "Lkotlinx/coroutines/channels/p;", "", "result", "", "d", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "e", "next", "()Ljava/lang/Object;", "a", "Ljava/lang/Object;", "c", "setResult", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/a;", "Lkotlinx/coroutines/channels/a;", "channel", "<init>", "(Lkotlinx/coroutines/channels/a;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class C1197a<E> implements p<E> {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Object f59370a = kotlinx.coroutines.channels.b.f59399g;
        @JvmField
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public final a<E> f59371b;

        public C1197a(@NotNull a<E> aVar) {
            this.f59371b = aVar;
        }

        private final boolean d(Object obj) {
            if (obj instanceof t) {
                t tVar = (t) obj;
                if (tVar.f59488d == null) {
                    return false;
                }
                throw kotlinx.coroutines.internal.i0.p(tVar.o0());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.p
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        @Nullable
        public /* synthetic */ Object a(@NotNull kotlin.coroutines.c<? super E> cVar) {
            return p.a.a(this, cVar);
        }

        @Override // kotlinx.coroutines.channels.p
        @Nullable
        public Object b(@NotNull kotlin.coroutines.c<? super Boolean> cVar) {
            Object obj = this.f59370a;
            kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.channels.b.f59399g;
            if (obj != j0Var) {
                return kotlin.coroutines.jvm.internal.a.a(d(obj));
            }
            Object f02 = this.f59371b.f0();
            this.f59370a = f02;
            if (f02 != j0Var) {
                return kotlin.coroutines.jvm.internal.a.a(d(f02));
            }
            return e(cVar);
        }

        @Nullable
        public final Object c() {
            return this.f59370a;
        }

        @Nullable
        final /* synthetic */ Object e(@NotNull kotlin.coroutines.c<? super Boolean> cVar) {
            kotlin.coroutines.c d4;
            Object h4;
            d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
            kotlinx.coroutines.p b4 = kotlinx.coroutines.r.b(d4);
            d dVar = new d(this, b4);
            while (true) {
                if (this.f59371b.V(dVar)) {
                    this.f59371b.k0(b4, dVar);
                    break;
                }
                Object f02 = this.f59371b.f0();
                setResult(f02);
                if (f02 instanceof t) {
                    t tVar = (t) f02;
                    if (tVar.f59488d == null) {
                        Boolean a4 = kotlin.coroutines.jvm.internal.a.a(false);
                        Result.a aVar = Result.Companion;
                        b4.resumeWith(Result.m119constructorimpl(a4));
                    } else {
                        Throwable o02 = tVar.o0();
                        Result.a aVar2 = Result.Companion;
                        b4.resumeWith(Result.m119constructorimpl(kotlin.d0.a(o02)));
                    }
                } else if (f02 != kotlinx.coroutines.channels.b.f59399g) {
                    Boolean a5 = kotlin.coroutines.jvm.internal.a.a(true);
                    d2.l<E, f1> lVar = this.f59371b.f59404b;
                    b4.T(a5, lVar != null ? kotlinx.coroutines.internal.b0.a(lVar, f02, b4.getContext()) : null);
                }
            }
            Object y3 = b4.y();
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (y3 == h4) {
                kotlin.coroutines.jvm.internal.e.c(cVar);
            }
            return y3;
        }

        @Override // kotlinx.coroutines.channels.p
        public E next() {
            E e4 = (E) this.f59370a;
            if (!(e4 instanceof t)) {
                kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.channels.b.f59399g;
                if (e4 != j0Var) {
                    this.f59370a = j0Var;
                    return e4;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw kotlinx.coroutines.internal.i0.p(((t) e4).o0());
        }

        public final void setResult(@Nullable Object obj) {
            this.f59370a = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/a$b;", "E", "Lkotlinx/coroutines/channels/c0;", "value", "", "k0", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "i", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "", "toString", "Lkotlinx/coroutines/o;", "d", "Lkotlinx/coroutines/o;", "cont", "", "e", "I", "receiveMode", "<init>", "(Lkotlinx/coroutines/o;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<E> extends c0<E> {
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final kotlinx.coroutines.o<Object> f59372d;
        @JvmField

        /* renamed from: e  reason: collision with root package name */
        public final int f59373e;

        public b(@NotNull kotlinx.coroutines.o<Object> oVar, int i4) {
            this.f59372d = oVar;
            this.f59373e = i4;
        }

        @Override // kotlinx.coroutines.channels.e0
        public void i(E e4) {
            this.f59372d.S(kotlinx.coroutines.q.f60535d);
        }

        @Override // kotlinx.coroutines.channels.c0
        public void j0(@NotNull t<?> tVar) {
            int i4 = this.f59373e;
            if (i4 == 1 && tVar.f59488d == null) {
                kotlinx.coroutines.o<Object> oVar = this.f59372d;
                Result.a aVar = Result.Companion;
                oVar.resumeWith(Result.m119constructorimpl(null));
            } else if (i4 == 2) {
                kotlinx.coroutines.o<Object> oVar2 = this.f59372d;
                m0.b bVar = m0.f59459b;
                m0 a4 = m0.a(m0.b(new m0.a(tVar.f59488d)));
                Result.a aVar2 = Result.Companion;
                oVar2.resumeWith(Result.m119constructorimpl(a4));
            } else {
                kotlinx.coroutines.o<Object> oVar3 = this.f59372d;
                Throwable o02 = tVar.o0();
                Result.a aVar3 = Result.Companion;
                oVar3.resumeWith(Result.m119constructorimpl(kotlin.d0.a(o02)));
            }
        }

        @Nullable
        public final Object k0(E e4) {
            if (this.f59373e != 2) {
                return e4;
            }
            m0.b bVar = m0.f59459b;
            return m0.a(m0.b(e4));
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "ReceiveElement@" + u0.b(this) + "[receiveMode=" + this.f59373e + ']';
        }

        @Override // kotlinx.coroutines.channels.e0
        @Nullable
        public kotlinx.coroutines.internal.j0 y(E e4, @Nullable s.d dVar) {
            if (this.f59372d.n(k0(e4), dVar != null ? dVar.f60410c : null, i0(e4)) != null) {
                if (dVar != null) {
                    dVar.d();
                }
                return kotlinx.coroutines.q.f60535d;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/a$c;", "E", "Lkotlinx/coroutines/channels/a$b;", "value", "Lkotlin/Function1;", "", "Lkotlin/f1;", "i0", "(Ljava/lang/Object;)Ld2/l;", "Lkotlinx/coroutines/o;", "", "cont", "", "receiveMode", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlinx/coroutines/o;ILd2/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<E> extends b<E> {
        @JvmField
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public final d2.l<E, f1> f59374f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull kotlinx.coroutines.o<Object> oVar, int i4, @NotNull d2.l<? super E, f1> lVar) {
            super(oVar, i4);
            this.f59374f = lVar;
        }

        @Override // kotlinx.coroutines.channels.c0
        @Nullable
        public d2.l<Throwable, f1> i0(E e4) {
            return kotlinx.coroutines.internal.b0.a(this.f59374f, e4, this.f59372d.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/a$d;", "E", "Lkotlinx/coroutines/channels/c0;", "value", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "i", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "Lkotlin/Function1;", "", "i0", "(Ljava/lang/Object;)Ld2/l;", "", "toString", "Lkotlinx/coroutines/channels/a$a;", "d", "Lkotlinx/coroutines/channels/a$a;", "iterator", "Lkotlinx/coroutines/o;", "", "e", "Lkotlinx/coroutines/o;", "cont", "<init>", "(Lkotlinx/coroutines/channels/a$a;Lkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d<E> extends c0<E> {
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final C1197a<E> f59375d;
        @JvmField
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public final kotlinx.coroutines.o<Boolean> f59376e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull C1197a<E> c1197a, @NotNull kotlinx.coroutines.o<? super Boolean> oVar) {
            this.f59375d = c1197a;
            this.f59376e = oVar;
        }

        @Override // kotlinx.coroutines.channels.e0
        public void i(E e4) {
            this.f59375d.setResult(e4);
            this.f59376e.S(kotlinx.coroutines.q.f60535d);
        }

        @Override // kotlinx.coroutines.channels.c0
        @Nullable
        public d2.l<Throwable, f1> i0(E e4) {
            d2.l<E, f1> lVar = this.f59375d.f59371b.f59404b;
            if (lVar != null) {
                return kotlinx.coroutines.internal.b0.a(lVar, e4, this.f59376e.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.c0
        public void j0(@NotNull t<?> tVar) {
            Object o4;
            if (tVar.f59488d == null) {
                o4 = o.a.b(this.f59376e, Boolean.FALSE, null, 2, null);
            } else {
                o4 = this.f59376e.o(tVar.o0());
            }
            if (o4 != null) {
                this.f59375d.setResult(tVar);
                this.f59376e.S(o4);
            }
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + u0.b(this);
        }

        @Override // kotlinx.coroutines.channels.e0
        @Nullable
        public kotlinx.coroutines.internal.j0 y(E e4, @Nullable s.d dVar) {
            if (this.f59376e.n(Boolean.TRUE, dVar != null ? dVar.f60410c : null, i0(e4)) != null) {
                if (dVar != null) {
                    dVar.d();
                }
                return kotlinx.coroutines.q.f60535d;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c\u0012$\u0010'\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010&\u0012\u0006\u0012\u0004\u0018\u00010%0$\u0012\u0006\u0010#\u001a\u00020 \u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/channels/a$e;", "R", "E", "Lkotlinx/coroutines/channels/c0;", "Lkotlinx/coroutines/i1;", "value", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "y", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/s$d;)Lkotlinx/coroutines/internal/j0;", "Lkotlin/f1;", "i", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "dispose", "Lkotlin/Function1;", "", "i0", "(Ljava/lang/Object;)Ld2/l;", "", "toString", "Lkotlinx/coroutines/channels/a;", "d", "Lkotlinx/coroutines/channels/a;", "channel", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "", "g", "I", "receiveMode", "Lkotlin/Function2;", "", "Lkotlin/coroutines/c;", "block", "<init>", "(Lkotlinx/coroutines/channels/a;Lkotlinx/coroutines/selects/f;Ld2/p;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<R, E> extends c0<E> implements i1 {
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final a<E> f59377d;
        @JvmField
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public final kotlinx.coroutines.selects.f<R> f59378e;
        @JvmField
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public final d2.p<Object, kotlin.coroutines.c<? super R>, Object> f59379f;
        @JvmField

        /* renamed from: g  reason: collision with root package name */
        public final int f59380g;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull a<E> aVar, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, int i4) {
            this.f59377d = aVar;
            this.f59378e = fVar;
            this.f59379f = pVar;
            this.f59380g = i4;
        }

        @Override // kotlinx.coroutines.i1
        public void dispose() {
            if (a0()) {
                this.f59377d.d0();
            }
        }

        @Override // kotlinx.coroutines.channels.e0
        public void i(E e4) {
            Object obj;
            d2.p<Object, kotlin.coroutines.c<? super R>, Object> pVar = this.f59379f;
            if (this.f59380g == 2) {
                m0.b bVar = m0.f59459b;
                obj = m0.a(m0.b(e4));
            } else {
                obj = e4;
            }
            z2.a.c(pVar, obj, this.f59378e.t(), i0(e4));
        }

        @Override // kotlinx.coroutines.channels.c0
        @Nullable
        public d2.l<Throwable, f1> i0(E e4) {
            d2.l<E, f1> lVar = this.f59377d.f59404b;
            if (lVar != null) {
                return kotlinx.coroutines.internal.b0.a(lVar, e4, this.f59378e.t().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.c0
        public void j0(@NotNull t<?> tVar) {
            if (this.f59378e.p()) {
                int i4 = this.f59380g;
                if (i4 == 0) {
                    this.f59378e.v(tVar.o0());
                } else if (i4 == 1) {
                    if (tVar.f59488d == null) {
                        z2.a.e(this.f59379f, null, this.f59378e.t(), null, 4, null);
                    } else {
                        this.f59378e.v(tVar.o0());
                    }
                } else if (i4 != 2) {
                } else {
                    d2.p<Object, kotlin.coroutines.c<? super R>, Object> pVar = this.f59379f;
                    m0.b bVar = m0.f59459b;
                    z2.a.e(pVar, m0.a(m0.b(new m0.a(tVar.f59488d))), this.f59378e.t(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + u0.b(this) + '[' + this.f59378e + ",receiveMode=" + this.f59380g + ']';
        }

        @Override // kotlinx.coroutines.channels.e0
        @Nullable
        public kotlinx.coroutines.internal.j0 y(E e4, @Nullable s.d dVar) {
            return (kotlinx.coroutines.internal.j0) this.f59378e.m(dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/a$f;", "Lkotlinx/coroutines/e;", "", "cause", "Lkotlin/f1;", "a", "", "toString", "Lkotlinx/coroutines/channels/c0;", "Lkotlinx/coroutines/channels/c0;", "receive", "<init>", "(Lkotlinx/coroutines/channels/a;Lkotlinx/coroutines/channels/c0;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class f extends kotlinx.coroutines.e {

        /* renamed from: a  reason: collision with root package name */
        private final c0<?> f59381a;

        public f(@NotNull c0<?> c0Var) {
            this.f59381a = c0Var;
        }

        @Override // kotlinx.coroutines.n
        public void a(@Nullable Throwable th) {
            if (this.f59381a.a0()) {
                a.this.d0();
            }
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            a(th);
            return f1.f55527a;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f59381a + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/a$g;", "E", "Lkotlinx/coroutines/internal/s$e;", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "Lkotlin/f1;", "k", "Lkotlinx/coroutines/internal/q;", "queue", "<init>", "(Lkotlinx/coroutines/internal/q;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g<E> extends s.e<g0> {
        public g(@NotNull kotlinx.coroutines.internal.q qVar) {
            super(qVar);
        }

        @Override // kotlinx.coroutines.internal.s.e, kotlinx.coroutines.internal.s.a
        @Nullable
        protected Object e(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (sVar instanceof t) {
                return sVar;
            }
            if (sVar instanceof g0) {
                return null;
            }
            return kotlinx.coroutines.channels.b.f59399g;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        public Object j(@NotNull s.d dVar) {
            kotlinx.coroutines.internal.s sVar = dVar.f60408a;
            if (sVar != null) {
                kotlinx.coroutines.internal.j0 k02 = ((g0) sVar).k0(dVar);
                if (k02 != null) {
                    Object obj = kotlinx.coroutines.internal.c.f60351b;
                    if (k02 == obj) {
                        return obj;
                    }
                    return null;
                }
                return kotlinx.coroutines.internal.t.f60417a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
        }

        @Override // kotlinx.coroutines.internal.s.a
        public void k(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (sVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            }
            ((g0) sVar).l0();
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
        final /* synthetic */ kotlinx.coroutines.internal.s f59383d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ a f59384e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(kotlinx.coroutines.internal.s sVar, kotlinx.coroutines.internal.s sVar2, a aVar) {
            super(sVar2);
            this.f59383d = sVar;
            this.f59384e = aVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (this.f59384e.a0()) {
                return null;
            }
            return kotlinx.coroutines.internal.r.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JJ\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"kotlinx/coroutines/channels/a$i", "Lkotlinx/coroutines/selects/d;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "I", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class i implements kotlinx.coroutines.selects.d<E> {
        i() {
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void I(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            a aVar = a.this;
            if (pVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            aVar.j0(fVar, 0, pVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JS\u0010\u000b\u001a\u00020\n\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\t\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"kotlinx/coroutines/channels/a$j", "Lkotlinx/coroutines/selects/d;", "Lkotlinx/coroutines/channels/m0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "I", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class j implements kotlinx.coroutines.selects.d<m0<? extends E>> {
        j() {
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void I(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super m0<? extends E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            a aVar = a.this;
            if (pVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            aVar.j0(fVar, 2, pVar);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001JL\u0010\n\u001a\u00020\t\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032$\u0010\b\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"kotlinx/coroutines/channels/a$k", "Lkotlinx/coroutines/selects/d;", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "I", "(Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class k implements kotlinx.coroutines.selects.d<E> {
        k() {
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void I(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super E, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            a aVar = a.this;
            if (pVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            }
            aVar.j0(fVar, 1, pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0086@"}, d2 = {"E", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/channels/m0;", "continuation", "", "receiveOrClosed"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME}, m = "receiveOrClosed-ZYPwvRU", n = {"this", "result"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59388a;

        /* renamed from: b  reason: collision with root package name */
        int f59389b;

        /* renamed from: d  reason: collision with root package name */
        Object f59391d;

        /* renamed from: e  reason: collision with root package name */
        Object f59392e;

        l(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59388a = obj;
            this.f59389b |= Integer.MIN_VALUE;
            return a.this.w(this);
        }
    }

    public a(@Nullable d2.l<? super E, f1> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(c0<? super E> c0Var) {
        boolean W = W(c0Var);
        if (W) {
            e0();
        }
        return W;
    }

    private final <R> boolean X(kotlinx.coroutines.selects.f<? super R> fVar, d2.p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, int i4) {
        e eVar = new e(this, fVar, pVar, i4);
        boolean V = V(eVar);
        if (V) {
            fVar.k(eVar);
        }
        return V;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final E h0(Object obj) {
        if (obj instanceof t) {
            Throwable th = ((t) obj).f59488d;
            if (th == null) {
                return null;
            }
            throw kotlinx.coroutines.internal.i0.p(th);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void j0(kotlinx.coroutines.selects.f<? super R> fVar, int i4, d2.p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        while (!fVar.h()) {
            if (b0()) {
                if (X(fVar, pVar, i4)) {
                    return;
                }
            } else {
                Object g02 = g0(fVar);
                if (g02 == kotlinx.coroutines.selects.g.d()) {
                    return;
                }
                if (g02 != kotlinx.coroutines.channels.b.f59399g && g02 != kotlinx.coroutines.internal.c.f60351b) {
                    l0(pVar, fVar, i4, g02);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(kotlinx.coroutines.o<?> oVar, c0<?> c0Var) {
        oVar.B(new f(c0Var));
    }

    private final <R> void l0(d2.p<Object, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, kotlinx.coroutines.selects.f<? super R> fVar, int i4, Object obj) {
        Object b4;
        boolean z3 = obj instanceof t;
        if (!z3) {
            if (i4 == 2) {
                m0.b bVar = m0.f59459b;
                if (z3) {
                    b4 = m0.b(new m0.a(((t) obj).f59488d));
                } else {
                    b4 = m0.b(obj);
                }
                z2.b.d(pVar, m0.a(b4), fVar.t());
                return;
            }
            z2.b.d(pVar, obj, fVar.t());
        } else if (i4 == 0) {
            throw kotlinx.coroutines.internal.i0.p(((t) obj).o0());
        } else {
            if (i4 != 1) {
                if (i4 == 2 && fVar.p()) {
                    m0.b bVar2 = m0.f59459b;
                    z2.b.d(pVar, m0.a(m0.b(new m0.a(((t) obj).f59488d))), fVar.t());
                    return;
                }
                return;
            }
            t tVar = (t) obj;
            if (tVar.f59488d == null) {
                if (fVar.p()) {
                    z2.b.d(pVar, null, fVar.t());
                    return;
                }
                return;
            }
            throw kotlinx.coroutines.internal.i0.p(tVar.o0());
        }
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public final kotlinx.coroutines.selects.d<E> C() {
        return new i();
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public final kotlinx.coroutines.selects.d<E> E() {
        return new k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.d0
    @Nullable
    public final Object F(@NotNull kotlin.coroutines.c<? super E> cVar) {
        Object f02 = f0();
        return (f02 == kotlinx.coroutines.channels.b.f59399g || (f02 instanceof t)) ? i0(1, cVar) : f02;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.d0
    @Nullable
    public final Object J(@NotNull kotlin.coroutines.c<? super E> cVar) {
        Object f02 = f0();
        return (f02 == kotlinx.coroutines.channels.b.f59399g || (f02 instanceof t)) ? i0(0, cVar) : f02;
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public final kotlinx.coroutines.selects.d<m0<E>> L() {
        return new j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    @Nullable
    public e0<E> M() {
        e0<E> M = super.M();
        if (M != null && !(M instanceof t)) {
            d0();
        }
        return M;
    }

    @Override // kotlinx.coroutines.channels.d0
    /* renamed from: T */
    public final boolean a(@Nullable Throwable th) {
        boolean K = K(th);
        c0(K);
        return K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g<E> U() {
        return new g<>(n());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean W(@NotNull c0<? super E> c0Var) {
        int f02;
        kotlinx.coroutines.internal.s U;
        if (Z()) {
            kotlinx.coroutines.internal.s n4 = n();
            do {
                U = n4.U();
                if (!(!(U instanceof g0))) {
                    return false;
                }
            } while (!U.J(c0Var, n4));
        } else {
            kotlinx.coroutines.internal.s n5 = n();
            h hVar = new h(c0Var, c0Var, this);
            do {
                kotlinx.coroutines.internal.s U2 = n5.U();
                if (!(!(U2 instanceof g0))) {
                    return false;
                }
                f02 = U2.f0(c0Var, n5, hVar);
                if (f02 != 1) {
                }
            } while (f02 != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Y() {
        return n().R() instanceof e0;
    }

    protected abstract boolean Z();

    protected abstract boolean a0();

    @Override // kotlinx.coroutines.channels.d0
    public final void b(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(u0.a(this) + " was cancelled");
        }
        a(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b0() {
        return !(n().R() instanceof g0) && a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c0(boolean z3) {
        t<?> m4 = m();
        if (m4 != null) {
            Object c4 = kotlinx.coroutines.internal.n.c(null, 1, null);
            while (true) {
                kotlinx.coroutines.internal.s U = m4.U();
                if (U instanceof kotlinx.coroutines.internal.q) {
                    break;
                } else if (!U.a0()) {
                    U.V();
                } else {
                    c4 = kotlinx.coroutines.internal.n.h(c4, (g0) U);
                }
            }
            if (c4 == null) {
                return;
            }
            if (!(c4 instanceof ArrayList)) {
                ((g0) c4).j0(m4);
                return;
            }
            ArrayList arrayList = (ArrayList) c4;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((g0) arrayList.get(size)).j0(m4);
            }
            return;
        }
        throw new IllegalStateException("Cannot happen".toString());
    }

    @Override // kotlinx.coroutines.channels.d0
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        b(null);
    }

    protected void d0() {
    }

    protected void e0() {
    }

    @Nullable
    protected Object f0() {
        while (true) {
            g0 N = N();
            if (N != null) {
                if (N.k0(null) != null) {
                    N.h0();
                    return N.i0();
                }
                N.l0();
            } else {
                return kotlinx.coroutines.channels.b.f59399g;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.d0
    public boolean g() {
        return l() != null && a0();
    }

    @Nullable
    protected Object g0(@NotNull kotlinx.coroutines.selects.f<?> fVar) {
        g<E> U = U();
        Object w3 = fVar.w(U);
        if (w3 != null) {
            return w3;
        }
        U.o().h0();
        return U.o().i0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.a$b] */
    @Nullable
    final /* synthetic */ <R> Object i0(int i4, @NotNull kotlin.coroutines.c<? super R> cVar) {
        kotlin.coroutines.c d4;
        c cVar2;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p b4 = kotlinx.coroutines.r.b(d4);
        if (this.f59404b == null) {
            if (b4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            }
            cVar2 = new b(b4, i4);
        } else if (b4 != null) {
            cVar2 = new c(b4, i4, this.f59404b);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
        }
        while (true) {
            if (V(cVar2)) {
                k0(b4, cVar2);
                break;
            }
            Object f02 = f0();
            if (f02 instanceof t) {
                cVar2.j0((t) f02);
                break;
            } else if (f02 != kotlinx.coroutines.channels.b.f59399g) {
                b4.T(cVar2.k0(f02), cVar2.i0(f02));
                break;
            }
        }
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Override // kotlinx.coroutines.channels.d0
    public boolean isEmpty() {
        return b0();
    }

    @Override // kotlinx.coroutines.channels.d0
    @NotNull
    public final p<E> iterator() {
        return new C1197a(this);
    }

    @Override // kotlinx.coroutines.channels.d0
    @Nullable
    public final E poll() {
        Object f02 = f0();
        if (f02 == kotlinx.coroutines.channels.b.f59399g) {
            return null;
        }
        return h0(f02);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // kotlinx.coroutines.channels.d0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w(@org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlinx.coroutines.channels.m0<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.a.l
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.a$l r0 = (kotlinx.coroutines.channels.a.l) r0
            int r1 = r0.f59389b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59389b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.a$l r0 = new kotlinx.coroutines.channels.a$l
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59388a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59389b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f59391d
            kotlinx.coroutines.channels.a r0 = (kotlinx.coroutines.channels.a) r0
            kotlin.d0.n(r5)
            goto L69
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.d0.n(r5)
            java.lang.Object r5 = r4.f0()
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.b.f59399g
            if (r5 == r2) goto L5b
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.t
            if (r0 == 0) goto L54
            kotlinx.coroutines.channels.m0$b r0 = kotlinx.coroutines.channels.m0.f59459b
            kotlinx.coroutines.channels.t r5 = (kotlinx.coroutines.channels.t) r5
            java.lang.Throwable r5 = r5.f59488d
            kotlinx.coroutines.channels.m0$a r0 = new kotlinx.coroutines.channels.m0$a
            r0.<init>(r5)
            java.lang.Object r5 = kotlinx.coroutines.channels.m0.b(r0)
            goto L5a
        L54:
            kotlinx.coroutines.channels.m0$b r0 = kotlinx.coroutines.channels.m0.f59459b
            java.lang.Object r5 = kotlinx.coroutines.channels.m0.b(r5)
        L5a:
            return r5
        L5b:
            r2 = 2
            r0.f59391d = r4
            r0.f59392e = r5
            r0.f59389b = r3
            java.lang.Object r5 = r4.i0(r2, r0)
            if (r5 != r1) goto L69
            return r1
        L69:
            kotlinx.coroutines.channels.m0 r5 = (kotlinx.coroutines.channels.m0) r5
            java.lang.Object r5 = r5.n()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.a.w(kotlin.coroutines.c):java.lang.Object");
    }
}
