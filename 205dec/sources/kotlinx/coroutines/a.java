package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractCoroutine.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u0019\u0012\u0006\u00105\u001a\u00020-\u0012\b\b\u0002\u0010:\u001a\u00020\u0010\u00a2\u0006\u0004\b;\u0010<J\u000f\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0014J\u000f\u0010\n\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0004J\u001e\u0010\u001a\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0010\u00a2\u0006\u0004\b\u001f\u0010 J6\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u001c\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150#\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&JO\u0010+\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\u0006\u0010\"\u001a\u00020!2\u0006\u0010(\u001a\u00028\u00012'\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00150)\u00a2\u0006\u0002\b*\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,R\u001d\u00103\u001a\u00020-8\u0006\u00a2\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020-8\u0004X\u0085\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010/R\u0014\u00107\u001a\u00020-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00101R\u0014\u00108\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lkotlinx/coroutines/a;", "T", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/c;", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "m1", "()V", "p1", "T0", "value", "o1", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "n1", "", "g0", "", "state", "S0", "Lkotlin/Result;", "result", "resumeWith", "k1", "exception", "A0", "(Ljava/lang/Throwable;)V", "M0", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "block", "q1", "(Lkotlinx/coroutines/CoroutineStart;Ld2/l;)V", "R", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "r1", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Ld2/p;)V", "Lkotlin/coroutines/f;", "b", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "getContext$annotations", "context", "c", "parentContext", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a<T> extends l2 implements e2, kotlin.coroutines.c<T>, q0 {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.coroutines.f f59031b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    protected final kotlin.coroutines.f f59032c;

    public /* synthetic */ a(kotlin.coroutines.f fVar, boolean z3, int i4, kotlin.jvm.internal.u uVar) {
        this(fVar, (i4 & 2) != 0 ? true : z3);
    }

    public static /* synthetic */ void l1() {
    }

    @Override // kotlinx.coroutines.l2
    public final void A0(@NotNull Throwable th) {
        n0.b(this.f59031b, th);
    }

    @Override // kotlinx.coroutines.l2
    @NotNull
    public String M0() {
        String b4 = k0.b(this.f59031b);
        if (b4 != null) {
            return '\"' + b4 + "\":" + super.M0();
        }
        return super.M0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.l2
    protected final void S0(@Nullable Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            n1(d0Var.f59534a, d0Var.a());
            return;
        }
        o1(obj);
    }

    @Override // kotlinx.coroutines.l2
    public final void T0() {
        p1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.l2
    @NotNull
    public String g0() {
        return u0.a(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.c
    @NotNull
    public final kotlin.coroutines.f getContext() {
        return this.f59031b;
    }

    @Override // kotlinx.coroutines.q0
    @NotNull
    public kotlin.coroutines.f getCoroutineContext() {
        return this.f59031b;
    }

    @Override // kotlinx.coroutines.l2, kotlinx.coroutines.e2
    public boolean isActive() {
        return super.isActive();
    }

    protected void k1(@Nullable Object obj) {
        Y(obj);
    }

    public final void m1() {
        B0((e2) this.f59032c.get(e2.f59626i0));
    }

    protected void n1(@NotNull Throwable th, boolean z3) {
    }

    protected void o1(T t3) {
    }

    protected void p1() {
    }

    public final void q1(@NotNull CoroutineStart coroutineStart, @NotNull d2.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar) {
        m1();
        coroutineStart.invoke(lVar, this);
    }

    public final <R> void r1(@NotNull CoroutineStart coroutineStart, R r3, @NotNull d2.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        m1();
        coroutineStart.invoke(pVar, r3, this);
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(@NotNull Object obj) {
        Object K0 = K0(i0.d(obj, null, 1, null));
        if (K0 == m2.f60498b) {
            return;
        }
        k1(K0);
    }

    public a(@NotNull kotlin.coroutines.f fVar, boolean z3) {
        super(z3);
        this.f59032c = fVar;
        this.f59031b = fVar.plus(this);
    }
}
