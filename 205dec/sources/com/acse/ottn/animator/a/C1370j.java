package com.acse.ottn.animator.a;

import android.view.animation.Interpolator;
import com.acse.ottn.animator.a.AbstractC1371k;
import java.util.ArrayList;

/* renamed from: com.acse.ottn.animator.a.j  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C1370j extends C1372l {

    /* renamed from: g  reason: collision with root package name */
    private int f4931g;

    /* renamed from: h  reason: collision with root package name */
    private int f4932h;

    /* renamed from: i  reason: collision with root package name */
    private int f4933i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4934j;

    public C1370j(AbstractC1371k.b... bVarArr) {
        super(bVarArr);
        this.f4934j = true;
    }

    @Override // com.acse.ottn.animator.a.C1372l
    public Object a(float f4) {
        return Integer.valueOf(b(f4));
    }

    public int b(float f4) {
        Object d4;
        int i4 = this.f4942a;
        if (i4 != 2) {
            if (f4 > 0.0f) {
                if (f4 < 1.0f) {
                    AbstractC1371k.b bVar = (AbstractC1371k.b) this.f4946e.get(0);
                    int i5 = 1;
                    while (true) {
                        int i6 = this.f4942a;
                        if (i5 >= i6) {
                            d4 = this.f4946e.get(i6 - 1).d();
                            break;
                        }
                        AbstractC1371k.b bVar2 = (AbstractC1371k.b) this.f4946e.get(i5);
                        if (f4 < bVar2.a()) {
                            Interpolator b4 = bVar2.b();
                            if (b4 != null) {
                                f4 = b4.getInterpolation(f4);
                            }
                            float a4 = (f4 - bVar.a()) / (bVar2.a() - bVar.a());
                            int f5 = bVar.f();
                            int f6 = bVar2.f();
                            F f7 = this.f4947f;
                            return f7 == null ? f5 + ((int) (a4 * (f6 - f5))) : ((Number) f7.evaluate(a4, Integer.valueOf(f5), Integer.valueOf(f6))).intValue();
                        }
                        i5++;
                        bVar = bVar2;
                    }
                } else {
                    AbstractC1371k.b bVar3 = (AbstractC1371k.b) this.f4946e.get(i4 - 2);
                    AbstractC1371k.b bVar4 = (AbstractC1371k.b) this.f4946e.get(this.f4942a - 1);
                    int f8 = bVar3.f();
                    int f9 = bVar4.f();
                    float a5 = bVar3.a();
                    float a6 = bVar4.a();
                    Interpolator b5 = bVar4.b();
                    if (b5 != null) {
                        f4 = b5.getInterpolation(f4);
                    }
                    float f10 = (f4 - a5) / (a6 - a5);
                    F f11 = this.f4947f;
                    return f11 == null ? f8 + ((int) (f10 * (f9 - f8))) : ((Number) f11.evaluate(f10, Integer.valueOf(f8), Integer.valueOf(f9))).intValue();
                }
            } else {
                AbstractC1371k.b bVar5 = (AbstractC1371k.b) this.f4946e.get(0);
                AbstractC1371k.b bVar6 = (AbstractC1371k.b) this.f4946e.get(1);
                int f12 = bVar5.f();
                int f13 = bVar6.f();
                float a7 = bVar5.a();
                float a8 = bVar6.a();
                Interpolator b6 = bVar6.b();
                if (b6 != null) {
                    f4 = b6.getInterpolation(f4);
                }
                float f14 = (f4 - a7) / (a8 - a7);
                F f15 = this.f4947f;
                return f15 == null ? f12 + ((int) (f14 * (f13 - f12))) : ((Number) f15.evaluate(f14, Integer.valueOf(f12), Integer.valueOf(f13))).intValue();
            }
        } else {
            if (this.f4934j) {
                this.f4934j = false;
                this.f4931g = ((AbstractC1371k.b) this.f4946e.get(0)).f();
                int f16 = ((AbstractC1371k.b) this.f4946e.get(1)).f();
                this.f4932h = f16;
                this.f4933i = f16 - this.f4931g;
            }
            Interpolator interpolator = this.f4945d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            F f17 = this.f4947f;
            if (f17 == null) {
                return this.f4931g + ((int) (f4 * this.f4933i));
            }
            d4 = f17.evaluate(f4, Integer.valueOf(this.f4931g), Integer.valueOf(this.f4932h));
        }
        return ((Number) d4).intValue();
    }

    @Override // com.acse.ottn.animator.a.C1372l
    /* renamed from: clone */
    public C1370j mo12clone() {
        ArrayList<AbstractC1371k> arrayList = this.f4946e;
        int size = arrayList.size();
        AbstractC1371k.b[] bVarArr = new AbstractC1371k.b[size];
        for (int i4 = 0; i4 < size; i4++) {
            bVarArr[i4] = (AbstractC1371k.b) arrayList.get(i4).mo13clone();
        }
        return new C1370j(bVarArr);
    }
}
