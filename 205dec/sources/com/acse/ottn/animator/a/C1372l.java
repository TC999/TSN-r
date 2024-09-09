package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1371k;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.a.l  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1372l {

    /* renamed from: a  reason: collision with root package name */
    int f4942a;

    /* renamed from: b  reason: collision with root package name */
    AbstractC1371k f4943b;

    /* renamed from: c  reason: collision with root package name */
    AbstractC1371k f4944c;

    /* renamed from: d  reason: collision with root package name */
    Interpolator f4945d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<AbstractC1371k> f4946e;

    /* renamed from: f  reason: collision with root package name */
    F f4947f;

    public C1372l(AbstractC1371k... abstractC1371kArr) {
        this.f4942a = abstractC1371kArr.length;
        ArrayList<AbstractC1371k> arrayList = new ArrayList<>();
        this.f4946e = arrayList;
        arrayList.addAll(Arrays.asList(abstractC1371kArr));
        this.f4943b = this.f4946e.get(0);
        AbstractC1371k abstractC1371k = this.f4946e.get(this.f4942a - 1);
        this.f4944c = abstractC1371k;
        this.f4945d = abstractC1371k.b();
    }

    public static C1372l a(float... fArr) {
        int length = fArr.length;
        AbstractC1371k.a[] aVarArr = new AbstractC1371k.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (AbstractC1371k.a) AbstractC1371k.a(0.0f);
            aVarArr[1] = (AbstractC1371k.a) AbstractC1371k.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (AbstractC1371k.a) AbstractC1371k.a(0.0f, fArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                aVarArr[i4] = (AbstractC1371k.a) AbstractC1371k.a(i4 / (length - 1), fArr[i4]);
            }
        }
        return new C1368h(aVarArr);
    }

    public static C1372l a(int... iArr) {
        int length = iArr.length;
        AbstractC1371k.b[] bVarArr = new AbstractC1371k.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (AbstractC1371k.b) AbstractC1371k.b(0.0f);
            bVarArr[1] = (AbstractC1371k.b) AbstractC1371k.a(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (AbstractC1371k.b) AbstractC1371k.a(0.0f, iArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                bVarArr[i4] = (AbstractC1371k.b) AbstractC1371k.a(i4 / (length - 1), iArr[i4]);
            }
        }
        return new C1370j(bVarArr);
    }

    public static C1372l a(AbstractC1371k... abstractC1371kArr) {
        int length = abstractC1371kArr.length;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (int i5 = 0; i5 < length; i5++) {
            if (abstractC1371kArr[i5] instanceof AbstractC1371k.a) {
                z3 = true;
            } else if (abstractC1371kArr[i5] instanceof AbstractC1371k.b) {
                z4 = true;
            } else {
                z5 = true;
            }
        }
        if (z3 && !z4 && !z5) {
            AbstractC1371k.a[] aVarArr = new AbstractC1371k.a[length];
            while (i4 < length) {
                aVarArr[i4] = (AbstractC1371k.a) abstractC1371kArr[i4];
                i4++;
            }
            return new C1368h(aVarArr);
        } else if (!z4 || z3 || z5) {
            return new C1372l(abstractC1371kArr);
        } else {
            AbstractC1371k.b[] bVarArr = new AbstractC1371k.b[length];
            while (i4 < length) {
                bVarArr[i4] = (AbstractC1371k.b) abstractC1371kArr[i4];
                i4++;
            }
            return new C1370j(bVarArr);
        }
    }

    public static C1372l a(Object... objArr) {
        int length = objArr.length;
        AbstractC1371k.c[] cVarArr = new AbstractC1371k.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (AbstractC1371k.c) AbstractC1371k.c(0.0f);
            cVarArr[1] = (AbstractC1371k.c) AbstractC1371k.a(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (AbstractC1371k.c) AbstractC1371k.a(0.0f, objArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                cVarArr[i4] = (AbstractC1371k.c) AbstractC1371k.a(i4 / (length - 1), objArr[i4]);
            }
        }
        return new C1372l(cVarArr);
    }

    public Object a(float f4) {
        int i4 = this.f4942a;
        if (i4 == 2) {
            Interpolator interpolator = this.f4945d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            return this.f4947f.evaluate(f4, this.f4943b.d(), this.f4944c.d());
        }
        int i5 = 1;
        if (f4 <= 0.0f) {
            AbstractC1371k abstractC1371k = this.f4946e.get(1);
            Interpolator b4 = abstractC1371k.b();
            if (b4 != null) {
                f4 = b4.getInterpolation(f4);
            }
            float a4 = this.f4943b.a();
            return this.f4947f.evaluate((f4 - a4) / (abstractC1371k.a() - a4), this.f4943b.d(), abstractC1371k.d());
        } else if (f4 >= 1.0f) {
            AbstractC1371k abstractC1371k2 = this.f4946e.get(i4 - 2);
            Interpolator b5 = this.f4944c.b();
            if (b5 != null) {
                f4 = b5.getInterpolation(f4);
            }
            float a5 = abstractC1371k2.a();
            return this.f4947f.evaluate((f4 - a5) / (this.f4944c.a() - a5), abstractC1371k2.d(), this.f4944c.d());
        } else {
            AbstractC1371k abstractC1371k3 = this.f4943b;
            while (i5 < this.f4942a) {
                AbstractC1371k abstractC1371k4 = this.f4946e.get(i5);
                if (f4 < abstractC1371k4.a()) {
                    Interpolator b6 = abstractC1371k4.b();
                    if (b6 != null) {
                        f4 = b6.getInterpolation(f4);
                    }
                    float a6 = abstractC1371k3.a();
                    return this.f4947f.evaluate((f4 - a6) / (abstractC1371k4.a() - a6), abstractC1371k3.d(), abstractC1371k4.d());
                }
                i5++;
                abstractC1371k3 = abstractC1371k4;
            }
            return this.f4944c.d();
        }
    }

    public void a(F f4) {
        this.f4947f = f4;
    }

    @Override // 
    /* renamed from: clone */
    public C1372l mo12clone() {
        ArrayList<AbstractC1371k> arrayList = this.f4946e;
        int size = arrayList.size();
        AbstractC1371k[] abstractC1371kArr = new AbstractC1371k[size];
        for (int i4 = 0; i4 < size; i4++) {
            abstractC1371kArr[i4] = arrayList.get(i4).mo13clone();
        }
        return new C1372l(abstractC1371kArr);
    }

    public String toString() {
        String str = " ";
        for (int i4 = 0; i4 < this.f4942a; i4++) {
            str = str + this.f4946e.get(i4).d() + "  ";
        }
        return str;
    }
}
