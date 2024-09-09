package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SharingStarted.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/g0;", "Lkotlinx/coroutines/flow/d0;", "Lkotlinx/coroutines/flow/h0;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "", "toString", "", "other", "", "equals", "hashCode", "", "b", "J", "stopTimeout", "c", "replayExpiration", "<init>", "(JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g0 implements d0 {

    /* renamed from: b  reason: collision with root package name */
    private final long f60013b;

    /* renamed from: c  reason: collision with root package name */
    private final long f60014c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SharingStarted.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {181, 183, 185, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 188}, m = "invokeSuspend", n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends SuspendLambda implements d2.q<i<? super SharingCommand>, Integer, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private i f60015a;

        /* renamed from: b  reason: collision with root package name */
        private int f60016b;

        /* renamed from: c  reason: collision with root package name */
        Object f60017c;

        /* renamed from: d  reason: collision with root package name */
        int f60018d;

        /* renamed from: e  reason: collision with root package name */
        int f60019e;

        a(kotlin.coroutines.c cVar) {
            super(3, cVar);
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull i<? super SharingCommand> iVar, int i4, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            a aVar = new a(cVar);
            aVar.f60015a = iVar;
            aVar.f60016b = i4;
            return aVar;
        }

        @Override // d2.q
        public final Object invoke(i<? super SharingCommand> iVar, Integer num, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) e(iVar, num.intValue(), cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r10.f60019e
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L47
                if (r1 == r6) goto L3f
                if (r1 == r5) goto L35
                if (r1 == r4) goto L2b
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                goto L3f
            L18:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L20:
                int r1 = r10.f60018d
                java.lang.Object r3 = r10.f60017c
                kotlinx.coroutines.flow.i r3 = (kotlinx.coroutines.flow.i) r3
                kotlin.d0.n(r11)
                goto La3
            L2b:
                int r1 = r10.f60018d
                java.lang.Object r4 = r10.f60017c
                kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) r4
                kotlin.d0.n(r11)
                goto L8f
            L35:
                int r1 = r10.f60018d
                java.lang.Object r5 = r10.f60017c
                kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.i) r5
                kotlin.d0.n(r11)
                goto L73
            L3f:
                java.lang.Object r0 = r10.f60017c
                kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) r0
                kotlin.d0.n(r11)
                goto Lb3
            L47:
                kotlin.d0.n(r11)
                kotlinx.coroutines.flow.i r11 = r10.f60015a
                int r1 = r10.f60016b
                if (r1 <= 0) goto L5f
                kotlinx.coroutines.flow.SharingCommand r2 = kotlinx.coroutines.flow.SharingCommand.START
                r10.f60017c = r11
                r10.f60018d = r1
                r10.f60019e = r6
                java.lang.Object r11 = r11.emit(r2, r10)
                if (r11 != r0) goto Lb3
                return r0
            L5f:
                kotlinx.coroutines.flow.g0 r6 = kotlinx.coroutines.flow.g0.this
                long r6 = kotlinx.coroutines.flow.g0.c(r6)
                r10.f60017c = r11
                r10.f60018d = r1
                r10.f60019e = r5
                java.lang.Object r5 = kotlinx.coroutines.a1.b(r6, r10)
                if (r5 != r0) goto L72
                return r0
            L72:
                r5 = r11
            L73:
                kotlinx.coroutines.flow.g0 r11 = kotlinx.coroutines.flow.g0.this
                long r6 = kotlinx.coroutines.flow.g0.b(r11)
                r8 = 0
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 <= 0) goto La4
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
                r10.f60017c = r5
                r10.f60018d = r1
                r10.f60019e = r4
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto L8e
                return r0
            L8e:
                r4 = r5
            L8f:
                kotlinx.coroutines.flow.g0 r11 = kotlinx.coroutines.flow.g0.this
                long r5 = kotlinx.coroutines.flow.g0.b(r11)
                r10.f60017c = r4
                r10.f60018d = r1
                r10.f60019e = r3
                java.lang.Object r11 = kotlinx.coroutines.a1.b(r5, r10)
                if (r11 != r0) goto La2
                return r0
            La2:
                r3 = r4
            La3:
                r5 = r3
            La4:
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
                r10.f60017c = r5
                r10.f60018d = r1
                r10.f60019e = r2
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto Lb3
                return r0
            Lb3:
                kotlin.f1 r11 = kotlin.f1.f55527a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.g0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SharingStarted.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends SuspendLambda implements d2.p<SharingCommand, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private SharingCommand f60021a;

        /* renamed from: b  reason: collision with root package name */
        int f60022b;

        b(kotlin.coroutines.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(cVar);
            bVar.f60021a = (SharingCommand) obj;
            return bVar;
        }

        @Override // d2.p
        public final Object invoke(SharingCommand sharingCommand, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((b) create(sharingCommand, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f60022b == 0) {
                kotlin.d0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(this.f60021a != SharingCommand.START);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public g0(long j4, long j5) {
        this.f60013b = j4;
        this.f60014c = j5;
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j4 + " ms) cannot be negative").toString());
        }
        if (j5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j5 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.d0
    @NotNull
    public h<SharingCommand> a(@NotNull h0<Integer> h0Var) {
        return k.l0(k.p0(k.m2(h0Var, new a(null)), new b(null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (this.f60013b == g0Var.f60013b && this.f60014c == g0Var.f60014c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Long.valueOf(this.f60013b).hashCode() * 31) + Long.valueOf(this.f60014c).hashCode();
    }

    @NotNull
    public String toString() {
        List k4;
        List b4;
        String X2;
        k4 = kotlin.collections.x.k(2);
        if (this.f60013b > 0) {
            k4.add("stopTimeout=" + this.f60013b + "ms");
        }
        if (this.f60014c < Long.MAX_VALUE) {
            k4.add("replayExpiration=" + this.f60014c + "ms");
        }
        b4 = kotlin.collections.x.b(k4);
        StringBuilder sb = new StringBuilder();
        sb.append("SharingStarted.WhileSubscribed(");
        X2 = kotlin.collections.f0.X2(b4, null, null, null, 0, null, null, 63, null);
        sb.append(X2);
        sb.append(')');
        return sb.toString();
    }
}
