package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f51252a;

    /* renamed from: b  reason: collision with root package name */
    protected String f51253b;

    public l(int i4) {
        this.f51253b = "GBK";
        this.f51252a = ByteBuffer.allocate(i4);
    }

    private void a(int i4) {
        if (this.f51252a.remaining() < i4) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f51252a.capacity() + i4) * 2);
            allocate.put(this.f51252a.array(), 0, this.f51252a.position());
            this.f51252a = allocate;
        }
    }

    private void b(byte b4, int i4) {
        if (i4 < 15) {
            this.f51252a.put((byte) (b4 | (i4 << 4)));
        } else if (i4 < 256) {
            this.f51252a.put((byte) (b4 | 240));
            this.f51252a.put((byte) i4);
        } else {
            throw new j("tag is too large: ".concat(String.valueOf(i4)));
        }
    }

    public l() {
        this(128);
    }

    public final void a(boolean z3, int i4) {
        a(z3 ? (byte) 1 : (byte) 0, i4);
    }

    public final void a(byte b4, int i4) {
        a(3);
        if (b4 == 0) {
            b((byte) 12, i4);
            return;
        }
        b((byte) 0, i4);
        this.f51252a.put(b4);
    }

    public final void a(short s3, int i4) {
        a(4);
        if (s3 >= -128 && s3 <= 127) {
            a((byte) s3, i4);
            return;
        }
        b((byte) 1, i4);
        this.f51252a.putShort(s3);
    }

    public final void a(int i4, int i5) {
        a(6);
        if (i4 >= -32768 && i4 <= 32767) {
            a((short) i4, i5);
            return;
        }
        b((byte) 2, i5);
        this.f51252a.putInt(i4);
    }

    public final void a(long j4, int i4) {
        a(10);
        if (j4 >= -2147483648L && j4 <= 2147483647L) {
            a((int) j4, i4);
            return;
        }
        b((byte) 3, i4);
        this.f51252a.putLong(j4);
    }

    private void a(float f4, int i4) {
        a(6);
        b((byte) 4, i4);
        this.f51252a.putFloat(f4);
    }

    private void a(double d4, int i4) {
        a(10);
        b((byte) 5, i4);
        this.f51252a.putDouble(d4);
    }

    public final void a(String str, int i4) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f51253b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i4);
            this.f51252a.putInt(bytes.length);
            this.f51252a.put(bytes);
            return;
        }
        b((byte) 6, i4);
        this.f51252a.put((byte) bytes.length);
        this.f51252a.put(bytes);
    }

    public final <K, V> void a(Map<K, V> map, int i4) {
        a(8);
        b((byte) 8, i4);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    private void a(boolean[] zArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(zArr.length, 0);
        for (boolean z3 : zArr) {
            a(z3, 0);
        }
    }

    public final void a(byte[] bArr, int i4) {
        a(bArr.length + 8);
        b((byte) 13, i4);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f51252a.put(bArr);
    }

    private void a(short[] sArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(sArr.length, 0);
        for (short s3 : sArr) {
            a(s3, 0);
        }
    }

    private void a(int[] iArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(iArr.length, 0);
        for (int i5 : iArr) {
            a(i5, 0);
        }
    }

    private void a(long[] jArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(jArr.length, 0);
        for (long j4 : jArr) {
            a(j4, 0);
        }
    }

    private void a(float[] fArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(fArr.length, 0);
        for (float f4 : fArr) {
            a(f4, 0);
        }
    }

    private void a(double[] dArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(dArr.length, 0);
        for (double d4 : dArr) {
            a(d4, 0);
        }
    }

    private void a(Object[] objArr, int i4) {
        a(8);
        b((byte) 9, i4);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public final <T> void a(Collection<T> collection, int i4) {
        a(8);
        b((byte) 9, i4);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t3 : collection) {
                a(t3, 0);
            }
        }
    }

    public final void a(m mVar, int i4) {
        a(2);
        b((byte) 10, i4);
        mVar.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i4) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i4);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i4);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i4);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i4);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i4);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i4);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i4);
        } else if (obj instanceof String) {
            a((String) obj, i4);
        } else if (obj instanceof Map) {
            a((Map) obj, i4);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i4);
        } else if (obj instanceof m) {
            a((m) obj, i4);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i4);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i4);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i4);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i4);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i4);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i4);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i4);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i4);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i4);
        } else {
            throw new j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.f51253b = str;
        return 0;
    }
}
