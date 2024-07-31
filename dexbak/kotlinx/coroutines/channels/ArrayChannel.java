package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections._ArraysJvm;
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

@Metadata(m12618bv = {}, m12617d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u000203\u0012 \u0010J\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010Hj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`I¢\u0006\u0004\bK\u0010LJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00028\u00002\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001fH\u0014¢\u0006\u0004\b#\u0010$R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u00020\u001f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u001f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010=\u001a\u00020\u001f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b<\u00108R\u0014\u0010?\u001a\u00020\u001f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b>\u00108R\u0014\u0010A\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u00108R\u0014\u0010B\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00108R\u0014\u0010C\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00108R\u0014\u0010G\u001a\u00020D8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006M"}, m12616d2 = {"Lkotlinx/coroutines/channels/i;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a;", "", "currentSize", "Lkotlinx/coroutines/internal/j0;", "o0", "(I)Lkotlinx/coroutines/internal/j0;", "element", "Lkotlin/f1;", "m0", "(ILjava/lang/Object;)V", "n0", "(I)V", "", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", UMCommonContent.f37777aG, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/g0;", "send", "i", "(Lkotlinx/coroutines/channels/g0;)Ljava/lang/Object;", "f0", "()Ljava/lang/Object;", "g0", "(Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/c0;", "receive", "", ExifInterface.LONGITUDE_WEST, "(Lkotlinx/coroutines/channels/c0;)Z", "wasClosed", "c0", "(Z)V", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "e", "[Ljava/lang/Object;", "buffer", "f", "I", "head", "g", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "h", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Z", "()Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "u", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", CampaignEx.JSON_KEY_AD_Q, "isFull", "isEmpty", "isClosedForReceive", "", "j", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Ll1/l;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {

    /* renamed from: d */
    private final ReentrantLock f42076d;

    /* renamed from: e */
    private Object[] f42077e;

    /* renamed from: f */
    private int f42078f;

    /* renamed from: g */
    private final int f42079g;

    /* renamed from: h */
    private final BufferOverflow f42080h;
    private volatile int size;

    public ArrayChannel(int i, @NotNull BufferOverflow bufferOverflow, @Nullable InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        super(interfaceC15280l);
        this.f42079g = i;
        this.f42080h = bufferOverflow;
        if (i >= 1) {
            this.f42076d = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i, 8)];
            _ArraysJvm.m11519w2(objArr, C14685b.f42051d, 0, 0, 6, null);
            Unit unit = Unit.f41048a;
            this.f42077e = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* renamed from: m0 */
    private final void m5438m0(int i, E e) {
        if (i < this.f42079g) {
            m5437n0(i);
            Object[] objArr = this.f42077e;
            objArr[(this.f42078f + i) % objArr.length] = e;
            return;
        }
        Object[] objArr2 = this.f42077e;
        int i2 = this.f42078f;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.f42078f = (i2 + 1) % objArr2.length;
    }

    /* renamed from: n0 */
    private final void m5437n0(int i) {
        Object[] objArr = this.f42077e;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f42079g);
            Object[] objArr2 = new Object[min];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.f42077e;
                objArr2[i2] = objArr3[(this.f42078f + i2) % objArr3.length];
            }
            _ArraysJvm.m11568n2(objArr2, C14685b.f42051d, i, min);
            this.f42077e = objArr2;
            this.f42078f = 0;
        }
    }

    /* renamed from: o0 */
    private final Symbol m5436o0(int i) {
        if (i < this.f42079g) {
            this.size = i + 1;
            return null;
        }
        int i2 = C14703h.f42075a[this.f42080h.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return C14685b.f42052e;
        }
        return C14685b.f42053f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: W */
    public boolean mo5184W(@NotNull AbstractC14694c0<? super E> abstractC14694c0) {
        ReentrantLock reentrantLock = this.f42076d;
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
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: c0 */
    public void mo5183c0(boolean z) {
        InterfaceC15280l<E, Unit> interfaceC15280l = this.f42059b;
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            int i = this.size;
            OnUndeliveredElement onUndeliveredElement = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.f42077e[this.f42078f];
                if (interfaceC15280l != null && obj != C14685b.f42051d) {
                    onUndeliveredElement = C15070b0.m4378c(interfaceC15280l, obj, onUndeliveredElement);
                }
                Object[] objArr = this.f42077e;
                int i3 = this.f42078f;
                objArr[i3] = C14685b.f42051d;
                this.f42078f = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.f41048a;
            reentrantLock.unlock();
            super.mo5183c0(z);
            if (onUndeliveredElement != null) {
                throw onUndeliveredElement;
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
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object m5487l = m5487l();
                if (m5487l == null) {
                    m5487l = C14685b.f42054g;
                }
                return m5487l;
            }
            Object[] objArr = this.f42077e;
            int i2 = this.f42078f;
            Object obj = objArr[i2];
            AbstractC14702g0 abstractC14702g0 = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object obj2 = C14685b.f42054g;
            boolean z = false;
            if (i == this.f42079g) {
                AbstractC14702g0 abstractC14702g02 = null;
                while (true) {
                    AbstractC14702g0 m5494N = m5494N();
                    if (m5494N == null) {
                        abstractC14702g0 = abstractC14702g02;
                        break;
                    }
                    C14342f0.m8187m(m5494N);
                    if (m5494N.mo5207i0(null) != null) {
                        C14342f0.m8187m(m5494N);
                        obj2 = m5494N.mo5209g0();
                        abstractC14702g0 = m5494N;
                        z = true;
                        break;
                    }
                    C14342f0.m8187m(m5494N);
                    m5494N.mo5433j0();
                    abstractC14702g02 = m5494N;
                }
            }
            if (obj2 != C14685b.f42054g && !(obj2 instanceof C14731t)) {
                this.size = i;
                Object[] objArr2 = this.f42077e;
                objArr2[(this.f42078f + i) % objArr2.length] = obj2;
            }
            this.f42078f = (this.f42078f + 1) % this.f42077e.length;
            Unit unit = Unit.f41048a;
            if (z) {
                C14342f0.m8187m(abstractC14702g0);
                abstractC14702g0.mo5210f0();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009f A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0010, B:11:0x0016, B:13:0x002a, B:15:0x0034, B:34:0x0085, B:36:0x0089, B:38:0x008d, B:44:0x00af, B:39:0x0099, B:41:0x009f, B:17:0x0044, B:20:0x0049, B:23:0x004e, B:25:0x0054, B:28:0x0060, B:30:0x0064, B:31:0x0069, B:32:0x0083), top: B:53:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object mo5181g0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.InterfaceC15197f<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f42076d
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc6
            if (r1 != 0) goto L16
            kotlinx.coroutines.channels.t r9 = r8.m5487l()     // Catch: java.lang.Throwable -> Lc6
            if (r9 == 0) goto L10
            goto L12
        L10:
            kotlinx.coroutines.internal.j0 r9 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> Lc6
        L12:
            r0.unlock()
            return r9
        L16:
            java.lang.Object[] r2 = r8.f42077e     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.f42078f     // Catch: java.lang.Throwable -> Lc6
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc6
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc6
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc6
            kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.f42079g     // Catch: java.lang.Throwable -> Lc6
            r6 = 1
            if (r1 != r3) goto L84
        L2a:
            kotlinx.coroutines.channels.a$g r3 = r8.m5527U()     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r7 = r9.mo3700u(r3)     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L44
            java.lang.Object r2 = r3.m4190o()     // Catch: java.lang.Throwable -> Lc6
            r5 = r2
            kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.AbstractC14702g0) r5     // Catch: java.lang.Throwable -> Lc6
            kotlin.jvm.internal.C14342f0.m8187m(r5)     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r2 = r5.mo5209g0()     // Catch: java.lang.Throwable -> Lc6
        L42:
            r3 = 1
            goto L85
        L44:
            kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L49
            goto L84
        L49:
            java.lang.Object r3 = kotlinx.coroutines.internal.C15072c.f43034b     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L4e
            goto L2a
        L4e:
            java.lang.Object r2 = kotlinx.coroutines.selects.C15198g.m3696d()     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r2) goto L60
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f42077e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f42078f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r7
        L60:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.C14731t     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L69
            r5 = r7
            kotlinx.coroutines.channels.g0 r5 = (kotlinx.coroutines.channels.AbstractC14702g0) r5     // Catch: java.lang.Throwable -> Lc6
            r2 = r7
            goto L42
        L69:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r9.<init>()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc6
            r9.append(r7)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lc6
            throw r1     // Catch: java.lang.Throwable -> Lc6
        L84:
            r3 = 0
        L85:
            kotlinx.coroutines.internal.j0 r7 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> Lc6
            if (r2 == r7) goto L99
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.C14731t     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L99
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f42077e     // Catch: java.lang.Throwable -> Lc6
            int r7 = r8.f42078f     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc6
            goto Laf
        L99:
            boolean r9 = r9.mo3703o()     // Catch: java.lang.Throwable -> Lc6
            if (r9 != 0) goto Laf
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.f42077e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f42078f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r9 = kotlinx.coroutines.selects.C15198g.m3696d()     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r9
        Laf:
            int r9 = r8.f42078f     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f42077e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 % r1
            r8.f42078f = r9     // Catch: java.lang.Throwable -> Lc6
            kotlin.f1 r9 = kotlin.Unit.f41048a     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            if (r3 == 0) goto Lc5
            kotlin.jvm.internal.C14342f0.m8187m(r5)
            r5.mo5210f0()
        Lc5:
            return r4
        Lc6:
            r9 = move-exception
            r0.unlock()
            goto Lcc
        Lcb:
            throw r9
        Lcc:
            goto Lcb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.mo5181g0(kotlinx.coroutines.selects.f):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.InterfaceC14695d0
    /* renamed from: h */
    public boolean mo5394h() {
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            return super.mo5394h();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @Nullable
    /* renamed from: i */
    public Object mo5439i(@NotNull AbstractC14702g0 abstractC14702g0) {
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            return super.mo5439i(abstractC14702g0);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.InterfaceC14695d0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f42076d;
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
        return "(buffer:capacity=" + this.f42079g + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c, kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: q */
    public boolean mo5187q() {
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            return m5480x();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: u */
    protected final boolean mo5172u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: w */
    protected final boolean mo5171w() {
        return this.size == this.f42079g && this.f42080h == BufferOverflow.SUSPEND;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: y */
    public Object mo5170y(E e) {
        InterfaceC14698e0<E> mo5495J;
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            int i = this.size;
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            Symbol m5436o0 = m5436o0(i);
            if (m5436o0 != null) {
                return m5436o0;
            }
            if (i == 0) {
                do {
                    mo5495J = mo5495J();
                    if (mo5495J != null) {
                        if (mo5495J instanceof C14731t) {
                            this.size = i;
                            C14342f0.m8187m(mo5495J);
                            return mo5495J;
                        }
                        C14342f0.m8187m(mo5495J);
                    }
                } while (mo5495J.mo5201v(e, null) == null);
                this.size = i;
                Unit unit = Unit.f41048a;
                reentrantLock.unlock();
                C14342f0.m8187m(mo5495J);
                mo5495J.mo5206j(e);
                C14342f0.m8187m(mo5495J);
                return mo5495J.mo5211d();
            }
            m5438m0(i, e);
            return C14685b.f42052e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: z */
    public Object mo5169z(E e, @NotNull InterfaceC15197f<?> interfaceC15197f) {
        ReentrantLock reentrantLock = this.f42076d;
        reentrantLock.lock();
        try {
            int i = this.size;
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            Symbol m5436o0 = m5436o0(i);
            if (m5436o0 != null) {
                return m5436o0;
            }
            if (i == 0) {
                while (true) {
                    AbstractC14687c.C14691d<E> m5489g = m5489g(e);
                    Object mo3700u = interfaceC15197f.mo3700u(m5489g);
                    if (mo3700u == null) {
                        this.size = i;
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
                        this.size = i;
                        return mo3700u;
                    }
                }
            }
            if (!interfaceC15197f.mo3703o()) {
                this.size = i;
                return C15198g.m3696d();
            }
            m5438m0(i, e);
            return C14685b.f42052e;
        } finally {
            reentrantLock.unlock();
        }
    }
}
