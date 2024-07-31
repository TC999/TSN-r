package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\fJ-\u0010\u0007\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0003\u0018\u0001*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bJ\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0014J\u000f\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, m12616d2 = {"Lkotlinx/coroutines/internal/q;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/f1;", "block", "f0", "", "Y", "X", "h0", "()V", "g0", "()Z", "isEmpty", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "isRemoved", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C15091q extends C15094s {
    @Override // kotlinx.coroutines.internal.C15094s
    /* renamed from: V */
    public boolean mo4214V() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    @Nullable
    /* renamed from: X */
    protected C15094s mo4212X() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.C15094s
    /* renamed from: Y */
    public final boolean mo4211Y() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    /* renamed from: f0 */
    public final /* synthetic */ <T extends C15094s> void m4246f0(@NotNull InterfaceC15280l<? super T, Unit> interfaceC15280l) {
        Object m4219P = m4219P();
        if (m4219P != null) {
            for (C15094s c15094s = (C15094s) m4219P; !C14342f0.m8193g(c15094s, this); c15094s = c15094s.m4218Q()) {
                C14342f0.m8175y(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (c15094s instanceof C15094s) {
                    interfaceC15280l.invoke(c15094s);
                }
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: g0 */
    public final boolean m4245g0() {
        return m4219P() == this;
    }

    /* renamed from: h0 */
    public final void m4244h0() {
        Object m4219P = m4219P();
        if (m4219P != null) {
            C15094s c15094s = (C15094s) m4219P;
            C15094s c15094s2 = this;
            while (!C14342f0.m8193g(c15094s, this)) {
                C15094s m4218Q = c15094s.m4218Q();
                c15094s.m4205e0(c15094s2, m4218Q);
                c15094s2 = c15094s;
                c15094s = m4218Q;
            }
            Object m4219P2 = m4219P();
            if (m4219P2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            m4205e0(c15094s2, (C15094s) m4219P2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
