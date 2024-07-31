package kotlin;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractC14217s1;
import kotlin.collections._Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.CollectionToArray;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0014\b\u0001\u0012\u0006\u0010%\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b(\u0010)B\u0014\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0088\u0001%\u0092\u0001\u00020 ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006,"}, m12616d2 = {"Lkotlin/s0;", "", "Lkotlin/r0;", "", "index", "k", "([II)I", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "r", "([III)V", "", CampaignEx.JSON_KEY_AD_Q, "([I)Ljava/util/Iterator;", "element", "", "g", "([II)Z", "elements", "h", "([ILjava/util/Collection;)Z", "p", "([I)Z", "", "s", "([I)Ljava/lang/String;", "o", "([I)I", "", AdnName.OTHER, "i", "([ILjava/lang/Object;)Z", "", "a", "[I", "getStorage$annotations", "()V", "storage", "m", "size", "e", "([I)[I", "d", "(I)[I", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@Unsigned
@JvmInline
/* renamed from: kotlin.s0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UIntArray implements Collection<UInt>, KMarkers {
    @NotNull

    /* renamed from: a */
    private final int[] f41351a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIntArray.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m12616d2 = {"Lkotlin/s0$a;", "Lkotlin/collections/s1;", "", "hasNext", "Lkotlin/r0;", "c", "()I", "", "a", "I", "index", "", "b", "[I", "array", "<init>", "([I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.s0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14465a extends AbstractC14217s1 {

        /* renamed from: a */
        private int f41352a;

        /* renamed from: b */
        private final int[] f41353b;

        public C14465a(@NotNull int[] array) {
            C14342f0.m8184p(array, "array");
            this.f41353b = array;
        }

        @Override // kotlin.collections.AbstractC14217s1
        /* renamed from: c */
        public int mo7274c() {
            int i = this.f41352a;
            int[] iArr = this.f41353b;
            if (i < iArr.length) {
                this.f41352a = i + 1;
                return UInt.m7678h(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f41352a));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41352a < this.f41353b.length;
        }
    }

    @PublishedApi
    private /* synthetic */ UIntArray(int[] storage) {
        C14342f0.m8184p(storage, "storage");
        this.f41351a = storage;
    }

    /* renamed from: c */
    public static final /* synthetic */ UIntArray m7292c(int[] v) {
        C14342f0.m8184p(v, "v");
        return new UIntArray(v);
    }

    @NotNull
    /* renamed from: d */
    public static int[] m7291d(int i) {
        return m7290e(new int[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: e */
    public static int[] m7290e(@NotNull int[] storage) {
        C14342f0.m8184p(storage, "storage");
        return storage;
    }

    /* renamed from: g */
    public static boolean m7288g(int[] iArr, int i) {
        boolean m11049N7;
        m11049N7 = _Arrays.m11049N7(iArr, i);
        return m11049N7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m7287h(int[] r4, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UInt> r5) {
        /*
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.C14342f0.m8184p(r5, r0)
            boolean r0 = r5.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lf
        Ld:
            r1 = 1
            goto L32
        Lf:
            java.util.Iterator r5 = r5.iterator()
        L13:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r5.next()
            boolean r3 = r0 instanceof kotlin.UInt
            if (r3 == 0) goto L2f
            kotlin.r0 r0 = (kotlin.UInt) r0
            int r0 = r0.m7679g0()
            boolean r0 = kotlin.collections.C14173m.m11889N7(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UIntArray.m7287h(int[], java.util.Collection):boolean");
    }

    /* renamed from: i */
    public static boolean m7286i(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && C14342f0.m8193g(iArr, ((UIntArray) obj).m7275t());
    }

    /* renamed from: j */
    public static final boolean m7285j(int[] iArr, int[] iArr2) {
        return C14342f0.m8193g(iArr, iArr2);
    }

    /* renamed from: k */
    public static final int m7284k(int[] iArr, int i) {
        return UInt.m7678h(iArr[i]);
    }

    /* renamed from: m */
    public static int m7282m(int[] iArr) {
        return iArr.length;
    }

    @PublishedApi
    /* renamed from: n */
    public static /* synthetic */ void m7281n() {
    }

    /* renamed from: o */
    public static int m7280o(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    /* renamed from: p */
    public static boolean m7279p(int[] iArr) {
        return iArr.length == 0;
    }

    @NotNull
    /* renamed from: q */
    public static Iterator<UInt> m7278q(int[] iArr) {
        return new C14465a(iArr);
    }

    /* renamed from: r */
    public static final void m7277r(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* renamed from: s */
    public static String m7276s(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ")";
    }

    /* renamed from: a */
    public boolean m7293a(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m7289f(((UInt) obj).m7679g0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m7287h(this.f41351a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m7286i(this.f41351a, obj);
    }

    /* renamed from: f */
    public boolean m7289f(int i) {
        return m7288g(this.f41351a, i);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m7280o(this.f41351a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m7279p(this.f41351a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<UInt> iterator() {
        return m7278q(this.f41351a);
    }

    /* renamed from: l */
    public int m7283l() {
        return m7282m(this.f41351a);
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
        return m7283l();
    }

    /* renamed from: t */
    public final /* synthetic */ int[] m7275t() {
        return this.f41351a;
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
        return m7276s(this.f41351a);
    }
}
