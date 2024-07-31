package p640rx.internal.util;

import java.util.ArrayList;
import java.util.List;

/* renamed from: rx.internal.util.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class LinkedArrayList {

    /* renamed from: a */
    final int f46494a;

    /* renamed from: b */
    Object[] f46495b;

    /* renamed from: c */
    Object[] f46496c;

    /* renamed from: d */
    volatile int f46497d;

    /* renamed from: e */
    int f46498e;

    public LinkedArrayList(int i) {
        this.f46494a = i;
    }

    /* renamed from: F */
    public int m855F() {
        return this.f46494a;
    }

    /* renamed from: G */
    public Object[] m854G() {
        return this.f46495b;
    }

    /* renamed from: H */
    public int m853H() {
        return this.f46498e;
    }

    /* renamed from: I */
    public int m852I() {
        return this.f46497d;
    }

    /* renamed from: J */
    public Object[] m851J() {
        return this.f46496c;
    }

    /* renamed from: K */
    List<Object> m850K() {
        int i = this.f46494a;
        int i2 = this.f46497d;
        ArrayList arrayList = new ArrayList(i2 + 1);
        Object[] m854G = m854G();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(m854G[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    break;
                }
            }
            return arrayList;
            m854G = m854G[i];
        }
    }

    /* renamed from: d */
    public void m849d(Object obj) {
        if (this.f46497d == 0) {
            Object[] objArr = new Object[this.f46494a + 1];
            this.f46495b = objArr;
            this.f46496c = objArr;
            objArr[0] = obj;
            this.f46498e = 1;
            this.f46497d = 1;
            return;
        }
        int i = this.f46498e;
        int i2 = this.f46494a;
        if (i == i2) {
            Object[] objArr2 = new Object[i2 + 1];
            objArr2[0] = obj;
            this.f46496c[i2] = objArr2;
            this.f46496c = objArr2;
            this.f46498e = 1;
            this.f46497d++;
            return;
        }
        this.f46496c[i] = obj;
        this.f46498e = i + 1;
        this.f46497d++;
    }

    public String toString() {
        return m850K().toString();
    }
}
