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
/* compiled from: Iterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lkotlin/collections/l1;", "", "", "a", "()Ljava/lang/Short;", "d", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class l1 implements Iterator<Short>, e2.a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlin/sequences/o;", "", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a<T> extends RestrictedSuspendLambda implements l1.p<kotlin.sequences.o<? super List<? extends T>>, kotlin.coroutines.c<? super kotlin.f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ Object f55344a;

        /* renamed from: b  reason: collision with root package name */
        Object f55345b;

        /* renamed from: c  reason: collision with root package name */
        Object f55346c;

        /* renamed from: d  reason: collision with root package name */
        int f55347d;

        /* renamed from: e  reason: collision with root package name */
        int f55348e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f55349f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f55350g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Iterator f55351h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ boolean f55352i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ boolean f55353j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, int i5, Iterator it, boolean z3, boolean z4, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f55349f = i4;
            this.f55350g = i5;
            this.f55351h = it;
            this.f55352i = z3;
            this.f55353j = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> completion) {
            kotlin.jvm.internal.f0.p(completion, "completion");
            a aVar = new a(this.f55349f, this.f55350g, this.f55351h, this.f55352i, this.f55353j, completion);
            aVar.f55344a = obj;
            return aVar;
        }

        @Override // l1.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super kotlin.f1> cVar) {
            return ((a) create(obj, cVar)).invokeSuspend(kotlin.f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.l1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"kotlin/sequences/s$a", "Lkotlin/sequences/m;", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<T> implements kotlin.sequences.m<List<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.sequences.m f55354a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f55355b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f55356c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f55357d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f55358e;

        public b(kotlin.sequences.m mVar, int i4, int i5, boolean z3, boolean z4) {
            this.f55354a = mVar;
            this.f55355b = i4;
            this.f55356c = i5;
            this.f55357d = z3;
            this.f55358e = z4;
        }

        @Override // kotlin.sequences.m
        @NotNull
        public Iterator<List<? extends T>> iterator() {
            return l1.b(this.f55354a.iterator(), this.f55355b, this.f55356c, this.f55357d, this.f55358e);
        }
    }

    @NotNull
    public final Short a() {
        return Short.valueOf(d());
    }

    public abstract short d();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(d());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
