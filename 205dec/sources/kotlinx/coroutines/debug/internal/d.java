package kotlinx.coroutines.debug.internal;

import d2.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.m;
import kotlin.sequences.o;
import kotlin.sequences.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugCoroutineInfoImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010&\u001a\u00020$\u00a2\u0006\u0004\b2\u00103J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J'\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082P\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\"R\u0014\u0010&\u001a\u00020$8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010\u00138F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010*R\u0011\u0010\r\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010,R(\u00101\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00078@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010.\"\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"Lkotlinx/coroutines/debug/internal/d;", "", "", "Ljava/lang/StackTraceElement;", "a", "f", "Lkotlin/sequences/o;", "Lkotlin/coroutines/jvm/internal/c;", "frame", "Lkotlin/f1;", "i", "(Lkotlin/sequences/o;Lkotlin/coroutines/jvm/internal/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "state", "Lkotlin/coroutines/c;", "h", "(Ljava/lang/String;Lkotlin/coroutines/c;)V", "toString", "Ljava/lang/ref/WeakReference;", "Lkotlin/coroutines/f;", "Ljava/lang/ref/WeakReference;", "_context", "b", "Ljava/lang/String;", "_state", "Ljava/lang/Thread;", "c", "Ljava/lang/Thread;", "lastObservedThread", "d", "_lastObservedFrame", "Lkotlinx/coroutines/debug/internal/j;", "e", "Lkotlinx/coroutines/debug/internal/j;", "()Lkotlinx/coroutines/debug/internal/j;", "creationStackBottom", "", "J", "sequenceNumber", "getContext", "()Lkotlin/coroutines/f;", "context", "()Ljava/util/List;", "creationStackTrace", "()Ljava/lang/String;", "value", "()Lkotlin/coroutines/jvm/internal/c;", "g", "(Lkotlin/coroutines/jvm/internal/c;)V", "lastObservedFrame", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/debug/internal/j;J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<kotlin.coroutines.f> f59581a;

    /* renamed from: b  reason: collision with root package name */
    private String f59582b = "CREATED";
    @JvmField
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Thread f59583c;

    /* renamed from: d  reason: collision with root package name */
    private WeakReference<kotlin.coroutines.jvm.internal.c> f59584d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final j f59585e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public final long f59586f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/o;", "Ljava/lang/StackTraceElement;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {0}, l = {75}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends RestrictedSuspendLambda implements p<o<? super StackTraceElement>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private o f59587a;

        /* renamed from: b  reason: collision with root package name */
        Object f59588b;

        /* renamed from: c  reason: collision with root package name */
        int f59589c;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ j f59591e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(j jVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59591e = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f59591e, cVar);
            aVar.f59587a = (o) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(o<? super StackTraceElement> oVar, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(oVar, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59589c;
            if (i4 == 0) {
                d0.n(obj);
                o<? super StackTraceElement> oVar = this.f59587a;
                d dVar = d.this;
                kotlin.coroutines.jvm.internal.c callerFrame = this.f59591e.getCallerFrame();
                this.f59588b = oVar;
                this.f59589c = 1;
                if (dVar.i(oVar, callerFrame, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                o oVar2 = (o) this.f59588b;
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082P"}, d2 = {"Lkotlin/sequences/o;", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/c;", "frame", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "yieldFrames"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0, 0}, l = {80}, m = "yieldFrames", n = {"this", "$this$yieldFrames", "frame", "it"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends RestrictedContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59592a;

        /* renamed from: b  reason: collision with root package name */
        int f59593b;

        /* renamed from: d  reason: collision with root package name */
        Object f59595d;

        /* renamed from: e  reason: collision with root package name */
        Object f59596e;

        /* renamed from: f  reason: collision with root package name */
        Object f59597f;

        /* renamed from: g  reason: collision with root package name */
        Object f59598g;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59592a = obj;
            this.f59593b |= Integer.MIN_VALUE;
            return d.this.i(null, null, this);
        }
    }

    public d(@Nullable kotlin.coroutines.f fVar, @Nullable j jVar, long j4) {
        this.f59585e = jVar;
        this.f59586f = j4;
        this.f59581a = new WeakReference<>(fVar);
    }

    private final List<StackTraceElement> a() {
        List<StackTraceElement> F;
        m e4;
        List<StackTraceElement> V2;
        j jVar = this.f59585e;
        if (jVar != null) {
            e4 = q.e(new a(jVar, null));
            V2 = SequencesKt___SequencesKt.V2(e4);
            return V2;
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Nullable
    public final j b() {
        return this.f59585e;
    }

    @NotNull
    public final List<StackTraceElement> c() {
        return a();
    }

    @Nullable
    public final kotlin.coroutines.jvm.internal.c d() {
        WeakReference<kotlin.coroutines.jvm.internal.c> weakReference = this.f59584d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final String e() {
        return this.f59582b;
    }

    @NotNull
    public final List<StackTraceElement> f() {
        List<StackTraceElement> F;
        kotlin.coroutines.jvm.internal.c d4 = d();
        if (d4 != null) {
            ArrayList arrayList = new ArrayList();
            while (d4 != null) {
                StackTraceElement stackTraceElement = d4.getStackTraceElement();
                if (stackTraceElement != null) {
                    arrayList.add(stackTraceElement);
                }
                d4 = d4.getCallerFrame();
            }
            return arrayList;
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    public final void g(@Nullable kotlin.coroutines.jvm.internal.c cVar) {
        this.f59584d = cVar != null ? new WeakReference<>(cVar) : null;
    }

    @Nullable
    public final kotlin.coroutines.f getContext() {
        return this.f59581a.get();
    }

    public final void h(@NotNull String str, @NotNull kotlin.coroutines.c<?> cVar) {
        if (f0.g(this.f59582b, str) && f0.g(str, "SUSPENDED") && d() != null) {
            return;
        }
        this.f59582b = str;
        if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
            cVar = null;
        }
        g((kotlin.coroutines.jvm.internal.c) cVar);
        this.f59583c = f0.g(str, "RUNNING") ? Thread.currentThread() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004e -> B:25:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:24:0x0064). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ java.lang.Object i(@org.jetbrains.annotations.NotNull kotlin.sequences.o<? super java.lang.StackTraceElement> r6, @org.jetbrains.annotations.Nullable kotlin.coroutines.jvm.internal.c r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.d.b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.d$b r0 = (kotlinx.coroutines.debug.internal.d.b) r0
            int r1 = r0.f59593b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59593b = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.d$b r0 = new kotlinx.coroutines.debug.internal.d$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f59592a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59593b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.f59598g
            java.lang.StackTraceElement r6 = (java.lang.StackTraceElement) r6
            java.lang.Object r6 = r0.f59597f
            kotlin.coroutines.jvm.internal.c r6 = (kotlin.coroutines.jvm.internal.c) r6
            java.lang.Object r7 = r0.f59596e
            kotlin.sequences.o r7 = (kotlin.sequences.o) r7
            java.lang.Object r2 = r0.f59595d
            kotlinx.coroutines.debug.internal.d r2 = (kotlinx.coroutines.debug.internal.d) r2
            kotlin.d0.n(r8)
            goto L64
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.d0.n(r8)
            r2 = r5
        L45:
            if (r7 != 0) goto L4a
            kotlin.f1 r6 = kotlin.f1.f55527a
            return r6
        L4a:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L67
            r0.f59595d = r2
            r0.f59596e = r6
            r0.f59597f = r7
            r0.f59598g = r8
            r0.f59593b = r3
            java.lang.Object r8 = r6.e(r8, r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            r4 = r7
            r7 = r6
            r6 = r4
        L64:
            r4 = r7
            r7 = r6
            r6 = r4
        L67:
            kotlin.coroutines.jvm.internal.c r7 = r7.getCallerFrame()
            if (r7 == 0) goto L6e
            goto L45
        L6e:
            kotlin.f1 r6 = kotlin.f1.f55527a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.d.i(kotlin.sequences.o, kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c):java.lang.Object");
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + e() + ",context=" + getContext() + ')';
    }
}
