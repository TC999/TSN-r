package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    protected String f51248a = "GBK";

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f51249b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f51250a;

        /* renamed from: b  reason: collision with root package name */
        public int f51251b;
    }

    public k() {
    }

    private boolean b(int i4) {
        int i5;
        try {
            a aVar = new a();
            while (true) {
                int a4 = a(aVar, this.f51249b.duplicate());
                i5 = aVar.f51251b;
                if (i4 <= i5 || aVar.f51250a == 11) {
                    break;
                }
                a(a4);
                a(aVar.f51250a);
            }
        } catch (h | BufferUnderflowException unused) {
        }
        return i4 == i5;
    }

    private boolean[] d(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                boolean[] zArr = new boolean[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    zArr[i5] = a(0, true);
                }
                return zArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    private short[] e(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                short[] sArr = new short[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    sArr[i5] = a(sArr[0], 0, true);
                }
                return sArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    private int[] f(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                int[] iArr = new int[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    iArr[i5] = a(iArr[0], 0, true);
                }
                return iArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    private long[] g(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                long[] jArr = new long[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    jArr[i5] = a(jArr[0], 0, true);
                }
                return jArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    private float[] h(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                float[] fArr = new float[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    fArr[i5] = a(fArr[0], 0, true);
                }
                return fArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    private double[] i(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                double[] dArr = new double[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    dArr[i5] = a(dArr[0], 0, true);
                }
                return dArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f51249b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f51249b = ByteBuffer.wrap(bArr);
    }

    public final byte[] c(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                byte[] bArr = new byte[a4];
                for (int i5 = 0; i5 < a4; i5++) {
                    bArr[i5] = a(bArr[0], 0, true);
                }
                return bArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        } else if (b4 == 13) {
            a aVar2 = new a();
            a(aVar2);
            if (aVar2.f51250a == 0) {
                int a5 = a(0, 0, true);
                if (a5 >= 0) {
                    byte[] bArr2 = new byte[a5];
                    this.f51249b.get(bArr2);
                    return bArr2;
                }
                throw new h("invalid size, tag: " + i4 + ", type: " + ((int) aVar.f51250a) + ", " + ((int) aVar2.f51250a) + ", size: " + a5);
            }
            throw new h("type mismatch, tag: " + i4 + ", type: " + ((int) aVar.f51250a) + ", " + ((int) aVar2.f51250a));
        } else {
            throw new h("type mismatch.");
        }
    }

    public k(byte[] bArr) {
        this.f51249b = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b4 = byteBuffer.get();
        aVar.f51250a = (byte) (b4 & 15);
        int i4 = (b4 & 240) >> 4;
        aVar.f51251b = i4;
        if (i4 == 15) {
            aVar.f51251b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    public k(byte[] bArr, byte b4) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f51249b = wrap;
        wrap.position(4);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f51250a);
    }

    private void a(a aVar) {
        a(aVar, this.f51249b);
    }

    private void a(int i4) {
        ByteBuffer byteBuffer = this.f51249b;
        byteBuffer.position(byteBuffer.position() + i4);
    }

    public final String b(int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 == 6) {
            int i5 = this.f51249b.get();
            if (i5 < 0) {
                i5 += 256;
            }
            byte[] bArr = new byte[i5];
            this.f51249b.get(bArr);
            try {
                return new String(bArr, this.f51248a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (b4 == 7) {
            int i6 = this.f51249b.getInt();
            if (i6 <= 104857600 && i6 >= 0) {
                byte[] bArr2 = new byte[i6];
                this.f51249b.get(bArr2);
                try {
                    return new String(bArr2, this.f51248a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new h("String too long: ".concat(String.valueOf(i6)));
        } else {
            throw new h("type mismatch.");
        }
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f51250a);
        } while (aVar.f51250a != 11);
    }

    private void a(byte b4) {
        int i4 = 0;
        switch (b4) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i5 = this.f51249b.get();
                if (i5 < 0) {
                    i5 += 256;
                }
                a(i5);
                return;
            case 7:
                a(this.f51249b.getInt());
                return;
            case 8:
                int a4 = a(0, 0, true);
                while (i4 < a4 * 2) {
                    b();
                    i4++;
                }
                return;
            case 9:
                int a5 = a(0, 0, true);
                while (i4 < a5) {
                    b();
                    i4++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f51250a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + ((int) b4) + ", " + ((int) aVar.f51250a));
            default:
                throw new h("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t3, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f51250a == 9) {
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t3.getClass(), a4));
                for (int i5 = 0; i5 < a4; i5++) {
                    tArr[i5] = a((k) t3, 0, true);
                }
                return tArr;
            }
            throw new h("size invalid: ".concat(String.valueOf(a4)));
        }
        throw new h("type mismatch.");
    }

    public final boolean a(int i4, boolean z3) {
        return a((byte) 0, i4, z3) != 0;
    }

    public final byte a(byte b4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return b4;
        }
        a aVar = new a();
        a(aVar);
        byte b5 = aVar.f51250a;
        if (b5 != 0) {
            if (b5 == 12) {
                return (byte) 0;
            }
            throw new h("type mismatch.");
        }
        return this.f51249b.get();
    }

    public final short a(short s3, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return s3;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 == 12) {
                    return (short) 0;
                }
                throw new h("type mismatch.");
            }
            return this.f51249b.getShort();
        }
        return this.f51249b.get();
    }

    public final int a(int i4, int i5, boolean z3) {
        if (!b(i5)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return i4;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 != 2) {
                    if (b4 == 12) {
                        return 0;
                    }
                    throw new h("type mismatch.");
                }
                return this.f51249b.getInt();
            }
            return this.f51249b.getShort();
        }
        return this.f51249b.get();
    }

    public final long a(long j4, int i4, boolean z3) {
        int i5;
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return j4;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 == 0) {
            i5 = this.f51249b.get();
        } else if (b4 == 1) {
            i5 = this.f51249b.getShort();
        } else if (b4 != 2) {
            if (b4 != 3) {
                if (b4 == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            return this.f51249b.getLong();
        } else {
            i5 = this.f51249b.getInt();
        }
        return i5;
    }

    private float a(float f4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return f4;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 != 4) {
            if (b4 == 12) {
                return 0.0f;
            }
            throw new h("type mismatch.");
        }
        return this.f51249b.getFloat();
    }

    private double a(double d4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return d4;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f51250a;
        if (b4 != 4) {
            if (b4 != 5) {
                if (b4 == 12) {
                    return 0.0d;
                }
                throw new h("type mismatch.");
            }
            return this.f51249b.getDouble();
        }
        return this.f51249b.getFloat();
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i4, boolean z3) {
        return (HashMap) a(new HashMap(), map, i4, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i4, boolean z3) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (b(i4)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f51250a == 8) {
                    int a4 = a(0, 0, true);
                    if (a4 < 0) {
                        throw new h("size invalid: ".concat(String.valueOf(a4)));
                    }
                    for (int i5 = 0; i5 < a4; i5++) {
                        map.put(a((k) key, 0, true), a((k) value, 1, true));
                    }
                } else {
                    throw new h("type mismatch.");
                }
            } else if (z3) {
                throw new h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i4, boolean z3) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i4, z3);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i4, boolean z3) {
        if (list != null && !list.isEmpty()) {
            Object[] b4 = b(list.get(0), i4, z3);
            if (b4 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b4) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final m a(m mVar, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f51250a == 10) {
                mVar2.a(this);
                a();
                return mVar2;
            }
            throw new h("type mismatch.");
        } catch (Exception e4) {
            throw new h(e4.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t3, int i4, boolean z3) {
        if (t3 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i4, z3));
        }
        if (t3 instanceof Boolean) {
            return Boolean.valueOf(a(i4, z3));
        }
        if (t3 instanceof Short) {
            return Short.valueOf(a((short) 0, i4, z3));
        }
        if (t3 instanceof Integer) {
            return Integer.valueOf(a(0, i4, z3));
        }
        if (t3 instanceof Long) {
            return Long.valueOf(a(0L, i4, z3));
        }
        if (t3 instanceof Float) {
            return Float.valueOf(a(0.0f, i4, z3));
        }
        if (t3 instanceof Double) {
            return Double.valueOf(a(0.0d, i4, z3));
        }
        if (t3 instanceof String) {
            return String.valueOf(b(i4, z3));
        }
        if (t3 instanceof Map) {
            return a((Map) t3, i4, z3);
        }
        if (t3 instanceof List) {
            return a((List) t3, i4, z3);
        }
        if (t3 instanceof m) {
            return a((m) t3, i4, z3);
        }
        if (t3.getClass().isArray()) {
            if (!(t3 instanceof byte[]) && !(t3 instanceof Byte[])) {
                if (t3 instanceof boolean[]) {
                    return d(i4, z3);
                }
                if (t3 instanceof short[]) {
                    return e(i4, z3);
                }
                if (t3 instanceof int[]) {
                    return f(i4, z3);
                }
                if (t3 instanceof long[]) {
                    return g(i4, z3);
                }
                if (t3 instanceof float[]) {
                    return h(i4, z3);
                }
                if (t3 instanceof double[]) {
                    return i(i4, z3);
                }
                return a((Object[]) t3, i4, z3);
            }
            return c(i4, z3);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f51248a = str;
        return 0;
    }
}
