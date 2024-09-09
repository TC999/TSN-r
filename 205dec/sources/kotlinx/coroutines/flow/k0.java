package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StateFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/k0;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/i0;", "flow", "", "c", "(Lkotlinx/coroutines/flow/i0;)Z", "", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i0;)[Lkotlin/coroutines/c;", "f", "()V", "g", "()Z", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k0 extends kotlinx.coroutines.flow.internal.c<i0<?>> {

    /* renamed from: a  reason: collision with root package name */
    static final AtomicReferenceFieldUpdater f60185a = AtomicReferenceFieldUpdater.newUpdater(k0.class, Object.class, "_state");
    volatile Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.c
    /* renamed from: c */
    public boolean a(@NotNull i0<?> i0Var) {
        kotlinx.coroutines.internal.j0 j0Var;
        if (this._state != null) {
            return false;
        }
        j0Var = j0.f60182a;
        this._state = j0Var;
        return true;
    }

    @Nullable
    public final Object d(@NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        kotlinx.coroutines.internal.j0 j0Var;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(d4, 1);
        pVar.H();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60185a;
        j0Var = j0.f60182a;
        if (!io.netty.channel.a.a(atomicReferenceFieldUpdater, this, j0Var, pVar)) {
            f1 f1Var = f1.f55527a;
            Result.a aVar = Result.Companion;
            pVar.resumeWith(Result.m119constructorimpl(f1Var));
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @NotNull
    /* renamed from: e */
    public kotlin.coroutines.c<f1>[] b(@NotNull i0<?> i0Var) {
        this._state = null;
        return kotlinx.coroutines.flow.internal.b.f60129a;
    }

    public final void f() {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        kotlinx.coroutines.internal.j0 j0Var3;
        kotlinx.coroutines.internal.j0 j0Var4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            j0Var = j0.f60183b;
            if (obj == j0Var) {
                return;
            }
            j0Var2 = j0.f60182a;
            if (obj == j0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60185a;
                j0Var3 = j0.f60183b;
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater, this, obj, j0Var3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f60185a;
                j0Var4 = j0.f60182a;
                if (io.netty.channel.a.a(atomicReferenceFieldUpdater2, this, obj, j0Var4)) {
                    f1 f1Var = f1.f55527a;
                    Result.a aVar = Result.Companion;
                    ((kotlinx.coroutines.p) obj).resumeWith(Result.m119constructorimpl(f1Var));
                    return;
                }
            }
        }
    }

    public final boolean g() {
        kotlinx.coroutines.internal.j0 j0Var;
        kotlinx.coroutines.internal.j0 j0Var2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f60185a;
        j0Var = j0.f60182a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, j0Var);
        kotlin.jvm.internal.f0.m(andSet);
        j0Var2 = j0.f60183b;
        return andSet == j0Var2;
    }
}
