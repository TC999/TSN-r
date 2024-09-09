package com.bytedance.sdk.component.widget.recycler.c.w;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux<K, V> {

    /* renamed from: c  reason: collision with root package name */
    static Object[] f30577c;
    static int sr;

    /* renamed from: w  reason: collision with root package name */
    static int f30578w;
    static Object[] xv;
    int[] ux = w.f30581c;

    /* renamed from: f  reason: collision with root package name */
    Object[] f30579f = w.xv;

    /* renamed from: r  reason: collision with root package name */
    int f30580r = 0;

    private static int c(int[] iArr, int i4, int i5) {
        try {
            return w.c(iArr, i4, i5);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void sr(int i4) {
        if (i4 == 8) {
            synchronized (c.class) {
                Object[] objArr = xv;
                if (objArr != null) {
                    this.f30579f = objArr;
                    xv = (Object[]) objArr[0];
                    this.ux = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sr--;
                    return;
                }
            }
        } else if (i4 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f30577c;
                if (objArr2 != null) {
                    this.f30579f = objArr2;
                    f30577c = (Object[]) objArr2[0];
                    this.ux = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f30578w--;
                    return;
                }
            }
        }
        this.ux = new int[i4];
        this.f30579f = new Object[i4 << 1];
    }

    public void clear() {
        int i4 = this.f30580r;
        if (i4 > 0) {
            int[] iArr = this.ux;
            Object[] objArr = this.f30579f;
            this.ux = w.f30581c;
            this.f30579f = w.xv;
            this.f30580r = 0;
            c(iArr, objArr, i4);
        }
        if (this.f30580r > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return w(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ux) {
            ux uxVar = (ux) obj;
            if (size() != uxVar.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f30580r; i4++) {
                try {
                    K c4 = c(i4);
                    V w3 = w(i4);
                    Object obj2 = uxVar.get(c4);
                    if (w3 == null) {
                        if (obj2 != null || !uxVar.containsKey(c4)) {
                            return false;
                        }
                    } else if (!w3.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i5 = 0; i5 < this.f30580r; i5++) {
                try {
                    K c5 = c(i5);
                    V w4 = w(i5);
                    Object obj3 = map.get(c5);
                    if (w4 == null) {
                        if (obj3 != null || !map.containsKey(c5)) {
                            return false;
                        }
                    } else if (!w4.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public V get(Object obj) {
        int c4 = c(obj);
        if (c4 >= 0) {
            return (V) this.f30579f[(c4 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.ux;
        Object[] objArr = this.f30579f;
        int i4 = this.f30580r;
        int i5 = 1;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            i7 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i6];
            i6++;
            i5 += 2;
        }
        return i7;
    }

    public boolean isEmpty() {
        return this.f30580r <= 0;
    }

    public V put(K k4, V v3) {
        int i4;
        int c4;
        int i5 = this.f30580r;
        if (k4 == null) {
            c4 = c();
            i4 = 0;
        } else {
            int hashCode = k4.hashCode();
            i4 = hashCode;
            c4 = c(k4, hashCode);
        }
        if (c4 >= 0) {
            int i6 = (c4 << 1) + 1;
            Object[] objArr = this.f30579f;
            V v4 = (V) objArr[i6];
            objArr[i6] = v3;
            return v4;
        }
        int i7 = c4 ^ (-1);
        int[] iArr = this.ux;
        if (i5 >= iArr.length) {
            int i8 = 4;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i8 = 8;
            }
            Object[] objArr2 = this.f30579f;
            sr(i8);
            if (i5 == this.f30580r) {
                int[] iArr2 = this.ux;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f30579f, 0, objArr2.length);
                }
                c(iArr, objArr2, i5);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr3 = this.ux;
            int i9 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i9, i5 - i7);
            Object[] objArr3 = this.f30579f;
            System.arraycopy(objArr3, i7 << 1, objArr3, i9 << 1, (this.f30580r - i7) << 1);
        }
        int i10 = this.f30580r;
        if (i5 == i10) {
            int[] iArr4 = this.ux;
            if (i7 < iArr4.length) {
                iArr4[i7] = i4;
                Object[] objArr4 = this.f30579f;
                int i11 = i7 << 1;
                objArr4[i11] = k4;
                objArr4[i11 + 1] = v3;
                this.f30580r = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int c4 = c(obj);
        if (c4 >= 0) {
            return xv(c4);
        }
        return null;
    }

    public int size() {
        return this.f30580r;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f30580r * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.f30580r; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            K c4 = c(i4);
            if (c4 != this) {
                sb.append(c4);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V w3 = w(i4);
            if (w3 != this) {
                sb.append(w3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    int w(Object obj) {
        int i4 = this.f30580r * 2;
        Object[] objArr = this.f30579f;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (obj.equals(objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public V xv(int i4) {
        Object[] objArr = this.f30579f;
        int i5 = i4 << 1;
        V v3 = (V) objArr[i5 + 1];
        int i6 = this.f30580r;
        int i7 = 0;
        if (i6 <= 1) {
            c(this.ux, objArr, i6);
            this.ux = w.f30581c;
            this.f30579f = w.xv;
        } else {
            int i8 = i6 - 1;
            int[] iArr = this.ux;
            if (iArr.length > 8 && i6 < iArr.length / 3) {
                sr(i6 > 8 ? i6 + (i6 >> 1) : 8);
                if (i6 != this.f30580r) {
                    throw new ConcurrentModificationException();
                }
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.ux, 0, i4);
                    System.arraycopy(objArr, 0, this.f30579f, 0, i5);
                }
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    int i10 = i8 - i4;
                    System.arraycopy(iArr, i9, this.ux, i4, i10);
                    System.arraycopy(objArr, i9 << 1, this.f30579f, i5, i10 << 1);
                }
            } else {
                if (i4 < i8) {
                    int i11 = i4 + 1;
                    int i12 = i8 - i4;
                    System.arraycopy(iArr, i11, iArr, i4, i12);
                    Object[] objArr2 = this.f30579f;
                    System.arraycopy(objArr2, i11 << 1, objArr2, i5, i12 << 1);
                }
                Object[] objArr3 = this.f30579f;
                int i13 = i8 << 1;
                objArr3[i13] = null;
                objArr3[i13 + 1] = null;
            }
            i7 = i8;
        }
        if (i6 == this.f30580r) {
            this.f30580r = i7;
            return v3;
        }
        throw new ConcurrentModificationException();
    }

    int c(Object obj, int i4) {
        int i5 = this.f30580r;
        if (i5 == 0) {
            return -1;
        }
        int c4 = c(this.ux, i5, i4);
        if (c4 >= 0 && !obj.equals(this.f30579f[c4 << 1])) {
            int i6 = c4 + 1;
            while (i6 < i5 && this.ux[i6] == i4) {
                if (obj.equals(this.f30579f[i6 << 1])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = c4 - 1; i7 >= 0 && this.ux[i7] == i4; i7--) {
                if (obj.equals(this.f30579f[i7 << 1])) {
                    return i7;
                }
            }
            return i6 ^ (-1);
        }
        return c4;
    }

    public V w(int i4) {
        return (V) this.f30579f[(i4 << 1) + 1];
    }

    int c() {
        int i4 = this.f30580r;
        if (i4 == 0) {
            return -1;
        }
        int c4 = c(this.ux, i4, 0);
        if (c4 >= 0 && this.f30579f[c4 << 1] != null) {
            int i5 = c4 + 1;
            while (i5 < i4 && this.ux[i5] == 0) {
                if (this.f30579f[i5 << 1] == null) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = c4 - 1; i6 >= 0 && this.ux[i6] == 0; i6--) {
                if (this.f30579f[i6 << 1] == null) {
                    return i6;
                }
            }
            return i5 ^ (-1);
        }
        return c4;
    }

    private static void c(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (sr < 10) {
                    objArr[0] = xv;
                    objArr[1] = iArr;
                    for (int i5 = (i4 << 1) - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    xv = objArr;
                    sr++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f30578w < 10) {
                    objArr[0] = f30577c;
                    objArr[1] = iArr;
                    for (int i6 = (i4 << 1) - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f30577c = objArr;
                    f30578w++;
                }
            }
        }
    }

    public int c(Object obj) {
        return obj == null ? c() : c(obj, obj.hashCode());
    }

    public K c(int i4) {
        return (K) this.f30579f[i4 << 1];
    }
}
