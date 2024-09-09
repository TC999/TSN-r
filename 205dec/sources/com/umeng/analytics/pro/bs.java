package com.umeng.analytics.pro;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TBaseHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bs {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator f52738a = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: TBaseHelper.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return bs.a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return bs.a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return bs.a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return bs.a((byte[]) obj, (byte[]) obj2);
            }
            return bs.a((Comparable) obj, (Comparable) obj2);
        }
    }

    private bs() {
    }

    public static int a(byte b4, byte b5) {
        if (b4 < b5) {
            return -1;
        }
        return b5 < b4 ? 1 : 0;
    }

    public static int a(double d4, double d5) {
        if (d4 < d5) {
            return -1;
        }
        return d5 < d4 ? 1 : 0;
    }

    public static int a(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        return i5 < i4 ? 1 : 0;
    }

    public static int a(long j4, long j5) {
        if (j4 < j5) {
            return -1;
        }
        return j5 < j4 ? 1 : 0;
    }

    public static int a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    public static int a(short s3, short s4) {
        if (s3 < s4) {
            return -1;
        }
        return s4 < s3 ? 1 : 0;
    }

    public static boolean b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(a(byteBuffer));
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(new byte[byteBuffer.remaining()]);
        if (byteBuffer.hasArray()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), wrap.array(), 0, byteBuffer.remaining());
        } else {
            byteBuffer.slice().get(wrap.array());
        }
        return wrap;
    }

    public static int a(boolean z3, boolean z4) {
        return Boolean.valueOf(z3).compareTo(Boolean.valueOf(z4));
    }

    public static int a(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        int a4 = a(bArr.length, bArr2.length);
        if (a4 != 0) {
            return a4;
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int a5 = a(bArr[i4], bArr2[i4]);
            if (a5 != 0) {
                return a5;
            }
        }
        return 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(List list, List list2) {
        int a4 = a(list.size(), list2.size());
        if (a4 != 0) {
            return a4;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            int compare = f52738a.compare(list.get(i4), list2.get(i4));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Set set, Set set2) {
        int a4 = a(set.size(), set2.size());
        if (a4 != 0) {
            return a4;
        }
        Comparator comparator = f52738a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f52738a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int a(Map map, Map map2) {
        int a4 = a(map.size(), map2.size());
        if (a4 != 0) {
            return a4;
        }
        Comparator comparator = f52738a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = f52738a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = arrayOffset + byteBuffer.limit();
        int i4 = limit - position > 128 ? position + 128 : limit;
        for (int i5 = position; i5 < i4; i5++) {
            if (i5 > position) {
                sb.append(" ");
            }
            sb.append(a(array[i5]));
        }
        if (limit != i4) {
            sb.append("...");
        }
    }

    public static String a(byte b4) {
        return Integer.toHexString((b4 | 256) & 511).toUpperCase().substring(1);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        if (b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        a(byteBuffer, bArr, 0);
        return bArr;
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i4) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i4, remaining);
        return remaining;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
