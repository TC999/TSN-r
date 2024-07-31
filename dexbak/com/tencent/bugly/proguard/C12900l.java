package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12900l {

    /* renamed from: a */
    public ByteBuffer f36885a;

    /* renamed from: b */
    protected String f36886b;

    public C12900l(int i) {
        this.f36886b = "GBK";
        this.f36885a = ByteBuffer.allocate(i);
    }

    /* renamed from: a */
    private void m15599a(int i) {
        if (this.f36885a.remaining() < i) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f36885a.capacity() + i) * 2);
            allocate.put(this.f36885a.array(), 0, this.f36885a.position());
            this.f36885a = allocate;
        }
    }

    /* renamed from: b */
    private void m15580b(byte b, int i) {
        if (i < 15) {
            this.f36885a.put((byte) (b | (i << 4)));
        } else if (i < 256) {
            this.f36885a.put((byte) (b | 240));
            this.f36885a.put((byte) i);
        } else {
            throw new C12897j("tag is too large: ".concat(String.valueOf(i)));
        }
    }

    public C12900l() {
        this(128);
    }

    /* renamed from: a */
    public final void m15589a(boolean z, int i) {
        m15602a(z ? (byte) 1 : (byte) 0, i);
    }

    /* renamed from: a */
    public final void m15602a(byte b, int i) {
        m15599a(3);
        if (b == 0) {
            m15580b((byte) 12, i);
            return;
        }
        m15580b((byte) 0, i);
        this.f36885a.put(b);
    }

    /* renamed from: a */
    public final void m15590a(short s, int i) {
        m15599a(4);
        if (s >= -128 && s <= 127) {
            m15602a((byte) s, i);
            return;
        }
        m15580b((byte) 1, i);
        this.f36885a.putShort(s);
    }

    /* renamed from: a */
    public final void m15598a(int i, int i2) {
        m15599a(6);
        if (i >= -32768 && i <= 32767) {
            m15590a((short) i, i2);
            return;
        }
        m15580b((byte) 2, i2);
        this.f36885a.putInt(i);
    }

    /* renamed from: a */
    public final void m15597a(long j, int i) {
        m15599a(10);
        if (j >= -2147483648L && j <= 2147483647L) {
            m15598a((int) j, i);
            return;
        }
        m15580b((byte) 3, i);
        this.f36885a.putLong(j);
    }

    /* renamed from: a */
    private void m15600a(float f, int i) {
        m15599a(6);
        m15580b((byte) 4, i);
        this.f36885a.putFloat(f);
    }

    /* renamed from: a */
    private void m15601a(double d, int i) {
        m15599a(10);
        m15580b((byte) 5, i);
        this.f36885a.putDouble(d);
    }

    /* renamed from: a */
    public final void m15593a(String str, int i) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f36886b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        m15599a(bytes.length + 10);
        if (bytes.length > 255) {
            m15580b((byte) 7, i);
            this.f36885a.putInt(bytes.length);
            this.f36885a.put(bytes);
            return;
        }
        m15580b((byte) 6, i);
        this.f36885a.put((byte) bytes.length);
        this.f36885a.put(bytes);
    }

    /* renamed from: a */
    public final <K, V> void m15591a(Map<K, V> map, int i) {
        m15599a(8);
        m15580b((byte) 8, i);
        m15598a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                m15595a(entry.getKey(), 0);
                m15595a(entry.getValue(), 1);
            }
        }
    }

    /* renamed from: a */
    private void m15581a(boolean[] zArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(zArr.length, 0);
        for (boolean z : zArr) {
            m15589a(z, 0);
        }
    }

    /* renamed from: a */
    public final void m15588a(byte[] bArr, int i) {
        m15599a(bArr.length + 8);
        m15580b((byte) 13, i);
        m15580b((byte) 0, 0);
        m15598a(bArr.length, 0);
        this.f36885a.put(bArr);
    }

    /* renamed from: a */
    private void m15582a(short[] sArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(sArr.length, 0);
        for (short s : sArr) {
            m15590a(s, 0);
        }
    }

    /* renamed from: a */
    private void m15585a(int[] iArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(iArr.length, 0);
        for (int i2 : iArr) {
            m15598a(i2, 0);
        }
    }

    /* renamed from: a */
    private void m15584a(long[] jArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(jArr.length, 0);
        for (long j : jArr) {
            m15597a(j, 0);
        }
    }

    /* renamed from: a */
    private void m15586a(float[] fArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(fArr.length, 0);
        for (float f : fArr) {
            m15600a(f, 0);
        }
    }

    /* renamed from: a */
    private void m15587a(double[] dArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(dArr.length, 0);
        for (double d : dArr) {
            m15601a(d, 0);
        }
    }

    /* renamed from: a */
    private void m15583a(Object[] objArr, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(objArr.length, 0);
        for (Object obj : objArr) {
            m15595a(obj, 0);
        }
    }

    /* renamed from: a */
    public final <T> void m15592a(Collection<T> collection, int i) {
        m15599a(8);
        m15580b((byte) 9, i);
        m15598a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            for (T t : collection) {
                m15595a(t, 0);
            }
        }
    }

    /* renamed from: a */
    public final void m15596a(AbstractC12901m abstractC12901m, int i) {
        m15599a(2);
        m15580b((byte) 10, i);
        abstractC12901m.mo15578a(this);
        m15599a(2);
        m15580b((byte) 11, 0);
    }

    /* renamed from: a */
    public final void m15595a(Object obj, int i) {
        if (obj instanceof Byte) {
            m15602a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            m15589a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            m15590a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            m15598a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            m15597a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            m15600a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            m15601a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            m15593a((String) obj, i);
        } else if (obj instanceof Map) {
            m15591a((Map) obj, i);
        } else if (obj instanceof List) {
            m15592a((Collection) ((List) obj), i);
        } else if (obj instanceof AbstractC12901m) {
            m15596a((AbstractC12901m) obj, i);
        } else if (obj instanceof byte[]) {
            m15588a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            m15581a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            m15582a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            m15585a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            m15584a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            m15586a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            m15587a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            m15583a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            m15592a((Collection) obj, i);
        } else {
            throw new C12897j("write object error: unsupport type. " + obj.getClass());
        }
    }

    /* renamed from: a */
    public final int m15594a(String str) {
        this.f36886b = str;
        return 0;
    }
}
