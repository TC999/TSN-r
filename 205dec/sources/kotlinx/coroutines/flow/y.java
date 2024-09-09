package kotlinx.coroutines.flow;

import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.i1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharedFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001FB\u001f\u0012\u0006\u0010Q\u001a\u00020\u0015\u0012\u0006\u0010S\u001a\u00020\u0015\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\be\u0010fJ\u0017\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0001\u0010\tJ\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\n\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J9\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J(\u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\rH\u0002J3\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u00132\u0014\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u0013H\u0002\u00a2\u0006\u0004\b*\u0010+J!\u0010.\u001a\u00020\u000b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b0\u0010\tJ\u001b\u00101\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b4\u00105J%\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010(0\u00132\u0006\u00106\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\b\u0010;\u001a\u00020\u0003H\u0014J\u001f\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00132\u0006\u0010<\u001a\u00020\u0015H\u0014\u00a2\u0006\u0004\b=\u0010>J\b\u0010?\u001a\u00020\u000bH\u0016J&\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000E2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010D\u001a\u00020CH\u0016R \u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010GR\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00103R\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\fR\u0016\u0010O\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010\fR\u0014\u0010Q\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010\fR\u0014\u0010S\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010\fR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u00105R\u0014\u0010Z\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u00158BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010YR\u0014\u0010^\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u00105R\u0014\u0010`\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b_\u00105R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bb\u0010c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006g"}, d2 = {"Lkotlinx/coroutines/flow/y;", "T", "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/b0;", "Lkotlinx/coroutines/flow/s;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", "value", "", "(Ljava/lang/Object;)Z", "U", "Lkotlin/f1;", "I", "", "newHead", "F", "", "item", "K", "", "curBuffer", "", "curSize", "newSize", "S", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "Lkotlinx/coroutines/flow/y$a;", "emitter", "D", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "X", "E", InAppSlotParams.SLOT_KEY.SLOT, "W", "V", "index", "O", "Lkotlin/coroutines/c;", "resumesIn", "L", "([Lkotlin/coroutines/c;)[Lkotlin/coroutines/c;", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "J", "Z", "()J", "oldIndex", "Y", "(J)[Lkotlin/coroutines/c;", "C", "(Lkotlinx/coroutines/flow/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "G", "size", "H", "(I)[Lkotlinx/coroutines/flow/b0;", "f", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "[Ljava/lang/Object;", "buffer", "replayIndex", "g", "minCollectorIndex", "h", "bufferSize", "i", "queueSize", "j", "replay", "k", "bufferCapacity", "l", "Lkotlinx/coroutines/channels/BufferOverflow;", "N", "head", "Q", "()I", "replaySize", "R", "totalSize", "M", "bufferEndIndex", "P", "queueEndIndex", "", "d", "()Ljava/util/List;", "replayCache", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y<T> extends kotlinx.coroutines.flow.internal.a<b0> implements s<T>, c<T>, kotlinx.coroutines.flow.internal.o<T> {

    /* renamed from: e  reason: collision with root package name */
    private Object[] f60312e;

    /* renamed from: f  reason: collision with root package name */
    private long f60313f;

    /* renamed from: g  reason: collision with root package name */
    private long f60314g;

    /* renamed from: h  reason: collision with root package name */
    private int f60315h;

    /* renamed from: i  reason: collision with root package name */
    private int f60316i;

    /* renamed from: j  reason: collision with root package name */
    private final int f60317j;

    /* renamed from: k  reason: collision with root package name */
    private final int f60318k;

    /* renamed from: l  reason: collision with root package name */
    private final BufferOverflow f60319l;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SharedFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/y$a;", "Lkotlinx/coroutines/i1;", "Lkotlin/f1;", "dispose", "Lkotlinx/coroutines/flow/y;", "a", "Lkotlinx/coroutines/flow/y;", "flow", "", "b", "J", "index", "", "c", "Ljava/lang/Object;", "value", "Lkotlin/coroutines/c;", "d", "Lkotlin/coroutines/c;", "cont", "<init>", "(Lkotlinx/coroutines/flow/y;JLjava/lang/Object;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements i1 {
        @JvmField
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final y<?> f60320a;
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public long f60321b;
        @JvmField
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final Object f60322c;
        @JvmField
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public final kotlin.coroutines.c<f1> f60323d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull y<?> yVar, long j4, @Nullable Object obj, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            this.f60320a = yVar;
            this.f60321b = j4;
            this.f60322c = obj;
            this.f60323d = cVar;
        }

        @Override // kotlinx.coroutines.i1
        public void dispose() {
            this.f60320a.D(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SharedFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR}, m = "collect", n = {"this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "newValue", "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "newValue"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60324a;

        /* renamed from: b  reason: collision with root package name */
        int f60325b;

        /* renamed from: d  reason: collision with root package name */
        Object f60327d;

        /* renamed from: e  reason: collision with root package name */
        Object f60328e;

        /* renamed from: f  reason: collision with root package name */
        Object f60329f;

        /* renamed from: g  reason: collision with root package name */
        Object f60330g;

        /* renamed from: h  reason: collision with root package name */
        Object f60331h;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60324a = obj;
            this.f60325b |= Integer.MIN_VALUE;
            return y.this.e(null, this);
        }
    }

    public y(int i4, int i5, @NotNull BufferOverflow bufferOverflow) {
        this.f60317j = i4;
        this.f60318k = i5;
        this.f60319l = bufferOverflow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(a aVar) {
        Object f4;
        synchronized (this) {
            if (aVar.f60321b < N()) {
                return;
            }
            Object[] objArr = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr);
            f4 = a0.f(objArr, aVar.f60321b);
            if (f4 != aVar) {
                return;
            }
            a0.h(objArr, aVar.f60321b, a0.f59989a);
            E();
            f1 f1Var = f1.f55527a;
        }
    }

    private final void E() {
        Object f4;
        if (this.f60318k != 0 || this.f60316i > 1) {
            Object[] objArr = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr);
            while (this.f60316i > 0) {
                f4 = a0.f(objArr, (N() + R()) - 1);
                if (f4 != a0.f59989a) {
                    return;
                }
                this.f60316i--;
                a0.h(objArr, N() + R(), null);
            }
        }
    }

    private final void F(long j4) {
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (((kotlinx.coroutines.flow.internal.a) this).f60126b != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).f60125a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    b0 b0Var = (b0) cVar;
                    long j5 = b0Var.f59996a;
                    if (j5 >= 0 && j5 < j4) {
                        b0Var.f59996a = j4;
                    }
                }
            }
        }
        this.f60314g = j4;
    }

    private final void I() {
        Object[] objArr = this.f60312e;
        kotlin.jvm.internal.f0.m(objArr);
        a0.h(objArr, N(), null);
        this.f60315h--;
        long N = N() + 1;
        if (this.f60313f < N) {
            this.f60313f = N;
        }
        if (this.f60314g < N) {
            F(N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(Object obj) {
        int R = R();
        Object[] objArr = this.f60312e;
        if (objArr == null) {
            objArr = S(null, 0, 2);
        } else if (R >= objArr.length) {
            objArr = S(objArr, R, objArr.length * 2);
        }
        a0.h(objArr, N() + R, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final kotlin.coroutines.c<f1>[] L(kotlin.coroutines.c<f1>[] cVarArr) {
        kotlinx.coroutines.flow.internal.c[] cVarArr2;
        b0 b0Var;
        kotlin.coroutines.c<? super f1> cVar;
        int length = cVarArr.length;
        if (((kotlinx.coroutines.flow.internal.a) this).f60126b != 0 && (cVarArr2 = ((kotlinx.coroutines.flow.internal.a) this).f60125a) != null) {
            int length2 = cVarArr2.length;
            int i4 = 0;
            cVarArr = cVarArr;
            while (i4 < length2) {
                kotlinx.coroutines.flow.internal.c cVar2 = cVarArr2[i4];
                if (cVar2 != null && (cVar = (b0Var = (b0) cVar2).f59997b) != null && V(b0Var) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        Object[] copyOf = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                        kotlin.jvm.internal.f0.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                        cVarArr = (kotlin.coroutines.c[]) copyOf;
                    }
                    cVarArr[length] = cVar;
                    b0Var.f59997b = null;
                    length++;
                }
                i4++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    private final long M() {
        return N() + this.f60315h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long N() {
        return Math.min(this.f60314g, this.f60313f);
    }

    private final Object O(long j4) {
        Object f4;
        Object[] objArr = this.f60312e;
        kotlin.jvm.internal.f0.m(objArr);
        f4 = a0.f(objArr, j4);
        return f4 instanceof a ? ((a) f4).f60322c : f4;
    }

    private final long P() {
        return N() + this.f60315h + this.f60316i;
    }

    private final int Q() {
        return (int) ((N() + this.f60315h) - this.f60313f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int R() {
        return this.f60315h + this.f60316i;
    }

    private final Object[] S(Object[] objArr, int i4, int i5) {
        Object f4;
        if (i5 > 0) {
            Object[] objArr2 = new Object[i5];
            this.f60312e = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long N = N();
            for (int i6 = 0; i6 < i4; i6++) {
                long j4 = i6 + N;
                f4 = a0.f(objArr, j4);
                a0.h(objArr2, j4, f4);
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean T(T t3) {
        if (p() == 0) {
            return U(t3);
        }
        if (this.f60315h >= this.f60318k && this.f60314g <= this.f60313f) {
            int i4 = z.f60332a[this.f60319l.ordinal()];
            if (i4 == 1) {
                return false;
            }
            if (i4 == 2) {
                return true;
            }
        }
        K(t3);
        int i5 = this.f60315h + 1;
        this.f60315h = i5;
        if (i5 > this.f60318k) {
            I();
        }
        if (Q() > this.f60317j) {
            X(this.f60313f + 1, this.f60314g, M(), P());
        }
        return true;
    }

    private final boolean U(T t3) {
        if (this.f60317j == 0) {
            return true;
        }
        K(t3);
        int i4 = this.f60315h + 1;
        this.f60315h = i4;
        if (i4 > this.f60317j) {
            I();
        }
        this.f60314g = N() + this.f60315h;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long V(b0 b0Var) {
        long j4 = b0Var.f59996a;
        if (j4 < M()) {
            return j4;
        }
        if (this.f60318k <= 0 && j4 <= N() && this.f60316i != 0) {
            return j4;
        }
        return -1L;
    }

    private final Object W(b0 b0Var) {
        Object obj;
        kotlin.coroutines.c<f1>[] cVarArr = kotlinx.coroutines.flow.internal.b.f60129a;
        synchronized (this) {
            long V = V(b0Var);
            if (V < 0) {
                obj = a0.f59989a;
            } else {
                long j4 = b0Var.f59996a;
                Object O = O(V);
                b0Var.f59996a = V + 1;
                cVarArr = Y(j4);
                obj = O;
            }
        }
        for (kotlin.coroutines.c<f1> cVar : cVarArr) {
            if (cVar != null) {
                f1 f1Var = f1.f55527a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m119constructorimpl(f1Var));
            }
        }
        return obj;
    }

    private final void X(long j4, long j5, long j6, long j7) {
        long min = Math.min(j5, j4);
        for (long N = N(); N < min; N++) {
            Object[] objArr = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr);
            a0.h(objArr, N, null);
        }
        this.f60313f = j4;
        this.f60314g = j5;
        this.f60315h = (int) (j6 - min);
        this.f60316i = (int) (j7 - j6);
    }

    @Nullable
    final /* synthetic */ Object C(@NotNull b0 b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(d4, 1);
        pVar.H();
        synchronized (this) {
            if (V(b0Var) < 0) {
                b0Var.f59997b = pVar;
            } else {
                f1 f1Var = f1.f55527a;
                Result.a aVar = Result.Companion;
                pVar.resumeWith(Result.m119constructorimpl(f1Var));
            }
            f1 f1Var2 = f1.f55527a;
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: G */
    public b0 l() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: H */
    public b0[] m(int i4) {
        return new b0[i4];
    }

    @Nullable
    final /* synthetic */ Object J(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        kotlin.coroutines.c d4;
        kotlin.coroutines.c<f1>[] cVarArr;
        a aVar;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(d4, 1);
        pVar.H();
        kotlin.coroutines.c<f1>[] cVarArr2 = kotlinx.coroutines.flow.internal.b.f60129a;
        synchronized (this) {
            if (T(t3)) {
                f1 f1Var = f1.f55527a;
                Result.a aVar2 = Result.Companion;
                pVar.resumeWith(Result.m119constructorimpl(f1Var));
                cVarArr = L(cVarArr2);
                aVar = null;
            } else {
                a aVar3 = new a(this, R() + N(), t3, pVar);
                K(aVar3);
                this.f60316i++;
                if (this.f60318k == 0) {
                    cVarArr2 = L(cVarArr2);
                }
                cVarArr = cVarArr2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            kotlinx.coroutines.r.a(pVar, aVar);
        }
        for (kotlin.coroutines.c<f1> cVar2 : cVarArr) {
            if (cVar2 != null) {
                f1 f1Var2 = f1.f55527a;
                Result.a aVar4 = Result.Companion;
                cVar2.resumeWith(Result.m119constructorimpl(f1Var2));
            }
        }
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @NotNull
    public final kotlin.coroutines.c<f1>[] Y(long j4) {
        int i4;
        long j5;
        long j6;
        Object f4;
        Object f5;
        long j7;
        kotlinx.coroutines.flow.internal.c[] cVarArr;
        if (j4 > this.f60314g) {
            return kotlinx.coroutines.flow.internal.b.f60129a;
        }
        long N = N();
        long j8 = this.f60315h + N;
        if (this.f60318k == 0 && this.f60316i > 0) {
            j8++;
        }
        if (((kotlinx.coroutines.flow.internal.a) this).f60126b != 0 && (cVarArr = ((kotlinx.coroutines.flow.internal.a) this).f60125a) != null) {
            for (kotlinx.coroutines.flow.internal.c cVar : cVarArr) {
                if (cVar != null) {
                    long j9 = ((b0) cVar).f59996a;
                    if (j9 >= 0 && j9 < j8) {
                        j8 = j9;
                    }
                }
            }
        }
        if (j8 <= this.f60314g) {
            return kotlinx.coroutines.flow.internal.b.f60129a;
        }
        long M = M();
        if (p() > 0) {
            i4 = Math.min(this.f60316i, this.f60318k - ((int) (M - j8)));
        } else {
            i4 = this.f60316i;
        }
        kotlin.coroutines.c<f1>[] cVarArr2 = kotlinx.coroutines.flow.internal.b.f60129a;
        long j10 = this.f60316i + M;
        if (i4 > 0) {
            cVarArr2 = new kotlin.coroutines.c[i4];
            Object[] objArr = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr);
            long j11 = M;
            int i5 = 0;
            while (true) {
                if (M >= j10) {
                    j5 = j8;
                    j6 = j10;
                    break;
                }
                f5 = a0.f(objArr, M);
                j5 = j8;
                kotlinx.coroutines.internal.j0 j0Var = a0.f59989a;
                if (f5 == j0Var) {
                    j6 = j10;
                    j7 = 1;
                } else if (f5 != null) {
                    a aVar = (a) f5;
                    int i6 = i5 + 1;
                    j6 = j10;
                    cVarArr2[i5] = aVar.f60323d;
                    a0.h(objArr, M, j0Var);
                    a0.h(objArr, j11, aVar.f60322c);
                    j7 = 1;
                    j11++;
                    if (i6 >= i4) {
                        break;
                    }
                    i5 = i6;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                }
                M += j7;
                j8 = j5;
                j10 = j6;
            }
            M = j11;
        } else {
            j5 = j8;
            j6 = j10;
        }
        int i7 = (int) (M - N);
        long j12 = p() == 0 ? M : j5;
        long max = Math.max(this.f60313f, M - Math.min(this.f60317j, i7));
        if (this.f60318k == 0 && max < j6) {
            Object[] objArr2 = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr2);
            f4 = a0.f(objArr2, max);
            if (kotlin.jvm.internal.f0.g(f4, a0.f59989a)) {
                M++;
                max++;
            }
        }
        X(max, j12, M, j6);
        E();
        return (cVarArr2.length == 0) ^ true ? L(cVarArr2) : cVarArr2;
    }

    public final long Z() {
        long j4 = this.f60313f;
        if (j4 < this.f60314g) {
            this.f60314g = j4;
        }
        return j4;
    }

    @Override // kotlinx.coroutines.flow.internal.o
    @NotNull
    public h<T> a(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return a0.e(this, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.s
    public boolean b(T t3) {
        int i4;
        boolean z3;
        kotlin.coroutines.c<f1>[] cVarArr = kotlinx.coroutines.flow.internal.b.f60129a;
        synchronized (this) {
            if (T(t3)) {
                cVarArr = L(cVarArr);
                z3 = true;
            } else {
                z3 = false;
            }
        }
        for (kotlin.coroutines.c<f1> cVar : cVarArr) {
            if (cVar != null) {
                f1 f1Var = f1.f55527a;
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m119constructorimpl(f1Var));
            }
        }
        return z3;
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> d() {
        Object f4;
        List<T> F;
        synchronized (this) {
            int Q = Q();
            if (Q == 0) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            ArrayList arrayList = new ArrayList(Q);
            Object[] objArr = this.f60312e;
            kotlin.jvm.internal.f0.m(objArr);
            for (int i4 = 0; i4 < Q; i4++) {
                f4 = a0.f(objArr, this.f60313f + i4);
                arrayList.add(f4);
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
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r10) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.y.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        if (b(t3)) {
            return f1.f55527a;
        }
        Object J = J(t3, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return J == h4 ? J : f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.s
    public void f() {
        synchronized (this) {
            X(M(), this.f60314g, M(), P());
            f1 f1Var = f1.f55527a;
        }
    }
}
