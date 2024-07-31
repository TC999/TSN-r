package kotlin;

import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractC14223u1;
import kotlin.collections._Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.CollectionToArray;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\f\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0014\b\u0001\u0012\u0006\u0010%\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\b(\u0010)B\u0014\b\u0016\u0012\u0006\u0010'\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0013\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020 8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b!\u0010\"\u0012\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001b\u0088\u0001%\u0092\u0001\u00020 ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006,"}, m12616d2 = {"Lkotlin/c1;", "", "Lkotlin/b1;", "", "index", "k", "([SI)S", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "r", "([SIS)V", "", CampaignEx.JSON_KEY_AD_Q, "([S)Ljava/util/Iterator;", "element", "", "g", "([SS)Z", "elements", "h", "([SLjava/util/Collection;)Z", "p", "([S)Z", "", "s", "([S)Ljava/lang/String;", "o", "([S)I", "", AdnName.OTHER, "i", "([SLjava/lang/Object;)Z", "", "a", "[S", "getStorage$annotations", "()V", "storage", "m", "size", "e", "([S)[S", "d", "(I)[S", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@Unsigned
@JvmInline
/* renamed from: kotlin.c1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UShortArray implements Collection<UShort>, KMarkers {
    @NotNull

    /* renamed from: a */
    private final short[] f40825a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UShortArray.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m12616d2 = {"Lkotlin/c1$a;", "Lkotlin/collections/u1;", "", "hasNext", "Lkotlin/b1;", "c", "()S", "", "a", "I", "index", "", "b", "[S", "array", "<init>", "([S)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.c1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14127a extends AbstractC14223u1 {

        /* renamed from: a */
        private int f40826a;

        /* renamed from: b */
        private final short[] f40827b;

        public C14127a(@NotNull short[] array) {
            C14342f0.m8184p(array, "array");
            this.f40827b = array;
        }

        @Override // kotlin.collections.AbstractC14223u1
        /* renamed from: c */
        public short mo9788c() {
            int i = this.f40826a;
            short[] sArr = this.f40827b;
            if (i < sArr.length) {
                this.f40826a = i + 1;
                return UShort.m12528h(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.f40826a));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f40826a < this.f40827b.length;
        }
    }

    @PublishedApi
    private /* synthetic */ UShortArray(short[] storage) {
        C14342f0.m8184p(storage, "storage");
        this.f40825a = storage;
    }

    /* renamed from: c */
    public static final /* synthetic */ UShortArray m12500c(short[] v) {
        C14342f0.m8184p(v, "v");
        return new UShortArray(v);
    }

    @NotNull
    /* renamed from: d */
    public static short[] m12499d(int i) {
        return m12498e(new short[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: e */
    public static short[] m12498e(@NotNull short[] storage) {
        C14342f0.m8184p(storage, "storage");
        return storage;
    }

    /* renamed from: g */
    public static boolean m12496g(short[] sArr, short s) {
        boolean m10953Q7;
        m10953Q7 = _Arrays.m10953Q7(sArr, s);
        return m10953Q7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m12495h(short[] r4, @org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UShort> r5) {
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
            boolean r3 = r0 instanceof kotlin.UShort
            if (r3 == 0) goto L2f
            kotlin.b1 r0 = (kotlin.UShort) r0
            short r0 = r0.m12532e0()
            boolean r0 = kotlin.collections.C14173m.m11882Q7(r4, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.UShortArray.m12495h(short[], java.util.Collection):boolean");
    }

    /* renamed from: i */
    public static boolean m12494i(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && C14342f0.m8193g(sArr, ((UShortArray) obj).m12483t());
    }

    /* renamed from: j */
    public static final boolean m12493j(short[] sArr, short[] sArr2) {
        return C14342f0.m8193g(sArr, sArr2);
    }

    /* renamed from: k */
    public static final short m12492k(short[] sArr, int i) {
        return UShort.m12528h(sArr[i]);
    }

    /* renamed from: m */
    public static int m12490m(short[] sArr) {
        return sArr.length;
    }

    @PublishedApi
    /* renamed from: n */
    public static /* synthetic */ void m12489n() {
    }

    /* renamed from: o */
    public static int m12488o(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* renamed from: p */
    public static boolean m12487p(short[] sArr) {
        return sArr.length == 0;
    }

    @NotNull
    /* renamed from: q */
    public static Iterator<UShort> m12486q(short[] sArr) {
        return new C14127a(sArr);
    }

    /* renamed from: r */
    public static final void m12485r(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    /* renamed from: s */
    public static String m12484s(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    /* renamed from: a */
    public boolean m12501a(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m12497f(((UShort) obj).m12532e0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m12495h(this.f40825a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m12494i(this.f40825a, obj);
    }

    /* renamed from: f */
    public boolean m12497f(short s) {
        return m12496g(this.f40825a, s);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m12488o(this.f40825a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m12487p(this.f40825a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<UShort> iterator() {
        return m12486q(this.f40825a);
    }

    /* renamed from: l */
    public int m12491l() {
        return m12490m(this.f40825a);
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
        return m12491l();
    }

    /* renamed from: t */
    public final /* synthetic */ short[] m12483t() {
        return this.f40825a;
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
        return m12484s(this.f40825a);
    }
}
