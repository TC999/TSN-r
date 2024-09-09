package kotlinx.coroutines.channels;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004GghiB)\u0012 \u0010e\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u000106j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`d\u00a2\u0006\u0004\bf\u0010:J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u0018\u001a\u00020\n\"\u0004\b\u0001\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0003\u001a\u00028\u00002(\u0010\u0017\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0004\u00a2\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010$2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b%\u0010&J#\u0010)\u001a\u000e\u0012\u0002\b\u00030'j\u0006\u0012\u0002\b\u0003`(2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020-2\u0006\u0010\u0003\u001a\u00028\u0000\u00a2\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010,J\u0019\u00102\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020!H\u0014\u00a2\u0006\u0004\b2\u00103J\u0019\u00104\u001a\u00020-2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b4\u00105J)\u00109\u001a\u00020\n2\u0018\u00108\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n06j\u0002`7H\u0016\u00a2\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020;H\u0014\u00a2\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$H\u0014\u00a2\u0006\u0004\b>\u0010?J\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004\u00a2\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016\u00a2\u0006\u0004\bD\u0010ER\u001a\u0010K\u001a\u00020F8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020C8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010ER\u0014\u0010P\u001a\u00020-8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020-8$X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010OR\u001a\u0010U\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010W\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010Y\u001a\u00020-8F\u00a2\u0006\u0006\u001a\u0004\bX\u0010OR\u0014\u0010[\u001a\u00020-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010OR\u0014\u0010]\u001a\u00020-8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010OR#\u0010a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020^8F\u00a2\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020C8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010E\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006j"}, d2 = {"Lkotlinx/coroutines/channels/c;", "E", "Lkotlinx/coroutines/channels/h0;", "element", "Lkotlinx/coroutines/channels/t;", "closed", "", "s", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/t;)Ljava/lang/Throwable;", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "u", "(Lkotlin/coroutines/c;Ljava/lang/Object;Lkotlinx/coroutines/channels/t;)V", "cause", "v", "(Ljava/lang/Throwable;)V", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/channels/t;)V", "R", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "", "block", "G", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "", "e", "()I", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "B", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/g0;", "N", "()Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/channels/e0;", "H", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/internal/AddLastDesc;", "h", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/s$b;", "O", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "I", "send", "j", "(Lkotlinx/coroutines/channels/g0;)Ljava/lang/Object;", "K", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "f", "(Ld2/l;)V", "Lkotlinx/coroutines/internal/s;", "D", "(Lkotlinx/coroutines/internal/s;)V", "M", "()Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/channels/c$d;", "i", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/c$d;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/internal/q;", "a", "Lkotlinx/coroutines/internal/q;", "n", "()Lkotlinx/coroutines/internal/q;", "queue", "o", "queueDebugStateString", "x", "()Z", "isBufferAlwaysFull", "y", "isBufferFull", "m", "()Lkotlinx/coroutines/channels/t;", "closedForSend", "l", "closedForReceive", "P", "isClosedForSend", "p", "isFull", "z", "isFullImpl", "Lkotlinx/coroutines/selects/e;", "r", "()Lkotlinx/coroutines/selects/e;", "onSend", "k", "bufferDebugString", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "b", "c", "d", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c<E> implements h0<E> {

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f59402c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    @JvmField
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    protected final d2.l<E, f1> f59404b;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlinx.coroutines.internal.q f59403a = new kotlinx.coroutines.internal.q();
    private volatile Object onCloseHandler = null;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/channels/c$a;", "E", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "k0", "Lkotlin/f1;", "h0", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "", "toString", "d", "Ljava/lang/Object;", "element", "", "i0", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<E> extends g0 {
        @JvmField

        /* renamed from: d  reason: collision with root package name */
        public final E f59405d;

        public a(E e4) {
            this.f59405d = e4;
        }

        @Override // kotlinx.coroutines.channels.g0
        public void h0() {
        }

        @Override // kotlinx.coroutines.channels.g0
        @Nullable
        public Object i0() {
            return this.f59405d;
        }

        @Override // kotlinx.coroutines.channels.g0
        public void j0(@NotNull t<?> tVar) {
        }

        @Override // kotlinx.coroutines.channels.g0
        @Nullable
        public kotlinx.coroutines.internal.j0 k0(@Nullable s.d dVar) {
            kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.q.f60535d;
            if (dVar != null) {
                dVar.d();
            }
            return j0Var;
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "SendBuffered@" + u0.b(this) + '(' + this.f59405d + ')';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00028\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/c$b;", "E", "Lkotlinx/coroutines/internal/s$b;", "Lkotlinx/coroutines/channels/c$a;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/q;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/q;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class b<E> extends s.b<a<? extends E>> {
        public b(@NotNull kotlinx.coroutines.internal.q qVar, E e4) {
            super(qVar, new a(e4));
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        protected Object e(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (sVar instanceof t) {
                return sVar;
            }
            if (sVar instanceof e0) {
                return kotlinx.coroutines.channels.b.f59398f;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u0016\u001a\u00028\u0001\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b\u0012(\u0010#\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 \u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001f\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u00020\t2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0016\u001a\u00028\u00018\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00178\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00020\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/c$c;", "E", "R", "Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "k0", "Lkotlin/f1;", "h0", "dispose", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "l0", "", "toString", "d", "Ljava/lang/Object;", "i0", "()Ljava/lang/Object;", "pollResult", "Lkotlinx/coroutines/channels/c;", "e", "Lkotlinx/coroutines/channels/c;", "channel", "Lkotlinx/coroutines/selects/f;", "f", "Lkotlinx/coroutines/selects/f;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/c;Lkotlinx/coroutines/selects/f;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1198c<E, R> extends g0 implements i1 {

        /* renamed from: d  reason: collision with root package name */
        private final E f59406d;
        @JvmField
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        public final c<E> f59407e;
        @JvmField
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public final kotlinx.coroutines.selects.f<R> f59408f;
        @JvmField
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        public final d2.p<h0<? super E>, kotlin.coroutines.c<? super R>, Object> f59409g;

        /* JADX WARN: Multi-variable type inference failed */
        public C1198c(E e4, @NotNull c<E> cVar, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            this.f59406d = e4;
            this.f59407e = cVar;
            this.f59408f = fVar;
            this.f59409g = pVar;
        }

        @Override // kotlinx.coroutines.i1
        public void dispose() {
            if (a0()) {
                l0();
            }
        }

        @Override // kotlinx.coroutines.channels.g0
        public void h0() {
            z2.a.e(this.f59409g, this.f59407e, this.f59408f.t(), null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.g0
        public E i0() {
            return this.f59406d;
        }

        @Override // kotlinx.coroutines.channels.g0
        public void j0(@NotNull t<?> tVar) {
            if (this.f59408f.p()) {
                this.f59408f.v(tVar.p0());
            }
        }

        @Override // kotlinx.coroutines.channels.g0
        @Nullable
        public kotlinx.coroutines.internal.j0 k0(@Nullable s.d dVar) {
            return (kotlinx.coroutines.internal.j0) this.f59408f.m(dVar);
        }

        @Override // kotlinx.coroutines.channels.g0
        public void l0() {
            d2.l<E, f1> lVar = this.f59407e.f59404b;
            if (lVar != null) {
                kotlinx.coroutines.internal.b0.b(lVar, i0(), this.f59408f.t().getContext());
            }
        }

        @Override // kotlinx.coroutines.internal.s
        @NotNull
        public String toString() {
            return "SendSelect@" + u0.b(this) + '(' + i0() + ")[" + this.f59407e + ", " + this.f59408f + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u000e\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016R\u0014\u0010\u000e\u001a\u00028\u00018\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/c$d;", "E", "Lkotlinx/coroutines/internal/s$e;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/s;", "affected", "", "e", "Lkotlinx/coroutines/internal/s$d;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "Ljava/lang/Object;", "element", "Lkotlinx/coroutines/internal/q;", "queue", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/q;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<E> extends s.e<e0<? super E>> {
        @JvmField

        /* renamed from: e  reason: collision with root package name */
        public final E f59410e;

        public d(E e4, @NotNull kotlinx.coroutines.internal.q qVar) {
            super(qVar);
            this.f59410e = e4;
        }

        @Override // kotlinx.coroutines.internal.s.e, kotlinx.coroutines.internal.s.a
        @Nullable
        protected Object e(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (sVar instanceof t) {
                return sVar;
            }
            if (sVar instanceof e0) {
                return null;
            }
            return kotlinx.coroutines.channels.b.f59398f;
        }

        @Override // kotlinx.coroutines.internal.s.a
        @Nullable
        public Object j(@NotNull s.d dVar) {
            kotlinx.coroutines.internal.s sVar = dVar.f60408a;
            if (sVar != null) {
                kotlinx.coroutines.internal.j0 y3 = ((e0) sVar).y(this.f59410e, dVar);
                if (y3 != null) {
                    Object obj = kotlinx.coroutines.internal.c.f60351b;
                    if (y3 == obj) {
                        return obj;
                    }
                    return null;
                }
                return kotlinx.coroutines.internal.t.f60417a;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: LockFreeLinkedList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/s$f", "Lkotlinx/coroutines/internal/s$c;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends s.c {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.s f59411d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c f59412e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(kotlinx.coroutines.internal.s sVar, kotlinx.coroutines.internal.s sVar2, c cVar) {
            super(sVar2);
            this.f59411d = sVar;
            this.f59412e = cVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull kotlinx.coroutines.internal.s sVar) {
            if (this.f59412e.y()) {
                return null;
            }
            return kotlinx.coroutines.internal.r.a();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001JX\u0010\f\u001a\u00020\u000b\"\u0004\b\u0001\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u00002(\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"kotlinx/coroutines/channels/c$f", "Lkotlinx/coroutines/selects/e;", "Lkotlinx/coroutines/channels/h0;", "R", "Lkotlinx/coroutines/selects/f;", "select", "param", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "Lkotlin/f1;", "D", "(Lkotlinx/coroutines/selects/f;Ljava/lang/Object;Ld2/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f implements kotlinx.coroutines.selects.e<E, h0<? super E>> {
        f() {
        }

        @Override // kotlinx.coroutines.selects.e
        public <R> void D(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, E e4, @NotNull d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
            c.this.G(fVar, e4, pVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@Nullable d2.l<? super E, f1> lVar) {
        this.f59404b = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void G(kotlinx.coroutines.selects.f<? super R> fVar, E e4, d2.p<? super h0<? super E>, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        while (!fVar.h()) {
            if (z()) {
                C1198c c1198c = new C1198c(e4, this, fVar, pVar);
                Object j4 = j(c1198c);
                if (j4 == null) {
                    fVar.k(c1198c);
                    return;
                } else if (!(j4 instanceof t)) {
                    if (j4 != kotlinx.coroutines.channels.b.f59400h && !(j4 instanceof c0)) {
                        throw new IllegalStateException(("enqueueSend returned " + j4 + ' ').toString());
                    }
                } else {
                    throw kotlinx.coroutines.internal.i0.p(s(e4, (t) j4));
                }
            }
            Object B = B(e4, fVar);
            if (B == kotlinx.coroutines.selects.g.d()) {
                return;
            }
            if (B != kotlinx.coroutines.channels.b.f59398f && B != kotlinx.coroutines.internal.c.f60351b) {
                if (B == kotlinx.coroutines.channels.b.f59397e) {
                    z2.b.d(pVar, this, fVar.t());
                    return;
                } else if (B instanceof t) {
                    throw kotlinx.coroutines.internal.i0.p(s(e4, (t) B));
                } else {
                    throw new IllegalStateException(("offerSelectInternal returned " + B).toString());
                }
            }
        }
    }

    private final int e() {
        kotlinx.coroutines.internal.q qVar = this.f59403a;
        Object Q = qVar.Q();
        if (Q != null) {
            int i4 = 0;
            for (kotlinx.coroutines.internal.s sVar = (kotlinx.coroutines.internal.s) Q; !kotlin.jvm.internal.f0.g(sVar, qVar); sVar = sVar.R()) {
                if (sVar instanceof kotlinx.coroutines.internal.s) {
                    i4++;
                }
            }
            return i4;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    private final String o() {
        String str;
        kotlinx.coroutines.internal.s R = this.f59403a.R();
        if (R == this.f59403a) {
            return "EmptyQueue";
        }
        if (R instanceof t) {
            str = R.toString();
        } else if (R instanceof c0) {
            str = "ReceiveQueued";
        } else if (R instanceof g0) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + R;
        }
        kotlinx.coroutines.internal.s U = this.f59403a.U();
        if (U != R) {
            String str2 = str + ",queueSize=" + e();
            if (U instanceof t) {
                return str2 + ",closedForSend=" + U;
            }
            return str2;
        }
        return str;
    }

    private final void q(t<?> tVar) {
        Object c4 = kotlinx.coroutines.internal.n.c(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.s U = tVar.U();
            if (!(U instanceof c0)) {
                U = null;
            }
            c0 c0Var = (c0) U;
            if (c0Var == null) {
                break;
            } else if (!c0Var.a0()) {
                c0Var.V();
            } else {
                c4 = kotlinx.coroutines.internal.n.h(c4, c0Var);
            }
        }
        if (c4 != null) {
            if (!(c4 instanceof ArrayList)) {
                ((c0) c4).j0(tVar);
            } else {
                ArrayList arrayList = (ArrayList) c4;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((c0) arrayList.get(size)).j0(tVar);
                }
            }
        }
        D(tVar);
    }

    private final Throwable s(E e4, t<?> tVar) {
        UndeliveredElementException d4;
        q(tVar);
        d2.l<E, f1> lVar = this.f59404b;
        if (lVar != null && (d4 = kotlinx.coroutines.internal.b0.d(lVar, e4, null, 2, null)) != null) {
            kotlin.j.a(d4, tVar.p0());
            throw d4;
        }
        return tVar.p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(kotlin.coroutines.c<?> cVar, E e4, t<?> tVar) {
        UndeliveredElementException d4;
        q(tVar);
        Throwable p02 = tVar.p0();
        d2.l<E, f1> lVar = this.f59404b;
        if (lVar != null && (d4 = kotlinx.coroutines.internal.b0.d(lVar, e4, null, 2, null)) != null) {
            kotlin.j.a(d4, p02);
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(d4)));
            return;
        }
        Result.a aVar2 = Result.Companion;
        cVar.resumeWith(Result.m119constructorimpl(kotlin.d0.a(p02)));
    }

    private final void v(Throwable th) {
        kotlinx.coroutines.internal.j0 j0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (j0Var = kotlinx.coroutines.channels.b.f59401i) || !io.netty.channel.a.a(f59402c, this, obj, j0Var)) {
            return;
        }
        ((d2.l) t0.q(obj, 1)).invoke(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object A(E e4) {
        e0<E> M;
        do {
            M = M();
            if (M == null) {
                return kotlinx.coroutines.channels.b.f59398f;
            }
        } while (M.y(e4, null) == null);
        M.i(e4);
        return M.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object B(E e4, @NotNull kotlinx.coroutines.selects.f<?> fVar) {
        d<E> i4 = i(e4);
        Object w3 = fVar.w(i4);
        if (w3 != null) {
            return w3;
        }
        e0<? super E> o4 = i4.o();
        o4.i(e4);
        return o4.e();
    }

    protected void D(@NotNull kotlinx.coroutines.internal.s sVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final e0<?> H(E e4) {
        kotlinx.coroutines.internal.s U;
        kotlinx.coroutines.internal.s sVar = this.f59403a;
        a aVar = new a(e4);
        do {
            U = sVar.U();
            if (U instanceof e0) {
                return (e0) U;
            }
        } while (!U.J(aVar, sVar));
        return null;
    }

    @Nullable
    final /* synthetic */ Object I(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        g0 j0Var;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p b4 = kotlinx.coroutines.r.b(d4);
        while (true) {
            if (z()) {
                if (this.f59404b == null) {
                    j0Var = new i0(e4, b4);
                } else {
                    j0Var = new j0(e4, b4, this.f59404b);
                }
                Object j4 = j(j0Var);
                if (j4 == null) {
                    kotlinx.coroutines.r.c(b4, j0Var);
                    break;
                } else if (j4 instanceof t) {
                    u(b4, e4, (t) j4);
                    break;
                } else if (j4 != kotlinx.coroutines.channels.b.f59400h && !(j4 instanceof c0)) {
                    throw new IllegalStateException(("enqueueSend returned " + j4).toString());
                }
            }
            Object A = A(e4);
            if (A == kotlinx.coroutines.channels.b.f59397e) {
                f1 f1Var = f1.f55527a;
                Result.a aVar = Result.Companion;
                b4.resumeWith(Result.m119constructorimpl(f1Var));
                break;
            } else if (A != kotlinx.coroutines.channels.b.f59398f) {
                if (A instanceof t) {
                    u(b4, e4, (t) A);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + A).toString());
                }
            }
        }
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean K(@Nullable Throwable th) {
        boolean z3;
        t<?> tVar = new t<>(th);
        kotlinx.coroutines.internal.s sVar = this.f59403a;
        while (true) {
            kotlinx.coroutines.internal.s U = sVar.U();
            z3 = true;
            if (!(!(U instanceof t))) {
                z3 = false;
                break;
            } else if (U.J(tVar, sVar)) {
                break;
            }
        }
        if (!z3) {
            kotlinx.coroutines.internal.s U2 = this.f59403a.U();
            if (U2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
            tVar = (t) U2;
        }
        q(tVar);
        if (z3) {
            v(th);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlinx.coroutines.channels.e0<E> M() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.q r0 = r4.f59403a
        L2:
            java.lang.Object r1 = r0.Q()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.s) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.e0
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.e0 r2 = (kotlinx.coroutines.channels.e0) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.t
            if (r2 == 0) goto L22
            boolean r2 = r1.X()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.s r2 = r1.d0()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.e0 r1 = (kotlinx.coroutines.channels.e0) r1
            return r1
        L2b:
            r2.W()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.M():kotlinx.coroutines.channels.e0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        r1 = null;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.channels.g0 N() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.q r0 = r4.f59403a
        L2:
            java.lang.Object r1 = r0.Q()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.s r1 = (kotlinx.coroutines.internal.s) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.g0
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.g0 r2 = (kotlinx.coroutines.channels.g0) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.t
            if (r2 == 0) goto L22
            boolean r2 = r1.X()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.s r2 = r1.d0()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.g0 r1 = (kotlinx.coroutines.channels.g0) r1
            return r1
        L2b:
            r2.W()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.N():kotlinx.coroutines.channels.g0");
    }

    @Override // kotlinx.coroutines.channels.h0
    @Nullable
    public final Object O(E e4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        if (A(e4) == kotlinx.coroutines.channels.b.f59397e) {
            return f1.f55527a;
        }
        Object I = I(e4, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return I == h4 ? I : f1.f55527a;
    }

    @Override // kotlinx.coroutines.channels.h0
    public final boolean P() {
        return m() != null;
    }

    @Override // kotlinx.coroutines.channels.h0
    public void f(@NotNull d2.l<? super Throwable, f1> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f59402c;
        if (!io.netty.channel.a.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj == kotlinx.coroutines.channels.b.f59401i) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        t<?> m4 = m();
        if (m4 == null || !io.netty.channel.a.a(atomicReferenceFieldUpdater, this, lVar, kotlinx.coroutines.channels.b.f59401i)) {
            return;
        }
        lVar.invoke(m4.f59488d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final s.b<?> h(E e4) {
        return new b(this.f59403a, e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final d<E> i(E e4) {
        return new d<>(e4, this.f59403a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Object j(@NotNull g0 g0Var) {
        boolean z3;
        kotlinx.coroutines.internal.s U;
        if (x()) {
            kotlinx.coroutines.internal.s sVar = this.f59403a;
            do {
                U = sVar.U();
                if (U instanceof e0) {
                    return U;
                }
            } while (!U.J(g0Var, sVar));
            return null;
        }
        kotlinx.coroutines.internal.s sVar2 = this.f59403a;
        e eVar = new e(g0Var, g0Var, this);
        while (true) {
            kotlinx.coroutines.internal.s U2 = sVar2.U();
            if (!(U2 instanceof e0)) {
                int f02 = U2.f0(g0Var, sVar2, eVar);
                z3 = true;
                if (f02 != 1) {
                    if (f02 == 2) {
                        z3 = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return U2;
            }
        }
        if (z3) {
            return null;
        }
        return kotlinx.coroutines.channels.b.f59400h;
    }

    @NotNull
    protected String k() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final t<?> l() {
        kotlinx.coroutines.internal.s R = this.f59403a.R();
        if (!(R instanceof t)) {
            R = null;
        }
        t<?> tVar = (t) R;
        if (tVar != null) {
            q(tVar);
            return tVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final t<?> m() {
        kotlinx.coroutines.internal.s U = this.f59403a.U();
        if (!(U instanceof t)) {
            U = null;
        }
        t<?> tVar = (t) U;
        if (tVar != null) {
            q(tVar);
            return tVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlinx.coroutines.internal.q n() {
        return this.f59403a;
    }

    @Override // kotlinx.coroutines.channels.h0
    public final boolean offer(E e4) {
        Object A = A(e4);
        if (A == kotlinx.coroutines.channels.b.f59397e) {
            return true;
        }
        if (A == kotlinx.coroutines.channels.b.f59398f) {
            t<?> m4 = m();
            if (m4 == null) {
                return false;
            }
            throw kotlinx.coroutines.internal.i0.p(s(e4, m4));
        } else if (A instanceof t) {
            throw kotlinx.coroutines.internal.i0.p(s(e4, (t) A));
        } else {
            throw new IllegalStateException(("offerInternal returned " + A).toString());
        }
    }

    @Override // kotlinx.coroutines.channels.h0
    public boolean p() {
        return z();
    }

    @Override // kotlinx.coroutines.channels.h0
    @NotNull
    public final kotlinx.coroutines.selects.e<E, h0<E>> r() {
        return new f();
    }

    @NotNull
    public String toString() {
        return u0.a(this) + '@' + u0.b(this) + '{' + o() + '}' + k();
    }

    protected abstract boolean x();

    protected abstract boolean y();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z() {
        return !(this.f59403a.R() instanceof e0) && y();
    }
}
