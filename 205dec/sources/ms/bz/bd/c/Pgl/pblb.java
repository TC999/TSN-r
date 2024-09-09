package ms.bz.bd.c.Pgl;

import android.util.SparseArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pblb {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<pgla> f61431a = new SparseArray<>();

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class pgla {
        public Object a(int i4, int i5, long j4, String str, Object obj) throws Throwable {
            return b(i5, j4, str, obj);
        }

        protected Object b(int i4, long j4, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object a(int i4, int i5, long j4, String str, Object obj) {
        return pblk.a(i4, i5, j4, str, obj);
    }

    public static Object b(int i4, String str) {
        return pblk.a(i4, 0, 0L, str, null);
    }

    public static void c(int i4, pgla pglaVar) {
        SparseArray<pgla> sparseArray = f61431a;
        pgla pglaVar2 = sparseArray.get(i4);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0L, "de549a", new byte[]{48, 116, 6, 72, 7, 114, 39, 70, 97, 97, 123, 39, 84, 69, 1, Byte.MAX_VALUE, 116, 80, 97, 118, 59}), pglaVar2.toString()));
        }
        sparseArray.put(i4, pglaVar);
    }

    public static Object d(int i4, int i5, long j4, String str, Object obj) {
        pgla pglaVar = f61431a.get(i4);
        if (pglaVar != null) {
            try {
                return pglaVar.a(i4, i5, j4, str, obj);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
        throw new RuntimeException(String.format((String) pblk.a(16777217, 0, 0L, "d3355d", new byte[]{122, 33, 0, 66, 5, 119, 98, 82, 39, 97, 53, 56, 83, 1, 3, 125, 113, 19, 110, 108, 113}), Integer.valueOf(i4)));
    }
}
