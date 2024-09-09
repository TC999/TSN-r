package rx.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: LinkedArrayList.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final int f63925a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f63926b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f63927c;

    /* renamed from: d  reason: collision with root package name */
    volatile int f63928d;

    /* renamed from: e  reason: collision with root package name */
    int f63929e;

    public f(int i4) {
        this.f63925a = i4;
    }

    public int F() {
        return this.f63925a;
    }

    public Object[] G() {
        return this.f63926b;
    }

    public int H() {
        return this.f63929e;
    }

    public int I() {
        return this.f63928d;
    }

    public Object[] J() {
        return this.f63927c;
    }

    List<Object> K() {
        int i4 = this.f63925a;
        int i5 = this.f63928d;
        ArrayList arrayList = new ArrayList(i5 + 1);
        Object[] G = G();
        int i6 = 0;
        while (true) {
            int i7 = 0;
            while (i6 < i5) {
                arrayList.add(G[i7]);
                i6++;
                i7++;
                if (i7 == i4) {
                    break;
                }
            }
            return arrayList;
            G = G[i4];
        }
    }

    public void d(Object obj) {
        if (this.f63928d == 0) {
            Object[] objArr = new Object[this.f63925a + 1];
            this.f63926b = objArr;
            this.f63927c = objArr;
            objArr[0] = obj;
            this.f63929e = 1;
            this.f63928d = 1;
            return;
        }
        int i4 = this.f63929e;
        int i5 = this.f63925a;
        if (i4 == i5) {
            Object[] objArr2 = new Object[i5 + 1];
            objArr2[0] = obj;
            this.f63927c[i5] = objArr2;
            this.f63927c = objArr2;
            this.f63929e = 1;
            this.f63928d++;
            return;
        }
        this.f63927c[i4] = obj;
        this.f63929e = i4 + 1;
        this.f63928d++;
    }

    public String toString() {
        return K().toString();
    }
}
