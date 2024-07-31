package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.internal.C15091q;
import kotlinx.coroutines.internal.C15094s;
import org.jetbrains.annotations.NotNull;

/* compiled from: JobSupport.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u0014\u0010\b\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/q2;", "Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/y1;", "", "state", "i0", "toString", "", "isActive", "()Z", "h", "()Lkotlinx/coroutines/q2;", "list", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.q2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15159q2 extends C15091q implements InterfaceC15259y1 {
    @Override // kotlinx.coroutines.InterfaceC15259y1
    @NotNull
    /* renamed from: h */
    public C15159q2 mo3496h() {
        return this;
    }

    @NotNull
    /* renamed from: i0 */
    public final String m3855i0(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object m4219P = m4219P();
        if (m4219P != null) {
            boolean z = true;
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, this); c15094s = c15094s.m4218Q()) {
                if (c15094s instanceof AbstractC15119k2) {
                    AbstractC15119k2 abstractC15119k2 = (AbstractC15119k2) c15094s;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(abstractC15119k2);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            C14342f0.m8185o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    @Override // kotlinx.coroutines.InterfaceC15259y1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @NotNull
    public String toString() {
        return super.toString();
    }
}
