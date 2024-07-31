package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.internal.C15070b0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* compiled from: AbstractChannel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00028\u0000`\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/channels/j0;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/i0;", "", "Y", "Lkotlin/f1;", "j0", "pollResult", "Lkotlinx/coroutines/o;", "cont", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/o;Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.j0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14708j0<E> extends C14706i0<E> {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: f */
    public final InterfaceC15280l<E, Unit> f42083f;

    /* JADX WARN: Multi-variable type inference failed */
    public C14708j0(E e, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o, @NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(e, interfaceC15146o);
        this.f42083f = interfaceC15280l;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    /* renamed from: Y */
    public boolean mo4211Y() {
        if (super.mo4211Y()) {
            mo5433j0();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14702g0
    /* renamed from: j0 */
    public void mo5433j0() {
        C15070b0.m4379b(this.f42083f, mo5209g0(), this.f42082e.getContext());
    }
}
