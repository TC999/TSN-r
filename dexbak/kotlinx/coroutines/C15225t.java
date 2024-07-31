package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/t;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/e2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/p;", "e", "Lkotlinx/coroutines/p;", "child", "parent", "<init>", "(Lkotlinx/coroutines/e2;Lkotlinx/coroutines/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15225t extends AbstractC14779f2<Job> {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: e */
    public final C15153p<?> f43396e;

    public C15225t(@NotNull Job job, @NotNull C15153p<?> c15153p) {
        super(job);
        this.f43396e = c15153p;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        C15153p<?> c15153p = this.f43396e;
        c15153p.m3919F(c15153p.mo3885w(this.f43146d));
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "ChildContinuation[" + this.f43396e + ']';
    }
}
