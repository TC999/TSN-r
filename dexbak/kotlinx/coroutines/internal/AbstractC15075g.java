package kotlinx.coroutines.internal;

import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.internal.AbstractC15075g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* compiled from: ConcurrentLinkedList.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\"\u0010#J \u0010\u0006\u001a\u0004\u0018\u00018\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u001b\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001d\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u001f\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010!\u001a\u00020\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0010¨\u0006$"}, m12616d2 = {"Lkotlinx/coroutines/internal/g;", "N", "", "Lkotlin/Function0;", "", "onClosedAction", "k", "(Ll1/a;)Lkotlinx/coroutines/internal/g;", DomainCampaignEx.LOOPBACK_VALUE, "", "m", "(Lkotlinx/coroutines/internal/g;)Z", "Lkotlin/f1;", "b", "()V", "j", "()Z", C7304t.f25048d, "e", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/g;", "leftmostAliveNode", "h", "rightmostAliveNode", "d", "next", "i", "isTail", "f", "prev", "g", "removed", "<init>", "(Lkotlinx/coroutines/internal/g;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15075g<N extends AbstractC15075g<N>> {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f43041a = AtomicReferenceFieldUpdater.newUpdater(AbstractC15075g.class, Object.class, "_next");

    /* renamed from: b */
    private static final AtomicReferenceFieldUpdater f43042b = AtomicReferenceFieldUpdater.newUpdater(AbstractC15075g.class, Object.class, "_prev");
    private volatile Object _next = null;
    private volatile Object _prev;

    public AbstractC15075g(@Nullable N n) {
        this._prev = n;
    }

    /* renamed from: c */
    private final N m4356c() {
        N m4353f = m4353f();
        while (m4353f != null && m4353f.mo4346g()) {
            m4353f = (N) m4353f._prev;
        }
        return m4353f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public final Object m4354e() {
        return this._next;
    }

    /* renamed from: h */
    private final N m4352h() {
        N m4355d = m4355d();
        C14342f0.m8187m(m4355d);
        while (m4355d.mo4346g()) {
            m4355d = (N) m4355d.m4355d();
            C14342f0.m8187m(m4355d);
        }
        return m4355d;
    }

    /* renamed from: b */
    public final void m4357b() {
        f43042b.lazySet(this, null);
    }

    @Nullable
    /* renamed from: d */
    public final N m4355d() {
        Object m4354e = m4354e();
        if (m4354e == ConcurrentLinkedList.m4363b()) {
            return null;
        }
        return (N) m4354e;
    }

    @Nullable
    /* renamed from: f */
    public final N m4353f() {
        return (N) this._prev;
    }

    /* renamed from: g */
    public abstract boolean mo4346g();

    /* renamed from: i */
    public final boolean m4351i() {
        return m4355d() == null;
    }

    /* renamed from: j */
    public final boolean m4350j() {
        return C13675a.m12692a(f43041a, this, null, ConcurrentLinkedList.m4363b());
    }

    @Nullable
    /* renamed from: k */
    public final N m4349k(@NotNull InterfaceC15269a interfaceC15269a) {
        Object m4354e = m4354e();
        if (m4354e != ConcurrentLinkedList.m4363b()) {
            return (N) m4354e;
        }
        interfaceC15269a.invoke();
        throw new ExceptionsH();
    }

    /* renamed from: l */
    public final void m4348l() {
        while (true) {
            N m4356c = m4356c();
            N m4352h = m4352h();
            m4352h._prev = m4356c;
            if (m4356c != null) {
                m4356c._next = m4352h;
            }
            if (!m4352h.mo4346g() && (m4356c == null || !m4356c.mo4346g())) {
                return;
            }
        }
    }

    /* renamed from: m */
    public final boolean m4347m(@NotNull N n) {
        return C13675a.m12692a(f43041a, this, null, n);
    }
}
