package com.acse.ottn.animator.p031a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.p031a.AbstractC1350k;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.animator.a.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1349j extends C1354l {

    /* renamed from: g */
    private int f2384g;

    /* renamed from: h */
    private int f2385h;

    /* renamed from: i */
    private int f2386i;

    /* renamed from: j */
    private boolean f2387j;

    public C1349j(AbstractC1350k.C1352b... c1352bArr) {
        super(c1352bArr);
        this.f2387j = true;
    }

    @Override // com.acse.ottn.animator.p031a.C1354l
    /* renamed from: a */
    public Object mo57064a(float f) {
        return Integer.valueOf(m57081b(f));
    }

    /* renamed from: b */
    public int m57081b(float f) {
        Object mo57065d;
        int i = this.f2395a;
        if (i != 2) {
            if (f > 0.0f) {
                if (f < 1.0f) {
                    AbstractC1350k.C1352b c1352b = (AbstractC1350k.C1352b) this.f2399e.get(0);
                    int i2 = 1;
                    while (true) {
                        int i3 = this.f2395a;
                        if (i2 >= i3) {
                            mo57065d = this.f2399e.get(i3 - 1).mo57065d();
                            break;
                        }
                        AbstractC1350k.C1352b c1352b2 = (AbstractC1350k.C1352b) this.f2399e.get(i2);
                        if (f < c1352b2.m57080a()) {
                            Interpolator m57074b = c1352b2.m57074b();
                            if (m57074b != null) {
                                f = m57074b.getInterpolation(f);
                            }
                            float m57080a = (f - c1352b.m57080a()) / (c1352b2.m57080a() - c1352b.m57080a());
                            int m57067f = c1352b.m57067f();
                            int m57067f2 = c1352b2.m57067f();
                            InterfaceC1325F interfaceC1325F = this.f2400f;
                            return interfaceC1325F == null ? m57067f + ((int) (m57080a * (m57067f2 - m57067f))) : ((Number) interfaceC1325F.evaluate(m57080a, Integer.valueOf(m57067f), Integer.valueOf(m57067f2))).intValue();
                        }
                        i2++;
                        c1352b = c1352b2;
                    }
                } else {
                    AbstractC1350k.C1352b c1352b3 = (AbstractC1350k.C1352b) this.f2399e.get(i - 2);
                    AbstractC1350k.C1352b c1352b4 = (AbstractC1350k.C1352b) this.f2399e.get(this.f2395a - 1);
                    int m57067f3 = c1352b3.m57067f();
                    int m57067f4 = c1352b4.m57067f();
                    float m57080a2 = c1352b3.m57080a();
                    float m57080a3 = c1352b4.m57080a();
                    Interpolator m57074b2 = c1352b4.m57074b();
                    if (m57074b2 != null) {
                        f = m57074b2.getInterpolation(f);
                    }
                    float f2 = (f - m57080a2) / (m57080a3 - m57080a2);
                    InterfaceC1325F interfaceC1325F2 = this.f2400f;
                    return interfaceC1325F2 == null ? m57067f3 + ((int) (f2 * (m57067f4 - m57067f3))) : ((Number) interfaceC1325F2.evaluate(f2, Integer.valueOf(m57067f3), Integer.valueOf(m57067f4))).intValue();
                }
            } else {
                AbstractC1350k.C1352b c1352b5 = (AbstractC1350k.C1352b) this.f2399e.get(0);
                AbstractC1350k.C1352b c1352b6 = (AbstractC1350k.C1352b) this.f2399e.get(1);
                int m57067f5 = c1352b5.m57067f();
                int m57067f6 = c1352b6.m57067f();
                float m57080a4 = c1352b5.m57080a();
                float m57080a5 = c1352b6.m57080a();
                Interpolator m57074b3 = c1352b6.m57074b();
                if (m57074b3 != null) {
                    f = m57074b3.getInterpolation(f);
                }
                float f3 = (f - m57080a4) / (m57080a5 - m57080a4);
                InterfaceC1325F interfaceC1325F3 = this.f2400f;
                return interfaceC1325F3 == null ? m57067f5 + ((int) (f3 * (m57067f6 - m57067f5))) : ((Number) interfaceC1325F3.evaluate(f3, Integer.valueOf(m57067f5), Integer.valueOf(m57067f6))).intValue();
            }
        } else {
            if (this.f2387j) {
                this.f2387j = false;
                this.f2384g = ((AbstractC1350k.C1352b) this.f2399e.get(0)).m57067f();
                int m57067f7 = ((AbstractC1350k.C1352b) this.f2399e.get(1)).m57067f();
                this.f2385h = m57067f7;
                this.f2386i = m57067f7 - this.f2384g;
            }
            Interpolator interpolator = this.f2398d;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            InterfaceC1325F interfaceC1325F4 = this.f2400f;
            if (interfaceC1325F4 == null) {
                return this.f2384g + ((int) (f * this.f2386i));
            }
            mo57065d = interfaceC1325F4.evaluate(f, Integer.valueOf(this.f2384g), Integer.valueOf(this.f2385h));
        }
        return ((Number) mo57065d).intValue();
    }

    @Override // com.acse.ottn.animator.p031a.C1354l
    /* renamed from: clone */
    public C1349j mo60091clone() {
        ArrayList<AbstractC1350k> arrayList = this.f2399e;
        int size = arrayList.size();
        AbstractC1350k.C1352b[] c1352bArr = new AbstractC1350k.C1352b[size];
        for (int i = 0; i < size; i++) {
            c1352bArr[i] = (AbstractC1350k.C1352b) arrayList.get(i).mo60092clone();
        }
        return new C1349j(c1352bArr);
    }
}
