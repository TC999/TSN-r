package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7202bq;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges._Ranges;
import kotlinx.coroutines.internal.Concurrent;
import kotlinx.coroutines.selects.C15198g;
import kotlinx.coroutines.selects.InterfaceC15197f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001bB\u000f\u0012\u0006\u0010;\u001a\u000206¢\u0006\u0004\bQ\u0010FJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u001b\u0010\bJ\u001f\u0010\u001e\u001a\u00020\t2\u000e\u0010\u0005\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J#\u0010&\u001a\u00020!2\u0006\u0010 \u001a\u00028\u00002\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0014¢\u0006\u0004\b&\u0010'R\u0018\u0010,\u001a\u00060(j\u0002`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R0\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f01j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`28\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0017\u0010;\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010@\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b=\u0010\u0013\"\u0004\b>\u0010?R$\u0010C\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010?R$\u0010G\u001a\u0002062\u0006\u0010<\u001a\u0002068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bD\u0010:\"\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010L\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bK\u0010IR\u0014\u0010P\u001a\u00020M8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006R"}, m12616d2 = {"Lkotlinx/coroutines/channels/g;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/c;", "Lkotlinx/coroutines/channels/j;", "", "cause", "", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Throwable;)Z", "Lkotlin/f1;", "U", "()V", "Lkotlinx/coroutines/channels/g$a;", "addSub", "removeSub", "e0", "(Lkotlinx/coroutines/channels/g$a;Lkotlinx/coroutines/channels/g$a;)V", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()J", "index", ExifInterface.LONGITUDE_WEST, "(J)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/d0;", "v", "()Lkotlinx/coroutines/channels/d0;", "L", "a", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "b", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "y", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/f;", "select", UMCommonContent.f37777aG, "(Ljava/lang/Object;Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "", "e", "[Ljava/lang/Object;", "buffer", "", "Lkotlinx/coroutines/internal/SubscribersList;", "f", "Ljava/util/List;", "subscribers", "", "g", "I", "X", "()I", "capacity", DomainCampaignEx.LOOPBACK_VALUE, "Y", "b0", "(J)V", "head", "a0", "d0", "tail", "Z", "c0", "(I)V", "size", "u", "()Z", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "", "j", "()Ljava/lang/String;", "bufferDebugString", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ArrayBroadcastChannel<E> extends AbstractC14687c<E> implements BroadcastChannel<E> {
    private volatile long _head;
    private volatile int _size;
    private volatile long _tail;

    /* renamed from: d */
    private final ReentrantLock f42069d;

    /* renamed from: e */
    private final Object[] f42070e;

    /* renamed from: f */
    private final List<C14701a<E>> f42071f;

    /* renamed from: g */
    private final int f42072g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArrayBroadcastChannel.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\tJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u00060\u0014j\u0002`\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0006R\u0014\u0010'\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u0014\u0010)\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0006R\u0014\u0010+\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0006¨\u0006."}, m12616d2 = {"Lkotlinx/coroutines/channels/g$a;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/a;", "Lkotlinx/coroutines/channels/d0;", "", "o0", "()Z", "", C7202bq.f24604g, "()Ljava/lang/Object;", "", "cause", "L", "(Ljava/lang/Throwable;)Z", "m0", "f0", "Lkotlinx/coroutines/selects/f;", "select", "g0", "(Lkotlinx/coroutines/selects/f;)Ljava/lang/Object;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "subLock", "Lkotlinx/coroutines/channels/g;", "e", "Lkotlinx/coroutines/channels/g;", "broadcastChannel", "", DomainCampaignEx.LOOPBACK_VALUE, "n0", "()J", "q0", "(J)V", "subHead", "Z", "isBufferAlwaysEmpty", "a0", "isBufferEmpty", "u", "isBufferAlwaysFull", IAdInterListener.AdReqParam.WIDTH, "isBufferFull", "<init>", "(Lkotlinx/coroutines/channels/g;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.g$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14701a<E> extends AbstractChannel<E> implements InterfaceC14695d0<E> {
        private volatile long _subHead;

        /* renamed from: d */
        private final ReentrantLock f42073d;

        /* renamed from: e */
        private final ArrayBroadcastChannel<E> f42074e;

        public C14701a(@NotNull ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super(null);
            this.f42074e = arrayBroadcastChannel;
            this.f42073d = new ReentrantLock();
            this._subHead = 0L;
        }

        /* renamed from: o0 */
        private final boolean m5445o0() {
            if (m5488k() != null) {
                return false;
            }
            return (mo5173a0() && this.f42074e.m5488k() == null) ? false : true;
        }

        /* renamed from: p0 */
        private final Object m5444p0() {
            long m5446n0 = m5446n0();
            C14731t<?> m5488k = this.f42074e.m5488k();
            if (m5446n0 >= this.f42074e.m5453a0()) {
                if (m5488k == null) {
                    m5488k = m5488k();
                }
                return m5488k != null ? m5488k : C14685b.f42054g;
            }
            Object m5457W = this.f42074e.m5457W(m5446n0);
            C14731t<?> m5488k2 = m5488k();
            return m5488k2 != null ? m5488k2 : m5457W;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14687c, kotlinx.coroutines.channels.InterfaceC14704h0
        /* renamed from: L */
        public boolean mo5178L(@Nullable Throwable th) {
            boolean mo5178L = super.mo5178L(th);
            if (mo5178L) {
                ArrayBroadcastChannel.m5448f0(this.f42074e, null, this, 1, null);
                ReentrantLock reentrantLock = this.f42073d;
                reentrantLock.lock();
                try {
                    m5443q0(this.f42074e.m5453a0());
                    Unit unit = Unit.f41048a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return mo5178L;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        /* renamed from: Z */
        protected boolean mo5174Z() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        /* renamed from: a0 */
        protected boolean mo5173a0() {
            return m5446n0() >= this.f42074e.m5453a0();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        @org.jetbrains.annotations.Nullable
        /* renamed from: f0 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.lang.Object mo5182f0() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.f42073d
                r0.lock()
                java.lang.Object r1 = r8.m5444p0()     // Catch: java.lang.Throwable -> L45
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.C14731t     // Catch: java.lang.Throwable -> L45
                r3 = 1
                if (r2 == 0) goto Lf
                goto L13
            Lf:
                kotlinx.coroutines.internal.j0 r2 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> L45
                if (r1 != r2) goto L15
            L13:
                r2 = 0
                goto L20
            L15:
                long r4 = r8.m5446n0()     // Catch: java.lang.Throwable -> L45
                r6 = 1
                long r4 = r4 + r6
                r8.m5443q0(r4)     // Catch: java.lang.Throwable -> L45
                r2 = 1
            L20:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.C14731t
                r4 = 0
                if (r0 != 0) goto L2a
                r0 = r4
                goto L2b
            L2a:
                r0 = r1
            L2b:
                kotlinx.coroutines.channels.t r0 = (kotlinx.coroutines.channels.C14731t) r0
                if (r0 == 0) goto L34
                java.lang.Throwable r0 = r0.f42143d
                r8.mo5178L(r0)
            L34:
                boolean r0 = r8.m5447m0()
                if (r0 == 0) goto L3b
                goto L3c
            L3b:
                r3 = r2
            L3c:
                if (r3 == 0) goto L44
                kotlinx.coroutines.channels.g<E> r0 = r8.f42074e
                r2 = 3
                kotlinx.coroutines.channels.ArrayBroadcastChannel.m5448f0(r0, r4, r4, r2, r4)
            L44:
                return r1
            L45:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.C14701a.mo5182f0():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        @Nullable
        /* renamed from: g0 */
        protected Object mo5181g0(@NotNull InterfaceC15197f<?> interfaceC15197f) {
            ReentrantLock reentrantLock = this.f42073d;
            reentrantLock.lock();
            try {
                Object m5444p0 = m5444p0();
                boolean z = false;
                if (!(m5444p0 instanceof C14731t) && m5444p0 != C14685b.f42054g) {
                    if (!interfaceC15197f.mo3703o()) {
                        m5444p0 = C15198g.m3696d();
                    } else {
                        m5443q0(m5446n0() + 1);
                        z = true;
                    }
                }
                reentrantLock.unlock();
                C14731t c14731t = (C14731t) (!(m5444p0 instanceof C14731t) ? null : m5444p0);
                if (c14731t != null) {
                    mo5178L(c14731t.f42143d);
                }
                if (m5447m0() ? true : z) {
                    ArrayBroadcastChannel.m5448f0(this.f42074e, null, null, 3, null);
                }
                return m5444p0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
            r2 = (kotlinx.coroutines.channels.C14731t) r1;
         */
        /* renamed from: m0 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m5447m0() {
            /*
                r8 = this;
                r0 = 0
            L1:
                boolean r1 = r8.m5445o0()
                r2 = 0
                if (r1 == 0) goto L5b
                java.util.concurrent.locks.ReentrantLock r1 = r8.f42073d
                boolean r1 = r1.tryLock()
                if (r1 != 0) goto L11
                goto L5b
            L11:
                java.lang.Object r1 = r8.m5444p0()     // Catch: java.lang.Throwable -> L54
                kotlinx.coroutines.internal.j0 r3 = kotlinx.coroutines.channels.C14685b.f42054g     // Catch: java.lang.Throwable -> L54
                if (r1 != r3) goto L1f
            L19:
                java.util.concurrent.locks.ReentrantLock r1 = r8.f42073d
                r1.unlock()
                goto L1
            L1f:
                boolean r3 = r1 instanceof kotlinx.coroutines.channels.C14731t     // Catch: java.lang.Throwable -> L54
                if (r3 == 0) goto L2c
                r2 = r1
                kotlinx.coroutines.channels.t r2 = (kotlinx.coroutines.channels.C14731t) r2     // Catch: java.lang.Throwable -> L54
            L26:
                java.util.concurrent.locks.ReentrantLock r1 = r8.f42073d
                r1.unlock()
                goto L5b
            L2c:
                kotlinx.coroutines.channels.e0 r3 = r8.mo5495J()     // Catch: java.lang.Throwable -> L54
                if (r3 == 0) goto L26
                boolean r4 = r3 instanceof kotlinx.coroutines.channels.C14731t     // Catch: java.lang.Throwable -> L54
                if (r4 == 0) goto L37
                goto L26
            L37:
                kotlinx.coroutines.internal.j0 r2 = r3.mo5201v(r1, r2)     // Catch: java.lang.Throwable -> L54
                if (r2 == 0) goto L19
                long r4 = r8.m5446n0()     // Catch: java.lang.Throwable -> L54
                r6 = 1
                long r4 = r4 + r6
                r8.m5443q0(r4)     // Catch: java.lang.Throwable -> L54
                r0 = 1
                java.util.concurrent.locks.ReentrantLock r2 = r8.f42073d
                r2.unlock()
                kotlin.jvm.internal.C14342f0.m8187m(r3)
                r3.mo5206j(r1)
                goto L1
            L54:
                r0 = move-exception
                java.util.concurrent.locks.ReentrantLock r1 = r8.f42073d
                r1.unlock()
                throw r0
            L5b:
                if (r2 == 0) goto L62
                java.lang.Throwable r1 = r2.f42143d
                r8.mo5178L(r1)
            L62:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.C14701a.m5447m0():boolean");
        }

        /* renamed from: n0 */
        public final long m5446n0() {
            return this._subHead;
        }

        /* renamed from: q0 */
        public final void m5443q0(long j) {
            this._subHead = j;
        }

        @Override // kotlinx.coroutines.channels.AbstractC14687c
        /* renamed from: u */
        protected boolean mo5172u() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractC14687c
        /* renamed from: w */
        protected boolean mo5171w() {
            throw new IllegalStateException("Should not be used".toString());
        }
    }

    public ArrayBroadcastChannel(int i) {
        super(null);
        this.f42072g = i;
        if (i >= 1) {
            this.f42069d = new ReentrantLock();
            this.f42070e = new Object[i];
            this._head = 0L;
            this._tail = 0L;
            this._size = 0;
            this.f42071f = Concurrent.m4366d();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: T */
    public final boolean mo3828a(Throwable th) {
        boolean mo5178L = mo5178L(th);
        for (C14701a<E> c14701a : this.f42071f) {
            c14701a.mo5475a(th);
        }
        return mo5178L;
    }

    /* renamed from: U */
    private final void m5459U() {
        boolean z = false;
        boolean z2 = false;
        for (C14701a<E> c14701a : this.f42071f) {
            if (c14701a.m5447m0()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            m5448f0(this, null, null, 3, null);
        }
    }

    /* renamed from: V */
    private final long m5458V() {
        long j = Long.MAX_VALUE;
        for (C14701a<E> c14701a : this.f42071f) {
            j = _Ranges.m7457v(j, c14701a.m5446n0());
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W */
    public final E m5457W(long j) {
        return (E) this.f42070e[(int) (j % this.f42072g)];
    }

    /* renamed from: Y */
    private final long m5455Y() {
        return this._head;
    }

    /* renamed from: Z */
    private final int m5454Z() {
        return this._size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public final long m5453a0() {
        return this._tail;
    }

    /* renamed from: b0 */
    private final void m5452b0(long j) {
        this._head = j;
    }

    /* renamed from: c0 */
    private final void m5451c0(int i) {
        this._size = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public final void m5450d0(long j) {
        this._tail = j;
    }

    /* renamed from: e0 */
    private final void m5449e0(C14701a<E> c14701a, C14701a<E> c14701a2) {
        long m7457v;
        AbstractC14702g0 m5494N;
        while (true) {
            ReentrantLock reentrantLock = this.f42069d;
            reentrantLock.lock();
            if (c14701a != null) {
                try {
                    c14701a.m5443q0(m5453a0());
                    boolean isEmpty = this.f42071f.isEmpty();
                    this.f42071f.add(c14701a);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (c14701a2 != null) {
                this.f42071f.remove(c14701a2);
                if (m5455Y() != c14701a2.m5446n0()) {
                    return;
                }
            }
            long m5458V = m5458V();
            long m5453a0 = m5453a0();
            long m5455Y = m5455Y();
            m7457v = _Ranges.m7457v(m5458V, m5453a0);
            if (m7457v <= m5455Y) {
                return;
            }
            int m5454Z = m5454Z();
            while (m5455Y < m7457v) {
                Object[] objArr = this.f42070e;
                int i = this.f42072g;
                objArr[(int) (m5455Y % i)] = null;
                boolean z = m5454Z >= i;
                m5455Y++;
                m5452b0(m5455Y);
                m5454Z--;
                m5451c0(m5454Z);
                if (z) {
                    do {
                        m5494N = m5494N();
                        if (m5494N != null && !(m5494N instanceof C14731t)) {
                            C14342f0.m8187m(m5494N);
                        }
                    } while (m5494N.mo5207i0(null) == null);
                    this.f42070e[(int) (m5453a0 % this.f42072g)] = m5494N.mo5209g0();
                    m5451c0(m5454Z + 1);
                    m5450d0(m5453a0 + 1);
                    Unit unit = Unit.f41048a;
                    reentrantLock.unlock();
                    C14342f0.m8187m(m5494N);
                    m5494N.mo5210f0();
                    m5459U();
                    c14701a = null;
                    c14701a2 = null;
                }
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f0 */
    static /* synthetic */ void m5448f0(ArrayBroadcastChannel arrayBroadcastChannel, C14701a c14701a, C14701a c14701a2, int i, Object obj) {
        if ((i & 1) != 0) {
            c14701a = null;
        }
        if ((i & 2) != 0) {
            c14701a2 = null;
        }
        arrayBroadcastChannel.m5449e0(c14701a, c14701a2);
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c, kotlinx.coroutines.channels.InterfaceC14704h0
    /* renamed from: L */
    public boolean mo5178L(@Nullable Throwable th) {
        if (super.mo5178L(th)) {
            m5459U();
            return true;
        }
        return false;
    }

    /* renamed from: X */
    public final int m5456X() {
        return this.f42072g;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: b */
    public void mo3827b(@Nullable CancellationException cancellationException) {
        mo3828a(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: j */
    protected String mo5180j() {
        return "(buffer:capacity=" + this.f42070e.length + ",size=" + m5454Z() + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: u */
    protected boolean mo5172u() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    /* renamed from: v */
    public InterfaceC14695d0<E> mo5175v() {
        C14701a c14701a = new C14701a(this);
        m5448f0(this, c14701a, null, 2, null);
        return c14701a;
    }

    @Override // kotlinx.coroutines.channels.AbstractC14687c
    /* renamed from: w */
    protected boolean mo5171w() {
        return m5454Z() >= this.f42072g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC14687c
    @NotNull
    /* renamed from: y */
    public Object mo5170y(E e) {
        ReentrantLock reentrantLock = this.f42069d;
        reentrantLock.lock();
        try {
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            int m5454Z = m5454Z();
            if (m5454Z >= this.f42072g) {
                return C14685b.f42053f;
            }
            long m5453a0 = m5453a0();
            this.f42070e[(int) (m5453a0 % this.f42072g)] = e;
            m5451c0(m5454Z + 1);
            m5450d0(m5453a0 + 1);
            Unit unit = Unit.f41048a;
            reentrantLock.unlock();
            m5459U();
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
        ReentrantLock reentrantLock = this.f42069d;
        reentrantLock.lock();
        try {
            C14731t<?> m5487l = m5487l();
            if (m5487l != null) {
                return m5487l;
            }
            int m5454Z = m5454Z();
            if (m5454Z >= this.f42072g) {
                return C14685b.f42053f;
            }
            if (!interfaceC15197f.mo3703o()) {
                return C15198g.m3696d();
            }
            long m5453a0 = m5453a0();
            this.f42070e[(int) (m5453a0 % this.f42072g)] = e;
            m5451c0(m5454Z + 1);
            m5450d0(m5453a0 + 1);
            Unit unit = Unit.f41048a;
            reentrantLock.unlock();
            m5459U();
            return C14685b.f42052e;
        } finally {
            reentrantLock.unlock();
        }
    }
}
