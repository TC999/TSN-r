package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.u1;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ULongArray.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0014\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)B\u0014\b\u0001\u0012\u0006\u0010%\u001a\u00020 \u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0088\u0001%\u0092\u0001\u00020 \u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006,"}, d2 = {"Lkotlin/w0;", "", "Lkotlin/v0;", "", "index", CampaignEx.JSON_KEY_AD_Q, "([JI)J", "value", "Lkotlin/f1;", "y", "([JIJ)V", "", "x", "([J)Ljava/util/Iterator;", "element", "", "m", "([JJ)Z", "elements", "n", "([JLjava/util/Collection;)Z", "w", "([J)Z", "", "z", "([J)Ljava/lang/String;", "u", "([J)I", "", "other", "o", "([JLjava/lang/Object;)Z", "", "a", "[J", "getStorage$annotations", "()V", "storage", "s", "size", "g", "(I)[J", "k", "([J)[J", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalUnsignedTypes
@JvmInline
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w0 implements Collection<v0>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final long[] f59025a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ULongArray.kt */
    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0011"}, d2 = {"Lkotlin/w0$a;", "Lkotlin/collections/u1;", "", "hasNext", "Lkotlin/v0;", "d", "()J", "", "a", "[J", "array", "", "b", "I", "index", "<init>", "([J)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends u1 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final long[] f59026a;

        /* renamed from: b  reason: collision with root package name */
        private int f59027b;

        public a(@NotNull long[] array) {
            kotlin.jvm.internal.f0.p(array, "array");
            this.f59026a = array;
        }

        @Override // kotlin.collections.u1
        public long d() {
            int i4 = this.f59027b;
            long[] jArr = this.f59026a;
            if (i4 < jArr.length) {
                this.f59027b = i4 + 1;
                return v0.i(jArr[i4]);
            }
            throw new NoSuchElementException(String.valueOf(this.f59027b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f59027b < this.f59026a.length;
        }
    }

    @PublishedApi
    private /* synthetic */ w0(long[] jArr) {
        this.f59025a = jArr;
    }

    public static final /* synthetic */ w0 c(long[] jArr) {
        return new w0(jArr);
    }

    @NotNull
    public static long[] g(int i4) {
        return k(new long[i4]);
    }

    @PublishedApi
    @NotNull
    public static long[] k(@NotNull long[] storage) {
        kotlin.jvm.internal.f0.p(storage, "storage");
        return storage;
    }

    public static boolean m(long[] arg0, long j4) {
        boolean O7;
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        O7 = kotlin.collections.p.O7(arg0, j4);
        return O7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean n(long[] r5, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.v0> r6) {
        /*
            java.lang.String r0 = "arg0"
            kotlin.jvm.internal.f0.p(r5, r0)
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.f0.p(r6, r0)
            boolean r0 = r6.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L14
        L12:
            r1 = 1
            goto L37
        L14:
            java.util.Iterator r6 = r6.iterator()
        L18:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L12
            java.lang.Object r0 = r6.next()
            boolean r3 = r0 instanceof kotlin.v0
            if (r3 == 0) goto L34
            kotlin.v0 r0 = (kotlin.v0) r0
            long r3 = r0.l0()
            boolean r0 = kotlin.collections.l.O7(r5, r3)
            if (r0 == 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            if (r0 != 0) goto L18
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.w0.n(long[], java.util.Collection):boolean");
    }

    public static boolean o(long[] jArr, Object obj) {
        return (obj instanceof w0) && kotlin.jvm.internal.f0.g(jArr, ((w0) obj).A());
    }

    public static final boolean p(long[] jArr, long[] jArr2) {
        return kotlin.jvm.internal.f0.g(jArr, jArr2);
    }

    public static final long q(long[] arg0, int i4) {
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        return v0.i(arg0[i4]);
    }

    public static int s(long[] arg0) {
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        return arg0.length;
    }

    @PublishedApi
    public static /* synthetic */ void t() {
    }

    public static int u(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean w(long[] arg0) {
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        return arg0.length == 0;
    }

    @NotNull
    public static Iterator<v0> x(long[] arg0) {
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        return new a(arg0);
    }

    public static final void y(long[] arg0, int i4, long j4) {
        kotlin.jvm.internal.f0.p(arg0, "arg0");
        arg0[i4] = j4;
    }

    public static String z(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public final /* synthetic */ long[] A() {
        return this.f59025a;
    }

    public boolean a(long j4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(v0 v0Var) {
        return a(v0Var.l0());
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends v0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof v0) {
            return l(((v0) obj).l0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return n(this.f59025a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return o(this.f59025a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return u(this.f59025a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.f59025a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<v0> iterator() {
        return x(this.f59025a);
    }

    public boolean l(long j4) {
        return m(this.f59025a, j4);
    }

    @Override // java.util.Collection
    /* renamed from: r */
    public int size() {
        return s(this.f59025a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }

    public String toString() {
        return z(this.f59025a);
    }
}
