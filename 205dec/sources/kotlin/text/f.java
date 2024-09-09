package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Strings.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B[\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012:\u0010\u0015\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00130\u000f\u00a2\u0006\u0002\b\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lkotlin/text/f;", "Lkotlin/sequences/m;", "Lkotlin/ranges/k;", "", "iterator", "", "a", "Ljava/lang/CharSequence;", "input", "", "b", "I", "startIndex", "c", "limit", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "getNextMatch", "<init>", "(Ljava/lang/CharSequence;IILd2/p;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f implements kotlin.sequences.m<kotlin.ranges.k> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f58939a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58940b;

    /* renamed from: c  reason: collision with root package name */
    private final int f58941c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final d2.p<CharSequence, Integer, Pair<Integer, Integer>> f58942d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Strings.kt */
    @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u001e\u0010\r\u00a8\u0006 "}, d2 = {"kotlin/text/f$a", "", "Lkotlin/ranges/k;", "Lkotlin/f1;", "a", "j", "", "hasNext", "", "I", "h", "()I", "o", "(I)V", "nextState", "b", "e", "l", "currentStartIndex", "c", "g", "n", "nextSearchIndex", "d", "Lkotlin/ranges/k;", "f", "()Lkotlin/ranges/k;", "m", "(Lkotlin/ranges/k;)V", "nextItem", "k", "counter", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<kotlin.ranges.k>, e2.a {

        /* renamed from: a  reason: collision with root package name */
        private int f58943a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f58944b;

        /* renamed from: c  reason: collision with root package name */
        private int f58945c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private kotlin.ranges.k f58946d;

        /* renamed from: e  reason: collision with root package name */
        private int f58947e;

        a() {
            int B;
            B = kotlin.ranges.q.B(f.this.f58940b, 0, f.this.f58939a.length());
            this.f58944b = B;
            this.f58945c = B;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f58948f.f58941c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f58945c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f58943a = r1
                r0 = 0
                r6.f58946d = r0
                goto L9e
            Lc:
                kotlin.text.f r0 = kotlin.text.f.this
                int r0 = kotlin.text.f.e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f58947e
                int r0 = r0 + r3
                r6.f58947e = r0
                kotlin.text.f r4 = kotlin.text.f.this
                int r4 = kotlin.text.f.e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f58945c
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                kotlin.ranges.k r0 = new kotlin.ranges.k
                int r1 = r6.f58944b
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = kotlin.text.n.i3(r4)
                r0.<init>(r1, r4)
                r6.f58946d = r0
                r6.f58945c = r2
                goto L9c
            L47:
                kotlin.text.f r0 = kotlin.text.f.this
                d2.p r0 = kotlin.text.f.c(r0)
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r5 = r6.f58945c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                kotlin.ranges.k r0 = new kotlin.ranges.k
                int r1 = r6.f58944b
                kotlin.text.f r4 = kotlin.text.f.this
                java.lang.CharSequence r4 = kotlin.text.f.d(r4)
                int r4 = kotlin.text.n.i3(r4)
                r0.<init>(r1, r4)
                r6.f58946d = r0
                r6.f58945c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f58944b
                kotlin.ranges.k r4 = kotlin.ranges.o.n1(r4, r2)
                r6.f58946d = r4
                int r2 = r2 + r0
                r6.f58944b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f58945c = r2
            L9c:
                r6.f58943a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.f.a.a():void");
        }

        public final int d() {
            return this.f58947e;
        }

        public final int e() {
            return this.f58944b;
        }

        @Nullable
        public final kotlin.ranges.k f() {
            return this.f58946d;
        }

        public final int g() {
            return this.f58945c;
        }

        public final int h() {
            return this.f58943a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f58943a == -1) {
                a();
            }
            return this.f58943a == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: j */
        public kotlin.ranges.k next() {
            if (this.f58943a == -1) {
                a();
            }
            if (this.f58943a != 0) {
                kotlin.ranges.k kVar = this.f58946d;
                if (kVar != null) {
                    this.f58946d = null;
                    this.f58943a = -1;
                    return kVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        public final void k(int i4) {
            this.f58947e = i4;
        }

        public final void l(int i4) {
            this.f58944b = i4;
        }

        public final void m(@Nullable kotlin.ranges.k kVar) {
            this.f58946d = kVar;
        }

        public final void n(int i4) {
            this.f58945c = i4;
        }

        public final void o(int i4) {
            this.f58943a = i4;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull CharSequence input, int i4, int i5, @NotNull d2.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        f0.p(input, "input");
        f0.p(getNextMatch, "getNextMatch");
        this.f58939a = input;
        this.f58940b = i4;
        this.f58941c = i5;
        this.f58942d = getNextMatch;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<kotlin.ranges.k> iterator() {
        return new a();
    }
}
