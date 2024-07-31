package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Job.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/s2;", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/u;", "Lkotlin/f1;", "dispose", "", "cause", "", "g", "", "toString", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.s2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15171s2 implements InterfaceC15064i1, InterfaceC15235u {

    /* renamed from: a */
    public static final C15171s2 f43239a = new C15171s2();

    private C15171s2() {
    }

    @Override // kotlinx.coroutines.InterfaceC15064i1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.InterfaceC15235u
    /* renamed from: g */
    public boolean mo3544g(@NotNull Throwable th) {
        return false;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }
}
