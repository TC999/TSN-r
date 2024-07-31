package kotlin;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.UIterators;
import kotlin.collections._Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.CollectionToArray;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0014\b\u0001\u0012\u0006\u0010%\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b(\u0010)B\u0014\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0088\u0001%\u0092\u0001\u00020 ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006,"}, m12616d2 = {"Lkotlin/o0;", "", "Lkotlin/n0;", "", "index", "k", "([BI)B", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "r", "([BIB)V", "", CampaignEx.JSON_KEY_AD_Q, "([B)Ljava/util/Iterator;", "element", "", "g", "([BB)Z", "elements", "h", "([BLjava/util/Collection;)Z", "p", "([B)Z", "", "s", "([B)Ljava/lang/String;", "o", "([B)I", "", AdnName.OTHER, "i", "([BLjava/lang/Object;)Z", "", "a", "[B", "getStorage$annotations", "()V", "storage", "m", "size", "e", "([B)[B", "d", "(I)[B", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@Unsigned
@JvmInline
/* renamed from: kotlin.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UByteArray implements Collection<UByte>, KMarkers {
    @NotNull

    /* renamed from: a */
    private final byte[] f41247a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UByteArray.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m12616d2 = {"Lkotlin/o0$a;", "Lkotlin/collections/p1;", "", "hasNext", "Lkotlin/n0;", "c", "()B", "", "a", "I", "index", "", "b", "[B", "array", "<init>", "([B)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.o0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14379a extends UIterators {

        /* renamed from: a */
        private int f41248a;

        /* renamed from: b */
        private final byte[] f41249b;

        public C14379a(@NotNull byte[] array) {
            C14342f0.m8184p(array, "array");
            this.f41249b = array;
        }

        @Override // kotlin.collections.UIterators
        /* renamed from: c */
        public byte mo7738c() {
            int i = this.f41248a;
            byte[] bArr = this.f41249b;
            if (i < bArr.length) {
                this.f41248a = i + 1;
                return UByte.m7776h(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f41248a));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41248a < this.f41249b.length;
        }
    }

    @PublishedApi
    private /* synthetic */ UByteArray(byte[] storage) {
        C14342f0.m8184p(storage, "storage");
        this.f41247a = storage;
    }

    /* renamed from: c */
    public static final /* synthetic */ UByteArray m7756c(byte[] v) {
        C14342f0.m8184p(v, "v");
        return new UByteArray(v);
    }

    @NotNull
    /* renamed from: d */
    public static byte[] m7755d(int i) {
        return m7754e(new byte[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: e */
    public static byte[] m7754e(@NotNull byte[] storage) {
        C14342f0.m8184p(storage, "storage");
        return storage;
    }

    /* renamed from: g */
    public static boolean m7752g(byte[] bArr, byte b) {
        boolean m11177J7;
        m11177J7 = _Arrays.m11177J7(bArr, b);
        return m11177J7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m7751h(byte[] r4, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UByte> r5) {
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
            boolean r3 = r0 instanceof kotlin.UByte
            if (r3 == 0) goto L2f
            kotlin.n0 r0 = (kotlin.UByte) r0
            byte r0 = r0.m7780e0()
            boolean r0 = kotlin.collections.C14173m.m11901J7(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UByteArray.m7751h(byte[], java.util.Collection):boolean");
    }

    /* renamed from: i */
    public static boolean m7750i(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && C14342f0.m8193g(bArr, ((UByteArray) obj).m7739t());
    }

    /* renamed from: j */
    public static final boolean m7749j(byte[] bArr, byte[] bArr2) {
        return C14342f0.m8193g(bArr, bArr2);
    }

    /* renamed from: k */
    public static final byte m7748k(byte[] bArr, int i) {
        return UByte.m7776h(bArr[i]);
    }

    /* renamed from: m */
    public static int m7746m(byte[] bArr) {
        return bArr.length;
    }

    @PublishedApi
    /* renamed from: n */
    public static /* synthetic */ void m7745n() {
    }

    /* renamed from: o */
    public static int m7744o(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    /* renamed from: p */
    public static boolean m7743p(byte[] bArr) {
        return bArr.length == 0;
    }

    @NotNull
    /* renamed from: q */
    public static Iterator<UByte> m7742q(byte[] bArr) {
        return new C14379a(bArr);
    }

    /* renamed from: r */
    public static final void m7741r(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* renamed from: s */
    public static String m7740s(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ")";
    }

    /* renamed from: a */
    public boolean m7757a(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m7753f(((UByte) obj).m7780e0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m7751h(this.f41247a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m7750i(this.f41247a, obj);
    }

    /* renamed from: f */
    public boolean m7753f(byte b) {
        return m7752g(this.f41247a, b);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m7744o(this.f41247a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m7743p(this.f41247a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<UByte> iterator() {
        return m7742q(this.f41247a);
    }

    /* renamed from: l */
    public int m7747l() {
        return m7746m(this.f41247a);
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
        return m7747l();
    }

    /* renamed from: t */
    public final /* synthetic */ byte[] m7739t() {
        return this.f41247a;
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
        return m7740s(this.f41247a);
    }
}
