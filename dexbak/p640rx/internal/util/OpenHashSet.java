package p640rx.internal.util;

import java.util.Arrays;
import p640rx.functions.Action1;
import p640rx.internal.util.unsafe.Pow2;

/* renamed from: rx.internal.util.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OpenHashSet<T> {

    /* renamed from: f */
    private static final int f46500f = -1640531527;

    /* renamed from: a */
    final float f46501a;

    /* renamed from: b */
    int f46502b;

    /* renamed from: c */
    int f46503c;

    /* renamed from: d */
    int f46504d;

    /* renamed from: e */
    T[] f46505e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    /* renamed from: d */
    static int m845d(int i) {
        int i2 = i * f46500f;
        return i2 ^ (i2 >>> 16);
    }

    /* renamed from: a */
    public boolean m848a(T t) {
        T t2;
        T[] tArr = this.f46505e;
        int i = this.f46502b;
        int m845d = m845d(t.hashCode()) & i;
        T t3 = tArr[m845d];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                m845d = (m845d + 1) & i;
                t2 = tArr[m845d];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[m845d] = t;
        int i2 = this.f46503c + 1;
        this.f46503c = i2;
        if (i2 >= this.f46504d) {
            m844e();
        }
        return true;
    }

    /* renamed from: b */
    public void m847b(Action1<? super T> action1) {
        if (this.f46503c == 0) {
            return;
        }
        T[] tArr = this.f46505e;
        for (T t : tArr) {
            Object obj = (Object) t;
            if (obj != 0) {
                action1.call(obj);
            }
        }
        Arrays.fill(tArr, (Object) null);
        this.f46503c = 0;
    }

    /* renamed from: c */
    public boolean m846c() {
        return this.f46503c == 0;
    }

    /* renamed from: e */
    void m844e() {
        T[] tArr = this.f46505e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f46503c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int m845d = m845d(tArr[length].hashCode()) & i2;
                if (tArr2[m845d] != null) {
                    do {
                        m845d = (m845d + 1) & i2;
                    } while (tArr2[m845d] != null);
                }
                tArr2[m845d] = tArr[length];
                i3 = i4;
            } else {
                this.f46502b = i2;
                this.f46504d = (int) (i * this.f46501a);
                this.f46505e = tArr2;
                return;
            }
        }
    }

    /* renamed from: f */
    public boolean m843f(T t) {
        T t2;
        T[] tArr = this.f46505e;
        int i = this.f46502b;
        int m845d = m845d(t.hashCode()) & i;
        T t3 = tArr[m845d];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return m842g(m845d, tArr, i);
        }
        do {
            m845d = (m845d + 1) & i;
            t2 = tArr[m845d];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return m842g(m845d, tArr, i);
    }

    /* renamed from: g */
    boolean m842g(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f46503c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int m845d = m845d(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= m845d && m845d > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < m845d && m845d <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    /* renamed from: h */
    public void m841h() {
        this.f46503c = 0;
        this.f46505e = (T[]) new Object[0];
    }

    /* renamed from: i */
    public T[] m840i() {
        return this.f46505e;
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.f46501a = f;
        int m756b = Pow2.m756b(i);
        this.f46502b = m756b - 1;
        this.f46504d = (int) (f * m756b);
        this.f46505e = (T[]) new Object[m756b];
    }
}
