package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1350k;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.a.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1354l {

    /* renamed from: a */
    int f2395a;

    /* renamed from: b */
    AbstractC1350k f2396b;

    /* renamed from: c */
    AbstractC1350k f2397c;

    /* renamed from: d */
    Interpolator f2398d;

    /* renamed from: e */
    ArrayList<AbstractC1350k> f2399e;

    /* renamed from: f */
    InterfaceC1325F f2400f;

    public C1354l(AbstractC1350k... abstractC1350kArr) {
        this.f2395a = abstractC1350kArr.length;
        ArrayList<AbstractC1350k> arrayList = new ArrayList<>();
        this.f2399e = arrayList;
        arrayList.addAll(Arrays.asList(abstractC1350kArr));
        this.f2396b = this.f2399e.get(0);
        AbstractC1350k abstractC1350k = this.f2399e.get(this.f2395a - 1);
        this.f2397c = abstractC1350k;
        this.f2398d = abstractC1350k.m57074b();
    }

    /* renamed from: a */
    public static C1354l m57062a(float... fArr) {
        int length = fArr.length;
        AbstractC1350k.C1351a[] c1351aArr = new AbstractC1350k.C1351a[Math.max(length, 2)];
        if (length == 1) {
            c1351aArr[0] = (AbstractC1350k.C1351a) AbstractC1350k.m57079a(0.0f);
            c1351aArr[1] = (AbstractC1350k.C1351a) AbstractC1350k.m57078a(1.0f, fArr[0]);
        } else {
            c1351aArr[0] = (AbstractC1350k.C1351a) AbstractC1350k.m57078a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                c1351aArr[i] = (AbstractC1350k.C1351a) AbstractC1350k.m57078a(i / (length - 1), fArr[i]);
            }
        }
        return new C1347h(c1351aArr);
    }

    /* renamed from: a */
    public static C1354l m57061a(int... iArr) {
        int length = iArr.length;
        AbstractC1350k.C1352b[] c1352bArr = new AbstractC1350k.C1352b[Math.max(length, 2)];
        if (length == 1) {
            c1352bArr[0] = (AbstractC1350k.C1352b) AbstractC1350k.m57073b(0.0f);
            c1352bArr[1] = (AbstractC1350k.C1352b) AbstractC1350k.m57077a(1.0f, iArr[0]);
        } else {
            c1352bArr[0] = (AbstractC1350k.C1352b) AbstractC1350k.m57077a(0.0f, iArr[0]);
            for (int i = 1; i < length; i++) {
                c1352bArr[i] = (AbstractC1350k.C1352b) AbstractC1350k.m57077a(i / (length - 1), iArr[i]);
            }
        }
        return new C1349j(c1352bArr);
    }

    /* renamed from: a */
    public static C1354l m57060a(AbstractC1350k... abstractC1350kArr) {
        int length = abstractC1350kArr.length;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < length; i2++) {
            if (abstractC1350kArr[i2] instanceof AbstractC1350k.C1351a) {
                z = true;
            } else if (abstractC1350kArr[i2] instanceof AbstractC1350k.C1352b) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            AbstractC1350k.C1351a[] c1351aArr = new AbstractC1350k.C1351a[length];
            while (i < length) {
                c1351aArr[i] = (AbstractC1350k.C1351a) abstractC1350kArr[i];
                i++;
            }
            return new C1347h(c1351aArr);
        } else if (!z2 || z || z3) {
            return new C1354l(abstractC1350kArr);
        } else {
            AbstractC1350k.C1352b[] c1352bArr = new AbstractC1350k.C1352b[length];
            while (i < length) {
                c1352bArr[i] = (AbstractC1350k.C1352b) abstractC1350kArr[i];
                i++;
            }
            return new C1349j(c1352bArr);
        }
    }

    /* renamed from: a */
    public static C1354l m57059a(Object... objArr) {
        int length = objArr.length;
        AbstractC1350k.C1353c[] c1353cArr = new AbstractC1350k.C1353c[Math.max(length, 2)];
        if (length == 1) {
            c1353cArr[0] = (AbstractC1350k.C1353c) AbstractC1350k.m57071c(0.0f);
            c1353cArr[1] = (AbstractC1350k.C1353c) AbstractC1350k.m57076a(1.0f, objArr[0]);
        } else {
            c1353cArr[0] = (AbstractC1350k.C1353c) AbstractC1350k.m57076a(0.0f, objArr[0]);
            for (int i = 1; i < length; i++) {
                c1353cArr[i] = (AbstractC1350k.C1353c) AbstractC1350k.m57076a(i / (length - 1), objArr[i]);
            }
        }
        return new C1354l(c1353cArr);
    }

    /* renamed from: a */
    public Object mo57064a(float f) {
        int i = this.f2395a;
        if (i == 2) {
            Interpolator interpolator = this.f2398d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            return this.f2400f.evaluate(f, this.f2396b.mo57065d(), this.f2397c.mo57065d());
        }
        int i2 = 1;
        if (f <= 0.0f) {
            AbstractC1350k abstractC1350k = this.f2399e.get(1);
            Interpolator m57074b = abstractC1350k.m57074b();
            if (m57074b != null) {
                f = m57074b.getInterpolation(f);
            }
            float m57080a = this.f2396b.m57080a();
            return this.f2400f.evaluate((f - m57080a) / (abstractC1350k.m57080a() - m57080a), this.f2396b.mo57065d(), abstractC1350k.mo57065d());
        } else if (f >= 1.0f) {
            AbstractC1350k abstractC1350k2 = this.f2399e.get(i - 2);
            Interpolator m57074b2 = this.f2397c.m57074b();
            if (m57074b2 != null) {
                f = m57074b2.getInterpolation(f);
            }
            float m57080a2 = abstractC1350k2.m57080a();
            return this.f2400f.evaluate((f - m57080a2) / (this.f2397c.m57080a() - m57080a2), abstractC1350k2.mo57065d(), this.f2397c.mo57065d());
        } else {
            AbstractC1350k abstractC1350k3 = this.f2396b;
            while (i2 < this.f2395a) {
                AbstractC1350k abstractC1350k4 = this.f2399e.get(i2);
                if (f < abstractC1350k4.m57080a()) {
                    Interpolator m57074b3 = abstractC1350k4.m57074b();
                    if (m57074b3 != null) {
                        f = m57074b3.getInterpolation(f);
                    }
                    float m57080a3 = abstractC1350k3.m57080a();
                    return this.f2400f.evaluate((f - m57080a3) / (abstractC1350k4.m57080a() - m57080a3), abstractC1350k3.mo57065d(), abstractC1350k4.mo57065d());
                }
                i2++;
                abstractC1350k3 = abstractC1350k4;
            }
            return this.f2397c.mo57065d();
        }
    }

    /* renamed from: a */
    public void m57063a(InterfaceC1325F interfaceC1325F) {
        this.f2400f = interfaceC1325F;
    }

    @Override // 
    /* renamed from: clone */
    public C1354l mo60091clone() {
        ArrayList<AbstractC1350k> arrayList = this.f2399e;
        int size = arrayList.size();
        AbstractC1350k[] abstractC1350kArr = new AbstractC1350k[size];
        for (int i = 0; i < size; i++) {
            abstractC1350kArr[i] = arrayList.get(i).mo60092clone();
        }
        return new C1354l(abstractC1350kArr);
    }

    public String toString() {
        String str = " ";
        for (int i = 0; i < this.f2395a; i++) {
            str = str + this.f2399e.get(i).mo57065d() + "  ";
        }
        return str;
    }
}
