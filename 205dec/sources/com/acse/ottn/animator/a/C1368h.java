package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1371k;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.h  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1368h extends C1372l {

    /* renamed from: g  reason: collision with root package name */
    private float f4927g;

    /* renamed from: h  reason: collision with root package name */
    private float f4928h;

    /* renamed from: i  reason: collision with root package name */
    private float f4929i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4930j;

    public C1368h(AbstractC1371k.a... aVarArr) {
        super(aVarArr);
        this.f4930j = true;
    }

    @Override // com.acse.ottn.animator.a.C1372l
    public Object a(float f4) {
        return Float.valueOf(b(f4));
    }

    public float b(float f4) {
        Object d4;
        int i4 = this.f4942a;
        if (i4 != 2) {
            if (f4 > 0.0f) {
                if (f4 < 1.0f) {
                    AbstractC1371k.a aVar = (AbstractC1371k.a) this.f4946e.get(0);
                    int i5 = 1;
                    while (true) {
                        int i6 = this.f4942a;
                        if (i5 >= i6) {
                            d4 = this.f4946e.get(i6 - 1).d();
                            break;
                        }
                        AbstractC1371k.a aVar2 = (AbstractC1371k.a) this.f4946e.get(i5);
                        if (f4 < aVar2.a()) {
                            Interpolator b4 = aVar2.b();
                            if (b4 != null) {
                                f4 = b4.getInterpolation(f4);
                            }
                            float a4 = (f4 - aVar.a()) / (aVar2.a() - aVar.a());
                            float f5 = aVar.f();
                            float f6 = aVar2.f();
                            F f7 = this.f4947f;
                            return f7 == null ? f5 + (a4 * (f6 - f5)) : ((Number) f7.evaluate(a4, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
                        }
                        i5++;
                        aVar = aVar2;
                    }
                } else {
                    AbstractC1371k.a aVar3 = (AbstractC1371k.a) this.f4946e.get(i4 - 2);
                    AbstractC1371k.a aVar4 = (AbstractC1371k.a) this.f4946e.get(this.f4942a - 1);
                    float f8 = aVar3.f();
                    float f9 = aVar4.f();
                    float a5 = aVar3.a();
                    float a6 = aVar4.a();
                    Interpolator b5 = aVar4.b();
                    if (b5 != null) {
                        f4 = b5.getInterpolation(f4);
                    }
                    float f10 = (f4 - a5) / (a6 - a5);
                    F f11 = this.f4947f;
                    return f11 == null ? f8 + (f10 * (f9 - f8)) : ((Number) f11.evaluate(f10, Float.valueOf(f8), Float.valueOf(f9))).floatValue();
                }
            } else {
                AbstractC1371k.a aVar5 = (AbstractC1371k.a) this.f4946e.get(0);
                AbstractC1371k.a aVar6 = (AbstractC1371k.a) this.f4946e.get(1);
                float f12 = aVar5.f();
                float f13 = aVar6.f();
                float a7 = aVar5.a();
                float a8 = aVar6.a();
                Interpolator b6 = aVar6.b();
                if (b6 != null) {
                    f4 = b6.getInterpolation(f4);
                }
                float f14 = (f4 - a7) / (a8 - a7);
                F f15 = this.f4947f;
                return f15 == null ? f12 + (f14 * (f13 - f12)) : ((Number) f15.evaluate(f14, Float.valueOf(f12), Float.valueOf(f13))).floatValue();
            }
        } else {
            if (this.f4930j) {
                this.f4930j = false;
                this.f4927g = ((AbstractC1371k.a) this.f4946e.get(0)).f();
                float f16 = ((AbstractC1371k.a) this.f4946e.get(1)).f();
                this.f4928h = f16;
                this.f4929i = f16 - this.f4927g;
            }
            Interpolator interpolator = this.f4945d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            F f17 = this.f4947f;
            if (f17 == null) {
                return this.f4927g + (f4 * this.f4929i);
            }
            d4 = f17.evaluate(f4, Float.valueOf(this.f4927g), Float.valueOf(this.f4928h));
        }
        return ((Number) d4).floatValue();
    }

    @Override // com.acse.ottn.animator.a.C1372l
    /* renamed from: clone */
    public C1368h mo12clone() {
        ArrayList<AbstractC1371k> arrayList = this.f4946e;
        int size = arrayList.size();
        AbstractC1371k.a[] aVarArr = new AbstractC1371k.a[size];
        for (int i4 = 0; i4 < size; i4++) {
            aVarArr[i4] = (AbstractC1371k.a) arrayList.get(i4).mo13clone();
        }
        return new C1368h(aVarArr);
    }
}
