package com.umeng.analytics.pro;

import androidx.core.app.FrameMetricsAggregator;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.umeng.analytics.pro.bs */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class TBaseHelper {

    /* renamed from: a */
    private static final Comparator f37952a = new C13133a();

    /* compiled from: TBaseHelper.java */
    /* renamed from: com.umeng.analytics.pro.bs$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13133a implements Comparator {
        private C13133a() {
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
                return TBaseHelper.m14533a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return TBaseHelper.m14531a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return TBaseHelper.m14532a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return TBaseHelper.m14527a((byte[]) obj, (byte[]) obj2);
            }
            return TBaseHelper.m14539a((Comparable) obj, (Comparable) obj2);
        }
    }

    private TBaseHelper() {
    }

    /* renamed from: a */
    public static int m14543a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    /* renamed from: a */
    public static int m14542a(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        return d2 < d ? 1 : 0;
    }

    /* renamed from: a */
    public static int m14541a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* renamed from: a */
    public static int m14540a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    /* renamed from: a */
    public static int m14538a(Object obj, Object obj2) {
        if (obj instanceof Comparable) {
            return m14539a((Comparable) obj, (Comparable) obj2);
        }
        if (obj instanceof List) {
            return m14533a((List) obj, (List) obj2);
        }
        if (obj instanceof Set) {
            return m14531a((Set) obj, (Set) obj2);
        }
        if (obj instanceof Map) {
            return m14532a((Map) obj, (Map) obj2);
        }
        if (obj instanceof byte[]) {
            return m14527a((byte[]) obj, (byte[]) obj2);
        }
        throw new IllegalArgumentException("Cannot compare objects of type " + obj.getClass());
    }

    /* renamed from: a */
    public static int m14530a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: b */
    public static boolean m14526b(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: c */
    public static ByteBuffer m14525c(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        return m14526b(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m14536a(byteBuffer));
    }

    /* renamed from: d */
    public static ByteBuffer m14524d(ByteBuffer byteBuffer) {
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

    /* renamed from: a */
    public static int m14529a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m14537a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m14527a(byte[] bArr, byte[] bArr2) {
        int m14541a = m14541a(bArr.length, bArr2.length);
        if (m14541a != 0) {
            return m14541a;
        }
        for (int i = 0; i < bArr.length; i++) {
            int m14543a = m14543a(bArr[i], bArr2[i]);
            if (m14543a != 0) {
                return m14543a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m14539a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m14533a(List list, List list2) {
        int m14541a = m14541a(list.size(), list2.size());
        if (m14541a != 0) {
            return m14541a;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f37952a.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m14531a(Set set, Set set2) {
        int m14541a = m14541a(set.size(), set2.size());
        if (m14541a != 0) {
            return m14541a;
        }
        Comparator comparator = f37952a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f37952a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m14532a(Map map, Map map2) {
        int m14541a = m14541a(map.size(), map2.size());
        if (m14541a != 0) {
            return m14541a;
        }
        Comparator comparator = f37952a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = f37952a;
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

    /* renamed from: a */
    public static void m14535a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int position = byteBuffer.position() + arrayOffset;
        int limit = arrayOffset + byteBuffer.limit();
        int i = limit - position > 128 ? position + 128 : limit;
        for (int i2 = position; i2 < i; i2++) {
            if (i2 > position) {
                sb.append(" ");
            }
            sb.append(m14544a(array[i2]));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static String m14544a(byte b) {
        return Integer.toHexString((b | 256) & FrameMetricsAggregator.EVERY_DURATION).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static byte[] m14536a(ByteBuffer byteBuffer) {
        if (m14526b(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m14534a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static int m14534a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static byte[] m14528a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
