package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CollectionToArray.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0080\u0001\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\n2(\u0010\u000e\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\rH\u0082\b\u00a2\u0006\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"", "collection", "", "", "a", "(Ljava/util/Collection;)[Ljava/lang/Object;", "b", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "Lkotlin/Function0;", "empty", "Lkotlin/Function1;", "", "alloc", "Lkotlin/Function2;", "trim", "c", "(Ljava/util/Collection;Ld2/a;Ld2/l;Ld2/p;)[Ljava/lang/Object;", "[Ljava/lang/Object;", "EMPTY", "I", "MAX_SIZE", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "CollectionToArray")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f55681a = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    private static final int f55682b = 2147483645;

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] a(@NotNull Collection<?> collection) {
        f0.p(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    objArr[i4] = it.next();
                    if (i5 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i6 = ((i5 * 3) + 1) >>> 1;
                        if (i6 <= i5) {
                            if (i5 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                            i6 = 2147483645;
                        }
                        objArr = Arrays.copyOf(objArr, i6);
                        f0.o(objArr, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i5);
                        f0.o(copyOf, "copyOf(result, size)");
                        return copyOf;
                    }
                    i4 = i5;
                }
            }
        }
        return f55681a;
    }

    @JvmName(name = "toArray")
    @NotNull
    public static final Object[] b(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        f0.p(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i4 = 0;
        if (size == 0) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length > 0) {
                objArr[0] = null;
                return objArr;
            }
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int i5 = i4 + 1;
            objArr2[i4] = it.next();
            if (i5 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i6 = ((i5 * 3) + 1) >>> 1;
                if (i6 <= i5) {
                    if (i5 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i6 = 2147483645;
                }
                objArr2 = Arrays.copyOf(objArr2, i6);
                f0.o(objArr2, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i5] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i5);
                f0.o(copyOf, "copyOf(result, size)");
                return copyOf;
            }
            i4 = i5;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] c(Collection<?> collection, d2.a<Object[]> aVar, d2.l<? super Integer, Object[]> lVar, d2.p<? super Object[], ? super Integer, Object[]> pVar) {
        int size = collection.size();
        if (size == 0) {
            return aVar.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return aVar.invoke();
        }
        int i4 = 0;
        ?? r3 = lVar.invoke(Integer.valueOf(size));
        while (true) {
            int i5 = i4 + 1;
            r3[i4] = it.next();
            if (i5 >= r3.length) {
                if (!it.hasNext()) {
                    return r3;
                }
                int i6 = ((i5 * 3) + 1) >>> 1;
                if (i6 <= i5) {
                    if (i5 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                    i6 = 2147483645;
                }
                r3 = Arrays.copyOf((Object[]) r3, i6);
                f0.o(r3, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return pVar.invoke(r3, Integer.valueOf(i5));
            }
            i4 = i5;
            r3 = r3;
        }
    }
}
