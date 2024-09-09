package rx.internal.util;

import java.util.Arrays;
import rx.internal.util.unsafe.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: OpenHashSet.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class h<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f63931f = -1640531527;

    /* renamed from: a  reason: collision with root package name */
    final float f63932a;

    /* renamed from: b  reason: collision with root package name */
    int f63933b;

    /* renamed from: c  reason: collision with root package name */
    int f63934c;

    /* renamed from: d  reason: collision with root package name */
    int f63935d;

    /* renamed from: e  reason: collision with root package name */
    T[] f63936e;

    public h() {
        this(16, 0.75f);
    }

    static int d(int i4) {
        int i5 = i4 * (-1640531527);
        return i5 ^ (i5 >>> 16);
    }

    public boolean a(T t3) {
        T t4;
        T[] tArr = this.f63936e;
        int i4 = this.f63933b;
        int d4 = d(t3.hashCode()) & i4;
        T t5 = tArr[d4];
        if (t5 != null) {
            if (t5.equals(t3)) {
                return false;
            }
            do {
                d4 = (d4 + 1) & i4;
                t4 = tArr[d4];
                if (t4 == null) {
                }
            } while (!t4.equals(t3));
            return false;
        }
        tArr[d4] = t3;
        int i5 = this.f63934c + 1;
        this.f63934c = i5;
        if (i5 >= this.f63935d) {
            e();
        }
        return true;
    }

    public void b(rx.functions.b<? super T> bVar) {
        if (this.f63934c == 0) {
            return;
        }
        T[] tArr = this.f63936e;
        for (T t3 : tArr) {
            Object obj = (Object) t3;
            if (obj != 0) {
                bVar.call(obj);
            }
        }
        Arrays.fill(tArr, (Object) null);
        this.f63934c = 0;
    }

    public boolean c() {
        return this.f63934c == 0;
    }

    void e() {
        T[] tArr = this.f63936e;
        int length = tArr.length;
        int i4 = length << 1;
        int i5 = i4 - 1;
        T[] tArr2 = (T[]) new Object[i4];
        int i6 = this.f63934c;
        while (true) {
            int i7 = i6 - 1;
            if (i6 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int d4 = d(tArr[length].hashCode()) & i5;
                if (tArr2[d4] != null) {
                    do {
                        d4 = (d4 + 1) & i5;
                    } while (tArr2[d4] != null);
                }
                tArr2[d4] = tArr[length];
                i6 = i7;
            } else {
                this.f63933b = i5;
                this.f63935d = (int) (i4 * this.f63932a);
                this.f63936e = tArr2;
                return;
            }
        }
    }

    public boolean f(T t3) {
        T t4;
        T[] tArr = this.f63936e;
        int i4 = this.f63933b;
        int d4 = d(t3.hashCode()) & i4;
        T t5 = tArr[d4];
        if (t5 == null) {
            return false;
        }
        if (t5.equals(t3)) {
            return g(d4, tArr, i4);
        }
        do {
            d4 = (d4 + 1) & i4;
            t4 = tArr[d4];
            if (t4 == null) {
                return false;
            }
        } while (!t4.equals(t3));
        return g(d4, tArr, i4);
    }

    boolean g(int i4, T[] tArr, int i5) {
        int i6;
        T t3;
        this.f63934c--;
        while (true) {
            int i7 = i4 + 1;
            while (true) {
                i6 = i7 & i5;
                t3 = tArr[i6];
                if (t3 == null) {
                    tArr[i4] = null;
                    return true;
                }
                int d4 = d(t3.hashCode()) & i5;
                if (i4 > i6) {
                    if (i4 >= d4 && d4 > i6) {
                        break;
                    }
                    i7 = i6 + 1;
                } else if (i4 < d4 && d4 <= i6) {
                    i7 = i6 + 1;
                }
            }
            tArr[i4] = t3;
            i4 = i6;
        }
    }

    public void h() {
        this.f63934c = 0;
        this.f63936e = (T[]) new Object[0];
    }

    public T[] i() {
        return this.f63936e;
    }

    public h(int i4) {
        this(i4, 0.75f);
    }

    public h(int i4, float f4) {
        this.f63932a = f4;
        int b4 = p.b(i4);
        this.f63933b = b4 - 1;
        this.f63935d = (int) (f4 * b4);
        this.f63936e = (T[]) new Object[b4];
    }
}
