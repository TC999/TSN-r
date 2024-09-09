package kotlinx.coroutines.flow;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channels.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007\u001a0\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007\u001a&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/channels/d0;", "channel", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/channels/d0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "consume", "f", "(Lkotlinx/coroutines/flow/i;Lkotlinx/coroutines/channels/d0;ZLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/h;", "h", "d", "Lkotlinx/coroutines/channels/j;", "a", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "b", "g", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class l {

    /* compiled from: SafeCollector.common.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements h<T> {

        /* renamed from: a */
        final /* synthetic */ kotlinx.coroutines.channels.j f60186a;

        public a(kotlinx.coroutines.channels.j jVar) {
            this.f60186a = jVar;
        }

        @Override // kotlinx.coroutines.flow.h
        @Nullable
        public Object e(@NotNull i iVar, @NotNull kotlin.coroutines.c cVar) {
            Object h4;
            Object q02 = k.q0(iVar, this.f60186a.t(), cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            return q02 == h4 ? q02 : f1.f55527a;
        }
    }

    /* compiled from: Channels.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/channels/d0;", "channel", "", "consume", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "emitAllImpl"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {50, 61}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "cause", "$this$run", "$this$emitAllImpl", "channel", "consume", "cause", "result"}, s = {"L$0", "L$1", "Z$0", "L$2", "L$3", "L$0", "L$1", "Z$0", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f60187a;

        /* renamed from: b */
        int f60188b;

        /* renamed from: c */
        Object f60189c;

        /* renamed from: d */
        Object f60190d;

        /* renamed from: e */
        Object f60191e;

        /* renamed from: f */
        Object f60192f;

        /* renamed from: g */
        boolean f60193g;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f60187a = obj;
            this.f60188b |= Integer.MIN_VALUE;
            return l.f(null, null, false, this);
        }
    }

    @FlowPreview
    @NotNull
    public static final <T> h<T> a(@NotNull kotlinx.coroutines.channels.j<T> jVar) {
        return new a(jVar);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use shareIn operator and the resulting SharedFlow as a replacement for BroadcastChannel", replaceWith = @ReplaceWith(expression = "shareIn(scope, 0, SharingStarted.Lazily)", imports = {}))
    @NotNull
    public static final <T> kotlinx.coroutines.channels.j<T> b(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull CoroutineStart coroutineStart) {
        return kotlinx.coroutines.flow.internal.f.b(hVar).h(q0Var, coroutineStart);
    }

    public static /* synthetic */ kotlinx.coroutines.channels.j c(h hVar, q0 q0Var, CoroutineStart coroutineStart, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return k.n(hVar, q0Var, coroutineStart);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var) {
        return new e(d0Var, true, null, 0, null, 28, null);
    }

    @Nullable
    public static final <T> Object e(@NotNull i<? super T> iVar, @NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object f4 = f(iVar, d0Var, true, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return f4 == h4 ? f4 : f1.f55527a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0083 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:67:0x0036, B:81:0x007d, B:83:0x0083, B:89:0x0091, B:90:0x0092, B:72:0x0059), top: B:104:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0092 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:67:0x0036, B:81:0x007d, B:83:0x0083, B:89:0x0091, B:90:0x0092, B:72:0x0059), top: B:104:0x0022 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.channels.d0] */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlinx.coroutines.channels.d0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x00a6 -> B:68:0x0039). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object f(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super T> r8, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.d0<? extends T> r9, boolean r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.flow.l.b
            if (r0 == 0) goto L13
            r0 = r11
            kotlinx.coroutines.flow.l$b r0 = (kotlinx.coroutines.flow.l.b) r0
            int r1 = r0.f60188b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f60188b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l$b r0 = new kotlinx.coroutines.flow.l$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f60187a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f60188b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5f
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r8 = r0.f60191e
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.f60193g
            java.lang.Object r10 = r0.f60190d
            kotlinx.coroutines.channels.d0 r10 = (kotlinx.coroutines.channels.d0) r10
            java.lang.Object r2 = r0.f60189c
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2
            kotlin.d0.n(r11)     // Catch: java.lang.Throwable -> L5d
        L39:
            r11 = r8
            r8 = r2
            r6 = r10
            r10 = r9
            r9 = r6
            goto L63
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            java.lang.Object r8 = r0.f60192f
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) r8
            java.lang.Object r8 = r0.f60191e
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            boolean r9 = r0.f60193g
            java.lang.Object r10 = r0.f60190d
            kotlinx.coroutines.channels.d0 r10 = (kotlinx.coroutines.channels.d0) r10
            java.lang.Object r2 = r0.f60189c
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.i) r2
            kotlin.d0.n(r11)     // Catch: java.lang.Throwable -> L5d
            goto L7d
        L5d:
            r8 = move-exception
            goto Lad
        L5f:
            kotlin.d0.n(r11)
            r11 = 0
        L63:
            r0.f60189c = r8     // Catch: java.lang.Throwable -> La9
            r0.f60190d = r9     // Catch: java.lang.Throwable -> La9
            r0.f60193g = r10     // Catch: java.lang.Throwable -> La9
            r0.f60191e = r11     // Catch: java.lang.Throwable -> La9
            r0.f60192f = r8     // Catch: java.lang.Throwable -> La9
            r0.f60188b = r4     // Catch: java.lang.Throwable -> La9
            java.lang.Object r2 = r9.w(r0)     // Catch: java.lang.Throwable -> La9
            if (r2 != r1) goto L76
            return r1
        L76:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
            r7 = r10
            r10 = r9
            r9 = r7
        L7d:
            boolean r5 = kotlinx.coroutines.channels.m0.l(r11)     // Catch: java.lang.Throwable -> L5d
            if (r5 == 0) goto L92
            java.lang.Throwable r11 = kotlinx.coroutines.channels.m0.f(r11)     // Catch: java.lang.Throwable -> L5d
            if (r11 != 0) goto L91
            if (r9 == 0) goto L8e
            kotlinx.coroutines.channels.r.r(r10, r8)
        L8e:
            kotlin.f1 r8 = kotlin.f1.f55527a
            return r8
        L91:
            throw r11     // Catch: java.lang.Throwable -> L5d
        L92:
            java.lang.Object r5 = kotlinx.coroutines.channels.m0.h(r11)     // Catch: java.lang.Throwable -> L5d
            r0.f60189c = r2     // Catch: java.lang.Throwable -> L5d
            r0.f60190d = r10     // Catch: java.lang.Throwable -> L5d
            r0.f60193g = r9     // Catch: java.lang.Throwable -> L5d
            r0.f60191e = r8     // Catch: java.lang.Throwable -> L5d
            r0.f60192f = r11     // Catch: java.lang.Throwable -> L5d
            r0.f60188b = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r11 = r2.emit(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r11 != r1) goto L39
            return r1
        La9:
            r8 = move-exception
            r6 = r10
            r10 = r9
            r9 = r6
        Lad:
            throw r8     // Catch: java.lang.Throwable -> Lae
        Lae:
            r11 = move-exception
            if (r9 == 0) goto Lb4
            kotlinx.coroutines.channels.r.r(r10, r8)
        Lb4:
            goto Lb6
        Lb5:
            throw r11
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.l.f(kotlinx.coroutines.flow.i, kotlinx.coroutines.channels.d0, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    @FlowPreview
    @NotNull
    public static final <T> kotlinx.coroutines.channels.d0<T> g(@NotNull h<? extends T> hVar, @NotNull q0 q0Var) {
        return kotlinx.coroutines.flow.internal.f.b(hVar).o(q0Var);
    }

    @NotNull
    public static final <T> h<T> h(@NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var) {
        return new e(d0Var, false, null, 0, null, 28, null);
    }
}
