package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlinx.coroutines.C15153p;
import kotlinx.coroutines.C15161r;
import kotlinx.coroutines.InterfaceC15064i1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractC14979c;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.C14978b;
import kotlinx.coroutines.flow.internal.InterfaceC14996o;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001FB\u001f\u0012\u0006\u0010Q\u001a\u00020\u0015\u0012\u0006\u0010S\u001a\u00020\u0015\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\be\u0010fJ\u0017\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\tJ\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J9\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J(\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\rH\u0002J3\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u00132\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u0013H\u0002¢\u0006\u0004\b*\u0010+J!\u0010.\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u0010\tJ\u001b\u00101\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\rH\u0000¢\u0006\u0004\b4\u00105J%\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u00132\u0006\u00106\u001a\u00020\rH\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0003H\u0014J\u001f\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00132\u0006\u0010<\u001a\u00020\u0015H\u0014¢\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\u000bH\u0016J&\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010D\u001a\u00020CH\u0016R \u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010GR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u00103R\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010\fR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010\fR\u0014\u0010Q\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010\fR\u0014\u0010S\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010\fR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u00105R\u0014\u0010Z\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010YR\u0014\u0010^\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u00105R\u0014\u0010`\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u00105R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, m12616d2 = {"Lkotlinx/coroutines/flow/y;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/b0;", "Lkotlinx/coroutines/flow/s;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", DomainCampaignEx.LOOPBACK_VALUE, "", "(Ljava/lang/Object;)Z", "U", "Lkotlin/f1;", "I", "", "newHead", "F", "", "item", "K", "", "curBuffer", "", "curSize", "newSize", ExifInterface.LATITUDE_SOUTH, "([Ljava/lang/Object;II)[Ljava/lang/Object;", "Lkotlinx/coroutines/flow/y$a;", "emitter", "D", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "X", ExifInterface.LONGITUDE_EAST, "slot", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "index", "O", "Lkotlin/coroutines/c;", "resumesIn", "L", "([Lkotlin/coroutines/c;)[Lkotlin/coroutines/c;", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "J", "Z", "()J", "oldIndex", "Y", "(J)[Lkotlin/coroutines/c;", "C", "(Lkotlinx/coroutines/flow/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "G", "size", "H", "(I)[Lkotlinx/coroutines/flow/b0;", "g", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "[Ljava/lang/Object;", "buffer", "f", "replayIndex", "minCollectorIndex", "h", "bufferSize", "i", "queueSize", "j", "replay", "k", "bufferCapacity", C7304t.f25048d, "Lkotlinx/coroutines/channels/BufferOverflow;", "N", "head", "Q", "()I", "replaySize", "R", "totalSize", "M", "bufferEndIndex", "P", "queueEndIndex", "", "d", "()Ljava/util/List;", "replayCache", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15049y<T> extends AbstractSharedFlow<C14944b0> implements InterfaceC15043s<T>, InterfaceC14945c<T>, InterfaceC14996o<T> {

    /* renamed from: e */
    private Object[] f42995e;

    /* renamed from: f */
    private long f42996f;

    /* renamed from: g */
    private long f42997g;

    /* renamed from: h */
    private int f42998h;

    /* renamed from: i */
    private int f42999i;

    /* renamed from: j */
    private final int f43000j;

    /* renamed from: k */
    private final int f43001k;

    /* renamed from: l */
    private final BufferOverflow f43002l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SharedFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m12616d2 = {"Lkotlinx/coroutines/flow/y$a;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "Lkotlinx/coroutines/flow/y;", "a", "Lkotlinx/coroutines/flow/y;", "flow", "", "b", "J", "index", "", "c", "Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "cont", "<init>", "(Lkotlinx/coroutines/flow/y;JLjava/lang/Object;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.y$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15050a implements InterfaceC15064i1 {
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: a */
        public final C15049y<?> f43003a;
        @JvmPlatformAnnotations

        /* renamed from: b */
        public long f43004b;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: c */
        public final Object f43005c;
        @JvmPlatformAnnotations
        @NotNull

        /* renamed from: d */
        public final InterfaceC14268c<Unit> f43006d;

        /* JADX WARN: Multi-variable type inference failed */
        public C15050a(@NotNull C15049y<?> c15049y, long j, @Nullable Object obj, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            this.f43003a = c15049y;
            this.f43004b = j;
            this.f43005c = obj;
            this.f43006d = interfaceC14268c;
        }

        @Override // kotlinx.coroutines.InterfaceC15064i1
        public void dispose() {
            this.f43003a.m4496D(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SharedFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collect"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.SharedFlowImpl", m8638f = "SharedFlow.kt", m8637i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m8636l = {314, 321, 324}, m8635m = "collect", m8634n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newValue", "this", "collector", "slot", "collectorJob", "newValue"}, m8633s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.y$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15051b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f43007a;

        /* renamed from: b */
        int f43008b;

        /* renamed from: d */
        Object f43010d;

        /* renamed from: e */
        Object f43011e;

        /* renamed from: f */
        Object f43012f;

        /* renamed from: g */
        Object f43013g;

        /* renamed from: h */
        Object f43014h;

        C15051b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f43007a = obj;
            this.f43008b |= Integer.MIN_VALUE;
            return C15049y.this.mo4470e(null, this);
        }
    }

    public C15049y(int i, int i2, @NotNull BufferOverflow bufferOverflow) {
        this.f43000j = i;
        this.f43001k = i2;
        this.f43002l = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public final void m4496D(C15050a c15050a) {
        Object m4827f;
        synchronized (this) {
            if (c15050a.f43004b < m4486N()) {
                return;
            }
            Object[] objArr = this.f42995e;
            C14342f0.m8187m(objArr);
            m4827f = SharedFlow.m4827f(objArr, c15050a.f43004b);
            if (m4827f != c15050a) {
                return;
            }
            SharedFlow.m4825h(objArr, c15050a.f43004b, SharedFlow.f42672a);
            m4495E();
            Unit unit = Unit.f41048a;
        }
    }

    /* renamed from: E */
    private final void m4495E() {
        Object m4827f;
        if (this.f43001k != 0 || this.f42999i > 1) {
            Object[] objArr = this.f42995e;
            C14342f0.m8187m(objArr);
            while (this.f42999i > 0) {
                m4827f = SharedFlow.m4827f(objArr, (m4486N() + m4482R()) - 1);
                if (m4827f != SharedFlow.f42672a) {
                    return;
                }
                this.f42999i--;
                SharedFlow.m4825h(objArr, m4486N() + m4482R(), null);
            }
        }
    }

    /* renamed from: F */
    private final void m4494F(long j) {
        AbstractC14979c[] abstractC14979cArr;
        if (((AbstractSharedFlow) this).f42809b != 0 && (abstractC14979cArr = ((AbstractSharedFlow) this).f42808a) != null) {
            for (AbstractC14979c abstractC14979c : abstractC14979cArr) {
                if (abstractC14979c != null) {
                    C14944b0 c14944b0 = (C14944b0) abstractC14979c;
                    long j2 = c14944b0.f42679a;
                    if (j2 >= 0 && j2 < j) {
                        c14944b0.f42679a = j;
                    }
                }
            }
        }
        this.f42997g = j;
    }

    /* renamed from: I */
    private final void m4491I() {
        Object[] objArr = this.f42995e;
        C14342f0.m8187m(objArr);
        SharedFlow.m4825h(objArr, m4486N(), null);
        this.f42998h--;
        long m4486N = m4486N() + 1;
        if (this.f42996f < m4486N) {
            this.f42996f = m4486N;
        }
        if (this.f42997g < m4486N) {
            m4494F(m4486N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public final void m4489K(Object obj) {
        int m4482R = m4482R();
        Object[] objArr = this.f42995e;
        if (objArr == null) {
            objArr = m4481S(null, 0, 2);
        } else if (m4482R >= objArr.length) {
            objArr = m4481S(objArr, m4482R, objArr.length * 2);
        }
        SharedFlow.m4825h(objArr, m4486N() + m4482R, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: L */
    public final InterfaceC14268c<Unit>[] m4488L(InterfaceC14268c<Unit>[] interfaceC14268cArr) {
        AbstractC14979c[] abstractC14979cArr;
        C14944b0 c14944b0;
        InterfaceC14268c<? super Unit> interfaceC14268c;
        int length = interfaceC14268cArr.length;
        if (((AbstractSharedFlow) this).f42809b != 0 && (abstractC14979cArr = ((AbstractSharedFlow) this).f42808a) != null) {
            int length2 = abstractC14979cArr.length;
            int i = 0;
            interfaceC14268cArr = interfaceC14268cArr;
            while (i < length2) {
                AbstractC14979c abstractC14979c = abstractC14979cArr[i];
                if (abstractC14979c != null && (interfaceC14268c = (c14944b0 = (C14944b0) abstractC14979c).f42680b) != null && m4478V(c14944b0) >= 0) {
                    int length3 = interfaceC14268cArr.length;
                    interfaceC14268cArr = interfaceC14268cArr;
                    if (length >= length3) {
                        Object[] copyOf = Arrays.copyOf(interfaceC14268cArr, Math.max(2, interfaceC14268cArr.length * 2));
                        C14342f0.m8185o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        interfaceC14268cArr = (InterfaceC14268c[]) copyOf;
                    }
                    interfaceC14268cArr[length] = interfaceC14268c;
                    c14944b0.f42680b = null;
                    length++;
                }
                i++;
                interfaceC14268cArr = interfaceC14268cArr;
            }
        }
        return interfaceC14268cArr;
    }

    /* renamed from: M */
    private final long m4487M() {
        return m4486N() + this.f42998h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public final long m4486N() {
        return Math.min(this.f42997g, this.f42996f);
    }

    /* renamed from: O */
    private final Object m4485O(long j) {
        Object m4827f;
        Object[] objArr = this.f42995e;
        C14342f0.m8187m(objArr);
        m4827f = SharedFlow.m4827f(objArr, j);
        return m4827f instanceof C15050a ? ((C15050a) m4827f).f43005c : m4827f;
    }

    /* renamed from: P */
    private final long m4484P() {
        return m4486N() + this.f42998h + this.f42999i;
    }

    /* renamed from: Q */
    private final int m4483Q() {
        return (int) ((m4486N() + this.f42998h) - this.f42996f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R */
    public final int m4482R() {
        return this.f42998h + this.f42999i;
    }

    /* renamed from: S */
    private final Object[] m4481S(Object[] objArr, int i, int i2) {
        Object m4827f;
        if (i2 > 0) {
            Object[] objArr2 = new Object[i2];
            this.f42995e = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long m4486N = m4486N();
            for (int i3 = 0; i3 < i; i3++) {
                long j = i3 + m4486N;
                m4827f = SharedFlow.m4827f(objArr, j);
                SharedFlow.m4825h(objArr2, j, m4827f);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T */
    public final boolean m4480T(T t) {
        if (m4789p() == 0) {
            return m4479U(t);
        }
        if (this.f42998h >= this.f43001k && this.f42997g <= this.f42996f) {
            int i = C15052z.f43015a[this.f43002l.ordinal()];
            if (i == 1) {
                return false;
            }
            if (i == 2) {
                return true;
            }
        }
        m4489K(t);
        int i2 = this.f42998h + 1;
        this.f42998h = i2;
        if (i2 > this.f43001k) {
            m4491I();
        }
        if (m4483Q() > this.f43000j) {
            m4476X(this.f42996f + 1, this.f42997g, m4487M(), m4484P());
        }
        return true;
    }

    /* renamed from: U */
    private final boolean m4479U(T t) {
        if (this.f43000j == 0) {
            return true;
        }
        m4489K(t);
        int i = this.f42998h + 1;
        this.f42998h = i;
        if (i > this.f43000j) {
            m4491I();
        }
        this.f42997g = m4486N() + this.f42998h;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public final long m4478V(C14944b0 c14944b0) {
        long j = c14944b0.f42679a;
        if (j < m4487M()) {
            return j;
        }
        if (this.f43001k <= 0 && j <= m4486N() && this.f42999i != 0) {
            return j;
        }
        return -1L;
    }

    /* renamed from: W */
    private final Object m4477W(C14944b0 c14944b0) {
        Object obj;
        InterfaceC14268c<Unit>[] interfaceC14268cArr = C14978b.f42812a;
        synchronized (this) {
            long m4478V = m4478V(c14944b0);
            if (m4478V < 0) {
                obj = SharedFlow.f42672a;
            } else {
                long j = c14944b0.f42679a;
                Object m4485O = m4485O(m4478V);
                c14944b0.f42679a = m4478V + 1;
                interfaceC14268cArr = m4475Y(j);
                obj = m4485O;
            }
        }
        for (InterfaceC14268c<Unit> interfaceC14268c : interfaceC14268cArr) {
            if (interfaceC14268c != null) {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                interfaceC14268c.resumeWith(Result.m60148constructorimpl(unit));
            }
        }
        return obj;
    }

    /* renamed from: X */
    private final void m4476X(long j, long j2, long j3, long j4) {
        long min = Math.min(j2, j);
        for (long m4486N = m4486N(); m4486N < min; m4486N++) {
            Object[] objArr = this.f42995e;
            C14342f0.m8187m(objArr);
            SharedFlow.m4825h(objArr, m4486N, null);
        }
        this.f42996f = j;
        this.f42997g = j2;
        this.f42998h = (int) (j3 - min);
        this.f42999i = (int) (j4 - j3);
    }

    @Nullable
    /* renamed from: C */
    final /* synthetic */ Object m4497C(@NotNull C14944b0 c14944b0, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        synchronized (this) {
            if (m4478V(c14944b0) < 0) {
                c14944b0.f42680b = c15153p;
            } else {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                c15153p.resumeWith(Result.m60148constructorimpl(unit));
            }
            Unit unit2 = Unit.f41048a;
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    /* renamed from: G */
    public C14944b0 mo4468l() {
        return new C14944b0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    @NotNull
    /* renamed from: H */
    public C14944b0[] mo4467m(int i) {
        return new C14944b0[i];
    }

    @Nullable
    /* renamed from: J */
    final /* synthetic */ Object m4490J(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        InterfaceC14268c<Unit>[] interfaceC14268cArr;
        C15050a c15050a;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        InterfaceC14268c<Unit>[] interfaceC14268cArr2 = C14978b.f42812a;
        synchronized (this) {
            if (m4480T(t)) {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                c15153p.resumeWith(Result.m60148constructorimpl(unit));
                interfaceC14268cArr = m4488L(interfaceC14268cArr2);
                c15050a = null;
            } else {
                C15050a c15050a2 = new C15050a(this, m4482R() + m4486N(), t, c15153p);
                m4489K(c15050a2);
                this.f42999i++;
                if (this.f43001k == 0) {
                    interfaceC14268cArr2 = m4488L(interfaceC14268cArr2);
                }
                interfaceC14268cArr = interfaceC14268cArr2;
                c15050a = c15050a2;
            }
        }
        if (c15050a != null) {
            C15161r.m3853a(c15153p, c15050a);
        }
        for (InterfaceC14268c<Unit> interfaceC14268c2 : interfaceC14268cArr) {
            if (interfaceC14268c2 != null) {
                Unit unit2 = Unit.f41048a;
                Result.C14124a c14124a2 = Result.Companion;
                interfaceC14268c2.resumeWith(Result.m60148constructorimpl(unit2));
            }
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @NotNull
    /* renamed from: Y */
    public final InterfaceC14268c<Unit>[] m4475Y(long j) {
        int i;
        long j2;
        long j3;
        Object m4827f;
        Object m4827f2;
        long j4;
        AbstractC14979c[] abstractC14979cArr;
        if (j > this.f42997g) {
            return C14978b.f42812a;
        }
        long m4486N = m4486N();
        long j5 = this.f42998h + m4486N;
        if (this.f43001k == 0 && this.f42999i > 0) {
            j5++;
        }
        if (((AbstractSharedFlow) this).f42809b != 0 && (abstractC14979cArr = ((AbstractSharedFlow) this).f42808a) != null) {
            for (AbstractC14979c abstractC14979c : abstractC14979cArr) {
                if (abstractC14979c != null) {
                    long j6 = ((C14944b0) abstractC14979c).f42679a;
                    if (j6 >= 0 && j6 < j5) {
                        j5 = j6;
                    }
                }
            }
        }
        if (j5 <= this.f42997g) {
            return C14978b.f42812a;
        }
        long m4487M = m4487M();
        if (m4789p() > 0) {
            i = Math.min(this.f42999i, this.f43001k - ((int) (m4487M - j5)));
        } else {
            i = this.f42999i;
        }
        InterfaceC14268c<Unit>[] interfaceC14268cArr = C14978b.f42812a;
        long j7 = this.f42999i + m4487M;
        if (i > 0) {
            interfaceC14268cArr = new InterfaceC14268c[i];
            Object[] objArr = this.f42995e;
            C14342f0.m8187m(objArr);
            long j8 = m4487M;
            int i2 = 0;
            while (true) {
                if (m4487M >= j7) {
                    j2 = j5;
                    j3 = j7;
                    break;
                }
                m4827f2 = SharedFlow.m4827f(objArr, m4487M);
                j2 = j5;
                Symbol symbol = SharedFlow.f42672a;
                if (m4827f2 == symbol) {
                    j3 = j7;
                    j4 = 1;
                } else if (m4827f2 != null) {
                    C15050a c15050a = (C15050a) m4827f2;
                    int i3 = i2 + 1;
                    j3 = j7;
                    interfaceC14268cArr[i2] = c15050a.f43006d;
                    SharedFlow.m4825h(objArr, m4487M, symbol);
                    SharedFlow.m4825h(objArr, j8, c15050a.f43005c);
                    j4 = 1;
                    j8++;
                    if (i3 >= i) {
                        break;
                    }
                    i2 = i3;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                }
                m4487M += j4;
                j5 = j2;
                j7 = j3;
            }
            m4487M = j8;
        } else {
            j2 = j5;
            j3 = j7;
        }
        int i4 = (int) (m4487M - m4486N);
        long j9 = m4789p() == 0 ? m4487M : j2;
        long max = Math.max(this.f42996f, m4487M - Math.min(this.f43000j, i4));
        if (this.f43001k == 0 && max < j3) {
            Object[] objArr2 = this.f42995e;
            C14342f0.m8187m(objArr2);
            m4827f = SharedFlow.m4827f(objArr2, max);
            if (C14342f0.m8193g(m4827f, SharedFlow.f42672a)) {
                m4487M++;
                max++;
            }
        }
        m4476X(max, j9, m4487M, j3);
        m4495E();
        return (interfaceC14268cArr.length == 0) ^ true ? m4488L(interfaceC14268cArr) : interfaceC14268cArr;
    }

    /* renamed from: Z */
    public final long m4474Z() {
        long j = this.f42996f;
        if (j < this.f42997g) {
            this.f42997g = j;
        }
        return j;
    }

    @Override // kotlinx.coroutines.flow.internal.InterfaceC14996o
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<T> mo4473a(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return SharedFlow.m4828e(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15043s
    /* renamed from: b */
    public boolean mo4472b(T t) {
        int i;
        boolean z;
        InterfaceC14268c<Unit>[] interfaceC14268cArr = C14978b.f42812a;
        synchronized (this) {
            if (m4480T(t)) {
                interfaceC14268cArr = m4488L(interfaceC14268cArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (InterfaceC14268c<Unit> interfaceC14268c : interfaceC14268cArr) {
            if (interfaceC14268c != null) {
                Unit unit = Unit.f41048a;
                Result.C14124a c14124a = Result.Companion;
                interfaceC14268c.resumeWith(Result.m60148constructorimpl(unit));
            }
        }
        return z;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15048x
    @NotNull
    /* renamed from: d */
    public List<T> mo4471d() {
        Object m4827f;
        List<T> m12478E;
        synchronized (this) {
            int m4483Q = m4483Q();
            if (m4483Q == 0) {
                m12478E = CollectionsKt__CollectionsKt.m12478E();
                return m12478E;
            }
            ArrayList arrayList = new ArrayList(m4483Q);
            Object[] objArr = this.f42995e;
            C14342f0.m8187m(objArr);
            for (int i = 0; i < m4483Q; i++) {
                m4827f = SharedFlow.m4827f(objArr, this.f42996f + i);
                arrayList.add(m4827f);
            }
            return arrayList;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c0 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #1 {all -> 0x006f, blocks: (B:14:0x003b, B:35:0x00a0, B:38:0x00aa, B:39:0x00ad, B:42:0x00c0, B:19:0x0059, B:22:0x006b, B:33:0x0092), top: B:52:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.flow.b0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.coroutines.flow.internal.a] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00bd -> B:15:0x003e). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo4470e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15049y.mo4470e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        if (mo4472b(t)) {
            return Unit.f41048a;
        }
        Object m4490J = m4490J(t, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4490J == m8642h ? m4490J : Unit.f41048a;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC15043s
    /* renamed from: g */
    public void mo4469g() {
        synchronized (this) {
            m4476X(m4487M(), this.f42997g, m4487M(), m4484P());
            Unit unit = Unit.f41048a;
        }
    }
}
