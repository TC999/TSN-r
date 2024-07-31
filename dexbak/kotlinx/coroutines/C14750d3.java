package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p649u1.C16231a;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B>\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, m12616d2 = {"Lkotlinx/coroutines/d3;", "R", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "job", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/selects/f;Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.d3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14750d3<R> extends AbstractC15119k2<C15125l2> {

    /* renamed from: e */
    private final InterfaceC15197f<R> f42196e;

    /* renamed from: f */
    private final InterfaceC15280l<InterfaceC14268c<? super R>, Object> f42197f;

    /* JADX WARN: Multi-variable type inference failed */
    public C14750d3(@NotNull C15125l2 c15125l2, @NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15280l<? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15280l) {
        super(c15125l2);
        this.f42196e = interfaceC15197f;
        this.f42197f = interfaceC15280l;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        if (this.f42196e.mo3703o()) {
            C16231a.m228c(this.f42197f, this.f42196e.mo3702s());
        }
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "SelectJoinOnCompletion[" + this.f42196e + ']';
    }
}
