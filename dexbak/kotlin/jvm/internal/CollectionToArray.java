package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0080\u0001\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\n2(\u0010\u000e\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\rH\u0082\b¢\u0006\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011\"\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013¨\u0006\u0015"}, m12616d2 = {"", "collection", "", "", "a", "(Ljava/util/Collection;)[Ljava/lang/Object;", "b", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "Lkotlin/Function0;", "empty", "Lkotlin/Function1;", "", "alloc", "Lkotlin/Function2;", "trim", "c", "(Ljava/util/Collection;Ll1/a;Ll1/l;Ll1/p;)[Ljava/lang/Object;", "[Ljava/lang/Object;", "EMPTY", "I", "MAX_SIZE", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "CollectionToArray")
/* renamed from: kotlin.jvm.internal.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CollectionToArray {

    /* renamed from: a */
    private static final Object[] f41191a = new Object[0];

    /* renamed from: b */
    private static final int f41192b = 2147483645;

    @JvmName(name = "toArray")
    @NotNull
    /* renamed from: a */
    public static final Object[] m8043a(@NotNull Collection<?> collection) {
        C14342f0.m8184p(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArr = new Object[size];
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    objArr[i] = it.next();
                    if (i2 >= objArr.length) {
                        if (!it.hasNext()) {
                            return objArr;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            if (i2 >= f41192b) {
                                throw new OutOfMemoryError();
                            }
                            i3 = f41192b;
                        }
                        objArr = Arrays.copyOf(objArr, i3);
                        C14342f0.m8185o(objArr, "Arrays.copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] copyOf = Arrays.copyOf(objArr, i2);
                        C14342f0.m8185o(copyOf, "Arrays.copyOf(result, size)");
                        return copyOf;
                    }
                    i = i2;
                }
            }
        }
        return f41191a;
    }

    @JvmName(name = "toArray")
    @NotNull
    /* renamed from: b */
    public static final Object[] m8042b(@NotNull Collection<?> collection, @Nullable Object[] objArr) {
        Object[] objArr2;
        C14342f0.m8184p(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i = 0;
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
            int i2 = i + 1;
            objArr2[i] = it.next();
            if (i2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= f41192b) {
                        throw new OutOfMemoryError();
                    }
                    i3 = f41192b;
                }
                objArr2 = Arrays.copyOf(objArr2, i3);
                C14342f0.m8185o(objArr2, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[i2] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i2);
                C14342f0.m8185o(copyOf, "Arrays.copyOf(result, size)");
                return copyOf;
            }
            i = i2;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* renamed from: c */
    private static final Object[] m8041c(Collection<?> collection, InterfaceC15269a<Object[]> interfaceC15269a, InterfaceC15280l<? super Integer, Object[]> interfaceC15280l, InterfaceC15284p<? super Object[], ? super Integer, Object[]> interfaceC15284p) {
        int size = collection.size();
        if (size == 0) {
            return interfaceC15269a.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return interfaceC15269a.invoke();
        }
        int i = 0;
        ?? r3 = interfaceC15280l.invoke(Integer.valueOf(size));
        while (true) {
            int i2 = i + 1;
            r3[i] = it.next();
            if (i2 >= r3.length) {
                if (!it.hasNext()) {
                    return r3;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= f41192b) {
                        throw new OutOfMemoryError();
                    }
                    i3 = f41192b;
                }
                r3 = Arrays.copyOf((Object[]) r3, i3);
                C14342f0.m8185o(r3, "Arrays.copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return interfaceC15284p.invoke(r3, Integer.valueOf(i2));
            }
            i = i2;
            r3 = r3;
        }
    }
}
