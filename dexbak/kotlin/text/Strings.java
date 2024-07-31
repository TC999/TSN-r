package kotlin.text;

import com.kuaishou.weapon.p205p0.C7304t;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import kotlin.ranges._Ranges;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B[\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012:\u0010\u0015\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00130\u000f¢\u0006\u0002\b\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0018"}, m12616d2 = {"Lkotlin/text/f;", "Lkotlin/sequences/m;", "Lkotlin/ranges/k;", "", "iterator", "", "a", "Ljava/lang/CharSequence;", "input", "", "b", "I", "startIndex", "c", "limit", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "getNextMatch", "<init>", "(Ljava/lang/CharSequence;IILl1/p;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Strings implements Sequence<C14413k> {

    /* renamed from: a */
    private final CharSequence f41601a;

    /* renamed from: b */
    private final int f41602b;

    /* renamed from: c */
    private final int f41603c;

    /* renamed from: d */
    private final InterfaceC15284p<CharSequence, Integer, Tuples<Integer, Integer>> f41604d;

    /* compiled from: Strings.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u001d\u0010\r¨\u0006\u001f"}, m12616d2 = {"kotlin/text/f$a", "", "Lkotlin/ranges/k;", "Lkotlin/f1;", "a", "h", "", "hasNext", "", "I", "g", "()I", "m", "(I)V", "nextState", "b", "d", "j", "currentStartIndex", "c", "f", C7304t.f25048d, "nextSearchIndex", "Lkotlin/ranges/k;", "e", "()Lkotlin/ranges/k;", "k", "(Lkotlin/ranges/k;)V", "nextItem", "i", "counter", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.text.f$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14562a implements Iterator<C14413k>, KMarkers {

        /* renamed from: a */
        private int f41605a = -1;

        /* renamed from: b */
        private int f41606b;

        /* renamed from: c */
        private int f41607c;
        @Nullable

        /* renamed from: d */
        private C14413k f41608d;

        /* renamed from: e */
        private int f41609e;

        C14562a() {
            int m7565B;
            m7565B = _Ranges.m7565B(Strings.this.f41602b, 0, Strings.this.f41601a.length());
            this.f41606b = m7565B;
            this.f41607c = m7565B;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f41610f.f41603c) goto L13;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void m6824a() {
            /*
                r6 = this;
                int r0 = r6.f41607c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f41605a = r1
                r0 = 0
                r6.f41608d = r0
                goto L9e
            Lc:
                kotlin.text.f r0 = kotlin.text.Strings.this
                int r0 = kotlin.text.Strings.m6826e(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f41609e
                int r0 = r0 + r3
                r6.f41609e = r0
                kotlin.text.f r4 = kotlin.text.Strings.this
                int r4 = kotlin.text.Strings.m6826e(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f41607c
                kotlin.text.f r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.m6827d(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.f41606b
                kotlin.ranges.k r1 = new kotlin.ranges.k
                kotlin.text.f r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.m6827d(r4)
                int r4 = kotlin.text.C14573n.m6757i3(r4)
                r1.<init>(r0, r4)
                r6.f41608d = r1
                r6.f41607c = r2
                goto L9c
            L47:
                kotlin.text.f r0 = kotlin.text.Strings.this
                l1.p r0 = kotlin.text.Strings.m6828c(r0)
                kotlin.text.f r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.m6827d(r4)
                int r5 = r6.f41607c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Tuples) r0
                if (r0 != 0) goto L77
                int r0 = r6.f41606b
                kotlin.ranges.k r1 = new kotlin.ranges.k
                kotlin.text.f r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.m6827d(r4)
                int r4 = kotlin.text.C14573n.m6757i3(r4)
                r1.<init>(r0, r4)
                r6.f41608d = r1
                r6.f41607c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f41606b
                kotlin.ranges.k r4 = kotlin.ranges.C14420o.m7576n1(r4, r2)
                r6.f41608d = r4
                int r2 = r2 + r0
                r6.f41606b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f41607c = r2
            L9c:
                r6.f41605a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Strings.C14562a.m6824a():void");
        }

        /* renamed from: c */
        public final int m6823c() {
            return this.f41609e;
        }

        /* renamed from: d */
        public final int m6822d() {
            return this.f41606b;
        }

        @Nullable
        /* renamed from: e */
        public final C14413k m6821e() {
            return this.f41608d;
        }

        /* renamed from: f */
        public final int m6820f() {
            return this.f41607c;
        }

        /* renamed from: g */
        public final int m6819g() {
            return this.f41605a;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: h */
        public C14413k next() {
            if (this.f41605a == -1) {
                m6824a();
            }
            if (this.f41605a != 0) {
                C14413k c14413k = this.f41608d;
                if (c14413k != null) {
                    this.f41608d = null;
                    this.f41605a = -1;
                    return c14413k;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41605a == -1) {
                m6824a();
            }
            return this.f41605a == 1;
        }

        /* renamed from: i */
        public final void m6817i(int i) {
            this.f41609e = i;
        }

        /* renamed from: j */
        public final void m6816j(int i) {
            this.f41606b = i;
        }

        /* renamed from: k */
        public final void m6815k(@Nullable C14413k c14413k) {
            this.f41608d = c14413k;
        }

        /* renamed from: l */
        public final void m6814l(int i) {
            this.f41607c = i;
        }

        /* renamed from: m */
        public final void m6813m(int i) {
            this.f41605a = i;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Strings(@NotNull CharSequence input, int i, int i2, @NotNull InterfaceC15284p<? super CharSequence, ? super Integer, Tuples<Integer, Integer>> getNextMatch) {
        C14342f0.m8184p(input, "input");
        C14342f0.m8184p(getNextMatch, "getNextMatch");
        this.f41601a = input;
        this.f41602b = i;
        this.f41603c = i2;
        this.f41604d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<C14413k> iterator() {
        return new C14562a();
    }
}
