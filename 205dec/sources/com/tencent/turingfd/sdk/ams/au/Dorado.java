package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Dorado {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f52033a;

    /* renamed from: b  reason: collision with root package name */
    public String f52034b = "GBK";

    public Dorado(int i4) {
        this.f52033a = ByteBuffer.allocate(i4);
    }

    public byte[] a() {
        byte[] bArr = new byte[this.f52033a.position()];
        System.arraycopy(this.f52033a.array(), 0, bArr, 0, this.f52033a.position());
        return bArr;
    }

    public void b(byte b4, int i4) {
        if (i4 < 15) {
            this.f52033a.put((byte) (b4 | (i4 << 4)));
        } else if (i4 < 256) {
            this.f52033a.put((byte) (b4 | 240));
            this.f52033a.put((byte) i4);
        } else {
            throw new ComaBerenices(Crux.a("tag is too large: ", i4));
        }
    }

    public void a(int i4) {
        if (this.f52033a.remaining() < i4) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f52033a.capacity() + i4) * 2);
            allocate.put(this.f52033a.array(), 0, this.f52033a.position());
            this.f52033a = allocate;
        }
    }

    public void a(byte b4, int i4) {
        a(3);
        if (b4 == 0) {
            b((byte) 12, i4);
            return;
        }
        b((byte) 0, i4);
        this.f52033a.put(b4);
    }

    public void a(short s3, int i4) {
        a(4);
        if (s3 >= -128 && s3 <= 127) {
            a((byte) s3, i4);
            return;
        }
        b((byte) 1, i4);
        this.f52033a.putShort(s3);
    }

    public void a(int i4, int i5) {
        a(6);
        if (i4 >= -32768 && i4 <= 32767) {
            a((short) i4, i5);
            return;
        }
        b((byte) 2, i5);
        this.f52033a.putInt(i4);
    }

    public void a(long j4, int i4) {
        a(10);
        if (j4 >= -2147483648L && j4 <= 2147483647L) {
            a((int) j4, i4);
            return;
        }
        b((byte) 3, i4);
        this.f52033a.putLong(j4);
    }

    public void a(float f4, int i4) {
        a(6);
        b((byte) 4, i4);
        this.f52033a.putFloat(f4);
    }

    public void a(String str, int i4) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f52034b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i4);
            this.f52033a.putInt(bytes.length);
            this.f52033a.put(bytes);
            return;
        }
        b((byte) 6, i4);
        this.f52033a.put((byte) bytes.length);
        this.f52033a.put(bytes);
    }

    public <K, V> void a(Map<K, V> map, int i4) {
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

    public void a(byte[] bArr, int i4) {
        a(bArr.length + 8);
        b((byte) 13, i4);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f52033a.put(bArr);
    }

    public <T> void a(Collection<T> collection, int i4) {
        a(8);
        b((byte) 9, i4);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t3 : collection) {
                a(t3, 0);
            }
        }
    }

    public void a(Draco draco, int i4) {
        a(2);
        b((byte) 10, i4);
        draco.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i4) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i4);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i4);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i4);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i4);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i4);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i4);
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i4);
            this.f52033a.putDouble(doubleValue);
        } else if (obj instanceof String) {
            a((String) obj, i4);
        } else if (obj instanceof Map) {
            a((Map) obj, i4);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i4);
        } else if (obj instanceof Draco) {
            a((Draco) obj, i4);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i4);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i4);
            a(zArr.length, 0);
            for (boolean z3 : zArr) {
                a(z3 ? (byte) 1 : (byte) 0, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i4);
            a(sArr.length, 0);
            for (short s3 : sArr) {
                a(s3, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i4);
            a(iArr.length, 0);
            for (int i5 : iArr) {
                a(i5, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i4);
            a(jArr.length, 0);
            for (long j4 : jArr) {
                a(j4, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i4);
            a(fArr.length, 0);
            for (float f4 : fArr) {
                a(f4, 0);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i4);
            a(dArr.length, 0);
            for (double d4 : dArr) {
                a(10);
                b((byte) 5, 0);
                this.f52033a.putDouble(d4);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i4);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
        } else if (obj instanceof Collection) {
            a((Collection) obj, i4);
        } else {
            StringBuilder a4 = Almond.a("write object error: unsupport type. ");
            a4.append(obj.getClass());
            throw new ComaBerenices(a4.toString());
        }
    }
}
