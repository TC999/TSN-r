package kotlinx.coroutines.flow;

import cn.jpush.android.api.InAppSlotParams;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StateFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u00106\u001a\u00020\u0007\u00a2\u0006\u0004\b7\u00100J!\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014\u00a2\u0006\u0004\b!\u0010\"J-\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&H\u0016\u00a2\u0006\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010+R*\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008V@VX\u0096\u000e\u00a2\u0006\u0012\u0012\u0004\b1\u0010\u0017\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lkotlinx/coroutines/flow/i0;", "T", "Lkotlinx/coroutines/flow/internal/a;", "Lkotlinx/coroutines/flow/k0;", "Lkotlinx/coroutines/flow/t;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", "", "expectedState", "newState", "", "v", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", "value", "b", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "()V", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "s", "()Lkotlinx/coroutines/flow/k0;", "", "size", "", "t", "(I)[Lkotlinx/coroutines/flow/k0;", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/h;", "I", InAppSlotParams.SLOT_KEY.SEQ, "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "", "d", "()Ljava/util/List;", "replayCache", "initialState", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class i0<T> extends kotlinx.coroutines.flow.internal.a<k0> implements t<T>, c<T>, kotlinx.coroutines.flow.internal.o<T> {
    private volatile Object _state;

    /* renamed from: e  reason: collision with root package name */
    private int f60023e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: StateFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "collect"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD}, m = "collect", n = {"this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "oldState", "newState", "this", "collector", InAppSlotParams.SLOT_KEY.SLOT, "collectorJob", "oldState", "newState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f60024a;

        /* renamed from: b  reason: collision with root package name */
        int f60025b;

        /* renamed from: d  reason: collision with root package name */
        Object f60027d;

        /* renamed from: e  reason: collision with root package name */
        Object f60028e;

        /* renamed from: f  reason: collision with root package name */
        Object f60029f;

        /* renamed from: g  reason: collision with root package name */
        Object f60030g;

        /* renamed from: h  reason: collision with root package name */
        Object f60031h;

        /* renamed from: i  reason: collision with root package name */
        Object f60032i;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60024a = obj;
            this.f60025b |= Integer.MIN_VALUE;
            return i0.this.e(null, this);
        }
    }

    public i0(@NotNull Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void u() {
    }

    private final boolean v(Object obj, Object obj2) {
        int i4;
        k0[] q3;
        q();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && (!kotlin.jvm.internal.f0.g(obj3, obj))) {
                return false;
            }
            if (kotlin.jvm.internal.f0.g(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i5 = this.f60023e;
            if ((i5 & 1) == 0) {
                int i6 = i5 + 1;
                this.f60023e = i6;
                k0[] q4 = q();
                f1 f1Var = f1.f55527a;
                while (true) {
                    if (q4 != null) {
                        for (k0 k0Var : q4) {
                            if (k0Var != null) {
                                k0Var.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i4 = this.f60023e;
                        if (i4 == i6) {
                            this.f60023e = i6 + 1;
                            return true;
                        }
                        q3 = q();
                        f1 f1Var2 = f1.f55527a;
                    }
                    q4 = q3;
                    i6 = i4;
                }
            } else {
                this.f60023e = i5 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.o
    @NotNull
    public h<T> a(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return j0.d(this, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.s
    public boolean b(T t3) {
        setValue(t3);
        return true;
    }

    @Override // kotlinx.coroutines.flow.t
    public boolean compareAndSet(T t3, T t4) {
        if (t3 == null) {
            t3 = (T) kotlinx.coroutines.flow.internal.r.f60167a;
        }
        if (t4 == null) {
            t4 = (T) kotlinx.coroutines.flow.internal.r.f60167a;
        }
        return v(t3, t4);
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> d() {
        List<T> l4;
        l4 = kotlin.collections.x.l(getValue());
        return l4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
        if ((!kotlin.jvm.internal.f0.g(r12, r13)) != false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:49:0x00d4, B:51:0x00da, B:40:0x00b6, B:44:0x00bd, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:59:0x0024 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d8 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00ec -> B:34:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super T> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r13) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.i0.e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        setValue(t3);
        return f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.s
    public void f() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.t, kotlinx.coroutines.flow.h0
    public T getValue() {
        kotlinx.coroutines.internal.j0 j0Var = kotlinx.coroutines.flow.internal.r.f60167a;
        T t3 = (T) this._state;
        if (t3 == j0Var) {
            return null;
        }
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: s */
    public k0 l() {
        return new k0();
    }

    @Override // kotlinx.coroutines.flow.t
    public void setValue(T t3) {
        if (t3 == null) {
            t3 = (T) kotlinx.coroutines.flow.internal.r.f60167a;
        }
        v(null, t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    @NotNull
    /* renamed from: t */
    public k0[] m(int i4) {
        return new k0[i4];
    }
}
