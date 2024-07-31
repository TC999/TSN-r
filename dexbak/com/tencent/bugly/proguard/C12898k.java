package com.tencent.bugly.proguard;

import com.github.mikephil.charting.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12898k {

    /* renamed from: a */
    protected String f36881a = "GBK";

    /* renamed from: b */
    private ByteBuffer f36882b;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.k$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12899a {

        /* renamed from: a */
        public byte f36883a;

        /* renamed from: b */
        public int f36884b;
    }

    public C12898k() {
    }

    /* renamed from: b */
    private boolean m15612b(int i) {
        int i2;
        try {
            C12899a c12899a = new C12899a();
            while (true) {
                int m15623a = m15623a(c12899a, this.f36882b.duplicate());
                i2 = c12899a.f36884b;
                if (i <= i2 || c12899a.f36883a == 11) {
                    break;
                }
                m15628a(m15623a);
                m15632a(c12899a.f36883a);
            }
        } catch (C12895h | BufferUnderflowException unused) {
        }
        return i == i2;
    }

    /* renamed from: d */
    private boolean[] m15608d(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                boolean[] zArr = new boolean[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    zArr[i2] = m15626a(0, true);
                }
                return zArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: e */
    private short[] m15607e(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                short[] sArr = new short[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    sArr[i2] = m15616a(sArr[0], 0, true);
                }
                return sArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: f */
    private int[] m15606f(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                int[] iArr = new int[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    iArr[i2] = m15627a(iArr[0], 0, true);
                }
                return iArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: g */
    private long[] m15605g(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                long[] jArr = new long[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    jArr[i2] = m15625a(jArr[0], 0, true);
                }
                return jArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: h */
    private float[] m15604h(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                float[] fArr = new float[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    fArr[i2] = m15629a(fArr[0], 0, true);
                }
                return fArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: i */
    private double[] m15603i(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                double[] dArr = new double[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    dArr[i2] = m15630a(dArr[0], 0, true);
                }
                return dArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: a */
    public final void m15615a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f36882b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f36882b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: c */
    public final byte[] m15609c(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                byte[] bArr = new byte[m15627a];
                for (int i2 = 0; i2 < m15627a; i2++) {
                    bArr[i2] = m15631a(bArr[0], 0, true);
                }
                return bArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        } else if (b == 13) {
            C12899a c12899a2 = new C12899a();
            m15624a(c12899a2);
            if (c12899a2.f36883a == 0) {
                int m15627a2 = m15627a(0, 0, true);
                if (m15627a2 >= 0) {
                    byte[] bArr2 = new byte[m15627a2];
                    this.f36882b.get(bArr2);
                    return bArr2;
                }
                throw new C12895h("invalid size, tag: " + i + ", type: " + ((int) c12899a.f36883a) + ", " + ((int) c12899a2.f36883a) + ", size: " + m15627a2);
            }
            throw new C12895h("type mismatch, tag: " + i + ", type: " + ((int) c12899a.f36883a) + ", " + ((int) c12899a2.f36883a));
        } else {
            throw new C12895h("type mismatch.");
        }
    }

    public C12898k(byte[] bArr) {
        this.f36882b = ByteBuffer.wrap(bArr);
    }

    /* renamed from: a */
    private static int m15623a(C12899a c12899a, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        c12899a.f36883a = (byte) (b & 15);
        int i = (b & 240) >> 4;
        c12899a.f36884b = i;
        if (i == 15) {
            c12899a.f36884b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    public C12898k(byte[] bArr, byte b) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f36882b = wrap;
        wrap.position(4);
    }

    /* renamed from: b */
    private void m15613b() {
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        m15632a(c12899a.f36883a);
    }

    /* renamed from: a */
    private void m15624a(C12899a c12899a) {
        m15623a(c12899a, this.f36882b);
    }

    /* renamed from: a */
    private void m15628a(int i) {
        ByteBuffer byteBuffer = this.f36882b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: b */
    public final String m15611b(int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b == 6) {
            int i2 = this.f36882b.get();
            if (i2 < 0) {
                i2 += 256;
            }
            byte[] bArr = new byte[i2];
            this.f36882b.get(bArr);
            try {
                return new String(bArr, this.f36881a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i3 = this.f36882b.getInt();
            if (i3 <= 104857600 && i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                this.f36882b.get(bArr2);
                try {
                    return new String(bArr2, this.f36881a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C12895h("String too long: ".concat(String.valueOf(i3)));
        } else {
            throw new C12895h("type mismatch.");
        }
    }

    /* renamed from: a */
    private void m15633a() {
        C12899a c12899a = new C12899a();
        do {
            m15624a(c12899a);
            m15632a(c12899a.f36883a);
        } while (c12899a.f36883a != 11);
    }

    /* renamed from: a */
    private void m15632a(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                m15628a(1);
                return;
            case 1:
                m15628a(2);
                return;
            case 2:
                m15628a(4);
                return;
            case 3:
                m15628a(8);
                return;
            case 4:
                m15628a(4);
                return;
            case 5:
                m15628a(8);
                return;
            case 6:
                int i2 = this.f36882b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                m15628a(i2);
                return;
            case 7:
                m15628a(this.f36882b.getInt());
                return;
            case 8:
                int m15627a = m15627a(0, 0, true);
                while (i < m15627a * 2) {
                    m15613b();
                    i++;
                }
                return;
            case 9:
                int m15627a2 = m15627a(0, 0, true);
                while (i < m15627a2) {
                    m15613b();
                    i++;
                }
                return;
            case 10:
                m15633a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                C12899a c12899a = new C12899a();
                m15624a(c12899a);
                if (c12899a.f36883a == 0) {
                    m15628a(m15627a(0, 0, true));
                    return;
                }
                throw new C12895h("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) c12899a.f36883a));
            default:
                throw new C12895h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    private <T> T[] m15610b(T t, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        if (c12899a.f36883a == 9) {
            int m15627a = m15627a(0, 0, true);
            if (m15627a >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), m15627a));
                for (int i2 = 0; i2 < m15627a; i2++) {
                    tArr[i2] = m15621a((C12898k) t, 0, true);
                }
                return tArr;
            }
            throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
        }
        throw new C12895h("type mismatch.");
    }

    /* renamed from: a */
    public final boolean m15626a(int i, boolean z) {
        return m15631a((byte) 0, i, z) != 0;
    }

    /* renamed from: a */
    public final byte m15631a(byte b, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return b;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b2 = c12899a.f36883a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new C12895h("type mismatch.");
        }
        return this.f36882b.get();
    }

    /* renamed from: a */
    public final short m15616a(short s, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return s;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new C12895h("type mismatch.");
            }
            return this.f36882b.getShort();
        }
        return this.f36882b.get();
    }

    /* renamed from: a */
    public final int m15627a(int i, int i2, boolean z) {
        if (!m15612b(i2)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return i;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new C12895h("type mismatch.");
                }
                return this.f36882b.getInt();
            }
            return this.f36882b.getShort();
        }
        return this.f36882b.get();
    }

    /* renamed from: a */
    public final long m15625a(long j, int i, boolean z) {
        int i2;
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return j;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b == 0) {
            i2 = this.f36882b.get();
        } else if (b == 1) {
            i2 = this.f36882b.getShort();
        } else if (b != 2) {
            if (b != 3) {
                if (b == 12) {
                    return 0L;
                }
                throw new C12895h("type mismatch.");
            }
            return this.f36882b.getLong();
        } else {
            i2 = this.f36882b.getInt();
        }
        return i2;
    }

    /* renamed from: a */
    private float m15629a(float f, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return f;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new C12895h("type mismatch.");
        }
        return this.f36882b.getFloat();
    }

    /* renamed from: a */
    private double m15630a(double d, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return d;
        }
        C12899a c12899a = new C12899a();
        m15624a(c12899a);
        byte b = c12899a.f36883a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return Utils.DOUBLE_EPSILON;
                }
                throw new C12895h("type mismatch.");
            }
            return this.f36882b.getDouble();
        }
        return this.f36882b.getFloat();
    }

    /* renamed from: a */
    public final <K, V> HashMap<K, V> m15618a(Map<K, V> map, int i, boolean z) {
        return (HashMap) m15617a(new HashMap(), map, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <K, V> Map<K, V> m15617a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (m15612b(i)) {
                C12899a c12899a = new C12899a();
                m15624a(c12899a);
                if (c12899a.f36883a == 8) {
                    int m15627a = m15627a(0, 0, true);
                    if (m15627a < 0) {
                        throw new C12895h("size invalid: ".concat(String.valueOf(m15627a)));
                    }
                    for (int i2 = 0; i2 < m15627a; i2++) {
                        map.put(m15621a((C12898k) key, 0, true), m15621a((C12898k) value, 1, true));
                    }
                } else {
                    throw new C12895h("type mismatch.");
                }
            } else if (z) {
                throw new C12895h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    /* renamed from: a */
    private <T> T[] m15614a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) m15610b(tArr[0], i, z);
        }
        throw new C12895h("unable to get type of key and value.");
    }

    /* renamed from: a */
    private <T> List<T> m15619a(List<T> list, int i, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] m15610b = m15610b(list.get(0), i, z);
            if (m15610b == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : m15610b) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    /* renamed from: a */
    public final AbstractC12901m m15622a(AbstractC12901m abstractC12901m, int i, boolean z) {
        if (!m15612b(i)) {
            if (z) {
                throw new C12895h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC12901m abstractC12901m2 = (AbstractC12901m) abstractC12901m.getClass().newInstance();
            C12899a c12899a = new C12899a();
            m15624a(c12899a);
            if (c12899a.f36883a == 10) {
                abstractC12901m2.mo15579a(this);
                m15633a();
                return abstractC12901m2;
            }
            throw new C12895h("type mismatch.");
        } catch (Exception e) {
            throw new C12895h(e.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <T> Object m15621a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(m15631a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(m15626a(i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(m15616a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(m15627a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(m15625a(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(m15629a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(m15630a((double) Utils.DOUBLE_EPSILON, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(m15611b(i, z));
        }
        if (t instanceof Map) {
            return m15618a((Map) t, i, z);
        }
        if (t instanceof List) {
            return m15619a((List) t, i, z);
        }
        if (t instanceof AbstractC12901m) {
            return m15622a((AbstractC12901m) t, i, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return m15608d(i, z);
                }
                if (t instanceof short[]) {
                    return m15607e(i, z);
                }
                if (t instanceof int[]) {
                    return m15606f(i, z);
                }
                if (t instanceof long[]) {
                    return m15605g(i, z);
                }
                if (t instanceof float[]) {
                    return m15604h(i, z);
                }
                if (t instanceof double[]) {
                    return m15603i(i, z);
                }
                return m15614a((Object[]) t, i, z);
            }
            return m15609c(i, z);
        }
        throw new C12895h("read object error: unsupport type.");
    }

    /* renamed from: a */
    public final int m15620a(String str) {
        this.f36881a = str;
        return 0;
    }
}
