package kotlin.collections;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayDeque.kt */
@SinceKotlin(version = "1.4")
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 V*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001GB\u0011\b\u0016\u0012\u0006\u0010Q\u001a\u00020\u0003\u00a2\u0006\u0004\bR\u0010SB\t\b\u0016\u00a2\u0006\u0004\bR\u0010TB\u0017\b\u0016\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u00a2\u0006\u0004\bR\u0010UJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0083\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0083\bJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u001d\u0010\u0018\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00160\u0015H\u0082\bJ\b\u0010\u0019\u001a\u00020\u0016H\u0016J\r\u0010\u001a\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001bJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0000\u00a2\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00028\u0000\u00a2\u0006\u0004\b\"\u0010!J\r\u0010#\u001a\u00028\u0000\u00a2\u0006\u0004\b#\u0010\u001bJ\u000f\u0010$\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b$\u0010\u001bJ\r\u0010%\u001a\u00028\u0000\u00a2\u0006\u0004\b%\u0010\u001bJ\u000f\u0010&\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b&\u0010\u001bJ\u0017\u0010'\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b'\u0010)J\u0016\u0010*\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u001e\u0010*\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0018\u0010+\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002\u00a2\u0006\u0004\b+\u0010\u000bJ \u0010,\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b.\u0010(J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b1\u00100J\u0017\u00102\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b2\u0010(J\u0017\u00103\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b3\u0010\u000bJ\u0016\u00104\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0016\u00105\u001a\u00020\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J)\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0001\u001072\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0016\u00a2\u0006\u0004\b:\u0010;J\u0017\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<08H\u0016\u00a2\u0006\u0004\b:\u0010=J)\u0010>\u001a\b\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0001\u001072\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0000\u00a2\u0006\u0004\b>\u0010;J\u0017\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<08H\u0000\u00a2\u0006\u0004\b?\u0010=JO\u0010E\u001a\u00020\u00052>\u0010D\u001a:\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(C\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010<08\u00a2\u0006\f\bA\u0012\b\bB\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050@H\u0000\u00a2\u0006\u0004\bE\u0010FR\u0016\u0010C\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR$\u0010P\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00038\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bN\u0010O\u00a8\u0006W"}, d2 = {"Lkotlin/collections/k;", "E", "Lkotlin/collections/f;", "", "minCapacity", "Lkotlin/f1;", "ensureCapacity", "newCapacity", "o", "internalIndex", "t", "(I)Ljava/lang/Object;", "index", "z", "y", "u", "s", "p", "", "elements", "n", "Lkotlin/Function1;", "", "predicate", CampaignEx.JSON_KEY_AD_Q, "isEmpty", "first", "()Ljava/lang/Object;", "r", "last", "x", "element", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "A", "removeLast", "B", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "addAll", f3.f5657f, f3.f5659h, "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", "T", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "D", "C", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "structure", "w", "(Ld2/p;)V", "a", "I", "b", "[Ljava/lang/Object;", "elementData", "<set-?>", "c", "getSize", "()I", "size", "initialCapacity", "<init>", "(I)V", "()V", "(Ljava/util/Collection;)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k<E> extends f<E> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f55337d = new a(null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f55338e = new Object[0];

    /* renamed from: f  reason: collision with root package name */
    private static final int f55339f = 2147483639;

    /* renamed from: g  reason: collision with root package name */
    private static final int f55340g = 10;

    /* renamed from: a  reason: collision with root package name */
    private int f55341a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private Object[] f55342b;

    /* renamed from: c  reason: collision with root package name */
    private int f55343c;

    /* compiled from: ArrayDeque.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/collections/k$a;", "", "", "oldCapacity", "minCapacity", "a", "(II)I", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final int a(int i4, int i5) {
            int i6 = i4 + (i4 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - k.f55339f > 0) {
                if (i5 > k.f55339f) {
                    return Integer.MAX_VALUE;
                }
                return k.f55339f;
            }
            return i6;
        }
    }

    public k(int i4) {
        Object[] objArr;
        if (i4 == 0) {
            objArr = f55338e;
        } else if (i4 > 0) {
            objArr = new Object[i4];
        } else {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Illegal Capacity: ", Integer.valueOf(i4)));
        }
        this.f55342b = objArr;
    }

    private final void ensureCapacity(int i4) {
        int n4;
        if (i4 >= 0) {
            Object[] objArr = this.f55342b;
            if (i4 <= objArr.length) {
                return;
            }
            if (objArr == f55338e) {
                n4 = kotlin.ranges.q.n(i4, 10);
                this.f55342b = new Object[n4];
                return;
            }
            o(f55337d.a(objArr.length, i4));
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    private final void n(int i4, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f55342b.length;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (!it.hasNext()) {
                break;
            }
            this.f55342b[i4] = it.next();
            i4 = i5;
        }
        int i6 = 0;
        int i7 = this.f55341a;
        while (i6 < i7) {
            int i8 = i6 + 1;
            if (!it.hasNext()) {
                break;
            }
            this.f55342b[i6] = it.next();
            i6 = i8;
        }
        this.f55343c = size() + collection.size();
    }

    private final void o(int i4) {
        Object[] objArr = new Object[i4];
        Object[] objArr2 = this.f55342b;
        o.c1(objArr2, objArr, 0, this.f55341a, objArr2.length);
        Object[] objArr3 = this.f55342b;
        int length = objArr3.length;
        int i5 = this.f55341a;
        o.c1(objArr3, objArr, length - i5, 0, i5);
        this.f55341a = 0;
        this.f55342b = objArr;
    }

    private final int p(int i4) {
        int Td;
        if (i4 == 0) {
            Td = p.Td(this.f55342b);
            return Td;
        }
        return i4 - 1;
    }

    private final boolean q(d2.l<? super E, Boolean> lVar) {
        boolean z3 = false;
        z3 = false;
        int i4 = 0;
        z3 = false;
        if (!isEmpty()) {
            if (!(this.f55342b.length == 0)) {
                int z4 = z(this.f55341a + size());
                int i5 = this.f55341a;
                if (this.f55341a < z4) {
                    int i6 = this.f55341a;
                    while (i6 < z4) {
                        int i7 = i6 + 1;
                        Object obj = this.f55342b[i6];
                        if (lVar.invoke(obj).booleanValue()) {
                            this.f55342b[i5] = obj;
                            i6 = i7;
                            i5++;
                        } else {
                            i6 = i7;
                            z3 = true;
                        }
                    }
                    o.n2(this.f55342b, null, i5, z4);
                } else {
                    int i8 = this.f55341a;
                    int length = this.f55342b.length;
                    boolean z5 = false;
                    while (i8 < length) {
                        int i9 = i8 + 1;
                        Object obj2 = this.f55342b[i8];
                        this.f55342b[i8] = null;
                        if (lVar.invoke(obj2).booleanValue()) {
                            this.f55342b[i5] = obj2;
                            i8 = i9;
                            i5++;
                        } else {
                            i8 = i9;
                            z5 = true;
                        }
                    }
                    i5 = z(i5);
                    while (i4 < z4) {
                        int i10 = i4 + 1;
                        Object obj3 = this.f55342b[i4];
                        this.f55342b[i4] = null;
                        if (lVar.invoke(obj3).booleanValue()) {
                            this.f55342b[i5] = obj3;
                            i5 = s(i5);
                            i4 = i10;
                        } else {
                            i4 = i10;
                            z5 = true;
                        }
                    }
                    z3 = z5;
                }
                if (z3) {
                    this.f55343c = y(i5 - this.f55341a);
                }
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(int i4) {
        int Td;
        Td = p.Td(this.f55342b);
        if (i4 == Td) {
            return 0;
        }
        return i4 + 1;
    }

    @InlineOnly
    private final E t(int i4) {
        return (E) this.f55342b[i4];
    }

    @InlineOnly
    private final int u(int i4) {
        return z(this.f55341a + i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int y(int i4) {
        return i4 < 0 ? i4 + this.f55342b.length : i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z(int i4) {
        Object[] objArr = this.f55342b;
        return i4 >= objArr.length ? i4 - objArr.length : i4;
    }

    @Nullable
    public final E A() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Nullable
    public final E B() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @NotNull
    public final Object[] C() {
        return toArray();
    }

    @NotNull
    public final <T> T[] D(@NotNull T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        addLast(e4);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(size() + elements.size());
        n(z(this.f55341a + size()), elements);
        return true;
    }

    public final void addFirst(E e4) {
        ensureCapacity(size() + 1);
        int p3 = p(this.f55341a);
        this.f55341a = p3;
        this.f55342b[p3] = e4;
        this.f55343c = size() + 1;
    }

    public final void addLast(E e4) {
        ensureCapacity(size() + 1);
        this.f55342b[z(this.f55341a + size())] = e4;
        this.f55343c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int z3 = z(this.f55341a + size());
        int i4 = this.f55341a;
        if (i4 < z3) {
            o.n2(this.f55342b, null, i4, z3);
        } else if (!isEmpty()) {
            Object[] objArr = this.f55342b;
            o.n2(objArr, null, this.f55341a, objArr.length);
            o.n2(this.f55342b, null, 0, z3);
        }
        this.f55341a = 0;
        this.f55343c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.f55342b[this.f55341a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        c.Companion.b(i4, size());
        return (E) this.f55342b[z(this.f55341a + i4)];
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.f55343c;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i4;
        int z3 = z(this.f55341a + size());
        int i5 = this.f55341a;
        if (i5 < z3) {
            while (i5 < z3) {
                int i6 = i5 + 1;
                if (kotlin.jvm.internal.f0.g(obj, this.f55342b[i5])) {
                    i4 = this.f55341a;
                } else {
                    i5 = i6;
                }
            }
            return -1;
        } else if (i5 < z3) {
            return -1;
        } else {
            int length = this.f55342b.length;
            while (true) {
                if (i5 >= length) {
                    int i7 = 0;
                    while (i7 < z3) {
                        int i8 = i7 + 1;
                        if (kotlin.jvm.internal.f0.g(obj, this.f55342b[i7])) {
                            i5 = i7 + this.f55342b.length;
                            i4 = this.f55341a;
                        } else {
                            i7 = i8;
                        }
                    }
                    return -1;
                }
                int i9 = i5 + 1;
                if (kotlin.jvm.internal.f0.g(obj, this.f55342b[i5])) {
                    i4 = this.f55341a;
                    break;
                }
                i5 = i9;
            }
        }
        return i5 - i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E last() {
        int H;
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        H = CollectionsKt__CollectionsKt.H(this);
        return (E) this.f55342b[z(this.f55341a + H)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int Td;
        int i4;
        int z3 = z(this.f55341a + size());
        int i5 = this.f55341a;
        if (i5 < z3) {
            Td = z3 - 1;
            if (i5 > Td) {
                return -1;
            }
            while (true) {
                int i6 = Td - 1;
                if (kotlin.jvm.internal.f0.g(obj, this.f55342b[Td])) {
                    i4 = this.f55341a;
                    break;
                } else if (Td == i5) {
                    return -1;
                } else {
                    Td = i6;
                }
            }
        } else if (i5 <= z3) {
            return -1;
        } else {
            int i7 = z3 - 1;
            if (i7 >= 0) {
                while (true) {
                    int i8 = i7 - 1;
                    if (kotlin.jvm.internal.f0.g(obj, this.f55342b[i7])) {
                        Td = i7 + this.f55342b.length;
                        i4 = this.f55341a;
                        break;
                    } else if (i8 < 0) {
                        break;
                    } else {
                        i7 = i8;
                    }
                }
            }
            Td = p.Td(this.f55342b);
            int i9 = this.f55341a;
            if (i9 > Td) {
                return -1;
            }
            while (true) {
                int i10 = Td - 1;
                if (kotlin.jvm.internal.f0.g(obj, this.f55342b[Td])) {
                    i4 = this.f55341a;
                    break;
                } else if (Td == i9) {
                    return -1;
                } else {
                    Td = i10;
                }
            }
        }
        return Td - i4;
    }

    @Nullable
    public final E r() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f55342b[this.f55341a];
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
        kotlin.jvm.internal.f0.p(elements, "elements");
        boolean z3 = false;
        z3 = false;
        int i4 = 0;
        z3 = false;
        if (!isEmpty()) {
            if (!(this.f55342b.length == 0)) {
                int z4 = z(this.f55341a + size());
                int i5 = this.f55341a;
                if (this.f55341a < z4) {
                    int i6 = this.f55341a;
                    while (i6 < z4) {
                        int i7 = i6 + 1;
                        Object obj = this.f55342b[i6];
                        if (!elements.contains(obj)) {
                            this.f55342b[i5] = obj;
                            i6 = i7;
                            i5++;
                        } else {
                            i6 = i7;
                            z3 = true;
                        }
                    }
                    o.n2(this.f55342b, null, i5, z4);
                } else {
                    int i8 = this.f55341a;
                    int length = this.f55342b.length;
                    boolean z5 = false;
                    while (i8 < length) {
                        int i9 = i8 + 1;
                        Object obj2 = this.f55342b[i8];
                        this.f55342b[i8] = null;
                        if (!elements.contains(obj2)) {
                            this.f55342b[i5] = obj2;
                            i8 = i9;
                            i5++;
                        } else {
                            i8 = i9;
                            z5 = true;
                        }
                    }
                    i5 = z(i5);
                    while (i4 < z4) {
                        int i10 = i4 + 1;
                        Object obj3 = this.f55342b[i4];
                        this.f55342b[i4] = null;
                        if (!elements.contains(obj3)) {
                            this.f55342b[i5] = obj3;
                            i5 = s(i5);
                            i4 = i10;
                        } else {
                            i4 = i10;
                            z5 = true;
                        }
                    }
                    z3 = z5;
                }
                if (z3) {
                    this.f55343c = y(i5 - this.f55341a);
                }
            }
        }
        return z3;
    }

    @Override // kotlin.collections.f
    public E removeAt(int i4) {
        int H;
        int H2;
        c.Companion.b(i4, size());
        H = CollectionsKt__CollectionsKt.H(this);
        if (i4 == H) {
            return removeLast();
        }
        if (i4 == 0) {
            return removeFirst();
        }
        int z3 = z(this.f55341a + i4);
        E e4 = (E) this.f55342b[z3];
        if (i4 < (size() >> 1)) {
            int i5 = this.f55341a;
            if (z3 >= i5) {
                Object[] objArr = this.f55342b;
                o.c1(objArr, objArr, i5 + 1, i5, z3);
            } else {
                Object[] objArr2 = this.f55342b;
                o.c1(objArr2, objArr2, 1, 0, z3);
                Object[] objArr3 = this.f55342b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f55341a;
                o.c1(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f55342b;
            int i7 = this.f55341a;
            objArr4[i7] = null;
            this.f55341a = s(i7);
        } else {
            H2 = CollectionsKt__CollectionsKt.H(this);
            int z4 = z(this.f55341a + H2);
            if (z3 <= z4) {
                Object[] objArr5 = this.f55342b;
                o.c1(objArr5, objArr5, z3, z3 + 1, z4 + 1);
            } else {
                Object[] objArr6 = this.f55342b;
                o.c1(objArr6, objArr6, z3, z3 + 1, objArr6.length);
                Object[] objArr7 = this.f55342b;
                objArr7[objArr7.length - 1] = objArr7[0];
                o.c1(objArr7, objArr7, 0, 1, z4 + 1);
            }
            this.f55342b[z4] = null;
        }
        this.f55343c = size() - 1;
        return e4;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E e4 = (E) this.f55342b[this.f55341a];
            Object[] objArr = this.f55342b;
            int i4 = this.f55341a;
            objArr[i4] = null;
            this.f55341a = s(i4);
            this.f55343c = size() - 1;
            return e4;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        int H;
        if (!isEmpty()) {
            H = CollectionsKt__CollectionsKt.H(this);
            int z3 = z(this.f55341a + H);
            E e4 = (E) this.f55342b[z3];
            this.f55342b[z3] = null;
            this.f55343c = size() - 1;
            return e4;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        boolean z3 = false;
        z3 = false;
        int i4 = 0;
        z3 = false;
        if (!isEmpty()) {
            if (!(this.f55342b.length == 0)) {
                int z4 = z(this.f55341a + size());
                int i5 = this.f55341a;
                if (this.f55341a < z4) {
                    int i6 = this.f55341a;
                    while (i6 < z4) {
                        int i7 = i6 + 1;
                        Object obj = this.f55342b[i6];
                        if (elements.contains(obj)) {
                            this.f55342b[i5] = obj;
                            i6 = i7;
                            i5++;
                        } else {
                            i6 = i7;
                            z3 = true;
                        }
                    }
                    o.n2(this.f55342b, null, i5, z4);
                } else {
                    int i8 = this.f55341a;
                    int length = this.f55342b.length;
                    boolean z5 = false;
                    while (i8 < length) {
                        int i9 = i8 + 1;
                        Object obj2 = this.f55342b[i8];
                        this.f55342b[i8] = null;
                        if (elements.contains(obj2)) {
                            this.f55342b[i5] = obj2;
                            i8 = i9;
                            i5++;
                        } else {
                            i8 = i9;
                            z5 = true;
                        }
                    }
                    i5 = z(i5);
                    while (i4 < z4) {
                        int i10 = i4 + 1;
                        Object obj3 = this.f55342b[i4];
                        this.f55342b[i4] = null;
                        if (elements.contains(obj3)) {
                            this.f55342b[i5] = obj3;
                            i5 = s(i5);
                            i4 = i10;
                        } else {
                            i4 = i10;
                            z5 = true;
                        }
                    }
                    z3 = z5;
                }
                if (z3) {
                    this.f55343c = y(i5 - this.f55341a);
                }
            }
        }
        return z3;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        c.Companion.b(i4, size());
        int z3 = z(this.f55341a + i4);
        E e5 = (E) this.f55342b[z3];
        this.f55342b[z3] = e4;
        return e5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) m.a(array, size());
        }
        int z3 = z(this.f55341a + size());
        int i4 = this.f55341a;
        if (i4 < z3) {
            o.l1(this.f55342b, array, 0, i4, z3, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f55342b;
            o.c1(objArr, array, 0, this.f55341a, objArr.length);
            Object[] objArr2 = this.f55342b;
            o.c1(objArr2, array, objArr2.length - this.f55341a, 0, z3);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public final void w(@NotNull d2.p<? super Integer, ? super Object[], kotlin.f1> structure) {
        int i4;
        kotlin.jvm.internal.f0.p(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i4 = this.f55341a) < z(this.f55341a + size())) ? this.f55341a : i4 - this.f55342b.length), toArray());
    }

    @Nullable
    public final E x() {
        int H;
        if (isEmpty()) {
            return null;
        }
        H = CollectionsKt__CollectionsKt.H(this);
        return (E) this.f55342b[z(this.f55341a + H)];
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        c.Companion.c(i4, size());
        if (i4 == size()) {
            addLast(e4);
        } else if (i4 == 0) {
            addFirst(e4);
        } else {
            ensureCapacity(size() + 1);
            int z3 = z(this.f55341a + i4);
            if (i4 < ((size() + 1) >> 1)) {
                int p3 = p(z3);
                int p4 = p(this.f55341a);
                int i5 = this.f55341a;
                if (p3 >= i5) {
                    Object[] objArr = this.f55342b;
                    objArr[p4] = objArr[i5];
                    o.c1(objArr, objArr, i5, i5 + 1, p3 + 1);
                } else {
                    Object[] objArr2 = this.f55342b;
                    o.c1(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                    Object[] objArr3 = this.f55342b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    o.c1(objArr3, objArr3, 0, 1, p3 + 1);
                }
                this.f55342b[p3] = e4;
                this.f55341a = p4;
            } else {
                int z4 = z(this.f55341a + size());
                if (z3 < z4) {
                    Object[] objArr4 = this.f55342b;
                    o.c1(objArr4, objArr4, z3 + 1, z3, z4);
                } else {
                    Object[] objArr5 = this.f55342b;
                    o.c1(objArr5, objArr5, 1, 0, z4);
                    Object[] objArr6 = this.f55342b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    o.c1(objArr6, objArr6, z3 + 1, z3, objArr6.length - 1);
                }
                this.f55342b[z3] = e4;
            }
            this.f55343c = size() + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, @NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        c.Companion.c(i4, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i4 == size()) {
            return addAll(elements);
        }
        ensureCapacity(size() + elements.size());
        int z3 = z(this.f55341a + size());
        int z4 = z(this.f55341a + i4);
        int size = elements.size();
        if (i4 < ((size() + 1) >> 1)) {
            int i5 = this.f55341a;
            int i6 = i5 - size;
            if (z4 < i5) {
                Object[] objArr = this.f55342b;
                o.c1(objArr, objArr, i6, i5, objArr.length);
                if (size >= z4) {
                    Object[] objArr2 = this.f55342b;
                    o.c1(objArr2, objArr2, objArr2.length - size, 0, z4);
                } else {
                    Object[] objArr3 = this.f55342b;
                    o.c1(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f55342b;
                    o.c1(objArr4, objArr4, 0, size, z4);
                }
            } else if (i6 >= 0) {
                Object[] objArr5 = this.f55342b;
                o.c1(objArr5, objArr5, i6, i5, z4);
            } else {
                Object[] objArr6 = this.f55342b;
                i6 += objArr6.length;
                int i7 = z4 - i5;
                int length = objArr6.length - i6;
                if (length >= i7) {
                    o.c1(objArr6, objArr6, i6, i5, z4);
                } else {
                    o.c1(objArr6, objArr6, i6, i5, i5 + length);
                    Object[] objArr7 = this.f55342b;
                    o.c1(objArr7, objArr7, 0, this.f55341a + length, z4);
                }
            }
            this.f55341a = i6;
            n(y(z4 - size), elements);
        } else {
            int i8 = z4 + size;
            if (z4 < z3) {
                int i9 = size + z3;
                Object[] objArr8 = this.f55342b;
                if (i9 <= objArr8.length) {
                    o.c1(objArr8, objArr8, i8, z4, z3);
                } else if (i8 >= objArr8.length) {
                    o.c1(objArr8, objArr8, i8 - objArr8.length, z4, z3);
                } else {
                    int length2 = z3 - (i9 - objArr8.length);
                    o.c1(objArr8, objArr8, 0, length2, z3);
                    Object[] objArr9 = this.f55342b;
                    o.c1(objArr9, objArr9, i8, z4, length2);
                }
            } else {
                Object[] objArr10 = this.f55342b;
                o.c1(objArr10, objArr10, size, 0, z3);
                Object[] objArr11 = this.f55342b;
                if (i8 >= objArr11.length) {
                    o.c1(objArr11, objArr11, i8 - objArr11.length, z4, objArr11.length);
                } else {
                    o.c1(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f55342b;
                    o.c1(objArr12, objArr12, i8, z4, objArr12.length - size);
                }
            }
            n(z4, elements);
        }
        return true;
    }

    public k() {
        this.f55342b = f55338e;
    }

    public k(@NotNull Collection<? extends E> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        if (array != null) {
            this.f55342b = array;
            this.f55343c = array.length;
            if (array.length == 0) {
                this.f55342b = f55338e;
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
