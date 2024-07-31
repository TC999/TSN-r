package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0007\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/l1;", "Lkotlinx/coroutines/y1;", "", "toString", "", "a", "Z", "isActive", "()Z", "Lkotlinx/coroutines/q2;", "h", "()Lkotlinx/coroutines/q2;", "list", "<init>", "(Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.l1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15124l1 implements InterfaceC15259y1 {

    /* renamed from: a */
    private final boolean f43151a;

    public C15124l1(boolean z) {
        this.f43151a = z;
    }

    @Override // kotlinx.coroutines.InterfaceC15259y1
    @Nullable
    /* renamed from: h */
    public C15159q2 mo3496h() {
        return null;
    }

    @Override // kotlinx.coroutines.InterfaceC15259y1
    public boolean isActive() {
        return this.f43151a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
