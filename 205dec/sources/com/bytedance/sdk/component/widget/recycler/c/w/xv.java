package com.bytedance.sdk.component.widget.recycler.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv<E> implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f30583c = new Object();
    private Object[] sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f30584w;
    private long[] xv;

    public xv() {
        this(10);
    }

    private void sr() {
        int i4 = this.ux;
        long[] jArr = this.xv;
        Object[] objArr = this.sr;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i6];
            if (obj != f30583c) {
                if (i6 != i5) {
                    jArr[i5] = jArr[i6];
                    objArr[i5] = obj;
                    objArr[i6] = null;
                }
                i5++;
            }
        }
        this.f30584w = false;
        this.ux = i5;
    }

    /* renamed from: c */
    public xv<E> clone() {
        try {
            xv<E> xvVar = (xv) super.clone();
            xvVar.xv = (long[]) this.xv.clone();
            xvVar.sr = (Object[]) this.sr.clone();
            return xvVar;
        } catch (CloneNotSupportedException e4) {
            throw new AssertionError(e4);
        }
    }

    public void delete(long j4) {
        int c4 = w.c(this.xv, this.ux, j4);
        if (c4 >= 0) {
            Object[] objArr = this.sr;
            Object obj = objArr[c4];
            Object obj2 = f30583c;
            if (obj != obj2) {
                objArr[c4] = obj2;
                this.f30584w = true;
            }
        }
    }

    public String toString() {
        if (w() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.ux * 28);
        sb.append('{');
        for (int i4 = 0; i4 < this.ux; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(w(i4));
            sb.append('=');
            E xv = xv(i4);
            if (xv != this) {
                sb.append(xv);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void w(long j4, E e4) {
        int c4 = w.c(this.xv, this.ux, j4);
        if (c4 >= 0) {
            this.sr[c4] = e4;
            return;
        }
        int i4 = c4 ^ (-1);
        int i5 = this.ux;
        if (i4 < i5) {
            Object[] objArr = this.sr;
            if (objArr[i4] == f30583c) {
                this.xv[i4] = j4;
                objArr[i4] = e4;
                return;
            }
        }
        if (this.f30584w && i5 >= this.xv.length) {
            sr();
            i4 = w.c(this.xv, this.ux, j4) ^ (-1);
        }
        int i6 = this.ux;
        if (i6 >= this.xv.length) {
            int c5 = w.c(i6 + 1);
            long[] jArr = new long[c5];
            Object[] objArr2 = new Object[c5];
            long[] jArr2 = this.xv;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.sr;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.xv = jArr;
            this.sr = objArr2;
        }
        int i7 = this.ux;
        if (i7 - i4 != 0) {
            long[] jArr3 = this.xv;
            int i8 = i4 + 1;
            System.arraycopy(jArr3, i4, jArr3, i8, i7 - i4);
            Object[] objArr4 = this.sr;
            System.arraycopy(objArr4, i4, objArr4, i8, this.ux - i4);
        }
        this.xv[i4] = j4;
        this.sr[i4] = e4;
        this.ux++;
    }

    public E xv(int i4) {
        if (this.f30584w) {
            sr();
        }
        return (E) this.sr[i4];
    }

    public xv(int i4) {
        this.f30584w = false;
        if (i4 == 0) {
            this.xv = w.f30582w;
            this.sr = w.xv;
        } else {
            int c4 = w.c(i4);
            this.xv = new long[c4];
            this.sr = new Object[c4];
        }
        this.ux = 0;
    }

    public void xv() {
        int i4 = this.ux;
        Object[] objArr = this.sr;
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = null;
        }
        this.ux = 0;
        this.f30584w = false;
    }

    public E c(long j4) {
        return c(j4, null);
    }

    public E c(long j4, E e4) {
        int c4 = w.c(this.xv, this.ux, j4);
        if (c4 >= 0) {
            Object[] objArr = this.sr;
            return objArr[c4] != f30583c ? (E) objArr[c4] : e4;
        }
        return e4;
    }

    public void c(int i4) {
        Object[] objArr = this.sr;
        Object obj = objArr[i4];
        Object obj2 = f30583c;
        if (obj != obj2) {
            objArr[i4] = obj2;
            this.f30584w = true;
        }
    }

    public int w() {
        if (this.f30584w) {
            sr();
        }
        return this.ux;
    }

    public long w(int i4) {
        if (this.f30584w) {
            sr();
        }
        return this.xv[i4];
    }
}
