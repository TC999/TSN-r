package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmPlatformAnnotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/v;", "Lkotlinx/coroutines/f2;", "Lkotlinx/coroutines/l2;", "Lkotlinx/coroutines/u;", "", "cause", "Lkotlin/f1;", "f0", "", "g", "", "toString", "Lkotlinx/coroutines/w;", "e", "Lkotlinx/coroutines/w;", "childJob", "parent", "<init>", "(Lkotlinx/coroutines/l2;Lkotlinx/coroutines/w;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15241v extends AbstractC14779f2<C15125l2> implements InterfaceC15235u {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: e */
    public final InterfaceC15244w f43428e;

    public C15241v(@NotNull C15125l2 c15125l2, @NotNull InterfaceC15244w interfaceC15244w) {
        super(c15125l2);
        this.f43428e = interfaceC15244w;
    }

    @Override // kotlinx.coroutines.CompletionHandler
    /* renamed from: f0 */
    public void mo3495f0(@Nullable Throwable th) {
        this.f43428e.mo3529n((InterfaceC15237u2) this.f43146d);
    }

    @Override // kotlinx.coroutines.InterfaceC15235u
    /* renamed from: g */
    public boolean mo3544g(@NotNull Throwable th) {
        return ((C15125l2) this.f43146d).mo4034h0(th);
    }

    @Override // p617l1.InterfaceC15280l
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo3495f0(th);
        return Unit.f41048a;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return "ChildHandle[" + this.f43428e + ']';
    }
}
