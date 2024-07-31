package kotlinx.coroutines.flow;

import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.flow.internal.AbstractC14979c;
import kotlinx.coroutines.flow.internal.C14978b;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/flow/k0;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/i0;", "flow", "", "c", "(Lkotlinx/coroutines/flow/i0;)Z", "", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i0;)[Lkotlin/coroutines/c;", "f", "()V", "g", "()Z", "d", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.k0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15007k0 extends AbstractC14979c<C14959i0<?>> {

    /* renamed from: a */
    static final AtomicReferenceFieldUpdater f42868a = AtomicReferenceFieldUpdater.newUpdater(C15007k0.class, Object.class, "_state");
    volatile Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.AbstractC14979c
    /* renamed from: c */
    public boolean mo4574a(@NotNull C14959i0<?> c14959i0) {
        Symbol symbol;
        if (this._state != null) {
            return false;
        }
        symbol = C15005j0.f42865a;
        this._state = symbol;
        return true;
    }

    @Nullable
    /* renamed from: d */
    public final Object m4571d(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Symbol symbol;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f42868a;
        symbol = C15005j0.f42865a;
        if (!C13675a.m12692a(atomicReferenceFieldUpdater, this, symbol, c15153p)) {
            Unit unit = Unit.f41048a;
            Result.C14124a c14124a = Result.Companion;
            c15153p.resumeWith(Result.m60148constructorimpl(unit));
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC14979c
    @NotNull
    /* renamed from: e */
    public InterfaceC14268c<Unit>[] mo4573b(@NotNull C14959i0<?> c14959i0) {
        this._state = null;
        return C14978b.f42812a;
    }

    /* renamed from: f */
    public final void m4569f() {
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        Symbol symbol4;
        while (true) {
            Object obj = this._state;
            if (obj == null) {
                return;
            }
            symbol = C15005j0.f42866b;
            if (obj == symbol) {
                return;
            }
            symbol2 = C15005j0.f42865a;
            if (obj == symbol2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f42868a;
                symbol3 = C15005j0.f42866b;
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, obj, symbol3)) {
                    return;
                }
            } else {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f42868a;
                symbol4 = C15005j0.f42865a;
                if (C13675a.m12692a(atomicReferenceFieldUpdater2, this, obj, symbol4)) {
                    Unit unit = Unit.f41048a;
                    Result.C14124a c14124a = Result.Companion;
                    ((C15153p) obj).resumeWith(Result.m60148constructorimpl(unit));
                    return;
                }
            }
        }
    }

    /* renamed from: g */
    public final boolean m4568g() {
        Symbol symbol;
        Symbol symbol2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f42868a;
        symbol = C15005j0.f42865a;
        Object andSet = atomicReferenceFieldUpdater.getAndSet(this, symbol);
        C14342f0.m8187m(andSet);
        symbol2 = C15005j0.f42866b;
        return andSet == symbol2;
    }
}
