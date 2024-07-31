package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.daimajia.numberprogressbar.BuildConfig;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@SinceKotlin(version = BuildConfig.VERSION_NAME)
@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001FB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020\u0003¢\u0006\u0004\bO\u0010PB\t\b\u0016¢\u0006\u0004\bO\u0010QB\u0017\b\u0016\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\bO\u0010RJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0083\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0083\bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u001d\u0010\u0018\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0015H\u0082\bJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\r\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010!J\r\u0010#\u001a\u00028\u0000¢\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b$\u0010\u001bJ\r\u0010%\u001a\u00028\u0000¢\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b&\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b'\u0010)J\u0016\u0010*\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u001e\u0010*\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0018\u0010+\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b+\u0010\u000bJ \u0010,\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b.\u0010(J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00100J\u0017\u00102\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b2\u0010(J\u0017\u00103\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b3\u0010\u000bJ\u0016\u00104\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0016\u00105\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J)\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0001\u001072\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<08H\u0016¢\u0006\u0004\b:\u0010=J)\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0001\u001072\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0000¢\u0006\u0004\b\u0001\u0010;J\u0017\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<08H\u0000¢\u0006\u0004\b>\u0010=JO\u0010D\u001a\u00020\u00052>\u0010C\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010<08¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050?H\u0000¢\u0006\u0004\bD\u0010ER\u0016\u0010B\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR$\u0010M\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b3\u0010G\u001a\u0004\bF\u0010L¨\u0006T"}, m12616d2 = {"Lkotlin/collections/l;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/g;", "", "minCapacity", "Lkotlin/f1;", "p", "newCapacity", "n", "internalIndex", "u", "(I)Ljava/lang/Object;", "index", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "v", UMCommonContent.f37782aL, "o", "", "elements", "m", "Lkotlin/Function1;", "", "predicate", CampaignEx.JSON_KEY_AD_Q, "isEmpty", "r", "()Ljava/lang/Object;", "s", "x", "y", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "B", "removeLast", "C", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "c", "removeAll", "retainAll", "clear", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "D", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "structure", IAdInterListener.AdReqParam.WIDTH, "(Ll1/p;)V", "a", "I", "b", "[Ljava/lang/Object;", "elementData", "<set-?>", "()I", "size", "initialCapacity", "<init>", "(I)V", "()V", "(Ljava/util/Collection;)V", "g", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* renamed from: kotlin.collections.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: e */
    private static final int f40906e = 2147483639;

    /* renamed from: f */
    private static final int f40907f = 10;

    /* renamed from: a */
    private int f40909a;

    /* renamed from: b */
    private Object[] f40910b;

    /* renamed from: c */
    private int f40911c;
    @NotNull

    /* renamed from: g */
    public static final C14169a f40908g = new C14169a(null);

    /* renamed from: d */
    private static final Object[] f40905d = new Object[0];

    /* compiled from: ArrayDeque.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u000f"}, m12616d2 = {"Lkotlin/collections/l$a;", "", "", "oldCapacity", "minCapacity", "a", "(II)I", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14169a {
        private C14169a() {
        }

        /* renamed from: a */
        public final int m11924a(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - ArrayDeque.f40906e > 0) {
                if (i2 > ArrayDeque.f40906e) {
                    return Integer.MAX_VALUE;
                }
                return ArrayDeque.f40906e;
            }
            return i3;
        }

        public /* synthetic */ C14169a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = f40905d;
        } else if (i <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        } else {
            objArr = new Object[i];
        }
        this.f40910b = objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public final int m11954A(int i) {
        Object[] objArr = this.f40910b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    /* renamed from: m */
    private final void m11938m(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f40910b.length;
        while (i < length && it.hasNext()) {
            this.f40910b[i] = it.next();
            i++;
        }
        int i2 = this.f40909a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f40910b[i3] = it.next();
        }
        this.f40911c = size() + collection.size();
    }

    /* renamed from: n */
    private final void m11937n(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.f40910b;
        _ArraysJvm.m11625c1(objArr2, objArr, 0, this.f40909a, objArr2.length);
        Object[] objArr3 = this.f40910b;
        int length = objArr3.length;
        int i2 = this.f40909a;
        _ArraysJvm.m11625c1(objArr3, objArr, length - i2, 0, i2);
        this.f40909a = 0;
        this.f40910b = objArr;
    }

    /* renamed from: o */
    private final int m11936o(int i) {
        int m10851Td;
        if (i == 0) {
            m10851Td = _Arrays.m10851Td(this.f40910b);
            return m10851Td;
        }
        return i - 1;
    }

    /* renamed from: p */
    private final void m11935p(int i) {
        int m7481n;
        if (i >= 0) {
            Object[] objArr = this.f40910b;
            if (i <= objArr.length) {
                return;
            }
            if (objArr == f40905d) {
                m7481n = _Ranges.m7481n(i, 10);
                this.f40910b = new Object[m7481n];
                return;
            }
            m11937n(f40908g.m11924a(objArr.length, i));
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    /* renamed from: q */
    private final boolean m11934q(InterfaceC15280l<? super E, Boolean> interfaceC15280l) {
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f40910b.length == 0)) {
                int m11954A = m11954A(this.f40909a + size());
                int i = this.f40909a;
                if (this.f40909a < m11954A) {
                    for (int i2 = this.f40909a; i2 < m11954A; i2++) {
                        Object obj = this.f40910b[i2];
                        if (interfaceC15280l.invoke(obj).booleanValue()) {
                            this.f40910b[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    _ArraysJvm.m11568n2(this.f40910b, null, i, m11954A);
                } else {
                    int length = this.f40910b.length;
                    boolean z2 = false;
                    for (int i3 = this.f40909a; i3 < length; i3++) {
                        Object obj2 = this.f40910b[i3];
                        this.f40910b[i3] = null;
                        if (interfaceC15280l.invoke(obj2).booleanValue()) {
                            this.f40910b[i] = obj2;
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    i = m11954A(i);
                    for (int i4 = 0; i4 < m11954A; i4++) {
                        Object obj3 = this.f40910b[i4];
                        this.f40910b[i4] = null;
                        if (interfaceC15280l.invoke(obj3).booleanValue()) {
                            this.f40910b[i] = obj3;
                            i = m11931t(i);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f40911c = m11925z(i - this.f40909a);
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public final int m11931t(int i) {
        int m10851Td;
        m10851Td = _Arrays.m10851Td(this.f40910b);
        if (i == m10851Td) {
            return 0;
        }
        return i + 1;
    }

    @InlineOnly
    /* renamed from: u */
    private final E m11930u(int i) {
        return (E) this.f40910b[i];
    }

    @InlineOnly
    /* renamed from: v */
    private final int m11929v(int i) {
        return m11954A(this.f40909a + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public final int m11925z(int i) {
        return i < 0 ? i + this.f40910b.length : i;
    }

    @Nullable
    /* renamed from: B */
    public final E m11953B() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Nullable
    /* renamed from: C */
    public final E m11952C() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @NotNull
    /* renamed from: D */
    public final Object[] m11951D() {
        return toArray();
    }

    @NotNull
    /* renamed from: E */
    public final <T> T[] m11950E(@NotNull T[] array) {
        C14342f0.m8184p(array, "array");
        return (T[]) toArray(array);
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: a */
    public int mo11949a() {
        return this.f40911c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        m11935p(size() + elements.size());
        m11938m(m11954A(this.f40909a + size()), elements);
        return true;
    }

    public final void addFirst(E e) {
        m11935p(size() + 1);
        int m11936o = m11936o(this.f40909a);
        this.f40909a = m11936o;
        this.f40910b[m11936o] = e;
        this.f40911c = size() + 1;
    }

    public final void addLast(E e) {
        m11935p(size() + 1);
        this.f40910b[m11954A(this.f40909a + size())] = e;
        this.f40911c = size() + 1;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: c */
    public E mo11948c(int i) {
        int m12476G;
        int m12476G2;
        AbstractList.Companion.m12304b(i, size());
        m12476G = CollectionsKt__CollectionsKt.m12476G(this);
        if (i == m12476G) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int m11954A = m11954A(this.f40909a + i);
        E e = (E) this.f40910b[m11954A];
        if (i < (size() >> 1)) {
            int i2 = this.f40909a;
            if (m11954A >= i2) {
                Object[] objArr = this.f40910b;
                _ArraysJvm.m11625c1(objArr, objArr, i2 + 1, i2, m11954A);
            } else {
                Object[] objArr2 = this.f40910b;
                _ArraysJvm.m11625c1(objArr2, objArr2, 1, 0, m11954A);
                Object[] objArr3 = this.f40910b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i3 = this.f40909a;
                _ArraysJvm.m11625c1(objArr3, objArr3, i3 + 1, i3, objArr3.length - 1);
            }
            Object[] objArr4 = this.f40910b;
            int i4 = this.f40909a;
            objArr4[i4] = null;
            this.f40909a = m11931t(i4);
        } else {
            m12476G2 = CollectionsKt__CollectionsKt.m12476G(this);
            int m11954A2 = m11954A(this.f40909a + m12476G2);
            if (m11954A <= m11954A2) {
                Object[] objArr5 = this.f40910b;
                _ArraysJvm.m11625c1(objArr5, objArr5, m11954A, m11954A + 1, m11954A2 + 1);
            } else {
                Object[] objArr6 = this.f40910b;
                _ArraysJvm.m11625c1(objArr6, objArr6, m11954A, m11954A + 1, objArr6.length);
                Object[] objArr7 = this.f40910b;
                objArr7[objArr7.length - 1] = objArr7[0];
                _ArraysJvm.m11625c1(objArr7, objArr7, 0, 1, m11954A2 + 1);
            }
            this.f40910b[m11954A2] = null;
        }
        this.f40911c = size() - 1;
        return e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int m11954A = m11954A(this.f40909a + size());
        int i = this.f40909a;
        if (i < m11954A) {
            _ArraysJvm.m11568n2(this.f40910b, null, i, m11954A);
        } else if (!isEmpty()) {
            Object[] objArr = this.f40910b;
            _ArraysJvm.m11568n2(objArr, null, this.f40909a, objArr.length);
            _ArraysJvm.m11568n2(this.f40910b, null, 0, m11954A);
        }
        this.f40909a = 0;
        this.f40911c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.m12304b(i, size());
        return (E) this.f40910b[m11954A(this.f40909a + i)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int m11954A = m11954A(this.f40909a + size());
        int i2 = this.f40909a;
        if (i2 < m11954A) {
            while (i2 < m11954A) {
                if (C14342f0.m8193g(obj, this.f40910b[i2])) {
                    i = this.f40909a;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < m11954A) {
            return -1;
        } else {
            int length = this.f40910b.length;
            while (true) {
                if (i2 >= length) {
                    for (int i3 = 0; i3 < m11954A; i3++) {
                        if (C14342f0.m8193g(obj, this.f40910b[i3])) {
                            i2 = i3 + this.f40910b.length;
                            i = this.f40909a;
                        }
                    }
                    return -1;
                } else if (C14342f0.m8193g(obj, this.f40910b[i2])) {
                    i = this.f40909a;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int m10851Td;
        int i;
        int m11954A = m11954A(this.f40909a + size());
        int i2 = this.f40909a;
        if (i2 < m11954A) {
            m10851Td = m11954A - 1;
            if (m10851Td < i2) {
                return -1;
            }
            while (!C14342f0.m8193g(obj, this.f40910b[m10851Td])) {
                if (m10851Td == i2) {
                    return -1;
                }
                m10851Td--;
            }
            i = this.f40909a;
        } else if (i2 <= m11954A) {
            return -1;
        } else {
            int i3 = m11954A - 1;
            while (true) {
                if (i3 >= 0) {
                    if (C14342f0.m8193g(obj, this.f40910b[i3])) {
                        m10851Td = i3 + this.f40910b.length;
                        i = this.f40909a;
                        break;
                    }
                    i3--;
                } else {
                    m10851Td = _Arrays.m10851Td(this.f40910b);
                    int i4 = this.f40909a;
                    if (m10851Td < i4) {
                        return -1;
                    }
                    while (!C14342f0.m8193g(obj, this.f40910b[m10851Td])) {
                        if (m10851Td == i4) {
                            return -1;
                        }
                        m10851Td--;
                    }
                    i = this.f40909a;
                }
            }
        }
        return m10851Td - i;
    }

    /* renamed from: r */
    public final E m11933r() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f40910b[this.f40909a];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f40910b.length == 0)) {
                int m11954A = m11954A(this.f40909a + size());
                int i = this.f40909a;
                if (this.f40909a < m11954A) {
                    for (int i2 = this.f40909a; i2 < m11954A; i2++) {
                        Object obj = this.f40910b[i2];
                        if (!elements.contains(obj)) {
                            this.f40910b[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    _ArraysJvm.m11568n2(this.f40910b, null, i, m11954A);
                } else {
                    int length = this.f40910b.length;
                    boolean z2 = false;
                    for (int i3 = this.f40909a; i3 < length; i3++) {
                        Object obj2 = this.f40910b[i3];
                        this.f40910b[i3] = null;
                        if (!elements.contains(obj2)) {
                            this.f40910b[i] = obj2;
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    i = m11954A(i);
                    for (int i4 = 0; i4 < m11954A; i4++) {
                        Object obj3 = this.f40910b[i4];
                        this.f40910b[i4] = null;
                        if (!elements.contains(obj3)) {
                            this.f40910b[i] = obj3;
                            i = m11931t(i);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f40911c = m11925z(i - this.f40909a);
                }
            }
        }
        return z;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E e = (E) this.f40910b[this.f40909a];
            Object[] objArr = this.f40910b;
            int i = this.f40909a;
            objArr[i] = null;
            this.f40909a = m11931t(i);
            this.f40911c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        int m12476G;
        if (!isEmpty()) {
            m12476G = CollectionsKt__CollectionsKt.m12476G(this);
            int m11954A = m11954A(this.f40909a + m12476G);
            E e = (E) this.f40910b[m11954A];
            this.f40910b[m11954A] = null;
            this.f40911c = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (!(this.f40910b.length == 0)) {
                int m11954A = m11954A(this.f40909a + size());
                int i = this.f40909a;
                if (this.f40909a < m11954A) {
                    for (int i2 = this.f40909a; i2 < m11954A; i2++) {
                        Object obj = this.f40910b[i2];
                        if (elements.contains(obj)) {
                            this.f40910b[i] = obj;
                            i++;
                        } else {
                            z = true;
                        }
                    }
                    _ArraysJvm.m11568n2(this.f40910b, null, i, m11954A);
                } else {
                    int length = this.f40910b.length;
                    boolean z2 = false;
                    for (int i3 = this.f40909a; i3 < length; i3++) {
                        Object obj2 = this.f40910b[i3];
                        this.f40910b[i3] = null;
                        if (elements.contains(obj2)) {
                            this.f40910b[i] = obj2;
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    i = m11954A(i);
                    for (int i4 = 0; i4 < m11954A; i4++) {
                        Object obj3 = this.f40910b[i4];
                        this.f40910b[i4] = null;
                        if (elements.contains(obj3)) {
                            this.f40910b[i] = obj3;
                            i = m11931t(i);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    this.f40911c = m11925z(i - this.f40909a);
                }
            }
        }
        return z;
    }

    @Nullable
    /* renamed from: s */
    public final E m11932s() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f40910b[this.f40909a];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        AbstractList.Companion.m12304b(i, size());
        int m11954A = m11954A(this.f40909a + i);
        E e2 = (E) this.f40910b[m11954A];
        this.f40910b[m11954A] = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        C14342f0.m8184p(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysJVM.m11803a(array, size());
        }
        if (array != null) {
            int m11954A = m11954A(this.f40909a + size());
            int i = this.f40909a;
            if (i < m11954A) {
                _ArraysJvm.m11580l1(this.f40910b, array, 0, i, m11954A, 2, null);
            } else if (!isEmpty()) {
                Object[] objArr = this.f40910b;
                _ArraysJvm.m11625c1(objArr, array, 0, this.f40909a, objArr.length);
                Object[] objArr2 = this.f40910b;
                _ArraysJvm.m11625c1(objArr2, array, objArr2.length - this.f40909a, 0, m11954A);
            }
            if (array.length > size()) {
                array[size()] = null;
            }
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    /* renamed from: w */
    public final void m11928w(@NotNull InterfaceC15284p<? super Integer, ? super Object[], Unit> structure) {
        int i;
        C14342f0.m8184p(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i = this.f40909a) < m11954A(this.f40909a + size())) ? this.f40909a : i - this.f40910b.length), toArray());
    }

    /* renamed from: x */
    public final E m11927x() {
        int m12476G;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(this);
        return (E) this.f40910b[m11954A(this.f40909a + m12476G)];
    }

    @Nullable
    /* renamed from: y */
    public final E m11926y() {
        int m12476G;
        if (isEmpty()) {
            return null;
        }
        m12476G = CollectionsKt__CollectionsKt.m12476G(this);
        return (E) this.f40910b[m11954A(this.f40909a + m12476G)];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        AbstractList.Companion.m12303c(i, size());
        if (i == size()) {
            addLast(e);
        } else if (i == 0) {
            addFirst(e);
        } else {
            m11935p(size() + 1);
            int m11954A = m11954A(this.f40909a + i);
            if (i < ((size() + 1) >> 1)) {
                int m11936o = m11936o(m11954A);
                int m11936o2 = m11936o(this.f40909a);
                int i2 = this.f40909a;
                if (m11936o >= i2) {
                    Object[] objArr = this.f40910b;
                    objArr[m11936o2] = objArr[i2];
                    _ArraysJvm.m11625c1(objArr, objArr, i2, i2 + 1, m11936o + 1);
                } else {
                    Object[] objArr2 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                    Object[] objArr3 = this.f40910b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    _ArraysJvm.m11625c1(objArr3, objArr3, 0, 1, m11936o + 1);
                }
                this.f40910b[m11936o] = e;
                this.f40909a = m11936o2;
            } else {
                int m11954A2 = m11954A(this.f40909a + size());
                if (m11954A < m11954A2) {
                    Object[] objArr4 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr4, objArr4, m11954A + 1, m11954A, m11954A2);
                } else {
                    Object[] objArr5 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr5, objArr5, 1, 0, m11954A2);
                    Object[] objArr6 = this.f40910b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    _ArraysJvm.m11625c1(objArr6, objArr6, m11954A + 1, m11954A, objArr6.length - 1);
                }
                this.f40910b[m11954A] = e;
            }
            this.f40911c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, @NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        AbstractList.Companion.m12303c(i, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        m11935p(size() + elements.size());
        int m11954A = m11954A(this.f40909a + size());
        int m11954A2 = m11954A(this.f40909a + i);
        int size = elements.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.f40909a;
            int i3 = i2 - size;
            if (m11954A2 < i2) {
                Object[] objArr = this.f40910b;
                _ArraysJvm.m11625c1(objArr, objArr, i3, i2, objArr.length);
                if (size >= m11954A2) {
                    Object[] objArr2 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr2, objArr2, objArr2.length - size, 0, m11954A2);
                } else {
                    Object[] objArr3 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr4, objArr4, 0, size, m11954A2);
                }
            } else if (i3 >= 0) {
                Object[] objArr5 = this.f40910b;
                _ArraysJvm.m11625c1(objArr5, objArr5, i3, i2, m11954A2);
            } else {
                Object[] objArr6 = this.f40910b;
                i3 += objArr6.length;
                int i4 = m11954A2 - i2;
                int length = objArr6.length - i3;
                if (length >= i4) {
                    _ArraysJvm.m11625c1(objArr6, objArr6, i3, i2, m11954A2);
                } else {
                    _ArraysJvm.m11625c1(objArr6, objArr6, i3, i2, i2 + length);
                    Object[] objArr7 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr7, objArr7, 0, this.f40909a + length, m11954A2);
                }
            }
            this.f40909a = i3;
            m11938m(m11925z(m11954A2 - size), elements);
        } else {
            int i5 = m11954A2 + size;
            if (m11954A2 < m11954A) {
                int i6 = size + m11954A;
                Object[] objArr8 = this.f40910b;
                if (i6 <= objArr8.length) {
                    _ArraysJvm.m11625c1(objArr8, objArr8, i5, m11954A2, m11954A);
                } else if (i5 >= objArr8.length) {
                    _ArraysJvm.m11625c1(objArr8, objArr8, i5 - objArr8.length, m11954A2, m11954A);
                } else {
                    int length2 = m11954A - (i6 - objArr8.length);
                    _ArraysJvm.m11625c1(objArr8, objArr8, 0, length2, m11954A);
                    Object[] objArr9 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr9, objArr9, i5, m11954A2, length2);
                }
            } else {
                Object[] objArr10 = this.f40910b;
                _ArraysJvm.m11625c1(objArr10, objArr10, size, 0, m11954A);
                Object[] objArr11 = this.f40910b;
                if (i5 >= objArr11.length) {
                    _ArraysJvm.m11625c1(objArr11, objArr11, i5 - objArr11.length, m11954A2, objArr11.length);
                } else {
                    _ArraysJvm.m11625c1(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f40910b;
                    _ArraysJvm.m11625c1(objArr12, objArr12, i5, m11954A2, objArr12.length - size);
                }
            }
            m11938m(m11954A2, elements);
        }
        return true;
    }

    public ArrayDeque() {
        this.f40910b = f40905d;
    }

    public ArrayDeque(@NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        if (array != null) {
            this.f40910b = array;
            this.f40911c = array.length;
            if (array.length == 0) {
                this.f40910b = f40905d;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
