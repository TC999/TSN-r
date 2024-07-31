package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.channels.AbstractC14687c;
import kotlinx.coroutines.internal.C15070b0;
import kotlinx.coroutines.internal.C15072c;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.C15198g;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010.\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010,j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`-¢\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0014R\u0018\u0010\u001a\u001a\u00060\u0016j\u0002`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010&\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0014\u0010'\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001fR\u0014\u0010+\u001a\u00020(8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00061"}, m12616d2 = {"Lkotlinx/coroutines/channels/v;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a;", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "m0", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", UMCommonContent.f37777aG, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "f0", "g0", "", "wasClosed", "Lkotlin/f1;", "c0", "Lkotlinx/coroutines/channels/c0;", "receive", ExifInterface.LONGITUDE_WEST, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "e", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "u", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "isEmpty", "", "j", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {

    /* renamed from: d */
    private final ReentrantLock f42156d;

    /* renamed from: e */
    private Object f42157e;

    public ConflatedChannel(@Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(interfaceC15280l);
        this.f42156d = new ReentrantLock();
        this.f42157e = C14685b.f42051d;
    }

    /* renamed from: m0 */
    private final OnUndeliveredElement m5179m0(Object obj) {
        InterfaceC15280l<E, Unit> interfaceC15280l;
        Object obj2 = this.f42157e;
        OnUndeliveredElement onUndeliveredElement = null;
        if (obj2 != C14685b.f42051d && (interfaceC15280l = this.f42059b) != null) {
            onUndeliveredElement = C15070b0.m4377d(interfaceC15280l, obj2, null, 2, null);
        }
        this.f42157e = obj;
        return onUndeliveredElement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: W */
    public boolean mo5184W(@NotNull AbstractC14694c0<? super E> abstractC14694c0) {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            return super.mo5184W(abstractC14694c0);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: Z */
    protected final boolean mo5174Z() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: a0 */
    protected final boolean mo5173a0() {
        return this.f42157e == C14685b.f42051d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: c0 */
    public void mo5183c0(boolean z) {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            OnUndeliveredElement m5179m0 = m5179m0(C14685b.f42051d);
            Unit unit = Unit.f41048a;
            reentrantLock.unlock();
            super.mo5183c0(z);
            if (m5179m0 != null) {
                throw m5179m0;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    /* renamed from: f0 */
    protected Object mo5182f0() {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            Object obj = this.f42157e;
            Symbol symbol = C14685b.f42051d;
            if (obj != symbol) {
                this.f42157e = symbol;
                Unit unit = Unit.f41048a;
                return obj;
            }
            Object m5487l = m5487l();
            if (m5487l == null) {
                m5487l = C14685b.f42054g;
            }
            return m5487l;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    /* renamed from: g0 */
    protected Object mo5181g0(@NotNull InterfaceC15197f<?> interfaceC15197f) {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            Object obj = this.f42157e;
            Symbol symbol = C14685b.f42051d;
            if (obj == symbol) {
                Object m5487l = m5487l();
                if (m5487l == null) {
                    m5487l = C14685b.f42054g;
                }
                return m5487l;
            } else if (!interfaceC15197f.mo3703o()) {
                return C15198g.m3696d();
            } else {
                Object obj2 = this.f42157e;
                this.f42157e = symbol;
                Unit unit = Unit.f41048a;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.InterfaceC14695d0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            return m5523b0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: j */
    protected String mo5180j() {
        return "(value=" + this.f42157e + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: u */
    protected final boolean mo5172u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: w */
    protected final boolean mo5171w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: y */
    public Object mo5170y(E e) {
        InterfaceC14698e0<E> mo5495J;
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            if (this.f42157e == C14685b.f42051d) {
                do {
                    mo5495J = mo5495J();
                    if (mo5495J != null) {
                        if (mo5495J instanceof C14731t) {
                            C14342f0.m8187m(mo5495J);
                            return mo5495J;
                        }
                        C14342f0.m8187m(mo5495J);
                    }
                } while (mo5495J.mo5201v(e, null) == null);
                Unit unit = Unit.f41048a;
                reentrantLock.unlock();
                C14342f0.m8187m(mo5495J);
                mo5495J.mo5206j(e);
                C14342f0.m8187m(mo5495J);
                return mo5495J.mo5211d();
            }
            OnUndeliveredElement m5179m0 = m5179m0(e);
            if (m5179m0 == null) {
                return C14685b.f42052e;
            }
            throw m5179m0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: z */
    public Object mo5169z(E e, @NotNull InterfaceC15197f<?> interfaceC15197f) {
        ReentrantLock reentrantLock = this.f42156d;
        reentrantLock.lock();
        try {
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            if (this.f42157e == C14685b.f42051d) {
                while (true) {
                    AbstractC14687c.C14691d<E> m5489g = m5489g(e);
                    Object mo3700u = interfaceC15197f.mo3700u(m5489g);
                    if (mo3700u == null) {
                        InterfaceC14698e0<? super E> m4190o = m5489g.m4190o();
                        Unit unit = Unit.f41048a;
                        reentrantLock.unlock();
                        C14342f0.m8187m(m4190o);
                        m4190o.mo5206j(e);
                        C14342f0.m8187m(m4190o);
                        return m4190o.mo5211d();
                    } else if (mo3700u == C14685b.f42053f) {
                        break;
                    } else if (mo3700u != C15072c.f43034b) {
                        if (mo3700u != C15198g.m3696d() && !(mo3700u instanceof C14731t)) {
                            throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + mo3700u).toString());
                        }
                        return mo3700u;
                    }
                }
            }
            if (!interfaceC15197f.mo3703o()) {
                return C15198g.m3696d();
            }
            OnUndeliveredElement m5179m0 = m5179m0(e);
            if (m5179m0 == null) {
                return C14685b.f42052e;
            }
            throw m5179m0;
        } finally {
            reentrantLock.unlock();
        }
    }
}
