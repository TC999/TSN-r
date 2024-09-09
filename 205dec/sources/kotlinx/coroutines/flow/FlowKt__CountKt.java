package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Count.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "", "b", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "a", "(Lkotlinx/coroutines/flow/h;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class FlowKt__CountKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Collect.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements i<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f59665a;

        public a(Ref.IntRef intRef) {
            this.f59665a = intRef;
        }

        @Override // kotlinx.coroutines.flow.i
        @Nullable
        public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
            this.f59665a.element++;
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Count.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "", "continuation", "", "count"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0, 0, 0}, l = {39}, m = "count", n = {"$this$count", "i", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59666a;

        /* renamed from: b  reason: collision with root package name */
        int f59667b;

        /* renamed from: c  reason: collision with root package name */
        Object f59668c;

        /* renamed from: d  reason: collision with root package name */
        Object f59669d;

        /* renamed from: e  reason: collision with root package name */
        Object f59670e;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59666a = obj;
            this.f59667b |= Integer.MIN_VALUE;
            return k.e0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Count.kt */
    @Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0086@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "", "continuation", "count"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0, 0, 0, 0}, l = {42}, m = "count", n = {"$this$count", "predicate", "i", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59671a;

        /* renamed from: b  reason: collision with root package name */
        int f59672b;

        /* renamed from: c  reason: collision with root package name */
        Object f59673c;

        /* renamed from: d  reason: collision with root package name */
        Object f59674d;

        /* renamed from: e  reason: collision with root package name */
        Object f59675e;

        /* renamed from: f  reason: collision with root package name */
        Object f59676f;

        c(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59671a = obj;
            this.f59672b |= Integer.MIN_VALUE;
            return k.d0(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull d2.p<? super T, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt.c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$c r0 = (kotlinx.coroutines.flow.FlowKt__CountKt.c) r0
            int r1 = r0.f59672b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59672b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$c r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59671a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59672b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.f59676f
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.f59675e
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.f59674d
            d2.p r5 = (d2.p) r5
            java.lang.Object r5 = r0.f59673c
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            kotlin.d0.n(r6)
            goto L63
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.d0.n(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2
            r2.<init>(r5, r6)
            r0.f59673c = r4
            r0.f59674d = r5
            r0.f59675e = r6
            r0.f59676f = r4
            r0.f59672b = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L62
            return r1
        L62:
            r4 = r6
        L63:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.a(kotlinx.coroutines.flow.h, d2.p, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__CountKt.b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$b r0 = (kotlinx.coroutines.flow.FlowKt__CountKt.b) r0
            int r1 = r0.f59667b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59667b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$b r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f59666a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59667b
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f59670e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.h) r4
            java.lang.Object r4 = r0.f59669d
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r0 = r0.f59668c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.h) r0
            kotlin.d0.n(r5)
            goto L5d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.d0.n(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$a r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$a
            r2.<init>(r5)
            r0.f59668c = r4
            r0.f59669d = r5
            r0.f59670e = r4
            r0.f59667b = r3
            java.lang.Object r4 = r4.e(r2, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            r4 = r5
        L5d:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt.b(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }
}
