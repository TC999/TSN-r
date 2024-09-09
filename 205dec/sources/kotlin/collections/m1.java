package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SlidingWindow.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010(\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u001aD\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001aH\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\f\"\u0004\b\u0000\u0010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000\u00a8\u0006\u000f"}, d2 = {"", "size", "step", "Lkotlin/f1;", "a", "T", "Lkotlin/sequences/m;", "", "partialWindows", "reuseBuffer", "", "c", "", "iterator", "b", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlin/sequences/o;", "", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends RestrictedSuspendLambda implements d2.p<kotlin.sequences.o<? super List<? extends T>>, kotlin.coroutines.c<? super kotlin.f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f55359a;

        /* renamed from: b  reason: collision with root package name */
        Object f55360b;

        /* renamed from: c  reason: collision with root package name */
        int f55361c;

        /* renamed from: d  reason: collision with root package name */
        int f55362d;

        /* renamed from: e  reason: collision with root package name */
        private /* synthetic */ Object f55363e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f55364f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f55365g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Iterator<T> f55366h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f55367i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f55368j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(int i4, int i5, Iterator<? extends T> it, boolean z3, boolean z4, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f55364f = i4;
            this.f55365g = i5;
            this.f55366h = it;
            this.f55367i = z3;
            this.f55368j = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f55364f, this.f55365g, this.f55366h, this.f55367i, this.f55368j, cVar);
            aVar.f55363e = obj;
            return aVar;
        }

        @Override // d2.p
        @Nullable
        /* renamed from: e */
        public final Object invoke(@NotNull kotlin.sequences.o<? super List<? extends T>> oVar, @Nullable kotlin.coroutines.c<? super kotlin.f1> cVar) {
            return ((a) create(oVar, cVar)).invokeSuspend(kotlin.f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00db A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0153  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a5 -> B:29:0x00a8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x011c -> B:58:0x011f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x014a -> B:71:0x014d). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.m1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> implements kotlin.sequences.m<List<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f55369a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f55370b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f55371c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f55372d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f55373e;

        public b(kotlin.sequences.m mVar, int i4, int i5, boolean z3, boolean z4) {
            this.f55369a = mVar;
            this.f55370b = i4;
            this.f55371c = i5;
            this.f55372d = z3;
            this.f55373e = z4;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<List<? extends T>> iterator() {
            return m1.b(this.f55369a.iterator(), this.f55370b, this.f55371c, this.f55372d, this.f55373e);
        }
    }

    public static final void a(int i4, int i5) {
        String str;
        if (i4 > 0 && i5 > 0) {
            return;
        }
        if (i4 != i5) {
            str = "Both size " + i4 + " and step " + i5 + " must be greater than zero.";
        } else {
            str = "size " + i4 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @NotNull
    public static final <T> Iterator<List<T>> b(@NotNull Iterator<? extends T> iterator, int i4, int i5, boolean z3, boolean z4) {
        Iterator<List<T>> d4;
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        if (iterator.hasNext()) {
            d4 = kotlin.sequences.q.d(new a(i4, i5, iterator, z4, z3, null));
            return d4;
        }
        return h0.f55332a;
    }

    @NotNull
    public static final <T> kotlin.sequences.m<List<T>> c(@NotNull kotlin.sequences.m<? extends T> mVar, int i4, int i5, boolean z3, boolean z4) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        a(i4, i5);
        return new b(mVar, i4, i5, z3, z4);
    }
}
