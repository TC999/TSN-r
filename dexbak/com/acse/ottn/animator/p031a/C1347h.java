package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1350k;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1347h extends C1354l {

    /* renamed from: g */
    private float f2380g;

    /* renamed from: h */
    private float f2381h;

    /* renamed from: i */
    private float f2382i;

    /* renamed from: j */
    private boolean f2383j;

    public C1347h(AbstractC1350k.C1351a... c1351aArr) {
        super(c1351aArr);
        this.f2383j = true;
    }

    @Override // com.acse.ottn.animator.p031a.C1354l
    /* renamed from: a */
    public Object mo57064a(float f) {
        return Float.valueOf(m57083b(f));
    }

    /* renamed from: b */
    public float m57083b(float f) {
        Object mo57065d;
        int i = this.f2395a;
        if (i != 2) {
            if (f > 0.0f) {
                if (f < 1.0f) {
                    AbstractC1350k.C1351a c1351a = (AbstractC1350k.C1351a) this.f2399e.get(0);
                    int i2 = 1;
                    while (true) {
                        int i3 = this.f2395a;
                        if (i2 >= i3) {
                            mo57065d = this.f2399e.get(i3 - 1).mo57065d();
                            break;
                        }
                        AbstractC1350k.C1351a c1351a2 = (AbstractC1350k.C1351a) this.f2399e.get(i2);
                        if (f < c1351a2.m57080a()) {
                            Interpolator m57074b = c1351a2.m57074b();
                            if (m57074b != null) {
                                f = m57074b.getInterpolation(f);
                            }
                            float m57080a = (f - c1351a.m57080a()) / (c1351a2.m57080a() - c1351a.m57080a());
                            float m57068f = c1351a.m57068f();
                            float m57068f2 = c1351a2.m57068f();
                            InterfaceC1325F interfaceC1325F = this.f2400f;
                            return interfaceC1325F == null ? m57068f + (m57080a * (m57068f2 - m57068f)) : ((Number) interfaceC1325F.evaluate(m57080a, Float.valueOf(m57068f), Float.valueOf(m57068f2))).floatValue();
                        }
                        i2++;
                        c1351a = c1351a2;
                    }
                } else {
                    AbstractC1350k.C1351a c1351a3 = (AbstractC1350k.C1351a) this.f2399e.get(i - 2);
                    AbstractC1350k.C1351a c1351a4 = (AbstractC1350k.C1351a) this.f2399e.get(this.f2395a - 1);
                    float m57068f3 = c1351a3.m57068f();
                    float m57068f4 = c1351a4.m57068f();
                    float m57080a2 = c1351a3.m57080a();
                    float m57080a3 = c1351a4.m57080a();
                    Interpolator m57074b2 = c1351a4.m57074b();
                    if (m57074b2 != null) {
                        f = m57074b2.getInterpolation(f);
                    }
                    float f2 = (f - m57080a2) / (m57080a3 - m57080a2);
                    InterfaceC1325F interfaceC1325F2 = this.f2400f;
                    return interfaceC1325F2 == null ? m57068f3 + (f2 * (m57068f4 - m57068f3)) : ((Number) interfaceC1325F2.evaluate(f2, Float.valueOf(m57068f3), Float.valueOf(m57068f4))).floatValue();
                }
            } else {
                AbstractC1350k.C1351a c1351a5 = (AbstractC1350k.C1351a) this.f2399e.get(0);
                AbstractC1350k.C1351a c1351a6 = (AbstractC1350k.C1351a) this.f2399e.get(1);
                float m57068f5 = c1351a5.m57068f();
                float m57068f6 = c1351a6.m57068f();
                float m57080a4 = c1351a5.m57080a();
                float m57080a5 = c1351a6.m57080a();
                Interpolator m57074b3 = c1351a6.m57074b();
                if (m57074b3 != null) {
                    f = m57074b3.getInterpolation(f);
                }
                float f3 = (f - m57080a4) / (m57080a5 - m57080a4);
                InterfaceC1325F interfaceC1325F3 = this.f2400f;
                return interfaceC1325F3 == null ? m57068f5 + (f3 * (m57068f6 - m57068f5)) : ((Number) interfaceC1325F3.evaluate(f3, Float.valueOf(m57068f5), Float.valueOf(m57068f6))).floatValue();
            }
        } else {
            if (this.f2383j) {
                this.f2383j = false;
                this.f2380g = ((AbstractC1350k.C1351a) this.f2399e.get(0)).m57068f();
                float m57068f7 = ((AbstractC1350k.C1351a) this.f2399e.get(1)).m57068f();
                this.f2381h = m57068f7;
                this.f2382i = m57068f7 - this.f2380g;
            }
            Interpolator interpolator = this.f2398d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            InterfaceC1325F interfaceC1325F4 = this.f2400f;
            if (interfaceC1325F4 == null) {
                return this.f2380g + (f * this.f2382i);
            }
            mo57065d = interfaceC1325F4.evaluate(f, Float.valueOf(this.f2380g), Float.valueOf(this.f2381h));
        }
        return ((Number) mo57065d).floatValue();
    }

    @Override // com.acse.ottn.animator.p031a.C1354l
    /* renamed from: clone */
    public C1347h mo60091clone() {
        ArrayList<AbstractC1350k> arrayList = this.f2399e;
        int size = arrayList.size();
        AbstractC1350k.C1351a[] c1351aArr = new AbstractC1350k.C1351a[size];
        for (int i = 0; i < size; i++) {
            c1351aArr[i] = (AbstractC1350k.C1351a) arrayList.get(i).mo60092clone();
        }
        return new C1347h(c1351aArr);
    }
}
