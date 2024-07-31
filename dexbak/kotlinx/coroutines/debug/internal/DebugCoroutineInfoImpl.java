package kotlinx.coroutines.debug.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.sequences.AbstractC14514o;
import kotlin.sequences.C14516q;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010&\u001a\u00020$¢\u0006\u0004\b2\u00103J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J'\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0082Pø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0016\u0010\"R\u0014\u0010&\u001a\u00020$8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0013\u0010)\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u001a\u0010*R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b \u0010,R(\u00101\u001a\u0004\u0018\u00010\u00072\b\u0010-\u001a\u0004\u0018\u00010\u00078@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010.\"\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, m12616d2 = {"Lkotlinx/coroutines/debug/internal/d;", "", "", "Ljava/lang/StackTraceElement;", "a", "f", "Lkotlin/sequences/o;", "Lkotlin/coroutines/jvm/internal/c;", "frame", "Lkotlin/f1;", "i", "(Lkotlin/sequences/o;Lkotlin/coroutines/jvm/internal/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "state", "Lkotlin/coroutines/c;", "h", "(Ljava/lang/String;Lkotlin/coroutines/c;)V", "toString", "Ljava/lang/ref/WeakReference;", "Lkotlin/coroutines/f;", "Ljava/lang/ref/WeakReference;", "_context", "b", "Ljava/lang/String;", "_state", "Ljava/lang/Thread;", "c", "Ljava/lang/Thread;", "lastObservedThread", "d", "_lastObservedFrame", "Lkotlinx/coroutines/debug/internal/j;", "e", "Lkotlinx/coroutines/debug/internal/j;", "()Lkotlinx/coroutines/debug/internal/j;", "creationStackBottom", "", "J", "sequenceNumber", "getContext", "()Lkotlin/coroutines/f;", "context", "()Ljava/util/List;", "creationStackTrace", "()Ljava/lang/String;", DomainCampaignEx.LOOPBACK_VALUE, "()Lkotlin/coroutines/jvm/internal/c;", "g", "(Lkotlin/coroutines/jvm/internal/c;)V", "lastObservedFrame", "<init>", "(Lkotlin/coroutines/f;Lkotlinx/coroutines/debug/internal/j;J)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.debug.internal.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DebugCoroutineInfoImpl {

    /* renamed from: a */
    private final WeakReference<CoroutineContext> f42236a;

    /* renamed from: b */
    private String f42237b = C14762e.f42254a;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: c */
    public Thread f42238c;

    /* renamed from: d */
    private WeakReference<CoroutineStackFrame> f42239d;
    @Nullable

    /* renamed from: e */
    private final StackTraceFrame f42240e;
    @JvmPlatformAnnotations

    /* renamed from: f */
    public final long f42241f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Lkotlin/sequences/o;", "Ljava/lang/StackTraceElement;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", m8638f = "DebugCoroutineInfoImpl.kt", m8637i = {0}, m8636l = {75}, m8635m = "invokeSuspend", m8634n = {"$this$sequence"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.debug.internal.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14760a extends RestrictedSuspendLambda implements InterfaceC15284p<AbstractC14514o<? super StackTraceElement>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private AbstractC14514o f42242a;

        /* renamed from: b */
        Object f42243b;

        /* renamed from: c */
        int f42244c;

        /* renamed from: e */
        final /* synthetic */ StackTraceFrame f42246e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14760a(StackTraceFrame stackTraceFrame, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42246e = stackTraceFrame;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14760a c14760a = new C14760a(this.f42246e, interfaceC14268c);
            c14760a.f42242a = (AbstractC14514o) obj;
            return c14760a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(AbstractC14514o<? super StackTraceElement> abstractC14514o, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14760a) create(abstractC14514o, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42244c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                AbstractC14514o<? super StackTraceElement> abstractC14514o = this.f42242a;
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = DebugCoroutineInfoImpl.this;
                CoroutineStackFrame callerFrame = this.f42246e.getCallerFrame();
                this.f42243b = abstractC14514o;
                this.f42244c = 1;
                if (debugCoroutineInfoImpl.m5099i(abstractC14514o, callerFrame, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                AbstractC14514o abstractC14514o2 = (AbstractC14514o) this.f42243b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugCoroutineInfoImpl.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082P"}, m12616d2 = {"Lkotlin/sequences/o;", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/c;", "frame", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "yieldFrames"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", m8638f = "DebugCoroutineInfoImpl.kt", m8637i = {0, 0, 0, 0}, m8636l = {80}, m8635m = "yieldFrames", m8634n = {"this", "$this$yieldFrames", "frame", "it"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.debug.internal.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14761b extends RestrictedContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42247a;

        /* renamed from: b */
        int f42248b;

        /* renamed from: d */
        Object f42250d;

        /* renamed from: e */
        Object f42251e;

        /* renamed from: f */
        Object f42252f;

        /* renamed from: g */
        Object f42253g;

        C14761b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42247a = obj;
            this.f42248b |= Integer.MIN_VALUE;
            return DebugCoroutineInfoImpl.this.m5099i(null, null, this);
        }
    }

    public DebugCoroutineInfoImpl(@Nullable CoroutineContext coroutineContext, @Nullable StackTraceFrame stackTraceFrame, long j) {
        this.f42240e = stackTraceFrame;
        this.f42241f = j;
        this.f42236a = new WeakReference<>(coroutineContext);
    }

    /* renamed from: a */
    private final List<StackTraceElement> m5107a() {
        List<StackTraceElement> m12478E;
        Sequence m6993e;
        List<StackTraceElement> m7189V2;
        StackTraceFrame stackTraceFrame = this.f42240e;
        if (stackTraceFrame != null) {
            m6993e = C14516q.m6993e(new C14760a(stackTraceFrame, null));
            m7189V2 = _Sequences.m7189V2(m6993e);
            return m7189V2;
        }
        m12478E = CollectionsKt__CollectionsKt.m12478E();
        return m12478E;
    }

    @Nullable
    /* renamed from: b */
    public final StackTraceFrame m5106b() {
        return this.f42240e;
    }

    @NotNull
    /* renamed from: c */
    public final List<StackTraceElement> m5105c() {
        return m5107a();
    }

    @Nullable
    /* renamed from: d */
    public final CoroutineStackFrame m5104d() {
        WeakReference<CoroutineStackFrame> weakReference = this.f42239d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    /* renamed from: e */
    public final String m5103e() {
        return this.f42237b;
    }

    @NotNull
    /* renamed from: f */
    public final List<StackTraceElement> m5102f() {
        List<StackTraceElement> m12478E;
        CoroutineStackFrame m5104d = m5104d();
        if (m5104d != null) {
            ArrayList arrayList = new ArrayList();
            while (m5104d != null) {
                StackTraceElement stackTraceElement = m5104d.getStackTraceElement();
                if (stackTraceElement != null) {
                    arrayList.add(stackTraceElement);
                }
                m5104d = m5104d.getCallerFrame();
            }
            return arrayList;
        }
        m12478E = CollectionsKt__CollectionsKt.m12478E();
        return m12478E;
    }

    /* renamed from: g */
    public final void m5101g(@Nullable CoroutineStackFrame coroutineStackFrame) {
        this.f42239d = coroutineStackFrame != null ? new WeakReference<>(coroutineStackFrame) : null;
    }

    @Nullable
    public final CoroutineContext getContext() {
        return this.f42236a.get();
    }

    /* renamed from: h */
    public final void m5100h(@NotNull String str, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        if (C14342f0.m8193g(this.f42237b, str) && C14342f0.m8193g(str, C14762e.f42256c) && m5104d() != null) {
            return;
        }
        this.f42237b = str;
        if (!(interfaceC14268c instanceof CoroutineStackFrame)) {
            interfaceC14268c = null;
        }
        m5101g((CoroutineStackFrame) interfaceC14268c);
        this.f42238c = C14342f0.m8193g(str, C14762e.f42255b) ? Thread.currentThread() : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004e -> B:25:0x0067). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0061 -> B:24:0x0064). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ java.lang.Object m5099i(@org.jetbrains.annotations.NotNull kotlin.sequences.AbstractC14514o<? super java.lang.StackTraceElement> r6, @org.jetbrains.annotations.Nullable kotlin.coroutines.jvm.internal.CoroutineStackFrame r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.C14761b
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.debug.internal.d$b r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.C14761b) r0
            int r1 = r0.f42248b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42248b = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.d$b r0 = new kotlinx.coroutines.debug.internal.d$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f42247a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42248b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r6 = r0.f42253g
            java.lang.StackTraceElement r6 = (java.lang.StackTraceElement) r6
            java.lang.Object r6 = r0.f42252f
            kotlin.coroutines.jvm.internal.c r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6
            java.lang.Object r7 = r0.f42251e
            kotlin.sequences.o r7 = (kotlin.sequences.AbstractC14514o) r7
            java.lang.Object r2 = r0.f42250d
            kotlinx.coroutines.debug.internal.d r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.C14294d0.m8596n(r8)
            goto L64
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.C14294d0.m8596n(r8)
            r2 = r5
        L45:
            if (r7 != 0) goto L4a
            kotlin.f1 r6 = kotlin.Unit.f41048a
            return r6
        L4a:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L67
            r0.f42250d = r2
            r0.f42251e = r6
            r0.f42252f = r7
            r0.f42253g = r8
            r0.f42248b = r3
            java.lang.Object r8 = r6.mo7018c(r8, r0)
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
            kotlin.f1 r6 = kotlin.Unit.f41048a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.m5099i(kotlin.sequences.o, kotlin.coroutines.jvm.internal.c, kotlin.coroutines.c):java.lang.Object");
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + m5103e() + ",context=" + getContext() + ')';
    }
}
