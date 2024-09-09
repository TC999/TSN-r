package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Cygnus {

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f52007a;

    /* renamed from: b  reason: collision with root package name */
    public String f52008b = "GBK";

    public Cygnus() {
    }

    public final void a() {
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b5);
    }

    public boolean b(int i4) {
        int i5;
        int i6;
        while (true) {
            try {
                ByteBuffer duplicate = this.f52007a.duplicate();
                byte b4 = duplicate.get();
                byte b5 = (byte) (b4 & 15);
                i5 = (b4 & 240) >> 4;
                if (i5 == 15) {
                    i5 = duplicate.get() & 255;
                    i6 = 2;
                } else {
                    i6 = 1;
                }
                if (i4 <= i5 || b5 == 11) {
                    break;
                }
                a(i6);
                a(b5);
            } catch (Chamaeleon | BufferUnderflowException unused) {
                return false;
            }
        }
        return i4 == i5;
    }

    public final void a(int i4) {
        ByteBuffer byteBuffer = this.f52007a;
        byteBuffer.position(byteBuffer.position() + i4);
    }

    public final void a(byte b4) {
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
                int i5 = this.f52007a.get();
                if (i5 < 0) {
                    i5 += 256;
                }
                a(i5);
                return;
            case 7:
                a(this.f52007a.getInt());
                return;
            case 8:
                int a4 = a(0, 0, true);
                while (i4 < a4 * 2) {
                    a();
                    i4++;
                }
                return;
            case 9:
                int a5 = a(0, 0, true);
                while (i4 < a5) {
                    a();
                    i4++;
                }
                return;
            case 10:
                b();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.f52007a;
                byte b5 = byteBuffer.get();
                byte b6 = (byte) (b5 & 15);
                if (((b5 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b6 == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new Chamaeleon("skipField with invalid type, type value: " + ((int) b4) + ", " + ((int) b6));
            default:
                throw new Chamaeleon("invalid type.");
        }
    }

    public void b() {
        while (this.f52007a.remaining() != 0) {
            ByteBuffer byteBuffer = this.f52007a;
            byte b4 = byteBuffer.get();
            byte b5 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b5);
            if (b5 == 11) {
                return;
            }
        }
    }

    public String b(int i4, boolean z3) {
        if (b(i4)) {
            ByteBuffer byteBuffer = this.f52007a;
            byte b4 = byteBuffer.get();
            byte b5 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b5 == 6) {
                int i5 = this.f52007a.get();
                if (i5 < 0) {
                    i5 += 256;
                }
                byte[] bArr = new byte[i5];
                this.f52007a.get(bArr);
                try {
                    return new String(bArr, this.f52008b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b5 == 7) {
                int i6 = this.f52007a.getInt();
                if (i6 <= 104857600 && i6 >= 0) {
                    byte[] bArr2 = new byte[i6];
                    this.f52007a.get(bArr2);
                    try {
                        return new String(bArr2, this.f52008b);
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(bArr2);
                    }
                }
                throw new Chamaeleon(Crux.a("String too long: ", i6));
            } else if (b5 != 11) {
                throw new Chamaeleon("type mismatch.");
            }
        } else if (z3) {
            throw new Chamaeleon("require field not exist.");
        }
        return null;
    }

    public boolean a(boolean z3, int i4, boolean z4) {
        return a(z3 ? (byte) 1 : (byte) 0, i4, z4) != 0;
    }

    public byte a(byte b4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return b4;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b5 = byteBuffer.get();
        byte b6 = (byte) (b5 & 15);
        if (((b5 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b6 != 0) {
            if (b6 != 11) {
                if (b6 == 12) {
                    return (byte) 0;
                }
                throw new Chamaeleon("type mismatch.");
            }
            return b4;
        }
        return this.f52007a.get();
    }

    public short a(short s3, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return s3;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 0) {
            if (b5 != 1) {
                if (b5 != 11) {
                    if (b5 == 12) {
                        return (short) 0;
                    }
                    throw new Chamaeleon("type mismatch.");
                }
                return s3;
            }
            return this.f52007a.getShort();
        }
        return this.f52007a.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t3, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 9) {
            if (b5 == 11) {
                return null;
            }
            throw new Chamaeleon("type mismatch.");
        }
        int a4 = a(0, 0, true);
        if (a4 >= 0) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t3.getClass(), a4));
            for (int i5 = 0; i5 < a4; i5++) {
                tArr[i5] = a((Cygnus) t3, 0, true);
            }
            return tArr;
        }
        throw new Chamaeleon(Crux.a("size invalid: ", a4));
    }

    public int a(int i4, int i5, boolean z3) {
        if (!b(i5)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return i4;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 0) {
            if (b5 != 1) {
                if (b5 != 2) {
                    if (b5 != 11) {
                        if (b5 == 12) {
                            return 0;
                        }
                        throw new Chamaeleon("type mismatch.");
                    }
                    return i4;
                }
                return this.f52007a.getInt();
            }
            return this.f52007a.getShort();
        }
        return this.f52007a.get();
    }

    public long a(long j4, int i4, boolean z3) {
        int i5;
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return j4;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 11) {
            if (b5 != 12) {
                if (b5 == 0) {
                    i5 = this.f52007a.get();
                } else if (b5 == 1) {
                    i5 = this.f52007a.getShort();
                } else if (b5 != 2) {
                    if (b5 != 3) {
                        throw new Chamaeleon("type mismatch.");
                    }
                    return this.f52007a.getLong();
                } else {
                    i5 = this.f52007a.getInt();
                }
                return i5;
            }
            return 0L;
        }
        return j4;
    }

    public float a(float f4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return f4;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 4) {
            if (b5 != 11) {
                if (b5 == 12) {
                    return 0.0f;
                }
                throw new Chamaeleon("type mismatch.");
            }
            return f4;
        }
        return this.f52007a.getFloat();
    }

    public double a(double d4, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return d4;
        }
        ByteBuffer byteBuffer = this.f52007a;
        byte b4 = byteBuffer.get();
        byte b5 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b5 != 4) {
            if (b5 != 5) {
                if (b5 != 11) {
                    if (b5 == 12) {
                        return 0.0d;
                    }
                    throw new Chamaeleon("type mismatch.");
                }
                return d4;
            }
            return this.f52007a.getDouble();
        }
        return this.f52007a.getFloat();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> HashMap<K, V> a(Map<K, V> map, int i4, boolean z3) {
        HashMap<K, V> hashMap = (HashMap<K, V>) new HashMap();
        if (map != null && !map.isEmpty()) {
            Map.Entry<K, V> next = map.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (!b(i4)) {
                if (z3) {
                    throw new Chamaeleon("require field not exist.");
                }
                return hashMap;
            }
            ByteBuffer byteBuffer = this.f52007a;
            byte b4 = byteBuffer.get();
            byte b5 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b5 != 8) {
                if (b5 == 11) {
                    return hashMap;
                }
                throw new Chamaeleon("type mismatch.");
            }
            int a4 = a(0, 0, true);
            if (a4 >= 0) {
                for (int i5 = 0; i5 < a4; i5++) {
                    hashMap.put(a((Cygnus) key, 0, true), a((Cygnus) value, 1, true));
                }
                return hashMap;
            }
            throw new Chamaeleon(Crux.a("size invalid: ", a4));
        }
        return new HashMap<>();
    }

    public byte[] a(int i4, boolean z3) {
        if (b(i4)) {
            ByteBuffer byteBuffer = this.f52007a;
            byte b4 = byteBuffer.get();
            byte b5 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b5 == 9) {
                int a4 = a(0, 0, true);
                if (a4 >= 0) {
                    byte[] bArr = new byte[a4];
                    for (int i5 = 0; i5 < a4; i5++) {
                        bArr[i5] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new Chamaeleon(Crux.a("size invalid: ", a4));
            } else if (b5 != 11) {
                if (b5 == 13) {
                    ByteBuffer byteBuffer2 = this.f52007a;
                    byte b6 = byteBuffer2.get();
                    byte b7 = (byte) (b6 & 15);
                    if (((b6 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b7 == 0) {
                        int a5 = a(0, 0, true);
                        if (a5 >= 0) {
                            byte[] bArr2 = new byte[a5];
                            this.f52007a.get(bArr2);
                            return bArr2;
                        }
                        throw new Chamaeleon("invalid size, tag: " + i4 + ", type: " + ((int) b5) + ", " + ((int) b7) + ", size: " + a5);
                    }
                    throw new Chamaeleon("type mismatch, tag: " + i4 + ", type: " + ((int) b5) + ", " + ((int) b7));
                }
                throw new Chamaeleon("type mismatch.");
            }
        } else if (z3) {
            throw new Chamaeleon("require field not exist.");
        }
        return null;
    }

    public Draco a(Draco draco, int i4, boolean z3) {
        if (!b(i4)) {
            if (z3) {
                throw new Chamaeleon("require field not exist.");
            }
            return null;
        }
        try {
            Draco draco2 = (Draco) draco.getClass().newInstance();
            ByteBuffer byteBuffer = this.f52007a;
            byte b4 = byteBuffer.get();
            byte b5 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b5 == 10) {
                draco2.a(this);
                b();
                return draco2;
            }
            throw new Chamaeleon("type mismatch.");
        } catch (Exception e4) {
            throw new Chamaeleon(e4.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t3, int i4, boolean z3) {
        if (t3 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i4, z3));
        }
        if (t3 instanceof Boolean) {
            return Boolean.valueOf(a(false, i4, z3));
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
            return b(i4, z3);
        }
        if (t3 instanceof Map) {
            return a((Map) t3, i4, z3);
        }
        double[] dArr = null;
        r2 = null;
        boolean[] zArr = null;
        r2 = null;
        short[] sArr = null;
        r2 = null;
        int[] iArr = null;
        r2 = null;
        long[] jArr = null;
        r2 = null;
        float[] fArr = null;
        dArr = null;
        if (t3 instanceof List) {
            List list = (List) t3;
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
        } else if (t3 instanceof Draco) {
            return a((Draco) t3, i4, z3);
        } else {
            if (t3.getClass().isArray()) {
                if (!(t3 instanceof byte[]) && !(t3 instanceof Byte[])) {
                    if (t3 instanceof boolean[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer = this.f52007a;
                            byte b5 = byteBuffer.get();
                            byte b6 = (byte) (b5 & 15);
                            if (((b5 & 240) >> 4) == 15) {
                                byteBuffer.get();
                            }
                            if (b6 == 9) {
                                int a4 = a(0, 0, true);
                                if (a4 >= 0) {
                                    zArr = new boolean[a4];
                                    for (int i5 = 0; i5 < a4; i5++) {
                                        zArr[i5] = a(zArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a4));
                                }
                            } else if (b6 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return zArr;
                    } else if (t3 instanceof short[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer2 = this.f52007a;
                            byte b7 = byteBuffer2.get();
                            byte b8 = (byte) (b7 & 15);
                            if (((b7 & 240) >> 4) == 15) {
                                byteBuffer2.get();
                            }
                            if (b8 == 9) {
                                int a5 = a(0, 0, true);
                                if (a5 >= 0) {
                                    sArr = new short[a5];
                                    for (int i6 = 0; i6 < a5; i6++) {
                                        sArr[i6] = a(sArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a5));
                                }
                            } else if (b8 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return sArr;
                    } else if (t3 instanceof int[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer3 = this.f52007a;
                            byte b9 = byteBuffer3.get();
                            byte b10 = (byte) (b9 & 15);
                            if (((b9 & 240) >> 4) == 15) {
                                byteBuffer3.get();
                            }
                            if (b10 == 9) {
                                int a6 = a(0, 0, true);
                                if (a6 >= 0) {
                                    iArr = new int[a6];
                                    for (int i7 = 0; i7 < a6; i7++) {
                                        iArr[i7] = a(iArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a6));
                                }
                            } else if (b10 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return iArr;
                    } else if (t3 instanceof long[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer4 = this.f52007a;
                            byte b11 = byteBuffer4.get();
                            byte b12 = (byte) (b11 & 15);
                            if (((b11 & 240) >> 4) == 15) {
                                byteBuffer4.get();
                            }
                            if (b12 == 9) {
                                int a7 = a(0, 0, true);
                                if (a7 >= 0) {
                                    jArr = new long[a7];
                                    for (int i8 = 0; i8 < a7; i8++) {
                                        jArr[i8] = a(jArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a7));
                                }
                            } else if (b12 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return jArr;
                    } else if (t3 instanceof float[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer5 = this.f52007a;
                            byte b13 = byteBuffer5.get();
                            byte b14 = (byte) (b13 & 15);
                            if (((b13 & 240) >> 4) == 15) {
                                byteBuffer5.get();
                            }
                            if (b14 == 9) {
                                int a8 = a(0, 0, true);
                                if (a8 >= 0) {
                                    fArr = new float[a8];
                                    for (int i9 = 0; i9 < a8; i9++) {
                                        fArr[i9] = a(fArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a8));
                                }
                            } else if (b14 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return fArr;
                    } else if (t3 instanceof double[]) {
                        if (b(i4)) {
                            ByteBuffer byteBuffer6 = this.f52007a;
                            byte b15 = byteBuffer6.get();
                            byte b16 = (byte) (b15 & 15);
                            if (((b15 & 240) >> 4) == 15) {
                                byteBuffer6.get();
                            }
                            if (b16 == 9) {
                                int a9 = a(0, 0, true);
                                if (a9 >= 0) {
                                    dArr = new double[a9];
                                    for (int i10 = 0; i10 < a9; i10++) {
                                        dArr[i10] = a(dArr[0], 0, true);
                                    }
                                } else {
                                    throw new Chamaeleon(Crux.a("size invalid: ", a9));
                                }
                            } else if (b16 != 11) {
                                throw new Chamaeleon("type mismatch.");
                            }
                        } else if (z3) {
                            throw new Chamaeleon("require field not exist.");
                        }
                        return dArr;
                    } else {
                        Object[] objArr = (Object[]) t3;
                        if (objArr.length != 0) {
                            return b(objArr[0], i4, z3);
                        }
                        throw new Chamaeleon("unable to get type of key and value.");
                    }
                }
                return a(i4, z3);
            }
            throw new Chamaeleon("read object error: unsupport type.");
        }
    }

    public Cygnus(byte[] bArr) {
        this.f52007a = ByteBuffer.wrap(bArr);
    }

    public Cygnus(byte[] bArr, int i4) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f52007a = wrap;
        wrap.position(i4);
    }
}
