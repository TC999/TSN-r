package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/x2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/p;", "e", "Lkotlinx/coroutines/p;", "continuation", "job", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.x2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15254x2<T> extends AbstractC15119k2<C15125l2> {

    /* renamed from: e */
    private final C15153p<T> f43449e;

    /* JADX WARN: Multi-variable type inference failed */
    public C15254x2(@NotNull C15125l2 c15125l2, @NotNull C15153p<? super T> c15153p) {
        super(c15125l2);
        this.f43449e = c15153p;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        Object m4014y0 = ((C15125l2) this.f43146d).m4014y0();
        if (m4014y0 instanceof CompletionState) {
            C15153p<T> c15153p = this.f43449e;
            Throwable th2 = ((CompletionState) m4014y0).f42189a;
            Result.C14124a c14124a = Result.Companion;
            c15153p.resumeWith(Result.m60148constructorimpl(C14294d0.m8609a(th2)));
            return;
        }
        C15153p<T> c15153p2 = this.f43449e;
        Object m3973o = C15134m2.m3973o(m4014y0);
        Result.C14124a c14124a2 = Result.Companion;
        c15153p2.resumeWith(Result.m60148constructorimpl(m3973o));
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.f43449e + ']';
    }
}
