package kotlin;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractC14220t1;
import kotlin.collections._Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.CollectionToArray;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0014\b\u0001\u0012\u0006\u0010%\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b(\u0010)B\u0014\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0088\u0001%\u0092\u0001\u00020 ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006,"}, m12616d2 = {"Lkotlin/w0;", "", "Lkotlin/v0;", "", "index", "k", "([JI)J", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "r", "([JIJ)V", "", CampaignEx.JSON_KEY_AD_Q, "([J)Ljava/util/Iterator;", "element", "", "g", "([JJ)Z", "elements", "h", "([JLjava/util/Collection;)Z", "p", "([J)Z", "", "s", "([J)Ljava/lang/String;", "o", "([J)I", "", AdnName.OTHER, "i", "([JLjava/lang/Object;)Z", "", "a", "[J", "getStorage$annotations", "()V", "storage", "m", "size", "e", "([J)[J", "d", "(I)[J", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@Unsigned
@JvmInline
/* renamed from: kotlin.w0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ULongArray implements Collection<ULong>, KMarkers {
    @NotNull

    /* renamed from: a */
    private final long[] f41680a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ULongArray.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m12616d2 = {"Lkotlin/w0$a;", "Lkotlin/collections/t1;", "", "hasNext", "Lkotlin/v0;", "c", "()J", "", "a", "I", "index", "", "b", "[J", "array", "<init>", "([J)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.w0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14609a extends AbstractC14220t1 {

        /* renamed from: a */
        private int f41681a;

        /* renamed from: b */
        private final long[] f41682b;

        public C14609a(@NotNull long[] array) {
            C14342f0.m8184p(array, "array");
            this.f41682b = array;
        }

        @Override // kotlin.collections.AbstractC14220t1
        /* renamed from: c */
        public long mo5814c() {
            int i = this.f41681a;
            long[] jArr = this.f41682b;
            if (i < jArr.length) {
                this.f41681a = i + 1;
                return ULong.m5889h(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f41681a));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41681a < this.f41682b.length;
        }
    }

    @PublishedApi
    private /* synthetic */ ULongArray(long[] storage) {
        C14342f0.m8184p(storage, "storage");
        this.f41680a = storage;
    }

    /* renamed from: c */
    public static final /* synthetic */ ULongArray m5832c(long[] v) {
        C14342f0.m8184p(v, "v");
        return new ULongArray(v);
    }

    @NotNull
    /* renamed from: d */
    public static long[] m5831d(int i) {
        return m5830e(new long[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: e */
    public static long[] m5830e(@NotNull long[] storage) {
        C14342f0.m8184p(storage, "storage");
        return storage;
    }

    /* renamed from: g */
    public static boolean m5828g(long[] jArr, long j) {
        boolean m11017O7;
        m11017O7 = _Arrays.m11017O7(jArr, j);
        return m11017O7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m5827h(long[] r5, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.ULong> r6) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.C14342f0.m8184p(r6, r0)
            boolean r0 = r6.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
        Ld:
            r1 = 1
            goto L32
        Lf:
            java.util.Iterator r6 = r6.iterator()
        L13:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r6.next()
            boolean r3 = r0 instanceof kotlin.ULong
            if (r3 == 0) goto L2f
            kotlin.v0 r0 = (kotlin.ULong) r0
            long r3 = r0.m5890g0()
            boolean r0 = kotlin.collections.C14173m.m11885O7(r5, r3)
            if (r0 == 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 != 0) goto L13
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ULongArray.m5827h(long[], java.util.Collection):boolean");
    }

    /* renamed from: i */
    public static boolean m5826i(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && C14342f0.m8193g(jArr, ((ULongArray) obj).m5815t());
    }

    /* renamed from: j */
    public static final boolean m5825j(long[] jArr, long[] jArr2) {
        return C14342f0.m8193g(jArr, jArr2);
    }

    /* renamed from: k */
    public static final long m5824k(long[] jArr, int i) {
        return ULong.m5889h(jArr[i]);
    }

    /* renamed from: m */
    public static int m5822m(long[] jArr) {
        return jArr.length;
    }

    @PublishedApi
    /* renamed from: n */
    public static /* synthetic */ void m5821n() {
    }

    /* renamed from: o */
    public static int m5820o(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    /* renamed from: p */
    public static boolean m5819p(long[] jArr) {
        return jArr.length == 0;
    }

    @NotNull
    /* renamed from: q */
    public static Iterator<ULong> m5818q(long[] jArr) {
        return new C14609a(jArr);
    }

    /* renamed from: r */
    public static final void m5817r(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* renamed from: s */
    public static String m5816s(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    /* renamed from: a */
    public boolean m5833a(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m5829f(((ULong) obj).m5890g0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m5827h(this.f41680a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m5826i(this.f41680a, obj);
    }

    /* renamed from: f */
    public boolean m5829f(long j) {
        return m5828g(this.f41680a, j);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m5820o(this.f41680a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m5819p(this.f41680a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<ULong> iterator() {
        return m5818q(this.f41680a);
    }

    /* renamed from: l */
    public int m5823l() {
        return m5822m(this.f41680a);
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
    public final /* bridge */ int size() {
        return m5823l();
    }

    /* renamed from: t */
    public final /* synthetic */ long[] m5815t() {
        return this.f41680a;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.m8043a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.m8042b(this, tArr);
    }

    public String toString() {
        return m5816s(this.f41680a);
    }
}
