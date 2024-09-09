package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuationImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000s\u0012\u0006\u0010+\u001a\u00020%\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0082\b\u00a2\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u001a\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u001d\u0010\bJB\u0010 \u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002\u00a2\u0006\u0004\b \u0010!J8\u0010#\u001a\u00020\"2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002\u00a2\u0006\u0004\b'\u0010(JZ\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0002\u00a2\u0006\u0004\b.\u0010/JH\u00100\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2%\b\u0002\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002\u00a2\u0006\u0004\b0\u00101JJ\u00103\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002\u00a2\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0002052\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002\u00a2\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b8\u0010\u000bJ\u000f\u00109\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b9\u0010\u000bJ\u000f\u0010:\u001a\u00020\u0006H\u0001\u00a2\u0006\u0004\b:\u0010\bJ\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016\u00a2\u0006\u0004\b=\u0010>J\u0011\u0010?\u001a\u0004\u0018\u00010\u001eH\u0010\u00a2\u0006\u0004\b?\u0010@J!\u0010B\u001a\u00020\t2\b\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0010\u00a2\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\bD\u0010\u0010J\u0017\u0010E\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u00a2\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bG\u0010HJ8\u0010I\u001a\u00020\t2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\bI\u0010\u001bJ\u0017\u0010L\u001a\u00020\r2\u0006\u0010K\u001a\u00020JH\u0016\u00a2\u0006\u0004\bL\u0010MJ\u0011\u0010N\u001a\u0004\u0018\u00010\u001eH\u0001\u00a2\u0006\u0004\bN\u0010@J \u0010Q\u001a\u00020\t2\f\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010RJ<\u0010\u0001\u001a\u00020\t2\u0006\u0010S\u001a\u00028\u00002#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\b\u0001\u0010TJ8\u0010U\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0016\u00a2\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\tH\u0000\u00a2\u0006\u0004\bW\u0010\u000bJ#\u0010X\u001a\u0004\u0018\u00010\u001e2\u0006\u0010S\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016\u00a2\u0006\u0004\bX\u0010YJH\u0010Z\u001a\u0004\u0018\u00010\u001e2\u0006\u0010S\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016\u00a2\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\\\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b`\u0010RJ\u001b\u0010b\u001a\u00020\t*\u00020a2\u0006\u0010S\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\bb\u0010cJ\u001b\u0010d\u001a\u00020\t*\u00020a2\u0006\u0010\\\u001a\u00020\rH\u0016\u00a2\u0006\u0004\bd\u0010eJ\u001f\u0010f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010\u00a2\u0006\u0004\bf\u0010gJ\u001b\u0010h\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010\u00a2\u0006\u0004\bh\u0010iJ\u000f\u0010k\u001a\u00020jH\u0016\u00a2\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020jH\u0014\u00a2\u0006\u0004\bm\u0010lR\u001a\u0010r\u001a\u00020n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bX\u0010o\u001a\u0004\bp\u0010qR \u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000s8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bt\u0010vR(\u0010}\u001a\u0004\u0018\u00010x2\b\u0010S\u001a\u0004\u0018\u00010x8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001e8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b~\u0010@R\u0014\u0010\u007f\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u007f\u0010\bR\u0016\u0010\u0080\u0001\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\bR\u0016\u0010\u0081\u0001\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\bR\u001f\u0010\u0084\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0087\u0001"}, d2 = {"Lkotlinx/coroutines/p;", "T", "Lkotlinx/coroutines/c1;", "Lkotlinx/coroutines/o;", "Lkotlin/coroutines/jvm/internal/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "A", "()Z", "Lkotlin/f1;", "N", "()V", "s", "", "cause", "r", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "block", "m", "(Ld2/a;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "k", "(Ld2/l;Ljava/lang/Throwable;)V", "Q", "O", "", "state", "D", "(Ld2/l;Ljava/lang/Object;)V", "Lkotlinx/coroutines/m;", "C", "(Ld2/l;)Lkotlinx/coroutines/m;", "", "mode", "v", "(I)V", "Lkotlinx/coroutines/t2;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "L", "(Lkotlinx/coroutines/t2;Ljava/lang/Object;ILd2/l;Ljava/lang/Object;)Ljava/lang/Object;", "J", "(Ljava/lang/Object;ILd2/l;)V", "Lkotlinx/coroutines/internal/j0;", "P", "(Ljava/lang/Object;Ljava/lang/Object;Ld2/l;)Lkotlinx/coroutines/internal/j0;", "", "j", "(Ljava/lang/Object;)Ljava/lang/Void;", "u", "H", "I", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "i", "()Ljava/lang/Object;", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "a", "F", "(Ljava/lang/Throwable;)V", "l", "(Lkotlinx/coroutines/m;Ljava/lang/Throwable;)V", "p", "Lkotlinx/coroutines/e2;", "parent", "w", "(Lkotlinx/coroutines/e2;)Ljava/lang/Throwable;", "y", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "(Ljava/lang/Object;Ld2/l;)V", "B", "(Ld2/l;)V", "t", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "n", "(Ljava/lang/Object;Ljava/lang/Object;Ld2/l;)Ljava/lang/Object;", "exception", "o", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "S", "Lkotlinx/coroutines/l0;", "G", "(Lkotlinx/coroutines/l0;Ljava/lang/Object;)V", CampaignEx.JSON_KEY_AD_Q, "(Lkotlinx/coroutines/l0;Ljava/lang/Throwable;)V", "g", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "E", "Lkotlin/coroutines/f;", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "e", "Lkotlin/coroutines/c;", "()Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/i1;", "x", "()Lkotlinx/coroutines/i1;", "M", "(Lkotlinx/coroutines/i1;)V", "parentHandle", "z", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/c;", "callerFrame", "<init>", "(Lkotlin/coroutines/c;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class p<T> extends c1<T> implements o<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60525f = AtomicIntegerFieldUpdater.newUpdater(p.class, "_decision");

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f60526g = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.coroutines.f f60527d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.coroutines.c<T> f60528e;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull kotlin.coroutines.c<? super T> cVar, int i4) {
        super(i4);
        this.f60528e = cVar;
        this.f60527d = cVar.getContext();
        this._decision = 0;
        this._state = b.f59055a;
        this._parentHandle = null;
    }

    private final boolean A() {
        kotlin.coroutines.c<T> cVar = this.f60528e;
        return (cVar instanceof kotlinx.coroutines.internal.j) && ((kotlinx.coroutines.internal.j) cVar).r(this);
    }

    private final m C(d2.l<? super Throwable, kotlin.f1> lVar) {
        return lVar instanceof m ? (m) lVar : new b2(lVar);
    }

    private final void D(d2.l<? super Throwable, kotlin.f1> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void J(Object obj, int i4, d2.l<? super Throwable, kotlin.f1> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof t2) {
            } else {
                if (obj2 instanceof s) {
                    s sVar = (s) obj2;
                    if (sVar.c()) {
                        if (lVar != null) {
                            p(lVar, sVar.f59534a);
                            return;
                        }
                        return;
                    }
                }
                j(obj);
                throw new KotlinNothingValueException();
            }
        } while (!io.netty.channel.a.a(f60526g, this, obj2, L((t2) obj2, obj, i4, lVar, null)));
        u();
        v(i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void K(p pVar, Object obj, int i4, d2.l lVar, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 4) != 0) {
                lVar = null;
            }
            pVar.J(obj, i4, lVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object L(t2 t2Var, Object obj, int i4, d2.l<? super Throwable, kotlin.f1> lVar, Object obj2) {
        if (obj instanceof d0) {
            return obj;
        }
        if (d1.c(i4) || obj2 != null) {
            if (lVar != null || (((t2Var instanceof m) && !(t2Var instanceof e)) || obj2 != null)) {
                if (!(t2Var instanceof m)) {
                    t2Var = null;
                }
                return new c0(obj, (m) t2Var, lVar, obj2, null, 16, null);
            }
            return obj;
        }
        return obj;
    }

    private final void M(i1 i1Var) {
        this._parentHandle = i1Var;
    }

    private final void N() {
        e2 e2Var;
        if (s() || x() != null || (e2Var = (e2) this.f60528e.getContext().get(e2.f59626i0)) == null) {
            return;
        }
        i1 f4 = e2.a.f(e2Var, true, false, new t(e2Var, this), 2, null);
        M(f4);
        if (!isCompleted() || A()) {
            return;
        }
        f4.dispose();
        M(s2.f60556a);
    }

    private final boolean O() {
        do {
            int i4 = this._decision;
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f60525f.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.j0 P(Object obj, Object obj2, d2.l<? super Throwable, kotlin.f1> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof t2) {
            } else if ((obj3 instanceof c0) && obj2 != null && ((c0) obj3).f59068d == obj2) {
                return q.f60535d;
            } else {
                return null;
            }
        } while (!io.netty.channel.a.a(f60526g, this, obj3, L((t2) obj3, obj, this.f59070c, lVar, obj2)));
        u();
        return q.f60535d;
    }

    private final boolean Q() {
        do {
            int i4 = this._decision;
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f60525f.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void j(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void k(d2.l<? super Throwable, kotlin.f1> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            kotlin.coroutines.f context = getContext();
            n0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final void m(d2.a<kotlin.f1> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            kotlin.coroutines.f context = getContext();
            n0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean r(Throwable th) {
        if (d1.d(this.f59070c)) {
            kotlin.coroutines.c<T> cVar = this.f60528e;
            if (!(cVar instanceof kotlinx.coroutines.internal.j)) {
                cVar = null;
            }
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) cVar;
            if (jVar != null) {
                return jVar.s(th);
            }
            return false;
        }
        return false;
    }

    private final boolean s() {
        Throwable j4;
        boolean isCompleted = isCompleted();
        if (d1.d(this.f59070c)) {
            kotlin.coroutines.c<T> cVar = this.f60528e;
            if (!(cVar instanceof kotlinx.coroutines.internal.j)) {
                cVar = null;
            }
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) cVar;
            if (jVar == null || (j4 = jVar.j(this)) == null) {
                return isCompleted;
            }
            if (!isCompleted) {
                a(j4);
            }
            return true;
        }
        return isCompleted;
    }

    private final void u() {
        if (A()) {
            return;
        }
        t();
    }

    private final void v(int i4) {
        if (O()) {
            return;
        }
        d1.a(this, i4);
    }

    private final i1 x() {
        return (i1) this._parentHandle;
    }

    @Override // kotlinx.coroutines.o
    public void B(@NotNull d2.l<? super Throwable, kotlin.f1> lVar) {
        m C = C(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                if (io.netty.channel.a.a(f60526g, this, obj, C)) {
                    return;
                }
            } else if (obj instanceof m) {
                D(lVar, obj);
            } else {
                boolean z3 = obj instanceof d0;
                if (z3) {
                    if (!((d0) obj).b()) {
                        D(lVar, obj);
                    }
                    if (obj instanceof s) {
                        if (!z3) {
                            obj = null;
                        }
                        d0 d0Var = (d0) obj;
                        k(lVar, d0Var != null ? d0Var.f59534a : null);
                        return;
                    }
                    return;
                } else if (obj instanceof c0) {
                    c0 c0Var = (c0) obj;
                    if (c0Var.f59066b != null) {
                        D(lVar, obj);
                    }
                    if (C instanceof e) {
                        return;
                    }
                    if (c0Var.h()) {
                        k(lVar, c0Var.f59069e);
                        return;
                    } else {
                        if (io.netty.channel.a.a(f60526g, this, obj, c0.g(c0Var, null, C, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (C instanceof e) {
                    return;
                } else {
                    if (io.netty.channel.a.a(f60526g, this, obj, new c0(obj, C, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    protected String E() {
        return "CancellableContinuation";
    }

    public final void F(@NotNull Throwable th) {
        if (r(th)) {
            return;
        }
        a(th);
        u();
    }

    @Override // kotlinx.coroutines.o
    public void G(@NotNull l0 l0Var, T t3) {
        kotlin.coroutines.c<T> cVar = this.f60528e;
        if (!(cVar instanceof kotlinx.coroutines.internal.j)) {
            cVar = null;
        }
        kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) cVar;
        K(this, t3, (jVar != null ? jVar.f60372g : null) == l0Var ? 4 : this.f59070c, null, 4, null);
    }

    @Override // kotlinx.coroutines.o
    public void H() {
        N();
    }

    @JvmName(name = "resetStateReusable")
    public final boolean I() {
        Object obj = this._state;
        if ((obj instanceof c0) && ((c0) obj).f59068d != null) {
            t();
            return false;
        }
        this._decision = 0;
        this._state = b.f59055a;
        return true;
    }

    @Override // kotlinx.coroutines.o
    public void S(@NotNull Object obj) {
        v(this.f59070c);
    }

    @Override // kotlinx.coroutines.o
    public void T(T t3, @Nullable d2.l<? super Throwable, kotlin.f1> lVar) {
        J(t3, this.f59070c, lVar);
    }

    @Override // kotlinx.coroutines.o
    public boolean a(@Nullable Throwable th) {
        Object obj;
        boolean z3;
        do {
            obj = this._state;
            if (!(obj instanceof t2)) {
                return false;
            }
            z3 = obj instanceof m;
        } while (!io.netty.channel.a.a(f60526g, this, obj, new s(this, th, z3)));
        if (!z3) {
            obj = null;
        }
        m mVar = (m) obj;
        if (mVar != null) {
            l(mVar, th);
        }
        u();
        v(this.f59070c);
        return true;
    }

    @Override // kotlinx.coroutines.c1
    public void c(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof t2)) {
                if (obj2 instanceof d0) {
                    return;
                }
                if (obj2 instanceof c0) {
                    c0 c0Var = (c0) obj2;
                    if (!c0Var.h()) {
                        if (io.netty.channel.a.a(f60526g, this, obj2, c0.g(c0Var, null, null, null, null, th, 15, null))) {
                            c0Var.i(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (io.netty.channel.a.a(f60526g, this, obj2, new c0(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.o
    @Nullable
    public Object d(T t3, @Nullable Object obj) {
        return P(t3, obj, null);
    }

    @Override // kotlinx.coroutines.c1
    @NotNull
    public final kotlin.coroutines.c<T> e() {
        return this.f60528e;
    }

    @Override // kotlinx.coroutines.c1
    @Nullable
    public Throwable f(@Nullable Object obj) {
        Throwable f4 = super.f(obj);
        if (f4 != null) {
            return f4;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.c1
    public <T> T g(@Nullable Object obj) {
        return obj instanceof c0 ? (T) ((c0) obj).f59065a : obj;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f60528e;
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        return (kotlin.coroutines.jvm.internal.c) cVar;
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public kotlin.coroutines.f getContext() {
        return this.f60527d;
    }

    @Override // kotlin.coroutines.jvm.internal.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.c1
    @Nullable
    public Object i() {
        return z();
    }

    @Override // kotlinx.coroutines.o
    public boolean isActive() {
        return z() instanceof t2;
    }

    @Override // kotlinx.coroutines.o
    public boolean isCancelled() {
        return z() instanceof s;
    }

    @Override // kotlinx.coroutines.o
    public boolean isCompleted() {
        return !(z() instanceof t2);
    }

    public final void l(@NotNull m mVar, @Nullable Throwable th) {
        try {
            mVar.a(th);
        } catch (Throwable th2) {
            kotlin.coroutines.f context = getContext();
            n0.b(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.o
    @Nullable
    public Object n(T t3, @Nullable Object obj, @Nullable d2.l<? super Throwable, kotlin.f1> lVar) {
        return P(t3, obj, lVar);
    }

    @Override // kotlinx.coroutines.o
    @Nullable
    public Object o(@NotNull Throwable th) {
        return P(new d0(th, false, 2, null), null, null);
    }

    public final void p(@NotNull d2.l<? super Throwable, kotlin.f1> lVar, @NotNull Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            kotlin.coroutines.f context = getContext();
            n0.b(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.o
    public void q(@NotNull l0 l0Var, @NotNull Throwable th) {
        kotlin.coroutines.c<T> cVar = this.f60528e;
        if (!(cVar instanceof kotlinx.coroutines.internal.j)) {
            cVar = null;
        }
        kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) cVar;
        K(this, new d0(th, false, 2, null), (jVar != null ? jVar.f60372g : null) == l0Var ? 4 : this.f59070c, null, 4, null);
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(@NotNull Object obj) {
        K(this, i0.c(obj, this), this.f59070c, null, 4, null);
    }

    public final void t() {
        i1 x3 = x();
        if (x3 != null) {
            x3.dispose();
        }
        M(s2.f60556a);
    }

    @NotNull
    public String toString() {
        return E() + '(' + u0.c(this.f60528e) + "){" + z() + "}@" + u0.b(this);
    }

    @NotNull
    public Throwable w(@NotNull e2 e2Var) {
        return e2Var.l();
    }

    @PublishedApi
    @Nullable
    public final Object y() {
        e2 e2Var;
        Object h4;
        N();
        if (Q()) {
            h4 = kotlin.coroutines.intrinsics.b.h();
            return h4;
        }
        Object z3 = z();
        if (!(z3 instanceof d0)) {
            if (d1.c(this.f59070c) && (e2Var = (e2) getContext().get(e2.f59626i0)) != null && !e2Var.isActive()) {
                CancellationException l4 = e2Var.l();
                c(z3, l4);
                throw l4;
            }
            return g(z3);
        }
        throw ((d0) z3).f59534a;
    }

    @Nullable
    public final Object z() {
        return this._state;
    }
}
