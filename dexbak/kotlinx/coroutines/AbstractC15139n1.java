package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.C13675a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges._Ranges;
import kotlin.time.C14597e;
import kotlinx.coroutines.InterfaceC15263z0;
import kotlinx.coroutines.internal.C15104v;
import kotlinx.coroutines.internal.InterfaceC15102t0;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004789\u001cB\u0007¢\u0006\u0004\b6\u0010\rJ\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u000f\u0010\u0018\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0018\u0010\rJ%\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\n\u0010\u001e\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u000bH\u0004¢\u0006\u0004\b,\u0010\rR$\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010/R\u0014\u00105\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b4\u0010#¨\u0006:"}, m12616d2 = {"Lkotlinx/coroutines/n1;", "Lkotlinx/coroutines/o1;", "Lkotlinx/coroutines/z0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "X", "(Ljava/lang/Runnable;)Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Ljava/lang/Runnable;", "Lkotlin/f1;", "U", "()V", "Lkotlinx/coroutines/n1$c;", "e0", "(Lkotlinx/coroutines/n1$c;)Z", "", "now", "delayedTask", "", "b0", "(JLkotlinx/coroutines/n1$c;)I", "Y", "shutdown", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "(JLkotlinx/coroutines/o;)V", "block", "Lkotlinx/coroutines/i1;", "c0", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/i1;", "J", "()J", "Lkotlin/coroutines/f;", "context", "dispatch", "(Lkotlin/coroutines/f;Ljava/lang/Runnable;)V", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/Runnable;)V", "a0", "(JLkotlinx/coroutines/n1$c;)V", "Z", DomainCampaignEx.LOOPBACK_VALUE, "isCompleted", "()Z", "d0", "(Z)V", "G", "isEmpty", "B", "nextTime", "<init>", "a", "b", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.n1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15139n1 extends AbstractC15150o1 implements InterfaceC15263z0 {

    /* renamed from: d */
    private static final AtomicReferenceFieldUpdater f43191d = AtomicReferenceFieldUpdater.newUpdater(AbstractC15139n1.class, Object.class, "_queue");

    /* renamed from: e */
    private static final AtomicReferenceFieldUpdater f43192e = AtomicReferenceFieldUpdater.newUpdater(AbstractC15139n1.class, Object.class, "_delayed");
    private volatile Object _queue = null;
    private volatile Object _delayed = null;
    private volatile int _isCompleted = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EventLoop.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m12616d2 = {"Lkotlinx/coroutines/n1$a;", "Lkotlinx/coroutines/n1$c;", "Lkotlin/f1;", "run", "", "toString", "Lkotlinx/coroutines/o;", "d", "Lkotlinx/coroutines/o;", "cont", "", "nanoTime", "<init>", "(Lkotlinx/coroutines/n1;JLkotlinx/coroutines/o;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.n1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15140a extends AbstractRunnableC15142c {

        /* renamed from: d */
        private final InterfaceC15146o<Unit> f43193d;

        /* JADX WARN: Multi-variable type inference failed */
        public C15140a(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
            super(j);
            this.f43193d = interfaceC15146o;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43193d.mo3916I(AbstractC15139n1.this, Unit.f41048a);
        }

        @Override // kotlinx.coroutines.AbstractC15139n1.AbstractRunnableC15142c
        @NotNull
        public String toString() {
            return super.toString() + this.f43193d.toString();
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/n1$b;", "Lkotlinx/coroutines/n1$c;", "Lkotlin/f1;", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "d", "Ljava/lang/Runnable;", "block", "", "nanoTime", "<init>", "(JLjava/lang/Runnable;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.n1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    private static final class C15141b extends AbstractRunnableC15142c {

        /* renamed from: d */
        private final Runnable f43195d;

        public C15141b(long j, @NotNull Runnable runnable) {
            super(j);
            this.f43195d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43195d.run();
        }

        @Override // kotlinx.coroutines.AbstractC15139n1.AbstractRunnableC15142c
        @NotNull
        public String toString() {
            return super.toString() + this.f43195d.toString();
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\"\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R0\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010%\"\u0004\b\u0017\u0010&¨\u0006*"}, m12616d2 = {"Lkotlinx/coroutines/n1$c;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/i1;", "Lkotlinx/coroutines/internal/t0;", AdnName.OTHER, "", "e", "", "now", "", "h", "Lkotlinx/coroutines/n1$d;", "delayed", "Lkotlinx/coroutines/n1;", "eventLoop", "f", "Lkotlin/f1;", "dispose", "", "toString", "", "a", "Ljava/lang/Object;", "_heap", "b", "I", "()I", "d", "(I)V", "index", "c", "J", "nanoTime", "Lkotlinx/coroutines/internal/s0;", DomainCampaignEx.LOOPBACK_VALUE, "()Lkotlinx/coroutines/internal/s0;", "(Lkotlinx/coroutines/internal/s0;)V", "heap", "<init>", "(J)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.n1$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractRunnableC15142c implements Runnable, Comparable<AbstractRunnableC15142c>, InterfaceC15064i1, InterfaceC15102t0 {

        /* renamed from: a */
        private Object f43196a;

        /* renamed from: b */
        private int f43197b = -1;
        @JvmPlatformAnnotations

        /* renamed from: c */
        public long f43198c;

        public AbstractRunnableC15142c(long j) {
            this.f43198c = j;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC15102t0
        /* renamed from: a */
        public void mo3559a(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this.f43196a;
            symbol = C15158q1.f43219a;
            if (obj != symbol) {
                this.f43196a = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.InterfaceC15102t0
        /* renamed from: b */
        public int mo3558b() {
            return this.f43197b;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC15102t0
        @Nullable
        /* renamed from: c */
        public ThreadSafeHeap<?> mo3557c() {
            Object obj = this.f43196a;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC15102t0
        /* renamed from: d */
        public void mo3556d(int i) {
            this.f43197b = i;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public final synchronized void dispose() {
            Symbol symbol;
            Symbol symbol2;
            Object obj = this.f43196a;
            symbol = C15158q1.f43219a;
            if (obj == symbol) {
                return;
            }
            if (!(obj instanceof C15143d)) {
                obj = null;
            }
            C15143d c15143d = (C15143d) obj;
            if (c15143d != null) {
                c15143d.m4178j(this);
            }
            symbol2 = C15158q1.f43219a;
            this.f43196a = symbol2;
        }

        @Override // java.lang.Comparable
        /* renamed from: e */
        public int compareTo(@NotNull AbstractRunnableC15142c abstractRunnableC15142c) {
            long j = this.f43198c - abstractRunnableC15142c.f43198c;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        /* renamed from: f */
        public final synchronized int m3951f(long j, @NotNull C15143d c15143d, @NotNull AbstractC15139n1 abstractC15139n1) {
            Symbol symbol;
            Object obj = this.f43196a;
            symbol = C15158q1.f43219a;
            if (obj == symbol) {
                return 2;
            }
            synchronized (c15143d) {
                AbstractRunnableC15142c m4183e = c15143d.m4183e();
                if (abstractC15139n1.isCompleted()) {
                    return 1;
                }
                if (m4183e == null) {
                    c15143d.f43199b = j;
                } else {
                    long j2 = m4183e.f43198c;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - c15143d.f43199b > 0) {
                        c15143d.f43199b = j;
                    }
                }
                long j3 = this.f43198c;
                long j4 = c15143d.f43199b;
                if (j3 - j4 < 0) {
                    this.f43198c = j4;
                }
                c15143d.m4187a(this);
                return 0;
            }
        }

        /* renamed from: h */
        public final boolean m3950h(long j) {
            return j - this.f43198c >= 0;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.f43198c + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, m12616d2 = {"Lkotlinx/coroutines/n1$d;", "Lkotlinx/coroutines/internal/s0;", "Lkotlinx/coroutines/n1$c;", "", "b", "J", "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.n1$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15143d extends ThreadSafeHeap<AbstractRunnableC15142c> {
        @JvmPlatformAnnotations

        /* renamed from: b */
        public long f43199b;

        public C15143d(long j) {
            this.f43199b = j;
        }
    }

    /* renamed from: U */
    private final void m3963U() {
        Symbol symbol;
        Symbol symbol2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f43191d;
                symbol = C15158q1.f43226h;
                if (C13675a.m12692a(atomicReferenceFieldUpdater, this, null, symbol)) {
                    return;
                }
            } else if (obj instanceof C15104v) {
                ((C15104v) obj).m4156d();
                return;
            } else {
                symbol2 = C15158q1.f43226h;
                if (obj == symbol2) {
                    return;
                }
                C15104v c15104v = new C15104v(8, true);
                c15104v.m4159a((Runnable) obj);
                if (C13675a.m12692a(f43191d, this, obj, c15104v)) {
                    return;
                }
            }
        }
    }

    /* renamed from: V */
    private final Runnable m3962V() {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C15104v) {
                C15104v c15104v = (C15104v) obj;
                Object m4148l = c15104v.m4148l();
                if (m4148l != C15104v.f43119s) {
                    return (Runnable) m4148l;
                }
                C13675a.m12692a(f43191d, this, obj, c15104v.m4149k());
            } else {
                symbol = C15158q1.f43226h;
                if (obj == symbol) {
                    return null;
                }
                if (C13675a.m12692a(f43191d, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    /* renamed from: X */
    private final boolean m3960X(Runnable runnable) {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (C13675a.m12692a(f43191d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C15104v) {
                C15104v c15104v = (C15104v) obj;
                int m4159a = c15104v.m4159a(runnable);
                if (m4159a == 0) {
                    return true;
                }
                if (m4159a == 1) {
                    C13675a.m12692a(f43191d, this, obj, c15104v.m4149k());
                } else if (m4159a == 2) {
                    return false;
                }
            } else {
                symbol = C15158q1.f43226h;
                if (obj == symbol) {
                    return false;
                }
                C15104v c15104v2 = new C15104v(8, true);
                c15104v2.m4159a((Runnable) obj);
                c15104v2.m4159a(runnable);
                if (C13675a.m12692a(f43191d, this, obj, c15104v2)) {
                    return true;
                }
            }
        }
    }

    /* renamed from: Y */
    private final void m3959Y() {
        AbstractRunnableC15142c m4175m;
        InterfaceC15152o3 m3872b = C15156p3.m3872b();
        long nanoTime = m3872b != null ? m3872b.nanoTime() : System.nanoTime();
        while (true) {
            C15143d c15143d = (C15143d) this._delayed;
            if (c15143d == null || (m4175m = c15143d.m4175m()) == null) {
                return;
            }
            m3935N(nanoTime, m4175m);
        }
    }

    /* renamed from: b0 */
    private final int m3956b0(long j, AbstractRunnableC15142c abstractRunnableC15142c) {
        if (isCompleted()) {
            return 1;
        }
        C15143d c15143d = (C15143d) this._delayed;
        if (c15143d == null) {
            C13675a.m12692a(f43192e, this, null, new C15143d(j));
            Object obj = this._delayed;
            C14342f0.m8187m(obj);
            c15143d = (C15143d) obj;
        }
        return abstractRunnableC15142c.m3951f(j, c15143d, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public final void m3954d0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    /* renamed from: e0 */
    private final boolean m3953e0(AbstractRunnableC15142c abstractRunnableC15142c) {
        C15143d c15143d = (C15143d) this._delayed;
        return (c15143d != null ? c15143d.m4180h() : null) == abstractRunnableC15142c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isCompleted() {
        return this._isCompleted;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractC15133m1
    /* renamed from: B */
    public long mo3967B() {
        AbstractRunnableC15142c m4180h;
        long m7478o;
        Symbol symbol;
        if (super.mo3967B() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof C15104v)) {
                symbol = C15158q1.f43226h;
                return obj == symbol ? Long.MAX_VALUE : 0L;
            } else if (!((C15104v) obj).m4152h()) {
                return 0L;
            }
        }
        C15143d c15143d = (C15143d) this._delayed;
        if (c15143d == null || (m4180h = c15143d.m4180h()) == null) {
            return Long.MAX_VALUE;
        }
        long j = m4180h.f43198c;
        InterfaceC15152o3 m3872b = C15156p3.m3872b();
        m7478o = _Ranges.m7478o(j - (m3872b != null ? m3872b.nanoTime() : System.nanoTime()), 0L);
        return m7478o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractC15133m1
    /* renamed from: G */
    public boolean mo3966G() {
        Symbol symbol;
        if (m3993I()) {
            C15143d c15143d = (C15143d) this._delayed;
            if (c15143d == null || c15143d.m4181g()) {
                Object obj = this._queue;
                if (obj != null) {
                    if (obj instanceof C15104v) {
                        return ((C15104v) obj).m4152h();
                    }
                    symbol = C15158q1.f43226h;
                    if (obj != symbol) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    @Override // kotlinx.coroutines.AbstractC15133m1
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long mo3563J() {
        /*
            r9 = this;
            boolean r0 = r9.m3992K()
            r1 = 0
            if (r0 == 0) goto L9
            return r1
        L9:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.n1$d r0 = (kotlinx.coroutines.AbstractC15139n1.C15143d) r0
            if (r0 == 0) goto L4d
            boolean r3 = r0.m4181g()
            if (r3 != 0) goto L4d
            kotlinx.coroutines.o3 r3 = kotlinx.coroutines.C15156p3.m3872b()
            if (r3 == 0) goto L20
            long r3 = r3.nanoTime()
            goto L24
        L20:
            long r3 = java.lang.System.nanoTime()
        L24:
            monitor-enter(r0)
            kotlinx.coroutines.internal.t0 r5 = r0.m4183e()     // Catch: java.lang.Throwable -> L4a
            r6 = 0
            if (r5 == 0) goto L44
            kotlinx.coroutines.n1$c r5 = (kotlinx.coroutines.AbstractC15139n1.AbstractRunnableC15142c) r5     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r5.m3950h(r3)     // Catch: java.lang.Throwable -> L4a
            r8 = 0
            if (r7 == 0) goto L3a
            boolean r5 = r9.m3960X(r5)     // Catch: java.lang.Throwable -> L4a
            goto L3b
        L3a:
            r5 = 0
        L3b:
            if (r5 == 0) goto L42
            kotlinx.coroutines.internal.t0 r5 = r0.m4177k(r8)     // Catch: java.lang.Throwable -> L4a
            r6 = r5
        L42:
            monitor-exit(r0)
            goto L45
        L44:
            monitor-exit(r0)
        L45:
            kotlinx.coroutines.n1$c r6 = (kotlinx.coroutines.AbstractC15139n1.AbstractRunnableC15142c) r6
            if (r6 == 0) goto L4d
            goto L24
        L4a:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L4d:
            java.lang.Runnable r0 = r9.m3962V()
            if (r0 == 0) goto L57
            r0.run()
            return r1
        L57:
            long r0 = r9.mo3967B()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AbstractC15139n1.mo3563J():long");
    }

    /* renamed from: W */
    public final void m3961W(@NotNull Runnable runnable) {
        if (m3960X(runnable)) {
            m3934P();
        } else {
            DefaultExecutor.f43436m.m3961W(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Z */
    public final void m3958Z() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: a0 */
    public final void m3957a0(long j, @NotNull AbstractRunnableC15142c abstractRunnableC15142c) {
        int m3956b0 = m3956b0(j, abstractRunnableC15142c);
        if (m3956b0 == 0) {
            if (m3953e0(abstractRunnableC15142c)) {
                m3934P();
            }
        } else if (m3956b0 == 1) {
            m3935N(j, abstractRunnableC15142c);
        } else if (m3956b0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: c0 */
    public final InterfaceC15064i1 m3955c0(long j, @NotNull Runnable runnable) {
        long m3858d = C15158q1.m3858d(j);
        if (m3858d < C14597e.f41662c) {
            InterfaceC15152o3 m3872b = C15156p3.m3872b();
            long nanoTime = m3872b != null ? m3872b.nanoTime() : System.nanoTime();
            C15141b c15141b = new C15141b(m3858d + nanoTime, runnable);
            m3957a0(nanoTime, c15141b);
            return c15141b;
        }
        return C15171s2.f43239a;
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    /* renamed from: d */
    public void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o) {
        long m3858d = C15158q1.m3858d(j);
        if (m3858d < C14597e.f41662c) {
            InterfaceC15152o3 m3872b = C15156p3.m3872b();
            long nanoTime = m3872b != null ? m3872b.nanoTime() : System.nanoTime();
            C15140a c15140a = new C15140a(m3858d + nanoTime, interfaceC15146o);
            C15161r.m3853a(interfaceC15146o, c15140a);
            m3957a0(nanoTime, c15140a);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        m3961W(runnable);
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return InterfaceC15263z0.C15264a.m3483b(this, j, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.InterfaceC15263z0
    @Nullable
    /* renamed from: k */
    public Object mo3485k(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return InterfaceC15263z0.C15264a.m3484a(this, j, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.AbstractC15133m1
    protected void shutdown() {
        C15120k3.f43148b.m4082c();
        m3954d0(true);
        m3963U();
        do {
        } while (mo3563J() <= 0);
        m3959Y();
    }
}
