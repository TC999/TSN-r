package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003BD\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/c3;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/k2;", "Lkotlinx/coroutines/l2;", "", "cause", "Lkotlin/f1;", "f0", "", "toString", "Lkotlinx/coroutines/selects/f;", "e", "Lkotlinx/coroutines/selects/f;", "select", "job", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "block", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/selects/f;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.c3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14633c3<T, R> extends AbstractC15119k2<C15125l2> {

    /* renamed from: e */
    private final InterfaceC15197f<R> f41728e;

    /* renamed from: f */
    private final InterfaceC15284p<T, InterfaceC14268c<? super R>, Object> f41729f;

    /* JADX WARN: Multi-variable type inference failed */
    public C14633c3(@NotNull C15125l2 c15125l2, @NotNull InterfaceC15197f<? super R> interfaceC15197f, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super R>, ? extends Object> interfaceC15284p) {
        super(c15125l2);
        this.f41728e = interfaceC15197f;
        this.f41729f = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        if (this.f41728e.mo3703o()) {
            ((C15125l2) this.f43146d).m4051Y0(this.f41728e, this.f41729f);
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
        return "SelectAwaitOnCompletion[" + this.f41728e + ']';
    }
}
