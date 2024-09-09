package androidx.core.content.res;

import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i4, T t3) {
        if (i4 + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i4));
            System.arraycopy(tArr, 0, r02, 0, i4);
            tArr = r02;
        }
        tArr[i4] = t3;
        return tArr;
    }

    public static int growSize(int i4) {
        if (i4 <= 4) {
            return 8;
        }
        return i4 * 2;
    }

    public static <T> T[] insert(T[] tArr, int i4, int i5, T t3) {
        if (i4 + 1 <= tArr.length) {
            System.arraycopy(tArr, i5, tArr, i5 + 1, i4 - i5);
            tArr[i5] = t3;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i4)));
        System.arraycopy(tArr, 0, tArr2, 0, i5);
        tArr2[i5] = t3;
        System.arraycopy(tArr, i5, tArr2, i5 + 1, tArr.length - i5);
        return tArr2;
    }

    public static int[] append(int[] iArr, int i4, int i5) {
        if (i4 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i4)];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            iArr = iArr2;
        }
        iArr[i4] = i5;
        return iArr;
    }

    public static int[] insert(int[] iArr, int i4, int i5, int i6) {
        if (i4 + 1 <= iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i4 - i5);
            iArr[i5] = i6;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i4)];
        System.arraycopy(iArr, 0, iArr2, 0, i5);
        iArr2[i5] = i6;
        System.arraycopy(iArr, i5, iArr2, i5 + 1, iArr.length - i5);
        return iArr2;
    }

    public static long[] append(long[] jArr, int i4, long j4) {
        if (i4 + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i4)];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            jArr = jArr2;
        }
        jArr[i4] = j4;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i4, boolean z3) {
        if (i4 + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i4)];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            zArr = zArr2;
        }
        zArr[i4] = z3;
        return zArr;
    }

    public static long[] insert(long[] jArr, int i4, int i5, long j4) {
        if (i4 + 1 <= jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i4 - i5);
            jArr[i5] = j4;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i4)];
        System.arraycopy(jArr, 0, jArr2, 0, i5);
        jArr2[i5] = j4;
        System.arraycopy(jArr, i5, jArr2, i5 + 1, jArr.length - i5);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i4, int i5, boolean z3) {
        if (i4 + 1 <= zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i4 - i5);
            zArr[i5] = z3;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i4)];
        System.arraycopy(zArr, 0, zArr2, 0, i5);
        zArr2[i5] = z3;
        System.arraycopy(zArr, i5, zArr2, i5 + 1, zArr.length - i5);
        return zArr2;
    }
}
