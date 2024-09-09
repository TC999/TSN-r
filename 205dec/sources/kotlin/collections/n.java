package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Arrays.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u000f\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u0001*\u00028\u0001\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a?\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001aH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001f"}, d2 = {"T", "", "", "j", "([[Ljava/lang/Object;)Ljava/util/List;", "R", "Lkotlin/Pair;", "m", "([Lkotlin/Pair;)Lkotlin/Pair;", "", "l", "([Ljava/lang/Object;)Z", "C", "Lkotlin/Function0;", "defaultValue", "k", "([Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "other", "g", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "", "h", "([Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "Lkotlin/f1;", "i", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/ArraysKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class n extends m {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean g(@Nullable T[] tArr, @Nullable T[] tArr2) {
        boolean z02;
        boolean v02;
        boolean u02;
        boolean x02;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            T t3 = tArr[i4];
            T t4 = tArr2[i4];
            if (t3 != t4) {
                if (t3 == null || t4 == null) {
                    return false;
                }
                if ((t3 instanceof Object[]) && (t4 instanceof Object[])) {
                    if (!g((Object[]) t3, (Object[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof byte[]) && (t4 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) t3, (byte[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof short[]) && (t4 instanceof short[])) {
                    if (!Arrays.equals((short[]) t3, (short[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof int[]) && (t4 instanceof int[])) {
                    if (!Arrays.equals((int[]) t3, (int[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof long[]) && (t4 instanceof long[])) {
                    if (!Arrays.equals((long[]) t3, (long[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof float[]) && (t4 instanceof float[])) {
                    if (!Arrays.equals((float[]) t3, (float[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof double[]) && (t4 instanceof double[])) {
                    if (!Arrays.equals((double[]) t3, (double[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof char[]) && (t4 instanceof char[])) {
                    if (!Arrays.equals((char[]) t3, (char[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof boolean[]) && (t4 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) t3, (boolean[]) t4)) {
                        return false;
                    }
                } else if ((t3 instanceof kotlin.o0) && (t4 instanceof kotlin.o0)) {
                    x02 = kotlin.collections.unsigned.c.x0(((kotlin.o0) t3).A(), ((kotlin.o0) t4).A());
                    if (!x02) {
                        return false;
                    }
                } else if ((t3 instanceof kotlin.c1) && (t4 instanceof kotlin.c1)) {
                    u02 = kotlin.collections.unsigned.c.u0(((kotlin.c1) t3).A(), ((kotlin.c1) t4).A());
                    if (!u02) {
                        return false;
                    }
                } else if ((t3 instanceof kotlin.s0) && (t4 instanceof kotlin.s0)) {
                    v02 = kotlin.collections.unsigned.c.v0(((kotlin.s0) t3).A(), ((kotlin.s0) t4).A());
                    if (!v02) {
                        return false;
                    }
                } else if ((t3 instanceof kotlin.w0) && (t4 instanceof kotlin.w0)) {
                    z02 = kotlin.collections.unsigned.c.z0(((kotlin.w0) t3).A(), ((kotlin.w0) t4).A());
                    if (!z02) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.f0.g(t3, t4)) {
                    return false;
                }
            }
            i4 = i5;
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    public static final <T> String h(@Nullable T[] tArr) {
        int u3;
        if (tArr == null) {
            return "null";
        }
        u3 = kotlin.ranges.q.u(tArr.length, 429496729);
        StringBuilder sb = new StringBuilder((u3 * 5) + 2);
        i(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder(capacity).\u2026builderAction).toString()");
        return sb2;
    }

    private static final <T> void i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        int H;
        String R0;
        String O0;
        String P0;
        String L0;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int i4 = 0;
        int length = tArr.length;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (i4 != 0) {
                sb.append(", ");
            }
            T t3 = tArr[i4];
            if (t3 == null) {
                sb.append("null");
            } else if (t3 instanceof Object[]) {
                i((Object[]) t3, sb, list);
            } else if (t3 instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t3);
                kotlin.jvm.internal.f0.o(arrays, "toString(this)");
                sb.append(arrays);
            } else if (t3 instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t3);
                kotlin.jvm.internal.f0.o(arrays2, "toString(this)");
                sb.append(arrays2);
            } else if (t3 instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t3);
                kotlin.jvm.internal.f0.o(arrays3, "toString(this)");
                sb.append(arrays3);
            } else if (t3 instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t3);
                kotlin.jvm.internal.f0.o(arrays4, "toString(this)");
                sb.append(arrays4);
            } else if (t3 instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t3);
                kotlin.jvm.internal.f0.o(arrays5, "toString(this)");
                sb.append(arrays5);
            } else if (t3 instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t3);
                kotlin.jvm.internal.f0.o(arrays6, "toString(this)");
                sb.append(arrays6);
            } else if (t3 instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t3);
                kotlin.jvm.internal.f0.o(arrays7, "toString(this)");
                sb.append(arrays7);
            } else if (t3 instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t3);
                kotlin.jvm.internal.f0.o(arrays8, "toString(this)");
                sb.append(arrays8);
            } else if (t3 instanceof kotlin.o0) {
                L0 = kotlin.collections.unsigned.c.L0(((kotlin.o0) t3).A());
                sb.append(L0);
            } else if (t3 instanceof kotlin.c1) {
                P0 = kotlin.collections.unsigned.c.P0(((kotlin.c1) t3).A());
                sb.append(P0);
            } else if (t3 instanceof kotlin.s0) {
                O0 = kotlin.collections.unsigned.c.O0(((kotlin.s0) t3).A());
                sb.append(O0);
            } else if (t3 instanceof kotlin.w0) {
                R0 = kotlin.collections.unsigned.c.R0(((kotlin.w0) t3).A());
                sb.append(R0);
            } else {
                sb.append(t3.toString());
            }
            i4 = i5;
        }
        sb.append(']');
        H = CollectionsKt__CollectionsKt.H(list);
        list.remove(H);
    }

    @NotNull
    public static final <T> List<T> j(@NotNull T[][] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = tArr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            T[] tArr2 = tArr[i5];
            i5++;
            i6 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i6);
        int length2 = tArr.length;
        while (i4 < length2) {
            T[] tArr3 = tArr[i4];
            i4++;
            c0.q0(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Ld2/a<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object k(Object[] objArr, d2.a defaultValue) {
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean l(Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> m(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        kotlin.jvm.internal.f0.p(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        int length = pairArr.length;
        int i4 = 0;
        while (i4 < length) {
            Pair<? extends T, ? extends R> pair = pairArr[i4];
            i4++;
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.l0.a(arrayList, arrayList2);
    }
}
