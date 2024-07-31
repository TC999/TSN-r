package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.C14372l0;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned._UArrays;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001aI\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\t*\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u000f\u001a\u00028\u0001\"\u0010\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u0001*\u00028\u0001\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0010\u0010\u0011\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a#\u0010\u0015\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a?\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "j", "([[Ljava/lang/Object;)Ljava/util/List;", "R", "Lkotlin/Pair;", "m", "([Lkotlin/Pair;)Lkotlin/Pair;", "", C7304t.f25048d, "([Ljava/lang/Object;)Z", "C", "Lkotlin/Function0;", "defaultValue", "k", "([Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", AdnName.OTHER, "g", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "", "h", "([Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", CommonNetImpl.RESULT, "", "processed", "Lkotlin/f1;", "i", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/ArraysKt")
/* renamed from: kotlin.collections.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class Arrays extends ArraysJVM {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    /* renamed from: g */
    public static final <T> boolean m11785g(@Nullable T[] tArr, @Nullable T[] tArr2) {
        boolean m9048z0;
        boolean m9102v0;
        boolean m9115u0;
        boolean m9076x0;
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if ((t instanceof Object[]) && (t2 instanceof Object[])) {
                    if (!m11785g((Object[]) t, (Object[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof byte[]) && (t2 instanceof byte[])) {
                    if (!java.util.Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof short[]) && (t2 instanceof short[])) {
                    if (!java.util.Arrays.equals((short[]) t, (short[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof int[]) && (t2 instanceof int[])) {
                    if (!java.util.Arrays.equals((int[]) t, (int[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof long[]) && (t2 instanceof long[])) {
                    if (!java.util.Arrays.equals((long[]) t, (long[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof float[]) && (t2 instanceof float[])) {
                    if (!java.util.Arrays.equals((float[]) t, (float[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof double[]) && (t2 instanceof double[])) {
                    if (!java.util.Arrays.equals((double[]) t, (double[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof char[]) && (t2 instanceof char[])) {
                    if (!java.util.Arrays.equals((char[]) t, (char[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof boolean[]) && (t2 instanceof boolean[])) {
                    if (!java.util.Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof UByteArray) && (t2 instanceof UByteArray)) {
                    m9076x0 = _UArrays.m9076x0(((UByteArray) t).m7739t(), ((UByteArray) t2).m7739t());
                    if (!m9076x0) {
                        return false;
                    }
                } else if ((t instanceof UShortArray) && (t2 instanceof UShortArray)) {
                    m9115u0 = _UArrays.m9115u0(((UShortArray) t).m12483t(), ((UShortArray) t2).m12483t());
                    if (!m9115u0) {
                        return false;
                    }
                } else if ((t instanceof UIntArray) && (t2 instanceof UIntArray)) {
                    m9102v0 = _UArrays.m9102v0(((UIntArray) t).m7275t(), ((UIntArray) t2).m7275t());
                    if (!m9102v0) {
                        return false;
                    }
                } else if ((t instanceof ULongArray) && (t2 instanceof ULongArray)) {
                    m9048z0 = _UArrays.m9048z0(((ULongArray) t).m5815t(), ((ULongArray) t2).m5815t());
                    if (!m9048z0) {
                        return false;
                    }
                } else if (!C14342f0.m8193g(t, t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    /* renamed from: h */
    public static final <T> String m11784h(@Nullable T[] tArr) {
        int m7460u;
        if (tArr == null) {
            return "null";
        }
        m7460u = _Ranges.m7460u(tArr.length, 429496729);
        StringBuilder sb = new StringBuilder((m7460u * 5) + 2);
        m11783i(tArr, sb, new ArrayList());
        String sb2 = sb.toString();
        C14342f0.m8185o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* renamed from: i */
    private static final <T> void m11783i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        int m12476G;
        String m9500R0;
        String m9542O0;
        String m9528P0;
        String m9584L0;
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            T t = tArr[i];
            if (t == null) {
                sb.append("null");
            } else if (t instanceof Object[]) {
                m11783i((Object[]) t, sb, list);
            } else if (t instanceof byte[]) {
                String arrays = java.util.Arrays.toString((byte[]) t);
                C14342f0.m8185o(arrays, "java.util.Arrays.toString(this)");
                sb.append(arrays);
            } else if (t instanceof short[]) {
                String arrays2 = java.util.Arrays.toString((short[]) t);
                C14342f0.m8185o(arrays2, "java.util.Arrays.toString(this)");
                sb.append(arrays2);
            } else if (t instanceof int[]) {
                String arrays3 = java.util.Arrays.toString((int[]) t);
                C14342f0.m8185o(arrays3, "java.util.Arrays.toString(this)");
                sb.append(arrays3);
            } else if (t instanceof long[]) {
                String arrays4 = java.util.Arrays.toString((long[]) t);
                C14342f0.m8185o(arrays4, "java.util.Arrays.toString(this)");
                sb.append(arrays4);
            } else if (t instanceof float[]) {
                String arrays5 = java.util.Arrays.toString((float[]) t);
                C14342f0.m8185o(arrays5, "java.util.Arrays.toString(this)");
                sb.append(arrays5);
            } else if (t instanceof double[]) {
                String arrays6 = java.util.Arrays.toString((double[]) t);
                C14342f0.m8185o(arrays6, "java.util.Arrays.toString(this)");
                sb.append(arrays6);
            } else if (t instanceof char[]) {
                String arrays7 = java.util.Arrays.toString((char[]) t);
                C14342f0.m8185o(arrays7, "java.util.Arrays.toString(this)");
                sb.append(arrays7);
            } else if (t instanceof boolean[]) {
                String arrays8 = java.util.Arrays.toString((boolean[]) t);
                C14342f0.m8185o(arrays8, "java.util.Arrays.toString(this)");
                sb.append(arrays8);
            } else if (t instanceof UByteArray) {
                m9584L0 = _UArrays.m9584L0(((UByteArray) t).m7739t());
                sb.append(m9584L0);
            } else if (t instanceof UShortArray) {
                m9528P0 = _UArrays.m9528P0(((UShortArray) t).m12483t());
                sb.append(m9528P0);
            } else if (t instanceof UIntArray) {
                m9542O0 = _UArrays.m9542O0(((UIntArray) t).m7275t());
                sb.append(m9542O0);
            } else if (t instanceof ULongArray) {
                m9500R0 = _UArrays.m9500R0(((ULongArray) t).m5815t());
                sb.append(m9500R0);
            } else {
                sb.append(t.toString());
            }
        }
        sb.append(']');
        m12476G = CollectionsKt__CollectionsKt.m12476G(list);
        list.remove(m12476G);
    }

    @NotNull
    /* renamed from: j */
    public static final <T> List<T> m11782j(@NotNull T[][] flatten) {
        C14342f0.m8184p(flatten, "$this$flatten");
        int i = 0;
        for (T[] tArr : flatten) {
            i += tArr.length;
        }
        ArrayList arrayList = new ArrayList(i);
        for (T[] tArr2 : flatten) {
            MutableCollections.m12414s0(arrayList, tArr2);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Ll1/a<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: k */
    private static final Object m11781k(Object[] objArr, InterfaceC15269a interfaceC15269a) {
        return objArr.length == 0 ? interfaceC15269a.invoke() : objArr;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: l */
    private static final boolean m11780l(Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    /* renamed from: m */
    public static final <T, R> Tuples<List<T>, List<R>> m11779m(@NotNull Tuples<? extends T, ? extends R>[] unzip) {
        C14342f0.m8184p(unzip, "$this$unzip");
        ArrayList arrayList = new ArrayList(unzip.length);
        ArrayList arrayList2 = new ArrayList(unzip.length);
        for (Tuples<? extends T, ? extends R> tuples : unzip) {
            arrayList.add(tuples.getFirst());
            arrayList2.add(tuples.getSecond());
        }
        return C14372l0.m7952a(arrayList, arrayList2);
    }
}
